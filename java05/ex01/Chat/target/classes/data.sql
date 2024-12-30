INSERT INTO Users( User_login, User_password)
VALUES
('hyounsi', '123456'),
('hamza', '123456'),
('ayman', '123456'),
('yahya', '123456'),
('rayan', '123456');

INSERT INTO Chatroom (Chatroom_name, Chatroom_owner)
VALUES
('school', 1),
('home', 2),
('chill', 1),
('workout', 2),
('rolation', 1);

INSERT INTO Message (Message_author, Message_room, Message_text)
VALUES
(1, 2, 'can we go outside'),
(2, 2, 'ok lets go brother'),
(1, 2, 'can we go outside'),
(1, 2, 'can we go outside'),
(1, 2, 'can we go outside');

INSERT INTO User_Chatroom (User_id, Chatroom_id) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 4);