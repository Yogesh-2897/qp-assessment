Use groceryStore;
Create table USER(
USER_ID INT AUTO_INCREMENT PRIMARY KEY,
FIRST_NAME VARCHAR(30),
LAST_NAME VARCHAR(30),
EMAIL VARCHAR(50),
STORE_NAME VARCHAR(30),
USER_TYPE VARCHAR(5),
PHONE_NUMBER VARCHAR(20),
USER_NAME VARCHAR(30),
PASSWORD VARCHAR(30),
DATE_OF_REGISTRATION datetime
);