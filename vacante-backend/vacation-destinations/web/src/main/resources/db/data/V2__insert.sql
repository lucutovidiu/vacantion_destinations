insert into users(user_id, created_at, email, first_name, gender, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled,last_name, password)
VALUES (1, current_timestamp, 'ovi@email.com', 'ovi', 'male', true, true, true, true, 'Lucut', '$2a$10$IJqUcrvwu9JGnJQs99aRTur5ou7Zp7jDWlNwWOz4RUKA3VlvCNrtm');
insert into user_roles(id, role, user_id_ref)
VALUES (2, 'ADMIN', 1);
insert into user_roles(id, role, user_id_ref)
VALUES (3, 'USER', 1);