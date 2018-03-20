--------------------------------------------------------
-- Archivo creado  - martes-marzo-20-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CLIENTES
--------------------------------------------------------

  CREATE TABLE "ISIS2304A461810"."CLIENTES" 
   (	"IDCLIENTE" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 ORDER  NOCYCLE , 
	"NOMBRE" VARCHAR2(20 BYTE), 
	"VINCULO" VARCHAR2(20 CHAR), 
	"LOGIN" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD"   NO INMEMORY ;
--------------------------------------------------------
--  DDL for Index CLIENTES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304A461810"."CLIENTES_PK" ON "ISIS2304A461810"."CLIENTES" ("IDCLIENTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  Constraints for Table CLIENTES
--------------------------------------------------------

  ALTER TABLE "ISIS2304A461810"."CLIENTES" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."CLIENTES" MODIFY ("LOGIN" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."CLIENTES" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."CLIENTES" MODIFY ("IDCLIENTE" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."CLIENTES" ADD CONSTRAINT "CLIENTES_PK" PRIMARY KEY ("IDCLIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "TBSPROD"  ENABLE;
  ALTER TABLE "ISIS2304A461810"."CLIENTES" ADD CONSTRAINT "CLIENTES_CHKVINCULO" CHECK (VINCULO =  'estudiante' OR VINCULO = 'maestro' OR VINCULO = 'empleado' OR VINCULO =  'padre' OR VINCULO = 'egresado' OR VINCULO = 'profInvitado' OR VINCULO = 'visitanteEv'

) ENABLE;