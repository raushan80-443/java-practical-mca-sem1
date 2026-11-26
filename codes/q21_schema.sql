-- Q21: Login & Registration Web Application - MVC (Database Schema)
-- Question: Architect and implement a multi-page web application featuring Database Persistence, Servlets, JSP Views, and Session Management under the MVC architecture.

-- Create the database if it does not already exist and switch to it
CREATE DATABASE IF NOT EXISTS user_db;
USE user_db;

-- Users table storing login credentials and profile name
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,         -- Auto-incrementing unique user ID
    username VARCHAR(50) NOT NULL UNIQUE,      -- Unique login username
    password VARCHAR(255) NOT NULL,            -- User password
    full_name VARCHAR(100) NOT NULL,           -- User's display name
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Record creation timestamp
);
