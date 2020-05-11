package zhu.app.anno;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeDao {

    //查询
    @Select("select * from employee")
    public List<Employee> findAll();

    @Select("selecr * from employee where id=#{id}")
    public Employee findById(Integer id);

    @Delete("delete from employee where id=#{id}")
    public void deleteById(Integer id);

    @Insert("insert into employee(name,age,sex,phone) values(#{name},#{age},#{sex},#{phone})")
    //设置相关属性
    //@Options(useGeneratedKeys = true, keyProperty = "id")
    //statement 设置执行的sql语句：before 表示是否先执行 resultType 结果的类型（Class类型）
    @SelectKey(statement = "select last_insert_id()",before = false,keyProperty = "id",resultType = int.class)
    public void add(Employee emp);

    @Update("update employee set name=#{name},age=#{age},sex=#{sex},phone=#{phone} where id=#{id}")
    public void update(Employee emp);

    //@Param 修饰参数 最终会将所有修饰的参数封装到map结构中
    @Select("select * from employee limit #{index},#{size}")
    public List<Employee> findByIndexAndSize(@Param("index") Integer index, @Param("size") Integer size);


    public List<Employee> findByIndexAndSize2(@Param("index") Integer index, @Param("size") Integer size);

    @Select("select id,name ename,age,sex,phone from employee where id=#{id}")
    //id 表示映射关系的唯一值
    // value 表示具体的字段和属性的映射关系
    //@Result id = true 表示主键
    @Results(id = "empMap",
            value = {@Result(column = "id", property = "id", id = true),
                    @Result(column = "ename", property = "name"),
                    @Result(column = "age", property = "age"),
                    @Result(column = "sex", property = "sex"),
                    @Result(column = "phone", property = "phone")})
    public Employee findById2(Integer id);


    @Select("select id,name ename,age,sex,phone from employee where id=#{id}")
    //指定已有映射关系
    @ResultMap("empMap2")//设置XML中指定的映射关系
    public Employee findById3(Integer id);

    //找到指定类中的方法，获取sql语句
    @SelectProvider(type = SqlProvider.class,method ="findAll" )
    public List<Employee> findAll2();

    @SelectProvider(type = SqlProvider.class, method = "findById")
    public Employee findById4(Integer id);

    @SelectProvider(type = SqlProvider.class,method = "findInfo")
    public List<Employee> findByCondition(@Param("name") String name,@Param("age") Integer age);

    @UpdateProvider(type = SqlProvider.class,method = "update")
    public void update2(Employee emp);
}
