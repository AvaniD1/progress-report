-- Login
-- Get password for student
SET @username='student001';
SELECT password FROM students where username = @username;

-- Get password for teacher
SET @username='teacher001';
SELECT password FROM teachers where username = @username;

-- Select all Year Groups
-- This is used when a teacher is logged in as teachers can see all year groups
SELECT year_group_id , display_name , description from year_groups;

-- Select Year Groups for a student
-- This is used when a student is logged in. 
-- Students can only select subjects from their current or past year groups 
SET @studentId='student001';
SELECT yg.year_group_id , display_name , description 
FROM year_groups yg 
INNER JOIN student_subjects ss
ON yg.year_group_id = ss.year_group_id 
WHERE student_id = @studentId;

-- Select Students for a year Group
SET @yearGroupId='UVI';
SELECT username AS student_id, first_name, last_name FROM students
WHERE current_year_group_id = @yearGroupId;

-- Select Subjects for a year group for a student
SET @studentId='student001';
SET @yearGroupId='UVI';
SELECT s.subject_id, s.display_name, s.description FROM student_subjects ss
INNER JOIN subjects s
ON s.subject_id = ss.subject_id
WHERE ss.year_group_id = @yearGroupId AND ss.student_id = @studentId;

-- Following queries for populating 'Student Absolute scores' and 'Progess report graphs'
-- for a given student, year group and subject

-- Query A
-- Select all exams for selected year group for a selected subject
-- each row includes selected year group's averge score and max score for selected subject
-- resultset is orderd by exam date i.e. latest exam at top
SET @yearGroupId='LVI';
SET @subjectId='PHY';
SELECT e.exam_id, e.exam_date , e.description, e.total_score,
FLOOR(AVG(ses.student_score)) AS average_score, MAX(ses.student_score) maximum_score
FROM student_exam_scores ses
INNER JOIN exams e
ON e.exam_id = ses.exam_id
WHERE e.subject_id = @subjectId AND e.year_group_id = @yearGroupId
GROUP BY e.exam_id, e.exam_date , e.description, e.total_score
ORDER BY e.exam_date ASC;

-- Query B
-- for each exam in resultset of Query A, find the score of the selected student
SET @examId=8;
SET @studentId='student003';
SELECT exam_id, student_id, student_score FROM student_exam_scores
WHERE exam_id IN(8,9,10,11,12) and student_id = @studentId; 

-- Query C
-- for each exam in resultset of Query A, find the score of the selected student
-- Get all students scores for a given exam
-- This will be used to calculate student's percentile and predict next score.
-- From the above query for getting one student's score, when we get
-- list of exams with students score in each of that exam, then for 
-- each exam in the returned list in above query, following query will be made
-- to get all the scores of all students who took that exam
SET @examId=9;
SELECT student_id, student_score FROM student_exam_scores
WHERE exam_id = @examId ORDER BY student_score ASC; 




