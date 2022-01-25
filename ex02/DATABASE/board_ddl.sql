

create table tbl_board (
    bno        number(10) primary key,
    title      varchar2(200) not null,
    content    varchar2(2000)  not null,
    writer     varchar2(50)  not null,
    regdt      date default sysdate,
    upddt      date default sysdate 
);

create sequence seq_board;

insert into tbl_board(bno, title, content, writer) values(1,'테스트1','테스트내용','user1');
insert into tbl_board(bno, title, content, writer) values(2,'테스트1','테스트내용','user1');
insert into tbl_board(bno, title, content, writer) values(3,'테스트1','테스트내용','user1');
insert into tbl_board(bno, title, content, writer) values(4,'테스트1','테스트내용','user1');
insert into tbl_board(bno, title, content, writer) values(5,'테스트1','테스트내용','user1');

commit;


-- 페이징 처리
SELECT *
  FROM (    SELECT  /*+ INDEX_DESC(TBL_BOARD SYS_C007224)  */  
		   	       ROWNUM RN, BNO, TITLE, CONTENT, writer, REGDT, replycnt
			  FROM TBL_BOARD 
			 WHERE   ROWNUM <= 20
			    ) a
 WHERE RN > 0;
 
 
 --첨부파일
 create table tbl_attach (
    uuid        number primary key,
    uploadPath  varchar2(100) not null,
    fileName    varchar2(100)  not null,
    fileType    char(1)  not null,
    bno         number 
);
