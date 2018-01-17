select * from Member;
select * from Attend;
select * from Bank;
select * from TAB;

delete from bank;

create sequence customer_num start with 1000 increment by 1;
CREATE TABLE Bank(
	customer_num VARCHAR2(20) PRIMARY KEY,
	account_num VARCHAR2(20) not null,
	money VARCHAR2(20) default 0,
	id VARCHAR2(20),
	FOREIGN KEY (id) REFERENCES MEMBER(id) ON DELETE CASCADE
);

drop table bank;
delete from bank;

insert into bank(customer_num, account_num, money, id) values(customer_num.nextval, '1234-5678-8899', '0', 'jk_pon');

drop sequence customer_num;
select seq_bbs_no.currval from dual;