package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class v {
    private static final String a = v.class.getSimpleName();
    private static gg b = new gg();

    public static <A extends gw> A a(byte[] paramArrayOfByte, Class<A> paramClass) {
        if (paramArrayOfByte == null) {
        }
        for (; ; ) {
            try {
                eo.a(6, a, "convertBytesToResponse: bytes array is null");
                paramArrayOfByte = null;
                return paramArrayOfByte;
            } finally {
            }
            paramArrayOfByte = b(paramArrayOfByte, paramClass);
        }
    }

    public static <A extends gw> byte[] a(A paramA, Class<A> paramClass) {
        Object localObject = null;
        if (paramA == null) {
        }
        for (; ; ) {
            try {
                eo.a(6, a, "convertRequestToByte: Request is null");
                paramA = (A) localObject;
                return paramA;
            } finally {
            }
            paramClass = new gu(paramClass);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            gc localgc = gj.a().b(localByteArrayOutputStream, null);
            try {
                paramClass.a(paramA, localgc);
                localgc.flush();
                paramA = localByteArrayOutputStream.toByteArray();
            } catch (IOException paramA) {
                eo.a(6, a, "Error generating adlog request" + paramA.getMessage());
                paramA = (A) localObject;
            }
        }
    }

    private static <A extends gw> A b(byte[] paramArrayOfByte, Class<A> paramClass) {
        Object localObject = b.a(new ByteArrayInputStream(paramArrayOfByte), null);
        try {
            localObject = (gw) new gt(paramClass).a(null, (gf) localObject);
            return (A) localObject;
        } catch (ClassCastException localClassCastException) {
            eo.a(6, a, "ClassCastException in parseAvroBinary:" + localClassCastException.getMessage());
            eo.a(3, a, "ClassCastException in parseAvroBinary: bytes = " + paramArrayOfByte + " type = " + paramClass.getSimpleName());
            return null;
        } catch (IOException localIOException) {
            eo.a(6, a, "IOException in parseAvroBinary:" + localIOException.getMessage());
            eo.a(3, a, "IOException in parseAvroBinary: bytes = " + paramArrayOfByte + " type = " + paramClass.getSimpleName());
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */