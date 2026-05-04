--
-- PostgreSQL database dump
--

\restrict zlc8hNJCpvHFSZVjFzIl12DZOTCB6ZambD0uRz4yHnzhuWBcOnvmykindvZHOsw

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-05-03 23:09:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- TOC entry 222 (class 1259 OID 16399)
-- Name: tb_motocicleta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_motocicleta (
    id_moto integer NOT NULL,
    id_tipo integer NOT NULL,
    marca_moto character varying(255) NOT NULL,
    modelo_moto character varying(255) NOT NULL,
    anio_moto integer NOT NULL,
    precio_moto double precision NOT NULL,
    id_prov integer
);


ALTER TABLE public.tb_motocicleta OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16398)
-- Name: tb_motocicleta_id_moto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_motocicleta_id_moto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_motocicleta_id_moto_seq OWNER TO postgres;

--
-- TOC entry 4945 (class 0 OID 0)
-- Dependencies: 221
-- Name: tb_motocicleta_id_moto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_motocicleta_id_moto_seq OWNED BY public.tb_motocicleta.id_moto;


--
-- TOC entry 224 (class 1259 OID 32857)
-- Name: tb_proveedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_proveedor (
    id_prov integer NOT NULL,
    nombre_prov character varying(255) NOT NULL,
    contacto_prov character varying(255)
);


ALTER TABLE public.tb_proveedor OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 32856)
-- Name: tb_proveedor_id_prov_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_proveedor_id_prov_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_proveedor_id_prov_seq OWNER TO postgres;

--
-- TOC entry 4946 (class 0 OID 0)
-- Dependencies: 223
-- Name: tb_proveedor_id_prov_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_proveedor_id_prov_seq OWNED BY public.tb_proveedor.id_prov;


--
-- TOC entry 226 (class 1259 OID 32874)
-- Name: tb_servicio_tecnico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_servicio_tecnico (
    id_servicio integer NOT NULL,
    detalle_servicio text,
    fecha_servicio date,
    id_moto integer
);


ALTER TABLE public.tb_servicio_tecnico OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 32873)
-- Name: tb_servicio_tecnico_id_servicio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_servicio_tecnico_id_servicio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_servicio_tecnico_id_servicio_seq OWNER TO postgres;

--
-- TOC entry 4947 (class 0 OID 0)
-- Dependencies: 225
-- Name: tb_servicio_tecnico_id_servicio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_servicio_tecnico_id_servicio_seq OWNED BY public.tb_servicio_tecnico.id_servicio;


--
-- TOC entry 220 (class 1259 OID 16390)
-- Name: tb_tipo_motocicleta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_tipo_motocicleta (
    id_tipo integer NOT NULL,
    descripcion_tipo character varying(255) NOT NULL
);


ALTER TABLE public.tb_tipo_motocicleta OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16389)
-- Name: tb_tipo_motocicleta_id_tipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_tipo_motocicleta_id_tipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_tipo_motocicleta_id_tipo_seq OWNER TO postgres;

--
-- TOC entry 4948 (class 0 OID 0)
-- Dependencies: 219
-- Name: tb_tipo_motocicleta_id_tipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_tipo_motocicleta_id_tipo_seq OWNED BY public.tb_tipo_motocicleta.id_tipo;


--
-- TOC entry 4771 (class 2604 OID 16402)
-- Name: tb_motocicleta id_moto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_motocicleta ALTER COLUMN id_moto SET DEFAULT nextval('public.tb_motocicleta_id_moto_seq'::regclass);


--
-- TOC entry 4772 (class 2604 OID 32860)
-- Name: tb_proveedor id_prov; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_proveedor ALTER COLUMN id_prov SET DEFAULT nextval('public.tb_proveedor_id_prov_seq'::regclass);


--
-- TOC entry 4773 (class 2604 OID 32877)
-- Name: tb_servicio_tecnico id_servicio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_servicio_tecnico ALTER COLUMN id_servicio SET DEFAULT nextval('public.tb_servicio_tecnico_id_servicio_seq'::regclass);


--
-- TOC entry 4770 (class 2604 OID 16393)
-- Name: tb_tipo_motocicleta id_tipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_tipo_motocicleta ALTER COLUMN id_tipo SET DEFAULT nextval('public.tb_tipo_motocicleta_id_tipo_seq'::regclass);


