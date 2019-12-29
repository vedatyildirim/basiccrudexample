---
description: >-
  Klasik bir MVC'de @Controller annotasyonu, Restful API'de ise @RestConroller
  anotasyonu ile oluşturulan bu sınıflar; verilerimizi frontend ve tarayıcı
  üzerinden kullanabilmemizi sağlarlar.
---

# Controller

Controller katmanı, uygulamanın tarayıcı ile konuşan ara birimidir. HTTP üzerinden gelen istekleri, RESTful yöntemleriyle yorumlayarak; GET, POST, PUT, DELETE gibi istekleri alır ve CRUD işlemleri gibi şeyleri yapmamızı sağlar.

**Annotasyonlar açıklanacak!**

```text
package com.vedatyildirim.basiccrudexample.controller;

import com.vedatyildirim.basiccrudexample.domain.Post;
import com.vedatyildirim.basiccrudexample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.Long;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/")
    public ResponseEntity<Iterable<Post>> getAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (!post.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(post.get());
    }


    @PostMapping("/")
    public ResponseEntity create(@RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @Valid @RequestBody Post post) {
        if (!postService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(postService.save(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!postService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
```

Şimdi, IDE’mizin run tuşuna basarak uygulamamızı çalıştırırız. Tarayıcıdan, localhost:9090 adresine gittiğimizde yayında olduğunu görürüz.

