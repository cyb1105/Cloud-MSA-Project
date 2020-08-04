# README

##  마이크로서비스 기반 마이데이터 API Server 제공 플랫폼

#### FTA(File To API) 플랫폼은 공공데이터 뿐만 아니라, 데이터3법 시행에 따라 자유롭게 사용 가능해질 마이데이터 등과 같은 데이터를 사용자들에게 API Server로 제공함으로써4차 산업 혁명 시대에 경쟁력 있는 PaaS형 플랫폼으로 자리잡고자 한다.

##### 차별화 핵심 전략 기술

FTA 플랫폼의 차별화된 핵심 기술은 사용자 마다 데이터 API Server를 제공하는 것이다. 

첫째, 사용자는 자신이 가지고 있는 데이터 파일(.CSV)을 이용하여 나만의 API Server로 제공 받을 수 있다. 사용자가 데이터의 주체가 되기 때문에, 승인 절차와 같은 과정이 필요 없게 된다. 즉, 서비스 개발에 온전히 집중하고자 하는 사용자의 요구사항을 충족시킬 수 있다.

둘째, FTA 플랫폼은 개발플랫폼(PaaS)을 제공하기 때문에, 각 사용자들이 이를 사용함으로써 2차 파생 플랫폼의 효과를 낳을 수 있다. 즉, 사용자들은 API 플랫폼을 구축 후 자체 개발을 통해 비즈니스·서비스를 확장시킬 수 있다.

 이와 같은 차별화 핵심 전략 기술을 통해 FTA 플랫폼은 서비스 출시 기간 단축, 개발 비용 절감, 서비스의 확장성을 높일 수 있다. 



### Database DB설정

| service     | DB             |
| ----------- | -------------- |
| Upload      | upload_db      |
| UserService | myapp1         |
| ApiServer   | h2 Database    |
| crawlingapi | microservicedb |

#### UserService 추가설정

```mysql
Insert ignore into myapp1.roles(name) values('ROLE_USER');
Insert ignore into myapp1.roles(name) values('ROLE_ADMIN');
```


## API Server - URL Setting

### 1. 사용자 접근 권한 설정(UUID 사용)

#### 1.1 [데이터 전체 조회]

- localhost:{port}/{tablename}?key={사용자 Key Value}

예) localhost:8080/example?key=xyz


#### 1.2 [데이터 특정 칼럼 값 조회]

- localhost:{port}/{tablename}/detail?key={사용자 Key Value}&{테이블 헤더 값}={value}&...

  - 예)localhost:8080/example/detail?key=xyz&관할경찰서=파주경찰서


#### 1.3 [특정 테이블 삭제]

- localhost:{port}/{tablename}/delete?key={keyvalue}

  - 예) localhost:8080/example/delete?key=xyz


### 2. 사용자 접근 권한 설정 X(UUID 사용 안함)

**2.1 [사용자 별 table 정보 조회]**

- localhost:{port}/{userid}/tableinfo

  - 예) localhost:8080/user1/tableinfo


### 3. Frontend 와의 연동

#### 3.1 [POST 방식을 통해 userid, UUID 정보 저장]

- localhost:8080/start?user={userid}&userKey={userkey}

  - 예)localhost:8080/start?user=user1&userKey=xyz

사용자의 id, UUID를 Front의 Session으로 부터 할당받는다.


## 주요 기능



#### 1. 사용자가 업로드한 CSV 파일을 MySQL DB에 삽입 Service

- `repository/CsvToSqlRepository`



#### 2. DB Table 호출 시 JSON Type으로 출력하는 Service

- `repository/SqlToJsonRepository`



#### 3. Key 값을 통한 데이터 접근 권한 설정 Service

- `security/DatabaseAccessServiceIm`



## 환경 설정

1. 사용자 별 Key 정보, 생성된 Table list 정보는 JPA 방식 사용
2. 사용자가 업로드한 CSV file을 DB table에 삽입하기 위해서는 동적인 처리 과정이 필요하므로 JDBC 사용
3. Docker 자동 배포 서비스를 통해 
3. Front로 부터 POST 요청(Session 값 전달)이 들어을 때, Service(API Server) 가 가동된다.

