---
description: Kullanılacak teknolojilerin kurulumları.
---

# Genel Kurulumlar



_Putty veya bir shell editörü üzerinden sunucuya erişim sağlanır. Bundan sonra anlatacağım linux komutları Putty üzerinde uygulanarak işlemlere devam edilir.._

#### Root olarak giriş yapılır.

> Debien ve CentOS gibi işletim sistemlerinde sudo komutu çalışmaz. Bunun için kurulum yapmak gereklidir ya da komutları sudosuz yazmak.. Kurulum için: "**apt-get install sudo"** komutu kullanılır.

```text
sudo su root
```

#### Root kullanıcısının ana dizini  kontrol edilir.

> Google Cloud gibi bir servise kullanılıyorsa veya root parolası bilinmiyorsa ya da değiştirmek istenirse, "**passwd root**" komutu ile yeni parola belirleyebiliriz. Aşağıdaki komutla hangi dizinde olduğumuzu görürüz.

```text
pwd
```

#### Linux üzerindeki SSH configuration dosyasını düzenlenir. Nano komutu ile dosya açılır.

> Açılan dosyada: **PermitRootLogin Yes** ve **PasswordAuthantification Yes** olarak düzenlenir. Nano komutu ile açılıp değişiklik yapılan herhangi bir dosyadaki kaydetme işlemleri yapılır: **ctrl + o** ile kaydedilip, **enter** ile işlemi tamamlayıp, **ctrl + x** ile çıkılır ve kaydedilen dosyanın algılanabilmesi için "**service sshd restart**" komutu ile SSH servisi yeniden başlatılır.

```text
nano /etc/ssh/sshd_config
service sshd restart
```

#### Sistem güncellemeleri yapılır.

```text
sudo apt-get update -y
sudo apt-get upgrade -y
```

#### Gerekli java sürümünün JDK'sı kurulur.

```text
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install openjdk-8-jdk
```

#### Gİt kurulur.

```text
sudo apt-get install git
```

#### Maven kurulur.

```text
sudo apt-get install maven
```

#### LTS olarak desteklenen NodeJS kurulur.

> Var olan sürüm güncellenmek istenirse ki; tavsiye edilmez: "sudo apt-get update -y nodejs"

```text
curl -sL https://deb.nodesource.com/setup_8.x | sudo -E bash -
sudo apt-get install -y nodejs
```

#### Zip işlemleri için zip ve unzip kurulur.

```text
sudo apt-get install zip
sudo apt-get install unzip
```

#### Nginx sunucusu kurulur ve servisi başlatılır.

Aşağıdaki komutlar ile kurulum yapılıp, servisler çalıştırıldıktan sonra \(dış\) IP adresiniz üzerinde sunucu yayında olacaktır.. Kaldırmak istenirse gerekli işlemler [link](https://askubuntu.com/questions/786015/how-to-remove-nodejs-from-ubuntu-16-04)te.

```text
sudo apt-get install nginx
sudo service nginx restart
```

#### PostgreSQL kurulumu _**\(ilgili veri tabanı kurulur, biz postgres üzerinden gideceğiz\)**_. [_KAYNAK_](https://tecadmin.net/install-postgresql-on-debian/)\_\_

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
CREATE DATABASE shipmanager; CREATE USER vedat WITH ENCRYPTED PASSWORD 'vy7967821'; GRANT ALL PRIVILEGES ON DATABASE shipmanager TO vedat;
```

#### PgAdmin gibi bir tool ile remote veritabanına bağlanma işlemi [_link_](https://bosnadev.com/2015/12/15/allow-remote-connections-postgresql-database-server/)_t_edir.

#### [POSTGRESQL GÜVENLİK AYARLARI BU LİNKTEDİR.](https://severalnines.com/blog/how-secure-your-postgresql-database-10-tips)

#### Yukarıdaki kurulumların ardından, istenirse işletim sistemi güncellemeleri yapılabilir.

```text
sudo apt-get update -y
sudo apt-get upgrade -y
```

