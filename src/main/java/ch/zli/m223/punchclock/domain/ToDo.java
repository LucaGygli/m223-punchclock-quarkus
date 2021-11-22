package ch.zli.m223.punchclock.domain;

import javax.persistence.*;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String toDoName;

    @OneToOne
    @JoinColumn(name = "task_Id",nullable = true)
    private Task task;

    public Long getId() {
        return id;
    }
    public String getToDoName() {
        return toDoName;
    }
    public void setToDoName(String toDoName) {
        this.toDoName = toDoName;
    }
}

