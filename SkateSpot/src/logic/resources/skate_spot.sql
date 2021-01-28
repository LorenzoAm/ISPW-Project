-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 28, 2021 alle 18:27
-- Versione del server: 10.4.17-MariaDB
-- Versione PHP: 8.0.0

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
  `PartitaIVA` varchar(11) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Descrizione` varchar(200) NOT NULL,
  `Immagine` varchar(50) DEFAULT NULL,
  `Citta` varchar(30) NOT NULL,
  `Via` varchar(30) NOT NULL,
  `Civico` int(4) NOT NULL,
  `Comune` varchar(30) NOT NULL,
  `Zona` varchar(30) NOT NULL,
  `CodiceProprietario` int(11) NOT NULL,
  `DataInserimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `shop`
--

INSERT INTO `shop` (`Codice`, `PartitaIVA`, `Nome`, `Descrizione`, `Immagine`, `Citta`, `Via`, `Civico`, `Comune`, `Zona`, `CodiceProprietario`, `DataInserimento`) VALUES
(1, '12345678901', 'random', 'random description', 'NULL', 'Roma', 'random street', 17, 'random municipality', 'random area', 3, '2021-01-28');

-- --------------------------------------------------------

--
-- Struttura della tabella `spot`
--

CREATE TABLE `spot` (
  `Codice` int(11) NOT NULL,
  `Via` varchar(30) NOT NULL,
  `Civico` int(4) NOT NULL,
  `Citta` varchar(30) NOT NULL,
  `Zona` varchar(30) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Comune` varchar(30) NOT NULL,
  `NumeroDiSkater` int(2) NOT NULL,
  `Descrizione` varchar(200) NOT NULL,
  `Immagine` varchar(50) DEFAULT NULL,
  `Rating` int(1) NOT NULL,
  `CodiceSkater` int(11) NOT NULL,
  `DataInserimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `spot`
--

INSERT INTO `spot` (`Codice`, `Via`, `Civico`, `Citta`, `Zona`, `Nome`, `Tipo`, `Comune`, `NumeroDiSkater`, `Descrizione`, `Immagine`, `Rating`, `CodiceSkater`, `DataInserimento`) VALUES
(1, 'via Libero Leonardi', 106, 'Roma', 'Cinecittà', 'Cinetown', 'skatepark ', 'Roma', 10, 'Skatepark comunale all\'aperto dotato di muretti, mini ramp, bowl, due funbox, scale e diversi rail.', NULL, 5, 3, '2021-01-24'),
(2, 'random street', 17, 'random city', 'random area', 'random spot', 'random street', 'random municipality', 0, '17', '', 0, 3, '2021-01-28'),
(3, 'via', 15, 'città', 'area', 'nome', 'via', 'comune', 0, '15', 'NULL', 0, 3, '2021-01-28');

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
(3, 'lorenzoamoretti@gmail.com', 'LorenzAm', 'password', 'Lorenzo', 'Amoretti', '1999-06-09', 'M', 'Owner', NULL, 1),
(4, 'lolemasa@alice.it', 'Ukass99', 'Ukass_99', 'Lorenzo', 'Amoretti', '1999-01-09', 'M', 'Owner', NULL, NULL),
(5, 'mariorossi@gmail.com', 'MR2020', 'password', 'Mario', 'Rossi', '1999-01-20', 'M', 'Owner', NULL, NULL);

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
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `spot`
--
ALTER TABLE `spot`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
