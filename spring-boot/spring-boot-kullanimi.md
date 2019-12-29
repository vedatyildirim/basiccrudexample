---
description: >-
  Spring Boot ile Spring Web kullanarak, REST API üzerinden bir “Merhaba Dünya”
  çıktısı alarak, hızlıca klasik bir giriş yapacağız.
---

# Spring Boot Kullanımı

[**Spring Boot Nedir?**](https://vedatyildirim.com/spring-boot-nedir) **adlı girizgah yazımı okuyarak daha iyi bir giriş yapabilirsiniz.**

Bu bölümde, Spring Boot’la proje oluşturma konusuna inceleyeceğiz. Yanısıra Spring Web MVC ile REST API üzerinden, klasik bir “Merhaba Dünya” çıktısı alacağız. Web projeleri için genelde, Spring Web MVC \(Uygulamanın MVC kısmı için\) ve Spring Data JPA \(Uygulamanın veritabanı işlemleri için\) bileşenleri kullanılır.

## **Spring Boot ile Uygulama Oluşturma**

### **Gereksinimler**

* [**JDK 1.8**](http://www.oracle.com/technetwork/java/javase/downloads/index.html) **+**
* [**Spring Tool Suite \(STS\)**](https://spring.io/guides/gs/sts) **veya** [**IntelliJ IDEA**](https://spring.io/guides/gs/intellij-idea/) **Geliştirme Ortamı**
* [**Gradle 4+**](http://www.gradle.org/downloads) **veya** [**Maven 3.2+**](https://maven.apache.org/download.cgi) **\(**[**Maven Kurulumu**](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)**\)**

### **Uygulama Oluşturma Seçenekleri**

Spring Boot ile proje oluşturmın için birkaç yöntem vardır.

* **IDE ile oluşturma:** Eclipse Spring Tool Suite \(STS\) ve IntelliJ içerisinden, projede kullanılacak bileşenler seçilerek kolayca oluşturabilir.
* **Maven veya Gradle ile oluşturma:** Doğrudan bir maven projesi oluşturulup, eklenen bağımlılık ve bileşenler pom.xml üzerinden indirilebilir. Aslında, IDE ile oluşturma da arka planda bunu yapmaktadır.
* **Spring Initializr ile oluşturma:** [start.spring.io](https://start.spring.io/) sayfasında, projede kullanılacak bileşenleri ekleyerek bir maven \(pom.xml\) dosyası veya bir zip dosyası olarak indirebilir.

Her biri ile örnek olması açısından burada IDE \(Eclipse [Spring Tool Suite \(STS\)](https://spring.io/guides/gs/sts)\) üzerinden gideceğiz. İlerleyen bölümlerde [Spring Initializr](https://start.spring.io/) ile oluşturacağız.

### Merhaba Dünya Örneği

#### 1. **New &gt; Spring Boot Project sekmesinden uygulama oluşturulur.**

![](https://lh3.googleusercontent.com/Z_W_B5gbJunEKCv4A3eDpf3-5WHDH3C4fFrrWI8Cds3h3YIwe7D7P26lOHZYPAQmFkMgnzqcc0mU3BlWAXioa4XM6QN3bq3IK-gyykX5IyqO5qb5kOpOj_xesDsOeNAZPEdvLvBO)

**2. Açılan pencereden, projede kullanılacak bileşenler seçilir. Basi bir örnek yapacağımız için şu anda sadece Spring Web \(Spring Web MVC\) kullanılacak. Uygulamanın temel bileşenleri seçilip, finish’e tıklandığında işlem tamamlanır. Maven, arka planda seçtiğimiz bileşenleri indirir ve kullanıma hazır hale getirir.**

![](https://lh3.googleusercontent.com/_lA0FY8IdjbwWYscDt07FWHwu6UgL5f_SUy4FIY-QjqjmSNHK2jS9LPE9WR2Z0rhk-hO96khuA8OkIk-xNe2AQdt4aavpRYwtuZ7LQIgpOy3daP5ayTAN9bqIbsIOBVpHvlsP52d)

**3. Projeye sağ tıklayıp, Run As &gt; Spring Boot App ‘i seçerek çalıştırılır.**

![](https://lh4.googleusercontent.com/2c2cT1GGjf_hCth1HEyty4pLOhb0f4lhP8Pzvo_iCzIkppKmu1j8UgW8ZKuVzYCltEkgkTvRIJk4bnA2-K2LFQ0U-hixu14En24a2j9-TUZY6Kg_NF_Mk5aw5yxHP0X1ye_Pl5be)

Oluşturulan uygulamadaki **main metodu**nu barındıran sınıf üzerinde **@SpringBoootApplication** annotasyonu hazır olarak gelmektedir. Bu sınıf bütün diğer paket, sınıf ve bağımlılıkları algılayarak uygulamayı çalıştırılacak olan sınıftır. Spring Boot’ta, Spring Frmework’teki klasik xml ayarları yerine annotasyonlar kullanılmaktadır.

```text
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

 }
```

**4. Son olarak, örnek niteliğinde basit bir Controller oluşturuyoruz.**

Kodda gördüğünüz **@RestController** annotasyonu, rest api çıktısı üretir. **@RequestMapping** annotasyonu ise çıktının yolunu belirtir \(Örnek: localhost:8080**/merhaba**\).

![](https://lh6.googleusercontent.com/M4QiAP5R1XVsVKMKbRA8wI_8RRtXuTxiDOXph5b3VUQsE67MSoVJfcUZYjaiKTVL5vZM0xs0pjDf6_KX30Es7MvrTdgLLXQ-WiZr6sE7YpZstjldJJkZtaHow1urEDx8kX--Am9i)

![](https://lh5.googleusercontent.com/gZuBHD6bbZCdV1I9mjj672TtGfyPJ9Y6O4XlcnMxYC29VaGLV8DzPw8OhC7jloj5MMfd5Sq1sm5LvUzX2PFLS7bKbTkj85mfwOS7uNRCGcwSgJgWJI8dRsZ2HonQghGzAMcJewqV)

**6. Klasik bir Merhaba Dünya çıktısı ile bu kısmı sonlandırıyoruz.**

Hiçbir ayar yapmadığımız için uygulamamız localhost'ta, 8080 portu ile ayağa kalkar: http://localhost:8080**/merhaba**

_**NOT: Hızlı giriş yaptık ama merak etmeyin. Gerekli kofigürasyon, annotasyon ve kavramlara deyinerek ilerleyeceğiz.**_

[Bir sonraki yazımda](https://vedatyildirim.com/spring-boot-mimarisi), bilinmesi gereken kavramları, mimariyi anlatmaya çalışacağım. 

Ardından CRUD \(Ekleme/Okuma/Güncelleme/Silme\) işlemleri yapacağımız bir örnek uygulama üzerinden daha net ve detaylı anlamanıza yardımcı olmaya çalışacağım.

_Kaynak:_ [_https://vedatyildirim.com/spring-boot-kullanimi_](https://vedatyildirim.com/spring-boot-kullanimi)\_\_

