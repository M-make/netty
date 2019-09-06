package netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ☞ 🏀 huqingfeng
 * @date 2019-09-05
 *
 *
 *  简单的解析两行数据
 */
public class SimpleHttpRequestCodec  extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(read(in));
        out.add(read(in));
    }

    private String read(ByteBuf in) {
        List<Byte> bytes = new ArrayList<Byte>();
        for (;in.readableBytes() != 0;) {

            byte dt = in.readByte();
            System.out.println((char)dt);
            if (dt == '\n'){
                break;
            }
            bytes.add(dt);
        }
        byte[] d = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            d[i] = bytes.get(i);
        }
        System.out.println(" === ");
        return new String(d);
    }
}
