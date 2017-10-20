DELETE FROM Customer;
INSERT INTO Customer(ID, CREATIONTIME, UPDATETIME, VERSION, FIRSTNAME, LASTNAME, PHONE, EMAIL ) VALUES
  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Rui', 'Silva', '989', 'some@something' ),
  (2, TIMESTAMP '2017-10-10 08:45:56.481', TIMESTAMP '2017-10-10 08:45:56.481', 0, 'Sergio', 'Silva', '876', 'some@something'),
  (3, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'Bruno', 'Silva', '090', 'some@something'),
  (4, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'No Accounts', 'Silva', '984', 'some@something');

DELETE FROM Account;
INSERT INTO Account(ACCOUNT_TYPE, ID, CREATIONTIME, UPDATETIME, VERSION, BALANCE, CUSTOMER_ID) VALUES
  ('CheckingAccount', 1, TIMESTAMP '2017-10-10 10:18:53.819', TIMESTAMP '2017-10-10 10:22:58.578', 2, 100.0, 1),
  ('SavingsAccount', 2, TIMESTAMP '2017-10-10 10:23:02.194', TIMESTAMP '2017-10-10 10:23:19.801', 1, 50.5, 1),
  ('CheckingAccount', 3, TIMESTAMP '2017-10-10 14:30:37.769', TIMESTAMP '2017-10-10 14:30:43.042', 1, 10.0, 2),
  ('SavingsAccount', 4, TIMESTAMP '2017-10-10 14:30:38.426', TIMESTAMP '2017-10-10 14:30:46.471', 1, 150.0, 2),
  ('CheckingAccount', 5, TIMESTAMP '2017-10-10 14:30:37.769', TIMESTAMP '2017-10-10 14:30:43.042', 1, 20.5, 3),
  ('SavingsAccount', 6, TIMESTAMP '2017-10-10 14:30:38.426', TIMESTAMP '2017-10-10 14:30:46.471', 1, 30.5, 3),
  ('CheckingAccount', 7, TIMESTAMP '2017-10-10 14:30:37.769', TIMESTAMP '2017-10-10 14:30:43.042', 1, 20.5, NULL );
