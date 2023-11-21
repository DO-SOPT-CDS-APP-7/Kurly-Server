# Kurly-Server

# 🔥  Git convention

### ✅ Commit Convention

- Feature : 새로운 기능 추가
- Fix : 버그 수정사항
- Hotfix : 급한 버그 수정
- Add : 파일 추가
- Rename :  파일, 폴더명 수정 또는 이동
- Remove : 파일 삭제 작업
- Docs : 문서 수정
- Test : 테스트 코드 추가
- Refactor : 코드 리팩토링
- Style : 코드 포맷 변경, 세미콜론 누락, 코드 수정 없는 경우
- Chore : 빌드 부분 혹은 패키지 매니저 수정사항

ex) [Feature] user API 구현

<br/><br/>

### ✅ Branch Convention

- [feature] : 기능 추가
- [fix] : 에러 수정, 버그 수정
- [docs] : README, 문서
- [refactor] : 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [modify] : 코드 수정 (기능의 변화가 있을 때)
- [chore] : gradle 세팅, 위의 것 이외에 거의 모든 것

ex) feature/read-product

### ➡️ 브랜치 전략

- `main` : 메인 브랜치
- `main`에 직접적인 commit, push는 가급적 금지합니다
- 작업 전, 반드시 `main` 브랜치를 pull 받고 시작합니다
  `git pull origin main`
- 기능 개발 시 `feature/기능` 브랜치를 파서 관리합니다
  `git branch feature/기능`
- 작은 기능별로 `commit message rules`에 따라 커밋을 진행합니다
- 작업 완료 시 `main` 브랜치로 Pull Request를 보냅니다
- 팀원과 코드리뷰를 진행한 후, 최종적으로 `main` 브랜치로 merge합니다
- 다 쓴 브랜치는 삭제합니다

<br/><br/>

# 🚀 Code Convention

### DB

- DB 이름은 **UpperCamelCase**를 사용합니다. → Product, Category,

### 함수, 변수, 타입

- 함수와 변수에는 **lowerCamelCase**를 사용합니다. → ex) getProductId
- 함수명은 동사로 시작합니다.
- 타입명은 **파스칼케이스**를 사용합니다. → PascalCase
    - interface이름에 I를 붙이지 않습니다.
- 기본 클래스 파일을 생성하거나 컴포넌트를 생성할 때는 약어 규칙에 따라 네이밍합니다.

### 변수 네이밍

- `사진` → photo
- `유저` → user
- `배열을 담은 변수`→ ~s(복수형)
- `상태` → status


<br/><br/>

## ⚙️ ERD
<img src="https://github.com/DO-SOPT-CDS-APP-7/Kurly-Server/assets/75441684/abafe7ef-43fe-411d-a6a1-b07232608c2e" width="400">
<br/><br/>

#  💻  Server 
|<img src="https://github.com/WOK-AT/WOKAT-SERVER/assets/75441684/a3503251-18b3-4f3e-9982-3cd2faab850f" width="200">| <img src="" width="200"> |
|:------:|:-----:|
|[김다현](https://github.com/dahyunnee)(Server)|[이혜연](https://github.com/hyeyeonnnnn)(Server)|
<br>
---
