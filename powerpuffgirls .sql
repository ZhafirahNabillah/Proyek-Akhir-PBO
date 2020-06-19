-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Jun 2020 pada 13.22
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `powerpuffgirls`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `IdAdmin` int(11) NOT NULL,
  `NamaLengkap` varchar(30) NOT NULL,
  `Username` varchar(16) NOT NULL,
  `Password` varchar(8) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `NoHP` varchar(13) NOT NULL,
  `TanggalLahir` date NOT NULL,
  `IdPsikolog` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`IdAdmin`, `NamaLengkap`, `Username`, `Password`, `Email`, `NoHP`, `TanggalLahir`, `IdPsikolog`) VALUES
(1, 'Admin Rumah Teduh', 'Admin', 'admin123', 'rumahteduh@gmail.com', '0338-333', '2020-06-17', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `artikel`
--

CREATE TABLE `artikel` (
  `IdArtikel` int(11) NOT NULL,
  `NamaPenerbit` varchar(30) NOT NULL,
  `KotaPenerbit` varchar(16) NOT NULL,
  `TanggalTerbit` date NOT NULL,
  `JudulArtikel` varchar(50) NOT NULL,
  `IsiArtikel` text NOT NULL,
  `IdAdmin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `artikel`
--

INSERT INTO `artikel` (`IdArtikel`, `NamaPenerbit`, `KotaPenerbit`, `TanggalTerbit`, `JudulArtikel`, `IsiArtikel`, `IdAdmin`) VALUES
(1, 'aa', 'aa', '2020-06-01', 'aaa', 'aaaaa', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `curhat`
--

CREATE TABLE `curhat` (
  `IdCurhat` int(11) NOT NULL,
  `NamaLengkap` varchar(50) NOT NULL,
  `TanggalLahir` date NOT NULL,
  `Usia` varchar(2) NOT NULL,
  `NoHP` varchar(13) NOT NULL,
  `IsiCurhat` text NOT NULL,
  `IdUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `laporan`
--

CREATE TABLE `laporan` (
  `IdLaporan` int(11) NOT NULL,
  `NamaLengkap` varchar(50) NOT NULL,
  `TanggalKejadian` date NOT NULL,
  `AlamatLengkap` varchar(40) NOT NULL,
  `NoHandphone` varchar(13) NOT NULL,
  `Kronologi` text NOT NULL,
  `IdUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `postingan`
--

CREATE TABLE `postingan` (
  `IdPostingan` int(11) NOT NULL,
  `NamaLengkap` varchar(50) NOT NULL,
  `Username` varchar(16) NOT NULL,
  `IsiPostingan` text NOT NULL,
  `TanggalPosting` date NOT NULL,
  `StatusPostingan` varchar(30) NOT NULL,
  `IdUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `postingan`
--

INSERT INTO `postingan` (`IdPostingan`, `NamaLengkap`, `Username`, `IsiPostingan`, `TanggalPosting`, `StatusPostingan`, `IdUser`) VALUES
(1, 'Yuhuuu bisaaa YUhuuu', 'maya', 'aaaaaaaaaaaaaaaaaaaaaaaa', '2020-06-04', 'Diterima', 1),
(2, 'Yuhuuu bisaaa YUhuuu', 'maya', 'aaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbb', '2020-06-04', 'Ditolak', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `psikolog`
--

CREATE TABLE `psikolog` (
  `IdPsikolog` int(11) NOT NULL,
  `NamaLengkap` varchar(50) NOT NULL,
  `Username` varchar(16) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `NoHp` varchar(13) NOT NULL,
  `TanggalLahir` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `psikolog`
--

INSERT INTO `psikolog` (`IdPsikolog`, `NamaLengkap`, `Username`, `Password`, `Email`, `NoHp`, `TanggalLahir`) VALUES
(1, 'Psikolog', 'psikolog', 'psikolog', 'obdvjhnkz', '0992346728348', '2020-06-10');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `IdUser` int(11) NOT NULL,
  `NamaLengkap` varchar(30) NOT NULL,
  `Username` varchar(16) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `NoHP` varchar(13) NOT NULL,
  `TanggalLahir` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`IdUser`, `NamaLengkap`, `Username`, `Password`, `Email`, `NoHP`, `TanggalLahir`) VALUES
(1, 'Yuhuuu bisaaa YUhuuu', 'maya', 'maya06', 'dewichantika@gmail.com', '12345678', '2020-06-01');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`IdAdmin`),
  ADD KEY `IdPsikolog` (`IdPsikolog`);

--
-- Indeks untuk tabel `artikel`
--
ALTER TABLE `artikel`
  ADD PRIMARY KEY (`IdArtikel`),
  ADD KEY `IdAdmin` (`IdAdmin`);

--
-- Indeks untuk tabel `curhat`
--
ALTER TABLE `curhat`
  ADD PRIMARY KEY (`IdCurhat`),
  ADD KEY `IdUser` (`IdUser`);

--
-- Indeks untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`IdLaporan`),
  ADD KEY `IdUser` (`IdUser`);

--
-- Indeks untuk tabel `postingan`
--
ALTER TABLE `postingan`
  ADD PRIMARY KEY (`IdPostingan`),
  ADD KEY `IdUser` (`IdUser`);

--
-- Indeks untuk tabel `psikolog`
--
ALTER TABLE `psikolog`
  ADD PRIMARY KEY (`IdPsikolog`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`IdUser`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `IdAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `artikel`
--
ALTER TABLE `artikel`
  MODIFY `IdArtikel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `curhat`
--
ALTER TABLE `curhat`
  MODIFY `IdCurhat` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `laporan`
--
ALTER TABLE `laporan`
  MODIFY `IdLaporan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `postingan`
--
ALTER TABLE `postingan`
  MODIFY `IdPostingan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `psikolog`
--
ALTER TABLE `psikolog`
  MODIFY `IdPsikolog` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `IdUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`IdPsikolog`) REFERENCES `psikolog` (`IdPsikolog`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `artikel`
--
ALTER TABLE `artikel`
  ADD CONSTRAINT `artikel_ibfk_1` FOREIGN KEY (`IdAdmin`) REFERENCES `admin` (`IdAdmin`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `curhat`
--
ALTER TABLE `curhat`
  ADD CONSTRAINT `curhat_ibfk_1` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD CONSTRAINT `laporan_ibfk_1` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `postingan`
--
ALTER TABLE `postingan`
  ADD CONSTRAINT `postingan_ibfk_1` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
