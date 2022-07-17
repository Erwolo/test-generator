-- TODO: prepare initial data
CREATE TABLE IF NOT EXISTS USER (
    id identity primary key,
    login varchar (255) not null,
    password varchar (255) not null
);
ALTER TABLE user ALTER COLUMN id INT NOT NULL AUTO_INCREMENT;
INSERT INTO user (login, password) SELECT 'erwol', '123' FROM DUAL WHERE NOT EXISTS (SELECT * FROM user WHERE login = 'erwol');