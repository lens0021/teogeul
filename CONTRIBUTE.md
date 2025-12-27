# Contribute

## 프로젝트 구조 및 모듈 구성

Android 앱은 `app/` 모듈에 있습니다.

- 주요 소스: `app/src/main/java/io/github/lens0021/teogeul/`
- 리소스: `app/src/main/res/`
- 단위 테스트: `app/src/test/java/`
- 빌드 산출물: `app/build/` (커밋하지 않음)

### 주요 패키지 요약

- `config/`: 설정 키/기본값/레포지토리
- `compose/`: 조합 문자열 모델
- `di/`: 의존성 주입(Hilt) 모듈
- `input/`: 입력 이벤트, 레이아웃 변환, 키 처리
- `korean/`: 한글 엔진 및 레이아웃 레지스트리
- `layout/`: 레이아웃 데이터 집합
- `model/`: 키/키스트로크 모델
- `ui/`: 설정 UI

## 개발 환경 설정

- Java 17 사용
- Android SDK 경로 설정
  - 환경 변수: `ANDROID_HOME=/path/to/Android/Sdk`
  - 또는 `local.properties`에 `sdk.dir=/path/to/Android/Sdk`
- asdf 사용 시
  - `asdf plugin add java`
  - `asdf install` (프로젝트의 `.tool-versions` 사용)
  - `asdf set java <version>`

## 빌드, 테스트, 검증 명령어

- `./gradlew assembleDebug`: 디버그 APK 빌드
  - 빠른 빌드: `./gradlew assembleDebug --build-cache --configuration-cache --parallel`
- `./gradlew installDebug`: 디바이스에 디버그 APK 설치
- `./gradlew testDebugUnitTest`: 로컬 JVM 단위 테스트 실행
- `./gradlew lint`: Android Lint 실행
- `./gradlew lintJson`: JSON 포맷/유효성 검증
- `./gradlew clean`: 빌드 산출물 정리

Windows에서는 `gradlew.bat`를 사용합니다.

### adb 무선 디버깅

Android SDK의 adb를 사용하여 무선으로 기기에 연결할 수 있습니다:

```bash
# 페어링 (최초 1회)
adb pair <IP>:<페어링_포트> <페어링_코드>

# 연결
adb connect <IP>:<연결_포트>

# 기기 확인
adb devices -l

# APK 설치
adb install -r app/build/outputs/apk/debug/teogeul-debug-*.apk
```

## 하드웨어 영문 레이아웃 선택

하드웨어 영문 레이아웃은 앱 설정(하드웨어 영문 키보드 종류)으로 결정됩니다.

- 앱 설정 UI: `app/src/main/java/io/github/lens0021/teogeul/ui/SettingsActivity.kt`
- 적용 로직: `app/src/main/java/io/github/lens0021/teogeul/IMEService.kt`

## Android IME 처리 흐름 요약 (운영체제 관점)

물리 키보드 입력은 **OS가 KeyEvent로 전달**하고, IME는 이를 **가공해 앱에 전송**합니다.
아래는 Android의 일반적인 흐름을 요약한 것입니다.

- **키보드 → OS**
  물리 키보드는 스캔코드/키코드를 생성합니다. Android는 이를 `KeyEvent`로 변환하고
  메타 상태(Shift/Alt 등)를 포함해 IME/앱으로 전달합니다.
- **OS → IME (InputMethodService)**
  활성 IME가 `onKeyDown`/`onKeyUp` 콜백으로 `KeyEvent`를 받습니다.
  IME는 필요하면 이벤트를 소모(consume)하고, 조합 입력을 관리합니다.
- **IME → 앱 (InputConnection)**
  IME는 `InputConnection`을 통해 `setComposingText`, `finishComposingText`,
  `commitText` 등을 호출해 앱에 실제 텍스트를 전달합니다.
  조합이 끝나면 `finishComposingText`로 확정합니다.
- **OS 레벨 레이아웃**
  Android의 `InputMethodSubtype`는 IME가 어떤 키보드 레이아웃/언어를
  사용할지 알려주는 시스템 힌트입니다. IME는 이를 해석해 자체 레이아웃 변환을
  수행하거나, 앱 설정으로 폴백할 수 있습니다.

이 프로젝트는 하드웨어 키 입력을 `KeyEvent`로 받아 내부 레이아웃 변환 및
한글 조합 엔진을 거쳐 `InputConnection`으로 결과를 전달합니다.

### 단축키(CTRL/ALT/META) 처리 주의사항

하드웨어 키보드는 물리 키코드 기준으로 들어오므로, 영문 레이아웃이 Dvorak/Colemak인 경우
단축키에서도 동일한 레이아웃 변환을 적용해야 합니다. 변환 없이 시스템에 그대로 전달하면
물리 키가 QWERTY로 해석되어 Ctrl+L 같은 단축키가 Ctrl+P로 동작하는 문제가 발생할 수 있습니다.

### 물리 키보드 q/z 입력 예시

아래 예시는 **하드웨어 키보드의 q, z 키**를 눌렀을 때 이 앱이 실제로 처리하는
방식을 설명합니다. 공통적으로 OS가 전달한 `KeyEvent`를 IME가 받아 현재 모드
(영문/한글)와 설정된 레이아웃에 따라 내부 레이아웃 변환을 수행한 뒤,
`InputConnection`으로 확정/조합 텍스트를 전달합니다. 영문 레이아웃 설정은
영문 모드에만 적용되며, 한글 모드 처리에는 영향을 주지 않습니다.

- 영어 설정이 쿼티인 경우:
  - 영문 모드에서 q/z 키 이벤트를 **QWERTY 레이아웃**으로 해석합니다.
  - 변환 결과가 곧바로 `commitText`로 전달되어 "q", "z"가 입력됩니다.
- 영어 설정이 드보락인 경우:
  - 영문 모드에서 q/z 키 이벤트를 **Dvorak 레이아웃**으로 변환합니다.
  - Dvorak 매핑에 따라 "'", ";"가 입력됩니다.
- 한글 설정이 두벌식인 경우 (영어 설정과 무관):
  - 한글 모드에서 q/z 키 이벤트를 **두벌식** 레이아웃으로 변환합니다.
  - 두벌식 매핑에 따라 "ㅂ", "ㅋ"이 조합 입력으로 들어가고,
    조합 규칙에 따라 `setComposingText`/`finishComposingText`로 확정됩니다.
- 한글 설정이 세벌식 최종(391)인 경우 (영어 설정과 무관):
  - 한글 모드에서 q/z 키 이벤트를 **세벌식 최종(391)** 레이아웃으로 변환합니다.
  - 매핑에 따라 종성 "ㅅ", 종성 "ㅁ" 값이 입력됩니다
    (조합 중에는 `setComposingText`, 확정 시 `commitText`).

## 커밋 및 PR 가이드

semantic commit 규칙을 따릅니다. 예: `fix: ...`, `docs: ...`, `chore: ...`
