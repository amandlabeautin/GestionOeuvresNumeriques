-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:8889
-- Généré le :  Dim 18 Juin 2017 à 22:18
-- Version du serveur :  5.6.35
-- Version de PHP :  7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `gestionOeuvresNumeriques`
--

-- --------------------------------------------------------

--
-- Structure de la table `acteur`
--

CREATE TABLE `acteur` (
  `id` bigint(20) NOT NULL,
  `acteur_nom` varchar(255) NOT NULL,
  `acteur_photo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `acteur`
--

INSERT INTO `acteur` (`id`, `acteur_nom`, `acteur_photo`) VALUES
(1, 'Tom Hanks', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F6%2F66%2FTom_Hanks_2014.jpg%2F220px-Tom_Hanks_2014.jpg'),
(2, 'Gary Sinise', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F9%2F90%2FGary_Sinise_2011_%2528cropped%2529.jpg%2F260px-Gary_Sinise_2011_%2528cropped%2529.jpg'),
(3, 'Robin Wright', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fc%2Fcd%2FRobin_Wright_Cannes_2017.jpg%2F220px-Robin_Wright_Cannes_2017.jpg'),
(4, 'Mykelti Williamson', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fa%2Fa0%2FMykelti_Williamson_2003_%2528cropped%2529.jpg%2F220px-Mykelti_Williamson_2003_%2528cropped%2529.jpg'),
(5, 'Sally Field', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F6%2F68%2FSally_Field_1990.jpg%2F220px-Sally_Field_1990.jpg'),
(6, 'Chris Pratt', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fc%2Fc2%2FChris_Pratt_by_Gage_Skidmore_2.jpg%2F220px-Chris_Pratt_by_Gage_Skidmore_2.jpg'),
(7, 'Zoe Saldana', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F3%2F31%2FZoe_Saldana_by_Gage_Skidmore_3.jpg%2F220px-Zoe_Saldana_by_Gage_Skidmore_3.jpg'),
(8, 'Dave Bautista', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F7%2F77%2FDave_Batista_-_Guardians_of_the_Galaxy_premiere_-_July_2014_%2528cropped%2529.jpg%2F220px-Dave_Batista_-_Guardians_of_the_Galaxy_premiere_-_July_2014_%2528cropped%2529.jpg'),
(9, 'Michael Rooker', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fe6%2FMichael_Rooker_2013_02_%2528cropped%2529.jpg%2F260px-Michael_Rooker_2013_02_%2528cropped%2529.jpg'),
(10, 'Karen Gillan', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F8%2F8e%2FKaren_Gillan_by_Gage_Skidmore_3.jpg%2F220px-Karen_Gillan_by_Gage_Skidmore_3.jpg'),
(11, 'Tom Holland', 'http%3A%2F%2Ffr.web.img2.acsta.net%2Fr_1920_1080%2Fpictures%2F15%2F11%2F24%2F16%2F53%2F595385.jpg'),
(12, 'Zendaya', 'http%3A%2F%2Ffr.web.img6.acsta.net%2Fr_1920_1080%2Fpictures%2F15%2F11%2F23%2F09%2F37%2F018271.jpg'),
(13, 'Marisa Tomei', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fc%2Fc9%2FMarisa_Tomei_TIFF_2012.jpg%2F220px-Marisa_Tomei_TIFF_2012.jpg'),
(14, 'Robert Downey Jr.', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F0%2F0a%2FRobert_Downey_Jr_avp_Iron_Man_3_Paris.jpg%2F220px-Robert_Downey_Jr_avp_Iron_Man_3_Paris.jpg'),
(15, 'Gal Gadot', 'http%3A%2F%2Ffr.web.img4.acsta.net%2Fr_1920_1080%2Fpictures%2F16%2F03%2F22%2F12%2F38%2F275927.jpg'),
(16, 'Chris Pine', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F8%2F83%2FChris_Pine_by_Gage_Skidmore.jpg%2F220px-Chris_Pine_by_Gage_Skidmore.jpg'),
(17, 'Connie Nielsen', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2Fe%2Fec%2FConnieNielsen09TIFF.jpg%2F220px-ConnieNielsen09TIFF.jpg'),
(23, 'Will Smith', 'https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F5%2F5c%2FWill_Smith_Cannes_2017.jpg%2F260px-Will_Smith_Cannes_2017.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `acteur_oeuvre`
--

CREATE TABLE `acteur_oeuvre` (
  `oeuvre_id` bigint(20) NOT NULL,
  `acteur_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `acteur_oeuvre`
--

INSERT INTO `acteur_oeuvre` (`oeuvre_id`, `acteur_id`) VALUES
(1, 1),
(1, 4),
(3, 6),
(3, 7),
(3, 8),
(3, 9),
(3, 10),
(5, 13),
(5, 14),
(5, 11),
(5, 12),
(6, 16),
(6, 17),
(6, 15),
(6, 3),
(7, 16),
(7, 17),
(7, 15),
(7, 3);

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `id` bigint(20) NOT NULL,
  `auteur_nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `auteur`
--

INSERT INTO `auteur` (`id`, `auteur_nom`) VALUES
(1, 'Jay Asher'),
(2, 'E.L. James'),
(3, 'Guillaume Musso');

-- --------------------------------------------------------

--
-- Structure de la table `auteur_oeuvre`
--

CREATE TABLE `auteur_oeuvre` (
  `oeuvre_id` bigint(20) NOT NULL,
  `auteur_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `auteur_oeuvre`
--

INSERT INTO `auteur_oeuvre` (`oeuvre_id`, `auteur_id`) VALUES
(2, 2),
(4, 3),
(8, 1);

-- --------------------------------------------------------

--
-- Structure de la table `download`
--

CREATE TABLE `download` (
  `id` bigint(20) NOT NULL,
  `date_de_commande` datetime NOT NULL,
  `date_de_telechargement` datetime DEFAULT NULL,
  `isdownload` bit(1) DEFAULT NULL,
  `isvalidate` bit(1) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `oeuvre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `editeur`
--

CREATE TABLE `editeur` (
  `id` bigint(20) NOT NULL,
  `editeur_nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `editeur`
--

INSERT INTO `editeur` (`id`, `editeur_nom`) VALUES
(1, 'Lgf'),
(2, 'Xo'),
(3, 'Ldp Jeunesse'),
(4, 'Albin Michel Jeunesse');

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL,
  `genre_nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `genre`
--

INSERT INTO `genre` (`id`, `genre_nom`) VALUES
(1, 'Comédie dramatique'),
(2, 'Romance'),
(3, 'Erotique'),
(4, 'Action'),
(5, 'Science Fiction'),
(6, 'Comédie'),
(7, 'Aventure'),
(8, 'Fantastique'),
(9, 'Drame');

-- --------------------------------------------------------

--
-- Structure de la table `genre_oeuvre`
--

CREATE TABLE `genre_oeuvre` (
  `oeuvre_id` bigint(20) NOT NULL,
  `genre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `genre_oeuvre`
--

INSERT INTO `genre_oeuvre` (`oeuvre_id`, `genre_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(3, 6),
(3, 5),
(4, 2),
(5, 4),
(5, 7),
(6, 4),
(6, 7),
(7, 4),
(7, 7),
(8, 9);

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

CREATE TABLE `oeuvre` (
  `discriminator` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `date_de_parution` date DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `resume` longtext,
  `titre` varchar(255) NOT NULL,
  `film_annonce` varchar(255) DEFAULT NULL,
  `film_duree` varchar(255) DEFAULT NULL,
  `livre_nbre_de_pages` int(11) DEFAULT NULL,
  `editeur_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `oeuvre`
--

INSERT INTO `oeuvre` (`discriminator`, `id`, `date_de_parution`, `image`, `resume`, `titre`, `film_annonce`, `film_duree`, `livre_nbre_de_pages`, `editeur_id`) VALUES
('F', 1, '1994-05-10', 'http%3A%2F%2Ffr.web.img4.acsta.net%2Fr_1920_1080%2Fpictures%2F15%2F10%2F13%2F15%2F12%2F514297.jpg', 'Quelques décennies d\'histoire américaine, des années 1940 à la fin du XXème siècle, à travers le regard et l\'étrange odyssée d\'un homme simple et pur, Forrest Gump.', 'FORREST GUMP', 'http%3A%2F%2Fwww.allocine.fr%2F_video%2Fiblogvision.aspx%3Fcmedia%3D19376882', '2h 20min', NULL, NULL),
('L', 2, '2014-02-04', 'http%3A%2F%2Fstatic.fnac-static.com%2Fmultimedia%2FImages%2FFR%2FNR%2F9d%2F8f%2F56%2F5672861%2F1507-1%2Ftsp20140305100037%2FCinquante-nuances-plus-claires.jpg', 'Ana et Christian ont tout pour être heureux : l\'amour, la fortune et un avenir plein de promesses. Ana apprend à vivre dans le monde fastueux de son M. Cinquante Nuances, sans perdre son intégrité ni son indépendance, tandis que Christian s\'efforce de se défaire de son obsession du contrôle et d\'oublier son terrible passé. Mais bientôt, alors que tout semble leur sourire, le destin les rattrape et leurs pires cauchemars deviennent réalité... Un happy end est-il possible pour Christian Grey et Anastasia Steele ? Romantique, libératrice et totalement addictive, la trilogie Fifty Shades, dont Cinquante nuances plus claires est le dernier volume, vous obsédera, vous possédera et vous marquera à jamais.', 'Fifty Shades - Tome 3 : Cinquante nuances plus claires', NULL, NULL, 600, 1),
('F', 3, '2019-02-04', 'http%3A%2F%2Ffr.web.img2.acsta.net%2Fr_1920_1080%2Fpictures%2F17%2F03%2F01%2F11%2F10%2F438835.jpg', 'Musicalement accompagné de la \"Awesome Mixtape n°2\" (la musique qu\'écoute Star-Lord dans le film), Les Gardiens de la galaxie 2 poursuit les aventures de l\'équipe alors qu\'elle traverse les confins du cosmos. Les gardiens doivent combattre pour rester unis alors qu\'ils découvrent les mystères de la filiation de Peter Quill. Les vieux ennemis vont devenir de nouveaux alliés et des personnages bien connus des fans de comics vont venir aider nos héros et continuer à étendre l\'univers Marvel.', 'LES GARDIENS DE LA GALAXIE 2', 'http%3A%2F%2Fwww.allocine.fr%2F_video%2Fiblogvision.aspx%3Fcmedia%3D19568905', '2h 16min', NULL, NULL),
('L', 4, '2019-06-03', 'http%3A%2F%2Fstatic.fnac-static.com%2Fmultimedia%2FImages%2FFR%2FNR%2F8c%2Ffb%2F81%2F8518540%2F1507-1.jpg', '« L\'art est un mensonge qui dit la vérité. »   Paris, un atelier d\'artiste caché au fond d\'une allée verdoyante. Madeline l\'a loué pour s\'y reposer et s\'isoler. À la suite d\'une méprise, cette jeune flic londonienne y voit débarquer Gaspard, un écrivain misanthrope venu des États-Unis pour écrire dans la solitude. Ces deux écorchés vifs sont contraints de cohabiter quelques jours.   L\'atelier a appartenu au célèbre peintre Sean Lorenz et respire encore sa passion des couleurs et de la lumière. Terrassé par l\'assassinat de son petit garçon, Lorenz est mort un an auparavant, laissant derrière lui trois tableaux, aujourd\'hui disparus. Fascinés par son génie, intrigués par son destin funeste, Madeline et Gaspard décident d\'unir leurs forces afin de retrouver ces toiles réputées extraordinaires.   Mais, pour percer le véritable secret de Sean Lorenz, ils vont devoir affronter leurs propres démons dans une enquête tragique qui les changera à jamais.     Guillaume Musso signe un thriller addictif et envoûtant porté par des personnages profondément humains. Une plongée vertigineuse dans le monde mystérieux de la création.   « Techniquement maîtrisé, narrativement efficace, ce page turner s\'inscrit dans la lignée de Harlan Coben et de Jesse Kellerman. » Michel Dufranne - RTBF   « Une intrigue qui vous tient en haleine jusqu\'à la dernière page. » Marina Carrère d\'Encausse - France 5', 'Un appartement à Paris', NULL, NULL, 484, 2),
('F', 5, '2017-12-07', 'http%3A%2F%2Ffr.web.img3.acsta.net%2Fr_1920_1080%2Fpictures%2F17%2F03%2F29%2F16%2F27%2F361551.jpg', 'Après ses spectaculaires débuts dans Captain America : Civil War, le jeune Peter Parker découvre peu à peu sa nouvelle identité, celle de Spider-Man, le super-héros lanceur de toile. Galvanisé par son expérience avec les Avengers, Peter rentre chez lui auprès de sa tante May, sous l’œil attentif de son nouveau mentor, Tony Stark. Il s’efforce de reprendre sa vie d’avant, mais au fond de lui, Peter rêve de se prouver qu’il est plus que le sympathique super héros du quartier. L’apparition d’un nouvel ennemi, le Vautour, va mettre en danger tout ce qui compte pour lui...', 'SPIDER-MAN: HOMECOMING', 'http%3A%2F%2Fwww.allocine.fr%2F_video%2Fiblogvision.aspx%3Fcmedia%3D19569522', 'ND', NULL, NULL),
('F', 6, '2017-07-06', 'http%3A%2F%2Ffr.web.img2.acsta.net%2Fr_1920_1080%2Fpictures%2F17%2F05%2F09%2F17%2F15%2F350974.jpg', 'C\'était avant qu\'elle ne devienne Wonder Woman, à l\'époque où elle était encore Diana, princesse des Amazones et combattante invincible. Un jour, un pilote américain s\'écrase sur l\'île paradisiaque où elle vit, à l\'abri des fracas du monde. Lorsqu\'il lui raconte qu\'une guerre terrible fait rage à l\'autre bout de la planète, Diana quitte son havre de paix, convaincue qu\'elle doit enrayer la menace. En s\'alliant aux hommes dans un combat destiné à mettre fin à la guerre, Diana découvrira toute l\'étendue de ses pouvoirs… et son véritable destin.', 'Wonder Woman', 'http%3A%2F%2Fwww.allocine.fr%2F_video%2Fiblogvision.aspx%3Fcmedia%3D19571367', '2h 21min', NULL, NULL),
('L', 8, '2017-06-09', 'http%3A%2F%2Ffr.web.img2.acsta.net%2Fpictures%2F17%2F01%2F26%2F10%2F06%2F400312.jpg', 'Clay Jensen reçoit sept cassettes enregistrées par Hannah Baker avant qu\'elle ne se suicide. Elle y parle de treize personnes qui ont, de près ou de loin, influé sur son geste. Et Clay en fait partie. D\'abord effrayé, Clay écoute la jeune fille en se promenant au son de sa voix dans la ville endormie. Puis, il découvre une Hannah inattendue qui lui dit à l\'oreille que la vie est dans les détails. Une phrase, un sourire, une méchanceté ou un baiser et tout peut basculer.', '13 Reasons Why', NULL, NULL, 200, 3);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `is_admin` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `password`, `username`, `is_admin`) VALUES
(6, 'ee11cbb19052e40b07aac0ca060c23ee', 'user', b'0'),
(8, 'd53a223dbb966570966c8b171c0adc1b', 'miage', b'1');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `acteur`
--
ALTER TABLE `acteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `acteur_oeuvre`
--
ALTER TABLE `acteur_oeuvre`
  ADD KEY `FK6sdhf7y4i0ffcfpityak2ff1c` (`acteur_id`),
  ADD KEY `FKtcnlslakji91oerpcx4soc0oj` (`oeuvre_id`);

--
-- Index pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `auteur_oeuvre`
--
ALTER TABLE `auteur_oeuvre`
  ADD KEY `FKcaw5d6tal3oo2ajuhkclg04o5` (`auteur_id`),
  ADD KEY `FK2r5yu45av5cuobonguwrcsj9g` (`oeuvre_id`);

--
-- Index pour la table `download`
--
ALTER TABLE `download`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo7cc91sofromqu0551ocgpn96` (`user_id`),
  ADD KEY `FKjp2md6eudgieymjyxxfa44crt` (`oeuvre_id`);

--
-- Index pour la table `editeur`
--
ALTER TABLE `editeur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `genre_oeuvre`
--
ALTER TABLE `genre_oeuvre`
  ADD KEY `FKgimci898dbk9ld5osc4kyujtg` (`genre_id`),
  ADD KEY `FKl2uinpii5xalt4c8ktbghys50` (`oeuvre_id`);

--
-- Index pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqkt2b0l1p1yq6tsvjqdwhg5n` (`editeur_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `acteur`
--
ALTER TABLE `acteur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT pour la table `auteur`
--
ALTER TABLE `auteur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `download`
--
ALTER TABLE `download`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `editeur`
--
ALTER TABLE `editeur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `acteur_oeuvre`
--
ALTER TABLE `acteur_oeuvre`
  ADD CONSTRAINT `FK6sdhf7y4i0ffcfpityak2ff1c` FOREIGN KEY (`acteur_id`) REFERENCES `acteur` (`id`),
  ADD CONSTRAINT `FKtcnlslakji91oerpcx4soc0oj` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`id`);

--
-- Contraintes pour la table `auteur_oeuvre`
--
ALTER TABLE `auteur_oeuvre`
  ADD CONSTRAINT `FK2r5yu45av5cuobonguwrcsj9g` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`id`),
  ADD CONSTRAINT `FKcaw5d6tal3oo2ajuhkclg04o5` FOREIGN KEY (`auteur_id`) REFERENCES `auteur` (`id`);

--
-- Contraintes pour la table `download`
--
ALTER TABLE `download`
  ADD CONSTRAINT `FKjp2md6eudgieymjyxxfa44crt` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`id`),
  ADD CONSTRAINT `FKo7cc91sofromqu0551ocgpn96` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `genre_oeuvre`
--
ALTER TABLE `genre_oeuvre`
  ADD CONSTRAINT `FKgimci898dbk9ld5osc4kyujtg` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  ADD CONSTRAINT `FKl2uinpii5xalt4c8ktbghys50` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`id`);

--
-- Contraintes pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD CONSTRAINT `FKqkt2b0l1p1yq6tsvjqdwhg5n` FOREIGN KEY (`editeur_id`) REFERENCES `editeur` (`id`);
