-- 각자의 데이터베이스 연결


/*
  Datatype의 종류
  1) 문자열   
      CHAR(n) : 고정길이 - 1~ 255 크기의 문자열 저장
      VARCHAR(n) : 가변길이 - 0~16383 문자열 저장
      
      * 위의 n의 의미는 byte수가 아닌 문자열의 수이다.
      * 반드시 문자는 '값'  or "값"  형식으로 사용한다.
      * Mysql에서  UTF-8 인코딩으로 한글자는 3BYTE이다!!
      
        EX) CHAR(6) : 한글, 영문 6글자
             VARCHAR(6) : 한글, 영문 6글자
            
    
  2) 숫자
      - 정수
       SMALLINT - 2byte
       INT - 4byte
       
      - 실수
          -부동소수점( float  , double)
          -고정소수점(decimal , numeric)
           ex) DECIMAL(20, 5)라고 하면 정수 15자리, 소수 5자리를 표현함
           
           
  3) 날짜      
     : DATE : 날짜만 있는 데이터 , YYYY-MM-DD 형태
       DATETIME : 날짜와 시간을 모두 포함하는 데이터 사용 , YYYY-MM-DD hh:mm:ss

      
      *날짜는 반드시 '년-월-일' 형식으로 묶어서 사용한다.
      * 현재 날짜와시간을 구하는 함수 now() 사용한다.
        EX) SELECT now();
        
	4) ENUM 
        : 선택 가능한 값 중 하나
		: ENUM('남', '여') 
    
    5) SET - 1정규화에 위배 될 수 있다.
        : 여러개 선택가능
        : SET('축구', '농구', '야구', '독서', '게임')
*/


/*
  -테이블 생성
create table 테이블이름( 
컬럼명 datatype  [ null | not null ] [제약조건 ] , 
컬럼명 datatype  [ null | not null ] [제약조건 ]  , 
..
)


  - 제약조건의 종류
   1) PRIMARY KEY : 대표키, 중복X, NOT NULL
   2) FOREIGN KEY :다른 테이블의 컬럼을 참조
   3) UNIQUE : PK유사(테이블에서 대표키는 될수 없는 그렇지만 유일해야하는 속성에 설정) 
   4) CHECK : 특정 컬럼의 값에 허용 될 수있는 조건 설정
   5) DEFAULT  : 기본값 설정

*/

/*
   1) PRIMARY KEY - PK, 기본키, 대표키
      : PK를 설정하면 중복안됨, NOT NULL , 자동으로 INDEX설정 - EX) 학번, 군번, 주민번호, 상품코드,...아이디...
      : PK는 하나의 테이블에 반드시 한개만 존재
      : 2개의 이상의 컬럼을 하나로 묶어서 PK설정 가능 
          - 복합키설정 : 사용할때 불편해서 모델링 과정속에서 복합키를 대리키로 변환하는 경우 많다!!!
*/
-- 테이블 생성
create table member(
   id varchar(20) primary key, -- unique, not null
   name varchar(10) not null,
   jumin char(13),
   age int,
   reg_date datetime
);

alter table member modify jumin char(15);


-- 검색
select * from member;

-- 테이블 구조 확인
desc member;

/*
  레코드 등록
  INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....);
  INSERT INTO 테이블이름 VALUES(값, 값,값,....); -- 모든 컬럼에 순서대로 값을 넣을때!!!
   INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....) ,(값, 값,값,....) , (값, 값,값,....) ..;  -- 여러데이터를 한번에 삽입 
*/
insert into member values('test', 'testname', '1234561234567', 20, now());


-- 중복 체크
insert into member(id, name, reg_date) values('test2', 'testname2', now());

insert into member(id, name, reg_date) values('test2', 'testname3', now()); -- 중복이라 등록 불가

-- not null 체크
insert into member(name, reg_date) values('testname2', now()); -- pk는 not null이라 값을 넣어야 함

-- 날짜 직접 넣기
insert into member(id, name, reg_date) values('test3', 'testname3', '2025-07-28');
insert into member(id, name, reg_date) values('test4', 'testname4', '2025-07-28 12:33:08');


