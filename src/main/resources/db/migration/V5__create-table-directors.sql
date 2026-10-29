CREATE TABLE directors (

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    businessPhone VARCHAR(20) NOT NULL,
    mobilePhone VARCHAR(20) NOT NULL,
    professionalRegistration VARCHAR(9) NOT NULL UNIQUE,
    registration VARCHAR(6) NOT NULL UNIQUE,
    position VARCHAR(100) NOT NULL,
    appointmentDate VARCHAR(20) NOT NULL,
    termEndDate VARCHAR(20) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    motherName VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL,
    country VARCHAR(100) NOT NULL,
    postalCode VARCHAR(9) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(100),

    PRIMARY KEY (id)

);