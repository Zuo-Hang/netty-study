package com.example.nettystudy.codeTest.handler;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.example.nettystudy.codeTest.commend.UserCreat;
import com.example.nettystudy.codeTest.dtoObject.DTObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/07/28/10:47
 * @Description:
 */
public class BusinessHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = Logger.getLogger(this.getClass());
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof byte []){
            logger.debug("解码后的字节码："+new String((byte[]) msg,"UTF-8"));
            try {
                DTObject objectContainer = ProtobufProxy.create(DTObject.class).decode((byte[]) msg);
                if (objectContainer instanceof DTObject){
                    DTObject data = (DTObject) objectContainer;
                    if (data.getClassName()!=null&&data.getObject().length>0){
                        Class<?> aClass = Class.forName(data.getClassName());
                        Object decode = ProtobufProxy.create(aClass).decode(data.getObject());
                        if(decode instanceof UserCreat){
                            UserCreat userCreat=(UserCreat)decode;
                        }
                        logger.info("收到实体对象："+decode);
                    }
                }
            }catch (Exception e){
                logger.info("对象反序列化出现问题："+e);
            }

        }
    }
}
