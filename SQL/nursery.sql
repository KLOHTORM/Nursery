DROP DATABASE IF EXISTS Human_Friends;
CREATE DATABASE Human_Friends;
USE Human_Friends;

-- тип животных --
DROP TABLE IF EXISTS animal;
CREATE TABLE animal (
animal_id SERIAL PRIMARY KEY,
animal_type VARCHAR(50)
);

INSERT INTO animal (animal_type)
VALUES
('домашние животные'),
('вьючные животные');


--  домашние животные --
DROP TABLE IF EXISTS pet;
CREATE TABLE pet (
pet_id SERIAL PRIMARY KEY,
name_animal VARCHAR(50)
);

INSERT INTO pet (name_animal)
VALUES
('собака'),
('кошка'),
('хомяк');


--  вьючные животные --
DROP TABLE IF EXISTS pack_animal;
CREATE TABLE pack_animal (
pack_animal_id SERIAL PRIMARY KEY,
name_animal VARCHAR(50)
);

INSERT INTO pack_animal (name_animal)
VALUES
('лошадь'),
('верблюд'),
('осёл');

-- собаки --
DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
dog_id SERIAL PRIMARY KEY,
animal_id INT UNSIGNED NOT NULL,
pet_id INT UNSIGNED NOT NULL,
nick_name VARCHAR(50),
birthdate DATE,
command VARCHAR(50)
);

INSERT INTO dog (animal_id, pet_id, nick_name, birthdate, command)
VALUES
(1, 1, 'Шарик', '2023-07-15', 'Сидеть, Лежать, Голос'),
(1, 1, 'Бобик', '2022-03-16', 'Голос, Домой, Забота'),
(1, 1, 'Тузик', '2020-02-17', 'Охранять, Прятатья');

-- кошки --
DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
cat_id SERIAL PRIMARY KEY,
animal_id INT UNSIGNED NOT NULL,
pet_id INT UNSIGNED NOT NULL,
nick_name VARCHAR(50),
birthdate DATE,
command VARCHAR(50) DEFAULT 'эта кошка никого не слушается)'
);

INSERT INTO cat (animal_id, pet_id, nick_name, birthdate, command)
VALUES
(1, 2, 'Мася', '2023-05-15', 'Кушать, Спать'),
(1, 2, 'Лола', '2022-01-16', 'Домой, Мурлыкать '),
(1, 2, 'Коржик', '2020-12-17', DEFAULT);

-- хомяки --
DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster (
hamster_id SERIAL PRIMARY KEY,
animal_id INT UNSIGNED NOT NULL,
pet_id INT UNSIGNED NOT NULL,
nick_name VARCHAR(50),
birthdate DATE,
command VARCHAR(50) DEFAULT 'Хомяки необучаемы'
);

INSERT INTO hamster (animal_id, pet_id, nick_name, birthdate, command)
VALUES
(1, 3, 'Мыш', '2023-01-15', 'Прятаться'),
(1, 3, 'Крекер', '2021-09-13', 'Крутиться'),
(1, 3, 'Гоша', '2022-12-11', 'Вертеться');

-- лошадь --
DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
horse_id SERIAL PRIMARY KEY,
animal_id INT UNSIGNED NOT NULL,
pack_animal_id INT UNSIGNED NOT NULL,
nick_name VARCHAR(50),
birthdate DATE,
command VARCHAR(50)
);

INSERT INTO horse (animal_id, pack_animal_id, nick_name, birthdate, command)
VALUES
(2, 1, 'Спаркл', '2022-02-15', 'Вперёд'),
(2, 1, 'Вильям', '2021-07-13', 'Пошли'),
(2, 1, 'Шон', '2015-12-11', 'Стоять');

-- верблюды --
DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
camel_id SERIAL PRIMARY KEY,
animal_id INT UNSIGNED NOT NULL,
pack_animal_id INT UNSIGNED NOT NULL,
nick_name VARCHAR(50),
birthdate DATE,
command VARCHAR(50)
);

