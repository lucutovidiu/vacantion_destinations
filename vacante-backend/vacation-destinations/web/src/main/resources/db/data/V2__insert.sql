
insert into users(user_id, created_at, email, first_name, gender, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled,last_name, password)
VALUES (1, current_timestamp, 'ovi@email.com', 'ovi', 'male', true, true, true, true, 'Lucut', '$2y$12$./et4m6qQaYhySE7R1VS1uIoroeK2wvPxJ752Qn5BTFt5D8dzO7V.');
insert into user_roles(id, role, user_id)
VALUES (2, 'ADMIN', 1);
insert into user_roles(id, role, user_id)
VALUES (3, 'USER', 1);