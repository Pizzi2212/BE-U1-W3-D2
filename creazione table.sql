CREATE TABLE Eventi (
 id SERIAL PRIMARY KEY,
 titolo VARCHAR(50) NOT NULL,
 data_evento DATE NOT NULL,
 descrizione TEXT NOT NULL,
 tipo_evento VARCHAR(10) NOT NULL,
 CHECK (tipo_evento IN ('pubblico','privato')),
 numero_max_partecipenti INTEGER NOT NULL
);
