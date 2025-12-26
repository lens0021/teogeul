package io.github.lens0021.teogeul.layout

import io.github.lens0021.teogeul.korean.HangulEngine

object LayoutData {
    @JvmField
    val JAMO_SEBUL_3_2015M_CHOJONG =
        arrayOf(
            intArrayOf(49, 0x11ae, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11a9), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x11bd, 0x1167), // e
            intArrayOf(114, 0x11be, 0x1162), // r
            intArrayOf(116, 0x1165, 0x1164), // t
            intArrayOf(121, 0x1105, 0x35), // y
            intArrayOf(117, 0x1103, 0x36), // u
            intArrayOf(105, 0x1106, 0x37), // i
            intArrayOf(111, 0x110e, 0x38), // o
            intArrayOf(112, 0x1111, 0x39), // p
            intArrayOf(97, 0x11bc, 0x11b4), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x11c2, 0x1175), // d
            intArrayOf(102, 0x11c1, 0x1161), // f
            intArrayOf(103, 0x1173, 0x3a), // g
            intArrayOf(104, 0x1102, 0x30), // h
            intArrayOf(106, 0x110b, 0x31), // j
            intArrayOf(107, 0x1100, 0x32), // k
            intArrayOf(108, 0x110c, 0x33), // l
            intArrayOf(59, 0x1107, 0x34),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x11b7, 0x11b3), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x11c0, 0x1166), // c
            intArrayOf(118, 0x11bf, 0x1169), // v
            intArrayOf(98, 0x116e, 0x3b), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_3_2015M_CHOJUNG =
        arrayOf(
            intArrayOf(49, 0x11ae, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11a9), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x1167, 0x11bd), // e
            intArrayOf(114, 0x1162, 0x11be), // r
            intArrayOf(116, 0x1165, 0x1164), // t
            intArrayOf(121, 0x1105, 0x0035), // y
            intArrayOf(117, 0x1103, 0x0036), // u
            intArrayOf(105, 0x1106, 0x0037), // i
            intArrayOf(111, 0x110e, 0x0038), // o
            intArrayOf(112, 0x1111, 0x0039), // p
            intArrayOf(97, 0x11bc, 0x11b4), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x1175, 0x11c2), // d
            intArrayOf(102, 0x1161, 0x11c1), // f
            intArrayOf(103, 0x1173, 0x3a), // g
            intArrayOf(104, 0x1102, 0x30), // h
            intArrayOf(106, 0x110b, 0x31), // j
            intArrayOf(107, 0x1100, 0x32), // k
            intArrayOf(108, 0x110c, 0x33), // l
            intArrayOf(59, 0x1107, 0x34),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x11b7, 0x11b3), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x1166, 0x11c0), // c
            intArrayOf(118, 0x1169, 0x11bf), // v
            intArrayOf(98, 0x116e, 0x3b), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    // 윗글쇠 자리에 겹받침이 들어간 배열.
    @JvmField
    val JAMO_SEBUL_3_2015M_CHOJONG_D =
        arrayOf(
            intArrayOf(49, 0x11ae, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11a9), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x11bd, 0x11ac), // e
            intArrayOf(114, 0x11be, 0x11b6), // r
            intArrayOf(116, 0x1165, 0x1164), // t
            intArrayOf(121, 0x1105, 0x35), // y
            intArrayOf(117, 0x1103, 0x36), // u
            intArrayOf(105, 0x1106, 0x37), // i
            intArrayOf(111, 0x110e, 0x38), // o
            intArrayOf(112, 0x1111, 0x39), // p
            intArrayOf(97, 0x11bc, 0x11b4), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x11c2, 0x11b2), // d
            intArrayOf(102, 0x11c1, 0x11b1), // f
            intArrayOf(103, 0x1173, 0x3a), // g
            intArrayOf(104, 0x1102, 0x30), // h
            intArrayOf(106, 0x110b, 0x31), // j
            intArrayOf(107, 0x1100, 0x32), // k
            intArrayOf(108, 0x110c, 0x33), // l
            intArrayOf(59, 0x1107, 0x34),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x11b7, 0x11b3), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x11c0, 0x116b5), // c
            intArrayOf(118, 0x11bf, 0x11aa), // v
            intArrayOf(98, 0x116e, 0x3b), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMOSET_SEBUL_3_2015M =
        arrayOf(
            JAMO_SEBUL_3_2015M_CHOJUNG,
            JAMO_SEBUL_3_2015M_CHOJUNG,
            JAMO_SEBUL_3_2015M_CHOJONG_D,
            JAMO_SEBUL_3_2015M_CHOJONG,
        )

    @JvmField
    val JAMO_SEBUL_3_2015_CHOJONG =
        arrayOf(
            intArrayOf(49, 0x11ae, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11a9), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x11bd, 0x1167), // e
            intArrayOf(114, 0x11be, 0x1165), // r
            intArrayOf(116, 0x1162, 0x1164), // t
            intArrayOf(121, 0x1105, 0x35), // y
            intArrayOf(117, 0x1103, 0x36), // u
            intArrayOf(105, 0x1106, 0x37), // i
            intArrayOf(111, 0x110e, 0x38), // o
            intArrayOf(112, 0x1111, 0x39), // p
            intArrayOf(97, 0x11bc, 0x11b4), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x11c2, 0x1175), // d
            intArrayOf(102, 0x11c1, 0x1161), // f
            intArrayOf(103, 0x1173, 0x3a), // g
            intArrayOf(104, 0x1102, 0x30), // h
            intArrayOf(106, 0x110b, 0x31), // j
            intArrayOf(107, 0x1100, 0x32), // k
            intArrayOf(108, 0x110c, 0x33), // l
            intArrayOf(59, 0x1107, 0x34),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x11b7, 0x11b3), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x11c0, 0x1166), // c
            intArrayOf(118, 0x11bf, 0x1169), // v
            intArrayOf(98, 0x116e, 0x3b), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_3_2015_CHOJUNG =
        arrayOf(
            intArrayOf(49, 0x11ae, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11a9), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x1167, 0x11bd), // e
            intArrayOf(114, 0x1165, 0x11be), // r
            intArrayOf(116, 0x1162, 0x1164), // t
            intArrayOf(121, 0x1105, 0x0035), // y
            intArrayOf(117, 0x1103, 0x0036), // u
            intArrayOf(105, 0x1106, 0x0037), // i
            intArrayOf(111, 0x110e, 0x0038), // o
            intArrayOf(112, 0x1111, 0x0039), // p
            intArrayOf(97, 0x11bc, 0x11b4), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x1175, 0x11c2), // d
            intArrayOf(102, 0x1161, 0x11c1), // f
            intArrayOf(103, 0x1173, 0x3a), // g
            intArrayOf(104, 0x1102, 0x30), // h
            intArrayOf(106, 0x110b, 0x31), // j
            intArrayOf(107, 0x1100, 0x32), // k
            intArrayOf(108, 0x110c, 0x33), // l
            intArrayOf(59, 0x1107, 0x34),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x11b7, 0x11b3), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x1166, 0x11c0), // c
            intArrayOf(118, 0x1169, 0x11bf), // v
            intArrayOf(98, 0x116e, 0x3b), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    // 윗글쇠에 겹받침이 있는 배열.
    @JvmField
    val JAMO_SEBUL_3_2015_CHOJONG_D =
        arrayOf(
            intArrayOf(49, 0x11ae, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11a9), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x11bd, 0x11ac), // e
            intArrayOf(114, 0x11be, 0x11b6), // r
            intArrayOf(116, 0x1162, 0x1164), // t
            intArrayOf(121, 0x1105, 0x35), // y
            intArrayOf(117, 0x1103, 0x36), // u
            intArrayOf(105, 0x1106, 0x37), // i
            intArrayOf(111, 0x110e, 0x38), // o
            intArrayOf(112, 0x1111, 0x39), // p
            intArrayOf(97, 0x11bc, 0x11b4), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x11c2, 0x11b2), // d
            intArrayOf(102, 0x11c1, 0x11b1), // f
            intArrayOf(103, 0x1173, 0x3a), // g
            intArrayOf(104, 0x1102, 0x30), // h
            intArrayOf(106, 0x110b, 0x31), // j
            intArrayOf(107, 0x1100, 0x32), // k
            intArrayOf(108, 0x110c, 0x33), // l
            intArrayOf(59, 0x1107, 0x34),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x11b7, 0x11b3), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x11c0, 0x11b5), // c
            intArrayOf(118, 0x11bf, 0x11aa), // v
            intArrayOf(98, 0x116e, 0x3b), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMOSET_SEBUL_3_2015 =
        arrayOf(
            JAMO_SEBUL_3_2015_CHOJUNG,
            JAMO_SEBUL_3_2015_CHOJUNG,
            JAMO_SEBUL_3_2015_CHOJONG_D,
            JAMO_SEBUL_3_2015_CHOJONG,
        )

    @JvmField
    val JAMO_SEBUL_3_2015Y =
        arrayOf(
            intArrayOf(49, 0x11c2, 0x11f9),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11eb), // q
            intArrayOf(119, 0x11af, 0x11af), // w
            intArrayOf(101, 0x1167, 0x11bd), // e
            intArrayOf(114, 0x1165, 0x11be), // r
            intArrayOf(116, 0x1162, 0x1164), // t
            intArrayOf(121, 0x1105, 0x302f), // y
            intArrayOf(117, 0x1103, 0x302e), // u
            intArrayOf(105, 0x1106, 0x1154), // i
            intArrayOf(111, 0x110e, 0x1155), // o
            intArrayOf(112, 0x1111, 0x3b), // p
            intArrayOf(129, 0x27, 0x22),
            intArrayOf(91, 0x5b, 0x27),
            intArrayOf(93, 0x5d, 0x22),
            intArrayOf(97, 0x11bc, 0x11f0), // a
            intArrayOf(115, 0x11ab, 0x11ab), // s
            intArrayOf(100, 0x1175, 0x11ae), // d
            intArrayOf(102, 0x1161, 0x11c1), // f
            intArrayOf(103, 0x1173, 0x119e), // g
            intArrayOf(104, 0x1102, 0xb7), // h
            intArrayOf(106, 0x110b, 0x114c), // j
            intArrayOf(107, 0x1100, 0x114e), // k
            intArrayOf(108, 0x110c, 0x1150), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x11b7, 0x11b7), // z
            intArrayOf(120, 0x11a8, 0x11a8), // x
            intArrayOf(99, 0x1166, 0x11c0), // c
            intArrayOf(118, 0x1169, 0x11bf), // v
            intArrayOf(98, 0x116e, 0x0021), // b
            intArrayOf(110, 0x1109, 0x1140), // n
            intArrayOf(109, 0x1112, 0x1159), // m
            intArrayOf(44, 0x2c, 0x113c),
            intArrayOf(46, 0x2e, 0x113e),
            intArrayOf(47, 0x1169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val COMB_SEBUL_3_2015 =
        arrayOf(
            intArrayOf(0x1100, 0x110b, 0x1101), // ㄱ + ㅇ = ㄲ
            intArrayOf(0x1100, 0x110c, 0x110d), // ㄱ + ㅈ = ㅉ
            intArrayOf(0x1103, 0x1106, 0x1104), // ㄷ + ㅁ = ㄸ
            intArrayOf(0x1106, 0x1103, 0x1104), // ㅁ + ㄷ = ㄸ
            intArrayOf(0x1107, 0x110c, 0x1108), // ㅂ + ㅈ = ㅃ
            intArrayOf(0x1109, 0x1112, 0x110a), // ㅅ + ㅎ = ㅆ
            intArrayOf(0x110b, 0x1100, 0x1101), // ㅇ + ㄱ = ㄲ
            intArrayOf(0x110c, 0x1100, 0x110d), // ㅈ + ㄱ = ㅉ
            intArrayOf(0x110c, 0x1107, 0x1108), // ㅈ + ㅂ = ㅃ
            intArrayOf(0x1112, 0x1109, 0x110a), // ㅎ + ㅅ = ㅆ
            intArrayOf(0x1162, 0x1162, 0x1164), // ㅐ + ㅐ = ㅒ
            intArrayOf(0x1165, 0x1165, 0x1164), // ㅓ + ㅓ = ㅒ
            intArrayOf(0x1175, 0x1162, 0x1164), // ㅣ + ㅐ = ㅒ
            intArrayOf(0x11a8, 0x11af, 0x11b0), // ㄱ + ㄹ = ㄺ
            intArrayOf(0x11a8, 0x11b7, 0x11a9), // ㄱ + ㅁ = ㄲ
            intArrayOf(0x11b7, 0x11a8, 0x11a9), // ㅁ + ㄱ = ㄲ
            intArrayOf(0x11b7, 0x11af, 0x11b1), // ㅁ + ㄹ = ㄻ
            intArrayOf(0x11b8, 0x11af, 0x11b2), // ㅂ + ㄹ = ㄼ
            intArrayOf(0x11ba, 0x11a8, 0x11aa), // ㅅ + ㄱ = ㄳ
            intArrayOf(0x11ba, 0x11af, 0x11b3), // ㅅ + ㄹ = ㄽ
            intArrayOf(0x11ba, 0x11b8, 0x11b9), // ㅅ + ㅂ = ㅄ
            intArrayOf(0x11bd, 0x11ab, 0x11ac), // ㅈ + ㄴ = ㄵ
            intArrayOf(0x11c0, 0x11af, 0x11b4), // ㅌ + ㄹ = ㄾ
            intArrayOf(0x11c1, 0x11af, 0x11b5), // ㅍ + ㄹ = ㄿ
            intArrayOf(0x11c2, 0x11ab, 0x11ad), // ㅎ + ㄴ = ㄶ
            intArrayOf(0x11c2, 0x11af, 0x11b6), // ㅎ + ㄹ = ㅀ
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
            // 가상 낱자 조합
            intArrayOf(0x011169, 0x1161, 0x116a),	// ㅘ
            intArrayOf(0x011169, 0x1162, 0x116b),	// ㅙ
            intArrayOf(0x011169, 0x1175, 0x116c),	// ㅚ
            intArrayOf(0x01116e, 0x1165, 0x116f),	// ㅝ
            intArrayOf(0x01116e, 0x1166, 0x1170),	// ㅞ
            intArrayOf(0x01116e, 0x1175, 0x1171),	// ㅟ
            intArrayOf(0x1173, 0x1175, 0x1174),	// ㅢ
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
    val JAMO_SEBUL_3_P3_CHOJONG =
        arrayOf(
            intArrayOf(49, 0x11bf, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x011173, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11b6), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x11c0, 0x1167), // e
            intArrayOf(114, 0x11be, 0x1165), // r
            intArrayOf(116, 0x1162, 0x1164), // t
            intArrayOf(121, 0x1105, 0x2f), // y
            intArrayOf(117, 0x1103, 0x37), // u
            intArrayOf(105, 0x1106, 0x38), // i
            intArrayOf(111, 0x110e, 0x39), // o
            intArrayOf(112, 0x1111, 0x3b), // p
            intArrayOf(97, 0x11bc, 0x11b9), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x11c2, 0x1175), // d
            intArrayOf(102, 0x11c1, 0x1161), // f
            intArrayOf(103, 0x1173, 0x3c), // g
            intArrayOf(104, 0x1102, 0x27), // h
            intArrayOf(106, 0x110b, 0x34), // j
            intArrayOf(107, 0x1100, 0x35), // k
            intArrayOf(108, 0x110c, 0x36), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x11b7, 0x11b1), // z
            intArrayOf(120, 0x11a8, 0x11a9), // x
            intArrayOf(99, 0x11ae, 0x1166), // c
            intArrayOf(118, 0x11bd, 0x1169), // v
            intArrayOf(98, 0x116e, 0x3e), // b
            intArrayOf(110, 0x1109, 0x30), // n
            intArrayOf(109, 0x1112, 0x31), // m
            intArrayOf(44, 0x2c, 0x32),
            intArrayOf(46, 0x2e, 0x33),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_3_P3_CHOJUNG =
        arrayOf(
            intArrayOf(49, 0x11bf, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x011173, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11b6), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x1167, 0x11c0), // e
            intArrayOf(114, 0x1165, 0x11be), // r
            intArrayOf(116, 0x1162, 0x1164), // t
            intArrayOf(121, 0x1105, 0x2f), // y
            intArrayOf(117, 0x1103, 0x37), // u
            intArrayOf(105, 0x1106, 0x38), // i
            intArrayOf(111, 0x110e, 0x39), // o
            intArrayOf(112, 0x1111, 0x3b), // p
            intArrayOf(97, 0x11bc, 0x11b9), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x1175, 0x11c2), // d
            intArrayOf(102, 0x1161, 0x11c1), // f
            intArrayOf(103, 0x1173, 0x3c), // g
            intArrayOf(104, 0x1102, 0x27), // h
            intArrayOf(106, 0x110b, 0x34), // j
            intArrayOf(107, 0x1100, 0x35), // k
            intArrayOf(108, 0x110c, 0x36), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x11b7, 0x11b1), // z
            intArrayOf(120, 0x11a8, 0x11a9), // x
            intArrayOf(99, 0x1166, 0x11ae), // c
            intArrayOf(118, 0x1169, 0x11bd), // v
            intArrayOf(98, 0x116e, 0x3e), // b
            intArrayOf(110, 0x1109, 0x30), // n
            intArrayOf(109, 0x1112, 0x31), // m
            intArrayOf(44, 0x2c, 0x32),
            intArrayOf(46, 0x2e, 0x33),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )
	
    // 윗글쇠 자리에 겹받침이 들어간 배열.
    @JvmField
    val JAMO_SEBUL_3_P3_CHOJONG_D =
        arrayOf(
            intArrayOf(49, 0x11bf, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x011173, 0x2a),
            intArrayOf(57, 0x01116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11b6), // q
            intArrayOf(119, 0x11af, 0x11b0), // w
            intArrayOf(101, 0x11c0, 0x11b4), // e
            intArrayOf(114, 0x11be, 0x11b3), // r
            intArrayOf(116, 0x1162, 0x1164), // t
            intArrayOf(121, 0x1105, 0x2f), // y
            intArrayOf(117, 0x1103, 0x37), // u
            intArrayOf(105, 0x1106, 0x38), // i
            intArrayOf(111, 0x110e, 0x39), // o
            intArrayOf(112, 0x1111, 0x3b), // p
            intArrayOf(97, 0x11bc, 0x11b9), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x11c2, 0x11b2), // d
            intArrayOf(102, 0x11c1, 0x11b5), // f
            intArrayOf(103, 0x1173, 0x3c), // g
            intArrayOf(104, 0x1102, 0x27), // h
            intArrayOf(106, 0x110b, 0x34), // j
            intArrayOf(107, 0x1100, 0x35), // k
            intArrayOf(108, 0x110c, 0x36), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x11b7, 0x11b1), // z
            intArrayOf(120, 0x11a8, 0x11a9), // x
            intArrayOf(99, 0x11ae, 0x11aa), // c
            intArrayOf(118, 0x11bd, 0x11ac), // v
            intArrayOf(98, 0x116e, 0x3e), // b
            intArrayOf(110, 0x1109, 0x30), // n
            intArrayOf(109, 0x1112, 0x31), // m
            intArrayOf(44, 0x2c, 0x32),
            intArrayOf(46, 0x2e, 0x33),
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMOSET_SEBUL_3_P3 =
        arrayOf(
            JAMO_SEBUL_3_P3_CHOJUNG,
            JAMO_SEBUL_3_P3_CHOJUNG,
            JAMO_SEBUL_3_P3_CHOJONG_D,
            JAMO_SEBUL_3_P3_CHOJONG,
        )

    @JvmField
    val COMB_SEBUL_3_P3 =
        arrayOf(
            intArrayOf(0x1162, 0x1162, 0x1164), // ㅐ + ㅐ = ㅒ
            intArrayOf(0x1175, 0x1162, 0x1164), // ㅣ + ㅐ = ㅒ
            intArrayOf(0x11a8, 0x11af, 0x11b0), // ㄱ + ㄹ = ㄺ
            intArrayOf(0x11b7, 0x11af, 0x11b1), // ㅁ + ㄹ = ㄻ
            intArrayOf(0x11b8, 0x11af, 0x11b2), // ㅂ + ㄹ = ㄼ
            intArrayOf(0x11ba, 0x11a8, 0x11aa), // ㅅ + ㄱ = ㄳ
            intArrayOf(0x11ba, 0x11af, 0x11b3), // ㅅ + ㄹ = ㄽ
            intArrayOf(0x11ba, 0x11b8, 0x11b9), // ㅅ + ㅂ = ㅄ
            intArrayOf(0x11bd, 0x11ab, 0x11ac), // ㅈ + ㄴ = ㄵ
            intArrayOf(0x11c0, 0x11af, 0x11b4), // ㅌ + ㄹ = ㄾ
            intArrayOf(0x11c1, 0x11af, 0x11b5), // ㅍ + ㄹ = ㄿ
            intArrayOf(0x11c2, 0x11ab, 0x11ad), // ㅎ + ㄴ = ㄶ
            intArrayOf(0x11c2, 0x11af, 0x11b6), // ㅎ + ㄹ = ㅀ
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
            // 가상 낱자 조합
            intArrayOf(0x011169, 0x1161, 0x116a),	// ㅘ
            intArrayOf(0x011169, 0x1162, 0x116b),	// ㅙ
            intArrayOf(0x011169, 0x1175, 0x116c),	// ㅚ
            intArrayOf(0x01116e, 0x1165, 0x116f),	// ㅝ
            intArrayOf(0x01116e, 0x1166, 0x1170),	// ㅞ
            intArrayOf(0x01116e, 0x1175, 0x1171),	// ㅟ
            intArrayOf(0x011173, 0x1175, 0x1174),	// ㅢ
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
    val JAMO_SEBUL_SHIN_ORIGINAL_CHOJONG =
        arrayOf(
            intArrayOf(113, 0x11ba, 0x1174), // q
            intArrayOf(119, 0x11af, 0x1163), // w
            intArrayOf(101, 0x11b8, 0x1167), // e
            intArrayOf(114, 0x11ae, 0x1162), // r
            intArrayOf(116, 0x11c0, 0x1165), // t
            intArrayOf(121, 0x1105, 0x1105), // y
            intArrayOf(117, 0x1103, 0x1103), // u
            intArrayOf(105, 0x1106, 0x01116e), // i
            intArrayOf(111, 0x110e, 0x01116e), // o
            intArrayOf(112, 0x1111, 0x011169), // p
            intArrayOf(97, 0x11bc, 0x1164), // a
            intArrayOf(115, 0x11ab, 0x1168), // s
            intArrayOf(100, 0x11c2, 0x1175), // d
            intArrayOf(102, 0x11bd, 0x1161), // f
            intArrayOf(103, 0x11c1, 0x1173), // g
            intArrayOf(104, 0x1102, 0x1102), // h
            intArrayOf(106, 0x110b, 0x3b), // j
            intArrayOf(107, 0x1100, 0x27), // k
            intArrayOf(108, 0x110c, 0x110c), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x11b7, 0x1172), // z
            intArrayOf(120, 0x11a8, 0x116d), // x
            intArrayOf(99, 0x11be, 0x1166), // c
            intArrayOf(118, 0x11bf, 0x1169), // v
            intArrayOf(98, 0x11bb, 0x116e), // b
            intArrayOf(110, 0x1109, 0x1109), // n
            intArrayOf(109, 0x1112, 0x2f), // m
            intArrayOf(47, 0x110f, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_SHIN_ORIGINAL_CHOJUNG =
        arrayOf(
            intArrayOf(113, 0x1174, 0x11ba), // q
            intArrayOf(119, 0x1163, 0x11af), // w
            intArrayOf(101, 0x1167, 0x11b8), // e
            intArrayOf(114, 0x1162, 0x11ae), // r
            intArrayOf(116, 0x1165, 0x11c0), // t
            intArrayOf(121, 0x1105, 0x1105), // y
            intArrayOf(117, 0x1103, 0x1103), // u
            intArrayOf(105, 0x01116e, 0x1106), // i
            intArrayOf(111, 0x01116e, 0x110e), // o
            intArrayOf(112, 0x011169, 0x1111), // p
            intArrayOf(97, 0x1164, 0x11bc), // a
            intArrayOf(115, 0x1168, 0x11ab), // s
            intArrayOf(100, 0x1175, 0x11c2), // d
            intArrayOf(102, 0x1161, 0x11bd), // f
            intArrayOf(103, 0x1173, 0x11c1), // g
            intArrayOf(104, 0x1102, 0x1102), // h
            intArrayOf(106, 0x110b, 0x3b), // j
            intArrayOf(107, 0x1100, 0x27), // k
            intArrayOf(108, 0x110c, 0x110c), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x1172, 0x11b7), // z
            intArrayOf(120, 0x116d, 0x11a8), // x
            intArrayOf(99, 0x1166, 0x11be), // c
            intArrayOf(118, 0x1169, 0x11bf), // v
            intArrayOf(98, 0x116e, 0x11bb), // b
            intArrayOf(110, 0x1109, 0x1109), // n
            intArrayOf(109, 0x1112, 0x2f), // m
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMOSET_SHIN_ORIGINAL =
        arrayOf(
            JAMO_SEBUL_SHIN_ORIGINAL_CHOJONG,
            JAMO_SEBUL_SHIN_ORIGINAL_CHOJUNG,
            JAMO_SEBUL_SHIN_ORIGINAL_CHOJONG,
            JAMO_SEBUL_SHIN_ORIGINAL_CHOJONG,
        )

    @JvmField
    val COMB_SEBUL_SHIN_ORIGINAL =
        arrayOf(
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
            // 가상 낱자 조합
            intArrayOf(0x011169, 0x1161, 0x116a),	// ㅘ
            intArrayOf(0x011169, 0x1162, 0x116b),	// ㅙ
            intArrayOf(0x011169, 0x1175, 0x116c),	// ㅚ
            intArrayOf(0x01116e, 0x1165, 0x116f),	// ㅝ
            intArrayOf(0x01116e, 0x1166, 0x1170),	// ㅞ
            intArrayOf(0x01116e, 0x1175, 0x1171),	// ㅟ
            intArrayOf(0x011173, 0x1175, 0x1174),	// ㅢ
            intArrayOf(0x01119e, 0x1175, 0x11a1),	// ㆎ
            intArrayOf(0x01119e, 0x119e, 0x11a2),	// ᆢㆎ
            intArrayOf(0x01119e, 0x01119e, 0x11a2),	// ᆢ
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
    val JAMO_SEBUL_SHIN_EDIT_CHOJONG =
        arrayOf(
            intArrayOf(113, 0x11ba, 0x1164), // q
            intArrayOf(119, 0x11af, 0x1163), // w
            intArrayOf(101, 0x11b8, 0x1167), // e
            intArrayOf(114, 0x11c0, 0x1162), // r
            intArrayOf(116, 0x11c1, 0x1165), // t
            intArrayOf(121, 0x1105, 0x201c), // y
            intArrayOf(117, 0x1103, 0x201d), // u
            intArrayOf(105, 0x1106, 0x1174), // i
            intArrayOf(111, 0x110e, 0x01116e), // o
            intArrayOf(112, 0x1111, 0x011169), // p
            intArrayOf(97, 0x11bc, 0x1172), // a
            intArrayOf(115, 0x11ab, 0x1168), // s
            intArrayOf(100, 0x11ae, 0x1175), // d
            intArrayOf(102, 0x11bb, 0x1161), // f
            intArrayOf(103, 0x11bd, 0x1173), // g
            intArrayOf(104, 0x1102, 0x2018), // h
            intArrayOf(106, 0x110b, 0x2019), // j
            intArrayOf(107, 0x1100, 0x3b), // k
            intArrayOf(108, 0x110c, 0x27), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x11b7, 0x203b), // z
            intArrayOf(120, 0x11a8, 0x116d), // x
            intArrayOf(99, 0x11be, 0x1166), // c
            intArrayOf(118, 0x11c2, 0x1169), // v
            intArrayOf(98, 0x11bf, 0x116e), // b
            intArrayOf(110, 0x1109, 0x00b7), // n
            intArrayOf(109, 0x1112, 0x2f), // m
            intArrayOf(47, 0x110f, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_SHIN_EDIT_CHOJUNG =
        arrayOf(
            intArrayOf(113, 0x1164, 0x11ba), // q
            intArrayOf(119, 0x1163, 0x11af), // w
            intArrayOf(101, 0x1167, 0x11b8), // e
            intArrayOf(114, 0x1162, 0x11c0), // r
            intArrayOf(116, 0x1165, 0x11c1), // t
            intArrayOf(121, 0x1105, 0x201c), // y
            intArrayOf(117, 0x1103, 0x201d), // u
            intArrayOf(105, 0x1174, 0x1106), // i
            intArrayOf(111, 0x01116e, 0x110e), // o
            intArrayOf(112, 0x011169, 0x1111), // p
            intArrayOf(97, 0x1172, 0x11bc), // a
            intArrayOf(115, 0x1168, 0x11ab), // s
            intArrayOf(100, 0x1175, 0x11ae), // d
            intArrayOf(102, 0x1161, 0x11bb), // f
            intArrayOf(103, 0x1173, 0x11bd), // g
            intArrayOf(104, 0x1102, 0x2018), // h
            intArrayOf(106, 0x110b, 0x2019), // j
            intArrayOf(107, 0x1100, 0x3b), // k
            intArrayOf(108, 0x110c, 0x27), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x203b, 0x11b7), // z
            intArrayOf(120, 0x116d, 0x11a8), // x
            intArrayOf(99, 0x1166, 0x11be), // c
            intArrayOf(118, 0x1169, 0x11c2), // v
            intArrayOf(98, 0x116e, 0x11bf), // b
            intArrayOf(110, 0x1109, 0x00b7), // n
            intArrayOf(109, 0x1112, 0x2f), // m
            intArrayOf(47, 0x011169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMOSET_SHIN_EDIT =
        arrayOf(
            JAMO_SEBUL_SHIN_EDIT_CHOJONG,
            JAMO_SEBUL_SHIN_EDIT_CHOJUNG,
            JAMO_SEBUL_SHIN_EDIT_CHOJONG,
            JAMO_SEBUL_SHIN_EDIT_CHOJONG,
        )

    @JvmField
    val JAMO_SEBUL_SHIN_M_CHOJONG =
        arrayOf(
            intArrayOf(113, 0x11ba, 0x1164), // q
            intArrayOf(119, 0x11af, 0x1163), // w
            intArrayOf(101, 0x11b8, 0x1167), // e
            intArrayOf(114, 0x11bd, 0x1162), // r
            intArrayOf(116, 0x11bf, 0x1165), // t
            intArrayOf(121, 0x1105, 0x201c), // y
            intArrayOf(117, 0x1103, 0x201d), // u
            intArrayOf(105, 0x1106, 0x203b), // i
            intArrayOf(111, 0x110e, 0x01116e), // o
            intArrayOf(112, 0x1111, 0x011169), // p
            intArrayOf(97, 0x11bc, 0x1172), // a
            intArrayOf(115, 0x11ab, 0x1174), // s
            intArrayOf(100, 0x11bb, 0x1175), // d
            intArrayOf(102, 0x11c0, 0x1161), // f
            intArrayOf(103, 0x11ae, 0x1173), // g
            intArrayOf(104, 0x1102, 0x300a), // h
            intArrayOf(106, 0x110b, 0x300b), // j
            intArrayOf(107, 0x1100, 0xb7), // k
            intArrayOf(108, 0x110c, 0x3b), // l
            intArrayOf(59, 0x1107, 0x3a), // ;
            intArrayOf(39, 0x1110, 0x2f), // '
            intArrayOf(122, 0x11b7, 0x1168), // z
            intArrayOf(120, 0x11a8, 0x116d), // x
            intArrayOf(99, 0x11c2, 0x1166), // c
            intArrayOf(118, 0x11c1, 0x1169), // v
            intArrayOf(98, 0x11be, 0x116e), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c), // ,
            intArrayOf(46, 0x2e, 0x3e), // .
            intArrayOf(47, 0x110f, 0x3f), // /
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_SHIN_M_CHOJUNG =
        arrayOf(
            intArrayOf(113, 0x1164, 0x11ba), // q
            intArrayOf(119, 0x1163, 0x11af), // w
            intArrayOf(101, 0x1167, 0x11b8), // e
            intArrayOf(114, 0x1162, 0x11bd), // r
            intArrayOf(116, 0x1165, 0x11bf), // t
            intArrayOf(121, 0x1105, 0x201c), // y
            intArrayOf(117, 0x1103, 0x201d), // u
            intArrayOf(105, 0x1106, 0x203b), // i
            intArrayOf(111, 0x110e, 0x110e), // o
            intArrayOf(112, 0x1111, 0x1111), // p
            intArrayOf(97, 0x1172, 0x11bc), // a
            intArrayOf(115, 0x1174, 0x11ab), // s
            intArrayOf(100, 0x1175, 0x11bb), // d
            intArrayOf(102, 0x1161, 0x11c0), // f
            intArrayOf(103, 0x1173, 0x11ae), // g
            intArrayOf(104, 0x1102, 0x300a), // h
            intArrayOf(106, 0x110b, 0x300b), // j
            intArrayOf(107, 0x1100, 0xb7), // k
            intArrayOf(108, 0x110c, 0x3b), // l
            intArrayOf(59, 0x1107, 0x3a), // ;
            intArrayOf(39, 0x1110, 0x2f), // '
            intArrayOf(122, 0x1168, 0x11b7), // z
            intArrayOf(120, 0x116d, 0x11a8), // x
            intArrayOf(99, 0x1166, 0x11c2), // c
            intArrayOf(118, 0x1169, 0x11c1), // v
            intArrayOf(98, 0x116e, 0x11be), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c), // ,
            intArrayOf(46, 0x2e, 0x3e), // .
            intArrayOf(47, 0x110f, 0x110f), // /
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_SHIN_M_CHODJUNG =
        arrayOf(
            intArrayOf(113, 0x1164, 0x11ba), // q
            intArrayOf(119, 0x1163, 0x11af), // w
            intArrayOf(101, 0x1167, 0x11b8), // e
            intArrayOf(114, 0x1162, 0x11bd), // r
            intArrayOf(116, 0x1165, 0x11bf), // t
            intArrayOf(121, 0x1105, 0x201c), // y
            intArrayOf(117, 0x1103, 0x201d), // u
            intArrayOf(105, 0x1106, 0x203b), // i
            intArrayOf(111, 0x01116e, 0x110e), // o
            intArrayOf(112, 0x011169, 0x1111), // p
            intArrayOf(97, 0x1172, 0x11bc), // a
            intArrayOf(115, 0x1174, 0x11ab), // s
            intArrayOf(100, 0x1175, 0x11bb), // d
            intArrayOf(102, 0x1161, 0x11c0), // f
            intArrayOf(103, 0x1173, 0x11ae), // g
            intArrayOf(104, 0x1102, 0x300a), // h
            intArrayOf(106, 0x110b, 0x300b), // j
            intArrayOf(107, 0x1100, 0xb7), // k
            intArrayOf(108, 0x110c, 0x3b), // l
            intArrayOf(59, 0x1107, 0x3a), // ;
            intArrayOf(39, 0x1110, 0x2f), // '
            intArrayOf(122, 0x1168, 0x11b7), // z
            intArrayOf(120, 0x116d, 0x11a8), // x
            intArrayOf(99, 0x1166, 0x11c2), // c
            intArrayOf(118, 0x1169, 0x11c1), // v
            intArrayOf(98, 0x116e, 0x11be), // b
            intArrayOf(110, 0x1109, 0x27), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c), // ,
            intArrayOf(46, 0x2e, 0x3e), // .
            intArrayOf(47, 0x011169, 0x110f), // /
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMOSET_SHIN_M =
        arrayOf(
            JAMO_SEBUL_SHIN_M_CHOJUNG,
            JAMO_SEBUL_SHIN_M_CHODJUNG,
            JAMO_SEBUL_SHIN_M_CHOJONG,
            JAMO_SEBUL_SHIN_M_CHOJONG,
        )

    @JvmField
    val JAMO_SEBUL_SHIN_P2_CHOJONG =
        arrayOf(
            intArrayOf(113, 0x11ba, 0x1164), // q
            intArrayOf(119, 0x11af, 0x1163), // w
            intArrayOf(101, 0x11b8, 0x1162), // e
            intArrayOf(114, 0x11c0, 0x1165), // r
            intArrayOf(116, 0x11bf, 0x1167), // t
            intArrayOf(121, 0x1105, 0x302f), // y
            intArrayOf(117, 0x1103, 0x302e), // u
            intArrayOf(105, 0x1106, 0x011173), // i
            intArrayOf(111, 0x110e, 0x01116e), // o
            intArrayOf(112, 0x1111, 0x01119e), // p
            intArrayOf(97, 0x11bc, 0x1172), // a
            intArrayOf(115, 0x11ab, 0x1168), // s
            intArrayOf(100, 0x11c2, 0x1175), // d
            intArrayOf(102, 0x11c1, 0x1161), // f
            intArrayOf(103, 0x11ae, 0x1173), // g
            intArrayOf(104, 0x1102, 0x25a1), // h
            intArrayOf(106, 0x110b, 0x27), // j
            intArrayOf(107, 0x1100, 0xb7), // k
            intArrayOf(108, 0x110c, 0x3b), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x11b7, 0x119e), // z
            intArrayOf(120, 0x11bb, 0x116d), // x
            intArrayOf(99, 0x11a8, 0x1166), // c
            intArrayOf(118, 0x11bd, 0x1169), // v
            intArrayOf(98, 0x11be, 0x116e), // b
            intArrayOf(110, 0x1109, 0x2015), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(47, 0x110f, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_SHIN_P2_CHOJUNG =
        arrayOf(
            intArrayOf(113, 0x1164, 0x11ba), // q
            intArrayOf(119, 0x1163, 0x11af), // w
            intArrayOf(101, 0x1162, 0x11b8), // e
            intArrayOf(114, 0x1165, 0x11c0), // r
            intArrayOf(116, 0x1167, 0x11bf), // t
            intArrayOf(121, 0x1105, 0x302f), // y
            intArrayOf(117, 0x1103, 0x302e), // u
            intArrayOf(105, 0x011173, 0x1106), // i
            intArrayOf(111, 0x01116e, 0x110e), // o
            intArrayOf(112, 0x01119e, 0x1111), // p
            intArrayOf(97, 0x1172, 0x11bc), // a
            intArrayOf(115, 0x1168, 0x11ab), // s
            intArrayOf(100, 0x1175, 0x11c2), // d
            intArrayOf(102, 0x1161, 0x11c1), // f
            intArrayOf(103, 0x1173, 0x11ae), // g
            intArrayOf(104, 0x1102, 0x25a1), // h
            intArrayOf(106, 0x110b, 0x27), // j
            intArrayOf(107, 0x1100, 0xb7), // k
            intArrayOf(108, 0x110c, 0x3b), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x2f),
            intArrayOf(122, 0x119e, 0x11b7), // z
            intArrayOf(120, 0x116d, 0x11bb), // x
            intArrayOf(99, 0x1166, 0x11a8), // c
            intArrayOf(118, 0x1169, 0x11bd), // v
            intArrayOf(98, 0x116e, 0x11be), // b
            intArrayOf(110, 0x1109, 0x2015), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x3c),
            intArrayOf(46, 0x2e, 0x3e),
            intArrayOf(47, 0x011169, 0x110f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMOSET_SHIN_P2 =
        arrayOf(
            JAMO_SEBUL_SHIN_P2_CHOJONG,
            JAMO_SEBUL_SHIN_P2_CHOJUNG,
            JAMO_SEBUL_SHIN_P2_CHOJONG,
            JAMO_SEBUL_SHIN_P2_CHOJONG,
        )

    @JvmField
    val JAMO_SEBUL_DANMOEUM =
        arrayOf(
            intArrayOf(97, 0x11bc, 0x11ae), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x1175, 0x11ac), // d
            intArrayOf(102, 0x1161, 0x11b1), // f
            intArrayOf(103, 0x1173, 0x25), // g
            intArrayOf(104, 0x1102, 0x5e), // h
            intArrayOf(106, 0x110b, 0x26), // j
            intArrayOf(107, 0x1100, 0x110f), // k
            intArrayOf(108, 0x110c, 0x110e), // l
            intArrayOf(113, 0x11ba, 0x11c1), // q
            intArrayOf(119, 0x11af, 0x11c0), // w
            intArrayOf(101, 0x11b8, 0x11bd), // e
            intArrayOf(114, 0x1162, 0x23), // r
            intArrayOf(116, 0x1165, 0x3c), // t
            intArrayOf(121, 0x1105, 0x3e), // y
            intArrayOf(117, 0x1103, 0x1110), // u
            intArrayOf(105, 0x1106, 0xb7), // i
            intArrayOf(111, 0x1107, 0x1111), // o
            intArrayOf(112, 0x116e, 0x27), // p
            intArrayOf(122, 0x11b7, 0x11be), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x1166, 0x11bf), // c
            intArrayOf(118, 0x1169, 0x11c2), // v
            intArrayOf(98, 0x116e, 0x3f), // b
            intArrayOf(110, 0x1109, 0x2d), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(36, 0x1169, 0x21), // $
            intArrayOf(0x20ac, 0x21, 0x21),
        )

    @JvmField
    val COMB_SEBUL_DANMOEUM =
        arrayOf(
            intArrayOf(0x1100, 0x1100, 0x1101),	// ㄲ
            intArrayOf(0x1103, 0x1103, 0x1104),	// ㄸ
            intArrayOf(0x1107, 0x1107, 0x1108),	// ㅃ
            intArrayOf(0x1109, 0x1109, 0x110a),	// ㅆ
            intArrayOf(0x110c, 0x110c, 0x110d),	// ㅉ
            intArrayOf(0x1161, 0x1161, 0x1163),	// ㅑ
            intArrayOf(0x1162, 0x1162, 0x1164),	// ㅒ
            intArrayOf(0x1163, 0x1175, 0x1164),	// ㅒ
            intArrayOf(0x1165, 0x1165, 0x1167),	// ㅕ
            intArrayOf(0x1167, 0x1175, 0x1168),	// ㅖ
            intArrayOf(0x1166, 0x1166, 0x1168),	// ㅖ
            intArrayOf(0x1169, 0x1161, 0x116a),	// ㅘ
            intArrayOf(0x1169, 0x1162, 0x116b),	// ㅙ
            intArrayOf(0x1169, 0x1175, 0x116c),	// ㅚ
            intArrayOf(0x1169, 0x1169, 0x116d),	// ㅛ
            intArrayOf(0x116e, 0x1165, 0x116f),	// ㅝ
            intArrayOf(0x116e, 0x1166, 0x1170),	// ㅞ
            intArrayOf(0x116e, 0x1175, 0x1171),	// ㅟ
            intArrayOf(0x116e, 0x116e, 0x1172),	// ㅠ
            intArrayOf(0x1173, 0x1175, 0x1174),	// ㅢ
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
    val JAMO_SEBUL_391 =
        arrayOf(
            intArrayOf(49, 0x11c2, 0x11a9),
            intArrayOf(50, 0x11bb, 0x11b0),
            intArrayOf(51, 0x11b8, 0x11bd),
            intArrayOf(52, 0x116d, 0x11b5),
            intArrayOf(53, 0x1172, 0x11b4),
            intArrayOf(54, 0x1163, 0x3d),
            intArrayOf(55, 0x1168, 0x201c),
            intArrayOf(56, 0x1174, 0x201d),
            intArrayOf(57, 0x116e, 0x27),
            intArrayOf(48, 0x110f, 0x7e),
            intArrayOf(113, 0x11ba, 0x11c1), // q
            intArrayOf(119, 0x11af, 0x11c0), // w
            intArrayOf(101, 0x1167, 0x11ac), // e
            intArrayOf(114, 0x1162, 0x11b6), // r
            intArrayOf(116, 0x1165, 0x11b3), // t
            intArrayOf(121, 0x1105, 0x35), // y
            intArrayOf(117, 0x1103, 0x36), // u
            intArrayOf(105, 0x1106, 0x37), // i
            intArrayOf(111, 0x110e, 0x38), // o
            intArrayOf(112, 0x1111, 0x39), // p
            intArrayOf(40, 0x28, 0x29),
            intArrayOf(97, 0x11bc, 0x11ae), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x1175, 0x11b2), // d
            intArrayOf(102, 0x1161, 0x11b1), // f
            intArrayOf(103, 0x1173, 0x1164), // g
            intArrayOf(104, 0x1102, 0x30), // h
            intArrayOf(106, 0x110b, 0x31), // j
            intArrayOf(107, 0x1100, 0x32), // k
            intArrayOf(108, 0x110c, 0x33), // l
            intArrayOf(59, 0x1107, 0x34),
            intArrayOf(39, 0x1110, 0xb7),
            intArrayOf(122, 0x11b7, 0x11be), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x1166, 0x11bf), // c
            intArrayOf(118, 0x1169, 0x11aa), // v
            intArrayOf(98, 0x116e, 0x3f), // b
            intArrayOf(110, 0x1109, 0x2d), // n
            intArrayOf(109, 0x1112, 0x22), // m
            intArrayOf(44, 0x2c, 0x2c),
            intArrayOf(46, 0x2e, 0x2e),
            intArrayOf(47, 0x1169, 0x21),
            intArrayOf(0x2d, 0x29, 0x3b),
            intArrayOf(0x3d, 0x3e, 0x2b),
            intArrayOf(0x5b, 0x28, 0x25),
            intArrayOf(0x5d, 0x3c, 0x2f),
            intArrayOf(0x5c, 0x3a, 0x5c),
            intArrayOf(0x60, 0x2a, 0x203b),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_390 =
        arrayOf(
            intArrayOf(49, 0x11c2, 0x11bd),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11c1), // q
            intArrayOf(119, 0x11af, 0x11c0), // w
            intArrayOf(101, 0x1167, 0x11bf), // e
            intArrayOf(114, 0x1162, 0x1164), // r
            intArrayOf(116, 0x1165, 0x3b), // t
            intArrayOf(121, 0x1105, 0x3c), // y
            intArrayOf(117, 0x1103, 0x37), // u
            intArrayOf(105, 0x1106, 0x38), // i
            intArrayOf(111, 0x110e, 0x39), // o
            intArrayOf(112, 0x1111, 0x3e), // p
            intArrayOf(40, 0x28, 0x29),
            intArrayOf(97, 0x11bc, 0x11ae), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x1175, 0x11b0), // d
            intArrayOf(102, 0x1161, 0x11a9), // f
            intArrayOf(103, 0x1173, 0x2f), // g
            intArrayOf(104, 0x1102, 0x27), // h
            intArrayOf(106, 0x110b, 0x34), // j
            intArrayOf(107, 0x1100, 0x35), // k
            intArrayOf(108, 0x110c, 0x36), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x11b7, 0x11be), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x1166, 0x11b1), // c
            intArrayOf(118, 0x1169, 0x11b6), // v
            intArrayOf(98, 0x116e, 0x21), // b
            intArrayOf(110, 0x1109, 0x30), // n
            intArrayOf(109, 0x1112, 0x31), // m
            intArrayOf(44, 0x2c, 0x32),
            intArrayOf(46, 0x2e, 0x33),
            intArrayOf(47, 0x1169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val JAMO_SEBUL_393Y =
        arrayOf(
            intArrayOf(96, 0x11f9, 0x11f0),
            intArrayOf(49, 0x11c2, 0x11bd),
            intArrayOf(50, 0x11bb, 0x11eb),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11c1), // q
            intArrayOf(119, 0x11af, 0x11c0), // w
            intArrayOf(101, 0x1167, 0x11bf), // e
            intArrayOf(114, 0x1162, 0x1164), // r
            intArrayOf(116, 0x1165, 0x3b), // t
            intArrayOf(121, 0x1105, 0x302f), // y
            intArrayOf(117, 0x1103, 0x302e), // u
            intArrayOf(105, 0x1106, 0x1154), // i
            intArrayOf(111, 0x110e, 0x1155), // o
            intArrayOf(112, 0x1111, 0xb7), // p
            intArrayOf(40, 0x28, 0x29),
            intArrayOf(97, 0x11bc, 0x11ae), // a
            intArrayOf(115, 0x11ab, 0x11ad), // s
            intArrayOf(100, 0x1175, 0x11b0), // d
            intArrayOf(102, 0x1161, 0x11a9), // f
            intArrayOf(103, 0x1173, 0x119e), // g
            intArrayOf(104, 0x1102, 0x27), // h
            intArrayOf(106, 0x110b, 0x114c), // j
            intArrayOf(107, 0x1100, 0x114e), // k
            intArrayOf(108, 0x110c, 0x1150), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x11b7, 0x11be), // z
            intArrayOf(120, 0x11a8, 0x11b9), // x
            intArrayOf(99, 0x1166, 0x11b1), // c
            intArrayOf(118, 0x1169, 0x11b6), // v
            intArrayOf(98, 0x116e, 0x21), // b
            intArrayOf(110, 0x1109, 0x1140), // n
            intArrayOf(109, 0x1112, 0x1159), // m
            intArrayOf(44, 0x2c, 0x113c),
            intArrayOf(46, 0x2e, 0x113e),
            intArrayOf(47, 0x1169, 0x3f),
        )

    @JvmField
    val JAMO_SEBUL_SUN_2014 =
        arrayOf(
            intArrayOf(49, 0x11c2, 0x21),
            intArrayOf(50, 0x11bb, 0x40),
            intArrayOf(51, 0x11b8, 0x23),
            intArrayOf(52, 0x116d, 0x24),
            intArrayOf(53, 0x1172, 0x25),
            intArrayOf(54, 0x1163, 0x5e),
            intArrayOf(55, 0x1168, 0x26),
            intArrayOf(56, 0x1174, 0x2a),
            intArrayOf(57, 0x116e, 0x28),
            intArrayOf(48, 0x110f, 0x29),
            intArrayOf(113, 0x11ba, 0x11bd), // q
            intArrayOf(119, 0x11af, 0x11be), // w
            intArrayOf(101, 0x1167, 0x1167), // e
            intArrayOf(114, 0x1162, 0x1164), // r
            intArrayOf(116, 0x1165, 0x3b), // t
            intArrayOf(121, 0x1105, 0x3c), // y
            intArrayOf(117, 0x1103, 0x37), // u
            intArrayOf(105, 0x1106, 0x38), // i
            intArrayOf(111, 0x110e, 0x39), // o
            intArrayOf(112, 0x1111, 0x3e), // p
            intArrayOf(40, 0x28, 0x29),
            intArrayOf(97, 0x11bc, 0x11ae), // a
            intArrayOf(115, 0x11ab, 0x11c0), // s
            intArrayOf(100, 0x1175, 0x1175), // d
            intArrayOf(102, 0x1161, 0x1161), // f
            intArrayOf(103, 0x1173, 0x2f), // g
            intArrayOf(104, 0x1102, 0x27), // h
            intArrayOf(106, 0x110b, 0x34), // j
            intArrayOf(107, 0x1100, 0x35), // k
            intArrayOf(108, 0x110c, 0x36), // l
            intArrayOf(59, 0x1107, 0x3a),
            intArrayOf(39, 0x1110, 0x22),
            intArrayOf(122, 0x11b7, 0x11c1), // z
            intArrayOf(120, 0x11a8, 0x11bf), // x
            intArrayOf(99, 0x1166, 0x1166), // c
            intArrayOf(118, 0x1169, 0x1169), // v
            intArrayOf(98, 0x116e, 0x116e), // b
            intArrayOf(110, 0x1109, 0x30), // n
            intArrayOf(109, 0x1112, 0x31), // m
            intArrayOf(44, 0x2c, 0x32),
            intArrayOf(46, 0x2e, 0x33),
            intArrayOf(47, 0x1169, 0x3f),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val COMB_SEBUL_SUN_2014 =
        arrayOf(
            intArrayOf(0x1162, 0x1162, 0x1164), // ㅐ + ㅐ = ㅒ
            intArrayOf(0x11a9, 0x11a8, 0x11bf), // ㄲ + ㄱ = ㅋ
            intArrayOf(0x11ab, 0x11ab, 0x11c0), // ㄴ + ㄴ = ㅌ
            intArrayOf(0x11ab, 0x11ba, 0x11ac), // ㄴ + ㅅ = ㄵ
            intArrayOf(0x11af, 0x11ab, 0x11b4), // ㄹ + ㄴ = ㄾ
            intArrayOf(0x11af, 0x11af, 0x11be), // ㄹ + ㄹ = ㅊ
            intArrayOf(0x11b1, 0x11b7, 0x11b5), // ㄻ + ㅁ = ㄿ
            intArrayOf(0x11b7, 0x11b7, 0x11c1), // ㅁ + ㅁ = ㅍ
            intArrayOf(0x11ba, 0x11ba, 0x11bd), // ㅅ + ㅅ = ㅈ
            intArrayOf(0x11bc, 0x11bc, 0x11ae), // ㅇ + ㅇ = ㄷ
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
    val COMB_SEBULSIK =
        arrayOf(
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
    val COMB_FULL =
        arrayOf(
            intArrayOf(0x1100, 0x1100, 0x1101), // choseong kiyeok + kiyeok          = ssangkiyeok
            intArrayOf(0x1100, 0x1103, 0x115a), // choseong kiyeok + tikeut          = kiyeok-tikeut
            intArrayOf(0x1102, 0x1100, 0x1113), // choseong nieun + kiyeok           = nieun-kiyeok
            intArrayOf(0x1102, 0x1102, 0x1114), // choseong nieun + nieun            = ssangnieun
            intArrayOf(0x1102, 0x1103, 0x1115), // choseong nieun + tikeut           = nieun-tikeut
            intArrayOf(0x1102, 0x1107, 0x1116), // choseong nieun + pieup            = nieun-pieup
            intArrayOf(0x1102, 0x1109, 0x115b), // choseong nieun + sios             = nieun-sios
            intArrayOf(0x1102, 0x110c, 0x115c), // choseong nieun + cieuc            = nieun-cieuc
            intArrayOf(0x1102, 0x1112, 0x115d), // choseong nieun + hieuh            = nieun-hieuh
            intArrayOf(0x1103, 0x1100, 0x1117), // choseong tikeut + kiyeok          = tikeut-kiyeok
            intArrayOf(0x1103, 0x1103, 0x1104), // choseong tikeut + tikeut          = ssangtikeut
            intArrayOf(0x1103, 0x1105, 0x115e), // choseong tikeut + rieul           = tikeut-rieul
            intArrayOf(0x1103, 0x1106, 0xa960), // choseong tikeut + mieum           = tikeut-mieum
            intArrayOf(0x1103, 0x1107, 0xa961), // choseong tikeut + pieup           = tikeut-pieup
            intArrayOf(0x1103, 0x1109, 0xa962), // choseong tikeut + sios            = tikeut-sios
            intArrayOf(0x1103, 0x110c, 0xa963), // choseong tikeut + cieuc           = tikeut-cieuc
            intArrayOf(0x1105, 0x1100, 0xa964), // choseong rieul + kiyeok           = rieul-kiyeok
            intArrayOf(0x1105, 0x1101, 0xa965), // choseong rieul + ssangkiyeok      = rieul-ssangkiyeok
            intArrayOf(0x1105, 0x1102, 0x1118), // choseong rieul + nieun            = rieul-nieun
            intArrayOf(0x1105, 0x1103, 0xa966), // choseong rieul + tikeut           = rieul-tikeut
            intArrayOf(0x1105, 0x1104, 0xa967), // choseong rieul + ssangtikeut      = rieul-ssangtikeut
            intArrayOf(0x1105, 0x1105, 0x1119), // choseong rieul + rieul            = ssangrieul
            intArrayOf(0x1105, 0x1106, 0xa968), // choseong rieul + mieum            = rieul-mieum
            intArrayOf(0x1105, 0x1107, 0xa969), // choseong rieul + pieup            = rieul-pieup
            intArrayOf(0x1105, 0x1108, 0xa96a), // choseong rieul + ssangpieup       = rieul-ssangpieup
            intArrayOf(0x1105, 0x1109, 0xa96c), // choseong rieul + sios             = rieul-sios
            intArrayOf(0x1105, 0x110b, 0x111b), // choseong rieul + ieung            = kapyeounrieul
            intArrayOf(0x1105, 0x110c, 0xa96d), // choseong rieul + cieuc            = rieul-cieuc
            intArrayOf(0x1105, 0x110f, 0xa96e), // choseong rieul + khieukh          = rieul-khieukh
            intArrayOf(0x1105, 0x1112, 0x111a), // choseong rieul + hieuh            = rieul-hieuh
            intArrayOf(0x1105, 0x112b, 0xa96b), // choseong rieul + kapyeounpieup    = rieul-kapyeounpieup
            intArrayOf(0x1106, 0x1100, 0xa96f), // choseong mieum + kiyeok           = mieum-kiyeok
            intArrayOf(0x1106, 0x1103, 0xa970), // choseong mieum + tikeut           = mieum-tikeut
            intArrayOf(0x1106, 0x1107, 0x111c), // choseong mieum + pieup            = mieum-pieup
            intArrayOf(0x1106, 0x1109, 0xa971), // choseong mieum + sios             = mieum-sios
            intArrayOf(0x1106, 0x110b, 0x111d), // choseong mieum + ieung            = kapyeounmieum
            intArrayOf(0x1107, 0x1100, 0x111e), // choseong pieup + kiyeok           = pieup-kiyeok
            intArrayOf(0x1107, 0x1102, 0x111f), // choseong pieup + nieun            = pieup-nieun
            intArrayOf(0x1107, 0x1103, 0x1120), // choseong pieup + tikeut           = pieup-tikeut
            intArrayOf(0x1107, 0x1107, 0x1108), // choseong pieup + pieup            = ssangpieup
            intArrayOf(0x1107, 0x1109, 0x1121), // choseong pieup + sios             = pieup-sios
            intArrayOf(0x1107, 0x110a, 0x1125), // choseong pieup + ssangsios        = pieup-ssangsios
            intArrayOf(0x1107, 0x110b, 0x112b), // choseong pieup + ieung            = kapyeounpieup
            intArrayOf(0x1107, 0x110c, 0x1127), // choseong pieup + cieuc            = pieup-cieuc
            intArrayOf(0x1107, 0x110e, 0x1128), // choseong pieup + chieuch          = pieup-chieuch
            intArrayOf(0x1107, 0x110f, 0xa973), // choseong pieup + khieukh          = pieup-khieukh
            intArrayOf(0x1107, 0x1110, 0x1129), // choseong pieup + thieuth          = pieup-thieuth
            intArrayOf(0x1107, 0x1111, 0x112a), // choseong pieup + phieuph          = pieup-phieuph
            intArrayOf(0x1107, 0x1112, 0xa974), // choseong pieup + hieuh            = pieup-hieuh
            intArrayOf(0x1107, 0x112b, 0x112c), // choseong pieup + kapyeounpieup    = kapyeounssangpieup
            intArrayOf(0x1107, 0x112d, 0x1122), // choseong pieup + sios-kiyeok      = pieup-sios-kiyeok
            intArrayOf(0x1107, 0x112f, 0x1123), // choseong pieup + sios-tikeut      = pieup-sios-tikeut
            intArrayOf(0x1107, 0x1132, 0x1124), // choseong pieup + sios-pieup       = pieup-sios-pieup
            intArrayOf(0x1107, 0x1136, 0x1126), // choseong pieup + sios-cieuc       = pieup-sios-cieuc
            intArrayOf(0x1107, 0x1139, 0xa972), // choseong pieup + sios-thieuth     = pieup-sios-thieuth
            intArrayOf(0x1108, 0x110b, 0x112c), // choseong ssangpieup + ieung       = kapyeounssangpieup
            intArrayOf(0x1109, 0x1100, 0x112d), // choseong sios + kiyeok            = sios-kiyeok
            intArrayOf(0x1109, 0x1102, 0x112e), // choseong sios + nieun             = sios-nieun
            intArrayOf(0x1109, 0x1103, 0x112f), // choseong sios + tikeut            = sios-tikeut
            intArrayOf(0x1109, 0x1105, 0x1130), // choseong sios + rieul             = sios-rieul
            intArrayOf(0x1109, 0x1106, 0x1131), // choseong sios + mieum             = sios-mieum
            intArrayOf(0x1109, 0x1107, 0x1132), // choseong sios + pieup             = sios-pieup
            intArrayOf(0x1109, 0x1109, 0x110a), // choseong sios + sios              = ssangsios
            intArrayOf(0x1109, 0x110a, 0x1134), // choseong sios + ssangsios         = sios-ssangsios
            intArrayOf(0x1109, 0x110b, 0x1135), // choseong sios + ieung             = sios-ieung
            intArrayOf(0x1109, 0x110c, 0x1136), // choseong sios + cieuc             = sios-cieuc
            intArrayOf(0x1109, 0x110e, 0x1137), // choseong sios + chieuch           = sios-chieuch
            intArrayOf(0x1109, 0x110f, 0x1138), // choseong sios + khieukh           = sios-khieukh
            intArrayOf(0x1109, 0x1110, 0x1139), // choseong sios + thieuth           = sios-thieuth
            intArrayOf(0x1109, 0x1111, 0x113a), // choseong sios + phieuph           = sios-phieuph
            intArrayOf(0x1109, 0x1112, 0x113b), // choseong sios + hieuh             = sios-hieuh
            intArrayOf(0x1109, 0x111e, 0x1133), // choseong sios + pieup-kiyeok      = sios-pieup-kiyeok
            intArrayOf(0x1109, 0x1132, 0xa975), // choseong sios + sios-pieup        = ssangsios-pieup
            intArrayOf(0x110a, 0x1107, 0xa975), // choseong ssangsios + pieup        = ssangsios-pieup
            intArrayOf(0x110a, 0x1109, 0x1134), // choseong ssangsios + sios         = sios-ssangsios
            intArrayOf(0x110b, 0x1100, 0x1141), // choseong ieung + kiyeok           = ieung-kiyeok
            intArrayOf(0x110b, 0x1103, 0x1142), // choseong ieung + tikeut           = ieung-tikeut
            intArrayOf(0x110b, 0x1105, 0xa976), // choseong ieung + rieul            = ieung-rieul
            intArrayOf(0x110b, 0x1106, 0x1143), // choseong ieung + mieum            = ieung-mieum
            intArrayOf(0x110b, 0x1107, 0x1144), // choseong ieung + pieup            = ieung-pieup
            intArrayOf(0x110b, 0x1109, 0x1145), // choseong ieung + sios             = ieung-sios
            intArrayOf(0x110b, 0x110b, 0x1147), // choseong ieung + ieung            = ssangieung
            intArrayOf(0x110b, 0x110c, 0x1148), // choseong ieung + cieuc            = ieung-cieuc
            intArrayOf(0x110b, 0x110e, 0x1149), // choseong ieung + chieuch          = ieung-chieuch
            intArrayOf(0x110b, 0x1110, 0x114a), // choseong ieung + thieuth          = ieung-thieuth
            intArrayOf(0x110b, 0x1111, 0x114b), // choseong ieung + phieuph          = ieung-phieuph
            intArrayOf(0x110b, 0x1112, 0xa977), // choseong ieung + hieuh            = ieung-hieuh
            intArrayOf(0x110b, 0x1140, 0x1146), // choseong ieung + pansios          = ieung-pansios
            intArrayOf(0x110c, 0x110b, 0x114d), // choseong cieuc + ieung            = cieuc-ieung
            intArrayOf(0x110c, 0x110c, 0x110d), // choseong cieuc + cieuc            = ssangcieuc
            intArrayOf(0x110d, 0x1112, 0xa978), // choseong ssangcieuc + hieuh       = ssangcieuc-hieuh
            intArrayOf(0x110e, 0x110f, 0x1152), // choseong chieuch + khieukh        = chieuch-khieukh
            intArrayOf(0x110e, 0x1112, 0x1153), // choseong chieuch + hieuh          = chieuch-hieuh
            intArrayOf(0x1110, 0x1110, 0xa979), // choseong thieuth + thieuth        = ssangthieuth
            intArrayOf(0x1111, 0x1107, 0x1156), // choseong phieuph + pieup          = phieuph-pieup
            intArrayOf(0x1111, 0x110b, 0x1157), // choseong phieuph + ieung          = kapyeounphieuph
            intArrayOf(0x1111, 0x1112, 0xa97a), // choseong phieuph + hieuh          = phieuph-hieuh
            intArrayOf(0x1112, 0x1109, 0xa97b), // choseong hieuh + sios             = hieuh-sios
            intArrayOf(0x1112, 0x1112, 0x1158), // choseong hieuh + hieuh            = ssanghieuh
            intArrayOf(0x1121, 0x1100, 0x1122), // choseong pieup-sios + kiyeok      = pieup-sios-kiyeok
            intArrayOf(0x1121, 0x1103, 0x1123), // choseong pieup-sios + tikeut      = pieup-sios-tikeut
            intArrayOf(0x1121, 0x1107, 0x1124), // choseong pieup-sios + pieup       = pieup-sios-pieup
            intArrayOf(0x1121, 0x1109, 0x1125), // choseong pieup-sios + sios        = pieup-ssangsios
            intArrayOf(0x1121, 0x110c, 0x1126), // choseong pieup-sios + cieuc       = pieup-sios-cieuc
            intArrayOf(0x1121, 0x1110, 0xa972), // choseong pieup-sios + thieuth     = pieup-sios-thieuth
            intArrayOf(0x1132, 0x1100, 0x1133), // choseong sios-pieup + kiyeok      = sios-pieup-kiyeok
            intArrayOf(0x113c, 0x113c, 0x113d), // choseong chitueumsios + chitueumsios = chitueumssangsios
            intArrayOf(0x113e, 0x113e, 0x113f), // choseong ceongchieumsios + ceongchieumsios = ceongchieumssangsios
            intArrayOf(0x114e, 0x114e, 0x114f), // choseong chitueumcieuc + chitueumcieuc = chitueumssangcieuc
            intArrayOf(0x1150, 0x1150, 0x1151), // choseong ceongchieumcieuc + ceongchieumcieuc = ceongchieumssangcieuc
            intArrayOf(0x1159, 0x1159, 0xa97c), // choseong yeorinhieuh + yeorinhieuh = ssangyeorinhieuh
            intArrayOf(0x1161, 0x1161, 0x119e), // jungseong a + a                   = arae-a
            intArrayOf(0x1161, 0x1169, 0x1176), // jungseong a + o                   = a-o
            intArrayOf(0x1161, 0x116e, 0x1177), // jungseong a + u                   = a-u
            intArrayOf(0x1161, 0x1173, 0x11a3), // jungseong a + eu                  = a-eu
            intArrayOf(0x1161, 0x1175, 0x1162), // jungseong a + i                   = ae
            intArrayOf(0x1163, 0x1169, 0x1178), // jungseong ya + o                  = ya-o
            intArrayOf(0x1163, 0x116d, 0x1179), // jungseong ya + yo                 = ya-yo
            intArrayOf(0x1163, 0x116e, 0x11a4), // jungseong ya + u                  = ya-u
            intArrayOf(0x1163, 0x1175, 0x1164), // jungseong ya + i                  = yae
            intArrayOf(0x1165, 0x1169, 0x117a), // jungseong eo + o                  = eo-o
            intArrayOf(0x1165, 0x116e, 0x117b), // jungseong eo + u                  = eo-u
            intArrayOf(0x1165, 0x1173, 0x117c), // jungseong eo + eu                 = eo-eu
            intArrayOf(0x1165, 0x1175, 0x1166), // jungseong eo + i                  = e
            intArrayOf(0x1167, 0x1163, 0x11a5), // jungseong yeo + ya                = yeo-ya
            intArrayOf(0x1167, 0x1169, 0x117d), // jungseong yeo + o                 = yeo-o
            intArrayOf(0x1167, 0x116e, 0x117e), // jungseong yeo + u                 = yeo-u
            intArrayOf(0x1167, 0x1175, 0x1168), // jungseong yeo + i                 = ye
            intArrayOf(0x1169, 0x1161, 0x116a), // jungseong o + a                   = wa
            intArrayOf(0x1169, 0x1162, 0x116b), // jungseong o + ae                  = wae
            intArrayOf(0x1169, 0x1163, 0x11a6), // jungseong o + ya                  = o-ya
            intArrayOf(0x1169, 0x1164, 0x11a7), // jungseong o + yae                 = o-yae
            intArrayOf(0x1169, 0x1165, 0x117f), // jungseong o + eo                  = o-eo
            intArrayOf(0x1169, 0x1166, 0x1180), // jungseong o + e                   = o-e
            intArrayOf(0x1169, 0x1167, 0xd7b0), // jungseong o + yeo                 = o-yeo
            intArrayOf(0x1169, 0x1168, 0x1181), // jungseong o + ye                  = o-ye
            intArrayOf(0x1169, 0x1169, 0x1182), // jungseong o + o                   = o-o
            intArrayOf(0x1169, 0x116e, 0x1183), // jungseong o + u                   = o-u
            intArrayOf(0x1169, 0x1175, 0x116c), // jungseong o + i                   = oe
            intArrayOf(0x116a, 0x1175, 0x116b), // jungseong wa + i                  = wae
            intArrayOf(0x116d, 0x1161, 0xd7b2), // jungseong yo + a                  = yo-a
            intArrayOf(0x116d, 0x1162, 0xd7b3), // jungseong yo + ae                 = yo-ae
            intArrayOf(0x116d, 0x1163, 0x1184), // jungseong yo + ya                 = yo-ya
            intArrayOf(0x116d, 0x1164, 0x1185), // jungseong yo + yae                = yo-yae
            intArrayOf(0x116d, 0x1165, 0xd7b4), // jungseong yo + eo                 = yo-eo
            intArrayOf(0x116d, 0x1167, 0x1186), // jungseong yo + yeo                = yo-yeo
            intArrayOf(0x116d, 0x1169, 0x1187), // jungseong yo + o                  = yo-o
            intArrayOf(0x116d, 0x1175, 0x1188), // jungseong yo + i                  = yo-i
            intArrayOf(0x116e, 0x1161, 0x1189), // jungseong u + a                   = u-a
            intArrayOf(0x116e, 0x1162, 0x118a), // jungseong u + ae                  = u-ae
            intArrayOf(0x116e, 0x1165, 0x116f), // jungseong u + eo                  = weo
            intArrayOf(0x116e, 0x1166, 0x1170), // jungseong u + e                   = we
            intArrayOf(0x116e, 0x1167, 0xd7b5), // jungseong u + yeo                 = u-yeo
            intArrayOf(0x116e, 0x1168, 0x118c), // jungseong u + ye                  = u-ye
            intArrayOf(0x116e, 0x116e, 0x118d), // jungseong u + u                   = u-u
            intArrayOf(0x116e, 0x1175, 0x1171), // jungseong u + i                   = wi
            intArrayOf(0x116e, 0x117c, 0x118b), // jungseong u + eo-eu               = u-eo-eu
            intArrayOf(0x116e, 0xd7c4, 0xd7b6), // jungseong u + i-i                 = u-i-i
            intArrayOf(0x116f, 0x1173, 0x118b), // jungseong weo + eu                = u-eo-eu
            intArrayOf(0x116f, 0x1175, 0x1170), // jungseong weo + i                 = we
            intArrayOf(0x1171, 0x1175, 0xd7b6), // jungseong wi + i                  = u-i-i
            intArrayOf(0x1172, 0x1161, 0x118e), // jungseong yu + a                  = yu-a
            intArrayOf(0x1172, 0x1162, 0xd7b7), // jungseong yu + ae                 = yu-ae
            intArrayOf(0x1172, 0x1165, 0x118f), // jungseong yu + eo                 = yu-eo
            intArrayOf(0x1172, 0x1166, 0x1190), // jungseong yu + e                  = yu-e
            intArrayOf(0x1172, 0x1167, 0x1191), // jungseong yu + yeo                = yu-yeo
            intArrayOf(0x1172, 0x1168, 0x1192), // jungseong yu + ye                 = yu-ye
            intArrayOf(0x1172, 0x1169, 0xd7b8), // jungseong yu + o                  = yu-o
            intArrayOf(0x1172, 0x116e, 0x1193), // jungseong yu + u                  = yu-u
            intArrayOf(0x1172, 0x1175, 0x1194), // jungseong yu + i                  = yu-i
            intArrayOf(0x1173, 0x1161, 0xd7b9), // jungseong eu + a                  = eu-a
            intArrayOf(0x1173, 0x1165, 0xd7ba), // jungseong eu + eo                 = eu-eo
            intArrayOf(0x1173, 0x1166, 0xd7bb), // jungseong eu + e                  = eu-e
            intArrayOf(0x1173, 0x1169, 0xd7bc), // jungseong eu + o                  = eu-o
            intArrayOf(0x1173, 0x116e, 0x1195), // jungseong eu + u                  = eu-u
            intArrayOf(0x1173, 0x1173, 0x1196), // jungseong eu + eu                 = eu-eu
            intArrayOf(0x1173, 0x1175, 0x1174), // jungseong eu + i                  = yi
            intArrayOf(0x1174, 0x116e, 0x1197), // jungseong yi + u                  = yi-u
            intArrayOf(0x1175, 0x1161, 0x1198), // jungseong i + a                   = i-a
            intArrayOf(0x1175, 0x1163, 0x1199), // jungseong i + ya                  = i-ya
            intArrayOf(0x1175, 0x1164, 0xd7be), // jungseong i + yae                 = i-yae
            intArrayOf(0x1175, 0x1167, 0xd7bf), // jungseong i + yeo                 = i-yeo
            intArrayOf(0x1175, 0x1168, 0xd7c0), // jungseong i + ye                  = i-ye
            intArrayOf(0x1175, 0x1169, 0x119a), // jungseong i + o                   = i-o
            intArrayOf(0x1175, 0x116d, 0xd7c2), // jungseong i + yo                  = i-yo
            intArrayOf(0x1175, 0x116e, 0x119b), // jungseong i + u                   = i-u
            intArrayOf(0x1175, 0x1172, 0xd7c3), // jungseong i + yu                  = i-yu
            intArrayOf(0x1175, 0x1173, 0x119c), // jungseong i + eu                  = i-eu
            intArrayOf(0x1175, 0x1175, 0xd7c4), // jungseong i + i                   = i-i
            intArrayOf(0x1175, 0x1178, 0xd7bd), // jungseong i + ya-o                = i-ya-o
            intArrayOf(0x1175, 0x119e, 0x119d), // jungseong i + araea               = i-araea
            intArrayOf(0x1182, 0x1175, 0xd7b1), // jungseong o-o + i                 = o-o-i
            intArrayOf(0x1199, 0x1169, 0xd7bd), // jungseong i-ya + o                = i-ya-o
            intArrayOf(0x119a, 0x1175, 0xd7c1), // jungseong i-o + i                 = i-o-i
            intArrayOf(0x119e, 0x1161, 0xd7c5), // jungseong araea + a               = araea-a
            intArrayOf(0x119e, 0x1165, 0x119f), // jungseong araea + eo              = araea-eo
            intArrayOf(0x119e, 0x1166, 0xd7c6), // jungseong araea + e               = araea-e
            intArrayOf(0x119e, 0x116e, 0x11a0), // jungseong araea + u               = araea-u
            intArrayOf(0x119e, 0x1175, 0x11a1), // jungseong araea + i               = araea-i
            intArrayOf(0x119e, 0x119e, 0x11a2), // jungseong araea + araea           = ssangaraea
            intArrayOf(0x11a8, 0x11a8, 0x11a9), // jongseong kiyeok + kiyeok         = ssangkiyeok
            intArrayOf(0x11a8, 0x11ab, 0x11fa), // jongseong kiyeok + nieun          = kiyeok-nieun
            intArrayOf(0x11a8, 0x11af, 0x11c3), // jongseong kiyeok + rieul          = kiyeok-rieul
            intArrayOf(0x11a8, 0x11b8, 0x11fb), // jongseong kiyeok + pieup          = kiyeok-pieup
            intArrayOf(0x11a8, 0x11ba, 0x11aa), // jongseong kiyeok + sios           = kiyeok-sios
            intArrayOf(0x11a8, 0x11be, 0x11fc), // jongseong kiyeok + chieuch        = kiyeok-chieuch
            intArrayOf(0x11a8, 0x11bf, 0x11fd), // jongseong kiyeok + khieukh        = kiyeok-khieukh
            intArrayOf(0x11a8, 0x11c2, 0x11fe), // jongseong kiyeok + hieuh          = kiyeok-hieuh
            intArrayOf(0x11a8, 0x11e7, 0x11c4), // jongseong kiyeok + sios-kiyeok    = kiyeok-sios-kiyeok
            intArrayOf(0x11aa, 0x11a8, 0x11c4), // jongseong kiyeok-sios + kiyeok    = kiyeok-sios-kiyeok
            intArrayOf(0x11ab, 0x11a8, 0x11c5), // jongseong nieun + kiyeok          = nieun-kiyeok
            intArrayOf(0x11ab, 0x11ab, 0x11ff), // jongseong nieun + nieun           = ssangnieun
            intArrayOf(0x11ab, 0x11ae, 0x11c6), // jongseong nieun + tikeut          = nieun-tikeut
            intArrayOf(0x11ab, 0x11af, 0xd7cb), // jongseong nieun + rieul           = nieun-rieul
            intArrayOf(0x11ab, 0x11ba, 0x11c7), // jongseong nieun + sios            = nieun-sios
            intArrayOf(0x11ab, 0x11bd, 0x11ac), // jongseong nieun + cieuc           = nieun-cieuc
            intArrayOf(0x11ab, 0x11be, 0xd7cc), // jongseong nieun + chieuch         = nieun-chieuch
            intArrayOf(0x11ab, 0x11c0, 0x11c9), // jongseong nieun + thieuth         = nieun-thieuth
            intArrayOf(0x11ab, 0x11c2, 0x11ad), // jongseong nieun + hieuh           = nieun-hieuh
            intArrayOf(0x11ab, 0x11eb, 0x11c8), // jongseong nieun + pansios         = nieun-pansios
            intArrayOf(0x11ae, 0x11a8, 0x11ca), // jongseong tikeut + kiyeok         = tikeut-kiyeok
            intArrayOf(0x11ae, 0x11ae, 0xd7cd), // jongseong tikeut + tikeut         = ssangtikeut
            intArrayOf(0x11ae, 0x11af, 0x11cb), // jongseong tikeut + rieul          = tikeut-rieul
            intArrayOf(0x11ae, 0x11b8, 0xd7cf), // jongseong tikeut + pieup          = tikeut-pieup
            intArrayOf(0x11ae, 0x11ba, 0xd7d0), // jongseong tikeut + sios           = tikeut-sios
            intArrayOf(0x11ae, 0x11bd, 0xd7d2), // jongseong tikeut + cieuc          = tikeut-cieuc
            intArrayOf(0x11ae, 0x11be, 0xd7d3), // jongseong tikeut + chieuch        = tikeut-chieuch
            intArrayOf(0x11ae, 0x11c0, 0xd7d4), // jongseong tikeut + thieuth        = tikeut-thieuth
            intArrayOf(0x11ae, 0x11e7, 0xd7d1), // jongseong tikeut + sios-kiyeok    = tikeut-sios-kiyeok
            intArrayOf(0x11ae, 0xd7cf, 0xd7ce), // jongseong tikeut + tikeut-pieup   = ssangtikeut-pieup
            intArrayOf(0x11af, 0x11a8, 0x11b0), // jongseong rieul + kiyeok          = rieul-kiyeok
            intArrayOf(0x11af, 0x11a9, 0xd7d5), // jongseong rieul + ssangkiyeok     = rieul-ssangkiyeok
            intArrayOf(0x11af, 0x11aa, 0x11cc), // jongseong rieul + kiyeok-sios     = rieul-kiyeok-sios
            intArrayOf(0x11af, 0x11ab, 0x11cd), // jongseong rieul + nieun           = rieul-nieun
            intArrayOf(0x11af, 0x11ae, 0x11ce), // jongseong rieul + tikeut          = rieul-tikeut
            intArrayOf(0x11af, 0x11af, 0x11d0), // jongseong rieul + rieul           = ssangrieul
            intArrayOf(0x11af, 0x11b7, 0x11b1), // jongseong rieul + mieum           = rieul-mieum
            intArrayOf(0x11af, 0x11b8, 0x11b2), // jongseong rieul + pieup           = rieul-pieup
            intArrayOf(0x11af, 0x11b9, 0x11d3), // jongseong rieul + pieup-sios      = rieul-pieup-sios
            intArrayOf(0x11af, 0x11ba, 0x11b3), // jongseong rieul + sios            = rieul-sios
            intArrayOf(0x11af, 0x11bb, 0x11d6), // jongseong rieul + ssangsios       = rieul-ssangsios
            intArrayOf(0x11af, 0x11bc, 0xd7dd), // jongseong rieul + ieung           = kapyeounrieul
            intArrayOf(0x11af, 0x11bf, 0x11d8), // jongseong rieul + khieukh         = rieul-khieukh
            intArrayOf(0x11af, 0x11c0, 0x11b4), // jongseong rieul + thieuth         = rieul-thieuth
            intArrayOf(0x11af, 0x11c1, 0x11b5), // jongseong rieul + phieuph         = rieul-phieuph
            intArrayOf(0x11af, 0x11c2, 0x11b6), // jongseong rieul + hieuh           = rieul-hieuh
            intArrayOf(0x11af, 0x11d8, 0xd7d7), // jongseong rieul + rieul-khieukh   = ssangrieul-khieukh
            intArrayOf(0x11af, 0x11da, 0x11d1), // jongseong rieul + mieum-kiyeok    = rieul-mieum-kiyeok
            intArrayOf(0x11af, 0x11dd, 0x11d2), // jongseong rieul + mieum-sios      = rieul-mieum-sios
            intArrayOf(0x11af, 0x11e1, 0xd7d8), // jongseong rieul + mieum-hieuh     = rieul-mieum-hieuh
            intArrayOf(0x11af, 0x11e4, 0xd7da), // jongseong rieul + pieup-phieuph   = rieul-pieup-phieuph
            intArrayOf(0x11af, 0x11e5, 0x11d4), // jongseong rieul + pieup-hieuh     = rieul-pieup-hieuh
            intArrayOf(0x11af, 0x11e6, 0x11d5), // jongseong rieul + kapyeounpieup   = rieul-kapyeounpieup
            intArrayOf(0x11af, 0x11eb, 0x11d7), // jongseong rieul + pansios         = rieul-pansios
            intArrayOf(0x11af, 0x11f0, 0xd7db), // jongseong rieul + yesieung        = rieul-yesieung
            intArrayOf(0x11af, 0x11f9, 0x11d9), // jongseong rieul + yeorinhieuh     = rieul-yeorinhieuh
            intArrayOf(0x11af, 0x11fe, 0xd7d6), // jongseong rieul + kiyeok-hieuh    = rieul-kiyeok-hieuh
            intArrayOf(0x11af, 0xd7e3, 0xd7d9), // jongseong rieul + pieup-tikeut    = rieul-pieup-tikeut
            intArrayOf(0x11b0, 0x11a8, 0xd7d5), // jongseong rieul-kiyeok + kiyeok   = rieul-ssangkiyeok
            intArrayOf(0x11b0, 0x11ba, 0x11cc), // jongseong rieul-kiyeok + sios     = rieul-kiyeok-sios
            intArrayOf(0x11b0, 0x11c2, 0xd7d6), // jongseong rieul-kiyeok + hieuh    = rieul-kiyeok-hieuh
            intArrayOf(0x11b1, 0x11a8, 0x11d1), // jongseong rieul-mieum + kiyeok    = rieul-mieum-kiyeok
            intArrayOf(0x11b1, 0x11ba, 0x11d2), // jongseong rieul-mieum + sios      = rieul-mieum-sios
            intArrayOf(0x11b1, 0x11c2, 0xd7d8), // jongseong rieul-mieum + hieuh     = rieul-mieum-hieuh
            intArrayOf(0x11b2, 0x11ae, 0xd7d9), // jongseong rieul-pieup + tikeut    = rieul-pieup-tikeut
            intArrayOf(0x11b2, 0x11ba, 0x11d3), // jongseong rieul-pieup + sios      = rieul-pieup-sios
            intArrayOf(0x11b2, 0x11bc, 0x11d5), // jongseong rieul-pieup + ieung     = rieul-kapyeounpieup
            intArrayOf(0x11b2, 0x11c1, 0xd7da), // jongseong rieul-pieup + phieuph   = rieul-pieup-phieuph
            intArrayOf(0x11b2, 0x11c2, 0x11d4), // jongseong rieul-pieup + hieuh     = rieul-pieup-hieuh
            intArrayOf(0x11b3, 0x11ba, 0x11d6), // jongseong rieul-sios + sios       = rieul-ssangsios
            intArrayOf(0x11b7, 0x11a8, 0x11da), // jongseong mieum + kiyeok          = mieum-kiyeok
            intArrayOf(0x11b7, 0x11ab, 0xd7de), // jongseong mieum + nieun           = mieum-nieun
            intArrayOf(0x11b7, 0x11af, 0x11db), // jongseong mieum + rieul           = mieum-rieul
            intArrayOf(0x11b7, 0x11b7, 0xd7e0), // jongseong mieum + mieum           = ssangmieum
            intArrayOf(0x11b7, 0x11b8, 0x11dc), // jongseong mieum + pieup           = mieum-pieup
            intArrayOf(0x11b7, 0x11b9, 0xd7e1), // jongseong mieum + pieup-sios      = mieum-pieup-sios
            intArrayOf(0x11b7, 0x11ba, 0x11dd), // jongseong mieum + sios            = mieum-sios
            intArrayOf(0x11b7, 0x11bb, 0x11de), // jongseong mieum + ssangsios       = mieum-ssangsios
            intArrayOf(0x11b7, 0x11bc, 0x11e2), // jongseong mieum + ieung           = kapyeounmieum
            intArrayOf(0x11b7, 0x11bd, 0xd7e2), // jongseong mieum + cieuc           = mieum-cieuc
            intArrayOf(0x11b7, 0x11be, 0x11e0), // jongseong mieum + chieuch         = mieum-chieuch
            intArrayOf(0x11b7, 0x11c2, 0x11e1), // jongseong mieum + hieuh           = mieum-hieuh
            intArrayOf(0x11b7, 0x11eb, 0x11df), // jongseong mieum + pansios         = mieum-pansios
            intArrayOf(0x11b7, 0x11ff, 0xd7df), // jongseong mieum + ssangnieun      = mieum-ssangnieun
            intArrayOf(0x11b8, 0x11ae, 0xd7e3), // jongseong pieup + tikeut          = pieup-tikeut
            intArrayOf(0x11b8, 0x11af, 0x11e3), // jongseong pieup + rieul           = pieup-rieul
            intArrayOf(0x11b8, 0x11b5, 0xd7e4), // jongseong pieup + rieul-phieuph   = pieup-rieul-phieuph
            intArrayOf(0x11b8, 0x11b7, 0xd7e5), // jongseong pieup + mieum           = pieup-mieum
            intArrayOf(0x11b8, 0x11b8, 0xd7e6), // jongseong pieup + pieup           = ssangpieup
            intArrayOf(0x11b8, 0x11ba, 0x11b9), // jongseong pieup + sios            = pieup-sios
            intArrayOf(0x11b8, 0x11bc, 0x11e6), // jongseong pieup + ieung           = kapyeounpieup
            intArrayOf(0x11b8, 0x11bd, 0xd7e8), // jongseong pieup + cieuc           = pieup-cieuc
            intArrayOf(0x11b8, 0x11be, 0xd7e9), // jongseong pieup + chieuch         = pieup-chieuch
            intArrayOf(0x11b8, 0x11c1, 0x11e4), // jongseong pieup + phieuph         = pieup-phieuph
            intArrayOf(0x11b8, 0x11c2, 0x11e5), // jongseong pieup + hieuh           = pieup-hieuh
            intArrayOf(0x11b8, 0x11e8, 0xd7e7), // jongseong pieup + sios-tikeut     = pieup-sios-tikeut
            intArrayOf(0x11b9, 0x11ae, 0xd7e7), // jongseong pieup-sios + tikeut     = pieup-sios-tikeut
            intArrayOf(0x11ba, 0x11a8, 0x11e7), // jongseong sios + kiyeok           = sios-kiyeok
            intArrayOf(0x11ba, 0x11ae, 0x11e8), // jongseong sios + tikeut           = sios-tikeut
            intArrayOf(0x11ba, 0x11af, 0x11e9), // jongseong sios + rieul            = sios-rieul
            intArrayOf(0x11ba, 0x11b7, 0xd7ea), // jongseong sios + mieum            = sios-mieum
            intArrayOf(0x11ba, 0x11b8, 0x11ea), // jongseong sios + pieup            = sios-pieup
            intArrayOf(0x11ba, 0x11ba, 0x11bb), // jongseong sios + sios             = ssangsios
            intArrayOf(0x11ba, 0x11bd, 0xd7ef), // jongseong sios + cieuc            = sios-cieuc
            intArrayOf(0x11ba, 0x11be, 0xd7f0), // jongseong sios + chieuch          = sios-chieuch
            intArrayOf(0x11ba, 0x11c0, 0xd7f1), // jongseong sios + thieuth          = sios-thieuth
            intArrayOf(0x11ba, 0x11c2, 0xd7f2), // jongseong sios + hieuh            = sios-hieuh
            intArrayOf(0x11ba, 0x11e6, 0xd7eb), // jongseong sios + kapyeounpieup    = sios-kapyeounpieup
            intArrayOf(0x11ba, 0x11e7, 0xd7ec), // jongseong sios + sios-kiyeok      = ssangsios-kiyeok
            intArrayOf(0x11ba, 0x11e8, 0xd7ed), // jongseong sios + sios-tikeut      = ssangsios-tikeut
            intArrayOf(0x11ba, 0x11eb, 0xd7ee), // jongseong sios + pansios          = sios-pansios
            intArrayOf(0x11bb, 0x11a8, 0xd7ec), // jongseong ssangsios + kiyeok      = ssangsios-kiyeok
            intArrayOf(0x11bb, 0x11ae, 0xd7ed), // jongseong ssangsios + tikeut      = ssangsios-tikeut
            intArrayOf(0x11bd, 0x11b8, 0xd7f7), // jongseong cieuc + pieup           = cieuc-pieup
            intArrayOf(0x11bd, 0x11bd, 0xd7f9), // jongseong cieuc + cieuc           = ssangcieuc
            intArrayOf(0x11bd, 0xd7e6, 0xd7f8), // jongseong cieuc + ssangpieup      = cieuc-ssangpieup
            intArrayOf(0x11c1, 0x11b8, 0x11f3), // jongseong phieuph + pieup         = phieuph-pieup
            intArrayOf(0x11c1, 0x11ba, 0xd7fa), // jongseong phieuph + sios          = phieuph-sios
            intArrayOf(0x11c1, 0x11bc, 0x11f4), // jongseong phieuph + ieung         = kapyeounphieuph
            intArrayOf(0x11c1, 0x11c0, 0xd7fb), // jongseong phieuph + thieuth       = phieuph-thieuth
            intArrayOf(0x11c2, 0x11ab, 0x11f5), // jongseong hieuh + nieun           = hieuh-nieun
            intArrayOf(0x11c2, 0x11af, 0x11f6), // jongseong hieuh + rieul           = hieuh-rieul
            intArrayOf(0x11c2, 0x11b7, 0x11f7), // jongseong hieuh + mieum           = hieuh-mieum
            intArrayOf(0x11c2, 0x11b8, 0x11f8), // jongseong hieuh + pieup           = hieuh-pieup
            intArrayOf(0x11ce, 0x11c2, 0x11cf), // jongseong rieul-tikeut + hieuh    = rieul-tikeut-hieuh
            intArrayOf(0x11d0, 0x11bf, 0xd7d7), // jongseong ssangrieul + khieukh    = ssangrieul-khieukh
            intArrayOf(0x11d9, 0x11c2, 0xd7dc), // jongseong rieul-yeorinhieuh + hieuh = rieul-yeorinhieuh-hieuh
            intArrayOf(0x11dc, 0x11ba, 0xd7e1), // jongseong mieum-pieup + sios      = mieum-pieup-sios
            intArrayOf(0x11dd, 0x11ba, 0x11de), // jongseong mieum-sios + sios       = mieum-ssangsios
            intArrayOf(0x11e3, 0x11c1, 0xd7e4), // jongseong pieup-rieul + phieuph   = pieup-rieul-phieuph
            intArrayOf(0x11ea, 0x11bc, 0xd7eb), // jongseong sios-pieup + ieung      = sios-kapyeounpieup
            intArrayOf(0x11eb, 0x11b8, 0xd7f3), // jongseong pansios + pieup         = pansios-pieup
            intArrayOf(0x11eb, 0x11e6, 0xd7f4), // jongseong pansios + kapyeounpieup = pansios-kapyeounpieup
            intArrayOf(0x11ec, 0x11a8, 0x11ed), // jongseong ieung-kiyeok + kiyeok   = ieung-ssangkiyeok
            intArrayOf(0x11f0, 0x11a8, 0x11ec), // jongseong yesieung + kiyeok       = yesieung-kiyeok
            intArrayOf(0x11f0, 0x11a9, 0x11ed), // jongseong yesieung + ssangkiyeok  = yesieung-ssangkiyeok
            intArrayOf(0x11f0, 0x11b7, 0xd7f5), // jongseong yesieung + mieum        = yesieung-mieum
            intArrayOf(0x11f0, 0x11ba, 0x11f1), // jongseong yesieung + sios         = yesieung-sios
            intArrayOf(0x11f0, 0x11bf, 0x11ef), // jongseong yesieung + khieukh      = yesieung-khieukh
            intArrayOf(0x11f0, 0x11c2, 0xd7f6), // jongseong yesieung + hieuh        = yesieung-hieuh
            intArrayOf(0x11f0, 0x11eb, 0x11f2), // jongseong yesieung + pansios      = yesieung-pansios
            intArrayOf(0x11f0, 0x11f0, 0x11ee), // jongseong yesieung + yesieung     = ssangyesieung
            intArrayOf(0xa964, 0x1100, 0xa965), // choseong rieul-kiyeok + kiyeok    = rieul-ssangkiyeok
            intArrayOf(0xa966, 0x1103, 0xa967), // choseong rieul-tikeut + tikeut    = rieul-ssangtikeut
            intArrayOf(0xa969, 0x1107, 0xa96a), // choseong rieul-pieup + pieup      = rieul-ssangpieup
            intArrayOf(0xa969, 0x110b, 0xa96b), // choseong rieul-pieup + ieung      = rieul-kapyeounpieup
            intArrayOf(0xd7c5, 0x1161, 0x11a2), // jungseong araea-a + a             = ssangaraea
            intArrayOf(0xd7cd, 0x11b8, 0xd7ce), // jongseong ssangtikeut + pieup     = ssangtikeut-pieup
            intArrayOf(0xd7d0, 0x11a8, 0xd7d1), // jongseong tikeut-sios + kiyeok    = tikeut-sios-kiyeok
            intArrayOf(0xd7de, 0x11ab, 0xd7df), // jongseong mieum-nieun + nieun     = mieum-ssangnieun
            intArrayOf(0xd7f3, 0x11bc, 0xd7f4), // jongseong pansios-pieup + ieung   = pansios-kapyeounpieup
            intArrayOf(0xd7f7, 0x11b8, 0xd7f8), // jongseong cieuc-pieup + pieup     = cieuc-ssangpieup
            // 아래는 신세벌식 P2 만의 조합이지만 위의 코드를 함께 쓰는 신세벌식 P2 자판의 코드 중복을 방지하기 위해 여기에 붙였습니다.
            intArrayOf(0x1100, 0x1109, 0x1140), // choseong gieug + siues = ssanggieug
            intArrayOf(0x1100, 0x110B, 0x114C), // choseong gieug + ieung = yesieung
            intArrayOf(0x1100, 0x1112, 0x1159), // choseong gieug + hiueh = yeolinhieuh
            intArrayOf(0x1159, 0x1112, 0xA97C), // choseong yeolinhieuh + hiueh = ssangyeolinhieuh
            intArrayOf(0x1141, 0x1109, 0x1146), // choseong ieung-gieug + sieus = ieung-yeolinsieus
            intArrayOf(0x110C, 0x1109, 0x113C), // choseong jieuj + siues = ab-sieus
            intArrayOf(0x113C, 0x1109, 0x113D), // choseong ab-sieus + sieus = ssang-ab-sieus
            intArrayOf(0x110E, 0x1109, 0x113E), // choseong chieuch + siues = dwis-sieus
            intArrayOf(0x113E, 0x1109, 0x113F), // choseong dwis-sieus + sieus = ssang-dwis-sieus
            intArrayOf(0x110C, 0x1103, 0x114E), // choseong jieuj + dieug = ab-jieuj
            intArrayOf(0x110D, 0x1103, 0x114F), // choseong ssangjieuj + dieud = ssang-ab-jieuj
            intArrayOf(0x110C, 0x1100, 0x1150), // choseong jieuj + gieug = dwis-jieuj
            intArrayOf(0x110D, 0x1100, 0x1151), // choseong ssangjieuj + gieug = ssang-dwis-jieuj
            intArrayOf(0x110E, 0x1103, 0x1154), // choseong chieuch + dieug = ab-chieuch
            intArrayOf(0x110E, 0x1100, 0x1155), // choseong chieuch + gieug = dwis-chieuch
            intArrayOf(-5000, 0x1161, 0x116a), // jungseong o + a                   = wa
            intArrayOf(-5000, 0x1162, 0x116b), // jungseong o + ae                  = wae
            intArrayOf(-5000, 0x1163, 0x11a6), // jungseong o + ya                  = o-ya
            intArrayOf(-5000, 0x1164, 0x11a7), // jungseong o + yae                 = o-yae
            intArrayOf(-5000, 0x1165, 0x117f), // jungseong o + eo                  = o-eo
            intArrayOf(-5000, 0x1166, 0x1180), // jungseong o + e                   = o-e
            intArrayOf(-5000, 0x1167, 0xd7b0), // jungseong o + yeo                 = o-yeo
            intArrayOf(-5000, 0x1168, 0x1181), // jungseong o + ye                  = o-ye
            intArrayOf(-5000, 0x1169, 0x1182), // jungseong o + o                   = o-o
            intArrayOf(-5000, 0x116e, 0x1183), // jungseong o + u                   = o-u
            intArrayOf(-5000, 0x1175, 0x116c), // jungseong o + i                   = oe
            intArrayOf(-5001, 0x1161, 0x1189), // jungseong u + a                   = u-a
            intArrayOf(-5001, 0x1162, 0x118a), // jungseong u + ae                  = u-ae
            intArrayOf(-5001, 0x1165, 0x116f), // jungseong u + eo                  = weo
            intArrayOf(-5001, 0x1166, 0x1170), // jungseong u + e                   = we
            intArrayOf(-5001, 0x1167, 0xd7b5), // jungseong u + yeo                 = u-yeo
            intArrayOf(-5001, 0x1168, 0x118c), // jungseong u + ye                  = u-ye
            intArrayOf(-5001, 0x116e, 0x118d), // jungseong u + u                   = u-u
            intArrayOf(-5001, 0x1175, 0x1171), // jungseong u + i                   = wi
            intArrayOf(-5001, 0x117c, 0x118b), // jungseong u + eo-eu               = u-eo-eu
            intArrayOf(-5002, 0x1161, 0xd7b9), // jungseong eu + a                  = eu-a
            intArrayOf(-5002, 0x1165, 0xd7ba), // jungseong eu + eo                 = eu-eo
            intArrayOf(-5002, 0x1166, 0xd7bb), // jungseong eu + e                  = eu-e
            intArrayOf(-5002, 0x1169, 0xd7bc), // jungseong eu + o                  = eu-o
            intArrayOf(-5002, 0x116e, 0x1195), // jungseong eu + u                  = eu-u
            intArrayOf(-5002, 0x1173, 0x1196), // jungseong eu + eu                 = eu-eu
            intArrayOf(-5002, 0x1175, 0x1174), // jungseong eu + i                  = yi
            intArrayOf(-5010, 0x1161, 0xd7c5), // jungseong araea + a               = araea-a
            intArrayOf(-5010, 0x1165, 0x119f), // jungseong araea + eo              = araea-eo
            intArrayOf(-5010, 0x1166, 0xd7c6), // jungseong araea + e               = araea-e
            intArrayOf(-5010, 0x116e, 0x11a0), // jungseong araea + u               = araea-u
            intArrayOf(-5010, 0x1175, 0x11a1), // jungseong araea + i               = araea-i
            intArrayOf(-5010, 0x119e, 0x11a2), // jungseong araea + araea           = ssangaraea
            intArrayOf(0x11BA, 0x11C1, 0x11EB), // jongseong sieus + pieup = yeolinsieus
            intArrayOf(0x110A, 0x11C1, 0xD7EE), // jongseong ssangsieus + pieup = sieus-yeolinsieus
            intArrayOf(0x11C7, 0x11C1, 0x11C8), // jongseong nieun-sieus + pieup = nieun-yeolinsieus
            intArrayOf(0x11B3, 0x11C1, 0x11D7), // jongseong lieul-sieus + pieup = lieul-yeolinsieus
            intArrayOf(0x11DD, 0x11C1, 0x11DF), // jongseong mieum-sieus + pieup = mieum-yeolinsieus
            intArrayOf(0x11BB, 0x11C1, 0xD7EE), // jongseong ssangsiues + pieup = sieus-yeolinsieus
            intArrayOf(0x11F1, 0x11C1, 0x11F2), // jongseong yesieung-sieus + pieup = yesieung-yeolinsieus
            intArrayOf(0x11BC, 0x11C1, 0x11F0), // jongseong ieung + pieup = yesieung
            intArrayOf(0x11F0, 0x11C1, 0x11EE), // jongseong yesieung + pieup = ssangyesieung
            intArrayOf(0xD7DD, 0x11C1, 0xD7DB), // jongseong yeolinlieul + pieup = lieul-yesieung
            intArrayOf(0x11C2, 0x11C1, 0x11F9), // jongseong hieuh + pieup = yeolinhieuh
            intArrayOf(0x11B6, 0x11C1, 0x11D9), // jongseong lieul-hieuh + pieup = lieul-yeolinhieuh
            intArrayOf(0x11BC, 0x11A8, 0x11EC), // jongseong ieung + gieug = yesieung-gieug
            intArrayOf(0x11BC, 0x11A9, 0x11EC), // jongseong ieung + ssanggieug = yesieung-ssanggieug
            intArrayOf(0x11BC, 0x11B7, 0xD7F5), // jongseong ieung + mieum = yesieung-mieum
            intArrayOf(0x11BC, 0x11BA, 0x11F1), // jongseong ieung + sieus = yesieung-sieus
            intArrayOf(0x11BC, 0x11BC, 0x11EE), // jongseong ieung + ieung = ssangyesieung
            intArrayOf(0x11BC, 0x11BF, 0x11EF), // jongseong ieung + ieung = ssangyesieung
            intArrayOf(0x11BC, 0x11C2, 0xD7F6), // jongseong ieung + ieung = ssangyesieung
        )

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

    @JvmField
    val JAMO_DUBUL_STANDARD =
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
            intArrayOf(113, 0x3142, 0x3143),
            intArrayOf(119, 0x3148, 0x3149),
            intArrayOf(101, 0x3137, 0x3138),
            intArrayOf(114, 0x3131, 0x3132),
            intArrayOf(116, 0x3145, 0x3146),
            intArrayOf(121, 0x315b, 0x315b),
            intArrayOf(117, 0x3155, 0x3155),
            intArrayOf(105, 0x3151, 0x3151),
            intArrayOf(111, 0x3150, 0x3152),
            intArrayOf(112, 0x3154, 0x3156),
            intArrayOf(97, 0x3141, 0x3141),
            intArrayOf(115, 0x3134, 0x3134),
            intArrayOf(100, 0x3147, 0x3147),
            intArrayOf(102, 0x3139, 0x3139),
            intArrayOf(103, 0x314e, 0x314e),
            intArrayOf(104, 0x3157, 0x3157),
            intArrayOf(106, 0x3153, 0x3153),
            intArrayOf(107, 0x314f, 0x314f),
            intArrayOf(108, 0x3163, 0x3163),
            intArrayOf(122, 0x314b, 0x314b),
            intArrayOf(120, 0x314c, 0x314c),
            intArrayOf(99, 0x314a, 0x314a),
            intArrayOf(118, 0x314d, 0x314d),
            intArrayOf(98, 0x3160, 0x3160),
            intArrayOf(110, 0x315c, 0x315c),
            intArrayOf(109, 0x3161, 0x3161),
        )

    @JvmField
    val COMB_DUBUL_STANDARD =
        arrayOf(
            intArrayOf(0x1169, 0x1161, 0x116a),
            intArrayOf(0x1169, 0x1162, 0x116b),
            intArrayOf(0x1169, 0x1175, 0x116c),
            intArrayOf(0x116e, 0x1165, 0x116f),
            intArrayOf(0x116e, 0x1166, 0x1170),
            intArrayOf(0x116e, 0x1175, 0x1171),
            intArrayOf(0x1173, 0x1175, 0x1174),
            intArrayOf(0x11a8, 0x11ba, 0x11aa),
            intArrayOf(0x11ab, 0x11bd, 0x11ac),
            intArrayOf(0x11ab, 0x11c2, 0x11ad),
            intArrayOf(0x11af, 0x11a8, 0x11b0),
            intArrayOf(0x11af, 0x11b7, 0x11b1),
            intArrayOf(0x11af, 0x11b8, 0x11b2),
            intArrayOf(0x11af, 0x11ba, 0x11b3),
            intArrayOf(0x11af, 0x11c0, 0x11b4),
            intArrayOf(0x11af, 0x11c1, 0x11b5),
            intArrayOf(0x11af, 0x11c2, 0x11b6),
            intArrayOf(0x11b8, 0x11ba, 0x11b9),
        )

    @JvmField
    val JAMO_DUBUL_NK =
        arrayOf(
            intArrayOf(113, 0x3142, 0x3143),
            intArrayOf(119, 0x3141, 0x3141),
            intArrayOf(101, 0x3137, 0x3138),
            intArrayOf(114, 0x3139, 0x3139),
            intArrayOf(116, 0x314e, 0x314e),
            intArrayOf(121, 0x3155, 0x3155),
            intArrayOf(117, 0x315c, 0x315c),
            intArrayOf(105, 0x3153, 0x3153),
            intArrayOf(111, 0x3150, 0x3152),
            intArrayOf(112, 0x3154, 0x3156),
            intArrayOf(97, 0x3148, 0x3149),
            intArrayOf(115, 0x3131, 0x3132),
            intArrayOf(100, 0x3147, 0x3147),
            intArrayOf(102, 0x3134, 0x3134),
            intArrayOf(103, 0x3145, 0x3146),
            intArrayOf(104, 0x3157, 0x3157),
            intArrayOf(106, 0x314f, 0x314f),
            intArrayOf(107, 0x3163, 0x3163),
            intArrayOf(108, 0x3161, 0x3161),
            intArrayOf(122, 0x314b, 0x314b),
            intArrayOf(120, 0x314c, 0x314c),
            intArrayOf(99, 0x314a, 0x314a),
            intArrayOf(118, 0x314d, 0x314d),
            intArrayOf(98, 0x3160, 0x3160),
            intArrayOf(110, 0x315b, 0x315b),
            intArrayOf(109, 0x3151, 0x3151),
        )

    @JvmField
    val JAMO_DUBUL_YET =
        arrayOf(
            intArrayOf(113, 0x3142, 0x3143),
            intArrayOf(119, 0x3148, 0x3149),
            intArrayOf(101, 0x3137, 0x3138),
            intArrayOf(114, 0x3131, 0x3132),
            intArrayOf(116, 0x3145, 0x3146),
            intArrayOf(121, 0x315b, 0x315b),
            intArrayOf(117, 0x3155, 0x3155),
            intArrayOf(105, 0x3151, 0x3151),
            intArrayOf(111, 0x3150, 0x3152),
            intArrayOf(112, 0x3154, 0x3156),
            intArrayOf(97, 0x3141, 0x317f),
            intArrayOf(115, 0x3134, 0x3136),
            intArrayOf(100, 0x3147, 0x3181),
            intArrayOf(102, 0x3139, 0x3140),
            intArrayOf(103, 0x314e, 0x3186),
            intArrayOf(104, 0x3157, 0x1183),
            intArrayOf(106, 0x3153, 0x115f),
            intArrayOf(107, 0x314f, 0x318d),
            intArrayOf(108, 0x3163, 0x318c),
            intArrayOf(122, 0x314b, 0x113c),
            intArrayOf(120, 0x314c, 0x113e),
            intArrayOf(99, 0x314a, 0x114e),
            intArrayOf(118, 0x314d, 0x1150),
            intArrayOf(98, 0x3160, 0x1154),
            intArrayOf(110, 0x315c, 0x1155),
            intArrayOf(109, 0x3161, 0x3161),
        )

    @JvmField
    val JAMO_DUBUL_DANMOEUM_GOOGLE =
        arrayOf(
            intArrayOf(113, 0x3142),
            intArrayOf(119, 0x3148),
            intArrayOf(101, 0x3137),
            intArrayOf(114, 0x3131),
            intArrayOf(116, 0x3145),
            intArrayOf(105, 0x3157),
            intArrayOf(111, 0x3150),
            intArrayOf(112, 0x3154),
            intArrayOf(97, 0x3141),
            intArrayOf(115, 0x3134),
            intArrayOf(100, 0x3147),
            intArrayOf(102, 0x3139),
            intArrayOf(104, 0x314e),
            intArrayOf(106, 0x3153),
            intArrayOf(107, 0x314f),
            intArrayOf(108, 0x3163),
            intArrayOf(120, 0x314b),
            intArrayOf(99, 0x314c),
            intArrayOf(118, 0x314a),
            intArrayOf(98, 0x314d),
            intArrayOf(110, 0x315c),
            intArrayOf(109, 0x3161),
        )

    @JvmField
    val COMB_DUBUL_DANMOEUM_GOOGLE =
        arrayOf(
            intArrayOf(0x1100, 0x1100, 0x1101),
            intArrayOf(0x1103, 0x1103, 0x1104),
            intArrayOf(0x1107, 0x1107, 0x1108),
            intArrayOf(0x1109, 0x1109, 0x110a),
            intArrayOf(0x110c, 0x110c, 0x110d),
            intArrayOf(0x1161, 0x1161, 0x1163),
            intArrayOf(0x1162, 0x1162, 0x1164),
            intArrayOf(0x1163, 0x1175, 0x1164),
            intArrayOf(0x1165, 0x1165, 0x1167),
            intArrayOf(0x1167, 0x1175, 0x1168),
            intArrayOf(0x1166, 0x1166, 0x1168),
            intArrayOf(0x1169, 0x1161, 0x116a),
            intArrayOf(0x1169, 0x1162, 0x116b),
            intArrayOf(0x1169, 0x1175, 0x116c),
            intArrayOf(0x1169, 0x1169, 0x116d),
            intArrayOf(0x116e, 0x1165, 0x116f),
            intArrayOf(0x116e, 0x1166, 0x1170),
            intArrayOf(0x116e, 0x1175, 0x1171),
            intArrayOf(0x116e, 0x116e, 0x1172),
            intArrayOf(0x1173, 0x1175, 0x1174),
            intArrayOf(0x11a8, 0x11a8, 0x11a9),
            intArrayOf(0x11a8, 0x11ba, 0x11aa),
            intArrayOf(0x11ab, 0x11bd, 0x11ac),
            intArrayOf(0x11ab, 0x11c2, 0x11ad),
            intArrayOf(0x11af, 0x11a8, 0x11b0),
            intArrayOf(0x11af, 0x11b7, 0x11b1),
            intArrayOf(0x11af, 0x11b8, 0x11b2),
            intArrayOf(0x11af, 0x11ba, 0x11b3),
            intArrayOf(0x11af, 0x11c0, 0x11b4),
            intArrayOf(0x11af, 0x11c1, 0x11b5),
            intArrayOf(0x11af, 0x11c2, 0x11b6),
            intArrayOf(0x11b8, 0x11ba, 0x11b9),
            intArrayOf(0x11ba, 0x11ba, 0x11bb),
        )

    @JvmField
    val JAMO_NEBUL_1969 =
        arrayOf(
            intArrayOf(49, 0x31, 0x21),
            intArrayOf(50, 0x32, 0x22),
            intArrayOf(51, 0x33, 0xffe6),
            intArrayOf(52, 0x34, 0x24),
            intArrayOf(53, 0x35, 0x25),
            intArrayOf(54, 0x36, 0x5f),
            intArrayOf(55, 0x37, 0x3a),
            intArrayOf(56, 0x38, 0x27),
            intArrayOf(57, 0x39, 0x28),
            intArrayOf(48, 0x30, 0x29),
            intArrayOf(113, 0x1107, 0x1108),
            intArrayOf(119, 0x110c, 0x110d),
            intArrayOf(101, 0x1103, 0x1104),
            intArrayOf(114, 0x1100, 0x1101),
            intArrayOf(116, 0x1109, 0x110a),
            intArrayOf(121, 0x1169, 0x116d),
            intArrayOf(117, 0x1165, 0x1167),
            intArrayOf(105, 0x1161, 0x1163),
            intArrayOf(111, 0x1175, 0x1162),
            intArrayOf(112, 0x1166, 0x3f),
            intArrayOf(0x5b, 0x11a8, 0x11bd),
            intArrayOf(97, 0x1106, 0x110f),
            intArrayOf(115, 0x1102, 0x1110),
            intArrayOf(100, 0x110b, 0x110e),
            intArrayOf(102, 0x1105, 0x1111),
            intArrayOf(103, 0x1112, 0x2f),
            intArrayOf(104, 0x021169, 0x02116d),
            intArrayOf(106, 0x021165, 0x021167),
            intArrayOf(107, 0x021161, 0x021163),
            intArrayOf(108, 0x021175, 0x021162),
            intArrayOf(59, 0x021166, 0x021168),
            intArrayOf(39, 0x11b8, 0x11ae),
            intArrayOf(122, 0x11b7, 0x11c2),
            intArrayOf(120, 0x11ab, 0x11c0),
            intArrayOf(99, 0x11bc, 0x11be),
            intArrayOf(118, 0x11af, 0x11c1),
            intArrayOf(98, 0x02116e, 0x021172),
            intArrayOf(110, 0x116e, 0x1172),
            intArrayOf(109, 0x1173, 0x2e),
            intArrayOf(44, 0x021173, 0x2c),
            intArrayOf(46, 0x11ba, 0x11b9),
            intArrayOf(47, 0x11bb, 0x11ad),
            intArrayOf(0x2d, 0x2d, 0x2715),
            intArrayOf(0x3d, 0x3d, 0x2b),
            intArrayOf(128, 0x2e, 0x2c),
        )

    @JvmField
    val COMB_NEBUL_1969 =
        arrayOf(
            intArrayOf(0x1169, 0x1161, 0x116a),
            intArrayOf(0x1169, 0x1162, 0x116b),
            intArrayOf(0x1169, 0x1175, 0x116c),
            intArrayOf(0x116e, 0x1165, 0x116f),
            intArrayOf(0x116e, 0x1166, 0x1170),
            intArrayOf(0x116e, 0x1175, 0x1171),
            intArrayOf(0x1173, 0x1175, 0x1174),
            intArrayOf(0x1169, 0x021161, 0x02116a),
            intArrayOf(0x1169, 0x021162, 0x02116b),
            intArrayOf(0x1169, 0x021175, 0x02116c),
            intArrayOf(0x116e, 0x021165, 0x02116f),
            intArrayOf(0x116e, 0x021166, 0x021170),
            intArrayOf(0x116e, 0x021175, 0x021171),
            intArrayOf(0x1173, 0x021175, 0x021174),
            intArrayOf(0x11a8, 0x11a8, 0x11a9),
            intArrayOf(0x11a8, 0x11ba, 0x11aa),
            intArrayOf(0x11ab, 0x11bd, 0x11ac),
            intArrayOf(0x11ab, 0x11c2, 0x11ad),
            intArrayOf(0x11af, 0x11a8, 0x11b0),
            intArrayOf(0x11af, 0x11b7, 0x11b1),
            intArrayOf(0x11af, 0x11b8, 0x11b2),
            intArrayOf(0x11af, 0x11ba, 0x11b3),
            intArrayOf(0x11af, 0x11c0, 0x11b4),
            intArrayOf(0x11af, 0x11c1, 0x11b5),
            intArrayOf(0x11af, 0x11c2, 0x11b6),
            intArrayOf(0x11b8, 0x11ba, 0x11b9),
            intArrayOf(0x11ba, 0x11ba, 0x11bb),
        )

    @JvmField
    val VIRTUAL_NEBUL_1969 =
        arrayOf(
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021161, 0x1161),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021162, 0x1162),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021163, 0x1163),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021164, 0x1164),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021165, 0x1165),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021166, 0x1166),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021167, 0x1167),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021168, 0x1168),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021169, 0x1169),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x02116a, 0x116a),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x02116b, 0x116b),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x02116c, 0x116c),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x02116d, 0x116d),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x02116e, 0x116e),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x02116f, 0x116f),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021170, 0x1170),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021171, 0x1171),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021172, 0x1172),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021173, 0x1173),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021174, 0x1174),
            intArrayOf(HangulEngine.VIRTUAL_JUNG, 0x021175, 0x1175),
        )

    @JvmField
    val CONVERT_ENGLISH_DVORAK =
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
            intArrayOf(113, 0x27, 0x22),
            intArrayOf(119, 0x2c, 0x3c),
            intArrayOf(101, 0x2e, 0x3e),
            intArrayOf(114, 112, 80),
            intArrayOf(116, 121, 89),
            intArrayOf(121, 102, 70),
            intArrayOf(117, 103, 71),
            intArrayOf(105, 99, 67),
            intArrayOf(111, 114, 82),
            intArrayOf(112, 108, 76),
            intArrayOf(97, 97, 65),
            intArrayOf(115, 111, 79),
            intArrayOf(100, 101, 69),
            intArrayOf(102, 117, 85),
            intArrayOf(103, 105, 73),
            intArrayOf(104, 100, 68),
            intArrayOf(106, 104, 72),
            intArrayOf(107, 116, 84),
            intArrayOf(108, 110, 78),
            intArrayOf(0x3b, 115, 83),
            intArrayOf(0x27, 0x2d, 0x5f),
            intArrayOf(122, 0x3b, 0x3a),
            intArrayOf(120, 113, 81),
            intArrayOf(99, 106, 74),
            intArrayOf(118, 107, 75),
            intArrayOf(98, 120, 88),
            intArrayOf(110, 98, 66),
            intArrayOf(109, 109, 77),
            intArrayOf(0x2c, 119, 87),
            intArrayOf(0x2e, 118, 86),
            intArrayOf(0x2f, 122, 90),
            intArrayOf(0x2d, 0x5b, 0x7b),
            intArrayOf(0x3d, 0x5d, 0x7d),
            intArrayOf(0x5b, 0x2f, 0x3f),
            intArrayOf(0x5d, 0x3d, 0x2b),
        )

    @JvmField
    val CONVERT_ENGLISH_COLEMAK =
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
            intArrayOf(113, 113, 81),
            intArrayOf(119, 119, 87),
            intArrayOf(101, 102, 70),
            intArrayOf(114, 112, 80),
            intArrayOf(116, 103, 71),
            intArrayOf(121, 106, 74),
            intArrayOf(117, 108, 76),
            intArrayOf(105, 117, 85),
            intArrayOf(111, 121, 89),
            intArrayOf(112, 0x3b, 0x3a),
            intArrayOf(97, 97, 65),
            intArrayOf(115, 114, 82),
            intArrayOf(100, 115, 83),
            intArrayOf(102, 116, 84),
            intArrayOf(103, 100, 68),
            intArrayOf(104, 104, 72),
            intArrayOf(106, 110, 78),
            intArrayOf(107, 101, 69),
            intArrayOf(108, 105, 73),
            intArrayOf(0x3b, 111, 79),
            intArrayOf(122, 122, 90),
            intArrayOf(120, 120, 88),
            intArrayOf(99, 99, 67),
            intArrayOf(118, 118, 86),
            intArrayOf(98, 98, 66),
            intArrayOf(110, 107, 75),
            intArrayOf(109, 109, 77),
            intArrayOf(0x2c, 0x2c, 0x3c),
            intArrayOf(0x2e, 0x2e, 0x3e),
            intArrayOf(0x2f, 0x2f, 0x3f),
        )
}
