---
description: >-
  Domain Katmanı diye adlandırdığımız kısım, ORM yardımı ile @Entity
  notasyonları ile POJO sınıflarımızla veritabanı tablolarını oluşturduğumuz ve
  üzerinden CRUD işlemlerini yapacağımız kısımdır.
---

# Domain Katmanı

## **Projeye Başlamak**

**Blog ve Author isimli iki sınıf oluşturup CRUD işlemleri yapacağız. İlişki için yapılan değişiklikleri açıklayacağım.**

**Post:**

```text
package com.vedatyildirim.restfulcrudexample.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;

@Entity
@Table(name="post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * PostgreSQL, Oracle gibi veritabanları için:
     * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POST_ID")
     * @SequenceGenerator(name = "SEQ_POST_ID", sequenceName = "SEQ_POST_ID", allocationSize = 1, initialValue = 1000)
     */
    @Column(name = "post_id", unique = true, nullable = false)
    private Long postId;

    @NotNull
    @Column(name = "title", nullable = false, length = 300)
    private String title;

    @NotNull
    @Column(name = "body", nullable = false, length = 300)
    private String body;

    // JPA config içindeki ayarlara ihtiyaç duyulmadan yapılır.
    @JsonFormat(pattern = "dd.MM.yyyy, HH:mm:ss")
    @Column(name = "create_At", nullable = false)
    private Date date = new Date();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="author_id")
    private Author author;
}


```

**Author:**

> ```text
> package com.vedatyildirim.restfulcrudexample.domain;
>
> import com.fasterxml.jackson.annotation.JsonFormat;
> import lombok.*;
> import javax.persistence.*;
> import javax.validation.constraints.NotNull;
> import java.io.Serializable;
> import java.util.Date;
>
> @Entity
> @Table(name="author")
> @Data
> @NoArgsConstructor
> @AllArgsConstructor
> @ToString
> @EqualsAndHashCode
> public class Author implements Serializable {
>
>     @Id
>     @GeneratedValue(strategy = GenerationType.AUTO)
>     /**
>      * PostgreSQL, Oracle gibi veritabanları için:
>      * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUTHOR_ID")
>      * @SequenceGenerator(name = "SEQ_AUTHOR_ID", sequenceName = "SEQ_AUTHOR_ID", allocationSize = 1, initialValue = 1000)
>      */
>     @Column(name = "author_id", unique = true, nullable = false)
>     private Long authorId;
>
>     @NotNull
>     @Column(name = "uname", nullable = false, length = 20)
>     private String uname;
>
>     @NotNull
>     @Column(name = "name", nullable = false, length = 20)
>     private String name;
>
>     @NotNull
>     @Column(name = "role", nullable = false, length = 20)
>     private String role;
>
>     // JPA config içindeki ayarlara ihtiyaç duyulmadan yapılır.
>     @JsonFormat(pattern = "dd.MM.yyyy, HH:mm:ss")
>     @Column(name = "create_At", nullable = false)
>     private Date date = new Date();
>
>
> }
> ```

