---
description: >-
  Bu bölümde, Spring Web ve Spring Data ile RESTful Webservisi üzerinden, CRUD
  (Ekleme, Okuma, Güncelleme, Silme) işlemleri yapacağımız örnek uygulamanın
  katmanlarını oluşturacağız.
---

# Katmanların Oluşturulması

Bir Spring Boot uygulamasının katmanlarından[ mimari](https://vedatyildirim.com/spring-boot-mimarisi) bölümünde bahsetmiştik. Bu katmanlar genel olarak klasik bir uygulama için de, Mikro Servis için de aynıdır. Mikro Servis için eklemeniz gereken bazı bileşenler ve yapmamız gereken bazı konfigürasyonlar var tabii ki.

_Fırsat bulabilirsem yaptığımız bu örneği, mikro servis olarak nasıl kullanırızı da yazmaya çalışırım. Ama biraz ipucu ile -euroka, zull, doker, openshift gibi konuları inceleyerek- bir başlangıç yapmayı deneyebilirsiniz._

**Projemizi oluştururken eklediğimiz;**

**Spring Data** ile Domain\(Entity/Model\) ve Repository\(DAO\) katmanlarını, **Spring Web** ile de Service ve Controller katmanlarını oluşturup, uygulamamızı tamamlayacağız.  


_Kaynak:_ [_https://vedatyildirim.com/spring-boot-crud-ornegi_](https://vedatyildirim.com/spring-boot-crud-ornegi)\_\_

