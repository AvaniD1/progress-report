CREATE DATABASE IF NOT EXISTS progress_report;

USE progress_report;

DROP TABLE IF EXISTS student_exam_scores;
DROP TABLE IF EXISTS exams;
DROP TABLE IF EXISTS student_subjects;
DROP TABLE IF EXISTS subjects;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS year_groups;

CREATE TABLE year_groups (
  year_group_id VARCHAR(10)  NOT NULL,
  display_name VARCHAR(45) NOT NULL,
  description VARCHAR(100) NULL,
  PRIMARY KEY (year_group_id));

CREATE TABLE students (
  username varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  address varchar(100) NOT NULL,
  email_address varchar(45) NOT NULL,
  password varbinary(100) NOT NULL,
  current_year_group_id  VARCHAR(10)  NOT NULL,
  PRIMARY KEY (username),
  UNIQUE KEY email_address_UNIQUE (email_address),
  FOREIGN KEY (current_year_group_id) REFERENCES year_groups(year_group_id)
) ;

CREATE TABLE teachers (
  username varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  address varchar(100) NOT NULL,
  email_address varchar(45) NOT NULL,
  password varbinary(100) NOT NULL,
  PRIMARY KEY (username),
  UNIQUE KEY email_address_UNIQUE (email_address)
) ;

CREATE TABLE subjects (
  subject_id VARCHAR(20)  NOT NULL,
  display_name VARCHAR(45) NOT NULL,
  description VARCHAR(100) NULL,
  PRIMARY KEY (subject_id));
  
  CREATE TABLE student_subjects (
  student_id VARCHAR(45)  NOT NULL,
  subject_id VARCHAR(20) NOT NULL,
  year_group_id VARCHAR(10) NOT NULL,
  enrolment_date DATETIME NOT NULL,
  PRIMARY KEY (student_id,subject_id,year_group_id),
  FOREIGN KEY (student_id) REFERENCES students(username),
  FOREIGN KEY (subject_id) REFERENCES subjects(subject_id),
  FOREIGN KEY (year_group_id) REFERENCES year_groups(year_group_id)
  );

  CREATE TABLE exams (
  exam_id INT  NOT NULL AUTO_INCREMENT,
  subject_id VARCHAR(20) NOT NULL,
  year_group_id VARCHAR(10) NOT NULL,
  exam_date DATETIME NOT NULL,
  description VARCHAR(50) NULL,
  total_score INT NOT NULL,
  PRIMARY KEY (exam_id),
  FOREIGN KEY (subject_id) REFERENCES subjects(subject_id),
  FOREIGN KEY (year_group_id) REFERENCES year_groups(year_group_id),
  UNIQUE KEY subject_year_group_UNIQUE (subject_id,year_group_id,exam_date)
  );
  
  CREATE TABLE student_exam_scores (
  exam_score_id INT  NOT NULL AUTO_INCREMENT,
  exam_id INT NOT NULL,
  student_id VARCHAR(10) NOT NULL,
  student_score INT NOT NULL,
  PRIMARY KEY (exam_score_id),
  FOREIGN KEY (exam_id) REFERENCES exams(exam_id),
  FOREIGN KEY (student_id) REFERENCES students(username),
  UNIQUE KEY exam_student_id_UNIQUE (exam_id,student_id)
  );
