--------------------------------------------------------
-- Archivo creado  - martes-marzo-20-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SEGUROS
--------------------------------------------------------

  CREATE TABLE "ISIS2304A461810"."SEGUROS" 
   (	"IDSEGURO" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE , 
	"ASEGURADORA" VARCHAR2(20 BYTE), 
	"COSTO" NUMBER, 
	"IDALOJAMIENTO" NUMBER, 
	"IDCONTRATO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index SEGUROS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304A461810"."SEGUROS_PK" ON "ISIS2304A461810"."SEGUROS" ("IDSEGURO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  Constraints for Table SEGUROS
--------------------------------------------------------

  ALTER TABLE "ISIS2304A461810"."SEGUROS" MODIFY ("IDCONTRATO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."SEGUROS" MODIFY ("IDALOJAMIENTO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."SEGUROS" MODIFY ("IDSEGURO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."SEGUROS" ADD CONSTRAINT "SEGUROS_PK" PRIMARY KEY ("IDSEGURO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
  ALTER TABLE "ISIS2304A461810"."SEGUROS" ADD CONSTRAINT "SEGUROS_CHK1" CHECK (COSTO>=0) ENABLE;
