CREATE Database Libary
go
USE Libary
go
CREATE TABLE Librarian(
L_Id int identity(1,1),
Name Varchar(100),
Address_ Varchar(80),
password_ varchar(20),


Primary key(L_Id)


)
go

CREATE TABLE Books(
B_Id int identity(1,1),
B_Name varchar(100),
Category varchar(10),
Author varchar(100),
price varchar(10),
Availability_ varchar(3),

Primary key(B_Id),
)

go

CREATE TABLE Member(
M_ID int identity(1,1),
M_Name varchar(100),
M_phone varchar(10),
M_Address varchar(50),
Book_ID INT FOREIGN KEY REFERENCES Books(B_Id),
Borrow_Date DATE ,
Return_Date DATE


Primary key(M_ID)
)

go



insert into Librarian values('john','1/20 3rd lane','1234')
insert into Librarian values('Sumudu','2/20 3rd lane','1254')
insert into Librarian values('Rose','1/20 3rd lane','1244')


Insert into Books values('Java','Education','Sean bean',100.00,'YES');
Insert into Books values('Java','Education','Sean bean',100.00,'YES');
Insert into Books values('C BIGINNERS','Education','bacyloni',500.00,'YES');
Insert into Books values('BootsTrap','Education','shawn sigera',300.00,'YES');
Insert into Books values('Algebra','Education','kevin maya',200.00,'YES');
Insert into Books values('Yoga','Education','rouse jean',200.00,'YES');



insert into Member(M_ID,M_phone,M_Address) values('Adam gihan','0762341234','30/200 john road, colombo 10')
insert into Member(M_ID,M_phone,M_Address) values('Suwini Perera','0762341234','1/200 sumudu road, colombo 10')
insert into Member(M_ID,M_phone,M_Address) values('kasun Bandara','0762341234','3/200 ryan road, colombo 10')







