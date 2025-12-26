package io.github.lens0021.teogeul.compose

import android.util.Log
import java.util.ArrayList

class ComposingText {
    companion object {
        const val LAYER0 = 0
        const val LAYER1 = 1
        const val LAYER2 = 2
        const val MAX_LAYER = 3
    }

    protected val mStringLayer: Array<ArrayList<StrSegment>> = Array(MAX_LAYER) { ArrayList() }
    protected val mCursor: IntArray = IntArray(MAX_LAYER)

    fun debugout() {
        for (i in 0 until MAX_LAYER) {
            Log.d("Teogeul", "ComposingText[$i]")
            Log.d("Teogeul", "  cur = ${mCursor[i]}")
            var tmp = ""
            for (ss in mStringLayer[i]) {
                tmp += "(${ss.string},${ss.from},${ss.to})"
            }
            Log.d("Teogeul", "  str = $tmp")
        }
    }

    fun getStrSegment(
        layer: Int,
        pos: Int,
    ): StrSegment? {
        return try {
            val strLayer = mStringLayer[layer]
            var position = pos
            if (position < 0) {
                position = strLayer.size - 1
            }
            if (position >= strLayer.size || position < 0) {
                null
            } else {
                strLayer[position]
            }
        } catch (ex: Exception) {
            null
        }
    }

    fun toString(
        layer: Int,
        from: Int,
        to: Int,
    ): String? {
        return try {
            val buf = StringBuilder()
            val strLayer = mStringLayer[layer]
            for (i in from..to) {
                val ss = strLayer[i]
                buf.append(ss.string)
            }
            buf.toString()
        } catch (ex: Exception) {
            null
        }
    }

    fun toString(layer: Int): String? {
        return toString(layer, 0, mStringLayer[layer].size - 1)
    }

    private fun modifyUpper(
        layer: Int,
        modFrom: Int,
        modLen: Int,
        orgLen: Int,
    ) {
        if (layer >= MAX_LAYER - 1) {
            return
        }

        val uplayer = layer + 1
        val strUplayer = mStringLayer[uplayer]
        if (strUplayer.isEmpty()) {
            strUplayer.add(StrSegment(toString(layer), 0, mStringLayer[layer].size - 1))
            modifyUpper(uplayer, 0, 1, 0)
            return
        }

        val modTo = modFrom + if (modLen == 0) 0 else modLen - 1
        val orgTo = modFrom + if (orgLen == 0) 0 else orgLen - 1
        val last = strUplayer[strUplayer.size - 1]
        if (last.to < modFrom) {
            last.to = modTo
            last.string = toString(layer, last.from, last.to)
            modifyUpper(uplayer, strUplayer.size - 1, 1, 1)
            return
        }

        var uplayerModFrom = -1
        var uplayerOrgTo = -1
        for (i in strUplayer.indices) {
            val ss = strUplayer[i]
            if (ss.from > modFrom) {
                if (ss.to <= orgTo) {
                    if (uplayerModFrom < 0) {
                        uplayerModFrom = i
                    }
                    uplayerOrgTo = i
                } else {
                    uplayerOrgTo = i
                    break
                }
            } else {
                if (orgLen == 0 && ss.from == modFrom) {
                    uplayerModFrom = i - 1
                    uplayerOrgTo = i - 1
                    break
                } else {
                    uplayerModFrom = i
                    uplayerOrgTo = i
                    if (ss.to >= orgTo) {
                        break
                    }
                }
            }
        }

        val diff = modLen - orgLen
        if (uplayerModFrom >= 0) {
            var ss = strUplayer[uplayerModFrom]
            var lastTo = ss.to
            val next = uplayerModFrom + 1
            for (i in next..uplayerOrgTo) {
                ss = strUplayer[next]
                if (lastTo > ss.to) {
                    lastTo = ss.to
                }
                strUplayer.removeAt(next)
            }
            ss.to = if (lastTo < modTo) modTo else lastTo + diff
            ss.string = toString(layer, ss.from, ss.to)
            for (i in next until strUplayer.size) {
                ss = strUplayer[i]
                ss.from += diff
                ss.to += diff
            }
            modifyUpper(uplayer, uplayerModFrom, 1, uplayerOrgTo - uplayerModFrom + 1)
        } else {
            val ss = StrSegment(toString(layer, modFrom, modTo), modFrom, modTo)
            strUplayer.add(0, ss)
            for (i in 1 until strUplayer.size) {
                val segment = strUplayer[i]
                segment.from += diff
                segment.to += diff
            }
            modifyUpper(uplayer, 0, 1, 0)
        }
    }

