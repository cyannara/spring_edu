create table tbl_reply (
    rno      number(10),
    bno      number(10) not null,
    reply    varchar2(1000) not null,
    writer   varchar2(50) not null,
    regdt    date default sysdate,
    upddt    date default sysdate );

create sequence seq_reply;

alter table tbl_reply add constraint pl_reply primary key(rno);
alter table tbl_reply add constraint fl_reply_board foreign key(bno) references tbl_board(bno);

INSERT INTO TBL_REPLY(RNO, BNO, REPLY, writer ) VALUES(SEQ_REPLY.NEXTVAL, 1, '댓글1', 'user1');
INSERT INTO TBL_REPLY(RNO, BNO, REPLY, writer ) VALUES(SEQ_REPLY.NEXTVAL, 1, '댓글2', 'user1');
INSERT INTO TBL_REPLY(RNO, BNO, REPLY, writer ) VALUES(SEQ_REPLY.NEXTVAL, 2, '댓글3', 'user1');      

commit;
select * from tbl_reply;

-- board 테이블에 댓글 수 컬럼 추가
alter table tbl_board add(replycnt number default 0);
update tbl_board set replycnt = (  select count(*) from tbl_reply where tbl_reply.bno = tbl_board.bno ) ;
commit;


-- 댓글의 페이징 처리하여 목록 조회
create index idx_reply on tbl_reply (bno desc, rno asc);

SELECT RNO,  BNO, REPLY, writer, REGDT
  FROM (  SELECT /*+  INDEX(tbl_reply, idx_reply) */
                          ROWNUM rn, RNO,  BNO, REPLY, writer, REGDT
            FROM TBL_REPLY
           WHERE BNO = 377
             AND rno > 0 
             AND ROWNUM <= 20
           )  a
WHERE RN > 0




