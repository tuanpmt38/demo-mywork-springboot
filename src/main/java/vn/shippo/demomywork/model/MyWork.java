package vn.shippo.demomywork.model;

import javax.persistence.*;

@Entity
@Table(name = "myworks")
public class MyWork {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public MyWork(){}

    public MyWork(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
