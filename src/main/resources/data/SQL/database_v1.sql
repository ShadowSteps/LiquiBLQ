-- Database: "liquiBlq"

-- DROP DATABASE "liquiBlq";

CREATE DATABASE "liquiBlq"
  WITH OWNER = postgres
       ENCODING = 'WIN1251'
       TABLESPACE = pg_default
       LC_COLLATE = 'Bulgarian_Bulgaria.1251'
       LC_CTYPE = 'Bulgarian_Bulgaria.1251'
       CONNECTION LIMIT = -1;

CREATE EXTENSION "uuid-ossp";
CREATE TABLE public.users
(
   id serial NOT NULL, 
   email character varying(55) NOT NULL, 
   password character(64) NOT NULL, 
   salt character(5) NOT NULL, 
   name character varying(50), 
   date_registered timestamp without time zone NOT NULL, 
   CONSTRAINT user_pk PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
CREATE OR REPLACE FUNCTION users_bi_f() RETURNS trigger AS
$BODY$
BEGIN
IF (TG_OP = 'INSERT') THEN 
    IF (new.date_registered is null) THEN
	new.date_registered = now();
    END IF;    
    RETURN NEW;
END IF;
END;
$BODY$
LANGUAGE plpgsql VOLATILE NOT LEAKPROOF
COST 100;

  
CREATE TRIGGER users_bi BEFORE INSERT
   ON users FOR EACH ROW
   EXECUTE PROCEDURE public.users_bi_f();
   
CREATE TABLE public.sessions
(
   id uuid NOT NULL, 
   "user" integer NOT NULL, 
   active boolean NOT NULL, 
   date_created timestamp without time zone NOT NULL, 
   CONSTRAINT sessions_pk PRIMARY KEY (id), 
   CONSTRAINT users_fk FOREIGN KEY ("user") REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE
) 
WITH (
  OIDS = FALSE
)
;

CREATE OR REPLACE FUNCTION sessions_bi_f() RETURNS trigger AS
$BODY$
BEGIN
IF (TG_OP = 'INSERT') THEN 
    IF (new.id is null) THEN
  new.id = uuid_generate_v4();
 end if;
 IF (new.date_created is null) THEN
  NEW.date_created = now();
    END IF;    
    RETURN NEW;
END IF;
END;
$BODY$
LANGUAGE plpgsql VOLATILE NOT LEAKPROOF
COST 100;

  
CREATE TRIGGER sessions_bi BEFORE INSERT
   ON sessions FOR EACH ROW
   EXECUTE PROCEDURE public.sessions_bi_f();
