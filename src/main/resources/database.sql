-- Create tables
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

CREATE TABLE evaluations (
    id VARCHAR(50) PRIMARY KEY,
    type_eval VARCHAR(20) NOT NULL, -- EXAMEN, DEVOIR
    poids FLOAT DEFAULT 1.0,        -- ex: 0.4 pour 40%
    matiere_id VARCHAR(50) REFERENCES matieres(id) ON DELETE CASCADE
);

CREATE TABLE matieres (
    id VARCHAR(50) PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    libelle VARCHAR(100) NOT NULL,
    coefficient INT DEFAULT 1,
    description TEXT
);

CREATE TABLE notes (
    id VARCHAR(50) PRIMARY KEY,
    valeur DECIMAL(4,2) CHECK (valeur >= 0 AND valeur <= 20),
    commentaire TEXT,
    date_saisie TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    etudiant_id VARCHAR(50) REFERENCES etudiants(id) ON DELETE CASCADE,
    evaluation_id VARCHAR(50) REFERENCES evaluations(id) ON DELETE CASCADE
);

-- Insert dummy data
INSERT INTO etudiants (id, matricule, nom, prenom, date_naissance, email, telephone, date_inscription, statut)
VALUES ('1', '2024001', 'Doe', 'John', '2000-01-01', 'john.doe@example.com', '123456789', NOW(), 'ACTIF')
ON CONFLICT (matricule) DO NOTHING;


INSERT INTO matieres (id, code, libelle, coefficient, description)
VALUES ('2', '2024-SQL', 'DataBase and SQL', 3, 'Cour de sur la modelisation des bases de donnees les bases au concept avancer')
ON CONFLICT (id) DO NOTHING;

INSERT INTO evaluations (id, type_eval, poids, matiere_id)
VALUES ('1', 'EXAMEN', 0.4, '2')
ON CONFLICT (id) DO NOTHING;

INSERT INTO notes (id, valeur, commentaire, date_saisie, etudiant_id, evaluation_id)
VALUES ('1', 15.5, 'Bon travail', '2024-01-20', '1', '1'),
       ('2', 12.0, 'Peut mieux faire', '2024-02-10', '1', '1')
INSERT INTO notes (id, valeur, commentaire, date_saisie, etudiant_id, evaluation_id)
VALUES ('3', 14.5, 'Bon travail', '2024-01-20', '2', '1'),
       ('4', 17.0, 'Tres bon travail', '2024-02-10', '2', '1')
ON CONFLICT (id) DO NOTHING;
