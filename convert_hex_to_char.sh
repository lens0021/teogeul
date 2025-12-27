#!/bin/bash

# Convert hex codes to character literals or HangulJamo constants for better readability
# Usage: ./convert_hex_to_char.sh <file>

if [ $# -eq 0 ]; then
    echo "Usage: $0 <file>"
    exit 1
fi

FILE="$1"

if [ ! -f "$FILE" ]; then
    echo "Error: File '$FILE' not found"
    exit 1
fi

# Create a temporary Python script to do the conversion
python3 - "$FILE" <<'EOF'
import sys
import re
import unicodedata

# Mapping from Unicode romanization to Hangul
JAMO_MAP = {
    # Consonants
    'KIYEOK': 'ㄱ', 'SSANGKIYEOK': 'ㄲ', 'NIEUN': 'ㄴ', 'TIKEUT': 'ㄷ',
    'SSANGTIKEUT': 'ㄸ', 'RIEUL': 'ㄹ', 'MIEUM': 'ㅁ', 'PIEUP': 'ㅂ',
    'SSANGPIEUP': 'ㅃ', 'SIOS': 'ㅅ', 'SSANGSIOS': 'ㅆ', 'IEUNG': 'ㅇ',
    'CIEUC': 'ㅈ', 'SSANGCIEUC': 'ㅉ', 'CHIEUCH': 'ㅊ', 'KHIEUKH': 'ㅋ',
    'THIEUTH': 'ㅌ', 'PHIEUPH': 'ㅍ', 'HIEUH': 'ㅎ',
    # Vowels
    'A': 'ㅏ', 'AE': 'ㅐ', 'YA': 'ㅑ', 'YAE': 'ㅒ', 'EO': 'ㅓ', 'E': 'ㅔ',
    'YEO': 'ㅕ', 'YE': 'ㅖ', 'O': 'ㅗ', 'WA': 'ㅘ', 'WAE': 'ㅙ', 'OE': 'ㅚ',
    'YO': 'ㅛ', 'U': 'ㅜ', 'WEO': 'ㅝ', 'WE': 'ㅞ', 'WI': 'ㅟ', 'YU': 'ㅠ',
    'EU': 'ㅡ', 'YI': 'ㅢ', 'I': 'ㅣ',
    # Special
    'KAPYEOUN': '각자병서', 'CHITUEUM': '치두음', 'CEONGCHIEUM': '정치음',
    'PAN': '반', 'YESIEUNG': '옛ㅇ', 'YEORINHIEUH': '여린ㅎ', 'FILLER': '채움',
    'SSANG': 'ㅆ',  # For SSANG prefix
}

def romanization_to_hangul(name):
    """Convert Unicode romanization to Hangul"""
    # Handle special cases first
    if name == 'SSANGRIEUL':
        return 'ㄹㄹ'
    if name == 'SSANGNIEUN':
        return 'ㄴㄴ'
    if name == 'SSANGIEUNG':
        return 'ㅇㅇ'

    # Split by hyphen
    parts = name.split('-')
    result = []

    for part in parts:
        if part in JAMO_MAP:
            result.append(JAMO_MAP[part])
        else:
            # Try compound words (CHITUEUMSIOS, KAPYEOUNPIEUP, etc.)
            found = False
            for prefix in ['CHITUEUM', 'CEONGCHIEUM', 'KAPYEOUN']:
                if part.startswith(prefix):
                    result.append(JAMO_MAP[prefix])
                    remainder = part[len(prefix):]
                    if remainder in JAMO_MAP:
                        result.append(JAMO_MAP[remainder])
                    found = True
                    break

            if not found:
                # Unknown part, keep as-is (shouldn't happen)
                result.append(part)

    return ''.join(result)

def get_hangul_jamo_constant(hex_val):
    """Get HangulJamo constant name for a hex value"""
    try:
        char = chr(hex_val)
        name = unicodedata.name(char)

        if "CHOSEONG" in name:
            jamo_part = name.replace("HANGUL CHOSEONG ", "")
            hangul_name = romanization_to_hangul(jamo_part)
            return f"HangulJamo.초성_{hangul_name}"
        elif "JUNGSEONG" in name:
            jamo_part = name.replace("HANGUL JUNGSEONG ", "")
            hangul_name = romanization_to_hangul(jamo_part)
            return f"HangulJamo.중성_{hangul_name}"
        elif "JONGSEONG" in name:
            jamo_part = name.replace("HANGUL JONGSEONG ", "")
            hangul_name = romanization_to_hangul(jamo_part)
            return f"HangulJamo.종성_{hangul_name}"
        elif "HANGUL LETTER" in name:
            # Compatibility Jamo (0x3131-0x318E)
            jamo_part = name.replace("HANGUL LETTER ", "")
            hangul_name = romanization_to_hangul(jamo_part)
            return f"HangulJamo.자모_{hangul_name}"
    except:
        pass

    return None

def hex_to_readable(match):
    """Convert hex code to character literal or HangulJamo constant"""
    hex_str = match.group(1)
    value = int(hex_str, 16)

    # Check if it's a Hangul Jamo
    jamo_const = get_hangul_jamo_constant(value)
    if jamo_const:
        return jamo_const

    # Convert printable ASCII (0x20-0x7E) to character literals
    if 0x20 <= value <= 0x7E:
        char = chr(value)
        # Handle special characters that need escaping
        if char == '\\':
            return "'\\\\'.code"
        elif char == '\'':
            return "'\\''.code"
        elif char == '"':
            return "'\"'.code"
        else:
            return f"'{char}'.code"
    else:
        # Keep other hex codes as-is
        return match.group(0)

def decimal_to_char(match):
    """Convert decimal ASCII codes to character literals"""
    full_match = match.group(0)
    decimal_str = match.group(1)
    value = int(decimal_str)

    # Common ASCII key codes: digits (48-57), letters (65-90, 97-122)
    # Only convert if it's at the start of intArrayOf (first position)
    if match.group(0).startswith('intArrayOf('):
        if 48 <= value <= 57:  # 0-9
            char = chr(value)
            return f"intArrayOf('{char}'.code,"
        elif 65 <= value <= 90:  # A-Z
            char = chr(value)
            return f"intArrayOf('{char}'.code,"
        elif 97 <= value <= 122:  # a-z
            char = chr(value)
            return f"intArrayOf('{char}'.code,"

    return full_match

# Read the file
with open(sys.argv[1], 'r') as f:
    content = f.read()

# Check if this is a layout file that needs HangulJamo import
needs_import = bool(re.search(r'0x1[0-9a-fA-F]{3}', content))

# First pass: Convert decimal key codes (first element in intArrayOf)
content = re.sub(r'intArrayOf\((\d+),', decimal_to_char, content)

# Second pass: Convert hex codes to character literals or HangulJamo constants
content = re.sub(r'0x([0-9a-fA-F]+)', hex_to_readable, content)

# Add HangulJamo import if needed and not already present
if needs_import and 'HangulJamo.' in content and 'import io.github.lens0021.teogeul.korean.HangulJamo' not in content:
    # Find the last import statement
    import_pattern = r'(import\s+[^\n]+\n)'
    imports = list(re.finditer(import_pattern, content))
    if imports:
        last_import = imports[-1]
        insert_pos = last_import.end()
        content = content[:insert_pos] + 'import io.github.lens0021.teogeul.korean.HangulJamo\n' + content[insert_pos:]

# Write back to file
with open(sys.argv[1], 'w') as f:
    f.write(content)

print(f"Converted hex codes in {sys.argv[1]}")
EOF
