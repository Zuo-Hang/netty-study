package com.example.nettystudy.codeTest.tcpClient;

import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.example.nettystudy.codeTest.commend.UserCreat;
import com.example.nettystudy.codeTest.dtoObject.DTObject;
import com.example.nettystudy.codeTest.handler.ByteUtils;
import com.example.nettystudy.codeTest.tcpProtocol.TcpProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/07/28/11:12
 * @Description:
 */
public class EchoHandler extends ChannelInboundHandlerAdapter {

    /**连接成功后发送消息测试
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserCreat userCreat=new UserCreat();
        userCreat.setCommend("creat");
        userCreat.setNickName("hang hang");
        userCreat.setPassword("123456");
        userCreat.setPhoneNumber("15389425034");
        DTObject dtObject = new DTObject();
        dtObject.setClassName(userCreat.getClass().getName());
        dtObject.setObject(ProtobufProxy.create(UserCreat.class).encode(userCreat));
        TcpProtocol tcpProtocol = new TcpProtocol();
        byte[] encode = ProtobufProxy.create(DTObject.class).encode(dtObject);
        tcpProtocol.setLen(encode.length);
        tcpProtocol.setData(encode);
        ctx.write(tcpProtocol);
        ctx.flush();
    }
}
