---
description: >-
  Bu bölümde hazırladığımız uygulamayı test etmek için Postmanle CRUD işlemleri
  yapacağız.
---

# Postman Kullanımı

Postman, milyonlarca yazılımcının kullandığı ücretsiz sürümü de olan bir uygulamadır. API’ler üzerinden test ve monitör etmek için kullanılan bir “rest client”ıdır. Bilmeyenlerimiz için kullanımı[ link](https://medium.com/postman-t%C3%BCrkiye/postman-nedir-622be8afef2e)tedir.

Bir önceki bölümde uygulamamızı ayağa kadırmıştık. Şimdi controllerda verdiğimiz yolu da önüne yazarak, localhost:9090/api adresi üzerinden işlemlerimizi yapalım. 

**Önce aşağıdaki gibi Header kısmındaki Accept ve Content-Type alanlarına application/json değerlerini gireceğiz.**  


![](https://lh5.googleusercontent.com/yO4QqonIjAUyJ5PxmAL388EA2Lj6S7uChuqzcKanhGbfXBJMDWfSJZlzTPqqCFgyoXd0G0FnbifzhwXEF85f4kmGMBSPExAuJUS8yzJOkaqxI5zBW4loa1SjFOkI6D3gAfirFbW7)

**POST İŞLEMİ**

Aşağıdaki görseldeki seçili alanlara dikkat ederek bu JSON örneğinde olduğu gibi alanları doldurarak ekleyebilirsiniz:  
****

```text
{
  "title": "Deneme Başlık",
  "content": "Deneme İçerik"
}
```

![](https://lh5.googleusercontent.com/HAhegUNyxDT1thwu9E47B9L9ogMEWjpVvhoWqPpAZyjAoxEmcB0TI3i9O4h35ZXY6So3T_P1EqtS9dYkK-ggER1-j6PoFbOqSTSXKuP1SkdLIbyfR5ANSVtMp9DLFY0c-ymDVpWp)

**PUT İŞLEMİ**

Aşağıdaki görseldeki seçili alanlara dikkat ederek bu JSON örneğinde olduğu gibi ID’nizi ve düzenlemek istediğiniz alanları vererek güncelleyebilirsiniz:

```text
{ 
  "id": 5,
  "title": "Test Başlığı",
  "content": "Test Başlığı"
}
```

![](https://lh6.googleusercontent.com/QoKRuSfaPOBmW_w15kC1f0p2AeIg3PxVeHepbjKjprrX9Mhu29BVJeKJs5pvOAvoiFQFmvc64jwmBpcvWCzzk-8Mfdf5QcU9j_h6rdtYPYHkq-CzfvEsW9012wnstZAkqEy9VuUm)

**GET İŞLEMİ**

Get işlemini sol üst menüden GET’i seçerek yapabilirsiniz. Bizim örneğimizde; localhost:9090/api/ üzerinde tüm kayıtları, localhost:9090/api/1 şeklinde id’yi vererekte tek tek listeleyebiliriz.

**Bir sonraki bölümde Swagger kullanımını inceleyeceğiz.**  


