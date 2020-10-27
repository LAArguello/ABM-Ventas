
CREATE TABLE public.clientes
(
    id serial NOT NULL,
    nombre character varying(60) COLLATE pg_catalog."default" NOT NULL,
    apellido character varying(12) COLLATE pg_catalog."default" NOT NULL,
    documento character varying(60) COLLATE pg_catalog."default",
    cliente_tipo_id serial NOT NULL,
    CONSTRAINT pk_clientes_id PRIMARY KEY (id)
    CONSTRAINT tipo_cliente_id FOREIGN KEY (cliente_tipo_id)
    REFERENCES public.cliente_tipo (id) MATCH SIMPLE
)
