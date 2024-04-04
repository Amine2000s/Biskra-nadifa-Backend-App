package com.chabiamin.restapidatabase.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class imageUtils {




    public static byte[] compressImage(byte[] data){

        Deflater deflater = new Deflater() ;
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] tmp = new byte[4*1024];

        while(!deflater.finished()){

            int size = deflater.deflate(tmp);
            outputStream.write(tmp , 0  ,size);

        }

        try{
            outputStream.close();
        }catch (Exception ex){

        }

        return outputStream.toByteArray();

    }


    public static byte[] decompressImage(byte[] data){

        Inflater inflater = new Inflater() ;
        inflater.setInput(data);

        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream(data.length) ;

        byte[]tmp = new byte [4*1024] ;

        try{
            while(!inflater.finished()){

                int count = inflater.inflate(tmp);
                byteArrayOutputStream.write(tmp,0,count);
            }
        }catch (Exception ex){

        }

        return byteArrayOutputStream.toByteArray();

    }



}
