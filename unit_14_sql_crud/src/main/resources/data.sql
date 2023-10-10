select * from students; # find all
select * from students where id = 8; # find by id
select count(id) as count_of_students from students where id = 8; # count
insert into students values (default, 23, 'qq', 'qq'); # create
update students set first_name = '', last_name = '', age = 34 where id = 23; # update
delete from students where id = 0; #delete