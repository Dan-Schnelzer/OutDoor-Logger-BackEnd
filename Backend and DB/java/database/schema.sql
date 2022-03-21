START TRANSACTION
-- DROP DATABASE IF EXISTS outdoor_logger;
DROP TABLE IF EXISTS hiking_log;
DROP TABLE IF EXISTS hunting_log;
DROP TABLE IF EXISTS fishing_log;
DROP TABLE IF EXISTS scouting_report;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
        user_id SERIAL NOT NULL,
        first_name  varchar(50)  NULL,
        last_name   varchar(50)  NULL,
        username  varchar(50) UNIQUE,
        password_hash varchar(250) NOT NULL,
        email varchar (50) UNIQUE NULL,
        role  varchar (50) NOT NULL,
        CONSTRAINT pk_users PRIMARY KEY (user_id)
        );

        INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
        INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
CREATE TABLE scouting_report (
        scout_report_id  SERIAL NOT NULL,
        user_id   int NOT NULL,
        report_date DATE NULL,
        report_location  varchar(200)  NULL,
        report_time    varchar(50) NULL,
        weather  varchar(100) NULL,
        scout_description  varchar(2000) NOT NULL,
        CONSTRAINT pk_scouting_report PRIMARY KEY (scout_report_id),
        CONSTRAINT fk_scouting_report_users FOREIGN KEY (user_id) REFERENCES users(user_id)
        );
CREATE TABLE fishing_log (
        fish_log_id SERIAL NOT NULL,
        user_id int NOT NULL,
        log_date  DATE NULL,
        log_location  varchar(100) NULL,
        log_description  varchar(700) NOT NULL,
        images  varchar(2500) NULL,
        bait   varchar (500) NULL,
        weather varchar (100) NULL,
        fishing_trip   varchar(200) NULL,
        CONSTRAINT pk_fishing_log PRIMARY KEY (fish_log_id),
        CONSTRAINT fk_fishing_log_users FOREIGN KEY (user_id) REFERENCES users(user_id)
        );
CREATE TABLE hunting_log (
        hunt_log_id  SERIAL NOT NULL,
        user_id int NOT NULL,
        log_date  DATE NULL,
        log_location  varchar(200) NULL,
        log_description varchar(700) NOT NULL,
        images varchar(2500) NULL,
        weather varchar(100) NULL,
        hunting_type  varchar(200) NULL,   
        hunting_trip  varchar(200) NULL,
        CONSTRAINT pk_hunting_log PRIMARY KEY (hunt_log_id),
        CONSTRAINT fk_hunting_log_users FOREIGN KEY (user_id) REFERENCES users(user_id)
        );
CREATE TABLE hiking_log (
        hiking_log_id SERIAL NOT NULL,
        user_id int NOT NULL,
        log_date DATE NULL,
        log_location varchar(200) NULL,
        log_description varchar (500) NOT NULL,
        images varchar(2500) NULL,
        weather varchar(50) NULL,
        log_state varchar (30) NOT NULL,
        CONSTRAINT pk_hiking_log PRIMARY KEY (hiking_log_id),
        CONSTRAINT fk_hiking_log_users FOREIGN KEY (user_id) REFERENCES users(user_id)
        );        
        
 COMMIT TRANSACTION;                 
                 
