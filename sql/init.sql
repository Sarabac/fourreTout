create schema if not exists monitor;

use monitor;


create table if not exists error_date(
    id INT AUTO_INCREMENT PRIMARY KEY,
    happened DATE
);