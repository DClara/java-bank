INSERT INTO CUSTOMER (ID,CREATIONTIME,UPDATETIME,VERSION,NAME) VALUES ('1',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'1','Duarte');
INSERT INTO CUSTOMER (ID,CREATIONTIME,UPDATETIME,VERSION,NAME) VALUES ('2',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'2','Pedro');
INSERT INTO CUSTOMER (ID,CREATIONTIME,UPDATETIME,VERSION,NAME) VALUES ('3',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'3','Joana');
INSERT INTO ACCOUNT (account_type,ID,CREATIONTIME,UPDATETIME,VERSION,BALANCE,CUSTOMER_ID) VALUES ('CheckingAccount','1',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'1','100','1');
INSERT INTO ACCOUNT (account_type,ID,CREATIONTIME,UPDATETIME,VERSION,BALANCE,CUSTOMER_ID) VALUES ('CheckingAccount','2',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'1','50','2');
INSERT INTO ACCOUNT (account_type,ID,CREATIONTIME,UPDATETIME,VERSION,BALANCE,CUSTOMER_ID) VALUES ('SavingsAccount','3',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'1','150','3');
INSERT INTO ACCOUNT (account_type,ID,CREATIONTIME,UPDATETIME,VERSION,BALANCE,CUSTOMER_ID) VALUES ('CheckingAccount','4',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'1','100','1');
INSERT INTO ACCOUNT (account_type,ID,CREATIONTIME,UPDATETIME,VERSION,BALANCE,CUSTOMER_ID) VALUES ('SavingsAccount','5',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),'1','120','2');