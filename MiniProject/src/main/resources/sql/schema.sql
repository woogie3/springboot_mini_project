
create table BoardList(
    userid VARCHAR2(20),
    boardno NUMBER(4) PRIMARY key,
    boardtitle VARCHAR2(70),
    regdate DATE,
    boardpw VARCHAR2(100),
    imagesrc VARCHAR2(1000),
    filesrc VARCHAR2(1000),
    countp NUMBER(4),
    contentp VARCHAR2(2000),
    boardparent NUMBER(10),
    originno NUMBER(10),
    groupord NUMBER(10),
    grouplayer NUMBER(10)
);