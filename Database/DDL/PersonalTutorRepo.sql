CREATE SCHEMA `persTutorRepo` DEFAULT CHARACTER SET utf8 ;

create table TUTORIALS (
        ID bigint not null,
        AUTHOR varchar(255),
        RATING bigint,
        SERVICE_DOMAIN varchar(255),
        TITLE varchar(255),
        URL varchar(255),
        primary key (id)
    );
