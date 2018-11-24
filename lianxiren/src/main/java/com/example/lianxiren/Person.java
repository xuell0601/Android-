package com.example.lianxiren;

public class Person {
    public Person(String name){
        this.name = name;
        this.pingyin = PinYinUtils.getPinYin(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pingyin='" + pingyin + '\'' +
                '}';
    }

    private String name;
    private String pingyin;

}
