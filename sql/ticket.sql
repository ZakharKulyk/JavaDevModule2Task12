CREATE  TABLE tickets(
    id IDENTITY PRIMARY KEY,
    created_at TIMESTAMP,
    client_id BIGINT,
    from_planet_id VARCHAR,
    to_planet_id VARCHAR

)