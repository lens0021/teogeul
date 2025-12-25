package io.github.lens0021.teogeul.KOKR.layout

object LayoutMoachigiSebul {
    @JvmField
    val JAMO_SEBUL_AHNMATAE =
        arrayOf(
            intArrayOf(49, 0x31, 0x21),
            intArrayOf(50, 0x32, 0x40),
            intArrayOf(51, 0x33, 0x23),
            intArrayOf(52, 0x34, 0x24),
            intArrayOf(53, 0x35, 0x25),
            intArrayOf(54, 0x36, 0x5e),
            intArrayOf(55, 0x37, 0x26),
            intArrayOf(56, 0x38, 0x2a),
            intArrayOf(57, 0x39, 0x28),
            intArrayOf(48, 0x30, 0x29),
            intArrayOf(113, 0x1106, 0x1106), // q
            intArrayOf(119, 0x1109, 0x1140), // w
            intArrayOf(101, 0x1102, 0x1102), // e
            intArrayOf(114, 0x1105, 0x1105), // r
            intArrayOf(116, 0x1112, 0x1159), // t
            intArrayOf(121, 0x1167, 0x3b), // y
            intArrayOf(117, 0x1163, 0x27), // u
            intArrayOf(105, 0x1173, 0x2f), // i
            intArrayOf(111, 0x116d, 0x5b), // o
            intArrayOf(112, 0x1172, 0x5d), // p
            intArrayOf(91, 0x2c, 0x7b),
            intArrayOf(93, 0x3f, 0x7d),
            intArrayOf(97, 0x1107, 0x1111), // a
            intArrayOf(115, 0x110c, 0x110e), // s
            intArrayOf(100, 0x1103, 0x1110), // d
            intArrayOf(102, 0x1100, 0x110f), // f
            intArrayOf(103, 0x110b, 0x114c), // g
            intArrayOf(104, 0x1165, 0x1165), // h
            intArrayOf(106, 0x1161, 0x119e), // j
            intArrayOf(107, 0x1175, 0x1175), // k
            intArrayOf(108, 0x1169, 0x1169), // l
            intArrayOf(59, 0x116e, 0x3a),
            intArrayOf(39, 0x2e, 0x22),
            intArrayOf(122, 0x11bd, 0x11be), // z
            intArrayOf(120, 0x11ae, 0x11c0), // x
            intArrayOf(99, 0x11b8, 0x11c1), // c
            intArrayOf(118, 0x11a8, 0x11bf), // v
            intArrayOf(98, 0x11bc, 0x11f0), // b
            intArrayOf(110, 0x11ba, 0x11eb), // n
            intArrayOf(109, 0x11ab, 0x11ab), // m
            intArrayOf(44, 0x11b7, 0x3c),
            intArrayOf(46, 0x11af, 0x3e),
            intArrayOf(47, 0x11c2, 0x11f9),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val COMB_SEBUL_AHNMATAE =
        arrayOf(
            intArrayOf(0x1100, 0x1103, 0x1104), // ㄱ + ㄷ = ㄸ
            intArrayOf(0x1100, 0x110b, 0x1101), // ㄱ + ㅇ = ㄲ
            intArrayOf(0x1100, 0x1112, 0x110f), // ㄱ + ㅎ = ㅋ
            intArrayOf(0x1102, 0x1109, 0x110a), // ㄴ + ㅅ = ㅆ
            intArrayOf(0x1103, 0x1100, 0x1104), // ㄷ + ㄱ = ㄸ
            intArrayOf(0x1103, 0x110c, 0x110d), // ㄷ + ㅈ = ㅉ
            intArrayOf(0x1103, 0x1112, 0x1110), // ㄷ + ㅎ = ㅌ
            intArrayOf(0x1107, 0x110c, 0x1108), // ㅂ + ㅈ = ㅃ
            intArrayOf(0x1107, 0x1112, 0x1111), // ㅂ + ㅎ = ㅍ
            intArrayOf(0x1109, 0x1102, 0x110a), // ㅅ + ㄴ = ㅆ
            intArrayOf(0x110b, 0x1100, 0x1101), // ㅇ + ㄱ = ㄲ
            intArrayOf(0x110c, 0x1103, 0x110d), // ㅈ + ㄷ = ㅉ
            intArrayOf(0x110c, 0x1107, 0x1108), // ㅈ + ㅂ = ㅃ
            intArrayOf(0x110c, 0x1112, 0x110e), // ㅈ + ㅎ = ㅊ
            intArrayOf(0x1112, 0x1100, 0x110f), // ㅎ + ㄱ = ㅋ
            intArrayOf(0x1112, 0x1103, 0x1110), // ㅎ + ㄷ = ㅌ
            intArrayOf(0x1112, 0x1107, 0x1111), // ㅎ + ㅂ = ㅍ
            intArrayOf(0x1112, 0x110c, 0x110e), // ㅎ + ㅈ + ㅊ
            intArrayOf(0x1161, 0x1169, 0x116a), // ㅏ + ㅗ = ㅘ
            intArrayOf(0x1161, 0x1175, 0x1162), // ㅏ + ㅣ = ㅐ
            intArrayOf(0x1162, 0x1169, 0x116b), // ㅐ + ㅗ = ㅙ
            intArrayOf(0x1163, 0x1175, 0x1164), // ㅑ + ㅣ = ㅒ
            intArrayOf(0x1165, 0x116e, 0x116f), // ㅓ + ㅜ = ㅝ
            intArrayOf(0x1165, 0x1175, 0x1166), // ㅓ + ㅣ = ㅔ
            intArrayOf(0x1166, 0x116e, 0x1170), // ㅔ + ㅜ = ㅞ
            intArrayOf(0x1167, 0x1175, 0x1168), // ㅕ + ㅣ = ㅖ
            intArrayOf(0x1169, 0x1161, 0x116a), // ㅗ + ㅏ = ㅘ
            intArrayOf(0x1169, 0x1175, 0x116c), // ㅗ + ㅣ = ㅚ
            intArrayOf(0x116a, 0x1175, 0x116b), // ㅘ + ㅣ = ㅙ
            intArrayOf(0x116c, 0x1161, 0x116b), // ㅚ + ㅏ = ㅙ
            intArrayOf(0x116e, 0x1165, 0x116f), // ㅜ + ㅓ = ㅝ
            intArrayOf(0x116e, 0x1175, 0x1171), // ㅜ + ㅣ = ㅟ
            intArrayOf(0x116f, 0x1175, 0x1170), // ㅝ + ㅣ = ㅞ
            intArrayOf(0x1171, 0x1165, 0x1170), // ㅟ + ㅓ = ㅞ
            intArrayOf(0x1173, 0x1175, 0x1174), // ㅡ + ㅣ = ㅢ
            intArrayOf(0x1175, 0x1161, 0x1162), // ㅣ + ㅏ = ㅐ
            intArrayOf(0x1175, 0x1163, 0x1164), // ㅣ + ㅑ = ㅒ
            intArrayOf(0x1175, 0x1165, 0x1166), // ㅣ + ㅓ = ㅔ
            intArrayOf(0x1175, 0x1167, 0x1168), // ㅣ + ㅕ = ㅖ
            intArrayOf(0x1175, 0x1169, 0x116c), // ㅣ + ㅗ = ㅚ
            intArrayOf(0x1175, 0x116e, 0x1171), // ㅣ + ㅜ = ㅟ
            intArrayOf(0x1175, 0x1173, 0x1174), // ㅣ + ㅡ = ㅢ
            intArrayOf(0x119e, 0x1175, 0x11a1), // ㆍ + ㅣ = ㆎ
            intArrayOf(0x119e, 0x119e, 0x11a2), // ㆍ + ㆍ = ᆢ
            intArrayOf(0x11a8, 0x11af, 0x11b0), // ㄱ + ㄹ = ㄺ
            intArrayOf(0x11a8, 0x11ba, 0x11aa), // ㄱ + ㅅ = ㄳ
            intArrayOf(0x11a8, 0x11bc, 0x11a9), // ㄱ + ㅇ = ㄲ
            intArrayOf(0x11a8, 0x11c2, 0x11bf), // ㄱ + ㅎ = ㅋ
            intArrayOf(0x11ab, 0x11ba, 0x11bb), // ㄴ + ㅅ = ㅆ
            intArrayOf(0x11ab, 0x11bd, 0x11ac), // ㄴ + ㅈ = ㄵ
            intArrayOf(0x11ab, 0x11c2, 0x11ad), // ㄴ + ㅎ = ㄶ
            intArrayOf(0x11ae, 0x11af, 0x11ce), // ㄷ + ㄹ = ᇎ
            intArrayOf(0x11ae, 0x11c2, 0x11c0), // ㄷ + ㅎ = ㅌ
            intArrayOf(0x11af, 0x11a8, 0x11b0), // ㄹ + ㄱ = ㄺ
            intArrayOf(0x11af, 0x11ae, 0x11ce), // ㄹ + ㄷ = ᇎ
            intArrayOf(0x11af, 0x11b7, 0x11b1), // ㄹ + ㅁ = ㄻ
            intArrayOf(0x11af, 0x11b8, 0x11b2), // ㄹ + ㅂ = ㄼ
            intArrayOf(0x11af, 0x11ba, 0x11b3), // ㄹ + ㅅ = ㄽ
            intArrayOf(0x11af, 0x11c2, 0x11b6), // ㄹ + ㅎ = ㅀ
            intArrayOf(0x11b2, 0x11c2, 0x11b5), // ㄼ + ㅎ = ㄿ
            intArrayOf(0x11b6, 0x11ae, 0x11b4), // ㅀ + ㄷ = ㄾ
            intArrayOf(0x11b6, 0x11b8, 0x11b5), // ㅀ + ㅂ = ㄿ
            intArrayOf(0x11b7, 0x11af, 0x11b1), // ㅁ + ㄹ = ㄻ
            intArrayOf(0x11b8, 0x11af, 0x11b2), // ㅂ + ㄹ = ㄼ
            intArrayOf(0x11b8, 0x11ba, 0x11b9), // ㅂ + ㅅ = ㅄ
            intArrayOf(0x11b8, 0x11c2, 0x11c1), // ㅂ + ㅎ = ㅍ
            intArrayOf(0x11ba, 0x11a8, 0x11aa), // ㅅ + ㄱ = ㄳ
            intArrayOf(0x11ba, 0x11ab, 0x11bb), // ㅅ + ㄴ = ㅆ
            intArrayOf(0x11ba, 0x11af, 0x11b3), // ㅅ + ㄹ = ㄽ
            intArrayOf(0x11ba, 0x11b8, 0x11b9), // ㅅ + ㅂ = ㅄ
            intArrayOf(0x11bc, 0x11a8, 0x11a9), // ㅇ + ㄱ = ㄲ
            intArrayOf(0x11bd, 0x11ab, 0x11ac), // ㅈ + ㄴ = ㄵ
            intArrayOf(0x11bd, 0x11c2, 0x11be), // ㅈ + ㅎ = ㅊ
            intArrayOf(0x11c0, 0x11af, 0x11b4), // ㅌ + ㄹ = ㄾ
            intArrayOf(0x11c1, 0x11af, 0x11b5), // ㅍ + ㄹ = ㄿ
            intArrayOf(0x11c2, 0x11a8, 0x11bf), // ㅎ + ㄱ = ㅋ
            intArrayOf(0x11c2, 0x11ab, 0x11ad), // ㅎ + ㄴ = ㄶ
            intArrayOf(0x11c2, 0x11ae, 0x11c0), // ㅎ + ㄷ = ㅌ
            intArrayOf(0x11c2, 0x11af, 0x11b6), // ㅎ + ㄹ = ㅀ
            intArrayOf(0x11c2, 0x11b8, 0x11c1), // ㅎ + ㅂ = ㅍ
            intArrayOf(0x11c2, 0x11bd, 0x11be), // ㅎ + ㅈ = ㅊ
            intArrayOf(0x11ce, 0x11c2, 0x11b4), // ᇎ + ㅎ = ㄾ
            intArrayOf(0x1100, 0x1100, 0x1101),	// ㄲ
            intArrayOf(0x1103, 0x1103, 0x1104),	// ㄸ
            intArrayOf(0x1107, 0x1107, 0x1108),	// ㅃ
            intArrayOf(0x1109, 0x1109, 0x110a),	// ㅆ
            intArrayOf(0x110c, 0x110c, 0x110d),	// ㅉ
            intArrayOf(0x1169, 0x1161, 0x116a),	// ㅘ
            intArrayOf(0x1169, 0x1162, 0x116b),	// ㅙ
            intArrayOf(0x1169, 0x1175, 0x116c),	// ㅚ
            intArrayOf(0x116e, 0x1165, 0x116f),	// ㅝ
            intArrayOf(0x116e, 0x1166, 0x1170),	// ㅞ
            intArrayOf(0x116e, 0x1175, 0x1171),	// ㅟ
            intArrayOf(0x1173, 0x1175, 0x1174),	// ㅢ
            intArrayOf(0x119e, 0x1175, 0x11a1),	// ㆎ
            intArrayOf(0x119e, 0x119e, 0x11a2),	// ᆢ
            intArrayOf(0x11a8, 0x11a8, 0x11a9),	// ㄲ
            intArrayOf(0x11a8, 0x11ba, 0x11aa),	// ㄳ
            intArrayOf(0x11ab, 0x11bd, 0x11ac),	// ㄵ
            intArrayOf(0x11ab, 0x11c2, 0x11ad),	// ㄶ
            intArrayOf(0x11af, 0x11a8, 0x11b0),	// ㄺ
            intArrayOf(0x11af, 0x11b7, 0x11b1),	// ㄻ
            intArrayOf(0x11af, 0x11b8, 0x11b2),	// ㄼ
            intArrayOf(0x11af, 0x11ba, 0x11b3),	// ㄽ
            intArrayOf(0x11af, 0x11c0, 0x11b4),	// ㄾ
            intArrayOf(0x11af, 0x11c1, 0x11b5),	// ㄿ
            intArrayOf(0x11af, 0x11c2, 0x11b6),	// ㅀ
            intArrayOf(0x11b8, 0x11ba, 0x11b9),	// ㅄ
            intArrayOf(0x11ba, 0x11ba, 0x11bb),	// ㅆ
        )

    @JvmField
    val JAMO_SEBUL_SEMOE_2016 =
        arrayOf(
            intArrayOf(49, 0x31, 0x21),
            intArrayOf(50, 0x32, 0x40),
            intArrayOf(51, 0x33, 0x23),
            intArrayOf(52, 0x34, 0x24),
            intArrayOf(53, 0x35, 0x25),
            intArrayOf(54, 0x36, 0x5e),
            intArrayOf(55, 0x37, 0x26),
            intArrayOf(56, 0x38, 0x2a),
            intArrayOf(57, 0x39, 0x28),
            intArrayOf(48, 0x30, 0x29),
            intArrayOf(113, 0x11ba, 0x11be), // q
            intArrayOf(119, 0x11b8, 0x11c1), // w
            intArrayOf(101, 0x11af, 0x11bd), // e
            intArrayOf(114, 0x1165, 0x1163), // r
            intArrayOf(116, 0x1167, 0x1164), // t
            intArrayOf(121, 0x1106, 0x1106), // y
            intArrayOf(117, 0x1102, 0x1102), // u
            intArrayOf(105, 0x1103, 0x1110), // i
            intArrayOf(111, 0x1107, 0x1111), // o
            intArrayOf(112, 0x116e, 0x3b), // p
            intArrayOf(91, 0x1169, 0x7b),
            intArrayOf(97, 0x11bc, 0x11c0), // a
            intArrayOf(115, 0x11ab, 0x11c2), // s
            intArrayOf(100, 0x1175, 0x1175), // d
            intArrayOf(102, 0x1161, 0x119e), // f
            intArrayOf(103, 0x1173, 0x1173), // g
            intArrayOf(104, 0x1112, 0xb7), // h
            intArrayOf(106, 0x110b, 0x110b), // j
            intArrayOf(107, 0x1100, 0x110f), // k
            intArrayOf(108, 0x110c, 0x110e), // l
            intArrayOf(59, 0x11bb, 0x3a),
            intArrayOf(39, 0x5b, 0x22),
            intArrayOf(122, 0x11b7, 0x11ae), // z
            intArrayOf(120, 0x11a8, 0x11bf), // x
            intArrayOf(99, 0x1166, 0x1168), // c
            intArrayOf(118, 0x1169, 0x116d), // v
            intArrayOf(98, 0x116e, 0x1172), // b
            intArrayOf(110, 0x1109, 0x1109), // n
            intArrayOf(109, 0x1105, 0x27), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(128, 0x2e, 0x2c),
        )
	
    @JvmField
    val JAMO_SEBUL_SEMOE =
        arrayOf(
            intArrayOf(49, 0x31, 0x21),
            intArrayOf(50, 0x32, 0x40),
            intArrayOf(51, 0x33, 0x23),
            intArrayOf(52, 0x34, 0x24),
            intArrayOf(53, 0x35, 0x25),
            intArrayOf(54, 0x36, 0x5e),
            intArrayOf(55, 0x37, 0x26),
            intArrayOf(56, 0x38, 0x2a),
            intArrayOf(57, 0x39, 0x28),
            intArrayOf(48, 0x30, 0x29),
            intArrayOf(113, 0x11ba, 0x11be), // q
            intArrayOf(119, 0x11b8, 0x11c1), // w
            intArrayOf(101, 0x11af, 0x11bd), // e
            intArrayOf(114, 0x1165, 0x1163), // r
            intArrayOf(116, 0x1167, 0x1164), // t
            intArrayOf(121, 0x1106, 0x1106), // y
            intArrayOf(117, 0x1102, 0x1102), // u
            intArrayOf(105, 0x1103, 0x1110), // i
            intArrayOf(111, 0x1107, 0x1111), // o
            intArrayOf(112, 0x116e, 0x3b), // p
            intArrayOf(97, 0x11bc, 0x11c0), // a
            intArrayOf(115, 0x11ab, 0x11c2), // s
            intArrayOf(100, 0x1175, 0x1175), // d
            intArrayOf(102, 0x1161, 0x119e), // f
            intArrayOf(103, 0x1173, 0x1173), // g
            intArrayOf(104, 0x1112, 0xb7), // h
            intArrayOf(106, 0x110b, 0x110b), // j
            intArrayOf(107, 0x1100, 0x110f), // k
            intArrayOf(108, 0x110c, 0x110e), // l
            intArrayOf(59, 0x11bb, 0x3a),
            intArrayOf(39, 0x2c, 0x22),
            intArrayOf(122, 0x11b7, 0x11ae), // z
            intArrayOf(120, 0x11a8, 0x11bf), // x
            intArrayOf(99, 0x1166, 0x1168), // c
            intArrayOf(118, 0x1169, 0x116d), // v
            intArrayOf(98, 0x116e, 0x1172), // b
            intArrayOf(110, 0x1109, 0x1109), // n
            intArrayOf(109, 0x1105, 0x27), // m
            intArrayOf(44, 0x2e, 0x3c),
            intArrayOf(46, 0x1169, 0x3e),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val COMB_SEBUL_SEMOE =
        arrayOf(
            intArrayOf(0x1100, 0x1100, 0x1101), // ㄲ
            intArrayOf(0x1100, 0x110b, 0x1101), // ㄱ + ㅇ = ㄲ
            intArrayOf(0x1100, 0x1112, 0x110f), // ㄱ + ㅎ = ㅋ
            intArrayOf(0x1101, 0x1100, 0x110f), // ㄲ + ㄱ = ㅋ
            intArrayOf(0x1103, 0x1103, 0x1104), // ㄸ
            intArrayOf(0x1103, 0x110b, 0x1104), // ㄷ + ㅇ = ㄸ
            intArrayOf(0x1103, 0x1112, 0x1110), // ㄷ + ㅎ = ㅌ
            intArrayOf(0x1104, 0x1103, 0x1110), // ㄸ + ㄷ = ㅌ
            intArrayOf(0x1107, 0x1107, 0x1108), // ㅃ
            intArrayOf(0x1107, 0x110b, 0x1108), // ㅂ + ㅇ = ㅃ
            intArrayOf(0x1107, 0x1112, 0x1111), // ㅂ + ㅎ = ㅍ
            intArrayOf(0x1108, 0x1107, 0x1111), // ㅃ + ㅂ = ㅍ
            intArrayOf(0x1109, 0x1109, 0x110a), // ㅆ
            intArrayOf(0x1109, 0x110b, 0x110a), // ㅅ + ㅇ = ㅆ
            intArrayOf(0x110b, 0x1100, 0x1101), // ㅇ + ㄱ = ㄲ
            intArrayOf(0x110b, 0x1103, 0x1104), // ㅇ + ㄷ = ㄸ
            intArrayOf(0x110b, 0x1107, 0x1108), // ㅇ + ㅂ = ㅃ
            intArrayOf(0x110b, 0x1109, 0x110a), // ㅇ + ㅅ = ㅆ
            intArrayOf(0x110b, 0x110c, 0x110d), // ㅇ + ㅈ = ㅉ
            intArrayOf(0x110c, 0x110b, 0x110d), // ㅈ + ㅇ = ㅉ
            intArrayOf(0x110c, 0x110c, 0x110d), // ㅉ
            intArrayOf(0x110c, 0x1112, 0x110e), // ㅈ + ㅎ = ㅊ
            intArrayOf(0x110d, 0x110c, 0x110e), // ㅉ + ㅈ = ㅊ
            intArrayOf(0x1112, 0x1100, 0x110f), // ㅎ + ㄱ = ㅋ
            intArrayOf(0x1112, 0x1103, 0x1110), // ㅎ + ㄷ = ㅌ
            intArrayOf(0x1112, 0x1107, 0x1111), // ㅎ + ㅂ = ㅍ
            intArrayOf(0x1112, 0x110c, 0x110e), // ㅎ + ㅈ = ㅊ
            intArrayOf(0x1161, 0x1161, 0x1163), // ㅏ + ㅏ = ㅑ
            intArrayOf(0x1161, 0x1165, 0x116d), // ㅏ + ㅓ = ㅛ
            intArrayOf(0x1161, 0x1169, 0x116a), // ㅏ + ㅗ = ㅘ
            intArrayOf(0x1161, 0x116c, 0x116b), // ㅏ + ㅚ = ㅙ
            intArrayOf(0x1161, 0x1173, 0x119e), // ㅏ + ㅡ = ㆍ
            intArrayOf(0x1161, 0x1174, 0x11a1), // ㅏ + ㅢ = ㆎ
            intArrayOf(0x1161, 0x1175, 0x1162), // ㅏ + ㅣ = ㅐ
            intArrayOf(0x1162, 0x1169, 0x116b), // ㅐ + ㅗ = ㅙ
            intArrayOf(0x1162, 0x1173, 0x11a1), // ㅐ + ㅡ = ㆎ
            intArrayOf(0x1163, 0x1175, 0x1164), // ㅑ + ㅣ = ㅒ
            intArrayOf(0x1165, 0x1161, 0x116d), // ㅓ + ㅏ = ㅛ
            intArrayOf(0x1165, 0x1165, 0x1163), // ㅓ + ㅓ = ㅑ
            intArrayOf(0x1165, 0x1169, 0x1163), // ㅓ + ㅗ = ㅑ
            intArrayOf(0x1165, 0x116e, 0x116f), // ㅓ + ㅜ = ㅝ
            intArrayOf(0x1165, 0x1173, 0x11a2), // ㅓ + ㅡ = ᆢ
            intArrayOf(0x1166, 0x1166, 0x1168), // ㅔ + ㅔ = ㅖ
            intArrayOf(0x1166, 0x1169, 0x1168), // ㅔ + ㅗ = ㅖ
            intArrayOf(0x1166, 0x116e, 0x1170), // ㅔ + ㅜ = ㅞ
            intArrayOf(0x1167, 0x1167, 0x1164), // ㅕ + ㅕ = ㅒ
            intArrayOf(0x1167, 0x1169, 0x1164), // ㅕ + ㅗ = ㅒ
            intArrayOf(0x1169, 0x1161, 0x116a), // ㅗ + ㅏ = ㅘ
            intArrayOf(0x1169, 0x1162, 0x116b), // ㅗ + ㅐ = ㅙ
            intArrayOf(0x1169, 0x1165, 0x1163), // ㅗ + ㅓ = ㅑ
            intArrayOf(0x1169, 0x1166, 0x1168), // ㅗ + ㅔ = ㅖ
            intArrayOf(0x1169, 0x1167, 0x1164), // ㅗ + ㅕ = ㅒ
            intArrayOf(0x1169, 0x1169, 0x116d), // ㅗ + ㅗ = ㅛ
            intArrayOf(0x1169, 0x116e, 0x1172), // ㅗ + ㅜ = ㅠ
            intArrayOf(0x1169, 0x1175, 0x116c), // ㅗ + ㅣ = ㅚ
            intArrayOf(0x116a, 0x1175, 0x116b), // ㅘ + ㅣ = ㅙ
            intArrayOf(0x116c, 0x1161, 0x116b), // ㅚ + ㅏ = ㅙ
            intArrayOf(0x116e, 0x1165, 0x116f), // ㅜ + ㅓ = ㅝ
            intArrayOf(0x116e, 0x1166, 0x1170), // ㅜ + ㅔ = ㅞ
            intArrayOf(0x116e, 0x1169, 0x1172), // ㅜ + ㅗ = ㅠ
            intArrayOf(0x116e, 0x116e, 0x1172), // ㅜ + ㅜ = ㅠ
            intArrayOf(0x116e, 0x1175, 0x1171), // ㅜ + ㅣ = ㅟ
            intArrayOf(0x1173, 0x1161, 0x119e), // ㅡ + ㅏ = ㆍ
            intArrayOf(0x1173, 0x1162, 0x11a1), // ㅡ + ㅐ = ㆎ
            intArrayOf(0x1173, 0x1165, 0x11a2), // ㅡ + ㅓ = ᆢ
            intArrayOf(0x1173, 0x1175, 0x1174), // ㅡ + ㅣ = ㅢ
            intArrayOf(0x1174, 0x1161, 0x11a1), // ㅢ + ㅏ = ㆎ
            intArrayOf(0x1175, 0x1161, 0x1162), // ㅣ + ㅏ = ㅐ
            intArrayOf(0x1175, 0x1169, 0x116c), // ㅣ + ㅗ = ㅚ
            intArrayOf(0x1175, 0x116a, 0x116b), // ㅣ + ㅘ = ㅙ
            intArrayOf(0x1175, 0x116e, 0x1171), // ㅣ + ㅜ = ㅟ
            intArrayOf(0x1175, 0x1173, 0x1174), // ㅣ + ㅡ = ㅢ
            intArrayOf(0x1175, 0x119e, 0x11a1), // ㅣ + ㆍ = ㆎ
            intArrayOf(0x119e, 0x1175, 0x11a1), // ㆍ + ㅣ = ㆎ
            intArrayOf(0x119e, 0x119e, 0x11a2), // ㆍ + ㆍ = ᆢ
            intArrayOf(0x11a8, 0x11a8, 0x11a9), // ㄲ
            intArrayOf(0x11a8, 0x11ae, 0x11aa), // ㄱ + ㄷ = ㄳ
            intArrayOf(0x11a8, 0x11af, 0x11b0), // ㄱ + ㄹ = ㄺ
            intArrayOf(0x11a8, 0x11b7, 0x11b0), // ㄱ + ㅁ = ㄺ
            intArrayOf(0x11a8, 0x11ba, 0x11aa), // ㄱ + ㅅ = ㄳ
            intArrayOf(0x11a8, 0x11bb, 0x11bf), // ㄱ + ㅆ = ㅋ
            intArrayOf(0x11a8, 0x11bc, 0x11a9), // ㄱ + ㅇ = ㄲ
            intArrayOf(0x11a8, 0x11c2, 0x11bf), // ㄱ + ㅎ = ㅋ
            intArrayOf(0x11a9, 0x11a8, 0x11bf), // ㄲ + ㄱ = ㅋ
            intArrayOf(0x11ab, 0x11ab, 0x11c2), // ㄴ + ㄴ = ㅎ
            intArrayOf(0x11ab, 0x11af, 0x11ac), // ㄴ + ㄹ = ㄵ
            intArrayOf(0x11ab, 0x11b7, 0x11c0), // ㄴ + ㅁ = ㅌ
            intArrayOf(0x11ab, 0x11bb, 0x11c2), // ㄴ + ㅆ = ㅎ
            intArrayOf(0x11ab, 0x11bc, 0x11ad), // ㄴ + ㅇ = ㄶ
            intArrayOf(0x11ab, 0x11bd, 0x11ac), // ㄵ
            intArrayOf(0x11ab, 0x11c2, 0x11ad), // ㄴ + ㅎ = ㄶ
            intArrayOf(0x11ac, 0x11ab, 0x11b6), // ㄵ + ㄴ = ㅀ
            intArrayOf(0x11ae, 0x11a8, 0x11aa), // ㄷ + ㄱ = ㄳ
            intArrayOf(0x11ae, 0x11b7, 0x11c0), // ㄷ + ㅁ = ㅌ
            intArrayOf(0x11ae, 0x11c2, 0x11c0), // ㄷ + ㅎ = ㅌ
            intArrayOf(0x11af, 0x11a8, 0x11b0), // ㄹ + ㄱ = ㄺ
            intArrayOf(0x11af, 0x11ab, 0x11ac), // ㄹ + ㄴ = ㄵ
            intArrayOf(0x11af, 0x11af, 0x11bd), // ㄹ + ㄹ = ㅈ
            intArrayOf(0x11af, 0x11b7, 0x11b1), // ㄹ + ㅁ = ㄻ
            intArrayOf(0x11af, 0x11b8, 0x11b2), // ㄹ + ㅂ + ㄼ
            intArrayOf(0x11af, 0x11ba, 0x11b3), // ㄹ + ㅅ = ㄽ
            intArrayOf(0x11af, 0x11bb, 0x11bd), // ㄹ + ㅆ = ㅈ
            intArrayOf(0x11af, 0x11bc, 0x11a8), // ㄹ + ㅇ = ㄱ
            intArrayOf(0x11af, 0x11be, 0x11a9), // ㄹ + ㅊ = ㄲ
            intArrayOf(0x11af, 0x11c0, 0x11b4), // ㄾ
            intArrayOf(0x11af, 0x11c1, 0x11b5), // ㄹ + ㅍ = ㄿ
            intArrayOf(0x11af, 0x11c2, 0x11b6), // ㅀ
            intArrayOf(0x11b0, 0x11bb, 0x11aa), // ㄺ + ㅆ = ㄳ
            intArrayOf(0x11b1, 0x11b7, 0x11b4), // ㄻ + ㅁ = ㄾ
            intArrayOf(0x11b2, 0x11b8, 0x11b5), // ㄼ + ㅂ = ㄿ
            intArrayOf(0x11b2, 0x11bb, 0x11c0), // ㄼ + ㅆ = ㅌ
            intArrayOf(0x11b3, 0x11bb, 0x11a9), // ㄽ + ㅆ = ㄲ
            intArrayOf(0x11b7, 0x11a8, 0x11b0), // ㅁ + ㄱ = ㄺ
            intArrayOf(0x11b7, 0x11ab, 0x11c0), // ㅁ + ㄴ = ㅌ
            intArrayOf(0x11b7, 0x11af, 0x11b1), // ㅁ + ㄹ = ㄻ
            intArrayOf(0x11b7, 0x11b7, 0x11ae), // ㅁ + ㅁ = ㄷ
            intArrayOf(0x11b7, 0x11bb, 0x11ae), // ㅁ + ㅆ = ㄷ
            intArrayOf(0x11b7, 0x11bc, 0x11b4), // ㅁ + ㅇ = ㄾ
            intArrayOf(0x11b7, 0x11bf, 0x11aa), // ㅁ + ㅋ = ㄳ
            intArrayOf(0x11b8, 0x11af, 0x11b2), // ㅂ + ㄹ = ㄼ
            intArrayOf(0x11b8, 0x11b8, 0x11c1), // ㅂ + ㅂ = ㅍ
            intArrayOf(0x11b8, 0x11ba, 0x11b9), // ㅂ + ㅅ = ㅄ
            intArrayOf(0x11b8, 0x11bb, 0x11c1), // ㅂ + ㅆ = ㅍ
            intArrayOf(0x11b8, 0x11bc, 0x11b5), // ㅂ + ㅇ = ㄿ
            intArrayOf(0x11b8, 0x11bd, 0x11c0), // ㅂ + ㅈ = ㅌ
            intArrayOf(0x11b8, 0x11be, 0x11b1), // ㅂ + ㅊ = ㄻ
            intArrayOf(0x11b8, 0x11c2, 0x11c1), // ㅂ + ㅎ = ㅍ
            intArrayOf(0x11b9, 0x11bb, 0x11b1), // ㅄ + ㅆ = ㄻ
            intArrayOf(0x11ba, 0x11a8, 0x11aa), // ㅅ + ㄱ = ㄳ
            intArrayOf(0x11ba, 0x11af, 0x11b3), // ㅅ + ㄹ = ㄽ
            intArrayOf(0x11ba, 0x11b8, 0x11b9), // ㅅ + ㅂ = ㅄ
            intArrayOf(0x11ba, 0x11bb, 0x11be), // ㅅ + ㅆ = ㅊ
            intArrayOf(0x11ba, 0x11ba, 0x11bb), // ㅅ + ㅅ = ㅆ
            intArrayOf(0x11ba, 0x11bc, 0x11bb), // ㅅ + ㅇ = ㅆ
            intArrayOf(0x11ba, 0x11bd, 0x11a9), // ㅅ + ㅈ = ㄲ
            intArrayOf(0x11ba, 0x11c1, 0x11b1), // ㅅ + ㅍ = ㄻ
            intArrayOf(0x11bb, 0x11a8, 0x11bf), // ㅆ + ㄱ = ㅋ
            intArrayOf(0x11bb, 0x11ab, 0x11c2), // ㅆ + ㄴ = ㅎ
            intArrayOf(0x11bb, 0x11af, 0x11bd), // ㅆ + ㄹ = ㅈ
            intArrayOf(0x11bb, 0x11b0, 0x11aa), // ㅆ + ㄺ = ㄳ
            intArrayOf(0x11bb, 0x11b2, 0x11c0), // ㅆ + ㄼ = ㅌ
            intArrayOf(0x11bb, 0x11b3, 0x11a9), // ㅆ + ㄽ = ㄲ
            intArrayOf(0x11bb, 0x11b7, 0x11ae), // ㅆ + ㅁ = ㄷ
            intArrayOf(0x11bb, 0x11b8, 0x11c1), // ㅆ + ㅂ = ㅍ
            intArrayOf(0x11bb, 0x11b9, 0x11b1), // ㅆ + ㅄ = ㄻ
            intArrayOf(0x11bb, 0x11ba, 0x11be), // ㅆ + ㅅ = ㅊ
            intArrayOf(0x11bb, 0x11bc, 0x11b6), // ㅆ + ㅇ = ㅀ
            intArrayOf(0x11bc, 0x11a8, 0x11a9), // ㅇ + ㄱ = ㄲ
            intArrayOf(0x11bc, 0x11ab, 0x11ad), // ㅇ + ㄴ = ㄶ
            intArrayOf(0x11bc, 0x11af, 0x11a8), // ㅇ + ㄹ = ㄱ
            intArrayOf(0x11bc, 0x11b7, 0x11b4), // ㅇ + ㅁ = ㄾ
            intArrayOf(0x11bc, 0x11b8, 0x11b5), // ㅇ + ㅂ = ㄿ
            intArrayOf(0x11bc, 0x11ba, 0x11bb), // ㅇ + ㅅ = ㅆ
            intArrayOf(0x11bc, 0x11bb, 0x11b6), // ㅇ + ㅆ = ㅀ
            intArrayOf(0x11bc, 0x11bc, 0x11c0), // ㅇ + ㅇ = ㅌ
            intArrayOf(0x11bd, 0x11b8, 0x11c0), // ㅈ + ㅂ = ㅌ
            intArrayOf(0x11bd, 0x11ba, 0x11a9), // ㅈ + ㅅ = ㄲ
            intArrayOf(0x11be, 0x11af, 0x11a9), // ㅊ + ㄹ = ㄲ
            intArrayOf(0x11be, 0x11b8, 0x11b1), // ㅊ + ㅂ = ㄻ
            intArrayOf(0x11bf, 0x11b7, 0x11aa), // ㅋ + ㅁ = ㄳ
            intArrayOf(0x11c0, 0x11bc, 0x11b6), // ㅌ + ㅇ = ㅀ
            intArrayOf(0x11c1, 0x11af, 0x11c0), // ㅍ + ㄹ = ㅌ
            intArrayOf(0x11c1, 0x11ba, 0x11b1), // ㅍ + ㅅ = ㄻ
            intArrayOf(0x11c2, 0x11a8, 0x11bf), // ㅎ + ㄱ = ㅋ
            intArrayOf(0x11c2, 0x11ab, 0x11ad), // ㅎ + ㄴ = ㄶ
            intArrayOf(0x11c2, 0x11ae, 0x11c0), // ㅎ + ㄷ = ㅌ
            intArrayOf(0x11c2, 0x11b8, 0x11c1), // ㅎ + ㅂ = ㅍ
        )
}
