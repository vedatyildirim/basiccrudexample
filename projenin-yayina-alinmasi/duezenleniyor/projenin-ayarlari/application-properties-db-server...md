---
description: >-
  Aplication.properties dosyasında ise veritabanı bağlantısı işlemleri ve sunucu
  işlemleri falan yapılır.
---

# Application Properties \(DB, Server..\)

**Application And Server Configuration** kısmındakileri dahil ettikten sonra, hangi veritabanı ile çalışacaksanız aşağıdan onun konfigurasyon kodunu alıp ekleyebilirsiniz.

### Application And Server Configuration:

```text
# ===============================
# = Application / Application Server Configuration
# ===============================
server.port=9090
spring.mandatory-file-encoding=UTF-8
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true

logging.level.root= ERROR
logging.level.org.springframework.web= ERROR
logging.level.org.hibernate= ERROR

# Hibernate Configuration
# ===============================
# = JPA / HIBERNATE Configuration
# ===============================

# Use spring.jpa.properties.* for Hibernate native properties (the prefix is
# stripped before adding them to the entity manager).

# Show or not log for each sql query
spring.jpa.show-sql = true

# Hibernate ddl auto (create, create-drop, update): with "update" the database
# schema will be automatically updated accordingly to java entities found in
# the project
spring.jpa.hibernate.ddl-auto = update

# Naming strategy
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy

```

### H2 Configuration:

```text
server.port=8091
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:file:~/test
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
```

### MySQL Configuration

```text
# ===============================
# = DATA SOURCE
# ===============================

# Set here configurations for the database connection
# Connection url for the database "netgloo_blog"
spring.datasource.url = jdbc:mysql://localhost:3306/crudrest?useUnicode=yes&characterEncoding=UTF-8

# Username and password
spring.datasource.username = root
spring.datasource.password =

# Keep the connection alive if idle for a long time (needed in production)
spring.datasource.testWhileIdle = true
spring.datasource.validationQuery = SELECT 1

# Allows Hibernate to generate SQL optimized for a particular DBMS
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```

### PostgreSQL Configuration

```text
# ===============================
# = POSTGRES DATA SOURCE
# ===============================
## default connection pool
spring.datasource.hikari.connectionTimeout=20000
spring.datasource.hikari.maximumPoolSize=5

## PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/crudexample
spring.datasource.username=postgres
spring.datasource.password=123

## drop n create table again, good for testing, comment this in production
spring.jpa.hibernate.ddl-auto=create
# ===============================
```

