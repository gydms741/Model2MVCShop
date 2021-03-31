# Model2MVCShop
쇼핑몰 구현을 통해 Model 2 MVC Pattern 학습

## Model2MVCShop

MVC model 2 pattern 으로 구현하는 쇼핑몰 미니 프로젝트

본 프로젝트는 온라인 쇼핑몰 개발을 목적으로 한다. 실제 상용화가 아닌 개발 능력 향상을 위한 실습성격의 프로젝트이며, 
수 차례에 걸친 리팩토링을 통해 코드를 수정 해나간다. 

---

### 01. 기본 코드로 웹페이지 형성

- 주어진 기획서를 토대로 공통 모듈과 회원관리 코드 분석
- 상품관리 코드 직접 구현

### 02. 검색조건 유지 & 페이지 나누기(Page Navigation)

- 검색시 페이지 이동이 있을 경우 조건이 유지되도록 구현

### 03. JSP⇒ EL, JSTL 적용

- JSP안의 java 코드를 EL tag, JSTL tag로 변경

### 04. Spring, MyBatis 적용, TDD

- Spring Framework와 MyBatis Framework를 사용해 Business Logic 구현
- JUnit Framework 사용해 단위테스트

### 05. AOP 및 Transaction 추가

- 비즈니스 로직과 연계되어 공통적으로 사용하는 부분을 특정시점 코드에 삽입
- AOP를 통해 부가적 공통코드를 효율적으로 관리 가능

### 06. Annotation 적용

- 각 Controller에 Annotation 적용

### 07. URI mapping 변경

- .do ⇒ ./로 변경
- 웹을 플랫폼화 하여 다양한 View 지원위해 mapping방식 변경

### 08. Restful Server-Client

- 일관적인 인터페이스로 분리되어 각 브라우저와 디바이스에서 작동할 수 있게 적용

### 09. jQuery 적용

- jQuery이용해 JavaScript, Html 간 Coupling 관계 낮춤

---

### Model2MVC Pattern 이란?

[MVC](https://www.notion.so/MVC-2b5dcb4b629e41b99cf95bb9baece8c3)

모든 처리를 JSP페이지 하나가 담당하는 것과는 달리 JSP페이지와 Servlet, 그리고 Logic을 위한 클래스가 나뉘어 브라우저 요청을 처리한다.
![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1eabf8b2-a159-4124-8bea-951ccf42dd35/KakaoTalk_20201123_015632173.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1eabf8b2-a159-4124-8bea-951ccf42dd35/KakaoTalk_20201123_015632173.png)
