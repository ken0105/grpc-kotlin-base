package com.example.grpckotlinbase

import Greeter.Greet
import Greeter.GreeterServiceGrpc
import io.grpc.stub.StreamObserver

import org.lognet.springboot.grpc.GRpcService

@GRpcService
class GreeterService : GreeterServiceGrpc.GreeterServiceImplBase() {
    override fun hello(request: Greet.GreetRequest, responseObserver: StreamObserver<Greet.GreetResponse>) {
        val response: Greet.GreetResponse = Greet.GreetResponse.newBuilder().setMessage(
            "Hello" + request.name).build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}