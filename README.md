# WEB Framework Basic Projcet

강아지의 정보를 입력받아 데이터베이스에 저장하고, 출력하는 애견샵 홈페이지 서비스를 구현합니다.

<br>

**<표. 파일이름 및 주요내용>**

| 파일 이름                 | 주요 내용 |
|-----------------------| --- |
| JDBCUtil.java         | . 패키지 명 : com.spring.dog.common <br> . JDBC 라이브러리를 이용하여 DB와 연결 및 해제를 구현<br>. 우리가 작업한 것 그대로 사용가능 |
| DogInfoDao.java       | . 패키지 명 : com.spring.dog.impl<br>. JDBCUtil.java를 이용하여 DB에 접근한다.<br>. DO를 이용하여 입력된 데이터를 DB에 저장하는 메소드 구현(insertDogInfo())<br>. DB에 저장되어 있는 전체 데이터 출력 메소드 구현 (getAllDogInfo()) |
| DogServiceImpl.java   | . 패키지 명 : com.spring.dog.impl<br>. DogService.java 인터페이스의 기능을 구현하는 클래스<br>. Dao를 이용하여 구현 |
| DogDo.java            | . 패키지 명 : com.spring.dog.service<br>. Do의 멤버변수는 본인이 중요하다고 생각하는 항목을 5개로 정하여 멤버변수로 사용(예. 보호자 이름, 강아지 종류 등.. )<br>. num 멤버변수 추가: 주키로 사용 (autoincrement 기능 이용하여 자동 저장되도록 구현) |
| DogService.java       | . 패키지 명 : com.spring.dog.service<br>. 기능 구현을 위한 인터페이스 객체로 사용<br>. insertDogInfo()/ getAllDogInfo() 인터페이스 구현 |
| DogMain.java          | . 패키지 명 : com.spring.dog.service<br>. main()를 포함하는 클래스<br>. Do에 임의의 데이터(테스트 데이터)를 저장한 후에, Dao 이용하여 DB에 저장 및 전체 데이터 가져오도록 구현 |
| applicationSettings.xml | . 어노테이션 또는 <bean>을 이용하여 객체 생성 및 주입기능 구현<br>. <bean> 이용 객체 생성시에 구현시에 초기치 설정 |
| 데이터베이스 테이블 구성         | . 위에서 입력받은 5개와 num을 포함하여 총 6개의 항목을 데이터베이스에 저장하기 위한 테이블 구성<br>. 번호를 추가하여 주키로 활용(데이터베이스에서 autoincrement 기능 활용) |