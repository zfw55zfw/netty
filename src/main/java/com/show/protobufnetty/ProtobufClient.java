package com.show.protobufnetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author zhengfawei
 * @create 2019-06-12 下午11:55
 * @desc
 **/
public class ProtobufClient {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ProtobufClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

        }finally {
            eventLoopGroup.shutdownGracefully();
        }

    }
}
