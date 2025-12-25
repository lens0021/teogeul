package io.github.lens0021.teogeul.KOKR

import java.util.EmptyStackException
import java.util.Stack

class HangulEngine {
    companion object {
        const val INPUT_NON_HANGUL = 0x0000

        const val INPUT_CHO3 = 0x1011
        const val INPUT_JUNG3 = 0x1012
        const val INPUT_JONG3 = 0x1013

        const val INPUT_CHO2 = 0x1021
        const val INPUT_JUNG2 = 0x1022
        const val INPUT_JONG2 = 0x1023

        const val VIRTUAL_NON_HANGUL = 0
        const val VIRTUAL_CHO = 1
        const val VIRTUAL_JUNG = 2
        const val VIRTUAL_JONG = 3

        @JvmField
        val CHO_TABLE = intArrayOf(
            'ㄱ'.code, 'ㄲ'.code, 'ㄴ'.code, 'ㄷ'.code, 'ㄸ'.code,
            'ㄹ'.code, 'ㅁ'.code, 'ㅂ'.code, 'ㅃ'.code, 'ㅅ'.code,
            'ㅆ'.code, 'ㅇ'.code, 'ㅈ'.code, 'ㅉ'.code, 'ㅊ'.code,
            'ㅋ'.code, 'ㅌ'.code, 'ㅍ'.code, 'ㅎ'.code
        )

        @JvmField
        val JUNG_TABLE = intArrayOf(
            'ㅏ'.code, 'ㅐ'.code, 'ㅑ'.code, 'ㅒ'.code, 'ㅓ'.code,
            'ㅔ'.code, 'ㅕ'.code, 'ㅖ'.code, 'ㅗ'.code, 'ㅘ'.code,
            'ㅙ'.code, 'ㅚ'.code, 'ㅛ'.code, 'ㅜ'.code, 'ㅝ'.code,
            'ㅞ'.code, 'ㅟ'.code, 'ㅠ'.code, 'ㅡ'.code, 'ㅢ'.code,
            'ㅣ'.code, 'ㆍ'.code, 'ㆎ'.code, 'ᆢ'.code
        )

        @JvmField
        val JONG_TABLE = intArrayOf(
            ' '.code, 'ㄱ'.code, 'ㄲ'.code, 'ㄳ'.code, 'ㄴ'.code,
            'ㄵ'.code, 'ㄶ'.code, 'ㄷ'.code, 'ㄹ'.code, 'ㄺ'.code,
            'ㄻ'.code, 'ㄼ'.code, 'ㄽ'.code, 'ㄾ'.code, 'ㄿ'.code,
            'ㅀ'.code, 'ㅁ'.code, 'ㅂ'.code, 'ㅄ'.code, 'ㅅ'.code,
            'ㅆ'.code, 'ㅇ'.code, 'ㅈ'.code, 'ㅊ'.code, 'ㅋ'.code,
            'ㅌ'.code, 'ㅍ'.code, 'ㅎ'.code
        )

        @JvmField
        val CHO_CONVERT = intArrayOf(
            0x1100, 0x1101, 0x0000, 0x1102, 0x0000, 0x115d, 0x1103,
            0x1104, 0x1105, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x111a, 0x1106, 0x1107, 0x1108, 0x0000, 0x1109, 0x110a, 0x110b,
            0x110c, 0x110d, 0x110e, 0x110f, 0x1110, 0x1111, 0x1112, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x1114, 0x1115, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x111c, 0x0000,
            0x0000, 0x111d, 0x111e, 0x1120, 0x1122, 0x1123, 0x1127, 0x1129,
            0x112b, 0x112c, 0x112d, 0x112e, 0x112f, 0x1132, 0x1136, 0x1140,
            0x1147, 0x114c, 0x0000, 0x0000, 0x1157, 0x1158, 0x1159
        )

        @JvmField
        val JONG_CONVERT = intArrayOf(
            0x11a8, 0x11a9, 0x11aa, 0x11ab, 0x11ac, 0x11ad, 0x11ae,
            0x0000, 0x11af, 0x11b0, 0x11b1, 0x11b2, 0x11b3, 0x11b4, 0x11b5,
            0x11b6, 0x11b7, 0x11b8, 0x0000, 0x11b9, 0x11ba, 0x11bb, 0x11bc,
            0x11bd, 0x0000, 0x11be, 0x11bf, 0x11c0, 0x11c1, 0x11c2, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x11c6, 0x11c7,
            0x11c8, 0x11cc, 0x11ce, 0x11d3, 0x11d7, 0x11d9, 0x11dc, 0x11dd,
            0x11df, 0x11e2, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
            0x11e6, 0x0000, 0x11e7, 0x0000, 0x11e8, 0x11ea, 0x0000, 0x11eb,
            0x0000, 0x11f0, 0x11f1, 0x11f2, 0x11f4, 0x0000, 0x11f9
        )

        @JvmField
        val TRAD_JUNG_CONVERT = intArrayOf(
            0x1184, 0x1185, 0x1188, 0x1191, 0x1192, 0x1194, 0x119e, 0x11a1
        )
    }

