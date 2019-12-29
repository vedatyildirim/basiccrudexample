---
description: >-
  Bu bölümde uygulamayı derlemeyi ve yayına inceleyeceğiz. Bu bölüm, bu serinin
  son yazısıdır. Faydalı olması dileği ile.. Başarılar dilerim.
---

# Yayına Alımı

**1.IDE içerisindeki veya normal terminalden, uygulama dizininde mvn clean install komutuyla uygulamamızı derleriz.** 

```text
mvn clean install
```

Aşağıda görüldüğü gibi target klasörü altındaki jar dosyası bizim uygulamamızdır. Artık istediğimiz yerde ayağa kaldırabiliriz.

![](https://lh4.googleusercontent.com/yrvY4ct63p1avaSw6DU-NxCqeT6fIjbpXdmN2FT9T1DswaoU_T4zZ8f5A6QiQ8iqrJwzsCc0D9Qs7I7vAylTn5Wlkeq4OMlY3N2-nrDNR-QtO1vDzqCUQkxEfVHx9YSAPCXlxowx)

**2.Oluşan jar’ı nerede çalıştıracaksak o dizine gidip, java -jar komutunun önüne, basiccrudexample-0.0.1-SNAPSHOT.jar -Dfile.encoding=UTF-8 şeklinde jar dosyamızın adını yazarak ayağa kaldırabiliriz.**

```text
java -jar basiccrudexample-0.0.1-SNAPSHOT.jar

```

**3. Erişim:**[**http://localhost:9090/api/**](http://localhost:9090/api/) **adresinden uygulamaya erişebilir ve kullanabiliriz.**

Bu bölümün sonuna geldik.. Başarılar dilerim.

[Vedat Yıldırım.](https://vedatyildirim.com)

