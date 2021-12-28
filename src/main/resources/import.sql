
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (1, 'Y', 1, 'Welcome to the University of Hawai''i CAS Demonstration application. The site includes source code that shows you how to use the UH CAS service.');
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (2, 'Y', 1, 'University of Hawaii Information Technology Services resides in a state-of-the-art, six-story, 74,000-square-foot facility located on the Manoa campus.');
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (3, 'Y', 1, 'The access to this system is restricted.<br/>If you believe you should have access, <br/> please send an email to <a href=''mailto:duckart@hawaii.edu''>duckart@hawaii.edu</a>.');
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (4, 'N', 1, 'For Future Use.');
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (5, 'Y', 1, 'This is a place for some messaging directed at the Applicant.');
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (6, 'Y', 1, 'Coordinators, secretaries, administrators, chancellors, and other big potatoes.');
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (7, 'Y', 1, 'You are someone who is a Coordinator and an Applicant.');
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (8, 'Y', 1, 'Some messaging about at the Application or the process of it.');
insert into message (MSG_ID, MSG_ENABLED, MSG_TYPE_ID, MSG_TEXT) values (9, 'Y', 1, 'Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.');

-- Campus codes and names.
insert into campus (id, code, actual, description) values (1,  'HA', 'Y', 'Hawaii Community College');
insert into campus (id, code, actual, description) values (2,  'HI', 'Y', 'UH Hilo');
insert into campus (id, code, actual, description) values (3,  'HO', 'Y', 'Honolulu Community College');
insert into campus (id, code, actual, description) values (4,  'KA', 'Y', 'Kapiolani Community College');
insert into campus (id, code, actual, description) values (5,  'KU', 'Y', 'Kauai Community College');
insert into campus (id, code, actual, description) values (6,  'LE', 'Y', 'Leeward Community College');
insert into campus (id, code, actual, description) values (7,  'MA', 'Y', 'UH Manoa');
insert into campus (id, code, actual, description) values (8,  'MU', 'Y', 'UH Maui College');
insert into campus (id, code, actual, description) values (9,  'WI', 'Y', 'Windward Community College');
insert into campus (id, code, actual, description) values (10, 'WO', 'Y', 'UH West Oahu');
insert into campus (id, code, actual, description) values (11, 'SW', 'N', 'UH System');

insert into type (id, description) values(2, 'Federal');
insert into type (id, description) values(3, 'UH');
insert into type (id, description) values(4, 'State');

