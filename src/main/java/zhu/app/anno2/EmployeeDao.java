package zhu.app.anno2;

import org.apache.ibatis.annotations.*;
import zhu.app.anno.SqlProvider;

import java.util.List;

public interface EmployeeDao {
    @Select("select * from t_emp where deptId=#{did} ")
    public List<Employee> findByDId(Integer did);
    @Select("select * from t_emp where eid=#{eid}")
    //one 和 @One 表示一的关系
    @Results(value = {
            @Result(column = "eid", property = "eid",id = true),
            @Result(column = "ename", property = "ename"),
            @Result(column = "deptId",property = "dept",
            one = @One(select = "zhu.app.anno2.DepartmentDao.findById2"))
    })
    public Employee findById(Integer eid);

    @Select("select * from t_emp e inner join t_dept d on e.deptId=d.did where e.eid=#{eid}")
    @ResultMap("empMap")
    public Employee findById2(Integer eid);

    //找到指定类中的方法，获取sql语句
    @SelectProvider(type = SqlProvider.class,method ="findAll" )
    public List<Employee> findAll2();

}
