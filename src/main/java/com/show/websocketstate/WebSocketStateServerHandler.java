package com.show.websocketstate;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author zhengfawei
 * @create 2019-06-09 下午10:48
 * @desc
 **/
public class WebSocketStateServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if(evt instanceof IdleStateEvent){
            IdleStateEvent event= (IdleStateEvent) evt;
            String eventType=null;
            switch (event.state()){
                case ALL_IDLE:
                    eventType="读写空闲";
                    break;
                case READER_IDLE:
                    eventType="读空闲";
                    break;
                case WRITER_IDLE:
                    eventType="写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+"超时时间"+eventType);
            ctx.channel().close();
        }
    }
}