insert into holiday (id, official_date, observed_date, description) values (1001, '2006-01-01', '2006-01-02', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (1002, '2006-01-16', '2006-01-16', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (1003, '2006-02-20', '2006-02-20', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (1004, '2006-03-27', '2006-03-27', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (1005, '2006-04-14', '2006-04-14', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (1006, '2006-05-29', '2006-05-29', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (1007, '2006-06-11', '2006-06-12', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (1008, '2006-07-04', '2006-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (1009, '2006-08-18', '2006-08-18', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (1010, '2006-09-04', '2006-09-04', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (1011, '2006-11-07', '2006-11-07', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values (1012, '2006-11-11', '2006-11-10', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (1013, '2006-11-23', '2006-11-23', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (1014, '2006-12-25', '2006-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (1015, '2007-01-01', '2007-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (1016, '2007-01-15', '2007-01-15', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (1017, '2007-02-19', '2007-02-19', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (1018, '2007-03-26', '2007-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (1019, '2007-04-06', '2007-04-06', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (1020, '2007-05-28', '2007-05-28', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (1021, '2007-06-11', '2007-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (1022, '2007-07-04', '2007-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (1023, '2007-08-17', '2007-08-17', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (1024, '2007-09-03', '2007-09-03', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (1025, '2007-11-11', '2007-11-12', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (1026, '2007-11-22', '2007-11-22', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (1027, '2007-12-25', '2007-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (1028, '2008-01-01', '2008-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (1029, '2008-01-21', '2008-01-21', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (1030, '2008-02-18', '2008-02-18', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (1031, '2008-03-21', '2008-03-21', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (1032, '2008-03-26', '2008-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (1033, '2008-05-26', '2008-05-26', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (1034, '2008-06-11', '2008-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (1035, '2008-07-04', '2008-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (1036, '2008-08-15', '2008-08-15', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (1037, '2008-09-01', '2008-09-01', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (1038, '2008-11-04', '2008-11-04', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values (1039, '2008-11-11', '2008-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (1040, '2008-11-27', '2008-11-27', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (1041, '2008-12-25', '2008-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (1042, '2009-01-01', '2009-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (1043, '2009-01-19', '2009-01-19', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (1044, '2009-02-16', '2009-02-16', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (1045, '2009-03-26', '2009-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (1046, '2009-04-10', '2009-04-10', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (1047, '2009-05-25', '2009-05-25', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (1048, '2009-06-11', '2009-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (1049, '2009-07-04', '2009-07-03', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (1050, '2009-08-21', '2009-08-21', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (1051, '2009-09-07', '2009-09-07', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (1052, '2009-11-11', '2009-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (1053, '2009-11-26', '2009-11-26', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (1054, '2009-12-25', '2009-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (1055, '2010-01-01', '2010-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (1056, '2010-01-18', '2010-01-18', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (1057, '2010-02-15', '2010-02-15', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (1058, '2010-03-26', '2010-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (1059, '2010-04-02', '2010-04-02', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (1060, '2010-05-31', '2010-05-31', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (1061, '2010-06-11', '2010-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (1062, '2010-07-04', '2010-07-05', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (1063, '2010-08-20', '2010-08-20', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (1064, '2010-09-06', '2010-09-06', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (1065, '2010-11-02', '2010-11-02', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values (1066, '2010-11-11', '2010-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (1067, '2010-11-25', '2010-11-25', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (1068, '2010-12-24', '2010-12-24', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (  15, '2011-01-01', '2010-12-31', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (  16, '2011-01-17', '2011-01-17', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (  17, '2011-02-21', '2011-02-21', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (  18, '2011-03-26', '2011-03-25', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (  19, '2011-04-22', '2011-04-22', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (  20, '2011-05-30', '2011-05-30', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (  21, '2011-06-11', '2011-06-10', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (  22, '2011-07-04', '2011-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (  23, '2011-08-19', '2011-08-19', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (  24, '2011-09-05', '2011-09-05', 'Labor Day');
insert into holiday (id, description, observed_date, official_date) values (  25, 'Discoverers'' Day',            '2011-10-10','2011-10-10');
insert into holiday (id, official_date, observed_date, description) values (  26, '2011-11-11', '2011-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (  27, '2011-11-24', '2011-11-24', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (  28, '2011-12-25', '2011-12-26', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (  29, '2012-01-01', '2012-01-02', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (  30, '2012-01-16', '2012-01-16', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (  31, '2012-02-20', '2012-02-20', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (  32, '2012-03-26', '2012-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (  33, '2012-04-06', '2012-04-06', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (  34, '2012-05-28', '2012-05-28', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (  35, '2012-06-11', '2012-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (  36, '2012-07-04', '2012-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (  37, '2012-08-17', '2012-08-17', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (  38, '2012-09-03', '2012-09-03', 'Labor Day');
insert into holiday (id, description, observed_date, official_date) values (  39, 'Discoverers'' Day',            '2012-10-08','2012-10-08');
insert into holiday (id, official_date, observed_date, description) values (  40, '2012-11-06', '2012-11-06', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values (  41, '2012-11-11', '2012-11-12', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (  42, '2012-11-22', '2012-11-22', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (  43, '2012-12-25', '2012-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (   1, '2013-01-01', '2013-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (   2, '2013-01-21', '2013-01-21', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (   3, '2013-02-18', '2013-02-18', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (   4, '2013-03-26', '2013-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (   5, '2013-03-29', '2013-03-29', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (   6, '2013-05-27', '2013-05-27', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (   7, '2013-06-11', '2013-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (   8, '2013-07-04', '2013-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (   9, '2013-08-16', '2013-08-16', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (  10, '2013-09-02', '2013-09-02', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (  11, '2013-10-14', '2013-10-14', 'Discoverers'' Day');
insert into holiday (id, official_date, observed_date, description) values (  12, '2013-11-11', '2013-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (  13, '2013-11-28', '2013-11-28', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (  14, '2013-12-25', '2013-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (  44, '2014-01-01', '2014-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (  45, '2014-01-20', '2014-01-20', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (  46, '2014-02-17', '2014-02-17', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (  47, '2014-03-26', '2014-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (  48, '2014-04-18', '2014-04-18', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (  49, '2014-05-26', '2014-05-26', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (  50, '2014-06-11', '2014-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (  51, '2014-07-04', '2014-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (  52, '2014-08-15', '2014-08-15', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (  53, '2014-09-01', '2014-09-01', 'Labor Day');
insert into holiday (id, description, observed_date, official_date) values (  54, 'Discoverers'' Day',            '2014-10-13','2014-10-13');
insert into holiday (id, official_date, observed_date, description) values (  55, '2014-11-04', '2014-11-04', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values (  56, '2014-11-11', '2014-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (  57, '2014-11-27', '2014-11-27', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (  58, '2014-12-25', '2014-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (  59, '2015-01-01', '2015-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (  60, '2015-01-19', '2015-01-19', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (  61, '2015-02-16', '2015-02-16', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (  62, '2015-03-26', '2015-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (  63, '2015-04-03', '2015-04-03', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (  64, '2015-05-25', '2015-05-25', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (  65, '2015-06-11', '2015-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (  66, '2015-07-04', '2015-07-03', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (  67, '2015-08-21', '2015-08-21', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (  68, '2015-09-07', '2015-09-07', 'Labor Day');
insert into holiday (id, description, observed_date, official_date) values (  69, 'Discoverers'' Day',            '2015-10-12','2015-10-12');
insert into holiday (id, official_date, observed_date, description) values (  70, '2015-11-11', '2015-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (  71, '2015-11-26', '2015-11-26', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (  72, '2015-12-25', '2015-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (  73, '2016-01-01', '2016-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (  74, '2016-01-18', '2016-01-18', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (  75, '2016-02-15', '2016-02-15', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (  76, '2016-03-25', '2016-03-25', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (  77, '2016-03-26', '2016-03-25', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (  78, '2016-05-30', '2016-05-30', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (  79, '2016-06-11', '2016-06-10', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (  80, '2016-07-04', '2016-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (  81, '2016-08-19', '2016-08-19', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (  82, '2016-09-05', '2016-09-05', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (  84, '2016-11-08', '2016-11-08', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values (  85, '2016-11-11', '2016-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (  86, '2016-11-24', '2016-11-24', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (  87, '2016-12-25', '2016-12-26', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (  88, '2017-01-01', '2017-01-02', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (  89, '2017-01-16', '2017-01-16', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (  90, '2017-02-20', '2017-02-20', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (  91, '2017-03-26', '2017-03-27', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (  92, '2017-04-14', '2017-04-14', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (  93, '2017-05-29', '2017-05-29', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (  94, '2017-06-11', '2017-06-12', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (  95, '2017-07-04', '2017-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (  96, '2017-08-18', '2017-08-18', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (  97, '2017-09-04', '2017-09-04', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (  99, '2017-11-11', '2017-11-10', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values ( 100, '2017-11-23', '2017-11-23', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values ( 101, '2017-12-25', '2017-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values ( 102, '2018-01-01', '2018-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values ( 103, '2018-01-15', '2018-01-15', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values ( 104, '2018-02-19', '2018-02-19', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values ( 105, '2018-03-26', '2018-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values ( 106, '2018-03-30', '2018-03-30', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values ( 107, '2018-05-28', '2018-05-28', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values ( 108, '2018-06-11', '2018-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values ( 109, '2018-07-04', '2018-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values ( 110, '2018-08-17', '2018-08-17', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values ( 111, '2018-09-03', '2018-09-03', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values ( 112, '2018-11-06', '2018-11-06', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values ( 113, '2018-11-11', '2018-11-12', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values ( 114, '2018-11-22', '2018-11-22', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values ( 115, '2018-12-25', '2018-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values ( 116, '2019-01-01', '2019-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values ( 117, '2019-01-21', '2019-01-21', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values ( 118, '2019-02-18', '2019-02-18', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values ( 119, '2019-03-26', '2019-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values ( 120, '2019-04-19', '2019-04-19', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values ( 121, '2019-05-27', '2019-05-27', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values ( 122, '2019-06-11', '2019-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values ( 123, '2019-07-04', '2019-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values ( 124, '2019-08-16', '2019-08-16', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values ( 125, '2019-09-02', '2019-09-02', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values ( 126, '2019-11-11', '2019-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values ( 127, '2019-11-28', '2019-11-28', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values ( 128, '2019-12-25', '2019-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values ( 129, '2020-01-01', '2020-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values ( 130, '2020-01-20', '2020-01-20', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values ( 131, '2020-02-17', '2020-02-17', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values ( 132, '2020-03-26', '2020-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values ( 133, '2020-04-10', '2020-04-10', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values ( 134, '2020-05-25', '2020-05-25', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values ( 135, '2020-06-11', '2020-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values ( 136, '2020-07-04', '2020-07-03', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values ( 137, '2020-08-21', '2020-08-21', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values ( 138, '2020-09-07', '2020-09-07', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values ( 139, '2020-11-03', '2020-11-03', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values ( 140, '2020-11-11', '2020-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values ( 141, '2020-11-26', '2020-11-26', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values ( 142, '2020-12-25', '2020-12-25', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (1204, '2021-01-01', '2021-01-01', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (1205, '2021-01-18', '2021-01-18', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (1206, '2021-02-15', '2021-02-15', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (1207, '2021-03-26', '2021-03-26', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (1208, '2021-04-02', '2021-04-02', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (1209, '2021-05-31', '2021-05-31', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (1210, '2021-06-11', '2021-06-11', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (1211, '2021-07-04', '2021-07-05', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (1212, '2021-08-20', '2021-08-20', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (1213, '2021-09-06', '2021-09-06', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (1214, '2021-11-11', '2021-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (1215, '2021-11-25', '2021-11-25', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (1216, '2021-12-25', '2021-12-24', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (1217, '2022-01-01', '2021-12-31', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (1218, '2022-01-17', '2022-01-17', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (1219, '2022-02-21', '2022-02-21', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (1220, '2022-03-26', '2022-03-25', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (1221, '2022-04-15', '2022-04-15', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (1222, '2022-05-30', '2022-05-30', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (1223, '2022-06-11', '2022-06-10', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (1224, '2022-07-04', '2022-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (1225, '2022-08-19', '2022-08-19', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (1226, '2022-09-05', '2022-09-05', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (1227, '2022-11-08', '2022-11-08', 'General Election Day');
insert into holiday (id, official_date, observed_date, description) values (1228, '2022-11-11', '2022-11-11', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (1229, '2022-11-24', '2022-11-24', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (1230, '2022-12-25', '2022-12-26', 'Christmas');
insert into holiday (id, official_date, observed_date, description) values (1231, '2023-01-01', '2023-01-02', 'New Year''s Day');
insert into holiday (id, official_date, observed_date, description) values (1232, '2023-01-16', '2023-01-16', 'Dr. Martin Luther King, Jr. Day');
insert into holiday (id, official_date, observed_date, description) values (1233, '2023-02-20', '2023-02-20', 'Presidents'' Day');
insert into holiday (id, official_date, observed_date, description) values (1234, '2023-03-26', '2023-03-27', 'Prince Jonah Kuhio Kalanianaole Day');
insert into holiday (id, official_date, observed_date, description) values (1235, '2023-04-07', '2023-04-07', 'Good Friday');
insert into holiday (id, official_date, observed_date, description) values (1236, '2023-05-29', '2023-05-29', 'Memorial Day');
insert into holiday (id, official_date, observed_date, description) values (1237, '2023-06-11', '2023-06-12', 'King Kamehameha I Day');
insert into holiday (id, official_date, observed_date, description) values (1238, '2023-07-04', '2023-07-04', 'Independence Day');
insert into holiday (id, official_date, observed_date, description) values (1239, '2023-08-18', '2023-08-18', 'Statehood Day');
insert into holiday (id, official_date, observed_date, description) values (1240, '2023-09-04', '2023-09-04', 'Labor Day');
insert into holiday (id, official_date, observed_date, description) values (1241, '2023-11-11', '2023-11-10', 'Veterans'' Day');
insert into holiday (id, official_date, observed_date, description) values (1242, '2023-11-23', '2023-11-23', 'Thanksgiving');
insert into holiday (id, official_date, observed_date, description) values (1243, '2023-12-25', '2023-12-25', 'Christmas');

insert into holiday_type(type_id, holiday_id) values(2,1);
insert into holiday_type(type_id, holiday_id) values(3,1);
insert into holiday_type(type_id, holiday_id) values(2,2);
insert into holiday_type(type_id, holiday_id) values(3,2);
insert into holiday_type(type_id, holiday_id) values(2,3);
insert into holiday_type(type_id, holiday_id) values(3,3);
insert into holiday_type(type_id, holiday_id) values(3,4);
insert into holiday_type(type_id, holiday_id) values(4,4);
insert into holiday_type(type_id, holiday_id) values(3,5);
insert into holiday_type(type_id, holiday_id) values(2,6);
insert into holiday_type(type_id, holiday_id) values(3,6);
insert into holiday_type(type_id, holiday_id) values(3,7);
insert into holiday_type(type_id, holiday_id) values(4,7);
insert into holiday_type(type_id, holiday_id) values(2,8);
insert into holiday_type(type_id, holiday_id) values(3,8);
insert into holiday_type(type_id, holiday_id) values(3,9);
insert into holiday_type(type_id, holiday_id) values(4,9);
insert into holiday_type(type_id, holiday_id) values(2,10);
insert into holiday_type(type_id, holiday_id) values(3,10);
insert into holiday_type(type_id, holiday_id) values(2,11);
insert into holiday_type(type_id, holiday_id) values(2,12);
insert into holiday_type(type_id, holiday_id) values(3,12);
insert into holiday_type(type_id, holiday_id) values(2,13);
insert into holiday_type(type_id, holiday_id) values(3,13);
insert into holiday_type(type_id, holiday_id) values(2,14);
insert into holiday_type(type_id, holiday_id) values(3,14);
insert into holiday_type(type_id, holiday_id) values(2,15);
insert into holiday_type(type_id, holiday_id) values(3,15);
insert into holiday_type(type_id, holiday_id) values(2,16);
insert into holiday_type(type_id, holiday_id) values(3,16);
insert into holiday_type(type_id, holiday_id) values(2,17);
insert into holiday_type(type_id, holiday_id) values(3,17);
insert into holiday_type(type_id, holiday_id) values(3,18);
insert into holiday_type(type_id, holiday_id) values(4,18);
insert into holiday_type(type_id, holiday_id) values(3,19);
insert into holiday_type(type_id, holiday_id) values(2,20);
insert into holiday_type(type_id, holiday_id) values(3,20);
insert into holiday_type(type_id, holiday_id) values(3,21);
insert into holiday_type(type_id, holiday_id) values(4,21);
insert into holiday_type(type_id, holiday_id) values(2,22);
insert into holiday_type(type_id, holiday_id) values(3,22);
insert into holiday_type(type_id, holiday_id) values(3,23);
insert into holiday_type(type_id, holiday_id) values(4,23);
insert into holiday_type(type_id, holiday_id) values(2,24);
insert into holiday_type(type_id, holiday_id) values(3,24);
insert into holiday_type(type_id, holiday_id) values(2,25);
insert into holiday_type(type_id, holiday_id) values(2,26);
insert into holiday_type(type_id, holiday_id) values(3,26);
insert into holiday_type(type_id, holiday_id) values(2,27);
insert into holiday_type(type_id, holiday_id) values(3,27);
insert into holiday_type(type_id, holiday_id) values(2,28);
insert into holiday_type(type_id, holiday_id) values(3,28);
insert into holiday_type(type_id, holiday_id) values(2,29);
insert into holiday_type(type_id, holiday_id) values(3,29);
insert into holiday_type(type_id, holiday_id) values(2,30);
insert into holiday_type(type_id, holiday_id) values(3,30);
insert into holiday_type(type_id, holiday_id) values(2,31);
insert into holiday_type(type_id, holiday_id) values(3,31);
insert into holiday_type(type_id, holiday_id) values(3,32);
insert into holiday_type(type_id, holiday_id) values(4,32);
insert into holiday_type(type_id, holiday_id) values(3,33);
insert into holiday_type(type_id, holiday_id) values(2,34);
insert into holiday_type(type_id, holiday_id) values(3,34);
insert into holiday_type(type_id, holiday_id) values(3,35);
insert into holiday_type(type_id, holiday_id) values(4,35);
insert into holiday_type(type_id, holiday_id) values(2,36);
insert into holiday_type(type_id, holiday_id) values(3,36);
insert into holiday_type(type_id, holiday_id) values(3,37);
insert into holiday_type(type_id, holiday_id) values(4,37);
insert into holiday_type(type_id, holiday_id) values(2,38);
insert into holiday_type(type_id, holiday_id) values(3,38);
insert into holiday_type(type_id, holiday_id) values(2,39);
insert into holiday_type(type_id, holiday_id) values(2,40);
insert into holiday_type(type_id, holiday_id) values(3,40);
insert into holiday_type(type_id, holiday_id) values(2,41);
insert into holiday_type(type_id, holiday_id) values(3,41);
insert into holiday_type(type_id, holiday_id) values(2,42);
insert into holiday_type(type_id, holiday_id) values(3,42);
insert into holiday_type(type_id, holiday_id) values(2,43);
insert into holiday_type(type_id, holiday_id) values(3,43);
insert into holiday_type(type_id, holiday_id) values(2,44);
insert into holiday_type(type_id, holiday_id) values(3,44);
insert into holiday_type(type_id, holiday_id) values(2,45);
insert into holiday_type(type_id, holiday_id) values(3,45);
insert into holiday_type(type_id, holiday_id) values(2,46);
insert into holiday_type(type_id, holiday_id) values(3,46);
insert into holiday_type(type_id, holiday_id) values(3,47);
insert into holiday_type(type_id, holiday_id) values(4,47);
insert into holiday_type(type_id, holiday_id) values(3,48);
insert into holiday_type(type_id, holiday_id) values(2,49);
insert into holiday_type(type_id, holiday_id) values(3,49);
insert into holiday_type(type_id, holiday_id) values(3,50);
insert into holiday_type(type_id, holiday_id) values(4,50);
insert into holiday_type(type_id, holiday_id) values(2,51);
insert into holiday_type(type_id, holiday_id) values(3,51);
insert into holiday_type(type_id, holiday_id) values(3,52);
insert into holiday_type(type_id, holiday_id) values(4,52);
insert into holiday_type(type_id, holiday_id) values(2,53);
insert into holiday_type(type_id, holiday_id) values(3,53);
insert into holiday_type(type_id, holiday_id) values(2,54);
insert into holiday_type(type_id, holiday_id) values(3,54);
insert into holiday_type(type_id, holiday_id) values(2,55);
insert into holiday_type(type_id, holiday_id) values(3,55);
insert into holiday_type(type_id, holiday_id) values(2,56);
insert into holiday_type(type_id, holiday_id) values(3,56);
insert into holiday_type(type_id, holiday_id) values(2,57);
insert into holiday_type(type_id, holiday_id) values(3,57);
insert into holiday_type(type_id, holiday_id) values(2,58);
insert into holiday_type(type_id, holiday_id) values(3,58);
insert into holiday_type(type_id, holiday_id) values(2,59);
insert into holiday_type(type_id, holiday_id) values(3,59);
insert into holiday_type(type_id, holiday_id) values(2,60);
insert into holiday_type(type_id, holiday_id) values(3,60);
insert into holiday_type(type_id, holiday_id) values(2,61);
insert into holiday_type(type_id, holiday_id) values(3,61);
insert into holiday_type(type_id, holiday_id) values(3,62);
insert into holiday_type(type_id, holiday_id) values(4,62);
insert into holiday_type(type_id, holiday_id) values(3,63);
insert into holiday_type(type_id, holiday_id) values(2,64);
insert into holiday_type(type_id, holiday_id) values(3,64);
insert into holiday_type(type_id, holiday_id) values(3,65);
insert into holiday_type(type_id, holiday_id) values(4,65);
insert into holiday_type(type_id, holiday_id) values(2,66);
insert into holiday_type(type_id, holiday_id) values(3,66);
insert into holiday_type(type_id, holiday_id) values(3,67);
insert into holiday_type(type_id, holiday_id) values(4,67);
insert into holiday_type(type_id, holiday_id) values(2,68);
insert into holiday_type(type_id, holiday_id) values(3,68);
insert into holiday_type(type_id, holiday_id) values(2,69);
insert into holiday_type(type_id, holiday_id) values(3,69);
insert into holiday_type(type_id, holiday_id) values(2,70);
insert into holiday_type(type_id, holiday_id) values(3,70);
insert into holiday_type(type_id, holiday_id) values(2,71);
insert into holiday_type(type_id, holiday_id) values(3,71);
insert into holiday_type(type_id, holiday_id) values(2,72);
insert into holiday_type(type_id, holiday_id) values(3,72);
insert into holiday_type(type_id, holiday_id) values(2,73);
insert into holiday_type(type_id, holiday_id) values(3,73);
insert into holiday_type(type_id, holiday_id) values(2,74);
insert into holiday_type(type_id, holiday_id) values(3,74);
insert into holiday_type(type_id, holiday_id) values(2,75);
insert into holiday_type(type_id, holiday_id) values(3,75);
insert into holiday_type(type_id, holiday_id) values(3,76);
insert into holiday_type(type_id, holiday_id) values(4,76);
insert into holiday_type(type_id, holiday_id) values(2,78);
insert into holiday_type(type_id, holiday_id) values(3,78);
insert into holiday_type(type_id, holiday_id) values(3,79);
insert into holiday_type(type_id, holiday_id) values(4,79);
insert into holiday_type(type_id, holiday_id) values(2,80);
insert into holiday_type(type_id, holiday_id) values(3,80);
insert into holiday_type(type_id, holiday_id) values(3,81);
insert into holiday_type(type_id, holiday_id) values(4,81);
insert into holiday_type(type_id, holiday_id) values(2,82);
insert into holiday_type(type_id, holiday_id) values(3,82);
insert into holiday_type(type_id, holiday_id) values(2, 84);
insert into holiday_type(type_id, holiday_id) values(3, 84);
insert into holiday_type(type_id, holiday_id) values(2,85);
insert into holiday_type(type_id, holiday_id) values(3,85);
insert into holiday_type(type_id, holiday_id) values(2,86);
insert into holiday_type(type_id, holiday_id) values(3,86);
insert into holiday_type(type_id, holiday_id) values(2,87);
insert into holiday_type(type_id, holiday_id) values(3,87);
insert into holiday_type(type_id, holiday_id) values(2, 88);
insert into holiday_type(type_id, holiday_id) values(3, 88);
insert into holiday_type(type_id, holiday_id) values(2, 89);
insert into holiday_type(type_id, holiday_id) values(3, 89);
insert into holiday_type(type_id, holiday_id) values(2, 90);
insert into holiday_type(type_id, holiday_id) values(3, 90);
insert into holiday_type(type_id, holiday_id) values(3, 91);
insert into holiday_type(type_id, holiday_id) values(4, 91);
insert into holiday_type(type_id, holiday_id) values(3, 92);
insert into holiday_type(type_id, holiday_id) values(2, 93);
insert into holiday_type(type_id, holiday_id) values(3, 93);
insert into holiday_type(type_id, holiday_id) values(3, 94);
insert into holiday_type(type_id, holiday_id) values(4, 94);
insert into holiday_type(type_id, holiday_id) values(2, 95);
insert into holiday_type(type_id, holiday_id) values(3, 95);
insert into holiday_type(type_id, holiday_id) values(3, 96);
insert into holiday_type(type_id, holiday_id) values(4, 96);
insert into holiday_type(type_id, holiday_id) values(2, 97);
insert into holiday_type(type_id, holiday_id) values(3, 97);
insert into holiday_type(type_id, holiday_id) values(2, 99);
insert into holiday_type(type_id, holiday_id) values(3, 99);
insert into holiday_type(type_id, holiday_id) values(2, 100);
insert into holiday_type(type_id, holiday_id) values(3, 100);
insert into holiday_type(type_id, holiday_id) values(2,101);
insert into holiday_type(type_id, holiday_id) values(3,101);
insert into holiday_type(type_id, holiday_id) values(2,115);
insert into holiday_type(type_id, holiday_id) values(3,115);
insert into holiday_type(type_id, holiday_id) values(2,128);
insert into holiday_type(type_id, holiday_id) values(3,128);
insert into holiday_type(type_id, holiday_id) values(2,142);
insert into holiday_type(type_id, holiday_id) values(3,142);

insert into holiday_type(type_id, holiday_id) values(2, 114);
insert into holiday_type(type_id, holiday_id) values(3, 114);
insert into holiday_type(type_id, holiday_id) values(2, 127);
insert into holiday_type(type_id, holiday_id) values(3, 127);
insert into holiday_type(type_id, holiday_id) values(2, 141);
insert into holiday_type(type_id, holiday_id) values(3, 141);

insert into holiday_type(type_id, holiday_id) values(3, 110);
insert into holiday_type(type_id, holiday_id) values(4, 110);
insert into holiday_type(type_id, holiday_id) values(3, 124);
insert into holiday_type(type_id, holiday_id) values(4, 124);
insert into holiday_type(type_id, holiday_id) values(3, 137);
insert into holiday_type(type_id, holiday_id) values(4, 137);

insert into holiday_type(type_id, holiday_id) values(2, 113);
insert into holiday_type(type_id, holiday_id) values(3, 113);
insert into holiday_type(type_id, holiday_id) values(2, 126);
insert into holiday_type(type_id, holiday_id) values(3, 126);
insert into holiday_type(type_id, holiday_id) values(2, 140);
insert into holiday_type(type_id, holiday_id) values(3, 140);

insert into holiday_type(type_id, holiday_id) values(2, 112);
insert into holiday_type(type_id, holiday_id) values(3, 112);
insert into holiday_type(type_id, holiday_id) values(2, 139);
insert into holiday_type(type_id, holiday_id) values(3, 139);

insert into holiday_type(type_id, holiday_id) values(2, 111);
insert into holiday_type(type_id, holiday_id) values(3, 111);
insert into holiday_type(type_id, holiday_id) values(2, 125);
insert into holiday_type(type_id, holiday_id) values(3, 125);
insert into holiday_type(type_id, holiday_id) values(2, 138);
insert into holiday_type(type_id, holiday_id) values(3, 138);

insert into holiday_type(type_id, holiday_id) values(2, 109);
insert into holiday_type(type_id, holiday_id) values(3, 109);
insert into holiday_type(type_id, holiday_id) values(2, 123);
insert into holiday_type(type_id, holiday_id) values(3, 123);
insert into holiday_type(type_id, holiday_id) values(2, 136);
insert into holiday_type(type_id, holiday_id) values(3, 136);

insert into holiday_type(type_id, holiday_id) values(3, 108);
insert into holiday_type(type_id, holiday_id) values(4, 108);
insert into holiday_type(type_id, holiday_id) values(3, 122);
insert into holiday_type(type_id, holiday_id) values(4, 122);
insert into holiday_type(type_id, holiday_id) values(3, 135);
insert into holiday_type(type_id, holiday_id) values(4, 135);

insert into holiday_type(type_id, holiday_id) values(2, 107);
insert into holiday_type(type_id, holiday_id) values(3, 107);
insert into holiday_type(type_id, holiday_id) values(2, 121);
insert into holiday_type(type_id, holiday_id) values(3, 121);
insert into holiday_type(type_id, holiday_id) values(2, 134);
insert into holiday_type(type_id, holiday_id) values(3, 134);

insert into holiday_type(type_id, holiday_id) values(3, 77);
insert into holiday_type(type_id, holiday_id) values(3, 106);
insert into holiday_type(type_id, holiday_id) values(3, 120);
insert into holiday_type(type_id, holiday_id) values(3, 133);

insert into holiday_type(type_id, holiday_id) values(3, 105);
insert into holiday_type(type_id, holiday_id) values(4, 105);
insert into holiday_type(type_id, holiday_id) values(3, 119);
insert into holiday_type(type_id, holiday_id) values(4, 119);
insert into holiday_type(type_id, holiday_id) values(3, 132);
insert into holiday_type(type_id, holiday_id) values(4, 132);

insert into holiday_type(type_id, holiday_id) values(2, 104);
insert into holiday_type(type_id, holiday_id) values(3, 104);
insert into holiday_type(type_id, holiday_id) values(2, 118);
insert into holiday_type(type_id, holiday_id) values(3, 118);
insert into holiday_type(type_id, holiday_id) values(2, 131);
insert into holiday_type(type_id, holiday_id) values(3, 131);

insert into holiday_type(type_id, holiday_id) values(2, 103);
insert into holiday_type(type_id, holiday_id) values(3, 103);
insert into holiday_type(type_id, holiday_id) values(2, 117);
insert into holiday_type(type_id, holiday_id) values(3, 117);
insert into holiday_type(type_id, holiday_id) values(2, 130);
insert into holiday_type(type_id, holiday_id) values(3, 130);

insert into holiday_type(type_id, holiday_id) values(2, 102);
insert into holiday_type(type_id, holiday_id) values(3, 102);
insert into holiday_type(type_id, holiday_id) values(2, 116);
insert into holiday_type(type_id, holiday_id) values(3, 116);
insert into holiday_type(type_id, holiday_id) values(2, 129);
insert into holiday_type(type_id, holiday_id) values(3, 129);

insert into holiday_type(type_id, holiday_id) values(3, 1230);
insert into holiday_type(type_id, holiday_id) values(4, 1230);

insert into holiday_type(type_id, holiday_id) values(3, 1229);
insert into holiday_type(type_id, holiday_id) values(4, 1229);

insert into holiday_type(type_id, holiday_id) values(3, 1228);
insert into holiday_type(type_id, holiday_id) values(4, 1228);

insert into holiday_type(type_id, holiday_id) values(3, 1227);
insert into holiday_type(type_id, holiday_id) values(4, 1227);

insert into holiday_type(type_id, holiday_id) values(3, 1226);
insert into holiday_type(type_id, holiday_id) values(4, 1226);

insert into holiday_type(type_id, holiday_id) values(3, 1225);
insert into holiday_type(type_id, holiday_id) values(4, 1225);

insert into holiday_type(type_id, holiday_id) values(3, 1224);
insert into holiday_type(type_id, holiday_id) values(4, 1224);

insert into holiday_type(type_id, holiday_id) values(3, 1223);
insert into holiday_type(type_id, holiday_id) values(4, 1223);

insert into holiday_type(type_id, holiday_id) values(3, 1222);
insert into holiday_type(type_id, holiday_id) values(4, 1222);

insert into holiday_type(type_id, holiday_id) values(3, 1221);
insert into holiday_type(type_id, holiday_id) values(4, 1221);

insert into holiday_type(type_id, holiday_id) values(3, 1220);
insert into holiday_type(type_id, holiday_id) values(4, 1220);

insert into holiday_type(type_id, holiday_id) values(3, 1219);
insert into holiday_type(type_id, holiday_id) values(4, 1219);

insert into holiday_type(type_id, holiday_id) values(3, 1218);
insert into holiday_type(type_id, holiday_id) values(4, 1218);

insert into holiday_type(type_id, holiday_id) values(3, 1217);
insert into holiday_type(type_id, holiday_id) values(4, 1217);

insert into holiday_type(type_id, holiday_id) values(3, 1216);
insert into holiday_type(type_id, holiday_id) values(4, 1216);

insert into holiday_type(type_id, holiday_id) values(3, 1215);
insert into holiday_type(type_id, holiday_id) values(4, 1215);

insert into holiday_type(type_id, holiday_id) values(3, 1214);
insert into holiday_type(type_id, holiday_id) values(4, 1214);

insert into holiday_type(type_id, holiday_id) values(3, 1213);
insert into holiday_type(type_id, holiday_id) values(4, 1213);

insert into holiday_type(type_id, holiday_id) values(3, 1212);
insert into holiday_type(type_id, holiday_id) values(4, 1212);

insert into holiday_type(type_id, holiday_id) values(3, 1211);
insert into holiday_type(type_id, holiday_id) values(4, 1211);

insert into holiday_type(type_id, holiday_id) values(3, 1210);
insert into holiday_type(type_id, holiday_id) values(4, 1210);

insert into holiday_type(type_id, holiday_id) values(3, 1209);
insert into holiday_type(type_id, holiday_id) values(4, 1209);

insert into holiday_type(type_id, holiday_id) values(3, 1208);
insert into holiday_type(type_id, holiday_id) values(4, 1208);

insert into holiday_type(type_id, holiday_id) values(3, 1207);
insert into holiday_type(type_id, holiday_id) values(4, 1207);

insert into holiday_type(type_id, holiday_id) values(3, 1206);
insert into holiday_type(type_id, holiday_id) values(4, 1206);

insert into holiday_type(type_id, holiday_id) values(3, 1205);
insert into holiday_type(type_id, holiday_id) values(4, 1205);

insert into holiday_type(type_id, holiday_id) values(3, 1204);
insert into holiday_type(type_id, holiday_id) values(4, 1204);

insert into holiday_type(type_id, holiday_id) values(3, 1068);
insert into holiday_type(type_id, holiday_id) values(4, 1068);

insert into holiday_type(type_id, holiday_id) values(3, 1067);
insert into holiday_type(type_id, holiday_id) values(4, 1067);

insert into holiday_type(type_id, holiday_id) values(3, 1066);
insert into holiday_type(type_id, holiday_id) values(4, 1066);

insert into holiday_type(type_id, holiday_id) values(3, 1065);
insert into holiday_type(type_id, holiday_id) values(4, 1065);

insert into holiday_type(type_id, holiday_id) values(3, 1064);
insert into holiday_type(type_id, holiday_id) values(4, 1064);

insert into holiday_type(type_id, holiday_id) values(3, 1063);
insert into holiday_type(type_id, holiday_id) values(4, 1063);

insert into holiday_type(type_id, holiday_id) values(3, 1062);
insert into holiday_type(type_id, holiday_id) values(4, 1062);

insert into holiday_type(type_id, holiday_id) values(3, 1061);
insert into holiday_type(type_id, holiday_id) values(4, 1061);

insert into holiday_type(type_id, holiday_id) values(3, 1060);
insert into holiday_type(type_id, holiday_id) values(4, 1060);

insert into holiday_type(type_id, holiday_id) values(3, 1059);
insert into holiday_type(type_id, holiday_id) values(4, 1059);

insert into holiday_type(type_id, holiday_id) values(3, 1058);
insert into holiday_type(type_id, holiday_id) values(4, 1058);

insert into holiday_type(type_id, holiday_id) values(3, 1057);
insert into holiday_type(type_id, holiday_id) values(4, 1057);

insert into holiday_type(type_id, holiday_id) values(3, 1056);
insert into holiday_type(type_id, holiday_id) values(4, 1056);

insert into holiday_type(type_id, holiday_id) values(3, 1055);
insert into holiday_type(type_id, holiday_id) values(4, 1055);

insert into holiday_type(type_id, holiday_id) values(3, 1054);
insert into holiday_type(type_id, holiday_id) values(4, 1054);

insert into holiday_type(type_id, holiday_id) values(3, 1053);
insert into holiday_type(type_id, holiday_id) values(4, 1053);

insert into holiday_type(type_id, holiday_id) values(3, 1052);
insert into holiday_type(type_id, holiday_id) values(4, 1052);

insert into holiday_type(type_id, holiday_id) values(3, 1051);
insert into holiday_type(type_id, holiday_id) values(4, 1051);

insert into holiday_type(type_id, holiday_id) values(3, 1050);
insert into holiday_type(type_id, holiday_id) values(4, 1050);

insert into holiday_type(type_id, holiday_id) values(3, 1049);
insert into holiday_type(type_id, holiday_id) values(4, 1049);

insert into holiday_type(type_id, holiday_id) values(3, 1048);
insert into holiday_type(type_id, holiday_id) values(4, 1048);

insert into holiday_type(type_id, holiday_id) values(3, 1047);
insert into holiday_type(type_id, holiday_id) values(4, 1047);

insert into holiday_type(type_id, holiday_id) values(3, 1046);
insert into holiday_type(type_id, holiday_id) values(4, 1046);

insert into holiday_type(type_id, holiday_id) values(3, 1045);
insert into holiday_type(type_id, holiday_id) values(4, 1045);

insert into holiday_type(type_id, holiday_id) values(3, 1044);
insert into holiday_type(type_id, holiday_id) values(4, 1044);

insert into holiday_type(type_id, holiday_id) values(3, 1043);
insert into holiday_type(type_id, holiday_id) values(4, 1043);

insert into holiday_type(type_id, holiday_id) values(3, 1042);
insert into holiday_type(type_id, holiday_id) values(4, 1042);

insert into holiday_type(type_id, holiday_id) values(3, 1041);
insert into holiday_type(type_id, holiday_id) values(4, 1041);

insert into holiday_type(type_id, holiday_id) values(3, 1040);
insert into holiday_type(type_id, holiday_id) values(4, 1040);

insert into holiday_type(type_id, holiday_id) values(3, 1039);
insert into holiday_type(type_id, holiday_id) values(4, 1039);

insert into holiday_type(type_id, holiday_id) values(3, 1038);
insert into holiday_type(type_id, holiday_id) values(4, 1038);

insert into holiday_type(type_id, holiday_id) values(3, 1037);
insert into holiday_type(type_id, holiday_id) values(4, 1037);

insert into holiday_type(type_id, holiday_id) values(3, 1036);
insert into holiday_type(type_id, holiday_id) values(4, 1036);

insert into holiday_type(type_id, holiday_id) values(3, 1035);
insert into holiday_type(type_id, holiday_id) values(4, 1035);

insert into holiday_type(type_id, holiday_id) values(3, 1034);
insert into holiday_type(type_id, holiday_id) values(4, 1034);

insert into holiday_type(type_id, holiday_id) values(3, 1033);
insert into holiday_type(type_id, holiday_id) values(4, 1033);

insert into holiday_type(type_id, holiday_id) values(3, 1032);
insert into holiday_type(type_id, holiday_id) values(4, 1032);

insert into holiday_type(type_id, holiday_id) values(3, 1031);
insert into holiday_type(type_id, holiday_id) values(4, 1031);

insert into holiday_type(type_id, holiday_id) values(3, 1030);
insert into holiday_type(type_id, holiday_id) values(4, 1030);

insert into holiday_type(type_id, holiday_id) values(3, 1029);
insert into holiday_type(type_id, holiday_id) values(4, 1029);

insert into holiday_type(type_id, holiday_id) values(3, 1028);
insert into holiday_type(type_id, holiday_id) values(4, 1028);

insert into holiday_type(type_id, holiday_id) values(3, 1027);
insert into holiday_type(type_id, holiday_id) values(4, 1027);

insert into holiday_type(type_id, holiday_id) values(3, 1026);
insert into holiday_type(type_id, holiday_id) values(4, 1026);

insert into holiday_type(type_id, holiday_id) values(3, 1025);
insert into holiday_type(type_id, holiday_id) values(4, 1025);

insert into holiday_type(type_id, holiday_id) values(3, 1024);
insert into holiday_type(type_id, holiday_id) values(4, 1024);

insert into holiday_type(type_id, holiday_id) values(3, 1023);
insert into holiday_type(type_id, holiday_id) values(4, 1023);

insert into holiday_type(type_id, holiday_id) values(3, 1022);
insert into holiday_type(type_id, holiday_id) values(4, 1022);

insert into holiday_type(type_id, holiday_id) values(3, 1021);
insert into holiday_type(type_id, holiday_id) values(4, 1021);

insert into holiday_type(type_id, holiday_id) values(3, 1020);
insert into holiday_type(type_id, holiday_id) values(4, 1020);

insert into holiday_type(type_id, holiday_id) values(3, 1019);
insert into holiday_type(type_id, holiday_id) values(4, 1019);

insert into holiday_type(type_id, holiday_id) values(3, 1018);
insert into holiday_type(type_id, holiday_id) values(4, 1018);

insert into holiday_type(type_id, holiday_id) values(3, 1017);
insert into holiday_type(type_id, holiday_id) values(4, 1017);

insert into holiday_type(type_id, holiday_id) values(3, 1016);
insert into holiday_type(type_id, holiday_id) values(4, 1016);

insert into holiday_type(type_id, holiday_id) values(3, 1015);
insert into holiday_type(type_id, holiday_id) values(4, 1015);

insert into holiday_type(type_id, holiday_id) values(3, 1014);
insert into holiday_type(type_id, holiday_id) values(4, 1014);

insert into holiday_type(type_id, holiday_id) values(3, 1013);
insert into holiday_type(type_id, holiday_id) values(4, 1013);

insert into holiday_type(type_id, holiday_id) values(3, 1012);
insert into holiday_type(type_id, holiday_id) values(4, 1012);

insert into holiday_type(type_id, holiday_id) values(3, 1011);
insert into holiday_type(type_id, holiday_id) values(4, 1011);
insert into holiday_type(type_id, holiday_id) values(3, 1010);
insert into holiday_type(type_id, holiday_id) values(4, 1010);
insert into holiday_type(type_id, holiday_id) values(3, 1009);
insert into holiday_type(type_id, holiday_id) values(4, 1009);
insert into holiday_type(type_id, holiday_id) values(3, 1008);
insert into holiday_type(type_id, holiday_id) values(4, 1008);
insert into holiday_type(type_id, holiday_id) values(3, 1007);
insert into holiday_type(type_id, holiday_id) values(4, 1007);
insert into holiday_type(type_id, holiday_id) values(3, 1006);
insert into holiday_type(type_id, holiday_id) values(4, 1006);
insert into holiday_type(type_id, holiday_id) values(3, 1005);
insert into holiday_type(type_id, holiday_id) values(4, 1005);
insert into holiday_type(type_id, holiday_id) values(3, 1004);
insert into holiday_type(type_id, holiday_id) values(4, 1004);
insert into holiday_type(type_id, holiday_id) values(3, 1003);
insert into holiday_type(type_id, holiday_id) values(4, 1003);
insert into holiday_type(type_id, holiday_id) values(3, 1002);
insert into holiday_type(type_id, holiday_id) values(4, 1002);
insert into holiday_type(type_id, holiday_id) values(3, 1001);
insert into holiday_type(type_id, holiday_id) values(4, 1001);

insert into holiday_type(type_id, holiday_id) values(3, 1243);
insert into holiday_type(type_id, holiday_id) values(4, 1243);
insert into holiday_type(type_id, holiday_id) values(3, 1242);
insert into holiday_type(type_id, holiday_id) values(4, 1242);
insert into holiday_type(type_id, holiday_id) values(3, 1241);
insert into holiday_type(type_id, holiday_id) values(4, 1241);
insert into holiday_type(type_id, holiday_id) values(3, 1240);
insert into holiday_type(type_id, holiday_id) values(4, 1240);
insert into holiday_type(type_id, holiday_id) values(3, 1239);
insert into holiday_type(type_id, holiday_id) values(4, 1239);
insert into holiday_type(type_id, holiday_id) values(3, 1238);
insert into holiday_type(type_id, holiday_id) values(4, 1238);
insert into holiday_type(type_id, holiday_id) values(3, 1237);
insert into holiday_type(type_id, holiday_id) values(4, 1237);
insert into holiday_type(type_id, holiday_id) values(3, 1236);
insert into holiday_type(type_id, holiday_id) values(4, 1236);
insert into holiday_type(type_id, holiday_id) values(3, 1235);
insert into holiday_type(type_id, holiday_id) values(4, 1235);
insert into holiday_type(type_id, holiday_id) values(3, 1234);
insert into holiday_type(type_id, holiday_id) values(4, 1234);
insert into holiday_type(type_id, holiday_id) values(3, 1233);
insert into holiday_type(type_id, holiday_id) values(4, 1233);
insert into holiday_type(type_id, holiday_id) values(3, 1232);
insert into holiday_type(type_id, holiday_id) values(4, 1232);
insert into holiday_type(type_id, holiday_id) values(3, 1231);
insert into holiday_type(type_id, holiday_id) values(4, 1231);

insert into role (id, role, short_description, description) values (1,  'USER',    'User',          'User');
insert into role (id, role, short_description, description) values (2,  'FACULTY', 'Faculty',       'Faculty');
insert into role (id, role, short_description, description) values (3,  'STAFF',   'Staff',         'Staff');
insert into role (id, role, short_description, description) values (99, 'ADMIN',   'Administrator', 'Administrator');
