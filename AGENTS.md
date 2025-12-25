# Repository Guidelines

## 코딩 스타일 및 네이밍 규칙
Java 소스는 4스페이스 들여쓰기, 같은 줄 여는 중괄호를 사용합니다.
메서드/필드는 camelCase, 클래스는 PascalCase를 유지합니다. 패키지는
`io.github.lens0021.teogeul` 아래로 유지하세요. 리소스 파일은 소문자
`snake_case`(예: `layout/keyboard_panel.xml`)를 권장합니다. 불필요한 포맷팅
변경은 최소화합니다.

## 테스트 가이드
단위 테스트는 JUnit 4(`junit:junit:4.13.2`)를 사용합니다.
테스트 파일은 `*Test` 네이밍을 따르고 `app/src/test/java/`에 추가합니다.
명시된 커버리지 기준은 없으므로 로직 변경과 회귀 방지에 집중합니다.

## 커밋 및 PR 가이드
최근 커밋은 `Fix: ...`, `Docs: ...`, `Chore: ...`처럼 짧고 목적이 드러나는 제목을
사용합니다. 커밋 제목은 간결하게, 상세 내용은 PR 본문에 적습니다. PR에는
요약, 테스트 결과(미실행 시 사유), UI/테마 변경 시 스크린샷을 포함하고,
관련 이슈가 있다면 링크합니다.

## AI 에이전트 지침
- 커밋 제목은 짧게 유지하고, 상세 내용은 PR 본문에 작성합니다.
- AI가 생성한 커밋에는 아래와 메시지를 반드시 포함합니다.

```
🤖 Generated with [Claude Code](https://claude.com/claude-code)

Co-Authored-By: Claude Sonnet 4.5 <noreply@anthropic.com>
```

- PR 업로드는 사람 계정에서 진행합니다.
- PR 본문에서 AI가 작성한 내용은 blockquote(>)로 감싸서 작성합니다.
