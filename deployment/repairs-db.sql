--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: repair; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.repair (
    id_repair bigint NOT NULL,
    age_surcharge integer NOT NULL,
    base_price integer NOT NULL,
    day_discount integer NOT NULL,
    delay_surcharge integer NOT NULL,
    id_ticket bigint,
    km_surcharge integer NOT NULL,
    repair_type integer NOT NULL,
    repairs_discount integer NOT NULL,
    total_price integer NOT NULL
);


ALTER TABLE public.repair OWNER TO postgres;

--
-- Name: repair_id_repair_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.repair ALTER COLUMN id_repair ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.repair_id_repair_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: repair; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.repair (id_repair, age_surcharge, base_price, day_discount, delay_surcharge, id_ticket, km_surcharge, repair_type, repairs_discount, total_price) FROM stdin;
\.


--
-- Name: repair_id_repair_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.repair_id_repair_seq', 8, true);


--
-- Name: repair repair_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.repair
    ADD CONSTRAINT repair_pkey PRIMARY KEY (id_repair);


--
-- PostgreSQL database dump complete
--

