create table "public"."test"
(
    id                 bigserial constraint profile_pkey primary key,
    business_category  varchar(255) not null,
    client             varchar(255),
    created            timestamp,
    daily_hrs          integer      not null,
    department         varchar(255) not null,
    email              varchar(255) constraint uk_profile_email unique,
    fail_attempt_time  timestamp,
    fail_attempts      integer,
    first_name         varchar(255) not null,
    gender             varchar(255) not null,
    last_name          varchar(255) not null,
    location           varchar(255),
    mobile             varchar(255),
    modified           timestamp,
    org_proj           varchar(255),
    ou                 varchar(255) not null,
    photo              bytea,
    project            varchar(255),
    supervisor         varchar(255),
    technical          varchar(255) not null,
    technicalreal      varchar(255) not null,
    unit               varchar(255),
    working_start_date varchar(255) not null,
    uid                varchar(255) not null constraint uk_profile_uid unique
);

