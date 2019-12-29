---
description: Bu katman @Service annotasyonu ile oluşturacağımız sınıflarımızı barındırır.
---

# Service

Servis katmanı, Domain katmanından alınan verileri ve Repository katmanından alınan metodları CRUD işlemleri için hazırlayıp Controllera aktarır. Aynı zamanda uygulamada yapılması gereken mantıksal işlemler \(iş/business\) bu katmanda yapılır.

```text
package com.vedatyildirim.basiccrudexample.service;

import com.vedatyildirim.basiccrudexample.domain.Post;
import com.vedatyildirim.basiccrudexample.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
    
}
```

Artık controller sınıfımızı oluşturup REST API servisimizi oluşturabiliriz.

