USE progress_report;

DELETE FROM exams;
DELETE FROM students;
DELETE FROM year_groups;

INSERT INTO year_groups
(year_group_id, display_name,description)
SELECT 'UIII' , 'Upper Three', 'Class containing students in upper three i.e. Year 7'
UNION
SELECT 'LIV' , 'Lower Four', 'Class containing students in Lower Four i.e. Year 8'
UNION
SELECT 'UIV' , 'Upper Four', 'Class containing students in Upper Four i.e. Year 9'
UNION
SELECT 'LV' , 'Upper Five','Class containing students in Lower Five i.e. Year 10'
UNION
SELECT 'UV' , 'Lower Five', 'Class containing students in Upper Five i.e. Year 11'
UNION
SELECT 'LVI' , 'Lower Six', 'Class containing students in Lower Six i.e. Year 12'
UNION
SELECT 'UVI' , 'Upper Six', 'Class containing students in Upper Six i.e. Year 13'