    var moachigi: Boolean = false
    var fullMoachigi: Boolean = false
    var firstMidEnd: Boolean = false

    var listener: HangulEngineListener? = null

    var cho: Int = -1
    var jung: Int = -1
    var jong: Int = -1
    var last: Int = 0
    var beforeJong: Int = 0
    var composing: String = ""

    var lastInputType: Int = 0

    private class History(
        val cho: Int,
        val jung: Int,
        val jong: Int,
        val last: Int,
        val beforeJong: Int,
        val composing: String,
        val lastInputType: Int
    )

    private val histories: Stack<History> = Stack()

    private var jamoTableData: Array<IntArray>? = null
    private var jamoSetData: Array<Array<IntArray>>? = null
    private var currentJamoTable: Array<IntArray>? = null
    private var combinationTableData: Array<IntArray>? = null

    var jamoTable: Array<IntArray>?
        get() = jamoTableData
        set(value) {
            jamoTableData = value
            jamoSetData = null
            currentJamoTable = null
        }

    var jamoSet: Array<Array<IntArray>>?
        get() = jamoSetData
        set(value) {
            jamoSetData = value
            jamoTableData = null
            changeJamoTable(lastInputType)
        }

    constructor() {
        resetComposition()
    }

    constructor(moachigi: Boolean) : this() {
        this.moachigi = moachigi
    }

    fun backspace(): Boolean {
        try {
            val history = histories.pop()
            cho = history.cho
            jung = history.jung
            jong = history.jong
            last = history.last
            beforeJong = history.beforeJong
            composing = history.composing
            lastInputType = history.lastInputType
        } catch (e: EmptyStackException) {
            lastInputType = 0
            if (composing.isEmpty()) {
                return false
            } else {
                composing = ""
            }
        }
        listener?.onEvent(SetComposingEvent(composing))
        changeJamoTable(if (lastInputType and 0x1010 != 0) lastInputType and 0x000f else 0)
        return true
    }

    fun inputCode(code: Int, shift: Int): Int {
        val table = when {
            jamoTableData != null -> jamoTableData
            jamoSetData != null -> currentJamoTable
            else -> null
        } ?: return -1
        for (item in table) {
            if (item[0] == code) {
                return if (shift == 0) item[1] else item[2]
            }
        }
        return -1
    }

