CREATE TABLE IF NOT EXISTS assigned (
    id int not null AUTO_INCREMENT primary key,
    person_id int,
    role_id int,
    foreign key (person_id) references person(id),
    foreign key (role_id) references role(id)
);