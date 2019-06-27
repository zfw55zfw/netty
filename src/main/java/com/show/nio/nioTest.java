package com.show.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;

/**
 * @author zhengfawei
 * @create 2019-06-27 上午10:20
 * @desc
 **/
public class nioTest {
    public static void main(String[] args) throws Exception {
        FileOutNio();
    }
    private static void intBufferNio(){
        IntBuffer intBuffer= IntBuffer.allocate(10);
        for (int i=0;i<intBuffer.capacity();i++){
            int random = new SecureRandom().nextInt(20);
            intBuffer.put(random);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
    private static void FileInNio() throws  Exception{

        FileInputStream fileInputStream = new FileInputStream("nio.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer bf = ByteBuffer.allocate(512);

        int length=-1;

        while ((length=channel.read(bf))!=-1){
            byte[] bytes = bf.array();
            System.out.println("start..............");
            String str = new String(bytes, 0, length);
            System.out.println(str);
            System.out.println("end........");
            System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
        }
        channel.close();
        fileInputStream.close();
    }
    private static void FileOutNio() throws Exception{
        FileOutputStream fileOutputStream =new FileOutputStream("nio1.txt");
        FileChannel channel = fileOutputStream.getChannel();
        byte[] bytes = "aaaahdsafasks helolofdsafa".getBytes();
        ByteBuffer bf = ByteBuffer.allocate(512);
        bf.put(bytes);
        bf.flip();
        channel.write(bf);

        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
