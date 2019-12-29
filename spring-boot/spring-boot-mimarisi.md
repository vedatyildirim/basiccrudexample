---
description: >-
  Spring Boot, mimari olarak çok katmanlı mimariye sahiptir. Microservice ve
  Monolithic geliştirme yöntemlerinin ikisini de destekler.
---

# Spring Boot Mimarisi

## **Mimari**

Kurumsal Java uygulamaları genellikle web tabanlıdır. Spring Web ile oluşturulan bu yapı; **sunum**\(web layer\), **servis**\(service layer\) ve **veri**\(repository layer, domain model ve domain modelin web layer'la arasında ara birim olan DTO'lar\) katmanlarından oluşmaktadır.

![Spring Boot Mimarisi.](https://lh6.googleusercontent.com/RZA2eu8lxJ-9D9ql6VKwOtrIaCJUNAcelGej574Ic941p8eY1f8nxKx2vvO_QBw2WqOAkegVFVAlSZ9zR-O_xEsRBy8tUNUti6_HBxyr_ZbTT_3yVPAxPc6uEXIUBkbRy4ExgH2M)

**Spring Web \(**MVC ve REST APİ için\) ve **Spring Data** \(JPA/Hibernate – Veritabanı işlemleri için\) ile oluşturulan, temel bir web uygulaması için aşağıda belirtilen annotastonlar ve paketler yardımı ile bu mimari kullanılır.

Bu katmanların her biri belirli görevlere sahiptir ve her bir katmanda uygulamanın ihtiyaçlarına göre farklı servisler ve bileşenler görev yapmaktadır. 

Örnek uygulama oluştururken bu mimariyi daha detaylı anlatmaya çalışacağım.‌

Her katman, bir paket\(package\) altındadır ve yukarıdaki mimariye uygun şekilde, sınıfların üzerinde gerekli annotasyonlar kullanılarak, aşağıdaki gibi oluşturulur.‌

## **Katmanlar**

Paket\(package\), Java’da temel kavramlardan ve ilk göze çarpan konulardan biridir. Başlangıçta paketlerin yapısına fazla dikkat etmeyiz. Fakat ilerleyen zamanlarda karmaşayı önlemek ve proje mimarisini anlaşılır hale getirmek için en pratik\(best praktice\) yöntemleri araştırmaya başlarız. ‌

Bu noktada Spring Boot’un sunduğu standart mimariye, paket yapısına ve kullanılacak bileşenlere göre aşağıdaki yapıya benzer bir mimari katmanı oluşturulur:

* **Domain katmanı:** @Entity annotasyonu ile oluşturulan POJO sınıflarıdır. Bu sınıflar, ORM işlemleri için tablolara karşılık gelen sınıflardır. Bütün veritabanı işlemleri bu sınıflar üzerinden yapılır. Dto: Servis ve sunum katmanının direk veritabanına ulaşmasını engellemek ve parola vs. gibi bazı özel parametreleri dışarıdan erişime kapatmak için kullanılır. Genelde domain’in altında yer alır.
* **Repository \(DAO\) katmanı:** @Repository annotasyonu ile oluşturulan ve Spring Boot tarafından CRUD işlemleri alt yapısı ile hazır olarak gelen bir arayüz\(interface\)dür.
* **Service \(iş\) katmanı:** @Service annotasyonu ile oluşturulur. Repositoryden aldığı CRUD işlemleri altyapısını kullanarak, üzerinde mantıksal işlemler yaptığımız sınıftır.
* **Controller \(sunum\) katmanı:** Klasik bir MVC uygulamasında @Controller annotasyonu, Restful API uygulamasında ise @RestConroller anotasyonu ile oluşturulan bu sınıflar; verilerimizi frontend ve tarayıcı üzerinden kullanabilmemizi sağlarlar.
* **Util, configuration, log vs:** Eklemek istediğimiz diğer şeyler için isteğe bağlı olarak, istediğimiz kadar komponent oluşturabilirsiniz.

Konunun detayına, katmanları yazarken biraz daha detaylı değineceğiz.Aşağıda gördüğünüz klasör/paket\(package\) yapısı, uygulamayı gerekli katmanlara ayıran ve mikro servis mimarisinde de kullanılan en yaygın [best practice](https://dzone.com/articles/project-package-organization) mimari yapısıdır

```text
src/main/java
    +- com
        +- example
                +- domain (Model(Entity) katmanı)
                |   +- Test.java
                +- repostory (DAO katmanı)
                |   +- TestRepository.java
                +- dto (Model erişim kısıt ve yönetim katmanı)
                |   +- TestDto.java
                +- util (Oluşturacağınız komponentler)
                |   +- ApplicationUtils.java
                +- service (İş(Business) katmanı)
                |   +- impl
                |   |   +- TestServiceImpl.java
                |   +- TestService.java
                +- controller (Sunum Katmanı)
                |   +- TestController.java
                +- configuration (Ayarlar)
                |   +- ApplicationConfiguration.java
            +- TestApplication.java
```

[**Bir sonraki bölüm**](https://vedatyildirim.com/spring-boot-proje-olusturulmasi)**de projemizi oluşturacak, CDUD işlemleri yapacağımız örnek bir uygulama geliştirerek devam edeceğiz.**

_Kaynak:_ [_https://vedatyildirim.com/spring-boot-mimarisi_](https://vedatyildirim.com/spring-boot-mimarisi)\_\_

