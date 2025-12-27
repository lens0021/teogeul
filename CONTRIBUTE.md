# Contribute

아래 내용은 기여자가 참고해야 할 기준입니다.

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
- `./gradlew installDebug`: 디바이스에 디버그 APK 설치
- `./gradlew testDebugUnitTest`: 로컬 JVM 단위 테스트 실행
- `./gradlew lint`: Android Lint 실행
- `./gradlew lintJson`: JSON 포맷/유효성 검증
- `./gradlew clean`: 빌드 산출물 정리
Windows에서는 `gradlew.bat`를 사용합니다.

## 하드웨어 영문 레이아웃 선택 (Subtype vs 앱 설정)

이 프로젝트는 **Android IME Subtype**과 **앱 설정(하드웨어 영문 키보드 종류)**를
모두 지원하며, 우선순위는 **Subtype > 앱 설정**입니다.

### 엔드유저 가이드

- Subtype은 **시스템이 관리하는 IME별 키보드 변형**입니다. 시스템 설정에서
  해당 키보드(Teogeul)의 Subtype을 선택하면, 앱은 그 값을 우선 적용합니다.
- Subtype은 **항상 하나가 선택된 상태**로 동작합니다. 다만 Subtype의
  `KeyboardLayoutSet` 값이 **기본값**이거나 **비어 있는 경우**에는, 앱 설정의
  `하드웨어 영문 키보드 종류`가 적용됩니다.
- 물리 키보드 레이아웃을 Dvorak/Colemak 등으로 쓸 때는 **Subtype으로 선택**하는
  편이 가장 확실합니다. 시스템이 현재 입력기에서 사용할 레이아웃을 알기 때문입니다.
- Subtype 선택 UI는 기기/제조사에 따라 다릅니다. 보통
  `설정 > 언어 및 입력 > 화면 키보드/물리 키보드 > Teogeul`에서 Subtype을 고르거나,
  키보드 전환 UI(예: 스페이스 길게 누르기)에서 변경합니다.
- 시스템에 Subtype 선택 UI가 없거나 동작이 불안정하면, **앱 설정만 사용**하세요.

### 기여자 참고 (구현 위치)

- Subtype 정의: `app/src/main/res/xml/method_ko.xml`
  (`KeyboardLayoutSet=...`가 `InputMethodSubtype.extraValue`로 전달됨)
- 앱 설정 UI: `app/src/main/java/io/github/lens0021/teogeul/ui/SettingsActivity.kt`
- 적용 로직: `app/src/main/java/io/github/lens0021/teogeul/IMEService.kt`
  (`InputMethodSubtype.extraValue`를 파싱해 레이아웃을 선택하고,
  기본값이면 앱 설정으로 폴백)

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

## 커밋 및 PR 가이드

semantic commit 규칙을 따릅니다. 예: `fix: ...`, `docs: ...`, `chore: ...`
