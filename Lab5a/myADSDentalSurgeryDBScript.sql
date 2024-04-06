CREATE DATABASE adsdentalsurgerydb;

use adsdentalsurgerydb;

CREATE TABLE Dentists (
    DentistID INT PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    ContactPhoneNumber VARCHAR(15),
    Email VARCHAR(100),
    Specialization VARCHAR(100)
);

CREATE TABLE Patients (
    PatientID INT PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    ContactPhoneNumber VARCHAR(15),
    Email VARCHAR(100),
    MailingAddress VARCHAR(200),
    DateOfBirth DATE
);

CREATE TABLE Surgeries (
    SurgeryID INT PRIMARY KEY,
    Name VARCHAR(100),
    LocationAddress VARCHAR(200),
    TelephoneNumber VARCHAR(15)
);

CREATE TABLE Appointments (
    AppointmentID INT PRIMARY KEY,
    DentistID INT,
    PatientID INT,
    SurgeryID INT,
    AppointmentDate DATE,
    AppointmentTime TIME,
    FOREIGN KEY (DentistID) REFERENCES Dentists(DentistID),
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (SurgeryID) REFERENCES Surgeries(SurgeryID)
);


INSERT INTO Dentists (DentistID, FirstName, LastName, ContactPhoneNumber, Email, Specialization) VALUES
(1, 'John', 'Doe', '123-456-7890', 'john.doe@ads.com', 'Orthodontist'),
(2, 'Jane', 'Smith', '987-654-3210', 'jane.smith@ads.com', 'Pedodontist'),
(3, 'Emily', 'Johnson', '456-789-1234', 'emily.johnson@ads.com', 'Endodontist');
INSERT INTO Patients (PatientID, FirstName, LastName, ContactPhoneNumber, Email, MailingAddress, DateOfBirth) VALUES
(1, 'Alice', 'Brown', '321-654-9870', 'alice.brown@mail.com', '123 Main St, Anytown, USA', '1980-04-01'),
(2, 'Bob', 'White', '654-321-0987', 'bob.white@mail.com', '456 Elm St, Anycity, USA', '1990-07-15'),
(3, 'Charlie', 'Green', '789-012-3456', 'charlie.green@mail.com', '789 Maple Ave, Anyville, USA', '2000-10-30');

INSERT INTO Surgeries (SurgeryID, Name, LocationAddress, TelephoneNumber) VALUES
(1, 'Main Street Dental', '123 Main St, Anytown, USA', '111-222-3333'),
(2, 'Elm Street Dental', '456 Elm St, Anycity, USA', '444-555-6666');


-- Ensure these values do not violate business constraints like appointment limits
INSERT INTO Appointments (AppointmentID, DentistID, PatientID, SurgeryID, AppointmentDate, AppointmentTime) VALUES
(1, 1, 1, 1, '2024-04-10', '09:30:00'),
(2, 1, 2, 1, '2024-04-11', '11:45:00'),
(3, 2, 3, 2, '2024-04-12', '14:00:00');



SELECT *
FROM Dentists
ORDER BY LastName ASC;

SELECT a.*, p.FirstName, p.LastName, p.ContactPhoneNumber, p.Email
FROM Appointments a
JOIN Patients p ON a.PatientID = p.PatientID
WHERE a.DentistID = 1;

SELECT a.*, d.FirstName AS DentistFirstName, d.LastName AS DentistLastName, p.FirstName AS PatientFirstName, p.LastName AS PatientLastName
FROM Appointments a
JOIN Dentists d ON a.DentistID = d.DentistID
JOIN Patients p ON a.PatientID = p.PatientID
WHERE a.SurgeryID = 1;


SELECT a.*, d.FirstName AS DentistFirstName, d.LastName AS DentistLastName, s.Name AS SurgeryName
FROM Appointments a
JOIN Dentists d ON a.DentistID = d.DentistID
JOIN Surgeries s ON a.SurgeryID = s.SurgeryID
WHERE a.PatientID = 1 AND a.AppointmentDate = '2024-04-10';
