# TC-POS Backend

A Spring Boot backend for the TC-POS system, handling sales and stock via REST APIs with MySQL.

## Features
- REST APIs: Product lookup (`GET /api/products/{barcode}`) and sales (`POST /api/sales`).
- MySQL database with 100 pre-loaded products in ZAR (R).
- Stock updates on sales.

## Setup
1. **Clone**: `git clone https://github.com/kholsas/tc-pos-backend.git`
2. **MySQL**:
    - Run: `mysql -u root -p`
    - Create:
      ```sql
      CREATE DATABASE tcposdb;
      CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
      GRANT ALL PRIVILEGES ON tcposdb.* TO 'admin'@'localhost';
      

3. **Developers**: Kholofelo Maloma
4. **Architect**: Kholofelo Maloma