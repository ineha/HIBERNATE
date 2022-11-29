package com.hibernate.Mapping.ManyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Emp {
    @Id
    private int eid;
    private String name;
  @ManyToMany
  @JoinTable(
          name = "emp_learn",
          joinColumns={@JoinColumn(name = "eId")},
          inverseJoinColumns ={@JoinColumn(name = "pId")}
  ) //first column in join table is called "join column" , secodn column is called "inverse join"

  private List<Project> projects;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
