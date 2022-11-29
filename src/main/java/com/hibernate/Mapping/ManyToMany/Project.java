package com.hibernate.Mapping.ManyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    @Column(name = "project_name")
    private String projectName;
   // @ManyToMany(mappedBy = "project")
    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
