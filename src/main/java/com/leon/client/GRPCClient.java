package com.leon.client;

import com.leon.grpc.User;
import com.leon.grpc.User.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.leon.grpc.userGrpc;
import com.leon.grpc.userGrpc.userBlockingStub;

public class GRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        LoginRequest loginRequest1 = LoginRequest.newBuilder().setUsername("HELLO-client").setPassword("HELLO").build() ;
        APIResponse response1 = userStub.login(loginRequest1);
        System.out.println("request:" + loginRequest1.toString() + "  response: "+ response1.toString());

        LoginRequest loginRequest2 = LoginRequest.newBuilder().setUsername("HELLO").setPassword("HELLO").build() ;
        APIResponse response2 = userStub.login(loginRequest2);
        System.out.println("request2:" + loginRequest2.toString() + "  response2: "+ response2.toString());

    }
}
