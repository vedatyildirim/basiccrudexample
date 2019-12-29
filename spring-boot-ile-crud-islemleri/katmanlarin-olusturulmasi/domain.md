---
description: >-
  Domain katmanında Entity sınıflarımı oluştururuz. Paket ismine entity, domain,
  model vb. gibi isteğe bağlı farklı isimlerde verebilirsiniz.
---

# Domain

Domain katmanında[ POJO](https://www.edureka.co/blog/pojo-in-java/) sınıflarımız vardır. Bu sınıfları Spring Data\(JPA/Hibernate\) kullanarak, ORM yöntemi ile veritabanı tablolarına dönüştürürüz. Bu[ annotasyonlar](https://dzone.com/articles/all-jpa-annotations-mapping-annotations) sadece Springe özel değildir.[ JPA/Hibernate](https://dzone.com/articles/all-jpa-annotations-mapping-annotations) kullanılan bütün Java projeleri için geçerlidir.‌

**Bilmeyenler için kullanacağımız temel annotasyonların en önemlilerini kısaca özetleyeceğim:‌**

* **@Entity:** Sınıfı, veritabanı tablosuna eşitler.‌
* **@Table\(name = "tablo\_adı"\):** Tablonun ismi sınıftan farklı olacaksa kullanılır. Kullanılmazsa zaten tablo sınıfın adını alır.
* **@Id:** Her tablonun olmazsa olmazı olan ID'sinin annotasyonudur.‌
* **@NotNull:** Boş olmaması gereken alanlar için kullanılır.‌
* **@Column\(name = "title", length = 300\):** Kolon adı ve uzunluğu vermek için kullanılır.‌
* **@GeneratedValue\(strategy = GenerationType.AUTO/IDENTITY/ SEQUENCE\):** Oracle, PostgreSQL'de, ID'yi otomaik artırma SEQUENCE yardımı ile yapıyor. MS SQL Server ve MySQL ise IDENTITY yardımı ile... Bir de durumu veritabanının kontrolüne bırakan AUTO vardır, h2 gibi veritabanlarında kullanılır.

> Farklı Veritabanları için GeneratedValue Örnekleri

```text
/*
 * AUTO, IDENTITY, SEQUENCE ÖRNEKLERİ
 */

// AUTO - H2 vb.
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "example_id", length = 20)
private Long exampleId;

// AUTO 
@Id
  @GeneratedValue(strategy = GenerationType.IDENTİTY)
@Column(name = "example_id", length = 20)
private Long exampleId;

// SEQUENCE - Oracle, PostgresSQL
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EXAMPLE_ID")
@SequenceGenerator(name = "SEQ_EXAMPLE_ID", sequenceName = "SEQ_EXAMPLE_ID", allocationSize = 1, initialValue = 1000)
/* name: Uygulama içinde Sequence’in adını tanımlamaya yarar.
 * sequenceName: verilen string’i veritabanı katmanında sequence adı olarak tanıtır.
 * initialValue: id'in kaçtan başlayacağını belirtir.
 * allocationSize: Cache yapısı içinde, max. kaç id tutlacağını belirtmeye yarar.
 */
@Column(name = "example_id", length = 20)
private Long exampleId;

```

## **Domain Katmanının Oluşturulması**

**Post adında bir Entity sınıfı oluşturacağız.** 

Bu sınıf, içindeki üç alan \(id, title, content\) olan post adında bir tablo oluşturacak. Eskiden Entity sınıflarımız, serializable arayüzüne implemente edilerek serileştirilirdi. Ama Spring Data bünyesindeki repository katmanında kullandığımız arayüz bu işlemi otomatik olarak yapmaktadır.

```text
package com.vedatyildirim.basiccrudexample.domain;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long Id;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "content", length = 500)
    private String content;
}

```

{% hint style="info" %}
**NOT**

**@SQLDelete: Silme \(delete\) işlemi esnasında bir sql işlemi yapılacaksa, buna yardımcı olur. Bu annotasyon tıpkı Entity annotasyonu gibi sınıfın üzerine yazılır. Biz kullanmadık ama önemli olduğu için paylaştım. Aynı şeyi; insert ve update içinde kullanabilirsiniz. @SQLInsert, @SQLUpdate @SQLDeleteAll gibi annotastonlar da mevcuttur.**

**Örneğin; aşağıdaki örnekte silme esnasında veriyi silmez, silindi olarak günceller.**

**SQLDelete\(sql="UPDATE post SET status = 'deleted' WHERE id = ?"\)**
{% endhint %}

**Şimdi sırada Repository katmanımızı oluşturmak var.**

