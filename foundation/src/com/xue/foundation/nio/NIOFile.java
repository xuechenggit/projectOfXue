package com.xue.foundation.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class NIOFile {

    private static String path = "C:\\Users\\www\\Desktop\\a.txt";

    public static void method1() {
        try(RandomAccessFile accessFile = new RandomAccessFile(path, "rw");){
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int res = -1;
            while ((res = fileChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(path, "rw");
        FileChannel fileChannel = accessFile.getChannel();
        Selector selector = Selector.open();

    }

    public static void client() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
            if (socketChannel.finishConnect()) {
                String str = "using nio";
                byteBuffer.clear();
                byteBuffer.put(str.getBytes());
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    socketChannel.write(byteBuffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //method1();
        client();
    }

}
