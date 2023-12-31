insert into user_account (id, created, name, email, password)
values (1000, now(), 'volt', 'volt@mail.ru', '12345'),
       (1001, now(), 'topic', 'topic@mail.ru', '54321'),
       (1002, now(), 'rose', 'rouse@mail.ru', '953458');

insert into vote (id, created, vote)
values (1009, now(), 5),
       (1010, now(), -2),
       (1011, now(), 3),
       (1012, now(), 10),
       (1013, now(), -5),
       (1014, now(), 2);

insert into quote (id, created, quote, user_id, vote_id)
values (1003, now(), 'Кто не был - тот будет, кто был - не забудет 540 дней в сапогах', 1000, 1009),
       (1004, now(), 'Не имей 100 рублей, а имей 100 друзей', 1001, 1010),
       (1005, now(), 'Любишь кататься - люби и саночки возить', 1000, 1011),
       (1006, now(), 'Жизнь - это игра, которая всегда заканчивается одним и тем же', 1002, 1012),
       (1007, now(), 'Не было печали, купила бабка поросёнка', 1000, 1013),
       (1008, now(), 'Все тайное обязательно станет явным', 1000, 1014);