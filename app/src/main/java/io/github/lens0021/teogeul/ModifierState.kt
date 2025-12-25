package io.github.lens0021.teogeul

enum class ModifierState(val num: Int) {
    Disabled(0),
    Enabled(1),
    Locked(2);

    fun isEnabled(): Boolean = num > 0
}
