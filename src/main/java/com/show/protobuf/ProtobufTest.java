package com.show.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author zhengfawei
 * @create 2019-06-12 下午11:16
 * @desc
 **/
public class ProtobufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBookProtos.Student show = AddressBookProtos.Student.newBuilder().
                setId(1).setName("show").setEmail("show@shuai.com").build();
        byte[] bytes = show.toByteArray();
        AddressBookProtos.Student show2 = AddressBookProtos.Student.parseFrom(bytes);
        System.out.println(show.getId());
        System.out.println(show.getName());
        System.out.println(show.getEmail());
    }
}
