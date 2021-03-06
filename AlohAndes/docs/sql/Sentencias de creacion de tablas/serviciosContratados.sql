--------------------------------------------------------
-- Archivo creado  - martes-marzo-20-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SERVICIOSCONTRATADOS
--------------------------------------------------------

  CREATE TABLE "ISIS2304A461810"."SERVICIOSCONTRATADOS" 
   (	"IDSERVICIO" NUMBER, 
	"IDCONTRATO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  DDL for Index SERVICIOSCONTRATADOS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ISIS2304A461810"."SERVICIOSCONTRATADOS_PK" ON "ISIS2304A461810"."SERVICIOSCONTRATADOS" ("IDSERVICIO", "IDCONTRATO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE "TBSPROD" ;
--------------------------------------------------------
--  Constraints for Table SERVICIOSCONTRATADOS
--------------------------------------------------------

  ALTER TABLE "ISIS2304A461810"."SERVICIOSCONTRATADOS" MODIFY ("IDCONTRATO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."SERVICIOSCONTRATADOS" MODIFY ("IDSERVICIO" NOT NULL ENABLE);
  ALTER TABLE "ISIS2304A461810"."SERVICIOSCONTRATADOS" ADD CONSTRAINT "SERVICIOSCONTRATADOS_PK" PRIMARY KEY ("IDSERVICIO", "IDCONTRATO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE "TBSPROD"  ENABLE;
