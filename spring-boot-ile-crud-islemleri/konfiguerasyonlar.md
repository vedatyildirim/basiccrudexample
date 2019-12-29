---
description: >-
  Bu bölümde, oluşturduğumuz örnek uygulama için gerekli olan; port, veritabanı,
  log vb. temel konfigürasyonları yapacağız. CRUD işlemleri yapacağımız bir
  sonraki aşamaya hazır hale getireceğiz.
---

# Konfigürasyonlar

**1.Application Properties \(DB, Server/Port vs. Konfigürasyonları**

Uygulama ile hazır gelen application.properties dosyasında, uygulamamın port, log, veritabanı vs. gibi konfigürasyon bilgilerini aşağıdaki gibi ekleyebilirsiniz.‌

### Uygulama Konfigürasyonları

```text
# ================================
# Uygulama Konfigürasyonları
# ================================

# Uygulama Portu
server.port=9090

# UTF-8 Ayarları
spring.mandatory-file-encoding=UTF-8
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true

# Uygulama log ayarları (INFO, ERROR, DEBUG vs. için)
logging.level.root= INFO
logging.level.org.springframework.web= INFO
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n

# SQL log ayarları
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=INFO
logging.level.org.hibernate= INFO

# SQL çalıştrma ayarları
# update (Mevcutu silme, yeni bir şey eklediysem güncelle, yoksa da oluştur),
# create-drop (mevcut veri sil, yeniden create et),
# none gibi özellikleri mevcuttur.
spring.jpa.hibernate.ddl-auto=update
```

### **Veritabanı Konfigürasyonları**

Hangi veritabanını kullanacaksanız, aşağıda ayrı olarak verdiğim "NOT" kısmından bakıp ekleyebilirsiniz. Biz örneğimizde H2 kullandık.

```text
# ================================
# H2 Veritabanı Ayarları
# ================================
# Tarayıcıda gösterimi açma/kapama
spring.h2.console.enabled=true
# Urldeki uzantısı: /h2-console
spring.h2.console.path=/h2-console
# File adı
spring.datasource.url=jdbc:h2:file:~/test
# Kullanıcı adı
spring.datasource.username=sa
# Parola
spring.datasource.password=
# Veritabaı bağlantı sürücüsü
spring.datasource.driver-class-name=org.h2.Driver
```

**H2 Konfigürasyonu:**

Bizim örneğimizde buradan aşağısı bizi ilgilendirmiyor ama not olarak en yalın halleriyle, diğer veritabanlarının konfigürasyonlarını da paylaştım.

#### **Bundan sonraki işimiz katmanları oluşturup, CRUD işlemlerini yapmaktır.**

## **NOT**

{% hint style="info" %}
**Eğer başka bir veritabanı kullanılacaksa, maven yolu pom.xml'e eklendikten sonra aşağıdaki örneklerle kullanabilirsiniz. Oracle ve PostgreSQL gibi veritabanı yönetim sistemlerinde; Entity'de, ID'ye sequence eklemek gerekir. Ben aşağıda en yalın halleri ile paylaşıyorum. MySQL'le de test ettim ama diğerleri için kendiniz denemeniz gerek.** 

_**Aşağıdaki örnekteki gibi:**_
{% endhint %}

```text
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "test_Sequence")
@SequenceGenerator(name = "test_Sequence", sequenceName = "TEST_SEQ")
private Long id;
```

**MySQL Konfigürasyonu:**

```text
# ===============================
# MySQL DATA SOURCE
# ===============================
spring.datasource.url = jdbc:mysql://localhost/crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password =
```

**PostgreSQL Konfigürasyonu:**

```text
# ===============================
# POSTGRES DATA SOURCE
# ===============================
spring.datasource.url=jdbc:postgresql://localhost:5432/veritabanıadı
spring.datasource.username=postgres
spring.datasource.password=
```

**Oracle Konfigürasyonu:**

```text
# ===============================
# ORACLE DATA SOURCE
# ===============================
spring.datasource.url=jdbc:oracle:thin:@localhost:1522:veritabanıadı
spring.datasource.username=admin
spring.datasource.password=test
spring.datasource.driver.class=oracle.jdbc.driver.OracleDriver
```

**SQL Server Konfigürasyonu:**

```text
# ===============================
# MS SQL Server DATA SOURCE
# ===============================
spring.datasource.url=jdbc:sqlserver://localhost;databaseName=veritabanıadı
spring.datasource.username=sa
spring.datasource.password=Projects@123
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect
```

**Bundan sonraki işimiz katmanları oluşturup,**[ **CRUD işlemleri**](https://vedatyildirim.com/spring-boot-crud-ornegi)**ni yapmaktır.**

_Kaynak:_ [_https://vedatyildirim.com/projenin-konfigurasyonlari_](https://vedatyildirim.com/projenin-konfigurasyonlari)\_\_

