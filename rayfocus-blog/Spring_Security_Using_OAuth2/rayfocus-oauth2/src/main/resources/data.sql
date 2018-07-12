
-- OAuth Client Details
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('rayfocus-bookstore', '$2a$10$nCWllJYSzQKl/ef3myAX3uv.zOL.kwB05L0RgQZ18aH8qDcj248ri', 'webclient,mobileclient',
	'password,authorization_code,refresh_token', null, null, 3600, 3600, null, true);

--Users	
INSERT INTO users
	(username,password,enabled)
VALUES 
	('bookstore.user','$2a$10$5X18hZRhgv01yfNJhWKsSuTxzg8pyaexFzyiDVbAxUlfWTOhH/nRu', true);
INSERT INTO users
	(username,password,enabled)
VALUES 
	('bookstore.admin','$2a$10$yD8fbccawNsL.VKqp6EpOuW9fmXs3lLtRrRAYD2GJ1Fo/3FcE4Oxa', true);

-- User Roles
INSERT INTO user_roles 
	(username, role)
VALUES 
	('bookstore.user', 'ROLE_USER');
INSERT INTO user_roles 
	(username, role)
VALUES 
	('bookstore.admin', 'ROLE_ADMIN');
INSERT INTO user_roles 
	(username, role)
VALUES 
	('bookstore.admin', 'ROLE_USER');
