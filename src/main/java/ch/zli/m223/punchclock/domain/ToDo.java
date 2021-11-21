package ch.zli.m223.punchclock.domain;

import javax.persistence.*;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String toDoName;

    public Long getId() {
        return id;
    }
    public String getToDoNameName() {
        return toDoName;
    }
    public void setToDoName(String toDoName) {
        this.toDoName = toDoName;
    }
}

