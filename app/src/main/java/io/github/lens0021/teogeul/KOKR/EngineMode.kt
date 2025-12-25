package io.github.lens0021.teogeul.KOKR

import io.github.lens0021.teogeul.KOKR.layout.LayoutAlphabet
import io.github.lens0021.teogeul.KOKR.layout.LayoutDev
import io.github.lens0021.teogeul.KOKR.layout.LayoutDubul
import io.github.lens0021.teogeul.KOKR.layout.LayoutGongSebul
import io.github.lens0021.teogeul.KOKR.layout.LayoutMoachigiSebul
import io.github.lens0021.teogeul.KOKR.layout.LayoutShinSebul

private const val LANG_EN_CODE = 0
private const val LANG_KO_CODE = 3

enum class EngineMode(
    val properties: Properties,
    val layout: Array<IntArray>?,
    val jamoset: Array<Array<IntArray>>?,
    val combination: Array<IntArray>?,
    val addStroke: Array<IntArray>?,
    vararg prefValues: String,
) {
    DIRECT(Properties(), null, null, null, null),

    SEBUL_390(
        Properties(),
        LayoutGongSebul.JAMO_SEBUL_390,
        null,
        LayoutGongSebul.COMB_SEBULSIK,
        null,
        "keyboard_sebul_390",
    ),
    SEBUL_391(
        Properties(),
        LayoutGongSebul.JAMO_SEBUL_391,
        null,
        LayoutGongSebul.COMB_SEBULSIK,
        null,
        "keyboard_sebul_391",
    ),
    SEBUL_DANMOEUM(
        Properties(),
        LayoutGongSebul.JAMO_SEBUL_DANMOEUM,
        null,
        LayoutGongSebul.COMB_SEBUL_DANMOEUM,
        null,
        "keyboard_sebul_danmoeum",
    ),
    DUBULSIK(
        Properties(),
        LayoutDubul.JAMO_DUBUL_STANDARD,
        null,
        LayoutDubul.COMB_DUBUL_STANDARD,
        null,
        "keyboard_dubul_standard",
    ),
    DUBULSIK_NK(
        Properties(),
        LayoutDubul.JAMO_DUBUL_NK,
        null,
        LayoutDubul.COMB_DUBUL_STANDARD,
        null,
        "keyboard_dubul_nk",
    ),

    SEBUL_SUN_2014(
        Properties(),
        LayoutGongSebul.JAMO_SEBUL_SUN_2014,
        null,
        LayoutGongSebul.COMB_SEBUL_SUN_2014,
        null,
        "keyboard_sebul_sun_2014",
    ),
    SEBUL_3_2015M(
        Properties(),
        null,
        LayoutShinSebul.JAMOSET_SEBUL_3_2015M,
        LayoutShinSebul.COMB_SEBUL_3_2015,
        null,
        "keyboard_sebul_3_2015m",
    ),
    SEBUL_3_2015(
        Properties(),
        null,
        LayoutShinSebul.JAMOSET_SEBUL_3_2015,
        LayoutShinSebul.COMB_SEBUL_3_2015,
        null,
        "keyboard_sebul_3_2015",
    ),
    SEBUL_3_P3(
        Properties(),
        null,
        LayoutShinSebul.JAMOSET_SEBUL_3_P3,
        LayoutShinSebul.COMB_SEBUL_3_P3,
        null,
        "keyboard_sebul_3_p3",
    ),
    SEBUL_SHIN_ORIGINAL(
        Properties(),
        null,
        LayoutShinSebul.JAMOSET_SHIN_ORIGINAL,
        LayoutShinSebul.COMB_SEBUL_SHIN_ORIGINAL,
        null,
        "keyboard_sebul_shin_original",
    ),
    SEBUL_SHIN_EDIT(
        Properties(),
        null,
        LayoutShinSebul.JAMOSET_SHIN_EDIT,
        LayoutShinSebul.COMB_SEBUL_SHIN_ORIGINAL,
        null,
        "keyboard_sebul_shin_edit",
    ),
    SEBUL_SHIN_M(
        Properties(),
        null,
        LayoutShinSebul.JAMOSET_SHIN_M,
        LayoutShinSebul.COMB_SEBUL_SHIN_ORIGINAL,
        null,
        "keyboard_sebul_shin_m",
    ),
    SEBUL_SHIN_P2(
        Properties(),
        null,
        LayoutShinSebul.JAMOSET_SHIN_P2,
        LayoutGongSebul.COMB_FULL,
        null,
        "keyboard_sebul_shin_p2",
    ),

    SEBUL_AHNMATAE(
        Properties(true, false, false, false),
        LayoutMoachigiSebul.JAMO_SEBUL_AHNMATAE,
        null,
        LayoutMoachigiSebul.COMB_SEBUL_AHNMATAE,
        null,
        "keyboard_sebul_ahnmatae",
    ),
    SEBUL_SEMOE_2016(
        Properties(true, false, false, false),
        LayoutMoachigiSebul.JAMO_SEBUL_SEMOE_2016,
        null,
        LayoutMoachigiSebul.COMB_SEBUL_SEMOE,
        null,
        "keyboard_sebul_semoe_2016",
    ),
    SEBUL_SEMOE(
        Properties(true, false, false, false),
        LayoutMoachigiSebul.JAMO_SEBUL_SEMOE_2016,
        null,
        LayoutMoachigiSebul.COMB_SEBUL_SEMOE,
        null,
        "keyboard_sebul_semoe",
    ),

    NEBUL_1969(Properties(), LayoutDev.JAMO_NEBUL_1969, null, LayoutDev.COMB_NEBUL_1969, null, "keyboard_nebul_1969"),

    DUBULSIK_YET(Properties(), LayoutDubul.JAMO_DUBUL_YET, null, LayoutGongSebul.COMB_FULL, null, "keyboard_dubul_yet"),
    SEBUL_393Y(
        Properties(),
        LayoutGongSebul.JAMO_SEBUL_393Y,
        null,
        LayoutGongSebul.COMB_FULL,
        null,
        "keyboard_sebul_393y",
    ),
    SEBUL_3_2015Y(
        Properties(),
        LayoutShinSebul.JAMO_SEBUL_3_2015Y,
        null,
        LayoutGongSebul.COMB_FULL,
        null,
        "keyboard_sebul_3_2015y",
    ),

    ENGLISH_QWERTY(
        Properties(LANG_EN_CODE, false, false, false, false, false, false),
        null,
        null,
        null,
        null,
        "keyboard_alphabet_qwerty",
    ),
    ENGLISH_DVORAK(
        Properties(LANG_EN_CODE, false, false, false, false, false, false),
        LayoutAlphabet.CONVERT_ENGLISH_DVORAK,
        null,
        null,
        null,
        "keyboard_alphabet_dvorak",
    ),
    ENGLISH_COLEMAK(
        Properties(LANG_EN_CODE, false, false, false, false, false, false),
        LayoutAlphabet.CONVERT_ENGLISH_COLEMAK,
        null,
        null,
        null,
        "keyboard_alphabet_colemak",
    ),
    ;

    val prefValues: Array<out String> = prefValues

    companion object {
        const val LANG_EN = LANG_EN_CODE
        const val LANG_KO = LANG_KO_CODE

        @JvmStatic
        fun get(defaultLayout: String): EngineMode {
            for (mode in values()) {
                if (mode.prefValues.isEmpty()) {
                    continue
                }
                for (prefValue in mode.prefValues) {
                    if (prefValue == defaultLayout) {
                        return mode
                    }
                }
            }
            return DIRECT
        }
    }

    class Properties {
        val languageCode: Int
        val altMode: Boolean
        val direct: Boolean
        val predictive: Boolean
        val fullMoachigi: Boolean
        val twelveEngine: Boolean
        val timeout: Boolean

        constructor(
            languageCode: Int,
            altMode: Boolean,
            direct: Boolean,
            predictive: Boolean,
            fullMoachigi: Boolean,
            twelveEngine: Boolean,
            timeout: Boolean,
        ) {
            this.languageCode = languageCode
            this.altMode = altMode
            this.direct = direct
            this.predictive = predictive
            this.fullMoachigi = fullMoachigi
            this.twelveEngine = twelveEngine
            this.timeout = timeout
        }

        constructor(
            altMode: Boolean,
            direct: Boolean,
            predictive: Boolean,
            fullMoachigi: Boolean,
            twelveEngine: Boolean,
            timeout: Boolean,
        ) : this(LANG_KO_CODE, altMode, direct, predictive, fullMoachigi, twelveEngine, timeout)

        constructor(
            direct: Boolean,
            predictive: Boolean,
            fullMoachigi: Boolean,
            twelveEngine: Boolean,
            timeout: Boolean,
        ) : this(false, direct, predictive, fullMoachigi, twelveEngine, timeout)

        constructor(predictive: Boolean, fullMoachigi: Boolean, twelveEngine: Boolean, timeout: Boolean) :
            this(false, fullMoachigi, predictive, twelveEngine, timeout)

        constructor(twelveEngine: Boolean, predictive: Boolean, timeout: Boolean) :
            this(false, predictive, false, twelveEngine, timeout)

        constructor() : this(false, false, false, false, false)
    }
}
