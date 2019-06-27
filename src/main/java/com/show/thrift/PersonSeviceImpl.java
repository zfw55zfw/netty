package com.show.thrift;

import org.apache.thrift.TException;

/**
 * @author zhengfawei
 * @create 2019-06-19 下午2:01
 * @desc
 **/
public class PersonSeviceImpl implements PersonService.Iface {


    @Override
    public void savePerson(Person Person) throws TException {
        System.out.println(Person.getAge());
        System.out.println(Person.getName());
        System.out.println(Person.isMarried());
    }

    @Override
    public Person getPerson(String name) throws TException {
        return new Person().setName(name).setAge(111).setMarried(true);
    }
}
