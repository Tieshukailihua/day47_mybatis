package zhu.app.anno2;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentDao {


    //关系映射，使用注解的情况下，只可以实现嵌套查询的方式
    @Select("select * from t_dept where did=#{did}")
    //many 和 @Many 表示设置多个关系
    @Results(id = "deptMap",value = {
            @Result(column = "did", property = "did",id = true),
            @Result(column = "dname", property = "dname"),
            @Result(column = "did",property = "empList", javaType = ArrayList.class,
                    many = @Many(select = "zhu.app.anno2.EmployeeDao.findByDId",
                    fetchType = FetchType.EAGER))
    })
    public Department findById(Integer did);

    @Select("select * from t_dept where did=#{did}")
    public Department findById2(Integer did);

}
