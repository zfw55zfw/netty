package com.show.protobufnetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhengfawei
 * @create 2019-06-12 下午11:59
 * @desc
 **/
public class ProtobufClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder().setId(1).setName("show").setEmail("asdfsa").build();
        ctx.channel().writeAndFlush(student);
    }
}
