create table "public"."user_roles"
(
  id      int4 not null,
  role    varchar(255),
  user_id int4,
  primary key (id)
);

create table "public"."users"
(
  user_id                    int4         not null,
  created_at                 timestamp,
  email                      varchar(255) not null,
  first_name                 varchar(255) not null,
  gender                     varchar(255) not null,
  is_account_non_expired     BOOLEAN DEFAULT true,
  is_account_non_locked      BOOLEAN DEFAULT true,
  is_credentials_non_expired BOOLEAN DEFAULT true,
  is_enabled                 BOOLEAN DEFAULT true,
  last_name                  varchar(255) not null,
  password                   varchar(255) not null,
  primary key (user_id)
);

alter table "public"."user_roles"
  add constraint FKhfh9dx7w3ubf1co1vdev94g3f
    foreign key (user_id)
      references users;