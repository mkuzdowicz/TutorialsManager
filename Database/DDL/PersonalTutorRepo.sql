CREATE SCHEMA `pers_tutor_repo` DEFAULT CHARACTER SET utf8 ;

use pers_tutor_repo;

create table hibernate_sequence (
    next_val bigint
 );
  
insert into hibernate_sequence values ( 1 );

create table USERS (
     USER_ID bigint not null,
     EMAIL varchar(255),
     PASSWORD varchar(255),
     USER_TYPE varchar(255),
     USERNAME varchar(255),
     primary key (USER_ID)
);

create table TUTORIALS (
     TUTORIAL_ID bigint not null,
     AUTHOR varchar(255),
     END_DATE_TO_DO datetime,
     PROGRESS int default 0,
     RATING bigint,
     SERVICE_DOMAIN varchar(255),
     START_DATE_TO_DO datetime,
     TITLE varchar(255),
     URL varchar(255),
     USER_ID bigint,
     CATEGORY_NAME varchar(255),
     primary key (TUTORIAL_ID)
);

create table TUTORIALS_CATEGORIES (
     CATEGORY_NAME varchar(255) not null,
     USER_ID bigint,
     primary key (CATEGORY_NAME)
);

 alter table TUTORIALS
     add constraint categories_tutorials_fk
     foreign key (CATEGORY_NAME)
     references TUTORIALS_CATEGORIES (CATEGORY_NAME);
     
alter table TUTORIALS
	add constraint user_tutorials_fk
	foreign key (USER_ID)
	references USERS (USER_ID);
	
alter table TUTORIALS_CATEGORIES
	add constraint user_categories_fk
	foreign key (USER_ID)
	references USERS (USER_ID);