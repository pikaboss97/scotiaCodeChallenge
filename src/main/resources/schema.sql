CREATE TABLE IF NOT EXISTS student (
    id IDENTITY PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100),
    status VARCHAR(10) CHECK (status IN ('active', 'inactive')) NOT NULL,
    age INT
);