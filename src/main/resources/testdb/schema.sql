drop table PRODUCT if exists;
create table PRODUCT (ID bigint identity primary key, 
						NAME varchar(50) not null,
						TYPE varchar(50) not null, 
                        PRICE decimal(8,2));
                        
ALTER TABLE PRODUCT ALTER COLUMN PRICE SET DEFAULT 0.0;