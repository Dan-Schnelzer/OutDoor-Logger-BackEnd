INSERT INTO users (first_name, last_name, username, password_hash)
   VALUES ('D', 'Schnelz', 'Eagle27', '12345');
   
INSERT INTO fishing_log (user_id, log_date, log_location, log_description)
 VALUES ('1','2022-12-23', 'somewhere in the ocean', 'caught 2 blue whales on a fly rod, I arm wrestled them, and then released them');  
 
 SELECT * FROM fishing_log; 
 
 INSERT INTO hunting_log (user_id, log_date, weather, log_description, hunting_type)
 VALUES ('1', '2022-01-17', 'rainy', 'shot a 67 point buck', 'cross bow');
 
 INSERT INTO hunting_log (user_id, log_date, weather, log_description, hunting_type)
 VALUES ('1', '2021-07-25', 'still rainy', 'shot a grizzly bear and a falcon', 'used a butter knife');
 
 INSERT INTO fishing_log (user_id, log_date, log_location, log_description)
 VALUES ('1', '2021-01-22', 'in a creek', 'caught 88 bass and the biggest was 7 foot long');
 
 INSERT INTO scouting_report (user_id, report_date, report_location, report_time, weather, scout_description)
  VALUES ('1', '2021-06-18', 'hills of western PA', 'early morning', 'blizzard out', 'seen 2 yetis and a bigfoot playing basketball');
  
  INSERT INTO scouting_report (user_id, report_date, report_location, report_time, weather, scout_description)
  VALUES ('1', '2022-08-19', 'paddys pub basement', 'midnight', 'probably cold out', 'charlie caught a lepruchan on a glue trap');
  
  SELECT * FROM scouting_report WHERE user_id =1;