--
-- TOC entry 4935 (class 0 OID 16399)
-- Dependencies: 222
-- Data for Name: tb_motocicleta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_motocicleta (id_moto, id_tipo, marca_moto, modelo_moto, anio_moto, precio_moto, id_prov) FROM stdin;
4	1	Honda	CB500	2024	6500	1
5	1	Honda	CB500	2024	6500	1
6	1	Honda	CB500	2024	6500	1
7	1	Honda	CB500	2024	6500	1
8	1	Honda	CB500	2024	6500	1
9	1	Honda	CB500	2024	6500	1
10	4	DAYTONA	scrambler	2020	2600	1
11	1	AXXO	SCRAMBLER	2022	1200	1
12	1	KAWASAKI	Z1000	2020	8600	1
13	1	axxo	scrambler	2001	2000	1
14	3	suzuki	vstrom	2000	2000	1
15	1	suzuki	0002	2026	2050	2
16	2	harley	chopper	2005	2050	\N
\.


--
-- TOC entry 4937 (class 0 OID 32857)
-- Dependencies: 224
-- Data for Name: tb_proveedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_proveedor (id_prov, nombre_prov, contacto_prov) FROM stdin;
1	Importadora Velocidad	0991234567
2	otom	0923902390
3	0	0
\.


--
-- TOC entry 4939 (class 0 OID 32874)
-- Dependencies: 226
-- Data for Name: tb_servicio_tecnico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_servicio_tecnico (id_servicio, detalle_servicio, fecha_servicio, id_moto) FROM stdin;
\.


--
-- TOC entry 4933 (class 0 OID 16390)
-- Dependencies: 220
-- Data for Name: tb_tipo_motocicleta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb_tipo_motocicleta (id_tipo, descripcion_tipo) FROM stdin;
1	Deportiva
2	Crucero
3	Touring
4	Offroad
5	Scooter
\.


--
-- TOC entry 4949 (class 0 OID 0)
-- Dependencies: 221
-- Name: tb_motocicleta_id_moto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_motocicleta_id_moto_seq', 16, true);


--
-- TOC entry 4950 (class 0 OID 0)
-- Dependencies: 223
-- Name: tb_proveedor_id_prov_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_proveedor_id_prov_seq', 3, true);


--
-- TOC entry 4951 (class 0 OID 0)
-- Dependencies: 225
-- Name: tb_servicio_tecnico_id_servicio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_servicio_tecnico_id_servicio_seq', 1, false);


--
-- TOC entry 4952 (class 0 OID 0)
-- Dependencies: 219
-- Name: tb_tipo_motocicleta_id_tipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_tipo_motocicleta_id_tipo_seq', 5, true);


--
-- TOC entry 4777 (class 2606 OID 16410)
-- Name: tb_motocicleta tb_motocicleta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_motocicleta
    ADD CONSTRAINT tb_motocicleta_pkey PRIMARY KEY (id_moto);


--
-- TOC entry 4779 (class 2606 OID 32864)
-- Name: tb_proveedor tb_proveedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_proveedor
    ADD CONSTRAINT tb_proveedor_pkey PRIMARY KEY (id_prov);


--
-- TOC entry 4781 (class 2606 OID 32882)
-- Name: tb_servicio_tecnico tb_servicio_tecnico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_servicio_tecnico
    ADD CONSTRAINT tb_servicio_tecnico_pkey PRIMARY KEY (id_servicio);


--
-- TOC entry 4775 (class 2606 OID 16397)
-- Name: tb_tipo_motocicleta tb_tipo_motocicleta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_tipo_motocicleta
    ADD CONSTRAINT tb_tipo_motocicleta_pkey PRIMARY KEY (id_tipo);


--
-- TOC entry 4782 (class 2606 OID 32865)
-- Name: tb_motocicleta fk_proveedor_moto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_motocicleta
    ADD CONSTRAINT fk_proveedor_moto FOREIGN KEY (id_prov) REFERENCES public.tb_proveedor(id_prov);


--
-- TOC entry 4783 (class 2606 OID 16411)
-- Name: tb_motocicleta tb_motocicleta_id_tipo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_motocicleta
    ADD CONSTRAINT tb_motocicleta_id_tipo_fkey FOREIGN KEY (id_tipo) REFERENCES public.tb_tipo_motocicleta(id_tipo);


--
-- TOC entry 4784 (class 2606 OID 32883)
-- Name: tb_servicio_tecnico tb_servicio_tecnico_id_moto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_servicio_tecnico
    ADD CONSTRAINT tb_servicio_tecnico_id_moto_fkey FOREIGN KEY (id_moto) REFERENCES public.tb_motocicleta(id_moto);


-- Completed on 2026-05-03 23:09:58

--
-- PostgreSQL database dump complete
--

\unrestrict zlc8hNJCpvHFSZVjFzIl12DZOTCB6ZambD0uRz4yHnzhuWBcOnvmykindvZHOsw

