---
description: >-
  Bu bölümde Swagger kullanımını, RESTful API için doküman oluşturmayı ve
  Swagger üzerinden CRUD işlemleri yapmayı göreceğiz.
---

# Swagger Kullanımı

Swagger, RESTful web servislerini için doküman oluşturma ve belgeleme işlemlerinde kullanılır. Sunduğu arayüz üzerinden postmande yaptığımız gibi CRUD işlemlerini falan da yapabiliriz.

**1.İlk olarak pom.xml dosyamıza Swagger’ı ekliyoruz.**

```text
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
```

**2. Uygulamamızın ana dizinin altında config adında bir paket ve SwaggerConfig adında bir sınıf oluşturuyoruz.** 

![Swagger Kullan&#x131;m&#x131;](https://lh6.googleusercontent.com/KVg_KSAT2iPYHijgC5CcOkAU6gllbPHxmBnCuXypjBW4T9AUjmlof0RWngUguFNG84SvLnKvc5ia24QFE45xyCiv0ndNVhIxHpyKWOZGXNswFwSIRb-KNeD9L-YuGNkUM1c3-pEu)

**3. SwaggerConfig sınıfımıza içerisinde konfigürasyonların bulunduğu, aşağıdaki kodu ekliyoruz.**

```text
package com.vedatyildirim.basiccrudexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

   ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("Post API Reference")
               .version("1.0.0")
               .build();
   }

   @Bean
   public Docket customImplementation() {
       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .select().paths(PathSelectors.any())
               .apis(RequestHandlerSelectors.basePackage("com.vedatyildirim.basiccrudexample"))
               .build()
               .pathMapping("/")
               .useDefaultResponseMessages(false)
               .directModelSubstitute(LocalDate.class, String.class)
               .genericModelSubstitutes(ResponseEntity.class);
   }
}

```

**4. Controller sınıfının üzerine API’nin adını, metodlarının üzerine de açıklamaları yazarız:**  


Sınıfın üzerine açıklamayı yapacağımız API annotasyonunu ekleriz. 

```text
@Api(value="post", description=" Post Operations Service")

```

Metodların üzerine ApiOperation annotasyonu ile açıklama yazarız. ApiResponses altında da tarayıcıdan dönecek her türlü sonuç için bir mesaj yazabiliriz.

```text
@ApiOperation(value = "View a list of available posts",response = Iterable.class)
@ApiResponses 
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "Successfully retrieved list"),
           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
   }

```

**Controller örneği:**

```text
package com.vedatyildirim.basiccrudexample.controller;

import com.vedatyildirim.basiccrudexample.domain.Post;
import com.vedatyildirim.basiccrudexample.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value="post", description=" Post Operations Service")
public class PostController {

   @Autowired
   private PostService postService;

   private static final Logger log = LoggerFactory.getLogger(PostController.class);


   @ApiOperation(value = "View a list of available posts",response = Iterable.class)
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "Successfully retrieved list"),
           @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
   }
   )
   @GetMapping("/")
   public ResponseEntity<Iterable<Post>> getAll() {
       return ResponseEntity.ok(postService.findAll());
   }


   @ApiOperation(value = "Search a post with an ID",response = Post.class)
   @GetMapping("/{id}")
   public ResponseEntity<Post> findById(@PathVariable Long id) {
       Optional<Post> post = postService.findById(id);
       if (!post.isPresent()) {
           log.error("Id " + id + " is not existed");
           ResponseEntity.badRequest().build();
       }
       return ResponseEntity.ok(post.get());
   }


   @ApiOperation(value = "Add a post")
   @PostMapping("/")
   public ResponseEntity create(@RequestBody Post post) {
       return ResponseEntity.ok(postService.save(post));
   }


   @ApiOperation(value = "Update a post")
   @PutMapping("/{id}")
   public ResponseEntity<Post> update(@PathVariable Long id, @Valid @RequestBody Post post) {
       if (!postService.findById(id).isPresent()) {
           log.error("Id " + id + " is not existed");
           ResponseEntity.badRequest().build();
       }
       return ResponseEntity.ok(postService.save(post));
   }


   @ApiOperation(value = "Delete a post")
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

  
**5.** [**http://localhost:9090/swagger-ui.html**](http://localhost:9090/swagger-ui.html) **adresinden, \(host ve port uygulamada ne verdiyseniz odur.\) ulaşabilirsiniz. Açılan arayüzde hem dokümanı görebilir, hem de Postman gibi CRUD işlemleri yapabilirsiniz.**

