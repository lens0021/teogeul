# Contribute

아래 내용은 기여자가 참고해야 할 기준입니다.

## 프로젝트 구조 및 모듈 구성
Android 앱은 `app/`에 있습니다. 주요 소스 코드는
`app/src/main/java/io/github/lens0021/teogeul/`에 있으며, 레이아웃 등 리소스는
`app/src/main/res/`, 에셋은 `app/src/main/assets/`에 있습니다. 네이티브 코드는
`app/src/main/cpp/`를 확인하세요. 단위 테스트는 `app/src/test/java/`에 있고,
빌드 산출물은 `app/build/`에 생성되므로 커밋하지 않습니다.

## 빌드, 테스트, 개발 명령어
- `./gradlew assembleDebug`: 디버그 APK 빌드
- `./gradlew installDebug`: 디바이스에 디버그 APK 설치
- `./gradlew testDebugUnitTest`: 로컬 JVM 단위 테스트 실행
- `./gradlew lint`: Android Lint 실행
- `./gradlew clean`: 빌드 산출물 정리
Windows에서는 `gradlew.bat`를 사용합니다.

