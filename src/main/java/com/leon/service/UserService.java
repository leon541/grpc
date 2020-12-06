package com.leon.service;


import com.leon.grpc.User;
import com.leon.grpc.User.*;
import com.leon.grpc.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {

        String userName = request.getUsername();
        String password = request.getPassword();
        APIResponse.Builder response = APIResponse.newBuilder();
        System.out.println("login: " + userName + " + " + password);
        if(userName.equals(password)) {
            response.setResponseCode(0).setResponseMessage("SUCCESS");
        } else {
            response.setResponseCode(1).setResponseMessage("FAILED");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}
