-- roles
INSERT INTO ROLES (ID, NAME) VALUES (1, 'ROLE_CUSTOMER');
INSERT INTO ROLES (ID, NAME) VALUES (2, 'ROLE_ADMIN');
-- EvseyVlasov424:customer123
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, PHONE_NUMBER) VALUES (1, 'EvseyVlasov424', '$2y$10$dojjMl/3TydUo3bFRNmM5./GpbCzLAY99B/xODi4npMNL9fKao3Dm', 'Евсей', 'Власов', '+79120295631');
INSERT INTO USERS_ROLES (USER_ID, ROLE_ID) VALUES ( 1, 1 );
-- GennadiySomov426:admin321
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, PHONE_NUMBER) VALUES (2, 'GennadiySomov426', '$2y$10$Vt5ryn9DxED4y3yvVVaqguBwiNtwsuVZSp1mp5biJdgqeQqhUoi6q', 'Геннадий', 'Сомов', '+79971352546');
INSERT INTO USERS_ROLES (USER_ID, ROLE_ID) VALUES ( 2, 1 ), (2, 2);