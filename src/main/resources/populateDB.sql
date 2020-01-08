DELETE
FROM CAR_ASSESSMENTS;
DELETE
FROM AIRPLANE_ASSESSMENTS;
DELETE
FROM ASSESSMENT;
DELETE
FROM AIRPLANE;
DELETE
FROM CAR;


INSERT into CAR (id, brand, model, power, YEAR_OF_ISSUE)
values (1, 'brand1CAR', 'model1CAR', 1.1, 2010),
       (2, 'brand2CAR', 'model1CAR', 1.2, 2011),
       (3, 'brand3CAR', 'model1CAR', 1.3, 2012),
       (4, 'brand4CAR', 'model1CAR', 1.4, 2013);

INSERT into AIRPLANE (id, brand, model, manufacturer, FUEL_CAPACITY, seats, YEAR_OF_ISSUE)
values (1, 'brand1AIRPLANE', 'model1AIRPLANE', 'manuf1', 1, 1, 2010),
       (2, 'brand1AIRPLANE', 'model1AIRPLANE', 'manuf2', 2, 2, 2011),
       (3, 'brand1AIRPLANE', 'model1AIRPLANE', 'manuf3', 3, 3, 2012),
       (4, 'brand1AIRPLANE', 'model1AIRPLANE', 'manuf4', 4, 4, 2011);


INSERT into ASSESSMENT (id, assessed_value, ASSESSMENT_DATE)
values (1, 1111111, '2012-09-17'),
       (2, 22222222, '2012-09-18'),
       (3, 33333333, '2015-09-17'),
       (4, 44444444, '2016-09-17'),
       (5, 44444444, '2017-09-17'),
       (6, 44444444, '2018-09-18'),
       (7, 44444444, '2019-09-17');

insert into AIRPLANE_ASSESSMENTS(airplane_id, assessments_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (4, 4);

insert into CAR_ASSESSMENTS(CAR_ID, assessments_id)
VALUES (1, 5),
       (1, 6),
       (2, 7);