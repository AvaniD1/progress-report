USE progress_report;

DELETE FROM teachers;

INSERT INTO teachers
(username,first_name,last_name,address,email_address,password)
SELECT 'teacher001','Teacher1','Surname1','Reading,UK','teacher1.surname1@gmail.com',sha2('testreport321',256)
UNION
SELECT 'teacher002','Teacher2','Surname2','Reading,UK','teacher2.surname2@gmail.com',sha2('testreport321',256)
UNION
SELECT 'teacher003','Teacher3','Surname3','Reading,UK','teacher3.surname3@gmail.com',sha2('testreport321',256)
UNION
SELECT 'teacher004','Teacher4','Surname4','Reading,UK','teacher4.surname4@gmail.com',sha2('testreport321',256)
UNION
SELECT 'teacher005','Teacher5','Surname5','Reading,UK','teacher5.surname5@gmail.com',sha2('testreport321',256)