    fun insertStrSegment(
        layer: Int,
        str: StrSegment,
    ) {
        val cursor = mCursor[layer]
        mStringLayer[layer].add(cursor, str)
        modifyUpper(layer, cursor, 1, 0)
        setCursor(layer, cursor + 1)
    }

    fun insertStrSegment(
        layer1: Int,
        layer2: Int,
        str: StrSegment,
    ) {
        mStringLayer[layer1].add(mCursor[layer1], str)
        mCursor[layer1]++

        for (i in layer1 + 1..layer2) {
            val pos = mCursor[i - 1] - 1
            val tmp = StrSegment(str.string, pos, pos)
            val strLayer = mStringLayer[i]
            strLayer.add(mCursor[i], tmp)
            mCursor[i]++
            for (j in mCursor[i] until strLayer.size) {
                val ss = strLayer[j]
                ss.from++
                ss.to++
            }
        }
        val cursor = mCursor[layer2]
        modifyUpper(layer2, cursor - 1, 1, 0)
        setCursor(layer2, cursor)
    }

    protected fun replaceStrSegment0(
        layer: Int,
        str: Array<StrSegment>,
        from: Int,
        to: Int,
    ) {
        val strLayer = mStringLayer[layer]

        var fromPos = from
        var toPos = to
        if (fromPos < 0 || fromPos > strLayer.size) {
            fromPos = strLayer.size
        }
        if (toPos < 0 || toPos > strLayer.size) {
            toPos = strLayer.size
        }
        for (i in fromPos..toPos) {
            strLayer.removeAt(fromPos)
        }
        for (i in str.indices.reversed()) {
            strLayer.add(fromPos, str[i])
        }

        modifyUpper(layer, fromPos, str.size, toPos - fromPos + 1)
    }

    fun replaceStrSegment(
        layer: Int,
        str: Array<StrSegment>,
        num: Int,
    ) {
        val cursor = mCursor[layer]
        replaceStrSegment0(layer, str, cursor - num, cursor - 1)
        setCursor(layer, cursor + str.size - num)
    }

    fun replaceStrSegment(
        layer: Int,
        str: Array<StrSegment>,
    ) {
        val cursor = mCursor[layer]
        replaceStrSegment0(layer, str, cursor - 1, cursor - 1)
        setCursor(layer, cursor + str.size - 1)
    }

    fun deleteStrSegment(
        layer: Int,
        from: Int,
        to: Int,
    ) {
        val fromL = intArrayOf(-1, -1, -1)
        val toL = intArrayOf(-1, -1, -1)

        val strLayer2 = mStringLayer[2]
        val strLayer1 = mStringLayer[1]

        if (layer == 2) {
            fromL[2] = from
            toL[2] = to
            fromL[1] = strLayer2[from].from
            toL[1] = strLayer2[to].to
            fromL[0] = strLayer1[fromL[1]].from
            toL[0] = strLayer1[toL[1]].to
        } else if (layer == 1) {
            fromL[1] = from
            toL[1] = to
            fromL[0] = strLayer1[from].from
            toL[0] = strLayer1[to].to
        } else {
            fromL[0] = from
            toL[0] = to
        }

        var diff = to - from + 1
        for (lv in 0 until MAX_LAYER) {
            if (fromL[lv] >= 0) {
                deleteStrSegment0(lv, fromL[lv], toL[lv], diff)
            } else {
                var boundaryFrom = -1
                var boundaryTo = -1
                val strLayer = mStringLayer[lv]
                for (i in strLayer.indices) {
                    val ss = strLayer[i]
                    if ((ss.from >= fromL[lv - 1] && ss.from <= toL[lv - 1]) ||
                        (ss.to >= fromL[lv - 1] && ss.to <= toL[lv - 1])
                    ) {
                        if (fromL[lv] < 0) {
                            fromL[lv] = i
                            boundaryFrom = ss.from
                        }
                        toL[lv] = i
                        boundaryTo = ss.to
                    } else if (ss.from <= fromL[lv - 1] && ss.to >= toL[lv - 1]) {
                        boundaryFrom = ss.from
                        boundaryTo = ss.to
                        fromL[lv] = i
                        toL[lv] = i
                        break
                    } else if (ss.from > toL[lv - 1]) {
                        break
                    }
                }
                if (boundaryFrom != fromL[lv - 1] || boundaryTo != toL[lv - 1]) {
                    deleteStrSegment0(lv, fromL[lv] + 1, toL[lv], diff)
                    boundaryTo -= diff
                    val tmp = arrayOf(StrSegment(toString(lv - 1), boundaryFrom, boundaryTo))
                    replaceStrSegment0(lv, tmp, fromL[lv], fromL[lv])
                    return
                } else {
                    deleteStrSegment0(lv, fromL[lv], toL[lv], diff)
                }
            }
            diff = toL[lv] - fromL[lv] + 1
        }
    }

