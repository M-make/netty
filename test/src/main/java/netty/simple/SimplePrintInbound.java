package netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-09-05
 */
public class SimplePrintInbound extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof String){
            System.err.println( "receive : " + msg);
            ByteBuf msg1 = ctx.alloc().buffer().writeBytes(((String) msg).getBytes());

            ctx.write(msg1);
        }
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
        System.out.println("done");
    }
}
