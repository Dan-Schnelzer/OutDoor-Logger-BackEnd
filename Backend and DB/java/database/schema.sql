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
        email varchar (50) UNIQUE NOT NULL,
        role  varchar (50) NOT NULL,
        CONSTRAINT pk_users PRIMARY KEY (user_id)
        );

       
CREATE TABLE scouting_report (
        scout_report_id  SERIAL NOT NULL,
        user_id   int NOT NULL,
        report_date DATE NULL,
        report_location  varchar(200)  NULL,
        images varchar(1000) NULL,
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
        
         INSERT INTO users (username,password_hash,role, email) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'notreal@email.com');
         INSERT INTO users (username,password_hash,role, email) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','email@fake.com');

        --  some fake DATAAAAAAAAAAAAAAAAA

        INSERT INTO fishing_log (user_id, log_date, log_location, log_description)  VALUES ('1','2022-12-23', 'somewhere in the ocean', 'caught 2 blue whales on a fly rod, I arm wrestled them, and then released them');  
         INSERT INTO fishing_log (user_id, log_date, log_location, log_description) VALUES ('1', '2021-01-22', 'in a creek', 'caught 88 bass and the biggest was 7 foot long');
         INSERT INTO fishing_log (user_id, log_date, log_location, log_description, images, bait, weather, fishing_trip) 
                VALUES ('1', '2022-04-11', 'Artic Sea', 'In a paddle boat with a bass rod I harpooned a walwruss', 'This would be Image URL here', 'seagulls', 'pretty stormy', 'No');

         INSERT INTO hunting_log (user_id, log_date, weather, log_description, hunting_type) VALUES ('1', '2022-01-17', 'rainy', 'shot a 67 point buck', 'cross bow');
          INSERT INTO hunting_log (user_id, log_date, weather, log_description, hunting_type) VALUES ('1', '2021-07-25', 'still rainy', 'shot a grizzly bear and a falcon', 'used a butter knife');
          INSERT INTO hunting_log (user_id, log_date, log_location, log_description, images, weather, hunting_type, hunting_trip) 
                VALUES ('1', '2022-04-18', 'Swissz Mountains', '2 Moose, 5 Geeze, 1 kangeroo', 'this would be images URL', 'Walkin on sunshine', 'paintball gun', 'Yes with the POTUS');

         INSERT INTO scouting_report (user_id, report_date, report_location, images, report_time, weather, scout_description)  VALUES ('1', '2021-06-18', 'hills of western PA', 'This would be image URLs', 'early morning', 'blizzard out', 'seen 2 yetis and a bigfoot playing basketball');
         INSERT INTO scouting_report (user_id, report_date, report_location, images, report_time, weather, scout_description)  VALUES ('1', '2022-08-19', 'paddys pub basement', 'This would be image URLs', 'midnight', 'probably cold out', 'charlie caught a lepruchan on a glue trap');

         INSERT INTO hiking_log (user_id, log_date, log_location, log_description, images, weather, log_state)   VALUES ('1', '2022-09-12', 'Rocky Mt high', 'Hiked 20 miles no problem, like 10 mins', 'This would be image URls', 'probably cold out', 'WW');
         INSERT INTO hiking_log (user_id, log_date, log_location, log_description, images, weather, log_state)   VALUES ('1', '2022-02-07', 'Mt St Helens', 'Took a volcano bath', 'This would be image URls', 'raining ash and rock', 'MN');

 COMMIT TRANSACTION;                 
                 
