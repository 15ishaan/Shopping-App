insert into PRODUCT values (1, 0, 100, 100);

insert into USER values(1, 'X', 'Gupta', 'X@gmail.com', 'ABC', 'ABC', 'user', TRUE);
insert into USER values(2, 'Y', 'Mehta', 'Y@gmail.com', 'ABC', 'ABC', 'user', TRUE);
insert into USER values(3, 'Z', 'Deshmukh', 'Z@gmail.com', 'ABC', 'ABC', 'user', TRUE);

insert into COUPONS values (1, 'OFF5');
insert into COUPONS values (2, 'OFF10');

insert into USERCOUPONS values (1, 1, 'OFF5', TRUE);
insert into USERCOUPONS values (2, 1, 'OFF10', TRUE);
insert into USERCOUPONS values (3, 2, 'OFF5', TRUE);
insert into USERCOUPONS values (4, 2, 'OFF10', TRUE);
insert into USERCOUPONS values (5, 3, 'OFF5', TRUE);
insert into USERCOUPONS values (6, 3, 'OFF10', TRUE);