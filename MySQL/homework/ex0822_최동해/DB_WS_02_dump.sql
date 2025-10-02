-- WS01 users테이블을 생성한 데이터베이스에서 작업한다.
USE EXAM;

create table users(
	user_seq int primary key,
    name varchar(10),
    email varchar(30) not null unique,
    phone varchar(20),
    is_sleep enum('Y', 'N') default 'N'
);

select * from users;

insert into users (user_seq, name, email, phone) values (444, '사길동', 'sa@gildong@com', '010-4444-4444');
insert into users (user_seq, name, email, phone) values (555, '오길동', 'o@gildong@com', '010-5555-5555');

insert into users (user_seq, name, email, phone) values (111, '홍길동', 'hong@gildong@com', '010-1111-1111');
insert into users (user_seq, name, email, phone) values (222, '이길동', 'lee@gildong@com', '010-2222-2222');
insert into users (user_seq, name, email, phone) values (333, '삼길동', 'sam@gildong@com', '010-3333-3333');

select * from users;

update users set is_sleep = 'Y' where user_seq = 222;

-- 5. 아래의 값으로새로운1건의데이터를insert 해 보고오류를확인한다.
insert into users (user_seq, name, email, phone) values (222, '이길동2', 'lee2@gildong@com', '010-2222-2222'); -- duplicate. primary key.

-- 6. 아래의 값으로새로운1건의데이터를insert 해 보고오류를확인한다.
insert into users (user_seq, name, email, phone) values (2222, '이길동2', 'lee@gildong@com', '010-2222-2222'); -- duplicate. users.email(unique 조건)

--  7. 아래의 값으로새로운1건의데이터를insert 해 보고오류를확인한다.
insert into users (user_seq, name, phone) values (2222, '이길동2', '010-2222-2222'); -- not null조건. 혹은 default value가 없어서.

--  8. 아래의 값으로새로운1건의데이터를insert 한다.
insert into users (user_seq, name, email, phone) values (2222, '이길동2', 'lee2@gildong@com', '010-2222-2222');

-- 9. 위 8번 등록건을확인하고삭제한다.
select * from users;
delete from users where user_seq = 2222;

--  10. users 테이블을 삭제하고 1 – 4번까지 다시 실행한다
drop table users;


CREATE TABLE account
( 
    account_seq   INT PRIMARY KEY,
    account_number VARCHAR(50) not null,
    balance       INT,
    user_seq      INT,
    foreign key(user_seq) references users(user_seq)
);

insert into account (account_seq, account_number, balance, user_seq) values (50, '00500505005005', 3000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (10, '00100101001001', 1000, 111);
insert into account (account_seq, account_number, balance, user_seq) values (30, '00300303003003', 5000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (70, '00700707007007', 7000, 444);
insert into account (account_seq, account_number, balance, user_seq) values (40, '00400404004004', 4000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (60, '00600606006006', 2000, 222);
insert into account (account_seq, account_number) values (80, '00800808008008');
insert into account (account_seq, account_number, balance, user_seq) values (20, '00200202002002', 6000, 111);

SELECT * FROM USERS;
SELECT * FROM ACCOUNT;

--  1. 고객번호 ( user_seq ) 가 111 인 계좌 ( account ) 테이블을 조회한다.
select * from account where user_seq = 111;

-- 2. 잔고 ( balance ) 가 5000 미만인 계좌 ( account ) 테이블을 조회한다.
select * from account where balance < 5000;
 
--  3. 잔고 ( balance ) 가 5000 이상 10000 이하인 계좌 ( account ) 테이블을 조회한다.
select * from account where balance between 5000 and 10000;
 
-- 4. 계좌번호 ( accountNumber ) 중 ‘4’ 를 포함하는 계좌 ( account ) 테이블을 조회한다.
select * from account where account_number like '%4%';
 
--  5. 고객명 ( name ) 이 ‘삼‘ 을 시작하는 고객 ( users ) 테이블을 조회한다.
select * from users where name like '삼%';
 
--  6. 계좌 ( account ) 테이블에 있는 고객 번호 ( user_seq ) 를 중복없이 조회한다.
select distinct user_seq from account;

--  7. 잔고 ( balance ) 가 없는 ( null ) 계좌 ( account ) 테이블을 조회한다.
select * from account where balance is null;

-- 8. 고객번호 ( user_seq ) 가 있는 계좌 ( account ) 테이블을 조회한다.
select * from account where user_seq is not null;

-- 9. 고객번호 ( user_seq ) 가 있고, 잔고가 4000 이하인 계좌 ( account ) 테이블을 조회한다.
select * from account where user_seq is not null and balance <= 4000;
 
-- 10. 계좌 ( account ) 테이블을 고객번호 ( user_seq ) 기준으로 오름차순으로 정렬하여 조회한다.
select * from account order by user_seq;
  
-- 11. 계좌 ( account ) 테이블을 고객번호 ( user_seq ) 기준으로 오름차순으로, 그리고 그 안에서 잔고( balance ) 기준으로 내림차순으로 정렬하여 조회한다.
select * from account order by user_seq, balance desc;

-- 12. 계좌 ( account ) 테이블을 조회하되, balance 값이 없으면 0 으로 표시한다.
select account_seq, account_number, ifnull(balance, 0) balance, user_seq from account;

--  13. 고객 ( users ) 테이블을 조회하되, email은 @포함 뒷 부분은 빼고 앞 아이디만 표시한다. 컬럼명도email 대신 email_id 로 변경한다.
select user_seq, name, substring(email, 1, locate('@', email)-1) email_id, phone, is_sleep from users;

--  14. 고객 ( users ) 테이블을 조회하되, phone 의 ‘-’ 를 제외하고 표시한다. 컬럼명도 phone_short 로변경한다.
select user_seq, name, email, replace(phone, '-', '') phone_short, is_sleep from users;

-- 15. 계좌 ( account ) 테이블에서 고객번호 ( user_seq ) 가 222 인 건 수를 조회한다.
select count(*) from account where user_seq = 222;

-- 16. 계좌 ( account ) 테이블의 전체 잔고 ( balance ) 의 합을 조회하고 balance_sum 으로 표시한다
select sum(balance) balance_sum from account;

-- 17. 계좌 ( account ) 테이블의 잔고 중 최소갑과 최대값을 조회하고 각각 balance_min, balance_max 로 표시한다
select min(balance) balance_min, max(balance) balance_max from account;

--  18. 계좌 ( account ) 테이블에서 고객번호와 고객번호 ( user_seq ) 별 계좌 건수를 조회하고 user_account_cnt 로 표시한다. 단, 고객번호 ( user_seq ) 가 없는 건은 제외한다.
select user_seq, count(user_seq) user_account_cnt from account where user_seq is not null group by user_seq;

-- 19. 계좌 ( account ) 테이블에서 고객번호와 고객번호 ( user_seq ) 별 잔고의 합을 조회하고 user_balance_sum 로 표시한다. 단, 고객번호 ( user_seq ) 가 없는 건은 제외한다
select user_seq, sum(balance) user_balance_sum from account where user_seq is not null group by user_seq;

--  20. 위 19번의 결과 중 user_balance_sum 이 10000 이하인 건만을 조회한다
select user_seq, sum(balance) user_balance_sum from account where user_seq is not null group by user_seq having sum(balance) <= 10000;
