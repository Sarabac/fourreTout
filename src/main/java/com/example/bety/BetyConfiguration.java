package com.example.bety;

import com.example.bety.model.mapper.PersonMapper;
import com.example.bety.model.mapper.RoleMapper;
import com.example.bety.repository.PersonRepo;
import com.example.bety.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BetyConfiguration {


    @Bean
    public PersonService personService(PersonRepo personRepo, PersonMapper personMapper, List<String> firstnames) {
        return new PersonService(personRepo, personMapper, firstnames);
    }

    @Bean
    public PersonMapper personMapper(RoleMapper roleMapper) {
        return new PersonMapper(roleMapper);
    }

    @Bean
    public RoleMapper roleMapper() {
        return new RoleMapper();
    }

    @Bean
    public List<String> names() {
        return Arrays.asList("bob", "john", "toto");
    }

    @Bean List<String> firstnames()
    {
        return Arrays.asList("Joe", "Alice");
    }

}
