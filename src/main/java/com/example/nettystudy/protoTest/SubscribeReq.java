package com.example.nettystudy.protoTest;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: hang hang
 * @Date: 2020/07/27/20:25
 * @Description:
 */
public class SubscribeReq {
    @Protobuf(fieldType = FieldType.INT32, order = 1, required = true)
    private int subReqID;
    @Protobuf(fieldType = FieldType.STRING, order = 2, required = true)
    private String userName;
    @Protobuf(fieldType = FieldType.STRING, order = 3, required = true)
    private String productName;
    @Protobuf(fieldType = FieldType.STRING, order = 4, required = true)
    private String address;

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SubscribeReq{" +
                "subReqID=" + subReqID +
                ", userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
