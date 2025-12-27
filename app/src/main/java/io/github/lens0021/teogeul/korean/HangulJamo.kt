package io.github.lens0021.teogeul.korean

/**
 * Hangul Jamo constants for better readability
 *
 * All constant names are based on Unicode standard names,
 * converted to Hangul for better readability.
 *
 * Unicode ranges:
 * - Choseong (초성): U+1100 ~ U+115F
 * - Jungseong (중성): U+1161 ~ U+11A7
 * - Jongseong (종성): U+11A8 ~ U+11FF
 */
@Suppress("ConstPropertyName", "NonAsciiCharacters")
object HangulJamo {
    // ===== Choseong (초성) - Leading consonants =====

    // Basic consonants
    const val 초성_ㄱ = 0x1100
    const val 초성_ㄲ = 0x1101
    const val 초성_ㄴ = 0x1102
    const val 초성_ㄷ = 0x1103
    const val 초성_ㄸ = 0x1104
    const val 초성_ㄹ = 0x1105
    const val 초성_ㅁ = 0x1106
    const val 초성_ㅂ = 0x1107
    const val 초성_ㅃ = 0x1108
    const val 초성_ㅅ = 0x1109
    const val 초성_ㅆ = 0x110A
    const val 초성_ㅇ = 0x110B
    const val 초성_ㅈ = 0x110C
    const val 초성_ㅉ = 0x110D
    const val 초성_ㅊ = 0x110E
    const val 초성_ㅋ = 0x110F
    const val 초성_ㅌ = 0x1110
    const val 초성_ㅍ = 0x1111
    const val 초성_ㅎ = 0x1112

    // ===== Jungseong (중성) - Medial vowels =====

    // Basic vowels
    const val 중성_ㅏ = 0x1161
    const val 중성_ㅐ = 0x1162
    const val 중성_ㅑ = 0x1163
    const val 중성_ㅒ = 0x1164
    const val 중성_ㅓ = 0x1165
    const val 중성_ㅔ = 0x1166
    const val 중성_ㅕ = 0x1167
    const val 중성_ㅖ = 0x1168
    const val 중성_ㅗ = 0x1169
    const val 중성_ㅘ = 0x116A
    const val 중성_ㅙ = 0x116B
    const val 중성_ㅚ = 0x116C
    const val 중성_ㅛ = 0x116D
    const val 중성_ㅜ = 0x116E
    const val 중성_ㅝ = 0x116F
    const val 중성_ㅞ = 0x1170
    const val 중성_ㅟ = 0x1171
    const val 중성_ㅠ = 0x1172
    const val 중성_ㅡ = 0x1173
    const val 중성_ㅢ = 0x1174
    const val 중성_ㅣ = 0x1175

    // ===== Jongseong (종성) - Final consonants =====

    // Basic final consonants
    const val 종성_ㄱ = 0x11A8
    const val 종성_ㄲ = 0x11A9
    const val 종성_ㄳ = 0x11AA
    const val 종성_ㄴ = 0x11AB
    const val 종성_ㄵ = 0x11AC
    const val 종성_ㄶ = 0x11AD
    const val 종성_ㄷ = 0x11AE
    const val 종성_ㄹ = 0x11AF
    const val 종성_ㄺ = 0x11B0
    const val 종성_ㄻ = 0x11B1
    const val 종성_ㄼ = 0x11B2
    const val 종성_ㄽ = 0x11B3
    const val 종성_ㄾ = 0x11B4
    const val 종성_ㄿ = 0x11B5
    const val 종성_ㅀ = 0x11B6
    const val 종성_ㅁ = 0x11B7
    const val 종성_ㅂ = 0x11B8
    const val 종성_ㅄ = 0x11B9
    const val 종성_ㅅ = 0x11BA
    const val 종성_ㅆ = 0x11BB
    const val 종성_ㅇ = 0x11BC
    const val 종성_ㅈ = 0x11BD
    const val 종성_ㅊ = 0x11BE
    const val 종성_ㅋ = 0x11BF
    const val 종성_ㅌ = 0x11C0
    const val 종성_ㅍ = 0x11C1
    const val 종성_ㅎ = 0x11C2

    // ===== Hangul Compatibility Jamo =====
    const val 자모_ㄱ = 0x3131
    const val 자모_ㄲ = 0x3132
    const val 자모_ㄳ = 0x3133
    const val 자모_ㄴ = 0x3134
    const val 자모_ㄵ = 0x3135
    const val 자모_ㄶ = 0x3136
    const val 자모_ㄷ = 0x3137
    const val 자모_ㄸ = 0x3138
    const val 자모_ㄹ = 0x3139
    const val 자모_ㄺ = 0x313A
    const val 자모_ㄻ = 0x313B
    const val 자모_ㄼ = 0x313C
    const val 자모_ㄽ = 0x313D
    const val 자모_ㄾ = 0x313E
    const val 자모_ㄿ = 0x313F
    const val 자모_ㅀ = 0x3140
    const val 자모_ㅁ = 0x3141
    const val 자모_ㅂ = 0x3142
    const val 자모_ㅃ = 0x3143
    const val 자모_ㅄ = 0x3144
    const val 자모_ㅅ = 0x3145
    const val 자모_ㅆ = 0x3146
    const val 자모_ㅇ = 0x3147
    const val 자모_ㅈ = 0x3148
    const val 자모_ㅉ = 0x3149
    const val 자모_ㅊ = 0x314A
    const val 자모_ㅋ = 0x314B
    const val 자모_ㅌ = 0x314C
    const val 자모_ㅍ = 0x314D
    const val 자모_ㅎ = 0x314E
    const val 자모_ㅏ = 0x314F
    const val 자모_ㅐ = 0x3150
    const val 자모_ㅑ = 0x3151
    const val 자모_ㅒ = 0x3152
    const val 자모_ㅓ = 0x3153
    const val 자모_ㅔ = 0x3154
    const val 자모_ㅕ = 0x3155
    const val 자모_ㅖ = 0x3156
    const val 자모_ㅗ = 0x3157
    const val 자모_ㅛ = 0x315B
    const val 자모_ㅜ = 0x315C
    const val 자모_ㅠ = 0x3160
    const val 자모_ㅡ = 0x3161
    const val 자모_ㅣ = 0x3163
}
