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
     primary key (USER_ID),
     UNIQUE (USERNAME)
);

create table UserConnection (userId varchar(255) not null,
    providerId varchar(255) not null,
    providerUserId varchar(255),
    rank int not null,
    displayName varchar(255),
    profileUrl varchar(512),
    imageUrl varchar(512),
    accessToken varchar(255) not null,					
    secret varchar(255),
    refreshToken varchar(255),
    expireTime bigint,
    primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

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
     USER_ID bigint not null,
     CATEGORY_NAME varchar(255),
     CATEGORY_ID bigint not null,
     primary key (TUTORIAL_ID)
);

create table TUTORIALS_CATEGORIES (
	 CATEGORY_ID bigint not null,
     CATEGORY_NAME varchar(255) not null,
     USER_ID bigint not null,
     primary key (CATEGORY_ID)
);

 alter table TUTORIALS
     add constraint categories_tutorials_fk
     foreign key (CATEGORY_ID)
     references TUTORIALS_CATEGORIES (CATEGORY_ID);
     
alter table TUTORIALS
	add constraint user_tutorials_fk
	foreign key (USER_ID)
	references USERS (USER_ID);
	
alter table TUTORIALS_CATEGORIES
	add constraint user_categories_fk
	foreign key (USER_ID)
	references USERS (USER_ID);
	
	
