INSERT INTO treatment_way (id, name)
VALUES (1, 'zapalenie pęcherza'), (2, 'zatrucia pokarmowe'),
(3, 'choroby nerek'), (4, 'biegunka'), (5, 'hemoroidy'), (6, 'pajączki na nogach');

INSERT INTO specific (id, name, unit, quantity, dosage, treatment_way_id)
VALUES (1,'DMSO', 'MILILITR', 2.0, '2 razy dziennie, roztwór wlać do kieliszka z wodą i wypić', 1),
(2, 'węgiel aktywny', 'MILIGRAM', 150.0, '1-3 razy dziennie, połknąć zalecaną dawkę popijając wodą', 2),
(3, 'kora dębu','LYZKA', 1, '2 razy dziennie, nasiadówki',5),
(4, 'olej rycynowy','MILILITR', 5.0, 'raz dziennie, wsmaruj w zmienione miejsca i zawiń folią', 6),
(5, 'demanosa', 'MILIGRAM', 3.0, '2 razy dziennie, rozpuść w niegazowanej wodzie i wypij', 1),
(6, 'olej kokosowy z dodatkiem kropli płynu lugola', 'LYZKA', 1.0, 'raz dziennie, smarowac zmienione miejsca', 5);

INSERT INTO user (id, first_name, last_name, date_of_birth, email, is_newsletter, password, user_name)
VALUES (1, 'Kinga', 'Kulig', '1986-04-29', 'kinga_k@gmail.com', true, '{noop}kk', 'kinia'),
       (2, 'Marcin', 'Jakis', '1983-09-13', 'mjakis@wp.com', false, '{noop}cc', 'cinek'),
       (3, 'Jolanta', 'Kombinacja', '1991-05-15', 'j.kombin@tlen.pl', false, '{noop}jj', 'jolus');

INSERT INTO user_role (role, user_id)
VALUES ('ROLE_ADMIN', 1), ('ROLE_USER', 1), ('ROLE_USER', 2), ('ROLE_USER', 3);
