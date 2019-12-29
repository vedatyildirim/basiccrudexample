---
description: >-
  Bu katman @Repository annotasyonu ile oluşturacağımız sınıflarımızı
  barındırır. Entity sınıfından aldığı veriler üzerinde CRUD işlemleri gibi
  şeyleri yapmamızı sağlayan arayüzler sunar.
---

# Repository

Bu katman, klasik Java uygulamalarındaki DAO katmanıdır. Sağladığı altyapı \([CrudRepository, PagingAndSortingRepository ,JpaRepository](https://www.baeldung.com/spring-data-repositories)\) ile Entity sınıfından aldığı veriler üzerinde CRUD işlemleri gibi şeyleri yapmamızı sağlayan arayüzler sunar. Bu arayüzlerler, serileştirme \(Serializable\) işlemi için kullanılan arayüze de bağlıdırlar. Detayları[ link](https://www.baeldung.com/spring-data-repositories)tedir.

```text
package com.vedatyildirim.basiccrudexample.repository;

import com.vedatyildirim.basiccrudexample.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
```

