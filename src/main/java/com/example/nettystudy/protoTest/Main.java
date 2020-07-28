package com.example.nettystudy.protoTest;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: hang hang
 * @Date: 2020/07/27/11:51
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Codec<SubscribeReq> simpleTypeCodec = ProtobufProxy
                .create(SubscribeReq.class);

        //创建并赋值
        SubscribeReq stt = new SubscribeReq();
        stt.setSubReqID(11);
        stt.setProductName("netty权威指南");
        stt.setAddress("黄埔大道");
        stt.setUserName("hanghang");
        System.out.println(stt);
//        String code = ProtobufIDLGenerator.getIDL(SimpleTypeTest.class);
//        System.out.println(code);
        try {
            // 序列化
            byte[] bb = simpleTypeCodec.encode(stt);
            System.out.println(Arrays.toString(bb));
            // 反序列化
            SubscribeReq newStt = simpleTypeCodec.decode(bb);
            System.out.println(newStt.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
