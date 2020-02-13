select * from tab;
select * from seq;
select * from board;

--게시판 테이블
create table board(
	no number primary key,
	writer varchar2(20),
	subject varchar2(50),
	content varchar2(100),
	readcount number,
	register date
);

--시퀀스 생성
create sequence board_seq;

select * from board;