package com.example.demo22.ListenerTest;

/**
 * @ClassName Even
 * @Description TODO
 * @Author chenbilang
 * @Date 2019/4/23
 * @Version 1.0
 */
public class Even {
    private Person person;

    public Even(Person person) {
        super();
        this.person = person;
    }

    public Even() {
        super();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
