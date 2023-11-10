package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from tb_emp where id = #{id}")
    public int deleteEmp(Integer id);

//    insert into tb_emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)
//    VALUES(null, 'ceshishuju', 'ceshi', '123', 1, 'http://localhost:', 1, '2023-1-1', 2, now(), now());
    @Options(keyProperty = "id", useGeneratedKeys = true) // 会自动将生成的主键值赋值给 emp 对象的 id 属性
    @Insert("insert into tb_emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public int InsertEmp(Emp emp);

//    @Update("update tb_emp set " +
//            "username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, update_time=#{updateTime} where id = #{id}")
    public  int updateEmp(Emp emp);

    @Select("select id, username, name, password, gender, image, job, entrydate, create_time, update_time, dept_id from tb_emp where id = #{id}")
    public Emp selectEmp(Integer id);
//    @Select("select id, username, name, password, gender, image, job, entrydate, create_time createTime, update_time updateTime, dept_id deptId from tb_emp where id = #{id}")
//    public Emp selectEmp(Integer id);
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime"),
//    })
//    @Select("select * from tb_emp where id = #{id}")
//    public Emp selectEmp(Integer id);

    // 根据条件查询
//    @Select("select * from tb_emp where name like '%${name}%' and gender = #{gender} and entrydate between #{startDate} and #{endDate} order by update_time desc")
//    @Select("select * from tb_emp where name like concat('%', #{name}, '%') and gender = #{gender} and entrydate between #{startDate} and #{endDate} order by update_time desc")
    public List<Emp> selectConEmp(String name, Short gender, LocalDate startDate, LocalDate endDate);

    // 批量删除
    public int deleteXmlEmp(List<Integer> empIdList);
}
