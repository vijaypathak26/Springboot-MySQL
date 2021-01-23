package com.springdb.mysql.springbootmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {

@javax.persistence.Id
@GeneratedValue
@Column(name = "Id")
    private Integer Id;
    @Column(name = "name")
    private String name;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "Salary")
    private Integer salary;

    public Users() {

    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


}
