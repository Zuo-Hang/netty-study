package com.example.nettystudy.codeTest.handler;

import com.example.nettystudy.codeTest.tcpProtocol.TcpProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/07/28/10:36
 * @Description:编码处理器
 */
public class EncoderHandler extends MessageToByteEncoder {
    private  Logger logger = Logger.getLogger(this.getClass());
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        if (msg instanceof TcpProtocol){
            TcpProtocol protocol = (TcpProtocol) msg;
            out.writeByte(protocol.getHeader());
            out.writeInt(protocol.getLen());
            out.writeBytes(protocol.getData());
            out.writeByte(protocol.getTail());
            logger.debug("数据编码成功："+out);
        }else {
            logger.info("不支持的数据协议："+msg.getClass()+"\t期待的数据协议类是："+TcpProtocol.class);
        }
    }
}
