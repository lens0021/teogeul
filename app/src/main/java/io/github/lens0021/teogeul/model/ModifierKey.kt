package io.github.lens0021.teogeul.model

import io.github.lens0021.teogeul.ModifierState

open class ModifierKey : Key() {
    var state: ModifierState = ModifierState.Disabled
}
