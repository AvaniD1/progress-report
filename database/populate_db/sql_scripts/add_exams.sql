USE progress_report;

DELETE FROM student_exam_scores;
DELETE FROM exams;

INSERT INTO exams
(subject_id , year_group_id , exam_date , description , total_score)
SELECT 'COMPSCI' , 'UVI' , '2019-10-15 09:00:00' , 'MidTerm1 Test' , 45
UNION
SELECT 'COMPSCI' , 'UVI' , '2019-12-04 09:00:00' , 'EndTerm1 Test' , 75
UNION
SELECT 'COMPSCI' , 'UVI' , '2020-02-08 09:00:00' , 'MidTerm2 Test' , 60
UNION
SELECT 'COMPSCI' , 'UVI' , '2020-03-22 08:45:00' , 'EndTerm2 Test' , 80
UNION
SELECT 'COMPSCI' , 'UVI' , '2020-05-17 09:30:00' , 'EndOfYear Test' , 90
UNION
SELECT 'PHY' , 'LVI' , '2019-10-15 09:00:00' , 'MidTerm1 Test' , 50
UNION
SELECT 'PHY' , 'LVI' , '2019-12-04 09:00:00' , 'EndTerm1 Test' , 80
UNION
SELECT 'PHY' , 'LVI' , '2020-02-08 09:00:00' , 'MidTerm2 Test' , 60
UNION
SELECT 'PHY' , 'LVI' , '2020-03-22 08:45:00' , 'EndTerm2 Test' , 85
UNION
SELECT 'PHY' , 'LVI' , '2020-05-17 09:30:00' , 'EndOfYear Test' , 90
UNION
SELECT 'PHY' , 'LV' , '2018-10-17 09:30:00' , 'MidTerm1 Test' , 90
UNION
SELECT 'MAT' , 'LIV' , '2016-11-08 09:15:00' , 'MidTerm1 test' , 45
UNION
SELECT 'MAT' , 'LIV' , '2016-11-10 14:30:00' , 'EndTerm2 Test' , 70
UNION
SELECT 'ENGLIT' , 'UIII' , '2015-10-15 12:00:00' , 'MidTerm1 test' , 25
UNION
SELECT 'ENGLIT' , 'LIV' , '2016-11-05 8:30:00' , 'EndTerm2 test' , 45 