package zhu.app.anno2;

import java.util.List;

public class Department {
    private Integer did;
    private String dname;
    //部门下包含的员工  empList
    private List<Employee> empList;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }
}
