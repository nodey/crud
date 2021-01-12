CREATE TABLE departments(
                            department_id BIGINT PRIMARY KEY,
                            department_name VARCHAR(45) NOT NULL,
                            department_description VARCHAR NOT NULL,
                            department_phone VARCHAR(13) NOT NULL,
                            department_date_of_formation DATE NOT NULL,
                            CONSTRAINT PK_DEPARTMENTID PRIMARY KEY (department_id)
);
CREATE TABLE employees(
                          employee_id BIGINT PRIMARY KEY,
                          department_id BIGINT,
                          employee_name VARCHAR(45) NOT NULL,
                          employee_phone VARCHAR(13) NOT NULL,
                          employee_email VARCHAR NOT NULL,
                          employee_position VARCHAR NOT NULL,
                          employee_date_of_employment DATE NOT NULL,
                          CONSTRAINT pk_EMPLOYEESK_ID PRIMARY KEY (employee_id),
                          CONSTRAINT fk_DEPARTMENTID FOREIGN KEY (department_id)
                              REFERENCES departments (department_id)
);

create sequence SEQ_USER
    minvalue 1
    start with 10
    increment by 1
    cache 5;