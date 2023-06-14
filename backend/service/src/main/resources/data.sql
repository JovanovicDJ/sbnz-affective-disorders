insert into doctors(name, surname, email, password)
values('Djordje', 'Jovanovic', 'a','$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6');

insert into doctors(name, surname, email, password)
values('Mladen', 'Gajic', 'mladen@gmail.com','$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6');

insert into patients(name, surname, dob, gender, email, phone, doctor_id)
values('Mika', 'Mikic', '2000-02-12', 0, 'mika@gmail.com', '0645566558', 1);

insert into patients(name, surname, dob, gender, email, phone, doctor_id)
values('Ognjen', 'Gajic', '2000-02-18', 0, 'ognjen@gmail.com', '0669843121', 1);

insert into patients(name, surname, dob, gender, email, phone, doctor_id)
values('Jovan', 'Tomic', '2000-01-12', 0, 'joca@gmail.com', '06989823156', 1);

insert into manic_episodes( accepted, deleted, execution_time, intensity, type, patient)
values (true, false, '2023-06-13 16:29:41', 51, 0, 1);

insert into depressive_episodes( accepted, deleted, execution_time, intensity, type, patient)
values (true, false, '2023-04-23 16:29:41', 55, 0, 1);

insert into manic_episodes( accepted, deleted, execution_time, intensity, type, patient)
values (true, false, '2023-01-23 16:29:41', 55, 0, 1);


insert into depressive_episodes( accepted, deleted, execution_time, intensity, type, patient)
values (true, false, '2022-05-23 16:29:41', 55, 0, 2);