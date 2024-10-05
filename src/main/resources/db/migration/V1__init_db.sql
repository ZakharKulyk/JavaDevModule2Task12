CREATE TABLE clients
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE planets
(
    id   VARCHAR primary key,
    name VARCHAR
);

CREATE TABLE tickets
(
    id IDENTITY PRIMARY KEY,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id      BIGINT,
    from_planet_id VARCHAR,
    to_planet_id   VARCHAR

)

