USE micro_generator;
ALTER TABLE user MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE role MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE permission MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;
INSERT INTO user (login, password) SELECT 'erwol', '123' FROM DUAL WHERE NOT EXISTS (SELECT * FROM user WHERE login = 'erwol');
INSERT INTO user (login, password) SELECT 'perwol', '321' FROM DUAL WHERE NOT EXISTS (SELECT * FROM user WHERE login = 'perwol');
INSERT INTO role (name) SELECT 'admin' FROM DUAL WHERE NOT EXISTS (SELECT * FROM role WHERE name = 'admin');
INSERT INTO role (name) SELECT 'user' FROM DUAL WHERE NOT EXISTS (SELECT * FROM role WHERE name = 'user');
INSERT INTO permission (name) SELECT 'read' FROM DUAL WHERE NOT EXISTS (SELECT * FROM permission WHERE name = 'read');
INSERT INTO permission (name) SELECT 'write' FROM DUAL WHERE NOT EXISTS (SELECT * FROM permission WHERE name = 'write');
INSERT INTO permission (name) SELECT 'edit' FROM DUAL WHERE NOT EXISTS (SELECT * FROM permission WHERE name = 'edit');
INSERT INTO permission (name) SELECT 'delete' FROM DUAL WHERE NOT EXISTS (SELECT * FROM permission WHERE name = 'delete');
INSERT INTO user_role (user_id, role_id)
SELECT (SELECT id FROM user WHERE login = 'erwol' LIMIT 1), (SELECT id FROM role WHERE name = 'admin' LIMIT 1)
FROM DUAL WHERE NOT EXISTS (SELECT * FROM user_role where user_id = (SELECT id FROM user WHERE login = 'erwol' LIMIT 1) AND role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1));
INSERT INTO user_role (user_id, role_id)
SELECT (SELECT id FROM user WHERE login = 'perwol' LIMIT 1), (SELECT id FROM role WHERE name = 'user' LIMIT 1)
FROM DUAL WHERE NOT EXISTS (SELECT * FROM user_role where user_id = (SELECT id FROM user WHERE login = 'perwol' LIMIT 1) AND role_id = (SELECT id FROM role WHERE name = 'user' LIMIT 1));
INSERT INTO role_permission (role_id, permission_id)
SELECT (SELECT id FROM role WHERE name = 'admin' LIMIT 1), (SELECT id FROM permission WHERE name = 'read' LIMIT 1)
FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'read' LIMIT 1));
INSERT INTO role_permission (role_id, permission_id)
SELECT (SELECT id FROM role WHERE name = 'admin' LIMIT 1), (SELECT id FROM permission WHERE name = 'write' LIMIT 1)
FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'write' LIMIT 1));
INSERT INTO role_permission (role_id, permission_id)
SELECT (SELECT id FROM role WHERE name = 'admin' LIMIT 1), (SELECT id FROM permission WHERE name = 'edit' LIMIT 1)
FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'edit' LIMIT 1));
INSERT INTO role_permission (role_id, permission_id)
SELECT (SELECT id FROM role WHERE name = 'admin' LIMIT 1), (SELECT id FROM permission WHERE name = 'delete' LIMIT 1)
FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'admin' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'delete' LIMIT 1));
INSERT INTO role_permission (role_id, permission_id)
SELECT (SELECT id FROM role WHERE name = 'user' LIMIT 1), (SELECT id FROM permission WHERE name = 'read' LIMIT 1)
FROM DUAL WHERE NOT EXISTS (SELECT * FROM role_permission WHERE role_id = (SELECT id FROM role WHERE name = 'user' LIMIT 1) AND permission_id = (SELECT id FROM permission WHERE name = 'read' LIMIT 1));
