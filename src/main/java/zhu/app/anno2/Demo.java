package zhu.app.anno2;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

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
        /*DepartmentDao mapper = session.getMapper(DepartmentDao.class);
        Department dept = mapper.findById(1);
        System.out.println(dept.getDname());
        System.out.println(dept.getEmpList().get(0).getEname());*/
       /* EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        Employee emp = mapper.findById2(1);
        System.out.println(emp.getEname());
        System.out.println(emp.getDept().getDname());*/



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
