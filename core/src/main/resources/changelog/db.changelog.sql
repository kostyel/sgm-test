--liquibase formatted sql

--changeset eliseev:20210722 failOnError:true
--preconditions onFail:MARK_RAN onError:HALT
create sequence bs.bookshelf_seq_id;

create table bs.bookshelf
(
    id bigint default nextval('bs.bookshelf_seq_id'::regclass) not null,
    name         varchar                                                 not null,
    primary key (id)
);

create sequence bs.level_seq_id;

create table bs.level
(
    id bigint default nextval('bs.level_seq_id'::regclass) not null,
    name     varchar                                             not null,
    primary key (id)
);

create sequence bs.book_seq_id;

create table bs.book
(
    id      bigint default nextval('bs.book_seq_id'::regclass) not null,
    name         varchar                                            not null,
    author       varchar                                            not null,
    bookshelf_id bigint
        constraint book_bookshelf_id_fk references bs.bookshelf,
    level_id     bigint
        constraint book_level_id_fk references bs.level,
    primary key (id)
);

insert into bs.bookshelf (name)
values ('Русская литература'),
       ('Зарубежная литература'),
       ('Литература 20х годов');

insert into bs.level (name)
values ('Детектив'),
       ('Фантастика'),
       ('Романтика');

insert into bs.book (name, author, bookshelf_id, level_id)
values ('Анна Каренина', 'Лев Толстой', 1, 1),
       ('Автостопом по галактике', 'Дуглас Адамс', 1, 1),
       ('Алиса в Стране чудес', 'Льюис Кэрролл', 1, 1),
       ('Алхимик', 'Пауло Коэльо', 1, 2),
       ('Американский психопат', 'Брет Истон Эллис', 1, 2),
       ('Аня из Зеленых Мезонинов', 'Люси Мод Монтгомери', 1, 2),
       ('Ангус, ремни и конкретные обжимашки', 'Луиз Рэннисон', 1, 3),
       ('Артемис Фаул', 'Йон Колфер', 1, 3),
       ('БДВ, или Большой и добрый великан', 'Роальд Даль', 1, 3),
       ('Белый пик', 'Энтони Хоровитц', 2, 1),
       ('Библия ядовитого леса', 'Барбара Кингсолвер', 2, 1),
       ('Благие знамения', 'Терри Пратчетт и Нил Гейман', 2, 1),
       ('Большие надежды', 'Чарльз Диккенс', 2, 2),
       ('Бог мелочей', 'Арундати Рой', 2, 2),
       ('Божество реки', 'Уилбур Смит', 2, 2),
       ('В дороге', 'Джек Керуак', 2, 3),
       ('Вдали от обезумевшей толпы', 'Томас Харди', 2, 3),
       ('Ведьмы', 'Роальд Даль', 2, 3),
       ('Ведьмы за границей', 'Терри Пратчетт', 3, 1),
       ('Великий Гэтсби', 'Фрэнсис Скотт Фицджеральд', 3, 1),
       ('Ветер в ивах', 'Кеннет Грэм', 3, 1),
       ('Вечеринка с ночевкой', 'Жаклин Уилсон', 3, 2),
       ('Вещие сестрички', 'Терри Пратчетт', 3, 2),
       ('Вики-ангел', 'Жаклин Уилсон', 3, 2),
       ('Винни-Пух и все-все-все', 'Алан Милн', 3, 3),
       ('Властелин колец', 'Джон Р. Р. Толкин', 3, 3),
       ('Война и мир', 'Лев Толстой', 3, 3);

