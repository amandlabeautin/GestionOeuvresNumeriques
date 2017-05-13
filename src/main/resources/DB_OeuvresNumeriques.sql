-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:8889
-- Généré le :  Ven 12 Mai 2017 à 00:50
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
(1, 'Tom Hanks', NULL),
(2, 'Gary Sinise', NULL),
(3, 'Robin Wright', NULL),
(4, 'Mykelti Williamson', NULL),
(5, 'Sally Field', NULL),
(6, 'Chris Pratt', NULL),
(7, 'Zoe Saldana', NULL),
(8, 'Dave Bautista', NULL),
(9, 'Michael Rooker', NULL),
(10, 'Karen Gillan', NULL);

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
(3, 10);

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
(4, 3);

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
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `download`
--

INSERT INTO `download` (`id`, `date_de_commande`, `date_de_telechargement`, `isdownload`, `isvalidate`, `user_id`) VALUES
(1, '2017-05-12 00:15:41', NULL, b'0', b'0', 1),
(2, '2017-05-12 00:24:55', NULL, b'0', b'0', 1),
(3, '2017-05-12 00:38:33', NULL, b'0', b'0', 1),
(4, '2017-05-12 00:43:46', NULL, b'0', b'0', 1);

-- --------------------------------------------------------

--
-- Structure de la table `download_oeuvre`
--

CREATE TABLE `download_oeuvre` (
  `oeuvre_id` bigint(20) NOT NULL,
  `download_id` bigint(20) NOT NULL
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
(2, 'Xo');

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
(6, 'Comédie');

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
(4, 2);

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
('F', 1, '1994-05-10', 'http%3A%2F%2Ffr.web.img4.acsta.net%2Fr_1920_1080%2Fpictures%2F15%2F10%2F13%2F15%2F12%2F514297.jpg', 'Quelques décennies d\'histoire américaine, des années 1940 à la fin du XXème siècle, à travers le regard et l\'étrange odyssée d\'un homme simple et pur, Forrest Gump.', 'FORREST GUMP', 'http%3A%2F%2Fwww.allocine.fr%2Fvideo%2Fplayer_gen_cmedia%3D19376882%26cfilm%3D10568.html', '2h 20min', NULL, NULL),
('L', 2, '2014-02-04', 'http%3A%2F%2Fstatic.fnac-static.com%2Fmultimedia%2FImages%2FFR%2FNR%2F9d%2F8f%2F56%2F5672861%2F1507-1%2Ftsp20140305100037%2FCinquante-nuances-plus-claires.jpg', 'Ana et Christian ont tout pour être heureux : l\'amour, la fortune et un avenir plein de promesses. Ana apprend à vivre dans le monde fastueux de son M. Cinquante Nuances, sans perdre son intégrité ni son indépendance, tandis que Christian s\'efforce de se défaire de son obsession du contrôle et d\'oublier son terrible passé. Mais bientôt, alors que tout semble leur sourire, le destin les rattrape et leurs pires cauchemars deviennent réalité... Un happy end est-il possible pour Christian Grey et Anastasia Steele ? Romantique, libératrice et totalement addictive, la trilogie Fifty Shades, dont Cinquante nuances plus claires est le dernier volume, vous obsédera, vous possédera et vous marquera à jamais.', 'Fifty Shades - Tome 3 : Cinquante nuances plus claires', NULL, NULL, 600, 1),
('F', 3, '2019-02-04', 'http%3A%2F%2Ffr.web.img2.acsta.net%2Fr_1920_1080%2Fpictures%2F17%2F03%2F01%2F11%2F10%2F438835.jpg', 'Musicalement accompagné de la \"Awesome Mixtape n°2\" (la musique qu\'écoute Star-Lord dans le film), Les Gardiens de la galaxie 2 poursuit les aventures de l\'équipe alors qu\'elle traverse les confins du cosmos. Les gardiens doivent combattre pour rester unis alors qu\'ils découvrent les mystères de la filiation de Peter Quill. Les vieux ennemis vont devenir de nouveaux alliés et des personnages bien connus des fans de comics vont venir aider nos héros et continuer à étendre l\'univers Marvel.', 'LES GARDIENS DE LA GALAXIE 2', 'http%3A%2F%2Fwww.allocine.fr%2Fvideo%2Fplayer_gen_cmedia%3D19568905%26cfilm%3D226995.html', '2h 16min', NULL, NULL),
('L', 4, '2019-06-03', 'http%3A%2F%2Fstatic.fnac-static.com%2Fmultimedia%2FImages%2FFR%2FNR%2F8c%2Ffb%2F81%2F8518540%2F1507-1.jpg', '« L\'art est un mensonge qui dit la vérité. »   Paris, un atelier d\'artiste caché au fond d\'une allée verdoyante. Madeline l\'a loué pour s\'y reposer et s\'isoler. À la suite d\'une méprise, cette jeune flic londonienne y voit débarquer Gaspard, un écrivain misanthrope venu des États-Unis pour écrire dans la solitude. Ces deux écorchés vifs sont contraints de cohabiter quelques jours.   L\'atelier a appartenu au célèbre peintre Sean Lorenz et respire encore sa passion des couleurs et de la lumière. Terrassé par l\'assassinat de son petit garçon, Lorenz est mort un an auparavant, laissant derrière lui trois tableaux, aujourd\'hui disparus. Fascinés par son génie, intrigués par son destin funeste, Madeline et Gaspard décident d\'unir leurs forces afin de retrouver ces toiles réputées extraordinaires.   Mais, pour percer le véritable secret de Sean Lorenz, ils vont devoir affronter leurs propres démons dans une enquête tragique qui les changera à jamais.     Guillaume Musso signe un thriller addictif et envoûtant porté par des personnages profondément humains. Une plongée vertigineuse dans le monde mystérieux de la création.   « Techniquement maîtrisé, narrativement efficace, ce page turner s\'inscrit dans la lignée de Harlan Coben et de Jesse Kellerman. » Michel Dufranne - RTBF   « Une intrigue qui vous tient en haleine jusqu\'à la dernière page. » Marina Carrère d\'Encausse - France 5', 'Un appartement à Paris', NULL, NULL, 484, 2);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, 'test', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 2);

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
  ADD KEY `FKo7cc91sofromqu0551ocgpn96` (`user_id`);

--
-- Index pour la table `download_oeuvre`
--
ALTER TABLE `download_oeuvre`
  ADD KEY `FK7hggjqt67flmm556g9ob579g7` (`download_id`),
  ADD KEY `FKpct5bjh8p0aae5fg3mbecbp7i` (`oeuvre_id`);

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
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`),
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `acteur`
--
ALTER TABLE `acteur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `auteur`
--
ALTER TABLE `auteur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `download`
--
ALTER TABLE `download`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `editeur`
--
ALTER TABLE `editeur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
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
  ADD CONSTRAINT `FKo7cc91sofromqu0551ocgpn96` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `download_oeuvre`
--
ALTER TABLE `download_oeuvre`
  ADD CONSTRAINT `FK7hggjqt67flmm556g9ob579g7` FOREIGN KEY (`download_id`) REFERENCES `download` (`id`),
  ADD CONSTRAINT `FKpct5bjh8p0aae5fg3mbecbp7i` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`id`);

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

--
-- Contraintes pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
