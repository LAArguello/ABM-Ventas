/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Arguello Leonel
 * Created: 26-oct-2020
 */

CREATE TABLE public.cliente_tipo
(
    id serial NOT NULL,
    nombre character varying(60) COLLATE pg_catalog."default" NOT NULL,
    descripcion character varying(12) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_cliente_tipo_id PRIMARY KEY (id)
)