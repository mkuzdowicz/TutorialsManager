CREATE SCHEMA `persTutorRepo` DEFAULT CHARACTER SET utf8 ;

/*------------------------------------------------*/

create table TUTORIALS (
        ID bigint not null,
        AUTHOR varchar(255),
        RATING bigint,
        SERVICE_DOMAIN varchar(255),
        TITLE varchar(255),
        URL varchar(255),
        primary key (id)
    );

/*------------------------------------------------*/
    
create table TUTORIALS_CATEGORIES (
        TUTORIALS_CATEGORIES_ID bigint not null,
        TITLE varchar(255),
        primary key (TUTORIALS_CATEGORIES_ID)
    );
    
/*------------------------------------------------*/

alter table TUTORIALS 
     add constraint FK840evp71diyova29pfpa43ddy 
     foreign key (CATEGORY_ID) 
     references TUTORIALS_CATEGORIES (TUTORIALS_CATEGORIES_ID
    );
