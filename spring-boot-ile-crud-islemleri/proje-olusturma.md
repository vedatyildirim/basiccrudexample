---
description: >-
  Bu bölümde Spring Initializr üzerinde bir Spring Boot uygulaması
  oluşturacağız. Bağımlılıklarımıza; Spring Web, Spring Data, Lombok ve H2
  veritabanı ekleyecek ve kullanıma hazır hale getireceğiz.
---

# Proje Oluşturma

### Kullanılacak bileşenler:

**Spring Web:** Web uygulamaları için kullanılır. RESTful web servisleri ve MVC ile uygulama geliştirme altyapısı sunar.‌ İçinde gömülü bir Tomcat\(uygulama sunucusu\) ile gelir.

**Spring Data:** Veritabanı işlemleri için kullanılır. JPA/Hibernate entegrasyonları ile birlikte gelir. ORM ve klasik JDBC alt yapılarının ikisini de destekler.‌

**H2 Veritabanı:** Uygulama ile otomatik ayağa kalkan gömülü bir veritabanıdır. Genelde basit işlemler veya test için kullanılır. Kurulum gerektirmediği için tercih ettim.

**Lombok:** Genelde, Entity sınıfları gibi POJO sınıflarında kullanılır. Ama başka bir sürü yerde de işimize yarar.

**En yaygın kullanılan annotastonlar aşağıdadır:**

_**@Data**_ : @Getter + @Setter + @ToString + @EqualsAndHashCode methodlarını oluşturur.

_**@Getter**_: Get methodlarını oluşturur.

_**@Setter**_: Set methodlarını oluşturur.

_**@ToString**_: ToString methodunu oluşturur.

_**@EqualsAndHashCode**_: Equals ve HashCode methodlarını oluşturur.

_**@AllArgsConstructor**_: Fieldlerle birlikte bir constructor oluşturur.

_**@NoArgsConstructor**_: Boş bir constructor oluşturur.

_**@NonNull**_ : Null kontrolü yapar ve NullPointerException fırlatmaktadır.

_**@Slf4j**_: Loglama işlemleri için kullanılır.

### Uygulama Oluşturma Aşaması:

[https://start.spring.io/](https://start.spring.io/) veya bir IDE üzerinden uygulamada kullanılacak bağımlılıkları seçerek projemizi oluşturabiliriz. İki yöntemde de, arka planda maven veya gradle üzerinden bağımlılıklar eklenir ve yapılandırılır. [Merhaba dünya](https://vedatyildirim.com/spring-boot-kullanimi) örneğimizde IDE ile yapmıştık. Şimdi [Spring Initializr](http://start.spring.io/) ile yapacağız.

Bağımlılıklarımızı seçelim:

**Maven**, tercih edeceğiniz bir Java sürümü \(bendeki Java 8\), **Spring Boot** sürümü \(bendeki 2.2.2\), **Spring Web**, **Spring Data**, **Lombok** ve **H2**. Aşağıdaki görselden de yardım alabilirsiniz.

![Spring Initializr](https://lh6.googleusercontent.com/zop4haRneZKq98696jR0fbWnTmeeKHuOtOiletlETFFCxm7y94a4KfH31fG1ZDiJR-Dlocb7Uz5ibevOZUtfj4Ef2H06qJUoWhTzX7NAAb27fFAHV7NLU0NHsKs_Z-F-y5Krx6av)

Generate tıklandığında proje olarak indirilir. O dosya herhangi bir yere çıkarılır ve  bir IDE ile açılır. Ben IntelliJ kullandım.

### Uygulama Yapısı:

![](https://lh5.googleusercontent.com/ZFFldR-NuWIUMetObTvm-gxV2S0bcyd0SYvldCrJpm3fLIlPh8euPGzIrNC1XjBev46SCGDXdOR_zKorei789PduK4UeJ8AP3eWBAmSiQdZTannYC7EjWXVQRM7QUGWfEsGd8ovY)

**İçerik:**

* **pom.xml** **dosyası**: Uygulamanın genel yapılandırması ve kullanmak için seçtiğimiz bütün maven bağımlılıklarının bulunduğu dosyadır.
* **uygulama ana sınıfı:** @SpringBoootApplication ****annotasyonunu ve main metodunu barındıran, uygulamayı ayağa kaldıran ana sınıfıdır. **@SpringBoootApplication:**[ _****Spring Boot’un otomatik yapılandırma mekanizmasını_](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-auto-configuration.html) _etkinleştirir ve uygulamada hazır olarak gelir._
* **resources klasörü**: Bizim şu an kullanmayacağımız, static ve templates adında -klasik template yapısı için- iki klasör. İsterseniz bunları direk kaldırabilirsiniz. Bizim için önemli olan içindeki **application.properties** dosyasıdır.
* **application.properties** **dosyası**: Uygulamanın -portundan veritabanına- bütün ayarları burada bulunur. Detayları [linkt](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#common-application-properties)edir. _NOT: Bu dosyayı yml uzantılı olarak da kullanabilirsiniz. Yml kullanımı da_ [_link_](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-use-yaml-for-external-properties)_tedir. Ayrıca her iki tipi; test, prod vb. gibi çoklu olarak da görmeniz mümkün. Her ortamın kendi ayarlarının yapılması adına, profiller üzerinden ortama göre build edilir. Profil konusunu ileride örneklendirmeye çalışacağım._ Biz şu an olduğu gibi kullanacağız.

**Bir sonraki yazımda bu** [**konfigürasyonları**](https://vedatyildirim.com/projenin-konfigurasyonlari) **yapacağız. Ardından katmanları yazıp ve** [**CRUD işlemleri**](https://vedatyildirim.com/spring-boot-crud-ornegi)**ne geçeceğiz.**

_Kaynak:_ [_https://vedatyildirim.com/spring-boot-proje-olusturulmas_**i**](https://vedatyildirim.com/spring-boot-proje-olusturulmasi)\*\*\*\*

