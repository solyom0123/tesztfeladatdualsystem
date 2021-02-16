insert into invoice (customer_name,issue_date,due_date,invoice_comment) values ('Teszt Béla',TO_DATE('2021-10-10','yyyy-mm-dd'),TO_DATE('2021-10-11','yyyy-mm-dd'),null);
insert into invoice (customer_name,issue_date,due_date,invoice_comment) values ('Teszt Cecil',TO_DATE('2021-10-12','yyyy-mm-dd'),TO_DATE('2021-10-13','yyyy-mm-dd'),'fontos');
insert into invoice (customer_name,issue_date,due_date,invoice_comment) values ('Teszt Sándor',TO_DATE('2021-10-14','yyyy-mm-dd'),TO_DATE('2021-10-14','yyyy-mm-dd'),null);
insert into invoice (customer_name,issue_date,due_date,invoice_comment) values ('Teszt Géza',TO_DATE('2021-10-15','yyyy-mm-dd'),TO_DATE('2021-10-15','yyyy-mm-dd'),'Béla');
insert into invoice_item (product_name,unit_price,quantity,invoice_id) values ('alma',10,200,(select id from invoice where customer_name='Teszt Béla'));
insert into invoice_item (product_name,unit_price,quantity,invoice_id) values ('barack',11,210,(select id from invoice where customer_name='Teszt Béla'));
insert into invoice_item (product_name,unit_price,quantity,invoice_id) values ('fánk',12,220,(select id from invoice where customer_name='Teszt Sándor'));
insert into invoice_item (product_name,unit_price,quantity,invoice_id) values ('ház',13,230,(select id from invoice where customer_name='Teszt Cecil'));
insert into invoice_item (product_name,unit_price,quantity,invoice_id) values ('kalács',14,240,(select id from invoice where customer_name='Teszt Sándor'));