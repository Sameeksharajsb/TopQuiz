/*creating users, quiz and related tables */
create table topquiz.users
(
Id int,
Username varchar(50),
isAdmin tinyint,
PRIMARY KEY(Id)
);
/*drop table topquiz.users;*/

insert into users(Id, Username, isAdmin) values(1,'Sam',1);
insert into users(Id, Username, isAdmin) values(2,'Nithya',1);
insert into users(Id, Username, isAdmin) values(3,'Teeny',0);
insert into users(Id, Username, isAdmin) values(4,'Rachel',0);
insert into users(Id, Username, isAdmin) values(5,'Chase',0);
insert into users(Id, Username, isAdmin) values(6,'Will',0);
insert into users(Id, Username, isAdmin) values(7,'Roger',0);
insert into users(Id, Username, isAdmin) values(8,'Willy',0);

select * from topquiz.users;
/*drop table topquiz.Quiz*/

create table topquiz.Quiz
(
Id int,
QuizName varchar(20),
time_limit int,
quizScore int,
attempts_allowed int,
PRIMARY KEY(Id)
);
insert into Quiz(Id, QuizName, time_limit, quizScore,attempts_allowed) 
values(1,'SpaceQuiz',25,75,3);
insert into Quiz(Id, QuizName, time_limit, quizScore,attempts_allowed) 
values(2,'WaterQuiz',25,75,3);

create table topquiz.Quiz_QB
(
Id int,
quizId int,
QuestionBankId int,
PRIMARY KEY(Id)
);

insert into Quiz_QB(Id, quizId, QuestionBankId) 
values(1,1,1);
insert into Quiz_QB(Id, quizId, QuestionBankId) 
values(2,1,2);
insert into Quiz_QB(Id, quizId, QuestionBankId) 
values(3,1,3);
insert into Quiz_QB(Id, quizId, QuestionBankId) 
values(4,2,1);
insert into Quiz_QB(Id, quizId, QuestionBankId) 
values(5,2,2);
insert into Quiz_QB(Id, quizId, QuestionBankId) 
values(6,2,3);

/* join the above two tables to create my new quiz table */
create table Quizes as
(select a.id, a.quizname, a.time_limit, a.quizscore, a.attempts_allowed, b.QuestionBankId
from 
topquiz.quiz as a
inner join 
topquiz.quiz_qb as b
on a.id=b.quizid)

drop table Quiz;
create table quiz as (
select * from Quizes)
select count(*) from Quiz;
select * from Quiz;

create table topquiz.Quiz_User
(
Id int,
Quiz_Id int,
User_id int,
attemptNumber int, 
AttemptScore int, 
Total_correct int, 
Total_Wrong int, 
Total_NA int, 
User_score int,
PRIMARY KEY(Id)
);


insert into Quiz_User(Id, Quiz_Id, User_id,attemptNumber,AttemptScore,Total_correct,Total_Wrong,Total_NA,User_score) 
values(1,1,3,1,75,20,2,3,60);
insert into Quiz_User(Id, Quiz_Id, User_id,attemptNumber,AttemptScore,Total_correct,Total_Wrong,Total_NA,User_score) 
values(2,1,3,2,75,15,5,5,45);
insert into Quiz_User(Id, Quiz_Id, User_id,attemptNumber,AttemptScore,Total_correct,Total_Wrong,Total_NA,User_score) 
values(3,1,4,1,75,20,2,3,60);

