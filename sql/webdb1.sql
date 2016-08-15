select * from emaillist;
select * from users;
select * from boards;
delete from boards;
commit;

insert into boards VALUES(1,'√÷«¸πŒ¿‘¥œ¥Ÿ','æ»≥Á«œººø‰',1,1,1,1,1,sysdate);
insert into boards VALUES(2,'√÷º÷∫Û¿‘¥œ¥Ÿ','æ»≥Á«œººø‰',1,1,1,1,2,sysdate);
insert into boards VALUES(3,'±Ë∏¡µŒ¿‘¥œ¥Ÿ','æ»≥Á«œººø‰',1,1,1,1,3,sysdate);
insert into boards VALUES(4,'∞≠ªÁ¿‘¥œ¥Ÿ','æ»≥Á«œººø‰',1,1,1,1,4,sysdate);

select * from emaillist;

select * from boards;
delete from boards where no=25;
commit;
desc boards;
select max(group_no) from boards;

delete from boards where no=8;

commit;
insert into boards VALUES(seq_boards.nextval,'...','....',1,nvl((select max(group_no) from boards),0+1),1,1,2,sysdate);
delete from boards where no=6;
select * from users;
delete from no where no=4;

insert into boards VALUES(seq_boards.nextval,5,'æ»≥Á«œºº¿Ø~','«Ï«Ï',1,5,5,5,5,sysdate);
insert into boards VALUES(seq_boards.nextval,?,?,1,;
select * from boards;
nvl((select max(group_no) from boards),0);
nvl((select max(group_no) from boards),0)+1;
select max(group_no) from boards;

select nvl((select max(group_no) from boards),0) from dual;
desc boards;

select * from emaillist a, boards b;
select * from emaillist;


select no,title,content,user_no from boards where user_no=1;

drop sequence seq_emaillist;
create sequence seq_emaillist;
start with 1
INCREMENT by 1;
commit;

select b.no,b.title,(a.FIRST_NAME || ' ' ||a.LAST_NAME) name, b.VIEW_COUNT,b.depth,to_char(b.REG_DATE,'yyyy-mm-dd hh:mm:ss'),b.user_no from emaillist a, boards b where b.title='213';

select b.no,b.title,(a.FIRST_NAME || ' ' ||a.LAST_NAME) name, b.VIEW_COUNT,b.depth,to_char(b.REG_DATE,'yyyy-mm-dd hh:mm:ss'),b.user_no from emaillist a, boards b where b.title='213';

select (first_name || ' '||LAST_NAME) name from emaillist;
select * from boards;

select * from(select c.*,rownum rn from(select a.no,a.title,(b.first_name || ' '||LAST_NAME) name,a.user_no,a.view_count,to_char(a.reg_date, 'yyyy-mm-dd pm hh:mi:ss'),a.depth  
from boards a, emaillist b where a.user_no=b.no order by group_no desc, order_no asc) c) where ?<=rn and rn<=?;



SELECT *   FROM (SELECT c.*, rownum rn
FROM (  SELECT a.no, a.title, b.(first_name || ' '||LAST_NAME) name, a.user_no, a.view_count, to_char(reg_date, 'yyyy-mm-dd pm hh:mi:ss'), a.depth
FROM board a, emaillist b
WHERE a.user_no = b.no
ORDER BY group_no DESC, order_no ASC) c ) WHERE 10  <= rn
AND rn <= 20;

select * from boards;

select * from(select c.*,rownum rn from(select a.no,a.title,(b.first_name || ' '||LAST_NAME) name,a.user_no,a.view_count,to_char(a.reg_date, 'yyyy-mm-dd pm hh:mi:ss'),a.depth 
from boards a, emaillist b 
where a.user_no=b.no order by group_no desc, order_no asc) c) where 5<=rn and rn<=10;

update boards set depth = depth + 1 where no = 1;

select * from boards;

update boards
set order_no=order_no+1
where group_no=1 and order_no>1;

select * from boards;
desc boards;

insert into boards VALUES(seq_boards.nextval,'æ»≥Á«œººø‰','»£»£',1,nvl((select max(group_no) from boards), 0)+1,1,1,1,sysdate);

select no,title,content,user_no,depth,order_no,group_no from boards where no=1;

insert into boards values(seq_boards.nextval, 'æ»≥Û', '«œ«œ', 0, 1, 1, 1, 1,sysdate);

select * from boards;
desc boards;

select * from(select c.*,rownum rn from(select a.no,a.title,(b.first_name || ' '||LAST_NAME) name,a.user_no,a.view_count,to_char(a.reg_date, 'yyyy-mm-dd pm hh:mi:ss'),a.depth from boards a, emaillist b where a.user_no=b.no and (title like 'æ»≥Á%' or content like 'ΩŒ%') order by group_no desc, order_no asc) c) where 1<=rn and rn<=10;
