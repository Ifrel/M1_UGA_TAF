insert into comptes values (11, 'Paul', '100');
insert into comptes values (12, 'Paul', '200');

select * from comptes;

rollback;

select * from comptes;