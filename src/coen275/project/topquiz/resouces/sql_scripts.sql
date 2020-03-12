create database topquiz;
use topquiz;
/*QAset and QuestionBank population 

/*QAset table 
/*drop table questions;*/
create table questions
(
Id int,
QuestionNumber int,
Question varchar(100),
AnswerChoice1 varchar(20),
AnswerChoice2 varchar(20),
AnswerChoice3 varchar(20),
AnswerChoice4 varchar(20),
CorrectAnswer varchar(20),
points int, 
QuestionType varchar(20),
ImageFile blob,
PRIMARY KEY(Id)
);

insert into questions(Id, QuestionNumber, Question, 
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (1,1,'What force from the Sun pulls on the Earth and keeps it in orbit?','Gravity', 
'Friction','Balance','Inertia','Gravity',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (2,2,'Which two are about the same size?','Earth and Mercury', 
'Earth and Venus','Venus and Mars','Venus and Jupiter','Earth and Venus',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (3,3, 'When a Full Moon causes the ocean to rise, what force is at work?',
'Magnetic', 
'Gravity','Drag','Friction','Gravity',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (4,4, 'Shooting stars are actually what?',
'Comets', 
'Stars','Meteors','Satelites','Meteors',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (5,5, 'What do we call the Sun and all the space objects in orbit around it?',
'The Galaxy', 
'The universe','The solar system','Milky Way','The solar system',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (6,6,'How long does it take Earth to rotate once on its axis?',
'24 Hours', 
'A month','A year','6 months','24 Hours',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (7,7, 'Name the planet closest to the Sun.',
'Earth', 
'Mars','Venus','Mercury','Mercury',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (8,8,  'What object orbiting the Sun used to be considered one of our planets?',
'Venus', 
'Neptune','Pluto','Mercury','Pluto',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
CorrectAnswer,points, QuestionType)
values (9,9,  'Does the Earth rotate in an Eastward or Westward direction?',
'Eastward',3,'FillInTheBlanks');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (10,10, 'How many colors are in the visible spectrum of white light?',
'Seven', 
'Eight','Nine','Six','Seven',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2,CorrectAnswer,points, QuestionType)
values (11,11,  'Oceans cover about three-fourths of the Earth\'s surface.  True or false?',
'True', 
'False','True',3,'T/F');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2,CorrectAnswer,points, QuestionType)
values (12,12,  'At midnight the water in an ocean stops moving.  True or false',
'True', 
'False','False',3,'T/F');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (13,13,  'What is the word for melted rock deep inside the earth?',
'Cement', 
'Clay','Magma','Pumice','Magma',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (14,14,  'About how long does it take the Moon to circle the Earth?',
'About a year', 
'About 28 days','About a day','About 6 day','About 28 day',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, CorrectAnswer,points, QuestionType)
values (15,15,  'Light can travel through all matter.  True or false?',
'True', 
'False','False',3,'T/F');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (16,16,  'What do we call deep holes in the moon?',
'Craters', 
'Boulders','Black Hole','Pits','Craters',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (17,17, 'What force from the Sun pulls on the earth and keeps it in orbit?',
'Drag', 
'Lever','Magnetic','Gravity','Gravity',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (18,18,  'What do we call man-made objects that orbit Earth and photograph the weather?',
'Shuttles', 
'Space Stations','Labs','Weather satellites','Weather satellites',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (19,19, 'What is a meteor called when it falls to Earth?',
'Shooting Star', 
'A meteorite','A comet','A shower','A meteorite',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (20,20,'Our galaxy is known as what?',
'Gems', 
'Kit Kat','Mars','Milky Way','Milky Way',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, CorrectAnswer,points, QuestionType)
values (21,21,  'Light can travel through all matter.  True or false?',
'True', 
'False','False',3,'T/F');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (22,22,  'What do we call deep holes in the moon?',
'Craters', 
'Boulders','Black Hole','Pits','Craters',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (23,23, 'What force from the Sun pulls on the earth and keeps it in orbit?',
'Drag', 
'Lever','Magnetic','Gravity','Gravity',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (24,24,  'What do we call man-made objects that orbit Earth and photograph the weather?',
'Shuttles', 
'Space Stations','Labs','Weather satellites','Weather satellites',3,'MCQ');

insert into questions(Id, QuestionNumber, Question,
AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, CorrectAnswer,points, QuestionType)
values (25,25, 'What is a meteor called when it falls to Earth?',
'Shooting Star', 
'A meteorite','A comet','A shower','A meteorite',3,'MCQ');
select * from topquiz.questions;
/*QuestionBank table */

create table topquiz.QuestionBank
(
ID int,
QuestionBankName varchar(20),
DifficultyLevel varchar(20),
Category varchar(20),
PRIMARY KEY(Id)
)

insert into QuestionBank(ID, QuestionBankName, DifficultyLevel, Category) 
values(1,'questionbank1','easy','sapce');
insert into QuestionBank(ID, QuestionBankName, DifficultyLevel, Category) 
values(2,'questionbank2','medium','sapce');
insert into QuestionBank(ID, QuestionBankName, DifficultyLevel, Category) 
values(3,'questionbank3','hard','sapce');
insert into QuestionBank(ID, QuestionBankName, DifficultyLevel, Category) 
values(4,'questionbank1','easy','water');
insert into QuestionBank(ID, QuestionBankName, DifficultyLevel, Category) 
values(5,'questionbank2','easy','water');
insert into QuestionBank(ID, QuestionBankName, DifficultyLevel, Category) 
values(6,'questionbank3','easy','water');

/*drop Table QA_QB;*/
create table QA_QB
(
ID int, 
QuestionBankId int, 
QAsetId int,
PRIMARY KEY(ID)
);

insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(51,4,1);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(52,4,2);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(53,4,3);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(54,4,4);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(55,4,5);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(56,4,6);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(57,4,7);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(58,4,8);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(59,4,9);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(60,4,10);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(61,4,11);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(62,4,12);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(63,4,13);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(64,4,14);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(65,4,15);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(66,4,16);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(67,4,17);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(68,4,18);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(69,4,19);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(70,4,20);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(71,4,21);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(72,4,22);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(73,4,23);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(74,4,24);
insert into QA_QB(ID, QuestionBankId, QAsetId) 
values(75,4,25);

create table Questionbanks as (
select a.id, a.QuestionBankName, a.difficultyLevel, a.category, b.qasetid 
from 
topquiz.questionbank as a
inner join 
topquiz.QA_QB as b
on a.id=b.QuestionBankId)

select count(*) from Questionbanks;
drop table Questionbank;
create table Questionbank as (
select * from Questionbanks)

