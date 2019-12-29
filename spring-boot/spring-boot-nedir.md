---
description: >-
  Spring Boot, Spring Framework bünyesindeki bütün bileşenlerin kullanımını
  annotasyonlarla otomatize etmek için geliştirilmiş bir çatıdır.
---

# Spring Boot Nedir?

![An Introduction to Spring Boot](https://lh5.googleusercontent.com/2S4u9eGh6Fcc6xgfi5gTs_WUcX0iMx6qmX3CqUCKUWAEAaLIp2Qah61sm8YFAH56fx4XU9ZFlG8HEOJlzQq40d4sQkjKYLmz3SpoNml5PGd0pAfdgGiej4GC0IeYaXupGJYYDSWA)

Spring Boot, Spring Framework bünyesindeki bileşenlerin kullanımını ve konfigürasyonunu daha kolay hale getiren bir Framework/Çatı olarak ortaya çıkmıştır.

_**Spring Boot = Spring Framework bileşenlerinin kolayca kullanılması + XML ​​gibi karmaşık konfigürasyonların yapılmasına gerek kalmaksınızın, annotasyonlarla otomatize halde çalışması + Gömülü sunucu desteği demektir.**_

![Spring Boot](https://lh6.googleusercontent.com/NDafSUUMoSpr4tbVOBLkrd06tRKl_tqKKJ_rJLbyRj0TQuiEO7Vyt1NS5zG1mWgsTVWzXYwtOlcIfEut9rJG5rQBprh14xVtf33ydh6H2dQcqdVsbHCagxULPRe7y0SJ-ONdG8xW)

Spring Framework ile çalışırken ihtiyaç duyulan teknoloji ve bileşenlerin projeye dahil edilmesi, oluşturulması gereken bean\(çekirdek\)lerin, yapılması gereken xml konfigürasyonlarının zor ve zahmetli oluşu Spring Boot’un ortaya çıkmasına neden olmuştur.  

Spring Boot, Spring Framework’ün ekosistemindeki bileşenleri daha kolay kullanmamızı sağlamıştır. Bu zahmetli işlemleri kendisi üstlenmiş ve süreci annotasyonlarla yönetmemizi sağlamıştır. 

Aşağıdaki görselde görüldüğü gibi bünyesinde birçok bileşeni ve teknolojiyi de barındırmakta ve kullanımını sağlamaktadır.

**Spring Boot’un Spring Framework Ekosistemi İçerisindeki Yeri.**

![Spring Framework Ekosistemi](https://lh4.googleusercontent.com/vZa9Zfhym6X8o4YNmhxRMpU0s96zRY0KJA0MWeVU3pdozp_G0F-tPy1szB6jhPRE9xI1WtYZ87gOFh2FV-gLsTVu6dG1Cn4ZbCZcuEe3JaL_e4lxz4GFdWctCKVNuN9-ozYN0ZSp)

Spring ekosisteminde, bir uygulamanın ihtiyaç duyabileceği \(Spring Web, Spring Security, Spring Data, Spring Cloud, Spring Test vs. gibi\) çeşitli Framework veya bileşenler mevcuttur. Bu bileşenleri, Spring Boot üzerinden kolayca projemize dahil eder ve konfigürasyon vs. gibi iş yükleri yerine, geliştireceğimiz uygulamaya odaklanırız.

Sunucu içinde bir container gerektirmediği için de direk tomcat ile kullanılabilir. Zaten içerisinde hazır gelmektedir.

Daha iyi anlatabilmek adına bir örnek uygulama üzerinden adım adım açıklayarak ilerlemeye çalışacağım. 

**Spring ile Entegre Çalışabilen Teknolojiler.**

![Sping ile Entegre &#xC7;al&#x131;&#x15F;abilen Teknolojiler.](https://lh3.googleusercontent.com/9Y8OZ5NunmA_eg6ENqwhh6nXVkjamT8zGSNBwlRplfnF5Z1c0ydsfK_Sy34WVymvsGU0hp_-OUhPSoc7gVszzvDbmdXNygZFSNCP3y-snMDMrt0ufJKuz56QCXSN5bxGqDofxc6g)

Ayrıca kurumsal uygulamalarda ihtiyaç duyulabilecek; Hazelcast, Kafka, Lombok, Retry, Solr, Elasticsearch, Redis gibi Spring Framework bünyesinde bulunmayan 3rd party \(üçüncü parti\) pek çok bileşen, servis ve teknolojinin kullanımını da kolaylaştırmaktadır.‌

_Kaynak:_ [_https://vedatyildirim.com/spring-boot-nedir_](https://vedatyildirim.com/spring-boot-nedir)\_\_

