package com.example.springbootblogapplication.config;

import com.example.springbootblogapplication.models.Account;
import com.example.springbootblogapplication.models.Post;
import com.example.springbootblogapplication.repositories.PostRepository;
import com.example.springbootblogapplication.services.AccountService;
import com.example.springbootblogapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception{
        List<Post> posts = postService.getAll();

        if (posts.isEmpty()) {

            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("first");
            account1.setLastName("last");
            account1.setEmail("first.last@domain.com");
            account1.setPassword("password");

            account2.setFirstName("second");
            account2.setLastName("last");
            account2.setEmail("second.last@domain.com");
            account2.setPassword("password");

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("title of post 1");
            post1.setBody("This is the body of post 1");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("title of post 2");
            post2.setBody("This is the body of post 2");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);
        }
    }
}