-- MySQL에서 CHAR(n) vs VARCHAR(n)의 차이점 (공백 처리 차이)
/* char 고정길이는 오른쪽 공백을 자동 제거한다.  검색 할때 오른쪽  공백 무시된다. */

CREATE TABLE test_char (
    col1 CHAR(5)
);

INSERT INTO test_char (col1) VALUES ('A   '); -- 'A' 뒤에 공백 3개 포함
INSERT INTO test_char (col1) VALUES ('AB  '); -- 'AB' 뒤에 공백 2개 포함

select * , length(col1) as byte수 , char_length(col1) as 문자길이수 from test_char;

select * from test_char where col1='A';
select * from test_char where col1='A   '; 

/* varchar 가변길이는 입력한 값 그대로 저장되므로 오른쪽 공백도 포함 한다.. */
CREATE TABLE test_varchar (
    col1 VARCHAR(5)
);

INSERT INTO test_varchar (col1) VALUES ('A   '); -- 'A' 뒤에 공백 3개 포함
INSERT INTO test_varchar (col1) VALUES ('AB  '); -- 'AB' 뒤에 공백 2개 포함

select * , length(col1) as byte수 , char_length(col1) as 문자길이수 from test_varchar;
select * from test_varchar where col1='A';
select * from test_varchar where col1='A   '; 

-- 테이블 삭제
drop table member;

-- 하나의 테이블에 2개의 컬럼을 하나로 묶어서 PK설정
create table member(
   id varchar(20), -- unique, not null
   name varchar(10) not null,
   jumin char(13),
   age int,
   reg_date datetime,
   primary key(id, jumin)
);

-- 레코드 등록
insert into member(id, name, jumin, reg_date) values('test2', 'testname1', '12345', now());
insert into member(id, name, jumin, reg_date) values('test1', 'testname1', '12346', now());
insert into member(id, name, jumin, reg_date) values('test2', 'testname1', '12345', now());
insert into member(id, name, jumin, reg_date) values('test2', 'testname1', '12345', now());
insert into member(id, name, jumin, reg_date) values('test2', 'testname1', null, now());
select * from member;

/*
  2) FOREIGN KEY - FK = 외래키
      : 다른 테이블의 PK를 참조하는 것.
      : 테이블에 레코드를 추가할때 참조되는 대상의 값이외에는 등록 할 수 없다.
          - 참조무결성원칙!!!
      : NULL허용, 중복가능!!
      : 하나의 테이블에 여러개의 컬럼이 FK설정가능하다.
      
      : 재귀적관계 설계 - 자기자신테이블의 PK를 참조하는것!!!
      
      *주의사항
        INSERT 할때 : 부모키가 INSERT -> 자식 INSERT 
        DELETE할때 :  참조하고 있는 자식 DELETE -> 부모 DELETE 해야한다.
      
             * 이러한 주의사항에 대한 불편함을 해결하기 위해서.
               FK를 설정할때 ON DELETE CASCADE 를 추가하면 부모레코드를 삭제하를
              그 부모키를 참조하는 모든 테이블의 레코드를 함께 삭제한다.
	      또는 FK설정할때 on delete set null 를 추가하면
	      부모레코드 삭제될때 참조되는 자식레코드의 값이 null이된다.
      
      FOREIGN KEY는 InnoDB 엔진에서만 동작한다.
      MyISAM엔진에서는 외래 키 제약 조건이 무시되므로 데이터 무결성이 보장되지 않는다.
     테이블을 만들 때 반드시 ENGINE=InnoDB를 명시해야 한다.
       기존 테이블이 MyISAM이라면 ALTER TABLE ... ENGINE=InnoDB; 명령어로 변경 가능하다.
       
       -- 사용하고 있는 엔진 확인
       SHOW VARIABLES LIKE 'default_storage_engine';
       

      MySQL에서는 반드시 테이블 생성의 마지막 부분에서 FOREIGN KEY를 별도로 선언해야 한다.
     MySQL에서는 REFERENCES를 바로 컬럼 선언 뒤에 쓰는 방식을 지원하지 않는다.
*/

