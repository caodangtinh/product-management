# Getting Started

### Start MySQL database server
```bash
docker container run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=product_management -p 3306:3306 mysql:8.0.25
```
