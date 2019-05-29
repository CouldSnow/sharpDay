package com.zy.springboot.springbootmaven.Demo.Entity;

public class Emp {
    private Integer id;

    private String empname;

    private String emptype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public String getEmptype() {
        return emptype;
    }

    public void setEmptype(String emptype) {
        this.emptype = emptype == null ? null : emptype.trim();
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", emptype='" + emptype + '\'' +
                '}';
    }
}