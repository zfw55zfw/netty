package com.show.protobufnetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhengfawei
 * @create 2019-06-12 下午11:45
 * @desc
 **/
public class ProtobufServerHandler extends SimpleChannelInboundHandler<DataInfo.Student>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        System.out.println(msg.getName());
        System.out.println(msg.getId());
        System.out.println(msg.getEmail());
    }
}
