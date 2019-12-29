# Controller Katmanı

**PostController:**

```text
package com.vedatyildirim.restfulcrudexample.controller;

import com.vedatyildirim.restfulcrudexample.dto.PostDto;
import com.vedatyildirim.restfulcrudexample.service.impl.PostServiceImpl;
import com.vedatyildirim.restfulcrudexample.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.lang.Long;

@Api(value = "/post", description = "Post APIs")
@CrossOrigin(origins = "*")
@RequestMapping("/posts")
@RestController
public class PostController {


    @Autowired
    private final PostServiceImpl postServiceImpl;

    public PostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }


    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = PostDto.class)
    public ResponseEntity<TPage<PostDto>> getAllByPagination(Pageable pageable) {
        TPage<PostDto> data = postServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/")
    @ApiOperation(value = "Get All Operation", response = PostDto.class)
    public ResponseEntity<List<PostDto>> getAllByPagination() {
        List<PostDto> data = postServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = PostDto.class)
    public ResponseEntity<PostDto> getById(@PathVariable(value = "id", required = true) Long id) {
        PostDto post = postServiceImpl.getById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = PostDto.class)
    public ResponseEntity<PostDto> create(@Valid @RequestBody PostDto post) {
        return ResponseEntity.ok(postServiceImpl.save(post));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = PostDto.class)
    public ResponseEntity<PostDto> update(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody PostDto post) {
        return ResponseEntity.ok(postServiceImpl.update(id, post));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(postServiceImpl.delete(id));
    }
}
```

**AuthorController:**

```text
package com.vedatyildirim.restfulcrudexample.controller;

import com.vedatyildirim.restfulcrudexample.dto.AuthorDto;
import com.vedatyildirim.restfulcrudexample.service.impl.AuthorServiceImpl;
import com.vedatyildirim.restfulcrudexample.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.lang.Long;


@Api(value = "/author", description = "Author APIs")
@CrossOrigin(origins = "*")
@RequestMapping("/author")
@RestController
public class AuthorController {


    @Autowired
    private final AuthorServiceImpl authorServiceImpl;

    public AuthorController(AuthorServiceImpl authorServiceImpl) {
        this.authorServiceImpl = authorServiceImpl;
    }


    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = AuthorDto.class)
    public ResponseEntity<TPage<AuthorDto>> getAllByPagination(Pageable pageable) {
        TPage<AuthorDto> data = authorServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/")
    @ApiOperation(value = "Get All Operation", response = AuthorDto.class, responseContainer = "List")
    public ResponseEntity<List<AuthorDto>> getAll() {
        List<AuthorDto> data = authorServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = AuthorDto.class)
    public ResponseEntity<AuthorDto> getById(@PathVariable(value = "id", required = true) Long id) {
        AuthorDto authorDto = authorServiceImpl.getById(id);
        return ResponseEntity.ok(authorDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = AuthorDto.class)
    public ResponseEntity<AuthorDto> create(@Valid @RequestBody AuthorDto author) {
        return ResponseEntity.ok(authorServiceImpl.save(author));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = AuthorDto.class)
    public ResponseEntity<AuthorDto> update(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody AuthorDto author) {
        return ResponseEntity.ok(authorServiceImpl.update(id, author));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(authorServiceImpl.delete(id));
    }
}
```

