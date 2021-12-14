# Objects

오브젝트 - 조영호 https://wikibook.co.kr/object/

---
## 목차

1. [객체, 설계](#1-객체-설계)
2. [객체지향 프로그래밍](#2-객체지향-프로그래밍)
3. [역할, 책임, 협력](#3-역할-책임-협력)
4. [설계 품질과 트레이드 오프](#4-설계-품질과-트레이드-오프)
5. [책임 할당하기](#5-책임-할당하기)
6. [메시지와 인터페이스](#6-메시지와-인터페이스)

<br/>  
  
## 1. 객체, 설계

- implementation ⇒ 구현
- 객체를 인터페이스와 구현으로 나누고 인터페이스만 공개하는 것은 객체 사이의 결합도를 낮추고 변경하기 쉬운 코드를 작성하기 위해 따라가야하는 가장 기본적인 설계 원칙
- 내부 구현을 외부에 노출하지 않고 자신의 문제를 스스로 책임지고 해결
    
    ⇒ 객체의 결합도는 낮아지며 자율성과 응집도는 올라간다
    
- 현실에서는 수동적인 존재라도 객체지향 세계에서는 모든것이 등록적으로 자율적인 존재가 된다 ⇒ 의인화 (anthropomorphism)
- 객체는 상태와 행동을 함께 가지는 복합적인 존재이며, 스스로 판단하고 행동하는 자율적인 존재이다.
- 객체 내부에 접근을 통제하는 이유 → 객체를 자율적인 존재로 만들기 위해
    - 객체 스스로 상태를 관리하고, 판단하고, 행동하는 자율적인 객체들의 공동체를 구성하는 것
- 설계가 필요한 이유 → 변경을 관리하기 위함
    - 객체 사이의 의존성을 적절히 관리함으로써 변경에 대한 파급 효과를 제어할 수 있다. 그 대표적인 방법중 하나가 접근제어 이다.
    

### 캡슐화

- 개념적으로나 물리적으로 객체 내부의 세부적인 사항을 감추는 것
- 목적 : 변경하기 쉬운 객체를 만드는것
    - 캡슐화를 통해 객체 내부의 접근을 제한 ⇒ 결합도가 낮아지며, 설계를 좀 더 쉽게 변경할 수 있게 된다a
- 외부에서 알 필요 없는 부분을 감춤으로써 대상을 단순화하는 추상화의 한 종류
- 불안정한 구현 세부사항(변경 가능성이 높은 부분) 을 안정적인 인터페이스 뒤로 캡슐화 하는것



---
<br/>
  
## 2. 객체지향 프로그래밍

### 상속과 의존성

- 부모 클래스에서 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식클래스에게 위임하는 디자인 패턴 ⇒ Template method 패턴
- 코드의 의존성과 실행시점의 의존성은 서로 다를 수 있다
    
    ⇒ 클래스 사이의 의존성과 객체 사이의 의존성은 동일하지 않을 수 있다
    
- 상속은 객체지량에서 코드를 재사용하기 위해 가장 널리 사용되는 방법이다
- 상속을 통해 자식클래스는 자신의 인터페이스에 부모클래스의 인터페이스를 포함한다 
⇒ 부모클래스가 수신할 수 있는 모든 메시지를 수신할 수 있으며, 외부 객체는 자식클래스와 부모클래스를 동일한 타입으로 간주한다. 
( 책의 '메시지를 전송한다' == '메서드를 호출한다')

### 다형성

- 외부 객체에서 전송한 메시지가 실제로 어떤 메서드가 실행될 것인지는 메시지를 수신한 객체의 클래스가 무엇이냐에 따라 달라지는것
- 컴파일 의존성은 부모클래스로 가지만, 실행 시의 의존성은 자식클래스로 향한다
→ 지연(lazy)바인딩, 동적(dynamic)바인딩 ↔️ 초기바인딩, 정적(static)바인딩
- 동일한 메시지를 수신했을 때 객체의 타입에 따라 다르게 응답할 수 있는 능력
- 상속을 이용하면 동일한 인터페이스를 공유하는 클래스들의 하나의 타입계층으로 묶을 수 있다


### 추상화

- 추상화를 사용하면 유연한 설계가 가능하다
- 세부적인 내용이 아닌 상위 개념을 쉽고 간단하게 표현하는 것 ( 인터페이스 )
- 새로운 구현 클래스를 추가하는것 만으로 애플리케이션의 기능을 확장할 수 있다

### 합성

- 인터페이스에 정의된 메시지를 통해서만 코드를 재사용하는 방법
- 구현을 효과적으로 캡슐화 할 수 있으며, 설계를 유연하게 한다
- 상속은 클래스를 통해 강하게 결합하며 합성은 메시지를 통해 느슨하게 결합한다]
- 코드 재사용성을 위해서는 상속보다는 합성을 선호한다

---


<br/>


## 3. 역할, 책임, 협력

<aside>
💡 객체지향 페러다임의 관점에서 핵심
⇒ 역할(Role), 책임(Responsibility), 협력(Collaboration)

</aside>

### 협력

> 어떤 객체가 다른 객체에게 무엇인가를 요청하는 것
> 
- 메시지 전송 : 객체 사잉의 협력을 위해 사용할 수 있는 유일한 커뮤니케이션 수단
- 객체를 자율적으로 만드는 가장 기본적인 방법 → 내부 구현은 캡슐화 하는 것
- 객체는 자신의 일을 자신이 처리하는 자율적인 존재이다
- 상태는 객체가 행동하는데 필요한 정보에 의해 결정되고, 행동은 협력안에서 객체가 처리할 메시지로 결정된다. **객체가 참여하는 협력이 객체를 구성하는 행동과 상태 모두를 결정한다**

### 책임

> 협력에 참여하기 위해서 객체가 수행하는 행동
> 
- 객체가 유지해야하는 정보와 수행할 수 있는 행동에 대해 대략적으로 서술한 문장
- 객체가 '무엇을 알고있는가'와 '무엇을 할 수 있는가' 로 구성
- 하는 것
    - 객체를 생성하거나 계산을 수행하는 등의 스스로 하는 것
    - 다른 객체의 행동을 시작하는 것
    - 다른 객체의 활동을 제어하고 조절하는 것
- 아는 것
    - 사적인 정보에 대해 아는 것
    - 관련된 객체해 관해 아는 것
    - 자신이 유도하거나 계산할 수 있는 것에 관해 아는 것
- **객체지향 설계에서는 책임이 가장 중요하다**
- 객체에게 얼마나 적절한 책임을 할당하느냐가 설계의 전체적인 품질을 결정한다
- 책임주도설계 ( Responsibility - Driven - Design )
    - 책임을 찾고 책임을 수행할 적절한 객체를 찾아 책임을 할당하는 방식
- **구현이 아닌 책임에 집중**
- 협력이 책임을 이끌어내고 책임이 협력에 함께할 객체를 결정한다
- 책임을 할당할 때 고려해야하는 2가지 요소
    1. 메시지가 객체를 결정한다
    
      : 객체가 메시지를 선택하는 것이 아니라 메시지가 객체를 선택한다
    
       → 최소한의 인터페이스와 추상적인 인터페이스를 가질 수 있게 된다.
    
    1. 행동이 상태를 결정한다
    
      :  협력 관계 속에서 다른 객체에게 무엇을 제공해야 하도 다른 객체로 부터 무엇을 얻어내야 하는지 고민해야만 훌륭한 책임을 수확할 수 있다.
    
    상태는 행동을 결정하고 나서야 비로소 결정할 수 있다
    
    협력이 객체의 행동을 결정하며 행동이 갹체의 상태를 결정한다 ( 행동 == 객체의 책임 )
    

### 역할

> 객체가 어떤 특정한 협력안에서 수행하는 책임의 집합
> 
- 역할은 여러개의 구체적인 객체를 포괄하는 추상화이다
- 역할을 이용하면 불편한 중복코드를 제거할 수 있으며, 협력이 더 유연해진다
- 설계초반에는 적절한 책임과 협력의 큰그림으로 탐색하고, 역할과 객체를 명확하게 구분하는 것은 그렇게 중요하지 않다.
필요한 순간에 객체로부터 역할을 분리해내는 것이 가장 좋은 방법이다.
- 객체는 다수의 역할을 보유할 수 있지만, 객체가 참여하는 특정 협력은 객체의 한가지 역할만 바라볼 수 있다
- 객체는 협력에 참여할 때 협력안에서 하나의 역할로 보여지며 다른 협력에 참여할 때는 다른 역할로 보여진다
- 협력의 관점에서 동일한 역할을 수행하는 객체들은 서로 대체 가능하다
역할은 특정한 객체의 종류를 캡슐화 하기 때문에 동일한 역할을 수행하고 계약을 준수하는 대체 가능한 객체들은 다형적이다

---


<br/>


## 4. 설계 품질과 트레이드 오프

<aside>
💡 객체지향 설계

⇒ 올바른 객체에게  __올바른 책임을 할당__  하면서  __낮은 결합도와 높은 응집도__  를 가진 구조를 창조하는 활동  

⇒ 객체의 활동에 초점을 맞춘다

</aside>

### 응집도

- 모듈 내의 요소들이 하나의 목적을 위해 긴밀하게 협력한다면 해당 모듈은 응집도가 높다
- 변경이 발생했을 때 모듈 내부에서 발생하는 변경의 정도
    - 하나의 변경
        - 하나의 모듈만 변경 ⇒ 높은 응집도
        - 여러개의 모듈 변경 ⇒ 낮은 응집도

### 결합도

- 의존성 정도. 다른 모듈에 대해 얼마나 많은 지식을 갖고 있는지 나타내는 척도
- 협력에 필요한 적절한 수준의 관계만을 유지해야한다
- 한 모듈이 변경되기 위해사 다른 모듈의 변경을 요구하는 정도
    - 하나의 모듈 수정
        - 함께 변경해야하는 모듈이 많음 ⇒ 높은 결합도
        - 함께 변경해야하는 모듈이 적음 ⇒ 낮은 결합도
        

**응집도와 결합도를 고려하기 전에 먼저 캡슐화를 향상시키기 위해 노력하라**

### 데이터 중심 설계 문제점

- 고립된 객체에 초점을 맞추기 때문에 캡슐화를 위반하기 쉽고, 요소들 사이에 결합도가 높아져, 코드를 변경하기 어려워짐
- 데이터 중심설계는 본질적으로 너무 이른시기에 데이터에 관해 결정하도록 강요한다 ⇒ 캡슐화 실패
- 협력이라는 문맥을 고려하지 않고 객체를 고립시킨채 오퍼레이션을 결정한다

---


<br/>



## 5. 책임 할당하기

### 책임 중심 설계

1. 데이터 보다 행동을 먼저 결정하라
    - 클라이언트 관점에서 객체가 수행하는 행동 == 객체의 책임
2. 협력이라는 문맥안에서 책임을 결정하라
    - 객체에게 할당된 책임의 품질은 협력에 적합한 정로로 결정된다
    - 객체의 입장에서는 책임이 조금 어색해 보이더라도, 협력에 적합하다면 그 책임은 좋은것이다
    - 메시지를 전송하는 클라이언트의 의도에 적합한 책임을 할당해야 한다.

### 책임할당을 위한 GRASP 패턴

> 일반적인 책임 할당을 위한 소프트웨어 패턴 (General Responsibility Assignment Software Pattern)
> 

<br/>


**Information Expert ( 정보 전문가 ) 패턴**

- 가장 기본적인 책임 할당 원칙
- 자신이 소유하고 있는 정보와 관련된 작업을 수행한다

<br/>


**Low Coupling ( 낮은 결합도 ) 패턴**

- 의존성은 낮추고 변화의 영향을 줄이며 재사용성을 증가하고 결합도가 낮게 유지되도록 책임을 할당하라

<br/>


**High Cohesion ( 높은 응집도 ) 패턴**

<br/>


**Creator ( 창조자 ) 패턴**

- 객체 A를 생성할 때, A를 잘 알고있거나, 긴밀하게 사용하거나 초기화에 필요한 데이터를 가지고 있는 객체를 Creator로 선택하는 것이 적절하다

<br/>


**Polymorphism ( 창조자 ) 패턴**

- 객체의 타입에 따라 변하는 행동이 있다면 타입을 분리하고 변화하는 행동을 각 타입의 책임으로 할당하라
    
    ![창조자패턴](https://user-images.githubusercontent.com/58412521/145680472-403758c0-8419-47bd-9f9a-fa52e1107a3e.jpg)
    
    ⇒ Movie와 DiscountCondition 사이의 협력은 다형적이다
    

<br/>


**Protected Variations ( 변경 보호 ) 패턴**

- 변경을 캡슐화 하도록 책임을 할당하는 것

<br/>


**Refactorying**

- 겉으로 보기는 동작은 바꾸지 않은채 내부 구조를 변경하는 것

---


<br/>



## 6. 메시지와 인터페이스

훌륭한 객체지향 코드를 얻기 위해서는 **클래스가 아니라 객체를 지향**해야 한다

→ 협력 안에서 객체가 수행하는 **책임**에 초점을 맞춰야 한다

### 협력과 메시지

<aside>
💡 condition.isSatisfiedBy(screening);
⇒ 수신자. 오처페이션명 ( 인자 )

</aside>

- 메서드
    - 메시지를 수신했을 때 실제로 실행되는 함수 혹은 프로시저
- 퍼블릭 인터페이스
    - 객체가 의사소통을 위해 외부에 공개하는 메시지의 집합
- 오퍼레이션
    - 퍼블릭 인터페이스에 포함된 메시지
    - 내부의 구현코드는 제외하고 단순히 메시지와 관련된 시그니처를 가리키는 경우가 대부분
- 시그니처
    - 오퍼레이션 (or 메서드)의 이름과 파라미터 목록을 합친 것

### 인터패이스와 설계 품질

- 좋은 인터페이스 : 최소한의 인터페이스 + 추상적인 인터페이스

<br/>


**디미터 법칙 ( Law of Demeter )**

- 객체의 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한하라
- 클래스 내부의 메서드가 조건을 만족하는 인스턴스에만 메시지를 전송하도록 프로그래밍해야한다
    
    ⇒  this 객체 / 메서드의 매개변수 / this의 속성 / 
         this의 속성인 컬렉션의 요소 / 메서드 내에서 생성된 지역 객체
    

<br/>


**묻지 말고 시켜라**

- 객체의 정보를 이용하는 행동을 객체의 외부가 아닌 내부에 위치
    
    ⇒ 정보와 행동을 동일한 클래스 안에 두게 된다
    

<br/>


**의도를 드러내는 인터페이스**

- 오퍼레이션의 이름은 객체 자신이 아닌 클라이언트의 의도를 표현해야한다

하지만, 원칙이 현재 상황에 부적합하고 판단된다면 과감하게 원칙을 무시해야한다

원칙을 아는것보다 더 중요한 것은 언제 원칙이 유용하고 언제 유용하지 않은지 판단할 수 있는 능력이다

<br/>


**명령-쿼리 분리 법칙 ( Command - Query - Seperator )**

- 루틴 : 호출 가능하도록 이름을 부여한 기능 모듈
- 프로시저 ( 명령 )
    - 부수효과 ( side effect )를 발생시킬 수 있지만 값을 반환할 수 없다
- 함수 ( 쿼리 )
    - 값을 반환할 수 있지만 부수효과를 발생할 수 없다
- 명령과 참조를 분리함으로써 명령어 언어의 틀 안에서 참조 투명성 ( Referential Transparency )의 장점을 제한적이나마 누릴 수 있게 된다
