alter table teachers add column active tinyint;
update teachers set active = 1;
alter table teachers modify active tinyint not null;

