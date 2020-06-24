package com.xue.foundation.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Pipe {

    private static java.nio.channels.Pipe pipe;
    static {
        try {
            pipe = java.nio.channels.Pipe.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sink() throws IOException {
        java.nio.channels.Pipe.SinkChannel sinkChannel = pipe.sink();
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put("hahaha".getBytes());
        byteBuffer.flip();
        sinkChannel.write(byteBuffer);
    }

    public static void source() throws IOException {
        java.nio.channels.Pipe.SourceChannel sourcePipe = pipe.source();
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.flip();
        while (sourcePipe.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        sink();
        source();
    }
}
