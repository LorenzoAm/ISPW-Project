-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 10, 2021 alle 14:20
-- Versione del server: 10.4.14-MariaDB
-- Versione PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `skate_spot`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `articolo`
--

CREATE TABLE `articolo` (
  `Codice` int(11) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Marca` varchar(30) NOT NULL,
  `Descrizione` varchar(200) NOT NULL,
  `Immagine` varchar(50) DEFAULT NULL,
  `Prezzo` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `includere`
--

CREATE TABLE `includere` (
  `CodiceShop` int(11) NOT NULL,
  `CodiceProd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `recensione`
--

CREATE TABLE `recensione` (
  `Codice` int(11) NOT NULL,
  `Descrizione` varchar(200) NOT NULL,
  `Rating` int(1) NOT NULL,
  `CodiceSkater` int(11) NOT NULL,
  `Data` date NOT NULL,
  `CodiceSpot` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `shop`
--

CREATE TABLE `shop` (
  `Codice` int(11) NOT NULL,
  `PartitaIVA` int(11) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Descrizione` varchar(200) NOT NULL,
  `Immagine` varchar(50) DEFAULT NULL,
  `Città` varchar(30) NOT NULL,
  `Via` varchar(30) NOT NULL,
  `Civico` int(4) NOT NULL,
  `Comune` varchar(30) NOT NULL,
  `Zona` varchar(30) NOT NULL,
  `CodiceProprietario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `spot`
--

CREATE TABLE `spot` (
  `Codice` int(11) NOT NULL,
  `Via` varchar(30) NOT NULL,
  `Civico` int(4) NOT NULL,
  `Città` varchar(30) NOT NULL,
  `Zona` varchar(30) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Tipo` varchar(10) NOT NULL,
  `Comune` varchar(30) NOT NULL,
  `NumeroDiSkater` int(2) NOT NULL,
  `Descrizione` varchar(200) NOT NULL,
  `Immagine` varchar(50) DEFAULT NULL,
  `Rating` int(1) NOT NULL,
  `CodiceSkater` int(11) NOT NULL,
  `Data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `Codice` int(11) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Cognome` varchar(30) NOT NULL,
  `DataDiNascita` date NOT NULL,
  `Sesso` varchar(1) NOT NULL,
  `Tipo` varchar(10) NOT NULL,
  `Immagine` varchar(50) DEFAULT NULL,
  `CodiceSpot` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`Codice`, `Email`, `Username`, `Password`, `Nome`, `Cognome`, `DataDiNascita`, `Sesso`, `Tipo`, `Immagine`, `CodiceSpot`) VALUES
(1, 'lorenzoamoretti@gmail.com', 'LorenzAm', 'password', 'Lorenzo', 'Amoretti', '1999-06-09', 'M', 'premium', NULL, NULL),
(2, 'peter92@gmail.com', 'Spiderman', 'password', 'Peter', 'Parker', '1992-05-12', 'M', 'base', NULL, NULL);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `articolo`
--
ALTER TABLE `articolo`
  ADD PRIMARY KEY (`Codice`),
  ADD UNIQUE KEY `Nome` (`Nome`);

--
-- Indici per le tabelle `includere`
--
ALTER TABLE `includere`
  ADD KEY `CodiceShop` (`CodiceShop`),
  ADD KEY `CodiceProd` (`CodiceProd`);

--
-- Indici per le tabelle `recensione`
--
ALTER TABLE `recensione`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `CodiceSkater` (`CodiceSkater`),
  ADD KEY `CodiceSpot` (`CodiceSpot`);

--
-- Indici per le tabelle `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`Codice`),
  ADD UNIQUE KEY `PartitaIVA` (`PartitaIVA`),
  ADD UNIQUE KEY `Via` (`Via`,`Civico`),
  ADD UNIQUE KEY `Nome` (`Nome`),
  ADD KEY `CodiceProprietario` (`CodiceProprietario`);

--
-- Indici per le tabelle `spot`
--
ALTER TABLE `spot`
  ADD PRIMARY KEY (`Codice`),
  ADD UNIQUE KEY `Via` (`Via`,`Civico`),
  ADD KEY `CodiceSkater` (`CodiceSkater`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`Codice`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD KEY `CodiceSpot` (`CodiceSpot`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `articolo`
--
ALTER TABLE `articolo`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `recensione`
--
ALTER TABLE `recensione`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `shop`
--
ALTER TABLE `shop`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `spot`
--
ALTER TABLE `spot`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `includere`
--
ALTER TABLE `includere`
  ADD CONSTRAINT `includere_ibfk_1` FOREIGN KEY (`CodiceShop`) REFERENCES `shop` (`Codice`),
  ADD CONSTRAINT `includere_ibfk_2` FOREIGN KEY (`CodiceProd`) REFERENCES `articolo` (`Codice`);

--
-- Limiti per la tabella `recensione`
--
ALTER TABLE `recensione`
  ADD CONSTRAINT `recensione_ibfk_1` FOREIGN KEY (`CodiceSkater`) REFERENCES `utente` (`Codice`),
  ADD CONSTRAINT `recensione_ibfk_2` FOREIGN KEY (`CodiceSpot`) REFERENCES `spot` (`Codice`);

--
-- Limiti per la tabella `shop`
--
ALTER TABLE `shop`
  ADD CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`CodiceProprietario`) REFERENCES `utente` (`Codice`);

--
-- Limiti per la tabella `spot`
--
ALTER TABLE `spot`
  ADD CONSTRAINT `spot_ibfk_1` FOREIGN KEY (`CodiceSkater`) REFERENCES `utente` (`Codice`);

--
-- Limiti per la tabella `utente`
--
ALTER TABLE `utente`
  ADD CONSTRAINT `utente_ibfk_1` FOREIGN KEY (`CodiceSpot`) REFERENCES `spot` (`Codice`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;