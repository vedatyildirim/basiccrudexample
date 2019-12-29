---
description: Boş sunucu üzerine kurulum işlemleri ve yayınlama... Burada iki yöntem vardır.
---

# Angular/Frontend Kısmının Yayına Alınması

#### Bunun iki yöntemi vardır.

Sonuç itibari ile ikisi de bize build işleminde oluşan bir dist klasörü türetiyor, ng serve gibi run etmiyoruz, etmemeliyiz de zaten. Yani her iki seçimde de dist klasörünü bir yere alıp **nginx sunumucumuz** üzerinden çalıştırmak ve spring/projemizle haberleştirmek durumundayız. Fakat 2. seçimde sunucuda yapılması gereken angular-cli kurulumunda ve ardından deploy süreçlerinde alınan hatalar ve bug'lar müdahale etmek açısından biraz sıkıntılı ve zordur.

## 1. Localde IDE'mizin içinde deploy edip dist klasörününü FTP\(FileZilla gibi bit tool ile\) yöntemi ile sunucuya almaktır.

1. Dist klasörünü FTP yardımı ile sunucudaki root dizimiz altında bir yere yükleriz. Kayıp yalşanmaması ve hata oluşmaması ve hızlı olması açısından dist klasörümüzü **zip klasörü** olarak sunucudaki gerekli dizine alır ardından PUTTY ile zipten çıkarırız\(Örnek: home/user/vedat/shipmanager dizini altında: unzip dist.zip komutu ile koayca hallederiz\). **Devamı Diğer Bölümde \(Nginx ile Projeyi Yayınlama\)**...

## 2. Bu kısım için önce angular cli'ın \(6 sürümü - projede kullanılan sürüm\) kurulması gereklidir. Ardından aşağıdaki adımları yaparak ilerleyebilirsiniz. İndirmek için kaynak:[ Kaynak](https://libraries.io/npm/@angular%2Fcli/6.2.6)

Git üzerinden çalışarak, spring boot tarafında olduğu gibi sunucuda deploy etmektir. Fakat sunucuda yapılması gereken angular-cli kurulumunda ve ardından deploy süreçlerinde alınan hatalar ve bug'lar müdahale etmek açısından biraz sıkıntılı ve zordur.

> **1.1.** Bu kısım için önce **angular cli**'ın \(6 sürümü - projede kullanılan sürüm\) **kurulması gerekir**. Ardından aşağıdaki adımları yaparak ilerleyebilirsiniz. İndirmek için kaynak:z[ Kaynak](https://libraries.io/npm/@angular%2Fcli/6.2.6)
>
> _npm install @angular/cli@6.2.6_
>
> **1.2. Proje git'ten klonlanır.**
>
> _git clone projeadresiniz \(Örnek: git clone https://gitadresi_
>
> **1.3. Proje klasörüne gidilir.**

> _Örnek: cd_ restcrud-master
>
> **Pull Alınacaksa:**

> Hangi branchte olunduğu öğrenilecekse: _git branch_
>
> Başka branche geçilecse: _git checkout_ \(Örnek: restcrud-master vs..\)

> Pull alınacaksa: _git pull_

> **Npm paketleri indirilir.**

> _npm install_
>
> **Proje build edilir**
>
> _ng build --prod_  VEYA _npm run build_  
>
>
> **İşlemden Çıkılır.**

> Ctrl + C
>
> exit



