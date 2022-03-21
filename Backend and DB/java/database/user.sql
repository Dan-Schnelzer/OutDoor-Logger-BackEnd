-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER outdoor_logger_owner
WITH PASSWORD 'finalcapstone';           -- for the moment let these passwords be

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO outdoor_logger_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO outdoor_logger_owner;

CREATE USER outdoor_logger_app_user
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO outdoor_logger_app_user;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO outdoor_logger_app_user;
