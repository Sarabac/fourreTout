create table if not exists error_date(
    id INT AUTO_INCREMENT PRIMARY KEY,
    happened DATETIME DEFAULT CURRENT_TIMESTAMP
);