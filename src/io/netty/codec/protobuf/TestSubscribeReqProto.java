package io.netty.codec.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author Yuicon
 */
public class TestSubscribeReqProto {

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("Yuicon");
        builder.setProductName("Netty Book");
        builder.setAddress("BeiJing LiuLiChang");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode : " + req.toString());
        SubscribeReqProto.SubscribeReq req1 = decode(encode(req));
        System.out.println("After decode : " + req.toString());
        System.out.println("Assert equal : --> " + req1.equals(req));
    }

}
