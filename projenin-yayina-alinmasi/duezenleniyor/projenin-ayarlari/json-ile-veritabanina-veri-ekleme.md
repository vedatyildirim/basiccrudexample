---
description: >-
  Aşağıdaki JSON dosyası ilişkili iki tablo olan blog ve author için
  hazırlanmıştır.
---

# JSON ile Veritabanına veri ekleme



```text
[
  {
    "_class": "net.kodakademi.restcrud.domain.Author",
    "authorId": 1,
    "uname": "vedat",
    "name": "vedat yıldırımm",
    "role": "administrator"
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Author",
    "authorId": 2,
    "uname": "secret",
    "name": "gizli kullanıcı",
    "role": "administrator"
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Author",
    "authorId": 3,
    "uname": "onur",
    "name": "onur çalışkan",
    "role": "sistem"
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Author",
    "authorId": 4,
    "uname": "turgut",
    "name": "turgut reis",
    "role": "admin"
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Author",
    "authorId": 5,
    "uname": "ahmet",
    "name": "ahmet başkan",
    "role": "ai dev"
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title": "5G Teknolojileri",
    "body": "5G başlığı ile ilgili yazıdır.",
    "status": "PUPLISHED",
    "author": {
      "authorId": 1
    }
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title" : "Yapay Zeka Teknolojileri",
    "body": "Yapay Zeka başlığı ile ilgili yazıdır.",
    "status": "DELETED",
    "author": {
      "authorId": 1
    }
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title" : "Dijital Dönüşüm Teknolojileri",
    "body": "Dijital Dönüşüm başlığı ile ilgili yazıdır.",
    "status": "PUPLISHED",
    "author": {
      "authorId": 2
    }
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title" : "Dijital Dönüşümde Oyunun Kuralları",
    "body": "Dijital Dönüşümde Oyunun Kuralları başlığı ile ilgili yazıdır.",
    "status": "PUPLISHED",
    "author": {
      "authorId": 2
    }
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title" : "Robot Teknolojileri",
    "body": "Robot başlığı ile ilgili yazıdır.",
    "status": "PUPLISHED",
    "author": {
      "authorId": 3
    }
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title" : "Dijital Dönüşüm Nedir",
    "body": "Bu konuda yazılmış bir sürü içerik var.",
    "status": "PUPLISHED",
    "author": {
      "authorId": 3
    }
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title" : "Sanal Gerçeklik Teknolojileri",
    "body": "Sanal Gerçeklik ile ilgili yazıdır.",
    "status": "PUPLISHED",
    "author": {
      "authorId": 4
    }
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title" : "Artırılmış Gerçeklik",
    "body": "Artırılmış Gerçeklik ile ilgili yazıdır.",
    "status": "PUPLISHED",
    "author": {
      "authorId": 5
    }
  },
  {
    "_class": "net.kodakademi.restcrud.domain.Post",
    "title" : "Siber Güvenlik",
    "body": "Sanal Gerçeklik ile ilgili yazıdır.",
    "status": "PUPLISHED",
    "author": {
      "authorId": 5
    }
  }
]
```

