---
description: >-
  Domain Katmanı diye adlandırdığımız kısım, ORM yardımı ile @Entity
  notasyonları ile POJO sınıflarımızla veritabanı tablolarını oluşturduğumuz ve
  üzerinden CRUD işlemlerini yapacağımız kısımdır.
---

# Veritabanı ve İlişki Kullanımı Hakkında Açıklama

Domain katmanında POJO sınıflarımız vardır. Bu sınıfları JPA/Hibernate\(Spring Data JPA ile gelir\) kullanarak, ORM yöntemi ile veritabanı tablolarına dönüştürürüz. Bu notasyonlar sadece springe özel değil, hibernate/jpa kullanılan bütün java projeleri için geçerlidir.

**Spring Data ile JPA/Hibernate kullanarak oluşturacağınız bir Spring Boot projesinde, genel ORM mantığını, JPA/Hibernate kullanımını ve temel anatosyonlarını özetleyen bir yazı yazmaya çalışacağım.**

Aşağıda kısaca, kullanacağımız temel anotasyonlardan en önemlilerini kısaca özetleyeceğim:

**@Entity**: Sınıfı, veritabanı tablosuna eşitler.

**@Table\(name = "article"\)**: Tablonun ismi sınıftan farklı olacaksa..

#### @SQLDelete: Bu anotasyon, silme \(delete\) işlemi esnasında bir sql işlemi yapılacaksa, buna yardımcı olur. Bu notasyon tıpkı Entity notasyonu gibi sınıfın üzerine yazılır.

Örneğin, aşağıdaki örnekte veriyi silmez, silindi olarak günceller.

```
SQLDelete(sql="UPDATE post SET status = 'deleted' WHERE id = ?")
```

**@Id**: Her tablonun olmazsa olmaz ID'sinin notasyonudur.

**@GeneratedValue\(strategy = GenerationType.IDENTITY\):** Oracle PostgreSQL veritabanı id otomatizasyonunu Sequence ile yapıyorlar. Microsoft’un SQL Server’ı ile MySql ise Identity ile işlemi yapıyor. Bir de durumu veritabanının kontolüne bırakan AUTO vardır, o da h2 de falan işe yarar.

**@NotNull**: Boş olamaz.

**@Column\(name = "title", length = 300\)**: Kolon adı ve uzunluğu.

_**Sequence kullanımına örnek:**_

```text
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EXAMPLE_ID")
@SequenceGenerator(name = "SEQ_EXAMPLE_ID", sequenceName = "SEQ_EXAMPLE_ID", allocationSize = 1, initialValue = 1000)
@Id
@Column(name = "example_id", length = 20)
private Long exampleId;
```

* _**name**_ özelliği uygulama içinde Sequence’in adını tanımlamaya yarar.
* _**sequenceName**_ özelliği verilen string’i veri tabanı katmanında sequence adı olarak tanıtır.
* _**initialValue**_ özelliği id sütununun kaçtan başlıyacağını bildirir. Bu örnekte gelecek ilk kayıt 1 numaralı id’ye sahip olacak.
* _**allocationSize**_ özelliği cache yapısı içinde kaç tane bilgi id tutulacak onu belirtmeye yarar. Bu örnekte girilecek ilk kaydın id’si 1 olacak ve uygulama biz allocationSize’ı 1000 verdiğimiz için 1 ile 1001 arasındaki id’leri tutacak.

_**Auto ve Identity Kullanımına Örnek:**_

```text
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    veya
    @GeneratedValue(strategy = GenerationType.IDENTİTY)
    @Column(name = "example_id", length = 20)
    private Long exampleId;
```

\*\*\*\*

**@EntityListeners\(AuditingEntityListener.class\)**: ****

_@CreatedDate_ ve _@LastModifiedDate_ notasyonları için kullanılır. Projenin ayarları altındaki Otomatik tarih bölümünde nasıl eklendiğini anlattım. \(Hazırladıysan Config klasöründe Jpa ile başlayan iki dosya buna aittir\). 

**Lomboka ait anotasyonlar: Lombokun kullanımından projeyi oluştururken bahsetmiştik. @Data \( @Getter @Setter \) @NoArgsConstructor @AllArgsConstructor ...**

