insert into issues (summary, description) values ('バグA', 'バグがあります');
insert into issues (summary, description) values ('機能要望B', 'Bに追加機能がほしいです');
insert into issues (summary, description) values ('画面Cが遅い', '早くしてほしいです');

-- password1234
insert into users (username,password ,authority) values ('tom','26e5b75e0c956a6bbfa3d6072ee81b73ab96cc9c962269e2c2e59034b693ad988c9d58a9849f9ece','ADMIN');
insert into users (username,password ,authority) values ('bob','8e9494e77d7af033943034bc51f8ede27a4fdc976a3dadb7d966ac220daea7947850728bf151230a', 'USER');