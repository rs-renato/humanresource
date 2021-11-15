DROP SCHEMA IF EXISTS humanresource;
CREATE SCHEMA humanresource COLLATE = utf8_general_ci;
USE humanresource;

/* *************************************************************** 
***************************CREATING TABLES************************
**************************************************************** */
CREATE TABLE REGIONS (
                         region_id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT,
                         region_name VARCHAR(25),
                         PRIMARY KEY (region_id)
);

CREATE TABLE COUNTRIES (
                           country_id CHAR(2) NOT NULL,
                           country_name VARCHAR(40),
                           region_id INT (11) UNSIGNED NOT NULL,
                           PRIMARY KEY (country_id),
                           CONSTRAINT countries_regions_region_id FOREIGN KEY (region_id) REFERENCES REGIONS(region_id)
);

CREATE TABLE LOCATIONS (
                           location_id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT,
                           street_address VARCHAR(40),
                           postal_code VARCHAR(12),
                           city VARCHAR(30) NOT NULL,
                           state_province VARCHAR(25),
                           country_id CHAR(2) NOT NULL,
                           PRIMARY KEY (location_id),
                           CONSTRAINT locations_countries_country_id FOREIGN KEY (country_id) REFERENCES COUNTRIES(country_id)
);

CREATE TABLE DEPARTMENTS (
                             department_id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT,
                             department_name VARCHAR(30) NOT NULL,
                             manager_id INT (11) UNSIGNED,
                             location_id INT (11) UNSIGNED,
                             PRIMARY KEY (department_id),
                             CONSTRAINT departments_locations_location_id FOREIGN KEY (location_id) REFERENCES LOCATIONS(location_id)
);

CREATE TABLE JOBS (
                      job_id VARCHAR(10) NOT NULL,
                      job_title VARCHAR(35) NOT NULL,
                      min_salary DECIMAL(8, 0) UNSIGNED,
                      max_salary DECIMAL(8, 0) UNSIGNED,
                      PRIMARY KEY (job_id)
);

CREATE TABLE EMPLOYEES (
                           employee_id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT,
                           first_name VARCHAR(20),
                           last_name VARCHAR(25) NOT NULL,
                           email VARCHAR(25) NOT NULL,
                           phone_number VARCHAR(20),
                           hire_date DATE NOT NULL,
                           job_id VARCHAR(10) NOT NULL,
                           salary DECIMAL(8, 2) NOT NULL,
                           commission_pct DECIMAL(2, 2),
                           manager_id INT (11) UNSIGNED,
                           department_id INT (11) UNSIGNED,
                           PRIMARY KEY (employee_id),
                           CONSTRAINT employees_jobs_job_id FOREIGN KEY (job_id) REFERENCES JOBS(job_id),
                           CONSTRAINT employees_departments_department_id FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(department_id),
                           CONSTRAINT employees_employees_employee_id FOREIGN KEY (manager_id) REFERENCES EMPLOYEES(employee_id)
);

ALTER TABLE DEPARTMENTS ADD FOREIGN KEY (manager_id) REFERENCES EMPLOYEES (employee_id);

CREATE TABLE JOB_HISTORY (
                             employee_id INT (11) UNSIGNED NOT NULL,
                             start_date DATE NOT NULL,
                             end_date DATE NOT NULL,
                             job_id VARCHAR(10) NOT NULL,
                             department_id INT (11) UNSIGNED NOT NULL,
                             CONSTRAINT job_history_employees_employee_id FOREIGN KEY (employee_id) REFERENCES EMPLOYEES(employee_id),
                             CONSTRAINT job_history_jobs_job_id FOREIGN KEY (job_id) REFERENCES JOBS(job_id),
                             CONSTRAINT job_history_departments_department_id FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(department_id)
);

ALTER TABLE JOB_HISTORY ADD UNIQUE INDEX (
                                          employee_id,
                                          start_date
    );

CREATE VIEW EMP_DETAILS_VIEW
AS
SELECT e.employee_id,
       e.job_id,
       e.manager_id,
       e.department_id,
       d.location_id,
       l.country_id,
       e.first_name,
       e.last_name,
       e.salary,
       e.commission_pct,
       d.department_name,
       j.job_title,
       l.city,
       l.state_province,
       c.country_name,
       r.region_name
FROM EMPLOYEES e,
     DEPARTMENTS d,
     JOBS j,
     LOCATIONS l,
     COUNTRIES c,
     REGIONS r
WHERE e.department_id = d.department_id
  AND d.location_id = l.location_id
  AND l.country_id = c.country_id
  AND c.region_id = r.region_id
  AND j.job_id = e.job_id;

COMMIT;