    fun inputJamo(code: Int): Int {
        if (composing.isEmpty()) {
            histories.clear()
        } else {
            histories.push(History(cho, jung, jong, last, beforeJong, composing, lastInputType))
        }

        val preserveState = (code and 0xffff0000.toInt()) shr 16 == 1
        val filteredCode = code and 0xffff
        val result: Int
        if (filteredCode >= 0x1100 && filteredCode <= 0x115f) {
            var choCode = code - 0x1100
            if (!fullMoachigi && !moachigi && !isCho(last) && !isJung(last)) {
                resetComposition()
            }
            if (isCho(last) || fullMoachigi && this.cho != -1) {
                val source = this.cho + 0x1100
                val combined = getCombination(source, code)
                if (combined != -1) {
                    choCode = combined - 0x1100
                } else {
                    resetComposition()
                }
            } else if (this.cho != -1) {
                resetComposition()
            }
            this.cho = choCode
            result = if (lastInputType == 0) {
                INPUT_CHO3
            } else if (preserveState) {
                lastInputType
            } else {
                INPUT_CHO3
            }
            last = code
        } else if (filteredCode >= 0x1161 && filteredCode <= 0x11a7) {
            var jungCode = code - 0x1161
            if (!moachigi && !isCho(last) && !isJung(last)) {
                resetComposition()
            }
            if (isJung(last) || fullMoachigi && this.jung != -1) {
                val source = this.jung + 0x1161
                val combined = getCombination(source, code)
                if (combined != -1) {
                    jungCode = combined - 0x1161
                    this.jung = jungCode
                } else {
                    resetComposition()
                    this.jung = jungCode
                }
            } else {
                if (this.jung != -1) {
                    resetComposition()
                }
                this.jung = jungCode
            }
            result = if (lastInputType == 0) {
                INPUT_JUNG3
            } else if (preserveState) {
                lastInputType
            } else {
                INPUT_JUNG3
            }
            last = code
        } else if (filteredCode >= 0x11a8 && filteredCode <= 0x11ff) {
            var jongCode = code - 0x11a7
            if (!moachigi && !isJung(last) && !isJong(last)) {
                resetComposition()
            }
            if (isJong(last) || fullMoachigi && this.jong != -1) {
                val source = this.jong + 0x11a7
                val combined = getCombination(source, code)
                if (combined != -1) {
                    this.beforeJong = jong
                    jongCode = combined - 0x11a7
                    this.jong = jongCode
                } else {
                    resetComposition()
                    this.jong = jongCode
                }
            } else {
                if (this.jong != -1) {
                    resetComposition()
                }
                this.jong = jongCode
            }
            result = if (lastInputType == 0) {
                INPUT_JONG3
            } else if (preserveState) {
                lastInputType
            } else {
                INPUT_JONG3
            }
            last = code
        } else if (filteredCode in 0x3131..0x314e || filteredCode in 0x3165..0x3186) {
            if (this.cho != -1 && this.jung != -1) {
                val jongCode = JONG_CONVERT[code - 0x3131] - 0x11a7
                if (isJong(last) && this.jong != -1) {
                    val combined = getCombination(this.jong + 0x11a7, jongCode + 0x11a7)
                    if (combined != -1) {
                        this.beforeJong = this.jong
                        this.jong = combined - 0x11a7
                        last = jongCode + 0x11a7
                    } else {
                        this.beforeJong = 0
                        resetComposition()
                        this.cho = CHO_CONVERT[code - 0x3131] - 0x1100
                        if (this.cho == -0x1100) {
                            this.cho = -1
                        }
                        last = CHO_CONVERT[code - 0x3131]
                    }
                } else {
                    if (jongCode == -0x11a7) {
                        resetComposition()
                        this.cho = CHO_CONVERT[code - 0x3131] - 0x1100
                        if (this.cho == -0x1100) {
                            this.cho = -1
                        }
                        last = CHO_CONVERT[code - 0x3131]
                    } else {
                        this.beforeJong = 0
                        this.jong = jongCode
                        last = jongCode + 0x11a7
                    }
                }
            } else {
                val choCode = CHO_CONVERT[code - 0x3131] - 0x1100
                if (isCho(last) && this.cho != -1) {
                    val combined = getCombination(this.cho + 0x1100, choCode + 0x1100)
                    if (combined != -1) {
                        this.cho = combined - 0x1100
                    } else {
                        resetComposition()
                        this.cho = choCode
                        if (this.cho == -0x1100) {
                            this.cho = -1
                        }
                    }
                } else {
                    if (!moachigi) {
                        resetComposition()
                    }
                    this.cho = choCode
                }
                last = choCode + 0x1100
                if (this.cho == -0x1100) {
                    this.cho = -1
                }
            }
            result = INPUT_CHO2
        } else if (filteredCode in 0x314f..0x3163 || filteredCode in 0x3187..0x318e) {
            if (this.jong == -1) {
                var jungCode = code - 0x314f
                if (code == 0x01318d) {
                    jungCode = 0x01119e - 0x1161
                }
                if (code in 0x3187..0x318e) {
                    jungCode = TRAD_JUNG_CONVERT[code - 0x3187] - 0x1161
                }
                if (isJung(last) && this.jung != -1) {
                    val source = if (this.jung >= 0) this.jung + 0x1161 else this.jung
                    val with = if (jungCode >= 0) jungCode + 0x1161 else jungCode
                    val combined = getCombination(source, with)
                    if (combined != -1) {
                        this.jung = combined
                        if (combined >= 0x1161) {
                            this.jung -= 0x1161
                        }
                    } else {
                        resetComposition()
                        this.jung = jungCode
                    }
                } else {
                    if (this.jung != -1) {
                        resetComposition()
                    }
                    this.jung = jungCode
                }
                last = if (jungCode >= 0) jungCode + 0x1161 else jungCode
            } else {
                var jungCode = code - 0x314f
                if (code in 0x3187..0x318e) {
                    jungCode = TRAD_JUNG_CONVERT[code - 0x3187] - 0x1161
                }
                if (code == 0x01318d) {
                    jungCode = 0x01119e - 0x1161
                }
                if (this.cho != -1) {
                    if (beforeJong != 0) {
                        this.jong = beforeJong
                        this.composing = getVisible(this.cho, this.jung, this.jong)
                        listener?.onEvent(SetComposingEvent(composing))
                        val lastLocal = this.last
                        resetComposition()
                        this.cho = convertToCho(lastLocal) - 0x1100
                        composing = getVisible(this.cho, this.jung, this.jong)
                        histories.push(History(cho, jung, jong, lastLocal, beforeJong, composing, lastInputType))
                        this.jung = jungCode
                    } else {
                        val convertedCho = convertToCho(this.jong + 0x11a7)
                        if (convertedCho > -1) {
                            this.jong = -1
                            this.composing = getVisible(this.cho, this.jung, this.jong)
                            listener?.onEvent(SetComposingEvent(composing))
                            resetComposition()
                            this.cho = convertedCho - 0x1100
                            composing = getVisible(this.cho, this.jung, this.jong)
                            histories.push(History(cho, jung, jong, last, beforeJong, composing, lastInputType))
                            this.jung = jungCode
                        }
                    }
                } else {
                    resetComposition()
                    this.jung = jungCode
                }
                last = if (jungCode >= 0) jungCode + 0x1161 else jungCode
            }
            result = INPUT_JUNG2
        } else {
            resetComposition()
            result = INPUT_NON_HANGUL
            last = code
            return result
        }

        this.composing = getVisible(this.cho, this.jung, this.jong)
        listener?.onEvent(SetComposingEvent(composing))

        lastInputType = result

        changeJamoTable(if (lastInputType and 0x1010 != 0) lastInputType and 0x000f else 0)

        return result
    }

