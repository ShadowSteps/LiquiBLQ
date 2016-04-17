
CREATE TABLE public."artist"
(
   id uuid NOT NULL default uuid_generate_v4(), 
   "name" text NOT NULL, 
   "nickname" text, 
   "dateofbirth" timestamp without time zone, 
   CONSTRAINT "artists_pk" PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;
CREATE TABLE public."album"
(
   "id" uuid NOT NULL default uuid_generate_v4(), 
   "date" timestamp without time zone, 
   "name" text NOT NULL, 
   CONSTRAINT "album_pk" PRIMARY KEY ("id")
) 
WITH (
  OIDS = FALSE
)
;

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
   "id" uuid NOT NULL default uuid_generate_v4(), 
   "name" text NOT NULL, 
   CONSTRAINT "genre_pk" PRIMARY KEY ("id")
) 
WITH (
  OIDS = FALSE
)
;

CREATE TABLE public."songs"
(
   "id" uuid NOT NULL default uuid_generate_v4(), 
   "name" text NOT NULL, 
   "genre" uuid NOT NULL, 
   "date" timestamp without time zone, 
   CONSTRAINT "song_pk" PRIMARY KEY ("id"),
   CONSTRAINT "s_genre_fk" FOREIGN KEY ("genre") REFERENCES "genre" (id) ON UPDATE CASCADE ON DELETE CASCADE
) 
WITH (
  OIDS = FALSE
)
;

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

ALTER TABLE sessions RENAME "user"  TO "user_id";
