package io.github.lens0021.teogeul

class StrSegment {
    var string: String?
    var from: Int
    var to: Int

    constructor() : this(null, -1, -1)

    constructor(str: String?) : this(str, -1, -1)

    constructor(chars: CharArray) : this(String(chars), -1, -1)

    constructor(str: String?, from: Int, to: Int) {
        this.string = str
        this.from = from
        this.to = to
    }
}
