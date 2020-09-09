insert into users(id, created_date, update_date, version, email, first_name, gender, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled,last_name, password)
VALUES (1, current_timestamp, current_timestamp, 0, 'ovi@email.com', 'ovi', 'male', true, true, true, true, 'Lucut', '$2a$10$IJqUcrvwu9JGnJQs99aRTur5ou7Zp7jDWlNwWOz4RUKA3VlvCNrtm');
insert into user_roles(id, created_date, update_date, version, role, user_id)
VALUES (2, current_timestamp, current_timestamp, 0, 'ADMIN', 1);
insert into user_roles(id, created_date, update_date, version, role, user_id)
VALUES (3, current_timestamp, current_timestamp, 0, 'USER', 1);
