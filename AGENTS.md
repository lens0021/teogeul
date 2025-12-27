# Repository Guidelines

CONTRIBUTE.md을 같이 읽으십시오.

## 코딩 스타일 및 네이밍 규칙

Kotlin 소스는 4스페이스 들여쓰기, 같은 줄 여는 중괄호를 사용합니다.
함수/프로퍼티는 camelCase, 클래스는 PascalCase를 유지합니다. 패키지는
`io.github.lens0021.teogeul` 아래로 유지하세요. 리소스 파일은 소문자
`snake_case`(예: `layout/keyboard_panel.xml`)를 권장합니다. 불필요한 포맷팅
변경은 최소화합니다. Kotlin 스타일은 ktlint 기본 규칙을 따릅니다.

## 테스트 가이드

단위 테스트는 JUnit 4(`junit:junit:4.13.2`)를 사용합니다.
테스트 파일은 `*Test` 네이밍을 따르고 `app/src/test/java/`에 추가합니다.
명시된 커버리지 기준은 없으므로 로직 변경과 회귀 방지에 집중합니다.

## 린트(Lint) 설정 가이드

Android Lint는 기본값이 충분히 훌륭하므로 **간결함을 유지**합니다.

### build.gradle.kts 린트 설정

- `checkAllWarnings = true` 사용 (기본값 활용)
- 명시적인 `enable` 리스트는 작성하지 않음 (대부분 이미 활성화됨)
- 필요한 경우만 `disable`, `error`, `warning` 설정
- 예시:

  ```kotlin
  lint {
      checkAllWarnings = true
      disable += setOf("MissingTranslation")
      error += setOf("MissingPrefix")
  }
  ```

### lint.xml 설정

- **경로별 제외 설정만** 작성 (`<ignore path="..." />`)
- 단순 severity 설정은 build.gradle.kts에서 처리
- 기본값과 동일한 임계값 설정은 작성하지 않음
  - `TooManyViews` 기본값: 80
  - `TooDeepLayout` 기본값: 10
- 예시:

  ```xml
  <issue id="UnusedResources">
      <ignore path="**/build/**" />
  </issue>
  ```

**원칙**: 기본 설정으로 충분하다면 명시하지 않음. 유지보수성과 가독성을 우선합니다.

## AI 에이전트 지침

- 커밋 제목은 짧게 유지하고, 상세 내용은 PR 본문에 작성합니다.
- AI가 생성한 커밋에는 사용한 도구/모델에 맞는 메시지를 반드시 포함합니다.
  예시:

  ```text
  🤖 Generated with [Codex CLI](https://platform.openai.com/docs/codex)

  Co-Authored-By: GPT-5 <noreply@openai.com>
  ```

  ```text
  🤖 Generated with [Claude Code](https://claude.com/claude-code)

  Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>
  ```

- PR 업로드는 사람 계정에서 진행합니다.
- PR에는 요약, 테스트 결과(미실행 시 사유), UI/테마 변경 시 스크린샷을 포함하고, 관련 이슈가 있다면 링크합니다.
- PR 본문에서 AI가 작성한 내용은 blockquote(>)로 감싸서 작성합니다.
