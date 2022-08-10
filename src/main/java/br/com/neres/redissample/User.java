package br.com.neres.redissample;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String name;

    @OneToMany
    private List<User> followers;
    @OneToMany
    private Set<Post> posts;

    public Long getId() {
        return id;
    }
}
