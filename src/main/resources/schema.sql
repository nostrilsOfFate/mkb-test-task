DROP TABLE IF EXISTS ASSESSMENT;
DROP TABLE IF EXISTS AIRPLANE;
DROP TABLE IF EXISTS CAR;
DROP TABLE IF EXISTS AIRPLANE_ASSESSMENTS;
DROP TABLE IF EXISTS CAR_ASSESSMENTS;

create table CAR
(
    id    IDENTITY primary key,
    brand VARCHAR2(150),
    model VARCHAR2(200),
    power DOUBLE,
    YEAR_OF_ISSUE  YEAR
);

create table AIRPLANE
(
    id            IDENTITY primary key,
    brand         VARCHAR2(150),
    model         VARCHAR2(200),
    manufacturer  VARCHAR2(500),
    fuel_capacity INT,
    seats         INT,
    YEAR_OF_ISSUE  YEAR
);

create table ASSESSMENT
(
    ID             IDENTITY primary key,
    ASSESSED_VALUE DEC(20),
    assessment_date TIMESTAMP
);

create table AIRPLANE_ASSESSMENTS
(
    AIRPLANE_ID    BIGINT not null,
    ASSESSMENTS_ID BIGINT not null,
    constraint airplane_idx
        foreign key (AIRPLANE_ID) references AIRPLANE (ID),
    constraint assessment_airplane_idx
        foreign key (ASSESSMENTS_ID) references ASSESSMENT (ID)
);

create table CAR_ASSESSMENTS
(
    CAR_ID         BIGINT not null,
    ASSESSMENTS_ID BIGINT not null,
    constraint assessment_car_idx
        foreign key (ASSESSMENTS_ID) references ASSESSMENT (ID),
    constraint car_idx
        foreign key (CAR_ID) references CAR (ID)
);

