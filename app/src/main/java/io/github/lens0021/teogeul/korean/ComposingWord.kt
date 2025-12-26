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

    fun backspace(): Boolean {
        return if (composingWord.isEmpty()) {
            false
        } else {
            composingWord.deleteCharAt(composingWord.length - 1)
            true
        }
    }

    fun getComposingChar(): String {
        return composingChar
    }

    fun getComposingWord(): String {
        return composingWord.toString()
    }

    fun setComposingWord(composingWord: String) {
        this.composingWord = StringBuilder(composingWord)
    }

    fun getEntireWord(): String {
        return composingWord.toString() + composingChar
    }

    fun length(): Int {
        return composingWord.length + if (composingChar.isEmpty()) 0 else 1
    }

    fun getFixedWord(): String? {
        return fixedWord
    }

    fun setFixedWord(fixedWord: String?) {
        this.fixedWord = fixedWord
    }
}
