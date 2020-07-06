#!/bin/bash
docker run --restart=unless-stopped --name mysql.cedesistemas.local -v /var/data/mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql:5.7