-- 데이터베이스 생성

create database exam;
-- 데이터베이스 선택
use exam;
-- 테이블 생성 : 부서테이블 
create table dept(
	dept_no int primary key,
    dept_name varchar(20) not null,
    dept_loc varchar(30)
);

-- 레코드 등록
insert into dept values(100, 'it', '서울'); 
insert into dept values(200, '경리', '경기');
insert into dept values(300, '교육', '대구');
insert into dept values(400, '인사', '서울');



-- 레코드 검색
select * from dept;
 
 -- 사원테이블 생성
 create table emp(
	emp_no int primary key,
    ename varchar(20) not null,
    dept_no int,
    sal int,
    hire_date datetime default now(),
    foreign key(dept_no) references dept(dept_no)-- null 가능, 중복 가능, 참조하는 테이블의 column값이 아닌건 등록 불가능
 );
 
 -- 레코드 등록
 select * from emp;
 insert into emp(emp_no, ename, dept_no, sal) values(1, 'test1', 200, 3000);
 insert into emp(emp_no, ename, dept_no, sal) values(2, 'test2', 200, 2500);
 insert into emp(emp_no, ename, dept_no, sal) values(3, 'test3', 100, 3000);
 insert into emp(emp_no, ename, dept_no, sal) values(4, 'test4', 150, 3000); -- dept 테이블의 dept_no에 150이란 값이 없음
 insert into emp(emp_no, ename, dept_no, sal) values(4, 'test4', null, 3000);
 insert into emp(emp_no, ename, dept_no, sal) values(5, 'test5', 300, 3000);

-- 부모 레코드 삭제
delete from dept where dept_no = 200;
delete from emp where dept_no = 200;
-- 먼저 참조하고 있는 자식레코드 삭제하고 --> 부모레코드 삭제

drop table emp;
drop table dept;

-- 직접 순서대로 삭제하는 부분이 번거롭다!!!! - fk설정할대 옵션(On delete cascade) 을 설정하면 자식 + 부모 함께 삭제해준다.
-- EMP테이블 삭제하고 다시 옵션설정해서 생성한다.
create table emp(
	emp_no int primary key,
    ename varchar(20) not null,
    dept_no int,
    sal int,
    hire_date datetime default now(),
    foreign key(dept_no) references dept(dept_no) on delete cascade -- null 가능, 중복 가능, 참조하는 테이블의 column값이 아닌건 등록 불가능
 );
 select * from dept;
 select * from emp;
 delete from dept where dept_no = 100;
 drop table emp;
 
 
 -- on delete set null 사용
 
 
create table emp(
	emp_no int primary key,
    ename varchar(20) not null,
    dept_no int,
    sal int,
    hire_date datetime default now(),
    foreign key(dept_no) references dept(dept_no) on delete set null -- null 가능, 중복 가능, 참조하는 테이블의 column값이 아닌건 등록 불가능
 );
 
 -- 레코드 추가
select * from emp order by dept_no asc;

-- -----------------------
create table emp(
	emp_no int primary key,
    ename varchar(20) not null,
    dept_no int,
    sal int,
    hire_date datetime default now(),
    foreign key(dept_no) references dept(dept_no) on delete set null -- null 가능, 중복 가능, 참조하는 테이블의 column값이 아닌건 등록 불가능
 );


