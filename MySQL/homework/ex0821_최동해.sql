create table subject(
	sub_code varchar(5) primary key,
    subject varchar(20) not null
);

create table room(
	room_no int primary key,
    room_count int not null
);

create table teacher(
	t_no int primary key,
    t_name varchar(12) not null,
    t_jumin varchar(14) not null,
    t_phone varchar(14) not null,
    t_addr varchar(50),
    t_mail varchar(20),
    sub_code varchar(5) not null,
    foreign key(sub_code) references subject(sub_code)
);

create table student(
	s_no int primary key,
    s_name varchar(12) not null,
    s_jumin varchar(14) not null,
    s_phone varchar(14) not null,
    s_addr varchar(50),
    s_mail varchar(20)
);

create table sugang(
	s_no int primary key,
    sub_code varchar(5),
    foreign key(s_no) references student(s_no),
    foreign key(sub_code) references subject(sub_code)
);

create table sugangtb(
	sub_code varchar(5) primary key,
    room_no int,
    sgt_time int not null,
    t_no int,
    foreign key(sub_code) references subject(sub_code),
    foreign key(room_no) references room(room_no),
    foreign key(t_no) references teacher(t_no)
);

insert into subject values('j1001', 'sql');
insert into subject values('j1002', 'Win2000');
insert into subject values('j1003', 'ASP');
insert into subject values('j1004', 'Php');
insert into subject values('j1005', 'java');
insert into subject values('j1006', 'javascript');

select * from subject;

insert into room values(901, 34);
insert into room values(902, 35);
insert into room values(903, 25);
insert into room values(904, 32);
insert into room values(905, 30);
insert into room values(906, 35);

select * from room;

insert into teacher values(1, '홍길동', '700918-1622011', '031-295-1234', '성남시 중원구 신흥동', 'kkk@jok.or.kr', 'j1001');
insert into teacher values(2, '유관순', '810419-2018916', '02-345-2345', '서울 강남구 개포동', 'kkk@jok.or.kr', 'j1002');
insert into teacher values(3, '이승복', '730112-1344911', '031-1234-6789', '서울시 강남구 논현동', 'sss@jok.or.kr', 'j1003');
insert into teacher values(4, '모택동', '730301-1167623', '031-567-5678', '서울시 서초구 서초동', 'mmm@jok.or.kr', 'j1004');
insert into teacher values(5, '주롱지', '730322-2037921', '031-789-3456', '서울시 강서구 가양동', 'xxx@jok.or.kr', 'j1005');
insert into teacher values(6, '이순신', '731122-1646213', '031-234-8901', '서울시 강북구 미아동', 'ppp@jok.or.kr', 'j1006');

select * from teacher;

insert into student values(1, '김현진', '771212-2346111', '017-888-8888', '부산', 'aaa@hanmail.net');
insert into student values(2, '김석주', '720112-1234812', '016-999-9999', '경기', 'bbb@hanmail.net');
insert into student values(3, '고훈기', '730102-1555555', '017-555-5555', '서울', 'ccc@hanmail.net');
insert into student values(4, '유민경', '801111-2222222', '017-222-2222', '전남', 'ddd@hanmail.net');
insert into student values(5, '김영수', '811231-1777777', '017-777-7777', '충주', 'eee@hanmail.net');
insert into student values(6, '박상원', '790915-1333333', '017-333-3333', '강원', 'fff@hanmail.net');

select * from student;

insert into sugang values(1, 'j1001');
insert into sugang values(2, 'j1002');
insert into sugang values(3, 'j1003');
insert into sugang values(4, 'j1004');
insert into sugang values(5, 'j1005');
insert into sugang values(6, 'j1006');

select * from sugang;

insert into sugangtb values('j1001', 901, 2, 1);
insert into sugangtb values('j1002', 902, 2, 2);
insert into sugangtb values('j1003', 903, 2, 3);
insert into sugangtb values('j1004', 904, 2, 4);
insert into sugangtb values('j1005', 905, 2, 5);
insert into sugangtb values('j1006', 906, 2, 6);

select * from sugangtb;