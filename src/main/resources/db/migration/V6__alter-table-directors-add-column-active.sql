alter table students add column active tinyint;
update students set active = 1;
alter table students modify active tinyint not null;

