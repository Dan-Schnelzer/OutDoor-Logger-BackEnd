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
        log_description  varchar(2000) NOT NULL,
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
        log_description varchar(2000) NOT NULL,
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
        log_description varchar (2000) NOT NULL,
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
            INSERT INTO fishing_log (user_id, log_date, log_location, log_description, images, bait, weather, fishing_trip) VALUES ('1', '2022-04-11', 'A place that has as close to 100 characters as possible because that would be pretty silly, max it!!', 
            'I am really interested in maxing out a 700 character varchar.  I am going to write a fairly substantial report about fish tacos.  Now, I have never had a fish taco.  I do not know why but I can never bring myself to eat one.  I love fish, I love tacos, but the idea 
            of a fish taco just does not sound appealing to me, even though Im almost positive I would love it.  I also cant help but wonder what type of fish is being used in the fish taco and nobody ever seems to say they are using cod, or bass, or tuna, or mahi mahi, or squid, or snail.
              I mean, Id probably like it regardless', 'This would be Image URL here', ' There is a high likelihood that my favorite bait is the one used by all the masters,
               some call it the master bait, but it is colloquially known as a worm.  The worm bait tends to be incredibly effective on the big mouthed ones, the one we call bass.  So for this trip I used a fake worm guy, sometimes known as a fake plastic lure, and i was jigging that rod with all my might trying to get some action on the line.  used that lure the whole time. ', 
               'Weather has a total of 100 varchars. I am not too sure how many it needs, but this is all I can put.', 'This was indeed a 200 varchar fishing trip.  It included my cousin, his wife, kids, and Billy Bob Thornton.  The trip was designed around a primitive site in Siberia using reindeer for transportation.');

         INSERT INTO hunting_log (user_id, log_date, weather, log_description, hunting_type) VALUES ('1', '2022-01-17', 'rainy', 'shot a 67 point buck', 'cross bow');
          INSERT INTO hunting_log (user_id, log_date, weather, log_description, hunting_type) VALUES ('1', '2021-07-25', 'still rainy', 'shot a grizzly bear and a falcon', 'used a butter knife');
          INSERT INTO hunting_log (user_id, log_date, log_location, log_description, images, weather, hunting_type, hunting_trip) 
                VALUES ('1', '2022-04-18', 'Swissz Mountains', '2 Moose, 5 Geeze, 1 kangeroo', 'this would be images URL', 'Walkin on sunshine', 'paintball gun', 'Yes with the POTUS');
         INSERT INTO hunting_log (user_id, log_date, log_location, log_description, images, weather, hunting_type, hunting_trip) VALUES ('1', '2022-04-18', 'The location for this hunting trip was 200.  Northwestern Scandinavia in a little town on the outskirts of Tägsjöberg, 2.1 miles from the road east by northeast.', 
         'This description includes 700 characters to really set the mood.  It was a cool and crisp morning, a light dusting of snow on the ground with a light breeze making the snow dance as if the fairies of the forest wanted to hide all the tracks on me.  I was well prepared with warm enough gear, camo, 8932 rounds to fill my Remington 870,
          Winchester Model 1894, and several small firearms I was carrying with me on this trip.  The hunting knife strapped around my waist was ready to carve into snow Yeti and bring home the bacon.  I carried several pounds of gear to set up in a tree and wait.  It took 40 days and 40 nights but I finally got the sucker.  Best trip in my life.', 'this would be images URL',
           'The weather once again can hold up to 100 varchar.  This weather was mostly done in the description.', 'The hunting type depends on 200 varchar to create.  I am thinking this hunting type is a stand in the woods and full on camping trip until I find them.  You may call it hardcore, I call it a good day.', 'Essentially, this takes all 200 varchar.  
           It is a hunting trip taking up all the space to tell you that Darth Vader was horrible company as he just wanted to force everything.');


         INSERT INTO scouting_report (user_id, report_date, report_location, images, report_time, weather, scout_description)  VALUES ('1', '2021-06-18', 'hills of western PA', 'This would be image URLs', 'early morning', 'blizzard out', 'seen 2 yetis and a bigfoot playing basketball');
         INSERT INTO scouting_report (user_id, report_date, report_location, images, report_time, weather, scout_description)  VALUES ('1', '2022-08-19', 'paddys pub basement', 'This would be image URLs', 'midnight', 'probably cold out', 'charlie caught a lepruchan on a glue trap');
           INSERT INTO scouting_report (user_id, report_date, report_location, images, report_time, weather, scout_description)  VALUES ('1', '2022-08-19', 'I am scouting out Chad Africa.  This is a real place and when I have more than 200 varchar to do so, I will tell you all about Chad.  But for now, just know it is in Chad Africa and this is 200 words.', 'This would be image URLs',
            '11:58:32 and 1008 milliseconds on to make 50 max.', 'Weather is again 100 varchar.  Cool.  Well, the weather was hot, but cool that I get 100 varchar.', '  We are going to get into story time.  Chad.  What a guy, he is a good buddy of mine.  Oh right, Chad Africa.  Chad Africa I have almost zero knowledge of, but lets copy in a little bit of Wiki: 
            Chad, officially known as the Republic of Chad, is a landlocked country at the crossroads of North and Central Africa. It is bordered by Libya to the north, Sudan to the east, the Central African Republic to the south, Cameroon to the south-west, Nigeria to the southwest (at Lake Chad), and Niger to the west. Chad has a population of 16 million, of which 1.6 million live in the capital 
            and largest city NDjamena.  Chad has several regions: a desert zone in the north, an arid Sahelian belt in the centre and a more fertile Sudanian Savanna zone in the south. Lake Chad, after which the country is named, is the second-largest wetland in Africa. Chads official languages are Arabic and French. It is home to over 200 different ethnic and linguistic groups. Islam (51.8%) and Christianity 
            (44.1%) are the main religions practiced in Chad.  As you can see, Chad is the perfect location for hunting Desert wildlife, particularly Simba and Nala.  I really like both of those lions from the Lion King, but I cant help but want to keep them all to myself, so I went about scouting it out.  At first I started in the city with the apostrophe I took out so that I did not have to worry about escape 
            characters in the code/database.  I flew it, had a few drinks, and had a guide take me to the desert to capture Simba.  Once we got to wherever the guide took me, I immediately began to run around the area like a chicken with their head cut off to see what I could find.  Rocks, sand, pretty much everything the light was touching was amazing.  I can tell why lions would win here.  After hours of marking
             possible locations to find my feline friends, I had my guide tell me that my word count was getting low.');      


         INSERT INTO hiking_log (user_id, log_date, log_location, log_description, images, weather, log_state)   VALUES ('1', '2022-09-12', 'Rocky Mt high', 'Hiked 20 miles no problem, like 10 mins', 'This would be image URls', 'probably cold out', 'WW');
         INSERT INTO hiking_log (user_id, log_date, log_location, log_description, images, weather, log_state)   VALUES ('1', '2022-02-07', 'Mt St Helens', 'Took a volcano bath', 'This would be image URls', 'raining ash and rock', 'MN');
         INSERT INTO hiking_log (user_id, log_date, log_location, log_description, images, weather, log_state)   VALUES ('1', '2022-02-07', 'The location for hiking is 200 varchar.  I would like to take us on a little journey to just past Mozambique.  Sadly, I really dont know where that is, but we can pretend it is just around the river.', '
          A fair amount to let someone just ramble about their hiking experiences.  If they had actual content to put down I am sure it would be interesting in their own right, but instead you may just read about the time I scaled a hill where a mudslide had occurred as a child.  The slope was insanely steep, it occurred to me that if I slipped I might die, and I 
          did in fact loose my balance only to catch a root with my right hand which pulled me back into the dirt.', 'This would be image URls', 'Slightly cloudy with a chance of rain <--thats 37.', 'State being 30 seems small.');
 COMMIT TRANSACTION;                 
                 
