

echo "###### Nettoyage environnement Mariadb"

systemctl stop mariadb;
systemctl disable mariadb;
pacman -R mariadb;
userdel mysql;

echo "###### Installation Mariadb" 

pacman -Sy mariadb;
rm -rf /var/lib/mysql;
mariadb-install-db --user=mysql --basedir=/usr --datadir=/var/lib/mysql; 
systemctl enable mariadb;
systemctl start mariadb;

echo "###### Inintialisation BDD Morpion"

mariadb -u root < init-morpion.sql;
