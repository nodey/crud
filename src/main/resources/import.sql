CREATE TABLE departments(
                            department_id integer PRIMARY KEY,
                            department_name VARCHAR(45) NOT NULL,
                            department_description VARCHAR NOT NULL,
                            department_phone VARCHAR(13) NOT NULL,
                            department_date_of_formation VARCHAR(10) NOT NULL
);
CREATE TABLE employees(
                          employee_id integer PRIMARY KEY not null,
                          department_id integer ,
                          employee_name VARCHAR(45) NOT NULL,
                          employee_date_of_birth VARCHAR(10) NOT NULL,
                          employee_phone VARCHAR(13) NOT NULL,
                          employee_email VARCHAR NOT NULL,
                          employee_position VARCHAR NOT NULL,
                          employee_date_of_employment VARCHAR(10) not null
);

CREATE SEQUENCE hibernate_sequence START 1;