
CREATE DATABASE IF NOT EXISTS passiton;
USE passiton;

CREATE TABLE IF NOT EXISTS resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    resource_type VARCHAR(20) NOT NULL DEFAULT 'General',
    title VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    description TEXT,
    sharing_type VARCHAR(20) NOT NULL,
    condition_status VARCHAR(30),
    owner_name VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'Available',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
