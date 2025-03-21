# Kiosk
 내일배움캠프 Spring 6기 자바 문법 종합반 과제입니다.

## 필수 기능 요구사항
### 클래스 정의
- Main: 시작 지점이 되는 클래스
- Kiosk: 프로그램 순서 및 흐름 제어를 담당하는 클래스
- Menu: MenuItem 클래스를 관리하는 클래스
  - 예시: 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함
- MenuItem: 세부 메뉴 속성을 가지는 클래스
  - 햄버거 이름, 가격 설명
  - 예시: new MenuItem("ShackBurger",6.9,"토마토,양상추,쉑소스가 토핑된 치즈버거")
- Cart: 사용자의 장바구니를 관리하는 클래스
  - 장바구니 추가, 삭제, 할인 등 사용자의 장바구니를 관리
- UserType: 사용자 유형에 따른 할인율을 관리
  - 국가유공자, 군인, 학생, 일반인
- Utils: 입력, 출력, 예외처리를 담당하는 유틸 클래스 
  - InputHandler, OutputHandler, ExceptionHandler
  - static 으로 정의
### Lv1. 기본적인 키오스크를 프로그래밍해보자
- 햄버거 메뉴 출력 및 선택하기
  - [x] 실행 시 햄버거 메뉴가 표시되고, 이후 Scanner로 숫자를 입력받아서 메뉴를 선택할 수 있다.
  - [x] 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성한다.
    - [x] 메뉴 범위에 해당하는 입력값이 아니면 예외를 발생시킨다.
  - [x] 반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료한다.
### Lv2. 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
- [x] MenuItem 클래스 생성하기
  - 개별 음식 항목을 관리하는 클래스로, 이름, 가격, 설명 필드를 갖는다.
- [x] main 함수에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력한다.
  - [x] MenuItem 객체 생성을 통해 이름, 가격, 설명을 세팅한다.
  - [x] List를 선언하여 여러 MenuItem을 추가한다.
### Lv3. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기
- [x] Kiosk 클래스 생성하기
  - 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스이다.
  - [x] MenuItem을 관리하는 리스트가 필드로 존재한다.
  - [x] main 함수에서 관리하는 입력과 반복문 로직은 start 함수를 만들어 관리한다.
  - [x] List<MenuItem> menuItems는 Kiosk 클래스 생성자를 통해 값을 할당한다.
### Lv4. 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기
- [x] Menu 클래스 생성하기
  - MenuItem 클래스를 관리하는 클래스이다.
  - [x] List<MenuItem>은 Menu 클래스가 관리하도록 변경한다.
- [x] 여러 버거들을 포함하는 상위 개념 '버거' 같은 '카테고리 이름' 필드를 갖는다.
  - 메뉴 카테고리 이름을 반환하는 메서드가 구현되어야 한다.
### Lv5. 캡슐화 적용하기
- [x] MenuItem, Menu 그리고 Kiosk 클래스의 필드에 직접 접근하지 못하도록 설정한다.
  - Getter와 Setter 메서드를 사용해 데이터를 관리한다.

## 도전 기능 요구사항
### Lv1. 장바구니 및 구매하기 기능을 추가하기
- 장바구니 생성 및 관리 기능
  - [x] 사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공한다.
  - [x] 장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회할 수 있어야 한다.
  - [x] 사용자가 잘못된 선택을 했을 경우 예외를 처리한다.
- 장바구니 출력 및 금액 계산
  - [x] 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력한다.
- 장바구니 담기 기능
  - [x] 메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 "추가", "취소" 처리한다.
    - 메뉴는 한 번에 1개만 담을 수 있다.
  - [x] 장바구니에 담은 목록을 출력한다.
- 주문 기능
  - [x] 장바구니에 담긴 모든 항목을 출력한다.
  - [x] 합산하여 총 금액을 게산하고, "주문하기"를 누르면 장바구니를 초기화한다.
### Lv2. Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리
- Enum을 활용한 사용자 유형별 할인율 관리하기
  - [x] 사용자 유형의 Enum 정의 및 각 사용자 유형에 따른 할인율 적용
  - 예시: 군인, 학생, 일반인
  - [x] 주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산
- 람다&스트림을 활용한 장바구니 조회 기능
  - [x] 기존에 생성한 Menu의 MenuItem을 조회할 때 스트림을 사용하여 출력하도록 수정
  - [ ] 기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용
    - stream.filter 활용
