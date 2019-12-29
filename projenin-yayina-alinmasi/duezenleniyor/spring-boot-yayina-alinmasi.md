---
description: Boş sunucu üzerine kurulum işlemleri ve yayınlama...
---

# Spring Boot/Java Projesinin Yayına Alınması

## Spring/Java Build İşlemleri

#### Spring/Java projesi git'den alınır veya FTP yolu ile de atılabilir.

```text
git clone gitadresi
```

#### İndirilen klasöre gidilir\(root klasörü içinde shipmanager-api örneğin\)

> Pull alınacaksa, branch kontrolü: "**git branch**" yapılır. Farklı bir branche geçilecek yeva orada pull alınacaksa "**git checkout branchadı"** \( örnek: shipment-api, shipment-api-dev vs..\) ve "**git pull".**

```text
cd restcrud-master
```

#### Maven ile proje target klasörüne deploy edilir.

```text
mvn clean install
```

**Target klasörü içine gidilir.**

```text
cd target
```

#### **Target klasörüne deploy edilen proje çalıştırılır/run edilir.**

```text
ps aux | grep java
```

#### **Mevcut çalışan/yayında olan proje/jar kontrol işlemi.**

> _Eğer varsa buna benzer bir çıktı alırsın ve üstteki \(içinde, "**projeadı..-0.0.1-SNAPSHOT.jar**" geçen\) satırın **id**'sini alıp **kill -9** komutuyla durdurulur._ 
>
> **Örnek: user     31337 0.1 10.3 4752092 791916 ?      Sl Aug10 44:34 java -jar -Xmx2048m -Xms1024m shipment-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod**                                                                                                                                                                                     _Bu şekilde bir çıktı ve gelen ID önemli değildir, o otomatik oluşur: user     22954 0.0  0.0 12944 972 pts/1    S+ 07:05 0:00 grep --color=auto jav_  
> ****

#### **Çalışan/yayında olan proje/jar kill - 9 komutunun önüne ID'si yazılarak durdurulur.**

```text
kill -9 8926
```

#### **Spring Boot/Java uygulaması çalıştırılır/yayına alınır**

```text
java -jar -Xmx2048m -Xms1024m restcrud-master-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod > today.log 2>&1 & echo
```

#### Uygulamanın çalışma durumunun log'u alınır.

```text
tail -f today.log
```

#### **Exit komutu ile işlemden çıkılır.** YOKSA PUTTY KAPANDIĞINDA UYGULAMA DURUR.

> exit : Shell’den cikma komutu

```text
Ctrl + C 
exit
```

{% hint style="info" %}
### **BURAYA KADAR OLAN KISIMDA BÜTÜN İŞLEMLER TAMAMLANMIŞ VE SPRİNG/JAVA  UYGULAMASI YAYINA ALINMIŞTIR. BAŞARILAR!**
{% endhint %}

