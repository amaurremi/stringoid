package com.flurry.sdk;

import android.util.Pair;
import android.widget.Toast;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogRequest;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogResponse;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class s
        extends de {
    private final w a = new w();

    public s() {
        this(null);
    }

    public s(de.a parama) {
        super("Ads", s.class.getSimpleName());
        this.g = "AnalyticsData_";
        a(parama);
    }

    protected Pair<String, byte[]> a(byte[] paramArrayOfByte) {
        int j = 0;
        byte[] arrayOfByte2 = new byte[4];
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.length - 4];
        int i = 0;
        if (i < paramArrayOfByte.length) {
            if (i < 4) {
                arrayOfByte2[i] = paramArrayOfByte[i];
            }
            for (; ; ) {
                i += 1;
                break;
                arrayOfByte1[(i - 4)] = paramArrayOfByte[i];
            }
        }
        int k = ByteBuffer.wrap(arrayOfByte2).getInt();
        paramArrayOfByte = new byte[k];
        arrayOfByte2 = new byte[arrayOfByte1.length - k];
        i = j;
        if (i < arrayOfByte1.length) {
            if (i < k) {
                paramArrayOfByte[i] = arrayOfByte1[i];
            }
            for (; ; ) {
                i += 1;
                break;
                arrayOfByte2[(i - k)] = arrayOfByte1[i];
            }
        }
        return new Pair(new String(paramArrayOfByte), arrayOfByte2);
    }

    public SdkLogResponse a(SdkLogRequest paramSdkLogRequest, String paramString1, String paramString2, String paramString3) {
        paramSdkLogRequest = v.a(paramSdkLogRequest, SdkLogRequest.class);
        if (paramSdkLogRequest != null) {
            b(a(paramSdkLogRequest, paramString1), paramString2, paramString3);
        }
        paramSdkLogRequest = new SdkLogResponse();
        paramSdkLogRequest.a("success");
        return paramSdkLogRequest;
    }

    protected void a(byte[] paramArrayOfByte, final String paramString1, final String paramString2) {
        try {
            Object localObject = a(paramArrayOfByte);
            paramArrayOfByte = (String) ((Pair) localObject).first;
            localObject = (byte[]) ((Pair) localObject).second;
            eo.a(4, this.d, "FlurryAdLogsManager: start upload data " + localObject + " with id = " + paramString1 + " to " + paramArrayOfByte);
            this.a.a(this, paramArrayOfByte, (byte[]) localObject, SdkLogResponse.class, new w.a() {
                public void a(int paramAnonymousInt, SdkLogResponse paramAnonymousSdkLogResponse) {
                    if ((paramAnonymousSdkLogResponse != null) && (paramAnonymousSdkLogResponse.b().toString().equals("success"))) {
                        eo.a(5, s.a(s.this), "FlurryAdLogsManager: ad report " + paramString1 + " sent. HTTP response: " + paramAnonymousInt);
                        if ((eo.c() <= 3) && (eo.d())) {
                            do.a().a(new Runnable() {
                                public void run() {
                                    Toast.makeText( do.a().b(), "Ad log report sent", 0).show();
                                }
                            });
                        }
                        s.a(s.this, paramString1, paramString2, paramAnonymousInt);
                        s.b(s.this);
                        return;
                    }
                    if (paramAnonymousSdkLogResponse != null) {
                        paramAnonymousSdkLogResponse = paramAnonymousSdkLogResponse.c().iterator();
                        while (paramAnonymousSdkLogResponse.hasNext()) {
                            CharSequence localCharSequence = (CharSequence) paramAnonymousSdkLogResponse.next();
                            eo.a(6, s.c(s.this), localCharSequence.toString());
                        }
                    }
                    s.a(s.this, paramString1, paramString2);
                }
            });
            return;
        } catch (Exception paramArrayOfByte) {
            eo.a(6, this.d, "Internal ERROR! Report is corrupt!");
            c(paramString1, paramString2);
        }
    }

    protected byte[] a(byte[] paramArrayOfByte, String paramString) {
        paramString = paramString.getBytes();
        int i = paramString.length;
        byte[] arrayOfByte1 = ByteBuffer.allocate(4).putInt(i).array();
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramString.length + paramArrayOfByte.length];
        i = 0;
        if (i < arrayOfByte2.length) {
            if (i < arrayOfByte1.length) {
                arrayOfByte2[i] = arrayOfByte1[i];
            }
            for (; ; ) {
                i += 1;
                break;
                if ((i >= arrayOfByte1.length) && (i < paramString.length + arrayOfByte1.length)) {
                    arrayOfByte2[i] = paramString[(i - 4)];
                } else {
                    arrayOfByte2[i] = paramArrayOfByte[(i - 4 - paramString.length)];
                }
            }
        }
        return arrayOfByte2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */