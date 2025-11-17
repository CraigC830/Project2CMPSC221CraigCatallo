CREATE TABLE Order (
    Order_ID INT PRIMARY KEY,
    Order_Item VARCHAR(30) NOT NULL,
    Order_Options VARCHAR(30) NOT NULL,
    Order_QTY int NOT NULL,
    Order_Price int NOT NULL,
    Order_Total int NOT NULL,
);