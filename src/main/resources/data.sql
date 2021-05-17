INSERT INTO sposob_leczenia (id, nazwa)
VALUES (1, 'zapalenie pęcherza'), (2, 'zatrucia pokarmowe'),
(3, 'choroby nerek'), (4, 'biegunka'), (5, 'hemoroidy'), (6, 'pajączki na nogach');

INSERT INTO specyfik (id, nazwa, jednostka, ilosc, dawkowanie, sposob_leczenia_id)
VALUES (1,'DMSO', 'MILILITR', 2.0, '2 razy dziennie, roztwór wlać do kieliszka z wodą i wypić', 1),
(2, 'węgiel aktywny', 'MILIGRAM', 150.0, '1-3 razy dziennie, połknąć zalecaną dawkę popijając wodą', 2),
(3, 'kora dębu','LYZKA', 1, '2 razy dziennie, nasiadówki',5),
(4, 'olej rycynowy','MILILITR', 5.0, 'raz dziennie, wsmaruj w zmienione miejsca i zawiń folią', 6),
(5, 'demanosa', 'MILIGRAM', 3.0, '2 razy dziennie, rozpuść w niegazowanej wodzie i wypij', 1),
(6,'olej kokosowy z dodatkiem kropli płynu lugola', 'LYZKA', 1.0, 'raz dziennie, smarowac zmienione miejsca', 5);
