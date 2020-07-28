package com.example.nettystudy.codeTest.dtoObject;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/07/28/10:09
 * @Description:
 */
public class DTObject {
    /**
     * 以便在反序列化的时候使用Class.forName()获取Class
     * 要求：类名和包路径要完全匹配
     */
    @Protobuf(fieldType = FieldType.STRING, order=1, required = true)
    private String className;
    @Protobuf(fieldType = FieldType.BYTES, order=2, required = true)
    private byte[] object;

    public DTObject() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public byte[] getObject() {
        return object;
    }

    public void setObject(byte[] object) {
        this.object = object;
    }
}
