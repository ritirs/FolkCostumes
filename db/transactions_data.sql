INSERT INTO public.location (id, location) VALUES (1, 'Laos Kultuurikeskuses');
INSERT INTO public.location (id, location) VALUES (2, 'Laos Jüri Gümnaasiumis');
INSERT INTO public.location (id, location) VALUES (3, 'Tantsija käes');
INSERT INTO public.location (id, location) VALUES (4, 'Paranduses');


INSERT INTO public.location_balance (id, location_id, element_id, user_id, quantity) VALUES (1, 1, 1, 1, 20);
INSERT INTO public.location_balance (id, location_id, element_id, user_id, quantity) VALUES (2, 3, 2, 2, 1);
INSERT INTO public.location_balance (id, location_id, element_id, user_id, quantity) VALUES (3, 2, 4, 1, 30);

INSERT INTO public.location_log (id, element_id, location_id, user_id, quantity, balance, transaction_time) VALUES (DEFAULT, 1, 1, 4, 10, 5, '2022-02-16');