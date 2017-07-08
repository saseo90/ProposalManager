-- 아래 구문 주석해제 시 HSQL 드라이버로 실행할 수 있다.
SET DATABASE SQL SYNTAX ORA TRUE;

--최종수정일 : 2017.07.08.
--수정일       : 2017.07.08. 20시
--규칙          : 테이블 및 칼럼 이름은 소문자 나머지 대문자

--0.삭제
--1.테이블 생성
--1.1.관라지정보(adminInfo)
--2.외래키 추가 : FK_테이블이름_컬럼이름 
--3.시퀀스 생성
--4.기초데이터
--4.1.관리자정보(adminInfo) 기초데이터


--0.삭제(생성의 반대순서로 삭제한다.)
--DROP TABLE adminInfo;

--1.생성
--1.1.관라지정보(adminInfo)
CREATE table adminInfo (
    adminNo       NUMBER(10)  PRIMARY KEY,
    adminId       VARCHAR(20) NOT NULL,
    adminPassword VARCHAR(20) NOT NULL,
    adminName     VARCHAR(20) NOT NULL
);

--4.기초데이터
--4.1.관리자정보(adminInfo) 기초데이터
insert into adminInfo (adminNo,adminId,adminPassword,adminName) values(1,"admin","0000","관리자");
insert into adminInfo (adminNo,adminId,adminPassword,adminName) values(2,"admin01","0000","관리자1");
insert into adminInfo (adminNo,adminId,adminPassword,adminName) values(3,"admin02","0000","관리자2");