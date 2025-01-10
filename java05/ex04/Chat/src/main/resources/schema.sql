CREATE TABLE Users (
    User_id SERIAL PRIMARY KEY ,
    User_login varchar(255),
    User_password varchar(255)
);

CREATE TABLE Chatroom (
    Chatroom_id SERIAL primary key,
    Chatroom_name varchar(255),
    Chatroom_owner int,
    FOREIGN KEY (Chatroom_owner) REFERENCES Users(User_id)
);

CREATE TABLE Message (
    Message_id SERIAL primary key,
    Message_author int, 
    Message_room int, 
    Message_text varchar(255),
    Message_time TIMESTAMP  default NOW(),
    FOREIGN KEY (Message_room) REFERENCES Chatroom(Chatroom_id),
    FOREIGN KEY (Message_author) REFERENCES Users(User_id)
);

CREATE TABLE User_Chatroom (
    User_id int,
    Chatroom_id int,
    PRIMARY KEY (user_id, Chatroom_id),
    FOREIGN KEY (User_id) REFERENCES Users(User_id),
    FOREIGN KEY (Chatroom_id) REFERENCES Chatroom(Chatroom_id)
);