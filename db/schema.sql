CREATE TABLE post (
   id SERIAL PRIMARY KEY,
   name VARCHAR(100),
   description VARCHAR(255),
   created VARCHAR(100)
);

CREATE TABLE candidate (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100)
);