    private fun deleteStrSegment0(
        layer: Int,
        from: Int,
        to: Int,
        diff: Int,
    ) {
        val strLayer = mStringLayer[layer]
        if (diff != 0) {
            for (i in to + 1 until strLayer.size) {
                val ss = strLayer[i]
                ss.from -= diff
                ss.to -= diff
            }
        }
        for (i in from..to) {
            strLayer.removeAt(from)
        }
    }

    fun delete(
        layer: Int,
        rightside: Boolean,
    ): Int {
        val cursor = mCursor[layer]
        val strLayer = mStringLayer[layer]

        if (!rightside && cursor > 0) {
            deleteStrSegment(layer, cursor - 1, cursor - 1)
            setCursor(layer, cursor - 1)
        } else if (rightside && cursor < strLayer.size) {
            deleteStrSegment(layer, cursor, cursor)
            setCursor(layer, cursor)
        }
        return strLayer.size
    }

    fun getStringLayer(layer: Int): ArrayList<StrSegment>? {
        return try {
            mStringLayer[layer]
        } catch (ex: Exception) {
            null
        }
    }

    private fun included(
        layer: Int,
        pos: Int,
    ): Int {
        if (pos == 0) {
            return 0
        }
        val uplayer = layer + 1
        val strLayer = mStringLayer[uplayer]
        for (i in strLayer.indices) {
            val ss = strLayer[i]
            if (ss.from <= pos && pos <= ss.to) {
                return i
            }
        }
        return strLayer.size
    }

    fun setCursor(
        layer: Int,
        pos: Int,
    ): Int {
        var position = pos
        if (position > mStringLayer[layer].size) {
            position = mStringLayer[layer].size
        }
        if (position < 0) {
            position = 0
        }
        if (layer == 0) {
            mCursor[0] = position
            mCursor[1] = included(0, position)
            mCursor[2] = included(1, mCursor[1])
        } else if (layer == 1) {
            mCursor[2] = included(1, position)
            mCursor[1] = position
            mCursor[0] = if (position > 0) mStringLayer[1][position - 1].to + 1 else 0
        } else {
            mCursor[2] = position
            mCursor[1] = if (position > 0) mStringLayer[2][position - 1].to + 1 else 0
            mCursor[0] = if (mCursor[1] > 0) mStringLayer[1][mCursor[1] - 1].to + 1 else 0
        }
        return position
    }

    fun moveCursor(
        layer: Int,
        diff: Int,
    ): Int {
        val c = mCursor[layer] + diff
        return setCursor(layer, c)
    }

    fun getCursor(layer: Int): Int {
        return mCursor[layer]
    }

    fun size(layer: Int): Int {
        return mStringLayer[layer].size
    }

    fun clear() {
        for (i in 0 until MAX_LAYER) {
            mStringLayer[i].clear()
            mCursor[i] = 0
        }
    }
}
