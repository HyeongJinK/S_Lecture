# 스프링 공부 겸 사이드 프로젝트

## 명세 
* 유저
  * 회원가입
  * 로그인
  * 유저 권한
* 게시판
  * 리스트
    * 페이징
    * 검색
  * 글쓰기
  * 수정하기
  * 삭제하기
* 할일
* 코스
  * 모듈
    * 토픽
* Swagger(apiDoc)

## 기술 스택

* 코드관리
  * git
* 라이브러리 관리
* 도커 이미지 관리
* 사용 언어
  * 자바
  * 코틀린
  * 자바 스크립트
* 프레임워크
  * Spring
  * 쿼커스
* 메시지 큐
  * 아파치 카프카
* DB
  * MySQL
  * MongoDB
* 컨테이너
  * Docker
  * Kubernetes
    * Helm
* 모니터링
  * 프로메테우스
  * Pinpoint
  * kiali
  * Pmm
* 로그 수집
  * ELK
* 문서화
  * Swagger
* 테스트
  * Junit
  * 소나큐브
* 코드 검증
* 인프라 관리
  * 앤서블



## 패키지 경로 규칙

---

<table>
  <tr>
    <td>경로</td>
    <td>하위경로</td>
    <td>명명규칙</td>
    <td>설명</td>
  </tr>

  <tr>
    <td>configuration</td>
    <td></td>
    <td>~Configuration</td>
    <td>설정파일</td>
  </tr>
  <tr>
    <td rowspan="2">domain</td>
    <td></td>
    <td>명사</td>
    <td>도메인</td>
  </tr>
  <tr>
    <td>enumable</td>
    <td>명사</td>
    <td>열거형</td>
  </tr>
  <tr>
    <td rowspan="3">repository</td>
    <td></td>
    <td>~Repository</td>
    <td>리포지토리</td>
  </tr>
  <tr>
    <td>custom</td>
    <td>~CustomRepository</td>
    <td>사용자 정의 리포 인터페이스</td>
  </tr>
  <tr>
    <td>impl</td>
    <td>~RepositoryImpl</td>
    <td>리포지토리 구현체</td>
  </tr>
  <tr>
    <td rowspan="2">service</td>
    <td></td>
    <td>~Service</td>
    <td>인터페이스</td>
  </tr>
  <tr>
    <td></td>
    <td>~ServiceImpl</td>
    <td>구현체</td>
  </tr>
  <tr>
    <td>controller</td>
    <td></td>
    <td>~Controller</td>
    <td>컨트롤러</td>
  </tr>
  <tr>
    <td>dto</td>
    <td></td>
    <td>~DTO</td>
    <td>데이터 전송객체</td>
  </tr>
  <tr>
    <td rowspan="3">adaptor</td>
    <td>client</td>
    <td>~Client</td>
    <td>Rest 클라이언트 동기 아웃바운드 처리</td>
  </tr>
  <tr>
    <td>consumer</td>
    <td>~Consumer</td>
    <td>비동기 인바운드 수신 처리</td>
  </tr>
  <tr>
    <td>producer</td>
    <td>~Producer</td>
    <td>비동기 아웃바운드 전송</td>
  </tr>
</table>

## 도메인 설명

### City

---
|이름|타입|설명|
|---|---|---|
|cityId | Long | 도시 고유키|
|cityName | String | 도시 이름|

## 프리젠테이션

## 비즈니스

## 퍼시스턴스
