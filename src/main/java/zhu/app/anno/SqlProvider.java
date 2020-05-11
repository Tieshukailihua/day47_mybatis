package zhu.app.anno;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SqlProvider {
    public String findAll(){

        return   new SQL(){
            {
                SELECT("*");
                FROM("employee");

                //SELECT("*").FROM("employee");
            }
        }.toString();
    }
    public String findById(){
        return new SQL(){
            {
                SELECT("*");
                FROM("employee");
                WHERE("id=#{id}");
            }
        }.toString();
    }


    //如果只是在sql中，取参数进行sql的拼接，不用写Map参数
    //如果需要在代码中，对某些参数进行条件判断，必须写上Map参数
    public String findInfo(Map<String,Object> map){
        return new SQL(){
            {
                SELECT("*");
                FROM("employee");
                if(map.get("name") != null){
                    WHERE("name like concat('%',#{name},'%')");
                }
                if (map.get("age") != null){
                    //WHERE("age=#{age}");
                    //or 拼接
                    OR().WHERE("age=#{age}");
                }
            }
        }.toString();
    }

    public String update(Employee emp){
        return new SQL(){
            {
                UPDATE("employee");
                if (emp.getName() != null){
                    SET("name=#{name}");
                }
                if (emp.getAge() != null){
                    SET("age=#{age}");
                }
                if (emp.getSex() != null){
                    SET("sex=#{sex}");
                }
                if (emp.getPhone() != null){
                    SET("phone=#{phone}");
                }
                WHERE("id=#{id}");

            }
        }.toString();
    }
}
