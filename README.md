# postup_api
postup project의  Restful api 서버입니다.


# 사용 기술

Spring boot , JPA(Hibernate), H2 DB



# 프로젝트 디렉토리 구조

cofig

-> WEB XSS(Cross Site Scripting) 문제를 해결하기위해 일단은 모두 허용으로 해놓았습니다.

Controller

-> Eintity명 + controller 형식으로 컨트롤러들의 이름을 만들었으며 , 해당하는 엔티티의 컨트롤러 역할을 합니다.


Entity

-> Hibernate 를 사용하기위한 엔티티 클래스들을 모아두었습니다.

Exception

-> 현재 데이터 저장 익셉션, 로그인 익셉션 만 핸들링하며 나머지 익셉션은 스프링부트 에 맡깁니다.


Model

-> JSon 형태를 맞추기위한 클래스들을 모아두었습니다.


Service

-> 서비스 기능을하는 클래스들을 모아두었으며 Entity명+Service 형식으로 인터페이스 이름을 지었습니다. 

또한 Entity명+Service+impl 에서 클래스로 구현합니다.

----
참고사항

현재 PostupApplication 클래스 내에서 

아래에 소스코드로 저장되는 데이터(파일,문서등) 을 프로그램 시작시 모두 지우게 설정해 두었습니다. 

해당 기능을 원하지않으면 삭제하시면됩니다.


```java
   @Bean
    CommandLineRunner init(DataServiceImpl dataService) {
        return (args) -> {
            dataService.deleteAll();
            dataService.init();
        };
    }
```


# 테스트 방법

Post man 어플리케이션을 기준으로 설명합니다.
(다른 API 테스트 툴을 써도 됩니다.)

1.  현재 프로젝트의 위키를 기준으로 URL 설정을 해줍니다.
2.  메소드 형식을 지정합니다.
3.  Body 에 Raw 를 선택하고 JSON형식으로 데이터를 적어줍니다.
4.  Send 를 한후 결과값이 제대로 오면 끝


기본설정

<img src=https://github.com/kseymin/postup_api/blob/master/Readme_img/Postman_Send.png/>

결과값

<center><img src=https://github.com/kseymin/postup_api/blob/master/Readme_img/Postman_Result.png/></center>
