package zhu.app.anno;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    private static SqlSessionFactory factory = null;
    static {
        //读取主配置文件
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SQLSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(reader);
    }
    public static void select() {
        //创建SQLSession对象
        SqlSession session = factory.openSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        /*List<Employee> all = mapper.findAll2();
        System.out.println(all.size());
        System.out.println(all.get(0).getName());*/
       /* Employee byId4 = mapper.findById4(17);
        System.out.println(byId4.getName());*/
        //List<Employee> list = mapper.findByCondition("高",20);
       // System.out.println(list.get(0));

        Employee emp = new Employee();
        emp.setName("老板");
        emp.setAge(18);
        emp.setSex("0");
        emp.setId(11);
        emp.setPhone("111111111");
        mapper.update2(emp);
        System.out.println(emp.getId());
      //mapper.deleteById(7);
    /*    List<Employee> list = mapper.findByIndexAndSize(2, 5);
        System.out.println(list.get(0).getName());
        List<Employee> list1 = mapper.findByIndexAndSize2(2, 5);
        System.out.println(list1.get(0).getName());*/
      /*  Employee byId2 = mapper.findById3(10);
        System.out.println(byId2.getName());*/

        //提交
        session.commit();
        //关闭
        session.close();
    }
    public static void main(String[] args) {
        //add();
        //delete();
        //update();
        select();
    }
}
