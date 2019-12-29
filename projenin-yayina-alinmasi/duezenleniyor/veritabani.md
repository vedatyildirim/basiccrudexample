---
description: >-
  Bu bir veritabanı eğitimi olmadığı için sadece neyi nereden kurup, ayağa
  kaldıracağınız anlatılmıştır.
---

# Veritabanının Oluşturulması

### H2 \(Projede Kullanılan\)

**Bu** örnek **projede** h2 veritabanı kullanıldığı için veritabanı adına **hiçbir şey** **kurmanıza** ve ayar yapmanıza **gerek yoktur**. Ancak MySQL veya PostgreSQL kullanılacaksa aşağıdaki açıklamalardan yardım alabilirsiniz.

### MySQL

Windows için **xampp**, linux için **lamp**'ı kurabilirsiniz.

### PostgreSQL

Java projelerinde genelde PostgreSQL kullanıldığı için bunu biraz daha detaylı anlatmaya çalıştım.

#### Windows İçin:

Bu [_link_](https://www.postgresql.org/download/windows/)ten  **Download the installer** tıklayıp**,** yönlendirileceğiniz bu [_link_](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)ten indirip direkt kurabilirsiniz.

#### Linux İçin:

Önce postgres kurulu değilse onu kuralım:

PostgreSQL kurulumu _**\(ilgili veri tabanı kurulur, biz postgres üzerinden gideceğiz\)**_. [_KAYNAK_](https://tecadmin.net/install-postgresql-on-debian/)\_\_

```text
wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | sudo apt-key add -
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ jessie-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
sudo apt-get update
sudo apt-get install postgresql postgresql-contrib
```

#### Veritabanı bağlantısı kontrol edilir.

```text
su - postgres
psql
```

#### Mevcut kullanıcı \(postgress\) parolasını değiştirme işlemi.

```text
sudo -u postgres psql
alter user postgres with encrypted password 'vy7967821';
```

#### Bir veritabanı oluşturup bir kullanıcı ile ilişkilendirme işlemi.

```text
CREATE DATABASE shipmanager; 
CREATE USER vedat WITH ENCRYPTED PASSWORD 'vy7967821'; 
GRANT ALL PRIVILEGES ON DATABASE shipmanager TO vedat;
```

#### Veritabanı sunucusunu çalıştırma, detaylar [_link_](https://www.godaddy.com/garage/how-to-install-postgresql-on-ubuntu-14-04/)_t_edir.

```text
service postgresql start
```

#### PgAdmin gibi bir tool ile remote veritabanına bağlanma işlemi [_link_](https://bosnadev.com/2015/12/15/allow-remote-connections-postgresql-database-server/)_t_edir.

#### [POSTGRESQL GÜVENLİK AYARLARI BU LİNKTEDİR.](https://severalnines.com/blog/how-secure-your-postgresql-database-10-tips)

#### Yukarıdaki kurulumların ardından, istenirse işletim sistemi güncellemeleri yapılabilir.

```text
sudo apt-get update -y
sudo apt-get upgrade -y
```

PgAdmin'i kurup ister remoute, ister local veritabanına bağlanabilirsin.

