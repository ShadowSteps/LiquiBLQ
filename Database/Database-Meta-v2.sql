
CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';

--
-- TOC entry 186 (class 1259 OID 104840)
-- Name: album; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE album (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    date timestamp without time zone,
    name text NOT NULL
);


ALTER TABLE album OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 104831)
-- Name: artist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE artist (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text NOT NULL,
    nickname text,
    dateofbirth timestamp without time zone
);


ALTER TABLE artist OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 104851)
-- Name: artists_in_albums; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE artists_in_albums (
    id integer NOT NULL,
    artist uuid NOT NULL,
    album uuid NOT NULL
);


ALTER TABLE artists_in_albums OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 104849)
-- Name: artists_in_albums_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE artists_in_albums_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE artists_in_albums_id_seq OWNER TO postgres;

--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 187
-- Name: artists_in_albums_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE artists_in_albums_id_seq OWNED BY artists_in_albums.id;


--
-- TOC entry 189 (class 1259 OID 104867)
-- Name: genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE genre (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text NOT NULL
);


ALTER TABLE genre OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 104818)
-- Name: sessions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sessions (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    user_id integer NOT NULL,
    active boolean DEFAULT true NOT NULL,
    date_created timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE sessions OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 104876)
-- Name: songs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE songs (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text NOT NULL,
    genre uuid NOT NULL,
    date timestamp without time zone,
    file text
);


ALTER TABLE songs OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 104892)
-- Name: songs_in_album; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE songs_in_album (
    id integer NOT NULL,
    song uuid NOT NULL,
    album uuid NOT NULL
);


ALTER TABLE songs_in_album OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 104890)
-- Name: songs_in_album_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE songs_in_album_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE songs_in_album_id_seq OWNER TO postgres;

--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 191
-- Name: songs_in_album_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE songs_in_album_id_seq OWNED BY songs_in_album.id;


--
-- TOC entry 183 (class 1259 OID 104808)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id integer NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    salt text NOT NULL,
    name text,
    date_registered timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 104806)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 182
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 2036 (class 2604 OID 104854)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY artists_in_albums ALTER COLUMN id SET DEFAULT nextval('artists_in_albums_id_seq'::regclass);


--
-- TOC entry 2039 (class 2604 OID 104895)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY songs_in_album ALTER COLUMN id SET DEFAULT nextval('songs_in_album_id_seq'::regclass);


--
-- TOC entry 2029 (class 2604 OID 104811)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--

SELECT pg_catalog.setval('artists_in_albums_id_seq', 46, true);


--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 191
-- Name: songs_in_album_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('songs_in_album_id_seq', 45, true);


--

SELECT pg_catalog.setval('users_id_seq', 76, true);


--
-- TOC entry 2047 (class 2606 OID 104848)
-- Name: album_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY album
    ADD CONSTRAINT album_pk PRIMARY KEY (id);


--
-- TOC entry 2049 (class 2606 OID 104856)
-- Name: artistalbum_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY artists_in_albums
    ADD CONSTRAINT artistalbum_pk PRIMARY KEY (id);


--
-- TOC entry 2045 (class 2606 OID 104839)
-- Name: artists_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY artist
    ADD CONSTRAINT artists_pk PRIMARY KEY (id);


--
-- TOC entry 2051 (class 2606 OID 104875)
-- Name: genre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY genre
    ADD CONSTRAINT genre_pk PRIMARY KEY (id);


--
-- TOC entry 2043 (class 2606 OID 104825)
-- Name: sessions_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sessions
    ADD CONSTRAINT sessions_pk PRIMARY KEY (id);


--
-- TOC entry 2053 (class 2606 OID 104884)
-- Name: song_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY songs
    ADD CONSTRAINT song_pk PRIMARY KEY (id);


--
-- TOC entry 2055 (class 2606 OID 104897)
-- Name: songs_in_album_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY songs_in_album
    ADD CONSTRAINT songs_in_album_pk PRIMARY KEY (id);


--
-- TOC entry 2041 (class 2606 OID 104817)
-- Name: user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- TOC entry 2058 (class 2606 OID 104862)
-- Name: aia_album_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY artists_in_albums
    ADD CONSTRAINT aia_album_fk FOREIGN KEY (album) REFERENCES album(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2057 (class 2606 OID 104857)
-- Name: aia_artists_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY artists_in_albums
    ADD CONSTRAINT aia_artists_fk FOREIGN KEY (artist) REFERENCES artist(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2059 (class 2606 OID 104885)
-- Name: s_genre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY songs
    ADD CONSTRAINT s_genre_fk FOREIGN KEY (genre) REFERENCES genre(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2061 (class 2606 OID 104903)
-- Name: sia_album_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY songs_in_album
    ADD CONSTRAINT sia_album_fk FOREIGN KEY (album) REFERENCES album(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2060 (class 2606 OID 104898)
-- Name: sia_songs_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY songs_in_album
    ADD CONSTRAINT sia_songs_fk FOREIGN KEY (song) REFERENCES songs(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2056 (class 2606 OID 104826)
-- Name: users_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sessions
    ADD CONSTRAINT users_fk FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-28 00:47:39

--
-- PostgreSQL database dump complete
--

