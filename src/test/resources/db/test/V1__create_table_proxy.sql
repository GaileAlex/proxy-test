CREATE SEQUENCE public.sequence_for_proxy_numeric
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE public.proxy
(
    id         text         NOT NULL DEFAULT to_char(nextval('sequence_for_proxy_numeric'::regclass),
                                                     '"S"fm000000'::text),
    "name"     varchar(120) NOT NULL,
    proxy_type varchar      NOT NULL,
    hostname   varchar(120) NOT NULL,
    port       int8         NOT NULL,
    username   varchar(20)  NOT NULL,
    "password" varchar(20)  NOT NULL,
    is_active  bool         NOT NULL,
    CONSTRAINT proxy_pkey PRIMARY KEY (id),
    CONSTRAINT proxy_name_un UNIQUE (name),
    CONSTRAINT proxy_hostname_un UNIQUE (hostname)
);

create index on proxy (name, proxy_type);


