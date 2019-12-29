---
description: >-
  Bu kısımda ister ModelMapper ile ister manual olarak DTO larımızı oluşturur,
  service ve entitylerin doğrudan konuşmasını engelemiş oluruz.
---

# Dto Katmanı

Aşağıdaki örnek ModelMapper ile yapılmıştır.

**PostDto:**

```text
package com.vedatyildirim.restfulcrudexample.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Post Data Transfer Object")
public class PostDto {
    @ApiModelProperty(required = true,value = "ID")
    private Long postId;
    @ApiModelProperty(required = true,value = "Title")
    private String title;
    @ApiModelProperty(required = true,value = "Body")
    private String body;
    @ApiModelProperty(required = true,value = "Author")
    private AuthorDto author;


}
```

**AuthorDto:**

> ```text
> package com.vedatyildirim.restfulcrudexample.dto;
>
> import io.swagger.annotations.ApiModel;
> import io.swagger.annotations.ApiModelProperty;
> import lombok.AllArgsConstructor;
> import lombok.Data;
> import lombok.NoArgsConstructor;
>
> @Data
> @AllArgsConstructor
> @NoArgsConstructor
> @ApiModel(value = "Author Data Transfer Object")
> public class AuthorDto {
>
>     @ApiModelProperty(required = true,value = "ID")
>     private Long authorId;
>     @ApiModelProperty(required = true,value = "Username")
>     private String uname;
>     @ApiModelProperty(required = true,value = "Name")
>     private String name;
>     @ApiModelProperty(required = true,value = "Role")
>     private String role;
>
> }
> ```

