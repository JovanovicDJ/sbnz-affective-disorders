insert into doctors(name, surname, email, password)
values('Djordje', 'Jovanovic', 'a','$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6');

insert into doctors(name, surname, email, password)
values('Mladen', 'Gajic', 'mladen@gmail.com','$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6');

insert into patients(name, surname, dob, gender, email, phone, doctor_id)
values('Mika', 'Mikic', '2000-02-12', 0, 'mika@gmail.com', '0645566558', 1);

insert into manic_episodes(me_id, accepted, deleted, execution_time, intensity, type, patient)
values (1, true, false, '2023-06-13 16:29:41', 51, 0, 1);

insert into manic_episodes(me_id, accepted, deleted, execution_time, intensity, type, patient)
values (2, true, false, '2023-05-23 16:29:41', 55, 0, 1);