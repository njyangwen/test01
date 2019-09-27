show create procedure querystudent5;

create table usermanager
(
    id int auto_increment primary key,
    name varchar(20),
    password varchar(40)

)

insert into usermanager(name,password) values('zhangsan','a123'),('lisi','b123');

select * from usermanager;


select * from usermanager where name='zhangsan' and password='a1234';
