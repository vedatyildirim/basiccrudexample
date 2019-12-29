---
description: >-
  Bir Spring Boot projesini direk jar'ını deplo ederek çalıştırabiliriz. Ancak
  projede Angular kullandığımız için bir web sunucusuna ihtiyaç duyulmuştur.
---

# Nginx ile Projeyi Yayınlama

#### Nginx Sunucu Yapılandırma İşlemleri.

Buraya kadar olan kısımda bütün kurulumlar ve adımlar yapıldıysa; Veritabanı, Spring Boot ve Angular Deploy edilmiş halde hazır olmalıdır.

Yayına almak için NGINX sunucusunda bazı ayarlar yapmak gerekir.

#### 1.Configüration Dosyasının Düzenlenmesi

İster aşağıdaki gibi FTP üzerinden direk, ister PUTTY ile terminal üzerinden nginx\(cd /etc/nginx\) klasöründeki **nginx.conf** dosyasını nano komutu ile **açarız**.

![](https://lh3.googleusercontent.com/LG0RuMc7z0KP_q4zap7Cp2zAFg7dZg4yA4Sjjb4mb8TTQAy7j7ZmlBrQZoxG_AE2Fl0XlczwMY9B_e4BgjdmokUWROo2WafJxEVedqgeppVuyzypXT3XK6wHjqlxBhKfRJpn5T9o)

Bu noktada Öncelikler DNS ile yönledirilebilen, en az bir domain/alanadı sahibi olmamız gerekmektedir.  


Her bir parçayı\(backen, frontend vs.\) başka domain/alanadı altında da yayınlayabiliriz. Hatta farklı bir sürü projemiz olabilir ve bir sürü alanadımız veya subdomainimiz. Bunun sınırı yoktur.

Biz burada 3 tane kullanarak işlem yapıyoruz: backend için: api.vedatyildirim.com, file/klasör için: cdn.vedatyildirim.com ve frontend için: portal.vedatyildirim.com portal doğal olarak aynı zamanda uygulamanın web sitesidir.

Biz üç örnek üzerinden gideceğiz: api \(backend\), portal \(frontend/angular\) ve dosya yükleme için cdn subdomainlerini oluşturur, DNS A üzerinden dış IP'mizi yazarak yönlendiririz. [YÖNLEDİRME İÇİN DETAYLI ANLATIM LİNKTEDİR.](https://help.hover.com/hc/en-us/articles/217282457-How-to-Edit-DNS-records-A-AAAA-CNAME-MX-TXT-SRV-)  


#### Alanadı Üzerinden Uygulamalara Yönledirme Ayarları

Şimdi servername api.domain.com olursa buraya, portal.domain.com olursa şuraya vs. git diye ayarlarımızı yapmalı ve sadece tek IP üzerinden yayın yapan sunumuzu çoklu şekilde kullanmaya başlamalıyız.

#### Konfigurasyon Dosyalarını Oluşturma

FTP veya nano komutu ile **api.conf**, **portal.conf** ve **cdn. conf** dosyalarını oluşturur ve alttaki gibi oluşturulur ve **sites-enabled** klasörüne atılır.

**api.conf**: Bu ayarlar sistemin localhostunda çalışan spring boot uygulamasını dinleyerek, sunucumuza dahil eder.

```text
server {
  listen       80;
  listen [::]:80;
  server_name api.vedatyildirim.com;

location    / {
    gzip on;
    gzip_min_length  1100;
    gzip_buffers  4 1024k;
    gzip_types    text/css text/javascript text/xml text/plain text/x-component application/javascript application/x-ja$    gzip_va$
    gzip_comp_level  6;
    client_max_body_size 100M;

    proxy_pass  http://127.0.0.1:8080;
    proxy_redirect          off;
        proxy_ssl_session_reuse off;

        proxy_set_header Host            $host;
        proxy_set_header X-Real-IP       $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

  }

}
```

**cdn.conf**: Bu klasör uygulamaya yüklenecek dosya, resim vs. lerin klasörünün yolunu belirtir. Hangi klasöre yüklenmek istenirse yolu yazılır.

```text
server {
  listen       80;
  listen [::]:80;

  server_name  cdn.vedatyildirim.com;

  root /home/user/cdn;
  location / {
    index  index.html index.htm;
    try_files $uri $uri/ =404;
    }    error_page   500 502 503 504  /50x.html;
  location = /50x.html {
    root   html;
  }
}

```

**portal.conf**: Bu ayarlar sistemin dış Ipsinde çalışacak olan angular uygulamasının dist klasörünün yolunu belirtir. Hangi klasöre atıldıysa yolu yazılır.

```text
server {
  listen       80;
  listen [::]:80;
  server_name api.vedatyildirim.com;

location    / {
    gzip on;
    gzip_min_length  1100;
    gzip_buffers  4 1024k;
    gzip_types    text/css text/javascript text/xml text/plain text/x-component application/javascript application/x-ja$    gzip_va$
    gzip_comp_level  6;
    client_max_body_size 100M;

    proxy_pass  http://127.0.0.1:8080;
    proxy_redirect          off;
        proxy_ssl_session_reuse off;

        proxy_set_header Host            $host;
        proxy_set_header X-Real-IP       $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

  }

}

```

**nginx.conf**:Son olarak da **nginx** klasöründeki, **nginx.conf** adlı ana ayar dosyamıza hazırladığımız ayar dosyalarını ekliyoruz.

> Burada aşağıdaki include işlemleri önemlidir. Yani uzantısı conf ile biten ve sites-enabled klasöründe olan bütün dosyaları inculude etmiş/eklemiş oluyoruz.
>
> ```text
>         include /etc/nginx/conf.d/*.conf;
>         include /etc/nginx/sites-enabled/*;
> ```

```text
user www-data;
worker_processes auto;
pid /run/nginx.pid;

events {
        worker_connections 768;
        # multi_accept on;
}

http {

        ##
        # Basic Settings
        ##

        sendfile on;
        tcp_nopush on;
        tcp_nodelay on;
        keepalive_timeout 65;
        types_hash_max_size 2048;
        # server_tokens off;

        # server_names_hash_bucket_size 64;
        # server_name_in_redirect off;

        include /etc/nginx/mime.types;
        default_type application/octet-stream;

        ##
        # SSL Settings
        ##

        ssl_protocols TLSv1 TLSv1.1 TLSv1.2; # Dropping SSLv3, ref: POODLE
        ssl_prefer_server_ciphers on;

        ##
        # Logging Settings
        ##

        access_log /var/log/nginx/access.log;
        error_log /var/log/nginx/error.log;

        ##
        # Gzip Settings
        ##

        gzip on;
        gzip_disable "msie6";

        # gzip_vary on;
        # gzip_proxied any;
        # gzip_comp_level 6;
        # gzip_buffers 16 8k;
        # gzip_http_version 1.1;
        # gzip_types text/plain text/css application/json application/javascript text/xml application/xml application/xml+rss text/javascript;

        ##
        # Virtual Host Configs
        ##

        include /etc/nginx/conf.d/*.conf;
        include /etc/nginx/sites-enabled/*;
}


#mail {
#       # See sample authentication script at:
#       # http://wiki.nginx.org/ImapAuthenticateWithApachePhpScript
#
#       # auth_http localhost/auth.php;
#       # pop3_capabilities "TOP" "USER";
#       # imap_capabilities "IMAP4rev1" "UIDPLUS";
#
#       server {
#               listen     localhost:110;
#               protocol   pop3;
#               proxy      on;
#       }
#
#       server {
#               listen     localhost:143;
#               protocol   imap;
#               proxy      on;
#       }
#}
```

### **İşlemler tamamdır.** 

**Aynı klasör içinde default isimli bir dosya da vardır ama sonunda .conf olmadığı için bizim ayarlarımızın** dışındadır. İstenirse silinebilir.

**Sunucu Yeniden Başlatılır. Artık uygulamamıza erişebilir, sorunsuz çalışabiliriz.**

```text
sudo systemctl restart nginx
```

### Uygulamayı Hızlandırmak.

Bunun için nginx gzip işlemlerine internetten veya mevcut uygulamadaki örneklerden bakabilirsin.

####  Bir hata aldıysan:

Angularda **environment.prod.ts** ve **environment.prod.ts** den API nin URL'ini vermek zorundasın. Bunu unutmuş olabilirsin.

Veya Spring içerisinde **applications.properties** ve yml uzantılı config dosyalarındaki **server.port**'u kontrol etmelisin.

**TEŞEKKÜRLER!**

  


