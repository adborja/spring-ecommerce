<<<<<<< HEAD
docker run --name mysql.cedesistemas.local -v /E/data/mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
=======
docker run --restart=unless-stopped --name mysql.cedesistemas.local -v /C/cedesistemas/data/mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
>>>>>>> base
