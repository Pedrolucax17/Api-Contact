CREATE SEQUENCE CONTACT_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_CONTACTS(
    ID INTEGER DEFAULT CONTACT_SEQ.NEXTVAL NOT NULL,
    NAME VARCHAR2(100) NOT NULL,
    EMAIL VARCHAR2(100) NOT NULL,
    BIRTH_DATE DATE NOT NULL
);