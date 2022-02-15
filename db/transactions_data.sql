INSERT INTO public.status_type (id, location) VALUES (1, 'Laos Kultuurikeskuses');
INSERT INTO public.status_type (id, location) VALUES (2, 'Laos Jüri Gümnaasiumis');
INSERT INTO public.status_type (id, location) VALUES (3, 'Tantsija käes');
INSERT INTO public.status_type (id, location) VALUES (4, 'Paranduses');

INSERT INTO public.status (id, status_type_id, user_id) VALUES (DEFAULT, 1, 11);
INSERT INTO public.status (id, status_type_id, user_id) VALUES (DEFAULT, 2, 10);
INSERT INTO public.status (id, status_type_id, user_id) VALUES (DEFAULT, 3, 1);
INSERT INTO public.status (id, status_type_id, user_id) VALUES (DEFAULT, 3, 5);
INSERT INTO public.status (id, status_type_id, user_id) VALUES (DEFAULT, 4, 10);



