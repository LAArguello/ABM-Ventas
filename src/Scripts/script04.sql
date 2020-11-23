/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Arguello Leonel
 * Created: 26-oct-2020
 */

CREATE TABLE public.factura
(
    id BIGSERIAL NOT NULL,
    fecha date,
    cliente integer,
    productos character varying(3000000) COLLATE pg_catalog."default",
    cantidad integer,
    forma_pago character varying(300) COLLATE pg_catalog."default",
    observacion character varying(300) COLLATE pg_catalog."default",
    total double precision,
    CONSTRAINT factura_pkey PRIMARY KEY (id),
    CONSTRAINT idcliente FOREIGN KEY (cliente)
        REFERENCES public.clientes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.factura
    OWNER to postgres;