-- 삭제
/*
   레코드 삭제방법
    1) ROLLBACK 처리가능 - DML
    
      DELETE FROM 테이블이름
      [WHERE 조건식]
      
        * where절 없이 delete or update를 MySQL Workbench 등에서 실행할 때 
         , safe update mode(안전 업데이트 모드)가 활성화되어 있으면 기본 키(PK) 또는 인덱스(KEY)가 없는 DELETE나 UPDATE 문을 허용하지 않음. 에러 발생
         
          즉, WHERE 절 없이 DELETE를 실행하면 전체 데이터가 삭제되므로, 실수로 데이터를 삭제하는 것을 방지하기 위해 제한이 걸려 있는 것이다.
          SET SQL_SAFE_UPDATES = 0;  -- 일시적으로 해제
          SET SQL_SAFE_UPDATES = 1;  -- 다시 활성화
          
            MySQL Workbench에서 영구적으로 Safe Mode를 끄려면 
				MySQL Workbench 실행
				Edit → Preferences → SQL Editor 선택
				"Safe Updates" 체크 해제
				MySQL Workbench를 다시 연결(Reconnect)
          
    2) ROLLBACK 안된다. - DDL
     TRUNCATE TABLE 테이블이름; --모든레코드를 삭제
      
      
      -- 기본적으로 MySQL은 AUTOCOMMIT 모드가 활성화 되어 있음
      SET AUTOCOMMIT = 0;  -- 자동 커밋 비활성화
      
          START TRANSACTION;    -- 트랜잭션 시작
           DELETE FROM userlist WHERE id = 1;  -- 레코드 삭제
           ROLLBACK;  -- 변경 사항 되돌리기
*/
delete from emp;
select * from emp;
set autocommit = 1;
rollback;

start transaction;
truncate table emp;

/*
  3) UNIQUE
      : 중복안됨, NULL허용(NOT NULL을 설정하면 PK와 동일) 
      : 후보키중에 대표키가 될수 없는 키를 UNIQUE 설정한다. 
      :  한테이블에 여러개의 컬럼에 설정가능
      
  4) CHECK
      : 조건을 설정하여 조건에 만족하지 않는 정보는 INSERT 할수 없다!
    
  5) DEFAULT
      : 기본값 설정(자주사용되는 값을 미리 설정해놓고 자동으로 값이 들어갈수 있도록 하는것)
      : EX) 등록일, 조회수....
      
*/
-- 테이블 생성
create table test(
	id varchar(10) primary key,
    jumin char(14) not null unique,
    name varchar(20) unique,
    age int check(age >= 20 and age <= 30),
    gender enum('남', '여'),
    reg_date datetime default now() not null
);

select * from test;

desc test;
drop table test;
 
 -- 레코드 추가 
insert into test values('test1', '1234', 'testname1', 25, '남', now());
insert into test(id, jumin, name, age, gender) values('test2', '1235', 'testname2', 23, '여');
insert into test values('test3', '1236', 'testname3', 25, '남', default);
insert into test values('test4', '1237', 'testname4', 25, '여', default);

-- AUTO_INCREMENT 설정
/*
  •	INT 타입에서 사용 가능하며 새로운 레코드가 추가될 때 자동 증가.
  •	PRIMARY KEY 또는 UNIQUE가 필요함.
  • AUTO_INCREMENT는 하나의 테이블에서 오직 하나의 컬럼에만 사용할 수 있다
  •	자동 증가하는 값은 테이블 내에서 하나의 시퀀스로 관리되므로, 
      여러 개의 AUTO_INCREMENT가 있으면 충돌이 발생할 수 있기 때문에 하나의 테이블에 한 개만 가능하다.
*/
create table member(
	id int primary key auto_increment,
    username varchar(20) not null,
    reg_date datetime
);
insert into member(username, reg_date) values('testname', now());
insert into member(username, reg_date) values('testname2', now());
insert into member values(30, 'testname2', now());
select * from member;

-- 다른 테이블에서 사용한 auto_increment의 값을 다른 테이블에서 참조하는 방법



drop table customer;
-- 고객테이블
create table customer(
  user_id varchar(30) primary key, -- 사용자ID
  user_pwd varchar(30) not null,-- 비밀번호
  user_name varchar(30),-- 이름
  reg_date date-- 가입일
);


insert into  customer values('jang','1111','유재석',now());
insert into  customer values('lee','1111','이효리',now());
insert into  customer values('kim','1111','송중기',now());
insert into  customer values('king','1111','송혜교',now());

-- 상품테이블
create table goods(
  goods_id varchar(20) primary key, -- 상품번호
  goods_name varchar(50) not null, -- 상품이름
  goods_price int ,-- 가격
  stock int, -- 재고량
  regdate datetime default now() -- 등록일
);


