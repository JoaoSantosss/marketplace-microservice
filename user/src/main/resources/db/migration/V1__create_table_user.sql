CREATE TABLE user_table (
	id uuid PRIMARY KEY,
	email VARCHAR NOT NULL UNIQUE,
	password VARCHAR NOT NULL,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP
);