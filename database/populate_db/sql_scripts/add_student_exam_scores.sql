USE progress_report;

DELETE FROM student_exam_scores;

-- The query below creates randomly generated exam scores for all the students
-- who have neen enrolled in any subject as per student_subject table. 
-- It does that by making and INNER JOIN between student_subjects table and exams table.
-- Refer here for INNER JOIN https://www.w3schools.com/sql/sql_join_inner.asp
-- INNER JOIN is created on subject_id and year_group_id i.e. all the subjects and year group
-- combinations stored in exams table are joined with students present in students_subjects
-- table for the same year group and subject combination. That way we first get all possible 
-- combinations of exams for all subjects in all year groups for all students in student_subjects table
-- For calculating students scores we randomly generate a number between a pre selectd min_score
-- and max score for that exam from exams table
SET @min_score_as_percentage = 0.35; 
SET @max_score_as_percentage = 0.95; 
INSERT INTO student_exam_scores(exam_id,student_id,student_score)
SELECT exam_id, student_id , 
FLOOR(RAND()*(@max_score_as_percentage*total_score - @min_score_as_percentage*total_score+1)) + FLOOR(@min_score_as_percentage*total_score)
FROM student_subjects ss
INNER JOIN exams e ON 
ss.subject_id = e.subject_id AND ss.year_group_id = e.year_group_id