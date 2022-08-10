package br.com.neres.redissample;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Avatar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String name;

//    @OneToMany
//    private List<User> followers;
//    @OneToMany
//    private Set<Post> posts;

    public Long getId() {
        return id;
    }
}
