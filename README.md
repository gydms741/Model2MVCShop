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

- MVC 패턴은 코드의 재사용에 유용하며, 사용자 인터페이스와 응용 프로그램 개발에 소요되는 시간을 줄여주는 효과적인 설계 방식을 말한다.

### MVC1과 MVC2 패턴 차이
- model1은 jsp 페이지 안에서 로직 처리를 위해 자바 코드가 함께 사용된다. 요청이 오면 직접 자바빈이나 클래스를 이용해 작업을 처리하고, 이를 클라이언트에 출력해준다. 구조가 단순한 장점이 있지만, JSP 내에서 html 코드와 자바 코드가 같이 사용되면서 복잡해지고 유지보수가 어려운 단점이 있다.
- model2는 모든 처리를 JSP에서만 담당하는 것이 아니라 서블릿을 만들어 역할 분담을 하는 패턴이다. 요청 결과를 출력해주는 뷰만 JSP가 담당하고, 흐름을 제어해주고 비즈니스 로직에 해당하는 컨트롤러의 역할을 서블릿이 담당하게 된다. 이처럼 역할을 분담하면서 유지보수가 용이해지는 장점이 있지만 습득하기 힘들고 구조가 복잡해지는 단점도 있다.

![다운로드](http://ontheinfo.com/wp-content/uploads/2016/07/MVC_model2.png)
