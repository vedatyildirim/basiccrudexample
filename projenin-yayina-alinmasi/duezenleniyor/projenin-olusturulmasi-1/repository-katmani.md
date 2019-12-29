---
description: >-
  Bu katman klasik java uygulamalarındaki DAO katmanıdır. Sağladığı alt yapı ile
  domain/entity POJO'larından aldığı veriler üzerinde CRUD, Pagination gibi
  işlemleri yapmamızı sağlayan arayüzler topluluğ
---

# Repository Katmanı

**PostRepository:**

```text
package com.vedatyildirim.restfulcrudexample.repository;

import com.vedatyildirim.restfulcrudexample.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
```

**AuthorRepository:**

```text
package com.vedatyildirim.restfulcrudexample.repository;

import com.vedatyildirim.restfulcrudexample.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}

```

