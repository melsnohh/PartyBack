BEGIN TRANSACTION;

DROP TABLE IF EXISTS party_user, tag_party, party_song, song, tag, users, party;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE tag(
    tag_id SERIAL,
	tag_names varchar(100),
    CONSTRAINT PK_tag PRIMARY KEY (tag_id)
);

CREATE TABLE song(
	song_id varchar(50) NOT NULL UNIQUE,
    song_name varchar(50),
    artist varchar(50),
    image_url varchar(100),
	CONSTRAINT PK_song_id PRIMARY KEY (song_id)
);

CREATE TABLE party (
    party_id SERIAL,
    party_name varchar(100) NOT NULL,
    description varchar(500),
    passcode varchar(15),
    playlist_id varchar(50) NOT NULL,
    city varchar(50),
    start_date DATE,
    start_time TIME,
    CONSTRAINT pk_party PRIMARY KEY (party_id)
);

CREATE TABLE party_song (
    party_id SERIAL,
    song_id varchar(50),
    vote int DEFAULT 0,
    CONSTRAINT PK_party_song PRIMARY KEY (party_id, song_id),
	CONSTRAINT FK_party_song_party_id FOREIGN KEY (party_id) REFERENCES party(party_id),
	CONSTRAINT FK_party_song_song_id FOREIGN KEY (song_id) REFERENCES song(song_id)
);

CREATE TABLE tag_party(
	tag_id int,
	party_id int,
	CONSTRAINT PK_tag_party PRIMARY KEY(tag_id, party_id),
	CONSTRAINT FK_tag_party_tag FOREIGN kEY (tag_id) REFERENCES tag(tag_id),
	CONSTRAINT FK_tag_party_party FOREIGN KEY (party_id) REFERENCES party(party_id)
);

CREATE TABLE party_user (
    user_id int,
    party_id int,
    CONSTRAINT pk_party_user PRIMARY KEY(party_id, user_id),
    CONSTRAINT fk_party_user_party FOREIGN KEY(party_id) REFERENCES party(party_id),
    CONSTRAINT fk_party_user_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;




