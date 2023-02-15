-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 16 fév. 2023 à 00:05
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `esprit`
--

-- --------------------------------------------------------

--
-- Structure de la table `colis`
--

CREATE TABLE `colis` (
  `id` int(11) NOT NULL,
  `nb_items` int(11) NOT NULL,
  `description` varchar(250) NOT NULL,
  `poids` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `colis`
--

INSERT INTO `colis` (`id`, `nb_items`, `description`, `poids`) VALUES
(2, 1, 'pp', 5);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `cin1` varchar(10) NOT NULL,
  `cin2` varchar(10) NOT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `conducteur`
--

CREATE TABLE `conducteur` (
  `cin` varchar(10) NOT NULL,
  `permis` mediumblob NOT NULL,
  `b3` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
  `id_course` int(11) NOT NULL,
  `point_depart` varchar(255) NOT NULL,
  `point_destination` varchar(255) NOT NULL,
  `distance` float NOT NULL,
  `prix` float NOT NULL,
  `statut_course` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `course`
--

INSERT INTO `course` (`id_course`, `point_depart`, `point_destination`, `distance`, `prix`, `statut_course`) VALUES
(1, 'Tunis', 'Ariana', 2, 10, 'en cours'),
(2, 'bardo', 'm5', 5, 15, 'termine');

-- --------------------------------------------------------

--
-- Structure de la table `livraisons`
--

CREATE TABLE `livraisons` (
  `id` int(11) NOT NULL,
  `adresse_expedition` varchar(250) NOT NULL,
  `adresse_destinataire` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `livraisons`
--

INSERT INTO `livraisons` (`id`, `adresse_expedition`, `adresse_destinataire`) VALUES
(1, 'Boumhal', 'Ariana'),
(2, 'ccc', 'xxx');

-- --------------------------------------------------------

--
-- Structure de la table `offre_course`
--

CREATE TABLE `offre_course` (
  `id_offre` int(11) NOT NULL,
  `matricule_vehicule` int(11) NOT NULL,
  `cin_conducteur` int(11) NOT NULL,
  `nb_passagers` int(11) NOT NULL,
  `options_offre` varchar(255) NOT NULL,
  `statut_offre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `offre_course`
--

INSERT INTO `offre_course` (`id_offre`, `matricule_vehicule`, `cin_conducteur`, `nb_passagers`, `options_offre`, `statut_offre`) VALUES
(1, 111, 1111, 11, 'NC', 'actif');

-- --------------------------------------------------------

--
-- Structure de la table `offre_livraison`
--

CREATE TABLE `offre_livraison` (
  `id` int(11) NOT NULL,
  `prix_livraison` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `offre_livraison`
--

INSERT INTO `offre_livraison` (`id`, `prix_livraison`) VALUES
(1, 6.3);

-- --------------------------------------------------------

--
-- Structure de la table `personnes`
--

CREATE TABLE `personnes` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id` int(11) NOT NULL,
  `message` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `cinAdmin` varchar(10) NOT NULL,
  `cinUser` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `cin` varchar(10) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `num_tel` varchar(20) NOT NULL,
  `role` varchar(30) NOT NULL,
  `evaluation` float(2,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`cin`, `nom`, `prenom`, `mail`, `mdp`, `num_tel`, `role`, `evaluation`) VALUES
('1323566', 'abir', 'kh', 'abir@gmail.com', 'abir', '26578467', 'client', 0.0);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `immatriculation` varchar(30) NOT NULL,
  `modele` varchar(30) NOT NULL,
  `marque` varchar(30) NOT NULL,
  `etat` varchar(20) NOT NULL,
  `photo` mediumblob NOT NULL,
  `cin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `colis`
--
ALTER TABLE `colis`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`cin1`,`cin2`),
  ADD KEY `fk_utilisateur_commentaire2` (`cin2`);

--
-- Index pour la table `conducteur`
--
ALTER TABLE `conducteur`
  ADD PRIMARY KEY (`cin`);

--
-- Index pour la table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id_course`);

--
-- Index pour la table `livraisons`
--
ALTER TABLE `livraisons`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `offre_course`
--
ALTER TABLE `offre_course`
  ADD PRIMARY KEY (`id_offre`);

--
-- Index pour la table `offre_livraison`
--
ALTER TABLE `offre_livraison`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personnes`
--
ALTER TABLE `personnes`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_utilisateur_reclamation1` (`cinAdmin`),
  ADD KEY `fk_utilisateur_reclamation2` (`cinUser`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`cin`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`immatriculation`),
  ADD KEY `fk_utilisateur_vehicule` (`cin`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `colis`
--
ALTER TABLE `colis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `livraisons`
--
ALTER TABLE `livraisons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `offre_livraison`
--
ALTER TABLE `offre_livraison`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `personnes`
--
ALTER TABLE `personnes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_utilisateur_commentaire1` FOREIGN KEY (`cin1`) REFERENCES `utilisateur` (`cin`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_utilisateur_commentaire2` FOREIGN KEY (`cin2`) REFERENCES `utilisateur` (`cin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `conducteur`
--
ALTER TABLE `conducteur`
  ADD CONSTRAINT `fk_utilisateur_conducteur` FOREIGN KEY (`cin`) REFERENCES `utilisateur` (`cin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `fk_utilisateur_reclamation1` FOREIGN KEY (`cinAdmin`) REFERENCES `utilisateur` (`cin`),
  ADD CONSTRAINT `fk_utilisateur_reclamation2` FOREIGN KEY (`cinUser`) REFERENCES `utilisateur` (`cin`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `fk_utilisateur_vehicule` FOREIGN KEY (`cin`) REFERENCES `utilisateur` (`cin`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
