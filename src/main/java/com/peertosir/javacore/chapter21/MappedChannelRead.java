package com.peertosir.javacore.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappedChannelRead {
    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("C:\\texts\\TEXT.txt"))){
            long fSize = fileChannel.size();

            MappedByteBuffer mappedByteBuffer = fileChannel.map(
                    FileChannel.MapMode.READ_ONLY,
                    0,
                    fSize
            );

            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mappedByteBuffer.get());
            }
            System.out.println();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
