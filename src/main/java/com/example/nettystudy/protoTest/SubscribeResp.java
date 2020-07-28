package com.example.nettystudy.protoTest;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: hang hang
 * @Date: 2020/07/27/20:28
 * @Description:
 */
public class SubscribeResp {
    @Protobuf(fieldType = FieldType.INT32, order = 1, required = true)
    private int subReqID;
    @Protobuf(fieldType = FieldType.STRING, order = 2, required = true)
    private int respCode;
    @Protobuf(fieldType = FieldType.STRING, order = 2, required = true)
    private String desc;

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SubscribeResp{" +
                "subReqID=" + subReqID +
                ", respCode=" + respCode +
                ", desc='" + desc + '\'' +
                '}';
    }
}
