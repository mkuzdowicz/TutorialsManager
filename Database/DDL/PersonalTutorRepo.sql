CREATE SCHEMA `persTutorRepo` DEFAULT CHARACTER SET utf8 ;

create table TUTORIALS (
        TUTORIAL_ID bigint not null,
        AUTHOR varchar(255),
        END_DATE_TO_DO datetime,
        RATING bigint,
        REWORKED_IN_PERCENTS int default 0,
        SERVICE_DOMAIN varchar(255),
        START_DATE_TO_DO datetime,
        TITLE varchar(255),
        URL varchar(255),
        CATEGORY_NAME varchar(255),
        primary key (TUTORIAL_ID)
    )

create table TUTORIALS_CATEGORIES (
        CATEGORY_NAME varchar(255) not null,
        primary key (CATEGORY_NAME)
    )

alter table TUTORIALS
        add constraint FK4ysdtksb8jvo2p9dd9un7g701
        foreign key (CATEGORY_NAME)
        references TUTORIALS_CATEGORIES (CATEGORY_NAME)