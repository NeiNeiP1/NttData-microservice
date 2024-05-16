CREATE TABLE IF NOT EXISTS TBL_CUSTOMERTYPE ( id LONG NOT NULL , name VARCHAR, PRIMARY KEY(id)  );
DELETE FROM TBL_CUSTOMERTYPE WHERE id >= '1';
INSERT INTO TBL_CUSTOMERTYPE (id,name) VALUES (1, 'Staff');
INSERT INTO TBL_CUSTOMERTYPE (id,name) VALUES (2, 'Company');
select * from TBL_CUSTOMERTYPE;

CREATE TABLE IF NOT EXISTS tbl_documenttype ( id INT NOT NULL,name VARCHAR,description VARCHAR,PRIMARY KEY (id));

INSERT INTO tbl_documenttype (id,name) VALUES (1, 'DNI');
INSERT INTO tbl_documenttype (id,name) VALUES (2, 'RUC');
INSERT INTO tbl_documenttype (id,name) VALUES (3, 'Pasaporte');
DELETE FROM tbl_documenttype WHERE id >= '1';
select * FROM tbl_documenttype;

CREATE TABLE IF NOT EXISTS tbl_customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR,
    doc VARCHAR,
    typedoc_id LONG NOT NULL,
    status VARCHAR,
    location VARCHAR,
    phonenumber VARCHAR,
    email VARCHAR,
    customertype_id LONG NOT NULL);

