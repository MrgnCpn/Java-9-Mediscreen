DROP DATABASE IF EXISTS mediscreen_patientadmin_test_oc_mc;

/** TEST DB **/

-- CREATE Database
CREATE DATABASE IF NOT EXISTS mediscreen_patientadmin_test_oc_mc;
USE mediscreen_patientadmin_test_oc_mc;
SET autocommit=1;

-- CREATE Tables
    -- Users Table
    CREATE TABLE patient (
        id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        firstname VARCHAR(60),
        lastname VARCHAR(60),
        sexe CHAR(1) NOT NULL,
        birthday DATE,
        address VARCHAR(255),
        email VARCHAR(100),
        phone VARCHAR(50),
        country VARCHAR(100)
    )
    ENGINE=INNODB
    AUTO_INCREMENT=0;

-- INSERT data
LOCK TABLES patient WRITE;

INSERT INTO patient(id, firstname, lastname, sexe, birthday, address, email, phone, country)
VALUES
    ('1', 'test', 'testNone', 'F', '1966-12-31', '1 Brookside St', 'EmailTestNone', '100-222-3333', 'CountryTestNone'),
    ('2', 'test', 'testBorderline', 'M', '1945-06-24', '2 High St', 'EmailTestBorderline', '200-333-4444', 'CountryTestBorderline'),
    ('3', 'test', 'testInDanger', 'M', '2004-06-18', '3 Club Road', 'EmailTestInDanger', '300-444-5555', 'CountryTestInDanger'),
    ('4', 'test', 'testEarlyOnset', 'F', '2002-06-28', '4 Valley Dr', 'EmailTestEarlyOnset', '400-555-6666', 'CountryTestEarlyOnset');

UNLOCK TABLES;