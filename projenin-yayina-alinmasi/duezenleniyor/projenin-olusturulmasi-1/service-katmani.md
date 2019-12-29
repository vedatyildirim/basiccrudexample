# Service Katmanı

**PostService:**

```text
package com.vedatyildirim.restfulcrudexample.service;

import com.vedatyildirim.restfulcrudexample.dto.PostDto;
import com.vedatyildirim.restfulcrudexample.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    PostDto save(PostDto post);

    PostDto getById(Long postId);

    TPage<PostDto> getAllPageable(Pageable pageable);

    List<PostDto> getAll();

    Boolean delete(Long post);

    // For Author Relation Ship
    PostDto update(Long postId, PostDto author);

}
```

**PostServiceImpl:**

```text
package com.vedatyildirim.restfulcrudexample.service.impl;

import com.vedatyildirim.restfulcrudexample.domain.Post;
import com.vedatyildirim.restfulcrudexample.dto.PostDto;
import com.vedatyildirim.restfulcrudexample.repository.AuthorRepository;
import com.vedatyildirim.restfulcrudexample.repository.PostRepository;
import com.vedatyildirim.restfulcrudexample.util.TPage;
import com.vedatyildirim.restfulcrudexample.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private final PostRepository postRepository;

    // For Author Relationship
    @Autowired
    private final AuthorRepository authorRepository;

    @Autowired
    private final ModelMapper modelMapper;
    
    public PostServiceImpl(PostRepository postRepository, AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto save(PostDto post) {

        Post postEntity = modelMapper.map(post, Post.class);
        postEntity = postRepository.save(postEntity);

        post.setPostId(postEntity.getPostId());
        return post;
    }

    @Override
    public PostDto getById(Long id) {
        Post post = postRepository.getOne(id);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public TPage<PostDto> getAllPageable(Pageable pageable) {
        Page<Post> data = postRepository.findAll(pageable);
        TPage<PostDto> respnose = new TPage<PostDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), PostDto[].class)));
        return respnose;
    }

    public List<PostDto> getAll() {
        List<Post> data = postRepository.findAll();
        return Arrays.asList(modelMapper.map(data, PostDto[].class));
    }

    @Override
    public Boolean delete(Long id) {
        postRepository.deleteById(id);
        return true;
    }

    @Override
    public PostDto update(Long id, PostDto post) {
        Post postDb = postRepository.getOne(id);
        postDb.setPostId(post.getPostId());
        postDb.setTitle(post.getTitle());
        postDb.setBody(post.getBody());
        postRepository.save(postDb);
        return modelMapper.map(postDb, PostDto.class);
    }
}

```

**AuthorService:**

```text
package com.vedatyildirim.restfulcrudexample.service;

import com.vedatyildirim.restfulcrudexample.dto.AuthorDto;
import com.vedatyildirim.restfulcrudexample.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {

    AuthorDto save(AuthorDto author);

    AuthorDto getById(Long authorId);

    List<AuthorDto> getAll();

    TPage<AuthorDto> getAllPageable(Pageable pageable);

    Boolean delete(Long author);

    AuthorDto update(Long authorId, AuthorDto author);
}

```

**AuthorServiceImpl:**

```text
package com.vedatyildirim.restfulcrudexample.service.impl;

import com.vedatyildirim.restfulcrudexample.domain.Author;
import com.vedatyildirim.restfulcrudexample.dto.AuthorDto;
import com.vedatyildirim.restfulcrudexample.repository.AuthorRepository;
import com.vedatyildirim.restfulcrudexample.service.AuthorService;
import com.vedatyildirim.restfulcrudexample.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDto save(AuthorDto author) {

        Author authorEntity = modelMapper.map(author, Author.class);
        authorEntity = authorRepository.save(authorEntity);

        author.setAuthorId(authorEntity.getAuthorId());
        return author;
    }

    @Override
    public AuthorDto getById(Long id) {
        Author author = authorRepository.getOne(id);
        return modelMapper.map(author, AuthorDto.class);
    }

    @Override
    public List<AuthorDto> getAll() {
        List<Author> data = authorRepository.findAll();
        return Arrays.asList(modelMapper.map(data, AuthorDto[].class));
    }

    @Override
    public TPage<AuthorDto> getAllPageable(Pageable pageable) {
        Page<Author> data = authorRepository.findAll(pageable);
        TPage<AuthorDto> respnose = new TPage<AuthorDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), AuthorDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(Long id) {
        authorRepository.deleteById(id);
        return true;
    }

    @Override
    public AuthorDto update(Long id, AuthorDto author) {
        Author authorDb = authorRepository.getOne(id);
        authorDb.setAuthorId(author.getAuthorId());
        authorDb.setUname(author.getUname());
        authorDb.setName(author.getName());
        authorDb.setRole(author.getRole());

        authorRepository.save(authorDb);
        return modelMapper.map(authorDb, AuthorDto.class);
    }
}
```

