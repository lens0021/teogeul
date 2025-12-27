package io.github.lens0021.teogeul.korean

class ComposingWord {
    private var composingWord = StringBuilder()
    private var composingChar = ""
    private var fixedWord: String? = null

    fun composeChar(composingChar: String) {
        this.composingChar = composingChar
    }

    fun commitComposingChar() {
        composingWord.append(composingChar)
        composingChar = ""
    }

    fun commitComposingWord(): String {
        commitComposingChar()
        val result = composingWord.toString()
        composingWord = StringBuilder()
        composingChar = ""
        return result
    }

    fun backspace(): Boolean =
        if (composingWord.isEmpty()) {
            false
        } else {
            composingWord.deleteCharAt(composingWord.length - 1)
            true
        }

    fun getComposingChar(): String = composingChar

    fun getComposingWord(): String = composingWord.toString()

    fun setComposingWord(composingWord: String) {
        this.composingWord = StringBuilder(composingWord)
    }

    fun getEntireWord(): String = composingWord.toString() + composingChar

    fun length(): Int = composingWord.length + if (composingChar.isEmpty()) 0 else 1

    fun getFixedWord(): String? = fixedWord

    fun setFixedWord(fixedWord: String?) {
        this.fixedWord = fixedWord
    }
}