INSERT INTO camel (animal_id, pack_animal_id, nick_name, birthdate, command)
VALUES
(2, 2, 'Каво', '2022-10-11', 'Присядь'),
(2, 2, 'Чево', '2021-07-18', 'Пошли'),
(2, 2, 'Куда', '2017-12-17', 'Встань');

-- ослы --
DROP TABLE IF EXISTS dunkey;
CREATE TABLE dunkey (
dunkey_id SERIAL PRIMARY KEY,
animal_id INT UNSIGNED NOT NULL,
pack_animal_id INT UNSIGNED NOT NULL,
nick_name VARCHAR(50),
birthdate DATE,
command VARCHAR(50)
);

INSERT INTO dunkey (animal_id, pack_animal_id, nick_name, birthdate, command)
VALUES
(2, 3, 'Миллер', '2016-09-11', 'Присядь'),
(2, 3, 'Цезарь', '2011-05-15', 'Пошли'),
(2, 3, 'Енот', '2021-10-17', 'Встань');


TRUNCATE camel;

CREATE TABLE horse_dunkey(
horse_dunkey_id SERIAL PRIMARY KEY,
animal_id INT UNSIGNED NOT NULL,
pack_animal_id INT UNSIGNED NOT NULL,
nick_name VARCHAR(50),
birthdate DATE,
command VARCHAR(50))
SELECT animal_id, pack_animal_id, nick_name, birthdate, command
FROM horse UNION
SELECT animal_id, pack_animal_id, nick_name, birthdate, command
FROM dunkey;

-- Создаём таблицу молодые животные --
DROP TABLE IF EXISTS `молодые животные`;
CREATE TABLE `молодые животные`(
young_animal_id SERIAL PRIMARY KEY
)
SELECT animal.animal_type as 'Type', query1.Animal_type as Animal_name, nick_name, birthdate, command,
concat( 'кол-во лет=', TIMESTAMPDIFF(YEAR, birthdate, CURDATE()),
' кол-во месяцев=', TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) % 12) as `Точный возраст`
FROM (SELECT animal_id, pack_animal.name_animal as Animal_type, nick_name, birthdate, command
FROM horse_dunkey
JOIN pack_animal USING(pack_animal_id)
WHERE TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) BETWEEN 1 AND 2
UNION
SELECT animal_id, pet.name_animal as Animal_type, nick_name, birthdate, command
FROM dog
JOIN pet USING(pet_id)
WHERE TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) BETWEEN 1 AND 2
UNION
SELECT animal_id, pet.name_animal as Animal_type, nick_name, birthdate, command
FROM cat
JOIN pet USING(pet_id)
WHERE TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) BETWEEN 1 AND 2
UNION
SELECT animal_id, pet.name_animal as Animal_type, nick_name, birthdate, command
FROM hamster
JOIN pet USING(pet_id)
WHERE TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) BETWEEN 1 AND 2
) as query1
JOIN animal ON animal.animal_id = query1.animal_id;


-- Обьединение всех таблиц в 1 --
DROP TABLE IF EXISTS all_tables;
CREATE TABLE all_tables(all_tables_id SERIAL PRIMARY KEY)
SELECT *
FROM (SELECT animal_id, pack_animal.name_animal as Animal_name, nick_name, birthdate, command
FROM horse_dunkey
JOIN pack_animal USING(pack_animal_id)
UNION
SELECT animal_id, pet.name_animal as Animal_name, nick_name, birthdate, command
FROM dog
JOIN pet USING(pet_id)
UNION
SELECT animal_id, pet.name_animal as Animal_name, nick_name, birthdate, command
FROM cat
JOIN pet USING(pet_id)
UNION
SELECT animal_id, pet.name_animal as Animal_name, nick_name, birthdate, command
FROM hamster
JOIN pet USING(pet_id)) as MY_Query
JOIN animal USING(animal_id);