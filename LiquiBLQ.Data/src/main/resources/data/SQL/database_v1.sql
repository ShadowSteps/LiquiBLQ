
CREATE EXTENSION "uuid-ossp";
CREATE TABLE public.users
(
   id serial NOT NULL, 
   email text NOT NULL, 
   password text NOT NULL, 
   salt text NOT NULL, 
   name text, 
   date_registered timestamp without time zone NOT NULL default now(), 
   CONSTRAINT user_pk PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
   
CREATE TABLE public.sessions
(
   id uuid NOT NULL default uuid_generate_v4(), 
   "user" integer NOT NULL, 
   active boolean NOT NULL default true, 
   date_created timestamp without time zone NOT NULL default now(), 
   CONSTRAINT sessions_pk PRIMARY KEY (id), 
   CONSTRAINT users_fk FOREIGN KEY ("user") REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE
) 
WITH (
  OIDS = FALSE
)
;
