package com.xue.foundation.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                int ready = selector.select();
                if (ready == 0) continue;
                Set keys = selector.selectedKeys();
                Iterator iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = (SelectionKey) iterator.next();
                    System.out.println(key.isConnectable()  + "  " + key.isAcceptable() + "  " + key.isReadable() +"  " + key.isWritable());
                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = serverSocketChannel1.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(256));
                    }
                    if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.close();
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            selector.close();
            serverSocketChannel.close();
        }
    }
}
