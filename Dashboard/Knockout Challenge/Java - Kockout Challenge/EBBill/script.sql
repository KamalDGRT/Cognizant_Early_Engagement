drop database if exists EBBill;

create database EBBill;

use EBBill;

create table ElectricityBill
(
    consumer_number varchar(15) primary key,
    name            varchar(25),
    address         varchar(30),
    units_consumed  int(5),
    bill_amount     float(6, 2)
);

desc ElectricityBill;

drop table ElectricityBill;

COMMIT;

select * from persons;