--------------------------------------------------------
-- Archivo creado  - jueves-noviembre-11-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PODIO
--------------------------------------------------------

  CREATE TABLE "DESAFIO"."PODIO" 
   (	"ID" NUMBER(6,0), 
	"NOMBRE" VARCHAR2(20 BYTE), 
	"POSICION" NUMBER(1,0), 
	"CANTIDAD" NUMBER(4,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into DESAFIO.PODIO
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PODIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "DESAFIO"."PODIO_PK" ON "DESAFIO"."PODIO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PODIO
--------------------------------------------------------

  ALTER TABLE "DESAFIO"."PODIO" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "DESAFIO"."PODIO" ADD CONSTRAINT "PODIO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