    fun resetComposition() {
        listener?.onEvent(FinishComposingEvent())
        cho = -1
        jung = -1
        jong = -1
        composing = ""
        lastInputType = 0
        last = 0
        histories.clear()
    }

    private fun getCombination(a: Int, b: Int): Int {
        val table = combinationTableData ?: return -1
        for (item in table) {
            if (item[0] == a && item[1] == b) {
                return item[2]
            }
        }
        return -1
    }

    private class Pair(val jong: Int, val cho: Int)

    private fun getJongseongPair(jong: Int): Pair? {
        val table = combinationTableData ?: return null
        for (item in table) {
            if (item[2] == jong) {
                var resultCho = 0
                for (i in JONG_CONVERT.indices) {
                    if (JONG_CONVERT[i] == item[1]) {
                        resultCho = CHO_CONVERT[i]
                    }
                }
                return Pair(item[0], resultCho)
            }
        }
        return null
    }

    fun convertToCho(jong: Int): Int {
        for (i in JONG_CONVERT.indices) {
            if (JONG_CONVERT[i] == jong) {
                return CHO_CONVERT[i]
            }
        }
        return -1
    }

    fun combineHangul(cho: Int, jung: Int, jong: Int): Int {
        return 0xac00 + cho * 588 + jung * 28 + jong
    }

