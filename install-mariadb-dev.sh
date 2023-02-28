
echo "###### Nettoyage environnement Mariadb"

systemctl stop mariadb;
systemctl disable mariadb;
apt remove mariadb-server mariadb-client -y;
userdel mysql;

echo "###### Installation Mariadb" 

apt update;
apt install mariadb-server mariadb-client -y;
rm -rf /var/lib/mysql;
mariadb-install-db --user=mysql --basedir=/usr --datadir=/var/lib/mysql; 
systemctl enable mariadb;
systemctl start mariadb;

echo "###### Inintialisation BDD Morpion"

mariadb -u root < init-morpion.sql;
