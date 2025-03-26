create database BankManagementSystem;
Show Databases;

use BankManagementSystem;

create table signup(
FormNo varchar(20),
Name varchar(20),
FatherName varchar(20),
DOB varchar(20),
Gender varchar(20),
EmailAdress varchar(50),
MAritalStatus varchar(20),
Adress varchar(40),
City varchar(20),
PIncode varchar(20));




create table signupSecond(
FormNo varchar(20),
Relegion varchar(20),
Income varchar(20),
Education varchar(20),
Occupation varchar(20),
PAN_NO varchar(50),
AadharNO varchar(20),
Senior_Or_Not varchar(40),
Account_Holder_Not varchar(20));




create table signupThree(
FormNo varchar(20),
AccountType varchar(40),
CardNumber varchar(80),
Pin varchar(20),
Facility varchar(100));




create table Login(
CardNumber varchar(80),
Pin varchar(20));




create table Bank(
PIN varchar(20),
Date varchar(40),
Type varchar(80),
Amount varchar(30));

select * from Bank;
select * from signup;
select * from signupSecond;
select * from signupThree;
select * from Login;


drop table signup;
drop table signupSecond;
drop table signupThree;
drop table Login;
drop table Bank;
