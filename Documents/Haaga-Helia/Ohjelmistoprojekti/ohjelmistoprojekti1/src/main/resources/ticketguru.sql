PGDMP     5    4                y        
   ticketguru    13.2    13.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394 
   ticketguru    DATABASE     h   CREATE DATABASE ticketguru WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Finnish_Finland.1252';
    DROP DATABASE ticketguru;
                postgres    false            �            1259    16556    appuser    TABLE     �   CREATE TABLE public.appuser (
    userid bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    role character varying(255),
    username character varying(255)
);
    DROP TABLE public.appuser;
       public         heap    postgres    false            �            1259    16543    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    16520    ticket    TABLE     u   CREATE TABLE public.ticket (
    ticketid bigint NOT NULL,
    eventid bigint,
    trid bigint,
    typeid bigint
);
    DROP TABLE public.ticket;
       public         heap    postgres    false            �            1259    16525    transaction    TABLE     a   CREATE TABLE public.transaction (
    trid bigint NOT NULL,
    trtime character varying(255)
);
    DROP TABLE public.transaction;
       public         heap    postgres    false            �            1259    16530    type    TABLE     �   CREATE TABLE public.type (
    typeid bigint NOT NULL,
    price double precision NOT NULL,
    typename character varying(255)
);
    DROP TABLE public.type;
       public         heap    postgres    false            �            1259    16535    venue    TABLE     �   CREATE TABLE public.venue (
    venueid bigint NOT NULL,
    address character varying(255),
    city character varying(255),
    postcode character varying(255),
    venuename character varying(255)
);
    DROP TABLE public.venue;
       public         heap    postgres    false            �          0    16556    appuser 
   TABLE DATA           Z   COPY public.appuser (userid, first_name, last_name, password, role, username) FROM stdin;
    public          postgres    false    205   o       �          0    16520    ticket 
   TABLE DATA           A   COPY public.ticket (ticketid, eventid, trid, typeid) FROM stdin;
    public          postgres    false    200   �       �          0    16525    transaction 
   TABLE DATA           3   COPY public.transaction (trid, trtime) FROM stdin;
    public          postgres    false    201   �       �          0    16530    type 
   TABLE DATA           7   COPY public.type (typeid, price, typename) FROM stdin;
    public          postgres    false    202   �       �          0    16535    venue 
   TABLE DATA           L   COPY public.venue (venueid, address, city, postcode, venuename) FROM stdin;
    public          postgres    false    203   �       �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public          postgres    false    204            =           2606    16563    appuser appuser_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.appuser
    ADD CONSTRAINT appuser_pkey PRIMARY KEY (userid);
 >   ALTER TABLE ONLY public.appuser DROP CONSTRAINT appuser_pkey;
       public            postgres    false    205            5           2606    16524    ticket ticket_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (ticketid);
 <   ALTER TABLE ONLY public.ticket DROP CONSTRAINT ticket_pkey;
       public            postgres    false    200            7           2606    16529    transaction transaction_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (trid);
 F   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_pkey;
       public            postgres    false    201            9           2606    16534    type type_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pkey PRIMARY KEY (typeid);
 8   ALTER TABLE ONLY public.type DROP CONSTRAINT type_pkey;
       public            postgres    false    202            ;           2606    16542    venue venue_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.venue
    ADD CONSTRAINT venue_pkey PRIMARY KEY (venueid);
 :   ALTER TABLE ONLY public.venue DROP CONSTRAINT venue_pkey;
       public            postgres    false    203            ?           2606    16550 "   ticket fkkl16tas6yekfnek1wn7o5jo6h    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT fkkl16tas6yekfnek1wn7o5jo6h FOREIGN KEY (typeid) REFERENCES public.type(typeid);
 L   ALTER TABLE ONLY public.ticket DROP CONSTRAINT fkkl16tas6yekfnek1wn7o5jo6h;
       public          postgres    false    200    2873    202            >           2606    16545 "   ticket fkoqxlky0g0nxr6ome3rmq1y2lv    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT fkoqxlky0g0nxr6ome3rmq1y2lv FOREIGN KEY (trid) REFERENCES public.transaction(trid);
 L   ALTER TABLE ONLY public.ticket DROP CONSTRAINT fkoqxlky0g0nxr6ome3rmq1y2lv;
       public          postgres    false    2871    201    200            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     