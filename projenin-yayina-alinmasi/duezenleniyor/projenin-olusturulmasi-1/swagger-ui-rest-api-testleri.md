---
description: >-
  Swagger, postman gibi REST servicelerimizin testlerini yapmamızı ve frondent
  arayüzü gibi kullanarak CRUD işlemleri yapmamızı sağlar.
---

# Swagger UI - REST API Testleri

![](../../../.gitbook/assets/screenshot-from-2019-07-02-21-59-42.png)

### Notlar:

_**POST:**_

_Aşağıdaki şekilde post edildiğinde:_ 

```text
{
  "author": {
    "authorId": 1
  },
  "body": "Deneme Içerik",
  "status": "DELETED",
  "title": "Deneme"
}
```

_Response olarak bu döner:_

```text
{
  "postId": 16,
  "title": "string",
  "body": "test",
  "status": "PUBLISHED",
  "author": {
    "authorId": 1,
    "uname": null,
    "name": null,
    "role": null
  }
}
```

_Ama GET edildiğinde null olan boşlukların **dolduğunu** görürsün. Kayıttan sonraki responsta böyle olması normal, sadece id'yi görüyor çünkü._

{% embed url="http://localhost:8091/swagger-ui.html" %}

