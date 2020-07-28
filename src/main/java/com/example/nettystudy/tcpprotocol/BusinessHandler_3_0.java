package com.example.nettystudy.tcpprotocol;

import com.example.nettystudy.codeTest.handler.ByteUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/07/28/16:13
 * @Description:
 */
public class BusinessHandler_3_0 extends ChannelInboundHandlerAdapter {
    private ObjectMapper objectMapper= ByteUtils.InstanceObjectMapper();
    private Logger logger = Logger.getLogger(this.getClass());
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof List){
            logger.info("这是一个List:"+(List)msg);
        }else if (msg instanceof Map){
            logger.info("这是一个Map:"+(Map)msg);
        }else{
            logger.info("这是一个对象："+msg.getClass().getName());
            logger.info("这是一个对象："+msg);
        }
    }
}
