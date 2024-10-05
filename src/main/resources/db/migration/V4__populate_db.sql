INSERT INTO clients (name) VALUES
                               ('John Doe'),
                               ('Jane Smith'),
                               ('Alice Johnson'),
                               ('Bob Brown'),
                               ('Charlie Black'),
                               ('Diana Prince'),
                               ('Ethan Hunt'),
                               ('Fiona Apple'),
                               ('George Clooney'),
                               ('Hannah Montana');


INSERT INTO planets (id, name) VALUES
                                   ('MARS', 'Mars'),
                                   ('VEN', 'Venus'),
                                   ('JUP', 'Jupiter'),
                                   ('SAT', 'Saturn'),
                                   ('EAR', 'Earth');


INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                              (CURRENT_TIMESTAMP, 1, 'MARS', 'VEN'),
                                                                              (CURRENT_TIMESTAMP, 2, 'VEN', 'JUP'),
                                                                              (CURRENT_TIMESTAMP, 3, 'JUP', 'SAT'),
                                                                              (CURRENT_TIMESTAMP, 4, 'SAT', 'EAR'),
                                                                              (CURRENT_TIMESTAMP, 5, 'EAR', 'MARS'),
                                                                              (CURRENT_TIMESTAMP, 6, 'MARS', 'JUP'),
                                                                              (CURRENT_TIMESTAMP, 7, 'VEN', 'SAT'),
                                                                              (CURRENT_TIMESTAMP, 8, 'JUP', 'EAR'),
                                                                              (CURRENT_TIMESTAMP, 9, 'SAT', 'MARS'),
                                                                              (CURRENT_TIMESTAMP, 10, 'EAR', 'VEN');