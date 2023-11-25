# Getting Started

### Start MySQL database server
```bash
docker container run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=product_management -p 3306:3306 mysql:8.0.25
```

### Start Application
```bash
./mvnw spring-boot:run
```

### Add a new user
```bash
curl --location 'http://localhost:8080/user/add' \
--header 'Content-Type: application/json' \
--data '{
"username": "username",
"password": "password"
}'
```

### Authenticate User
```bash
curl --location 'http://localhost:8080/user/authenticate' \
--header 'Content-Type: application/json' \
--data '{
"username": "username",
"password": "password"
}'
```

### Add a product
```bash
curl --location 'http://localhost:8080/products/add' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer JWT_TOKEN' \
--data '{
    "table": "products",
    "records": [
        {
            "entry_date": "03-01-2023",
            "itemcode": "11111",
            "itemname": "Test",
            "itemquantity": "20",
            "upc": "upc-11111",
            "ean": "ean-11111",
            "sku": "sku-11111",
            "isbn": "isbn-11111",
            "mpc": "mpc-11111",
            "sStatus": "Paid"
        },
        {
            "entry_date": "03-01-2023",
            "itemcode": "22222",
            "itemname": "Test",
            "itemquantity": "20",
            "upc": "upc-22222",
            "ean": "ean-22222",
            "sku": "sku-22222",
            "isbn": "isbn-22222",
            "mpc": "mpc-22222",
            "sStatus": "Paid"
        }
    ]
}'
```

### Get all product
```bash
curl --location 'http://localhost:8080/products/all' \
--header 'Authorization: Bearer JWT_TOKEN'
```