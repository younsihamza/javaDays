
INSERT INTO USERS (login, password)
VALUES 
('hamza', '123123'),
('hyounsi', '123123'),
('ayman', '123123'),
('rayan', '123123'),
('yahya', '123123');

INSERT INTO Chatroom (name , owner)
VALUES
('course', 1),
('home', 2),
('school', 3),
('java', 1),
('python', 4);

INSERT INTO Message (message_auther, message_room, message_text)
VALUES 
(1,1, 'hello BROTHER '),
(5,1, 'hello BROTHER '),
(3,1, 'hello BROTHER '),
(4,1, 'hello BROTHER '),
(2,1, 'hello BROTHER ');


INSERT INTO User_Chatroom (user_id, Chatroom_id)
VALUES
(1,2),
(2,2),
(3,2),
(4,2),
(2,1);