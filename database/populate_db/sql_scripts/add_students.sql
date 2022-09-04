USE progress_report;

DELETE FROM students;

INSERT INTO students
(username,first_name,last_name,address,email_address,password,current_year_group_id)
SELECT 'avanid','Avani','Dwivedi','Reading,UK','aashi.dwivedi@gmail.com',sha2('testreport123',256),'UVI' 
UNION
SELECT 'abbeyg','Abbey','Gems','Caversham,UK','abbey.gems@gmail.com',sha2('testreport345',256),'UVI' 
UNION
SELECT 'freyas','Freya','Shepphard','Sandelsham,UK','freya.shephard@gmail.com',sha2('testreport987',256),'UVI' 
UNION
SELECT 'emileyh','Emiley','Hollaway','Bracknell,UK','emiley.hollaway@gmail.com',sha2('xyx321',256),'UVI' 
UNION
SELECT 'samatha','Samatha','Davis','London,UK','samatha.davis@gmail.com',sha2('pqr236',256),'UVI'
UNION
SELECT 'student001','Test1','User1','Reading,UK','test1.user1@gmail.com',sha2('testreport123',256),'UVI' 
UNION
SELECT 'student002','Test2','User2','Reading,UK','test2.user2@gmail.com',sha2('testreport123',256),'UVI' 
UNION
SELECT 'student003','Test3','User3','Reading,UK','test3.user3@gmail.com',sha2('testreport123',256),'LVI' 
UNION
SELECT 'student004','Test4','User4','Reading,UK','test4.user4@gmail.com',sha2('testreport123',256),'LVI' 
UNION
SELECT 'student005','Test5','User5','Reading,UK','test5.user5@gmail.com',sha2('testreport123',256),'LVI' 
UNION
SELECT 'student006','Test6','User6','Reading,UK','test6.user6@gmail.com',sha2('testreport123',256),'LVI' 
UNION
SELECT 'student007','Test7','User7','Reading,UK','test7.user7@gmail.com',sha2('testreport123',256),'LVI' 
UNION
SELECT 'student008','Test8','User8','Reading,UK','test8.user8@gmail.com',sha2('testreport123',256),'UV' 
UNION
SELECT 'student009','Test9','User9','Reading,UK','test9.user9@gmail.com',sha2('testreport123',256),'UV' 
UNION
SELECT 'student010','Test10','User10','Reading,UK','test10.user10@gmail.com',sha2('testreport123',256),'UV' 
UNION
SELECT 'student011','Test11','User11','Reading,UK','test11.user11@gmail.com',sha2('testreport123',256),'UV'
UNION
SELECT 'student012','Test12','User12','Reading,UK','test12.user12@gmail.com',sha2('testreport123',256),'UV'
UNION
SELECT 'student013','Test13','User13','Reading,UK','test13.user13@gmail.com',sha2('testreport123',256),'UIV' 
UNION
SELECT 'student014','Test14','User14','Reading,UK','test14.user14@gmail.com',sha2('testreport123',256),'UIV' 
UNION
SELECT 'student015','Test15','User15','Reading,UK','test15.user15@gmail.com',sha2('testreport123',256),'UIV' 
UNION
SELECT 'student016','Test16','User16','Reading,UK','test16.user16@gmail.com',sha2('testreport123',256),'LIV'
UNION
SELECT 'student017','Test17','User17','Reading,UK','test17.user17@gmail.com',sha2('testreport123',256),'LIV'
UNION
SELECT 'student018','Test18','User18','Reading,UK','test18.user18@gmail.com',sha2('testreport123',256),'LIV'
UNION
SELECT 'student019','Test17','User19','Reading,UK','test19.user19@gmail.com',sha2('testreport123',256),'LIV'
UNION
SELECT 'student020','Test20','User20','Reading,UK','test20.user20@gmail.com',sha2('testreport123',256),'LIV'