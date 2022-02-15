-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-02-14 18:40:00.812

-- tables
-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    email varchar(50)  NULL,
    telephone varchar(15)  NULL,
    birth_date date  NOT NULL,
    address varchar(50)  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: costume
CREATE TABLE costume (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT costume_set_pk PRIMARY KEY (id)
);

-- Table: element
CREATE TABLE element (
    id serial  NOT NULL,
    element_type_id int  NOT NULL,
    element_name varchar(50)  NOT NULL,
    description varchar(250)  NOT NULL,
    CONSTRAINT set_element_pk PRIMARY KEY (id)
);

-- Table: element_in_costume
CREATE TABLE element_in_costume (
    id serial  NOT NULL,
    costume_id int  NOT NULL,
    set_element_id int  NOT NULL,
    CONSTRAINT element_in_costume_pk PRIMARY KEY (id)
);

-- Table: element_type
CREATE TABLE element_type (
    id serial  NOT NULL,
    element_type varchar(50)  NOT NULL,
    CONSTRAINT costume_set_element_type_pk PRIMARY KEY (id)
);

-- Table: group
CREATE TABLE "group" (
    id serial  NOT NULL,
    group_name varchar(50)  NOT NULL,
    CONSTRAINT group_pk PRIMARY KEY (id)
);

-- Table: inventory_balance
CREATE TABLE inventory_balance (
    id serial  NOT NULL,
    quantity int  NOT NULL,
    status_id int  NOT NULL,
    element_in_costume_id int  NOT NULL,
    CONSTRAINT inventory_balance_pk PRIMARY KEY (id)
);

-- Table: role_type
CREATE TABLE role_type (
    id serial  NOT NULL,
    name varchar(20)  NOT NULL,
    CONSTRAINT role_type_pk PRIMARY KEY (id)
);

-- Table: status
CREATE TABLE status (
    id serial  NOT NULL,
    status_type_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT status_pk PRIMARY KEY (id)
);

-- Table: status_type
CREATE TABLE status_type (
    id serial  NOT NULL,
    location varchar(50)  NOT NULL,
    CONSTRAINT status_type_pk PRIMARY KEY (id)
);

-- Table: transactions
CREATE TABLE transactions (
    id serial  NOT NULL,
    quantity int  NOT NULL,
    transaction_time date  NOT NULL,
    status_id int  NOT NULL,
    element_in_costume_id int  NOT NULL,
    CONSTRAINT transactions_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    firstname varchar(50)  NOT NULL,
    lastname varchar(50)  NOT NULL,
    contact_id int  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_in_group
CREATE TABLE user_in_group (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    group_id int  NOT NULL,
    user_role_id int  NOT NULL,
    CONSTRAINT user_in_group_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    role_id int  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: element_in_costume_costume (table: element_in_costume)
ALTER TABLE element_in_costume ADD CONSTRAINT element_in_costume_costume
    FOREIGN KEY (costume_id)
    REFERENCES costume (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: element_in_costume_set_element (table: element_in_costume)
ALTER TABLE element_in_costume ADD CONSTRAINT element_in_costume_set_element
    FOREIGN KEY (set_element_id)
    REFERENCES element (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: inventory_balance_element_in_costume (table: inventory_balance)
ALTER TABLE inventory_balance ADD CONSTRAINT inventory_balance_element_in_costume
    FOREIGN KEY (element_in_costume_id)
    REFERENCES element_in_costume (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: inventory_balance_status (table: inventory_balance)
ALTER TABLE inventory_balance ADD CONSTRAINT inventory_balance_status
    FOREIGN KEY (status_id)
    REFERENCES status (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: set_element_element_type (table: element)
ALTER TABLE element ADD CONSTRAINT set_element_element_type
    FOREIGN KEY (element_type_id)
    REFERENCES element_type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: status_status_type (table: status)
ALTER TABLE status ADD CONSTRAINT status_status_type
    FOREIGN KEY (status_type_id)
    REFERENCES status_type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: status_user (table: status)
ALTER TABLE status ADD CONSTRAINT status_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: transactions_element_in_costume (table: transactions)
ALTER TABLE transactions ADD CONSTRAINT transactions_element_in_costume
    FOREIGN KEY (element_in_costume_id)
    REFERENCES element_in_costume (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: transactions_status (table: transactions)
ALTER TABLE transactions ADD CONSTRAINT transactions_status
    FOREIGN KEY (status_id)
    REFERENCES status (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_contact
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_in_group_group (table: user_in_group)
ALTER TABLE user_in_group ADD CONSTRAINT user_in_group_group
    FOREIGN KEY (group_id)
    REFERENCES "group" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_in_group_user (table: user_in_group)
ALTER TABLE user_in_group ADD CONSTRAINT user_in_group_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_in_group_user_role (table: user_in_group)
ALTER TABLE user_in_group ADD CONSTRAINT user_in_group_user_role
    FOREIGN KEY (user_role_id)
    REFERENCES user_role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role_type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- sequences
-- Sequence: costume_set_element_type_seq
CREATE SEQUENCE costume_set_element_type_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: costume_set_seq
CREATE SEQUENCE costume_set_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: set_element_seq
CREATE SEQUENCE set_element_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- End of file.

