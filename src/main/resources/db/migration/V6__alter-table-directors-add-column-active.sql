alter table directors add column active tinyint;
update directors set active = 1;
alter table directors modify active tinyint not null;