    fun getVisible(cho: Int, jung: Int, jong: Int): String {
        var localCho = cho
        var visible: String
        if (localCho > 0x12 || jung > 0x14 || jong > 0x1b) {
            visible = when {
                localCho != -1 && jung == -1 && jong == -1 -> {
                    String(charArrayOf((localCho + 0x1100).toChar()))
                }
                localCho == -1 && jung != -1 && jong == -1 -> {
                    String(charArrayOf((jung + 0x1161).toChar()))
                }
                localCho == -1 && jung == -1 && jong != -1 -> {
                    String(charArrayOf((jong + 0x11a8 - 1).toChar()))
                }
                else -> {
                    if (localCho == -1) {
                        localCho = 0x5f
                    }
                    var result = String(charArrayOf((localCho + 0x1100).toChar())) +
                        String(charArrayOf((jung + 0x1161).toChar()))
                    if (jong != -1) {
                        result += String(charArrayOf((jong + 0x11a8 - 1).toChar()))
                    }
                    result
                }
            }
        } else if (localCho != -1 && jung != -1 && jong != -1) {
            visible = combineHangul(localCho, jung, jong).toChar().toString()
        } else if (localCho != -1 && jung != -1) {
            visible = combineHangul(localCho, jung, 0).toChar().toString()
        } else if (firstMidEnd) {
            visible = when {
                localCho != -1 && jung == -1 && jong == -1 -> CHO_TABLE[localCho].toChar().toString()
                localCho == -1 && jung != -1 && jong == -1 -> JUNG_TABLE[jung].toChar().toString()
                localCho == -1 && jung == -1 && jong != -1 -> JONG_TABLE[jong].toChar().toString()
                else -> {
                    if (localCho == -1) {
                        localCho = 0x5f
                    }
                    var result = String(charArrayOf((localCho + 0x1100).toChar())) +
                        String(charArrayOf((jung + 0x1161).toChar()))
                    if (jong != -1) {
                        result += String(charArrayOf((jong + 0x11a8 - 1).toChar()))
                    }
                    result
                }
            }
        } else {
            visible = when {
                localCho != -1 -> CHO_TABLE[localCho].toChar().toString()
                jung != -1 -> JUNG_TABLE[jung].toChar().toString()
                jong != -1 -> JONG_TABLE[jong].toChar().toString()
                else -> ""
            }
        }
        return visible
    }

    fun isCho(code: Int): Boolean {
        val filtered = code and 0xffff
        return filtered in 0x1100..0x115f
    }

    fun isJung(code: Int): Boolean {
        val filtered = code and 0xffff
        return filtered in 0x1161..0x11a7
    }

    fun isJong(code: Int): Boolean {
        val filtered = code and 0xffff
        return filtered in 0x11a8..0x11ff
    }

    fun changeJamoTable(num: Int) {
        val table = jamoSetData?.getOrNull(num) ?: return
        currentJamoTable = table
    }

    fun getCombinationTable(): Array<IntArray>? {
        return combinationTableData
    }

    fun setCombinationTable(combinations: Array<IntArray>?) {
        this.combinationTableData = combinations
    }

    interface HangulEngineListener {
        fun onEvent(event: HangulEngineEvent)
    }

    abstract class HangulEngineEvent

    class FinishComposingEvent : HangulEngineEvent()

    class SetComposingEvent(val composing: String) : HangulEngineEvent()

}
