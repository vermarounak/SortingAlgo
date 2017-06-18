create table NUMBER_TBL
(
  S_NO           NUMBER(10) not null,
  INPUT_NUMBERS  VARCHAR2(1000) not null,
  SORTED_NUMBERS VARCHAR2(1000) not null,
  CREATION_DATE  DATE default SYSDATE not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table NUMBER_TBL
  add constraint NUMBER_TBL_PK primary key (S_NO);

create sequence NUMBERSORTING_SNO_SEQ
minvalue 1
maxvalue 999999999
start with 1
increment by 1
nocache;