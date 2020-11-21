package com.github.grant.admin.utils.security;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * ZoomGrant 2020/11/21 11:43
 */
public class GzipUtils {

    public byte[] gzip(byte[] datas) {
        try(ByteArrayOutputStream bout =  new ByteArrayOutputStream();
                GzipCompressorOutputStream gout =  new GzipCompressorOutputStream(bout)) {
            gout.write(datas);
            gout.flush();
            return bout.toByteArray();
        }catch (Exception e){
            return new byte[0];
        }
    }

    public byte[] ugzip(byte[] datas) {
        try(ByteArrayInputStream bin =  new ByteArrayInputStream(datas);
            GzipCompressorInputStream gin =  new GzipCompressorInputStream(bin)) {
            byte[] bytes = new byte[(int)gin.getCompressedCount()];
            gin.read(bytes);
            return bytes;
        }catch (Exception e){
            return new byte[0];
        }

    }
}
