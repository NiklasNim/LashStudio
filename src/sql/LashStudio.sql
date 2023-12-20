
CREATE TABLE [dbo].[Customer] (
    [customerId] INT IDENTITY(1,1),
    [firstName] VARCHAR (255) NOT NULL,
    [lastName] VARCHAR (255) NOT NULL,
    [phone] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([customerId] ASC)
);


CREATE TABLE [dbo].[Order] (
    [orderId] INT IDENTITY(1,1),
    [orderDate] DATE NOT NULL,
    [customerId_FK] INT  NOT NULL,
    PRIMARY KEY CLUSTERED ([orderId] ASC),
    FOREIGN KEY ([customerId_FK]) REFERENCES [dbo].[Customer] ([customerId])
);

CREATE TABLE [dbo].[OrderLine] (
    [quantity] INT  NOT NULL,
    [unitPrice] MONEY NOT NULL,
    [barcode_FK] INT,
    [orderId_FK] INT,
    PRIMARY KEY CLUSTERED ([orderId_FK],[barcode_FK] ASC),
    FOREIGN KEY ([barcode_FK]) REFERENCES [dbo].[Product] ([barcode]),
    FOREIGN KEY ([orderId_FK]) REFERENCES [dbo].[Order] ([orderId])
);

CREATE TABLE [dbo].[Booking](
    [bookingDate] DATE NOT NULL,
    [bookingId] INT IDENTITY(1,1),
    [customerId_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([bookingId] ASC),
    FOREIGN KEY ([customerId_FK]) REFERENCES [dbo].[Customer]([customerId])
);

CREATE TABLE[dbo].[BookingLine](
    [bookingLineId] INT IDENTITY(1,1),
    [unitPrice] MONEY NOT NULL,
    [serviceId_FK] INT NOT NULL,
    [bookingId_FK] INT NOT NULL,
    [scheduleId_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([bookingLineId] ASC),
    FOREIGN KEY ([serviceId_FK]) REFERENCES [dbo].[Service]([serviceId]),
    FOREIGN KEY ([bookingId_FK]) REFERENCES [dbo].[Booking]([bookingId]),
    FOREIGN KEY ([scheduleId_FK]) REFERENCES [dbo].[Schedule]([ScheduleId]),
);



CREATE TABLE [dbo].[Service](
    [serviceId] INT IDENTITY(1,1),
    [price] MONEY NOT NULL,
    [description] VARCHAR(500) NOT NULL,
    [serviceType] VARCHAR(250) NOT NULL,
	[locationId_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([serviceId] ASC),
	FOREIGN KEY ([locationId_FK]) REFERENCES [dbo].[Location] ([locationId])
);


CREATE TABLE [dbo].[Location] (
    [locationId] INT IDENTITY(1,1),
    [name] VARCHAR(255) NOT NULL,
    [addressId_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([locationId] ASC),
    FOREIGN KEY ([addressId_FK]) REFERENCES [dbo].[Address] ([addressId])
);


CREATE TABLE [dbo].[Product](
    [name] VARCHAR (250) NOT NULL,
    [expirationDate] DATE NOT NULL,
    [type] VARCHAR (250) NOT NULL,
    [stock] int NOT NULL,
    [minStock] int NOT NULL,
    [price] MONEY NOT NULL,
    [barcode] int,
    [cvr_FK] int NOT NULL,
    PRIMARY KEY CLUSTERED([barcode]ASC),
    FOREIGN KEY ([cvr_FK]) REFERENCES [dbo].[Supplier]([cvr])
);

CREATE TABLE [dbo].[Supplier] (
    [name] VARCHAR(255)  NOT NULL,
    [cvr] INT,
    PRIMARY KEY CLUSTERED ([cvr] ASC),
);

CREATE TABLE [dbo].[Address] (
    [addressId] INT IDENTITY(1,1),
    [streetName] VARCHAR(255),
    [houseNumber] VARCHAR(255),
    [zipcode] INT,
    PRIMARY KEY CLUSTERED ([addressId] ASC)
);



CREATE TABLE [dbo].[Materialservice](
    [serviceId_FK] INT,
    [materialId_FK] INT,
    PRIMARY KEY CLUSTERED ([serviceId_FK], [materialId_FK] ASC),
    FOREIGN KEY ([serviceId_FK]) REFERENCES [dbo].[Service]([serviceId]),
    FOREIGN KEY ([materialId_FK]) REFERENCES [dbo].[Material] ([materialId])
);

CREATE TABLE [dbo].[Material] (
    [lashes] VARCHAR(255)  NOT NULL,
    [nails] VARCHAR(255),
    [haircolour] VARCHAR(255),
    [scissors] VARCHAR(255),
    [serviceId_FK] INT NOT NULL,
    [materialId] INT IDENTITY(1,1),
    [cvr_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([materialId] ASC),
    FOREIGN KEY ([serviceId_FK]) REFERENCES [dbo].[Service] ([serviceId]),
    FOREIGN KEY ([cvr_FK]) REFERENCES [dbo].[Supplier] ([cvr])
);


CREATE TABLE [dbo].[Employee](
    [firstName] VARCHAR (50) NOT NULL,
    [lastName] VARCHAR (50) NOT NULL,
    [employeeId] INT IDENTITY(1,1),
    PRIMARY KEY CLUSTERED ([employeeId] ASC),

);

CREATE TABLE [dbo].[Hair](
    [hairId] INT IDENTITY(1,1),
	[gender] VARCHAR (50) NOT NULL,
    [serviceId_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([hairId] ASC),
    FOREIGN KEY ([serviceId_FK]) REFERENCES [dbo].[Service]([serviceId])
);



CREATE TABLE [dbo].[Nails](
    [nailsId] INT IDENTITY(1,1),
	[extention] BIT NOT NULL,
    [serviceId_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([nailsId] ASC),
    FOREIGN KEY ([serviceId_FK]) REFERENCES [dbo].[Service]([serviceId])
);

CREATE TABLE [dbo].[Lashes](
    [lashesId] INT IDENTITY(1,1),
	[volume] VARCHAR (50) NOT NULL,
    [serviceId_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([lashesId] ASC),
    FOREIGN KEY ([serviceId_FK]) REFERENCES [dbo].[Service]([serviceId])
);

CREATE TABLE [dbo].[Schedule](
    [ScheduleId] INT IDENTITY (1,1),
    [startTime] DATETIME NOT NULL, 
    [endTime] DATETIME NOT NULL,
    [employeeId_FK] INT NOT NULL,
    PRIMARY KEY CLUSTERED ([ScheduleId] ASC),
    FOREIGN KEY ([employeeId_FK]) REFERENCES [dbo].[Employee]([employeeId]) 
);




INSERT INTO [dbo].[Order] (orderDate, customerId_FK) VALUES
('2023-01-01', 1),
('2023-01-15', 2),
('2023-02-10', 3),
('2023-02-20', 4),
('2023-03-05', 5),
('2023-03-15', 6),
('2023-04-01', 7),
('2023-04-10', 8),
('2023-04-20', 9),
('2023-05-01', 10);

INSERT INTO [dbo].[Customer] (firstName, lastName, phone) VALUES
('Henrik', 'Larsen', 20232024),
('Bo', 'Benzon', 19981999),
('Ida', 'Jensen', 11314910),
('Anna', 'Nielsen', 20406070),
('Lars', 'Johansen', 30507080),
('Sofia', 'Christensen', 40608090),
('Peter', 'Svendsen', 50709000),
('Maria', 'Hansen', 66889910),
('Jan', 'Madsen', 77991020),
('Line', 'Pedersen', 81112230);

INSERT INTO [dbo].[OrderLine](quantity, unitPrice, barcode_FK, orderId_FK) VALUES
(1, 35, 12345678, 1),
(2, 85, 12345679, 2),
(3, 45, 12345680, 1),
(1, 60, 12345681, 2),
(2, 120, 12345682, 3);


INSERT INTO [dbo].[Booking] (bookingDate, customerId_FK) VALUES
('2023-03-03', 3),
('2023-04-04', 3),
('2023-05-05', 4),
('2023-06-06', 4),
('2023-07-07', 5);


INSERT INTO BookingLine(serviceId_FK, bookingId_FK, scheduleId_FK, unitPrice) VALUES
(3, 3, 11, 500),
(4, 4, 12, 600);



INSERT INTO [dbo].[Service] (price, description, serviceType, locationId_FK) VALUES
(250, 'Klipning', 'Hair', 1),
(300, 'Neglebehandling', 'Nails', 1),
(350, 'Vipperservice', 'Lashes', 1);



INSERT INTO [dbo].[Product] (name, expirationDate, type, stock, minStock, price, barcode, cvr_FK) VALUES
('Head & Shoulders', '2030-01-01', 'Shampoo', 30, 5, 35, 12345678, 123456),
('ID', '2026-02-02', 'Styling Wax', 40, 10, 85, 12345679, 123457),
('Redken All Soft Conditioner', '2028-12-31', 'Conditioner', 25, 5, 45, 12345680, 123458),
('Garnier', '2029-06-30', 'Hair Dye', 20, 10, 60, 12345681, 199859),
('Lashday', '2031-05-15', 'Lashes', 50, 20, 120, 12345682, 123460),
('ZOYA', '2029-08-24', 'Nail Polish', 60, 30, 90, 12345683, 123461),
('TRESemmé', '2025-12-31', 'Heat Protector', 35, 5, 40, 12345684, 223463),
('ONYX', '2028-11-11', 'Nail Cream', 55, 15, 50, 12345685, 671234),
('KISS', '2024-10-10', 'Lashes', 70, 30, 25, 12345686, 155465),
('Salon Signature Acrylic Nail Set', '2023-09-09', 'Nails', 45, 20, 150, 12345687, 123465);


INSERT INTO [dbo].[Supplier] (name, cvr) VALUES
('Nice Hair', 123456),
('LuxPlus', 123457),
('Hair4You', 123458),
('Shampoo World', 199859), 
('Hair Care', 123460),
('Beauty Products', 123461),
('Salon Supplies', 223463),
('Hair Essentials', 671234),
('Grooming Lounge', 155465),
('Acrylic Nails Co.', 123465);

INSERT INTO [dbo].[Address] (streetName, houseNumber, zipcode) VALUES
('Jens Bangs Gade', '8 1 tv', 9000),
('Kattedamsvej', '7', 9440),
('Kastetvej', '36', 9000),
('Hobrovej', '45', 9000),
('Østerågade', '12', 9000),
('Fjordgade', '8', 9000),
('Strandvej', '22', 9000),
('Boulevarden', '6', 9000),
('Kjellerupsgade', '18', 9000),
('Søndergade', '5', 9000);


INSERT INTO [dbo].[MaterialService] (serviceId_FK, materialId_FK) VALUES
(3, 2),
(4, 3);


INSERT INTO [dbo].[Material] (lashes, nails, hairColour, scissors, serviceId_FK, cvr_FK) VALUES
('Kurvede vipper', 'Negle lak', 'Blå hårfarve', 'Scissor Pro Max', 3, 123456),
('3D vipper', 'Negle fil', 'Highlights', 'Blå saks', 4, 155465);


INSERT INTO [dbo].[Employee] (firstName, lastName) VALUES
('Hanne', 'Jensen'),
('Rikke', 'Fage'),
('Nadia', 'Pedersen'),
('Sofie', 'Larsen'),
('Emma', 'Møller'),
('Maria', 'Jørgensen'),
('Louise', 'Andersen'),
('Freja', 'Nielsen'),
('Ida', 'Christensen'),
('Anne', 'Kjær');


INSERT INTO [dbo].[Location] (name, addressId_FK) VALUES
('Salon 1', 1),
('Salon 2', 2),
('Salon 3', 3);


INSERT INTO [dbo].[Hair] (gender, serviceId_FK) VALUES
('Mand', 3),
('Kvinde', 3);

INSERT INTO [dbo].[Nails] (extention, serviceId_FK) VALUES
(0, 4),
(1, 4);

INSERT INTO [dbo].[Lashes] (volume, serviceId_FK) VALUES
('3D', 5),
('Natural', 5),
('Short', 5),
('Medium', 5),
('Long', 5);

DECLARE @StartTime DATETIME;
SET @StartTime = '2024-01-02T08:00:00';

DECLARE @Counter INT;
SET @Counter = 1;

WHILE (@Counter <= 10)
BEGIN
    PRINT CONVERT(VARCHAR, @StartTime, 108); -- 108 formatet viser kun tid
    SET @Counter = @Counter + 1;
    DECLARE @Endtime DATETIME;
    SET @Endtime = DATEADD(HOUR, 1, @StartTime);
    INSERT INTO [dbo].[Schedule](startTime, endTime, employeeId_FK) VALUES
    (@StartTime, @Endtime, 1)
    SET @StartTime = @Endtime;
END


delete from schedule
