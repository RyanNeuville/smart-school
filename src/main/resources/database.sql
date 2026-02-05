-- Create tables
CREATE TABLE IF NOT EXISTS etudiant (
    id VARCHAR(50) PRIMARY KEY,
    matricule VARCHAR(20) UNIQUE NOT NULL,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    date_naissance DATE,
    email VARCHAR(100),
    telephone VARCHAR(20),
    date_inscription TIMESTAMP,
    statut VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS evaluation (
    id VARCHAR(50) PRIMARY KEY,
    matiere VARCHAR(50),
    date_examen DATE,
    coefficient INT
);

CREATE TABLE IF NOT EXISTS note (
    id VARCHAR(50) PRIMARY KEY,
    valeur DOUBLE PRECISION,
    commentaire TEXT,
    date_saisie DATE,
    etudiant_id VARCHAR(50) REFERENCES etudiant(id),
    evaluation_id VARCHAR(50) REFERENCES evaluation(id)
);

-- Insert dummy data
INSERT INTO etudiants (id, matricule, nom, prenom, date_naissance, email, telephone, date_inscription, statut)
VALUES ('1', '2024001', 'Doe', 'John', '2000-01-01', 'john.doe@example.com', '123456789', NOW(), 'ACTIF')
ON CONFLICT (matricule) DO NOTHING;

INSERT INTO evaluations (id, matiere, date_examen, coefficient)
VALUES ('1', 'Java Programming', '2024-01-15', 3)
ON CONFLICT (id) DO NOTHING;

INSERT INTO notes (id, valeur, commentaire, date_saisie, etudiant_id, evaluation_id)
VALUES ('1', 15.5, 'Bon travail', '2024-01-20', '1', '1'),
       ('2', 12.0, 'Peut mieux faire', '2024-02-10', '1', '1')
ON CONFLICT (id) DO NOTHING;
