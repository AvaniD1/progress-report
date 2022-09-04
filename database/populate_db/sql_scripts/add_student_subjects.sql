USE progress_report;

DELETE FROM student_subjects;

-- This is generating all possible combinations of students and subjects using CROSS JOIN
-- refer here for CROSS JOIN https://www.w3resource.com/sql/joins/cross-join.php
-- This is just to generate some test data
-- In final application this will be inserted based on actual subjects that students enrol to. 
-- In the initial implementation we are only showing scores for only current year of all students
-- so enrolment date is not important but once we implement selecting reports for previous year 
-- groups then enrolment date will be important as then we have to use enrolment date and 
-- year group to first find all students for that year group in a specific acedamic year and
-- then list all subjects for selected year group, student for same specific acedamic year 
INSERT INTO  student_subjects(student_id,subject_id,year_group_id,enrolment_date)
SELECT username, subject_id, current_year_group_id , '2019-09-05 09:00:00'  
FROM students CROSS JOIN subjects

