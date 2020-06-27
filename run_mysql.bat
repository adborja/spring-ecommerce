docker run --name mysql.cedesistemas.local -v /home/docker/data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7

docker run --name mysql.cedesistemas.local -v /C/data/mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7

docker run --name mysql.cedesistemas.local -v /c/Users/CarlosR/data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7


mkdir mysql
sudo mount -t vboxsf -o uid=1000,gid=50 /c/Users /home/docker/data
sudo mount -t vboxsf -o uid=1000,gid=50 data /home/docker/data

C:\Users\CarlosR
mysql