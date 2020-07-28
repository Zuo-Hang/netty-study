package com.example.nettystudy.codeTest.tcpProtocol;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/07/28/9:38
 * @Description:
 */
public class TcpProtocol {
    /**
     * 使用16进制表示协议的开始位和结束位，
     * 其中0x58代表开始，0x63代表结束，均用一个字节来进行表示。
     * 主要处理粘包/拆包问题
     */
    private byte header=0x58;
    private int len;
    private byte [] data;
    private byte tail=0x63;

    public byte getTail() {
        return tail;
    }

    public void setTail(byte tail) {
        this.tail = tail;
    }

    public TcpProtocol(int len, byte[] data) {
        this.len = len;
        this.data = data;
    }

    public TcpProtocol() {
    }

    public byte getHeader() {
        return header;
    }

    public void setHeader(byte header) {
        this.header = header;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
