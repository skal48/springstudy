DROP SEQUENCE MOVIE_SEQ;
CREATE SEQUENCE MOVIE_SEQ NOCACHE;

DROP TABLE MOVIE;
CREATE TABLE MOVIE (
   NO NUMBER NOT NULL
 , TITLE VARCHAR2(100 BYTE)
 , GENRE VARCHAR2(100 BYTE)
 , DESCRIPTION VARCHAR2(500 BYTE)
 , STAR  NUMBER
 CONSTRAINT PK_MOVIE PRIMARY KEY
); 
 
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '�͹̳�����', 'SF', '�ΰ��� ����� ������', 5);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '�ƹ�Ÿ', 'SF', '�ǵ��� �༺���� ���� �η�', 5);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '���ϸ���', '����', '���ϸ������ ����', 4.5);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '���ҽý�Ʈ', '����', '�Ǹ��� ���� ���� ����', 3.5);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '���ũŻ��', '���', '����� �ʸ� �����Ӱ� �ϸ���', 1);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '������', '���', '�ҸӴ� �� �Ծ��', 2.5);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '��-E', '�ִϸ��̼�', '��-E�� �ŷ����� �̺�', 1.5);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '���� ġ������ ��ߺҸ�', '�ִϸ��̼�', '������ �ŵ��� ����� �� ġ����', 2);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '���ӽ�ĵ��', '�ڹ̵�', '�����λ� �� ������ ����', 3);  
INSERT INTO MOVIE VALUES(MOVIE_SEQ.NEXTVAL, '�������� �׳�', '�ڹ̵�', '�߿�� �̾���', 4);  
