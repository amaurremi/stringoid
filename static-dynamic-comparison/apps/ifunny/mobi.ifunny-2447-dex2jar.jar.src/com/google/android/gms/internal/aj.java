package com.google.android.gms.internal;

import android.util.Base64OutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class aj {
    private final int a;
    private final int b;
    private final ai c = new an();
    private Base64OutputStream d;
    private ByteArrayOutputStream e;

    public aj(int paramInt) {
        this.b = paramInt;
        this.a = 6;
    }

    private String b(String paramString) {
        paramString = paramString.split("\n");
        if ((paramString == null) || (paramString.length == 0)) {
            return "";
        }
        this.e = new ByteArrayOutputStream();
        this.d = new Base64OutputStream(this.e, 10);
        Arrays.sort(paramString, new ak(this));
        int i = 0;
        if ((i < paramString.length) && (i < this.b)) {
            if (paramString[i].trim().length() == 0) {
            }
            for (; ; ) {
                i += 1;
                break;
                try {
                    this.d.write(this.c.a(paramString[i]));
                } catch (IOException localIOException) {
                    mx.b("Error while writing hash to byteStream", localIOException);
                }
            }
        }
        try {
            this.d.flush();
            this.d.close();
            paramString = this.e.toString();
            return paramString;
        } catch (IOException paramString) {
            mx.b("HashManager: Unable to convert to base 64", paramString);
        }
        return "";
    }

    String a(String paramString) {
        paramString = paramString.split("\n");
        if ((paramString == null) || (paramString.length == 0)) {
            return "";
        }
        this.e = new ByteArrayOutputStream();
        this.d = new Base64OutputStream(this.e, 10);
        Object localObject = new PriorityQueue(this.b, new al(this));
        int i = 0;
        if (i < paramString.length) {
            String[] arrayOfString = am.b(paramString[i]);
            if (arrayOfString.length < this.a) {
            }
            for (; ; ) {
                i += 1;
                break;
                ao.a(arrayOfString, this.b, this.a, (PriorityQueue) localObject);
            }
        }
        paramString = ((PriorityQueue) localObject).iterator();
        while (paramString.hasNext()) {
            localObject = (ap) paramString.next();
            try {
                this.d.write(this.c.a(((ap) localObject).b));
            } catch (IOException localIOException) {
                mx.b("Error while writing hash to byteStream", localIOException);
            }
        }
        try {
            this.d.flush();
            this.d.close();
            paramString = this.e.toString();
            return paramString;
        } catch (IOException paramString) {
            mx.b("HashManager: unable to convert to base 64", paramString);
        }
        return "";
    }

    public String a(ArrayList<String> paramArrayList) {
        StringBuffer localStringBuffer = new StringBuffer();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
            localStringBuffer.append(((String) paramArrayList.next()).toLowerCase());
            localStringBuffer.append('\n');
        }
        switch (0) {
            default:
                return "";
            case 0:
                return a(localStringBuffer.toString());
        }
        return b(localStringBuffer.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */