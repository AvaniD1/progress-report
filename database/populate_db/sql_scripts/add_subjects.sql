USE progress_report;

DELETE FROM subjects;

INSERT INTO subjects
(subject_id, display_name, description)
SELECT 'PHY' , 'Physics', 'a science relating to matter and energy'
UNION
SELECT 'MAT' , 'Mathematics' , 'science of number quantities and shapes'
UNION
SELECT 'COMPSCI' , 'Computer Science' , 'study of the principle and use of computers'
UNION
SELECT 'FM' , 'Further Mathematics' , 'advanced mathematics'
UNION
SELECT 'ENGLIT' , 'English Literature' , 'study of texts in the english language'
UNION
SELECT 'ENGLANG' , 'English Language' , 'study of linguistics'


