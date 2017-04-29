-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:8889
-- Généré le :  Dim 23 Avril 2017 à 03:26
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
  `acteur_photo` varchar(255) DEFAULT NULL,
  `acteur_prenom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `acteur_oeuvre`
--

CREATE TABLE `acteur_oeuvre` (
  `acteur_id` bigint(20) NOT NULL,
  `oeuvre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `id` bigint(20) NOT NULL,
  `auteur_nom` varchar(255) NOT NULL,
  `auteur_prenom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `auteur_oeuvre`
--

CREATE TABLE `auteur_oeuvre` (
  `oeuvre_id` bigint(20) NOT NULL,
  `auteur_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `download`
--

CREATE TABLE `download` (
  `id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `editeur`
--

CREATE TABLE `editeur` (
  `id` bigint(20) NOT NULL,
  `editeur_nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(1, 'Action'),
(2, 'Aventure'),
(3, 'Comédie'),
(4, 'Documentaire'),
(5, 'Drame'),
(6, 'Fantastique'),
(7, 'Guerre'),
(8, 'Horreur'),
(9, 'Manga'),
(10, 'Policier');

-- --------------------------------------------------------

--
-- Structure de la table `genre_oeuvre`
--

CREATE TABLE `genre_oeuvre` (
  `oeuvre_id` bigint(20) NOT NULL,
  `genre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

CREATE TABLE `oeuvre` (
  `discriminator` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `date_de_parution` date DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `film_annonce` varchar(255) DEFAULT NULL,
  `film_duree` varchar(255) DEFAULT NULL,
  `livre_nbre_de_pages` int(11) DEFAULT NULL,
  `editeur_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre_download`
--

CREATE TABLE `oeuvre_download` (
  `oeuvre_id` bigint(20) NOT NULL,
  `download_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `user_login` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `user_login`, `user_password`) VALUES
(1, 'test', 'test');

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
  ADD KEY `FKtcnlslakji91oerpcx4soc0oj` (`oeuvre_id`),
  ADD KEY `FK6sdhf7y4i0ffcfpityak2ff1c` (`acteur_id`);

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
-- Index pour la table `oeuvre_download`
--
ALTER TABLE `oeuvre_download`
  ADD KEY `FK5kdcfyo1chm8f1kt5ei89696j` (`download_id`),
  ADD KEY `FK4oms6wpp1l5i2dsee9thnis6m` (`oeuvre_id`);

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `auteur`
--
ALTER TABLE `auteur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `download`
--
ALTER TABLE `download`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `editeur`
--
ALTER TABLE `editeur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
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
-- Contraintes pour la table `oeuvre_download`
--
ALTER TABLE `oeuvre_download`
  ADD CONSTRAINT `FK4oms6wpp1l5i2dsee9thnis6m` FOREIGN KEY (`oeuvre_id`) REFERENCES `oeuvre` (`id`),
  ADD CONSTRAINT `FK5kdcfyo1chm8f1kt5ei89696j` FOREIGN KEY (`download_id`) REFERENCES `download` (`id`);
