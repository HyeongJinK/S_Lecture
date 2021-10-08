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
