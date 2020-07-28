package com.example.nettystudy.tcpprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/07/28/16:09
 * @Description:
 */
public class EncoderHandler_3_0 extends MessageToByteEncoder {
    private  Logger logger = Logger.getLogger(this.getClass());
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        if (msg instanceof TcpProtocol_3_0){
            TcpProtocol_3_0 protocol = (TcpProtocol_3_0) msg;
            out.writeByte(protocol.getHeader());
            out.writeByte(protocol.getClassLen());
            out.writeInt(protocol.getLen());
            out.writeBytes(protocol.getClassName());
            out.writeBytes(protocol.getData());
            out.writeByte(protocol.getTail());
            logger.debug("数据编码成功："+out);
        }else {
            logger.info("不支持的数据协议："+msg.getClass()+"\t期待的数据协议类是："+ TcpProtocol_3_0.class);
        }
    }
}
