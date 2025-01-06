CREATE TABLE USERS (
    id SERIAL PRIMARY KEY,
    login varchar(255),
    password varchar(255)
);

CREATE TABLE Chatroom (
    id SERIAL PRIMARY KEY,
    name varchar(255),
    owner int, 
    FOREIGN KEY (owner) REFERENCES USERS(id) 
);

CREATE TABLE Message (
    message_id SERIAL PRIMARY KEY,
    message_auther INT,
    message_room INT,
    message_text TEXT,
    message_time TIMESTAMP default NOW(),
    FOREIGN KEY (message_auther) REFERENCES USERS(id),
    FOREIGN KEY (message_room) REFERENCES Chatroom(id)
);

CREATE TABLE User_Chatroom (
    user_id INT,
    Chatroom_id INT,
    PRIMARY KEY (user_id, Chatroom_id),
    FOREIGN KEY (user_id) REFERENCES USERS(id),
    FOREIGN KEY (Chatroom_id) REFERENCES Chatroom(id)
)