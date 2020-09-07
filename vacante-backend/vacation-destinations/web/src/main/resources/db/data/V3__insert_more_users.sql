insert into users(user_id, created_at, email, first_name, gender, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled,last_name, password)
VALUES (2, current_timestamp, 'bogoseldaniel@email.com', 'daniel', 'male', true, true, true, true, 'bogosel', '$2y$12$Qj445m/bhCvyxjMVu919iOxV.QJPnRbU91mMHX.cod4qG6hNOa4hG');
insert into user_roles(id, role, user_id_ref)
VALUES (4, 'ADMIN', 2);
insert into user_roles(id, role, user_id_ref)
VALUES (5, 'USER', 2);