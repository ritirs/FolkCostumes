INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'linda@mail.ee', '+372 55232343', '1990-03-15', 'Saare 4, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'liina@gmail.com', '+372 506789098', '1998-07-14', 'Pronksi 56, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Birgit@hotmail.com', '+372 55002343', '1997-06-11', 'Marja 14-23, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Elerin@hot.ee', '+372 55782343', '1996-04-18', 'Pihlaka 1, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Egle@online.ee', '+372 55232341', '1995-07-03', 'Kuldnoka 12, Viimsi vald, Harju maakond');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Kriste@mail.ee', '+372 55232343', '1999-08-23', 'Mustamäe tee 123-23, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Maris@mail.ee', '+372 55789343', '1998-09-01', 'Sinilille 12-1, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Kelin@gmail.com', '+372 55123343', '1998-04-10', 'Majaka põik 2, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Riti@mail.ee', '+372 50098343', '1997-12-01', 'Pargi tee 34, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Eva@eva.ee', '+372 5108743', '1996-02-06', 'Lauliku 12, Tallinn');
INSERT INTO public.contact (id, email, telephone, birth_date, address)
VALUES (DEFAULT, 'Tiiu@mail.ee', '+372 5223223', '1995-05-11', 'Muuseumi 1, Tallinn');


INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Linda', 'Laululind', 1);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Liina', 'Viirsalu', 2);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Birgit', 'Parmas', 3);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Elerin', 'Luha', 4);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Egle', 'Ajaots', 5);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Kriste', 'Maja', 6);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Maris', 'Saare', 7);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Kelin', 'Piusa', 8);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Riti', 'Karu', 9);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Eva', 'Madis', 10);
INSERT INTO public.user (id, firstname, lastname, contact_id) VALUES (DEFAULT, 'Tiiu', 'Tiisvelt', 11);

INSERT INTO public.group (id, group_name) VALUES (1, 'Sukad ja Tagi');
INSERT INTO public.group (id, group_name) VALUES (2, 'Jüri Marid');
INSERT INTO public.group (id, group_name) VALUES (3, 'Lustilised');
INSERT INTO public.group (id, group_name) VALUES (4, 'Joondu segarühm');
INSERT INTO public.group (id, group_name) VALUES (5, 'Joondu 6.-9. klass');

INSERT INTO public.role_type (id, name) VALUES (1, 'Juhendaja');
INSERT INTO public.role_type (id, name) VALUES (2, 'Tantsija');
INSERT INTO public.role_type (id, name) VALUES (3, 'Muu kasutaja');
INSERT INTO public.role_type (id, name) VALUES (4, 'Rhvrte vastutav');
INSERT INTO public.role_type (id, name) VALUES (5, 'Admin');

INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 1, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 2, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 3, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 4, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 5, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 6, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 7, 5);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 8, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 9, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 10, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 1, 5);

INSERT INTO public.user_in_group (id, user_id, group_id, user_role_id) VALUES (DEFAULT, 1, 1, 1);
INSERT INTO public.user_in_group (id, user_id, group_id, user_role_id) VALUES (DEFAULT, 10, 2, 2);
INSERT INTO public.user_in_group (id, user_id, group_id, user_role_id) VALUES (DEFAULT, 3, 3, 1);
INSERT INTO public.user_in_group (id, user_id, group_id, user_role_id) VALUES (DEFAULT, 4, 4, 2);
INSERT INTO public.user_in_group (id, user_id, group_id, user_role_id) VALUES (DEFAULT, 7, 5, 2);