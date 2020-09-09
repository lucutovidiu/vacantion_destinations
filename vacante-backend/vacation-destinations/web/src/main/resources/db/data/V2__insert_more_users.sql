insert into users(id, created_date, update_date, version, email, first_name, gender, is_account_non_expired,
                  is_account_non_locked, is_credentials_non_expired, is_enabled, last_name, password)
VALUES (2, current_timestamp, current_timestamp, 0, 'bogoseldaniel@email.com', 'daniel', 'male', true, true, true, true,
        'bogosel', '$2y$12$Qj445m/bhCvyxjMVu919iOxV.QJPnRbU91mMHX.cod4qG6hNOa4hG');
insert into user_roles(id, created_date, update_date, version, role, user_id)
VALUES (4, current_timestamp, current_timestamp, 0, 'ADMIN', 2);
insert into user_roles(id, created_date, update_date, version, role, user_id)
VALUES (5, current_timestamp, current_timestamp, 0, 'USER', 2);
