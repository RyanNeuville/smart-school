-- Suppression des tables si elles existent (pour le développement)
DROP TABLE IF EXISTS notes;
DROP TABLE IF EXISTS evaluations;
DROP TABLE IF EXISTS matieres;
DROP TABLE IF EXISTS etudiants;

-- Table Étudiants
CREATE TABLE etudiants (
    id VARCHAR(50) PRIMARY KEY,
    matricule VARCHAR(20) UNIQUE NOT NULL,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    date_naissance DATE,
    email VARCHAR(100) UNIQUE,
    telephone VARCHAR(20) NOT NULL,
    date_inscription TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    statut VARCHAR(20) DEFAULT 'ACTIF'
);

-- Table Matières
CREATE TABLE matieres (
    id VARCHAR(50) PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    libelle VARCHAR(100) NOT NULL,
    coefficient INT DEFAULT 1,
    description TEXT
);

-- Table Evaluations (Devoir, Examen, etc.)
CREATE TABLE evaluations (
    id VARCHAR(50) PRIMARY KEY,
    type_eval VARCHAR(20) NOT NULL, -- EXAMEN, DEVOIR
    poids FLOAT DEFAULT 1.0,        -- ex: 0.4 pour 40%
    matiere_id VARCHAR(50) REFERENCES matieres(id) ON DELETE CASCADE
);

-- Table Notes
CREATE TABLE notes (
    id VARCHAR(50) PRIMARY KEY,
    valeur DECIMAL(4,2) CHECK (valeur >= 0 AND valeur <= 20),
    commentaire TEXT,
    date_saisie TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    etudiant_id VARCHAR(50) REFERENCES etudiants(id) ON DELETE CASCADE,
    evaluation_id VARCHAR(50) REFERENCES evaluations(id) ON DELETE CASCADE
);