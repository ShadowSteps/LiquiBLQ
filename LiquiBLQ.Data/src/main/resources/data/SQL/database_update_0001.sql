
CREATE TABLE public."artist"
(
   id uuid NOT NULL, 
   "name" character varying(55) NOT NULL, 
   "nickname" character varying(55) NOT NULL, 
   "dateofbirth" timestamp without time zone NOT NULL, 
   CONSTRAINT "artists_pk" PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
CREATE OR REPLACE FUNCTION artist_bi_f() RETURNS trigger AS
$BODY$
BEGIN
IF (TG_OP = 'INSERT') THEN 
    IF (new.id is null) THEN
	new.id = uuid_generate_v4();
    END IF;    
    RETURN NEW;
END IF;
END;
$BODY$
LANGUAGE plpgsql VOLATILE NOT LEAKPROOF
COST 100;

  
CREATE TRIGGER artist_bi BEFORE INSERT
   ON artist FOR EACH ROW
   EXECUTE PROCEDURE public.artist_bi_f();

CREATE TABLE public."album"
(
   "id" uuid NOT NULL, 
   "date" timestamp without time zone NOT NULL, 
   "name" character varying(55) NOT NULL, 
   CONSTRAINT "album_pk" PRIMARY KEY ("id")
) 
WITH (
  OIDS = FALSE
)
;

CREATE OR REPLACE FUNCTION album_bi_f() RETURNS trigger AS
$BODY$
BEGIN
IF (TG_OP = 'INSERT') THEN 
    IF (new.id is null) THEN
	new.id = uuid_generate_v4();
    END IF;    
    RETURN NEW;
END IF;
END;
$BODY$
LANGUAGE plpgsql VOLATILE NOT LEAKPROOF
COST 100;

CREATE TRIGGER album_bi BEFORE INSERT
   ON album FOR EACH ROW
   EXECUTE PROCEDURE public.album_bi_f();

CREATE TABLE public."artists_in_albums"
(
   "id" serial NOT NULL, 
   "artist" uuid NOT NULL, 
   "album" uuid NOT NULL, 
   CONSTRAINT "artistalbum_pk" PRIMARY KEY ("id"), 
   CONSTRAINT "aia_artists_fk" FOREIGN KEY ("artist") REFERENCES "artist" (id) ON UPDATE CASCADE ON DELETE CASCADE,
   CONSTRAINT "aia_album_fk" FOREIGN KEY ("album") REFERENCES "album" (id) ON UPDATE CASCADE ON DELETE CASCADE
) 
WITH (
  OIDS = FALSE
)
;

CREATE TABLE public."genre"
(
   "id" uuid NOT NULL, 
   "name" character varying(55) NOT NULL, 
   CONSTRAINT "genre_pk" PRIMARY KEY ("id")
) 
WITH (
  OIDS = FALSE
)
;

CREATE OR REPLACE FUNCTION genre_bi_f() RETURNS trigger AS
$BODY$
BEGIN
IF (TG_OP = 'INSERT') THEN 
    IF (new.id is null) THEN
	new.id = uuid_generate_v4();
    END IF;    
    RETURN NEW;
END IF;
END;
$BODY$
LANGUAGE plpgsql VOLATILE NOT LEAKPROOF
COST 100;

CREATE TRIGGER genre_bi BEFORE INSERT
   ON genre FOR EACH ROW
   EXECUTE PROCEDURE public.genre_bi_f();

CREATE TABLE public."songs"
(
   "id" uuid NOT NULL, 
   "name" character varying(55) NOT NULL, 
   "genre" uuid NOT NULL, 
   "date" timestamp without time zone NOT NULL, 
   CONSTRAINT "song_pk" PRIMARY KEY ("id"),
   CONSTRAINT "s_genre_fk" FOREIGN KEY ("genre") REFERENCES "genre" (id) ON UPDATE CASCADE ON DELETE CASCADE
) 
WITH (
  OIDS = FALSE
)
;

CREATE OR REPLACE FUNCTION songs_bi_f() RETURNS trigger AS
$BODY$
BEGIN
IF (TG_OP = 'INSERT') THEN 
    IF (new.id is null) THEN
	new.id = uuid_generate_v4();
    END IF;    
    RETURN NEW;
END IF;
END;
$BODY$
LANGUAGE plpgsql VOLATILE NOT LEAKPROOF
COST 100;

CREATE TRIGGER songs_bi BEFORE INSERT
   ON songs FOR EACH ROW
   EXECUTE PROCEDURE public.songs_bi_f();

CREATE TABLE public."songs_in_album"
(
   "id" serial NOT NULL, 
   "song" uuid NOT NULL, 
   "album" uuid NOT NULL, 
   CONSTRAINT "songs_in_album_pk" PRIMARY KEY ("id"),
   CONSTRAINT "sia_songs_fk" FOREIGN KEY ("song") REFERENCES "songs" (id) ON UPDATE CASCADE ON DELETE CASCADE,
   CONSTRAINT "sia_album_fk" FOREIGN KEY ("album") REFERENCES "album" (id) ON UPDATE CASCADE ON DELETE CASCADE
) 
WITH (
  OIDS = FALSE
)
;

ALTER TABLE sessions RENAME "user"  TO "userId";