insert into goods values('A01','새우깡',1500,10,now());
insert into goods values('A02','허니버터칩',2500,10,now());
insert into goods values('A03','콘칩',2000,10,now());
insert into goods values('A04','빼빼로',1500,10,now());
insert into goods values('A05','감자깡',1500,10,now());

delete from goods;

-- 주문테이블
drop table orders;

create table orders(
  order_id int primary key auto_increment, -- 주문코드
  order_date datetime not null, -- 주문일자
  user_id varchar(30) not null references customer(user_id) , -- 주문한사람
  address varchar(100) not null, -- 배송지
  total_amount int not null -- 총구매금액
);


-- 주문상세
create table order_line(
  order_line_id int primary key auto_increment, -- 주문상세코드
  order_id int not null , -- 주문코드(주문아이디)
  goods_id varchar(20) not null , -- 상품아이디
  unit_price int not null, -- 단가
  qty int not null, -- 주문수량
  amount int not null, -- 단가*주문수량 한 금액
  foreign key(order_id) references orders(order_id) , 
  foreign key(goods_id) references goods(goods_id)
);

-- ---------------------------------------------------------------------
select * from orders;
-- 주문하기
 -- 1) jang 아이디가 A01 상품 2개, AO2 상품 1개 구입한다.
  INSERT INTO ORDERS(ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(now(),'jang','경기도 판교', 5500);
  
  -- 방금 삽입한 order_id 값 가져오기
SET @order_id = LAST_INSERT_ID();
  
insert into order_line(order_id, goods_id,unit_price, qty, amount)
values(@order_id , 'A01', 1500,2 , 3000 );
  
insert into order_line(order_id, goods_id,unit_price, qty, amount)
values(@order_id , 'A02', 2500,1 , 2500 );
  
  
  -- 주문수량만큼 재고량 감소시킨다.
  update goods set stock=stock-2 where goods_id='A01';
  update goods set stock=stock-1 where goods_id='A02';
 
 commit;
 
 select * from orders;
 select * from order_line;
 
 drop table order_line;
 drop table orders;
 
 -- 2) KIM 아이디가 A01 상품 3개 구입한다.
   INSERT INTO ORDERS( ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(now(),'kim','서울시 강남구', 4500);
  
    -- 방금 삽입한 order_id 값 가져오기
SET @order_id = LAST_INSERT_ID();

  insert into order_line(order_id, goods_id,unit_price, qty, amount)
  values(@order_id, 'A01', 1500,3 , 4500 );
  
  update goods set stock=stock-3 where goods_id='A01';

 
 -- 3) JANG 아이디가 A03 상품 2개와 A04 상품 1개 구입한다.
  INSERT INTO ORDERS( ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(now(),'jang','경기도 분당구', 5500);
  
    -- 방금 삽입한 order_id 값 가져오기
SET @order_id = LAST_INSERT_ID();

  insert into order_line(order_id, goods_id,unit_price, qty, amount)
  values(@order_id , 'A03', 2000,2 , 4000 );
  
   insert into order_line(order_id, goods_id,unit_price, qty, amount)
  values( @order_id , 'A04', 1500,1 , 1500 );
  
  update goods set stock=stock-2 where goods_id='A03';
  update goods set stock=stock-1 where goods_id='A04';
  
  
  
  -- -----------------------------------------------------
  select * from customer;
  select * from goods;
  select * from orders;
  select * from order_line;
  select order_id, sum(amount) from order_line group by order_id;
  
   drop table order_line;
  drop table orders;
  drop table goods;
  drop table customer;
  

  
  
  




CREATE TABLE sequence_table ( 
    seq_id INT AUTO_INCREMENT PRIMARY KEY 
);
 
CREATE TABLE products ( 
    product_id INT PRIMARY KEY, 
    batch_number INT NOT NULL 
); 

CREATE TABLE products2 ( 
    product_id INT PRIMARY KEY, 
    batch_number INT NOT NULL 
); 
 
INSERT INTO sequence_table () VALUES ();  -- 새로운 시퀀스 값 생성 
SET @new_id = LAST_INSERT_ID();           -- 방금 생성된 ID 가져오기 
 
select * from sequence_table;
select * from products;
INSERT INTO products (product_id, batch_number) VALUES (@new_id, 101);
INSERT INTO products2 (product_id, batch_number) VALUES (@new_id, 101);

-- 복합 키(Composite Key)와 AUTO_INCREMENT 조합

create table products3(
	product_id int auto_increment,
    name varchar(10),
    age int not null,
    primary key(product_id, name) 
);

select * from products3;
insert into products3(name, age) values('test', 30);


/*
  테이블 수정
  
 ① 컬럼추가
  alter table 테이블이름 add (컬럼명 자료형 [제약조건] , 컬럼명 자료형 [제약조건] , ....)
 
 ② 컬럼삭제
 alter table 테이블이름 drop column 컬럼이름
 
 ③ datatype변경
    alter table 테이블이름 modify 컬럼이름 변경자료형  [ not null | null ]
    
④ 컬럼이름 변경
 alter table 테이블이름 rename column 기존컬럼명 to 변경컬럼명
 
 ⑤ 제약조건 추가
  alter table 테이블이름 ADD CONSTRAINT 별칭 제약조건종류 ;
  
 -제약조건 삭제
  ALTER TABLE 테이블이름 DROP 제약조건;
  
 
 - 테이블 삭제
 drop table 테이블이름;

*/

-- 테이블 만들기
create table test(
  id varchar(20),
  name varchar(10),
  gender char(3)
);

drop table test;
select * from test;
desc test;

insert into test values('test1', 'testname1', 'man', 10);

-- 1. id에 pk 제약조건 추가
alter table test add constraint id primary key(id);

-- 1. id에 pk 제약조건 삭제
alter table test drop primary key;
 

-- name에 varcher(20)  not null로 변경
alter table test modify name varchar(20) not null;
-- 컬럼 추가
alter table test add column test int unique;

-- 컬럼이름 변경
alter table test rename column test to testint;

-- 컬럼 추가
alter table test add column test varchar(20) not null default 0;

-- 컬럼 삭제
alter table test drop column test;
select * from test;
-- 컬럼추가



/*
SQL의 종류
 - DDL문장(CREATE, DROP, ALTER, TRUNCATE)
 - DML문장(INSERT ,UPDATE, DELETE)
*/

/*
  데이터 조작 : DML(INSERT , UPDATE, DELETE)
   - ROLLBACK OR COMMIT 가능
   
   1) INSERT문장
       -INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....);
       -INSERT INTO 테이블이름 VALUES(값, 값,값,....); -- 모든 컬럼에 순서대로 값을 넣을때!!!
   
   2) DELETE문장
       DELETE [FROM] 테이블이름
       [WHERE 조건식]
   
   3) UPDATE문장
      UPDATE 테이블이름
      SET 컬럼명=변경값 , 컬럼명=변경값,....
      [WHERE 조건식] 

*/

select * from emp;
desc emp;
/*
   --테이블 복사
   CREATE TABLE 테이블이름
   AS 복사할테이블정보;
   
    주의 : 테이블을 복사하면 제약조건은 복사 안된다!!! - 복사한후에 제약조건을 ALTER를 이용해서 추가한다.

*/
-- 1) 모든 레코드 모든 컬럼 복사해보자
create table copy_emp as select * from emp;

select * from copy_emp;
alter table copy_emp add constraint primary key(empno);
desc copy_emp;

-- 2) 특정레코드 , 특정 컬럼만 복사해보자
create table copy_emp2 as select empno, ename, job, sal from emp where sal > 2500;
select * from copy_emp2;

-- 3) 테이블의 구조만 복사해보자.
create table copy_emp3 as select * from emp where 1=0;
drop table copy_emp3;
select * from copy_emp3;
desc copy_emp3;
-- copy_emp에서 empno가 7566 사원의 sal을 4000 , comm을 100 으로 변경해보자 

update copy_emp set sal = 4000, comm = 100 where empno=7566;
select * from copy_emp;



