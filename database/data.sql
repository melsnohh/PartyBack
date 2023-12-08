BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
--INSERT INTO users (username,password_hash,role) VALUES ('dchan','$2a$10$a1mqf7ECVExR/pr54U1DpuiEoHPonVH5OJNY7NT6xS7E36.6Hev6.','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('msnoh','$2a$10$CVExR/pr54U1DpuiEoHPonVH5OJNY7NT6xS7E36.6Hev6.','ROLE_USER');


INSERT INTO song (song_id, song_name, artist, image_url) VALUES('4RY96Asd9IefaL3X4LOLZ8', 'In Da Club', '50 Cent','https://i.scdn.co/image/ab67616d00004851f7f74100d5cc850e01172cbf' );
INSERT INTO song (song_id, song_name, artist, image_url) VALUES('5WAOIxI6GVlUl27aLdVNJD', 'This Aint', 'Chris Brown','https://i.scdn.co/image/ab67616d00004851af236a3219d347662cb4a284');
INSERT INTO song (song_id, song_name, artist, image_url) VALUES('6n3HGiq4v35D6eFOSwqYuo', 'Teenage Fever', 'Drake','https://i.scdn.co/image/ab67616d000048514f0fd9dad63977146e685700' );
INSERT INTO song (song_id, song_name, artist, image_url) VALUES('0zg5XJPiga7E5FxiehriG2', 'Been That Way', 'Bryson Tiller','https://i.scdn.co/image/ab67616d00004851d5f3cea8affdca01a0dc754f' );

INSERT INTO tag (tag_names) VALUES('HipHop');
INSERT INTO tag (tag_names) VALUES('R&B');
INSERT INTO tag (tag_names) VALUES('LateNight');
INSERT INTO tag (tag_names) VALUES('Debauchery');
INSERT INTO tag (tag_names) VALUES('Dance');
INSERT INTO tag (tag_names) VALUES('Philadelphia');

INSERT INTO Party (party_name, description, playlist_id, city, start_date, start_time)
VALUES('TE Dance Party', 'A dance party to celebrate TE students graduating from BootCamp', '7LItanlUlNTfVGqig3i156','Philadelphia', '2023-04-20', '09:30 PM');

INSERT INTO party_user (party_id, user_id) VALUES (1, 3);

INSERT INTO Party (party_name, description, playlist_id, city, start_date, start_time)
VALUES('TE Cool Kids Party', 'Come dance with the cool kids at TE', 'needs-to-be-created-on-spotify',' Philadelphia', '2023-04-21', '10:30 PM');

INSERT INTO Party (party_name, description, playlist_id, city, start_date, start_time)
VALUES('TE Chill Party', 'Come chill with TE students', 'needs-to-be-created-on-spotify', 'Philadelphia', '2023-05-20', '08:30 PM');

INSERT INTO Party (party_name, description, passcode, playlist_id, city, start_date, start_time)
VALUES('TE Summer Party', 'Come celebrate the beginning of summer with TE students!', '111', 'needs-to-be-created-on-spotify','Philadelphia', '2023-05-10', '09:30 PM');

INSERT INTO Party (party_name, description, passcode, playlist_id, city, start_date, start_time)
VALUES('TE Friday Party', 'Come celebrate the beginning of summer with TE students!', '111', 'needs-to-be-created-on-spotify','Philadelphia', '2023-05-10', '09:30 PM');

INSERT INTO Party (party_name, description, passcode, playlist_id, city, start_date, start_time)
VALUES('TE Saturday Party', 'Come celebrate the beginning of summer with TE students!', '111', 'needs-to-be-created-on-spotify','Philadelphia', '2023-05-10', '09:30 PM');

INSERT INTO Party (party_name, description, passcode, playlist_id, city, start_date, start_time)
VALUES('TE Sunday Party', 'Come celebrate the beginning of summer with TE students!', '111', 'needs-to-be-created-on-spotify','Philadelphia', '2023-05-10', '09:30 PM');

INSERT INTO Party (party_name, description, playlist_id, city, start_date, start_time)
VALUES('TE Monday Party', 'Come celebrate the beginning of summer with TE students!', 'needs-to-be-created-on-spotify','Philadelphia', '2023-05-10', '09:30 PM');

INSERT INTO Party (party_name, description, passcode, playlist_id, city, start_date, start_time)
VALUES('TE Tuesday Party', 'Come celebrate the beginning of summer with TE students!', '111', 'needs-to-be-created-on-spotify','Philadelphia', '2023-05-10', '09:30 PM');

INSERT INTO Party (party_name, description, passcode, playlist_id, city, start_date, start_time)
VALUES('TE Wednesday Party', 'Come celebrate the beginning of summer with TE students!', '111', 'needs-to-be-created-on-spotify','Philadelphia', '2023-05-10', '09:30 PM');

INSERT INTO Party (party_name, description, passcode, playlist_id, city, start_date, start_time)
VALUES('TE Thursday Party', 'Come celebrate the beginning of summer with TE students!', '111', 'needs-to-be-created-on-spotify','Philadelphia', '2023-05-10', '09:30 PM');

INSERT INTO party_song (party_id, song_id, vote) VALUES ('1','4RY96Asd9IefaL3X4LOLZ8','1');
INSERT INTO party_song (party_id, song_id, vote) VALUES ('1','5WAOIxI6GVlUl27aLdVNJD','0');
INSERT INTO party_song (party_id, song_id, vote) VALUES ('1','6n3HGiq4v35D6eFOSwqYuo','-1');
INSERT INTO party_song (party_id, song_id, vote) VALUES ('1','0zg5XJPiga7E5FxiehriG2','2');

INSERT INTO tag_party VALUES(1, 1);
INSERT INTO tag_party VALUES(1, 2);
INSERT INTO tag_party VALUES(1, 3);
INSERT INTO tag_party VALUES(1, 4);
INSERT INTO tag_party VALUES(1, 5);
INSERT INTO tag_party VALUES(1, 6);
INSERT INTO tag_party VALUES(1, 7);
INSERT INTO tag_party VALUES(1, 8);
INSERT INTO tag_party VALUES(1, 9);
INSERT INTO tag_party VALUES(1, 10);
INSERT INTO tag_party VALUES(6, 1);
INSERT INTO tag_party VALUES(6, 9);
INSERT INTO tag_party VALUES(6, 8);
INSERT INTO tag_party VALUES(5, 7);

COMMIT TRANSACTION;
