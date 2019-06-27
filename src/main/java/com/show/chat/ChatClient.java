package com.show.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zhengfawei
 * @create 2019-06-09 下午10:34
 * @desc
 **/
public class ChatClient {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                channel.writeAndFlush(bufferedReader.readLine()+"\r\n");
            }
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
