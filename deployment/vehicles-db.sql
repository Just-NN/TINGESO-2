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
-- Name: vehicle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vehicle (
    license_plate bigint NOT NULL,
    brand character varying(255),
    engine_type integer NOT NULL,
    mileage integer NOT NULL,
    model character varying(255),
    seats integer NOT NULL,
    vehicle_type integer NOT NULL,
    year integer NOT NULL
);


ALTER TABLE public.vehicle OWNER TO postgres;

--
-- Name: vehicle_license_plate_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.vehicle ALTER COLUMN license_plate ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.vehicle_license_plate_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: vehicle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vehicle (license_plate, brand, engine_type, mileage, model, seats, vehicle_type, year) FROM stdin;
1	Toyota	1	50000	Corolla	5	1	2010
\.


--
-- Name: vehicle_license_plate_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vehicle_license_plate_seq', 1, true);


--
-- Name: vehicle vehicle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT vehicle_pkey PRIMARY KEY (license_plate);


--
-- PostgreSQL database dump complete
--

