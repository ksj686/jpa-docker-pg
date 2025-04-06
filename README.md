# jpa-docker-pg
spring jpa, docker, postgre를 활용한 프로젝트

### .yml 파일 설정
- postgres:15 → 항상 최신 15버전으로 자동 업데이트됨 (가끔 비추천)
- postgres:15.6 → 고정 버전.
- 비밀번호 정보가 들어간 .env 파일은 .gitignore에 추가해서 별도로 관리하기.

<details>
  <summary>docker 명령어 모음</summary>
  <사용하는 명령어><br>
  docker-compose up -d .yml 파일 기반 설치
  <br> docker start postgres15_6 pgadmin 컨테이너(postgres15_6,  pgadmin) 실행
  <br> docker stop postgres15_6 pgadmin 컨테이너 중단
  <br> docker-compose down 컨테이너 중지 (.yml 파일이 있는 경로에서 실행)
  <br> docker-compose down -v 볼륨 포함 삭제
  <br> docker-compose down --rmi all -v 이미지까지 삭제
  <br><br>
  
  <기본명령어><br>
  docker-compose up -d	컨테이너 최초 실행 또는 재실행 (필요시 재생성 포함)
  <br> docker ps 실행중인 컨테이너 확인
  <br> docker start <컨테이너명>	이미 생성된 컨테이너를 다시 시작할 때 사용
  <br> docker ps -a	정지된 컨테이너 목록 포함 전체 컨테이너 확인
  <br> docker logs <컨테이너명>	컨테이너 로그 확인해서 정상 작동 여부 체크
</details>
