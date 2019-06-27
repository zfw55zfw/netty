package com.show.thrift;

import org.apache.thrift.TException;

/**
 * @author zhengfawei
 * @create 2019-06-19 上午10:42
 * @desc
 **/
public class StudentHandler implements StudentService.Iface {

    @Override
    public void saveStudent(Student student) throws TException {
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.isMarried());
    }

    @Override
    public Student getStudent(String name) throws TException {
        return  new Student().setName(name).setAge(18).setMarried(false);
    }
}
