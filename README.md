# jpa-docker-pg
spring jpa, docker, postgre를 활용한 프로젝트

<details>
  <summary>.yml 파일 설정</summary>
  
  - postgres:15 → 항상 최신 15버전으로 자동 업데이트됨 (가끔 비추천)   
  - postgres:15.6 → 고정 버전.
  - 비밀번호 정보가 들어간 .env 파일은 .gitignore에 추가해서 별도로 관리하기.  <br>
</details>

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

<details>
  <summary>pgAdmin에서 PostgreSQL 서버 연결하는 방법</summary>

### ✅ 1. pgAdmin에서 서버 추가

1. 첫 화면에서 새 서버 추가
2. 팝업창 뜨면 아래처럼 채우기:

---

### 🧩 General 탭

| 항목 | 값 |
|------|----|
| Name | `local-postgres` (자유롭게) |

---

### 🔌 Connection 탭

| 항목 | 값 |
|------|----|
| Host name/address | `db` ← **중요! docker-compose 안에서 db 컨테이너 이름 사용** |
| Port | `5432` |
| Maintenance database | `${POSTGRES_DB}` 예: `mydb` |
| Username | `${POSTGRES_USER}` 예: `postgres` 또는 `myapp` |
| Password | `${POSTGRES_PASSWORD}` 예: `secret123` |
| Save Password | ✅ 체크 |

※ 위 값들은 `.env` 파일 또는 `docker-compose.yml`의 `environment:` 아래 설정한 값.


## 🎯 연결 후

1. 왼쪽 트리에서 방금 만든 `local-postgres` 클릭
2. `Databases > mydb > Schemas > public > Tables` 로 내려가면
3. 스키마, 테이블 등 구조 확인 가능

</details>

<details>
  <summary>mysql, postgre 차이점</summary>

## ❗차이점 설명

| 항목 | MySQL | PostgreSQL |
|------|-------|-------------|
| 사용자 접속 제어 | `'user'@'localhost'`, `'user'@'%'` | **PostgreSQL은 `pg_hba.conf`로 제어** |
| 문자셋 지정 | `CHARACTER SET utf8mb4` | PostgreSQL은 기본이 UTF-8 (지정 필요 거의 없음) |
| 권한 부여 방식 | `GRANT ... ON db.*` | `GRANT ... ON DATABASE db` |

> PostgreSQL은 호스트 구분 없이 `pg_hba.conf` 파일에서 접속 방식 설정하므로, SQL 자체에는 `'@localhost'` 같은 구문이 없음.

---

</details>

<details>
  <summary>초기 실행 sql</summary>
  SQL 실행 - GRANT ALL PRIVILEGES ON DATABASE app_db TO app_user;
</details>

<details>
  <summary>db 테이블 생성</summary>

    CREATE TABLE IF NOT EXISTS "users" (  -- user는 postgre에서 예약어라 users로 변경
      email VARCHAR(50) PRIMARY KEY NOT NULL,
      name VARCHAR(50),  
      create_date TIMESTAMP  
    );  

    CREATE TABLE hotel_info (  
      hotel_id VARCHAR(50) PRIMARY KEY,  
      nm VARCHAR(50),  
      year INTEGER,
      grade VARCHAR(2),
      created TIMESTAMP,
      modified TIMESTAMP
    );

</details>
