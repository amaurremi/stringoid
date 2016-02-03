package com.mopub.common;

import com.mopub.common.util.ResponseHeader;
import org.apache.http.Header;

public class DownloadResponse {
    private byte[] a;
    private final int b;
    private final long c;
    private final Header[] d;

    /* Error */
    public DownloadResponse(org.apache.http.HttpResponse paramHttpResponse) {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 17	java/lang/Object:<init>	()V
        //   4: aload_0
        //   5: iconst_0
        //   6: newarray <illegal type>
        //   8: putfield 19	com/mopub/common/DownloadResponse:a	[B
        //   11: new 21	java/io/ByteArrayOutputStream
        //   14: dup
        //   15: invokespecial 22	java/io/ByteArrayOutputStream:<init>	()V
        //   18: astore_3
        //   19: new 24	java/io/BufferedInputStream
        //   22: dup
        //   23: aload_1
        //   24: invokeinterface 30 1 0
        //   29: invokeinterface 36 1 0
        //   34: invokespecial 39	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   37: astore_2
        //   38: aload_2
        //   39: aload_3
        //   40: invokestatic 45	com/mopub/common/util/Streams:copyContent	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //   43: aload_0
        //   44: aload_3
        //   45: invokevirtual 49	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   48: putfield 19	com/mopub/common/DownloadResponse:a	[B
        //   51: aload_2
        //   52: invokestatic 53	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   55: aload_3
        //   56: invokestatic 53	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   59: aload_0
        //   60: aload_1
        //   61: invokeinterface 57 1 0
        //   66: invokeinterface 63 1 0
        //   71: putfield 65	com/mopub/common/DownloadResponse:b	I
        //   74: aload_0
        //   75: aload_0
        //   76: getfield 19	com/mopub/common/DownloadResponse:a	[B
        //   79: arraylength
        //   80: i2l
        //   81: putfield 67	com/mopub/common/DownloadResponse:c	J
        //   84: aload_0
        //   85: aload_1
        //   86: invokeinterface 71 1 0
        //   91: putfield 73	com/mopub/common/DownloadResponse:d	[Lorg/apache/http/Header;
        //   94: return
        //   95: astore_1
        //   96: aconst_null
        //   97: astore_2
        //   98: aload_2
        //   99: invokestatic 53	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   102: aload_3
        //   103: invokestatic 53	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   106: aload_1
        //   107: athrow
        //   108: astore_1
        //   109: goto -11 -> 98
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	112	0	this	DownloadResponse
        //   0	112	1	paramHttpResponse	org.apache.http.HttpResponse
        //   37	62	2	localBufferedInputStream	java.io.BufferedInputStream
        //   18	85	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
        // Exception table:
        //   from	to	target	type
        //   19	38	95	finally
        //   38	51	108	finally
    }

    public byte[] getByteArray() {
        return this.a;
    }

    public long getContentLength() {
        return this.c;
    }

    public String getFirstHeader(ResponseHeader paramResponseHeader) {
        Header[] arrayOfHeader = this.d;
        int j = arrayOfHeader.length;
        int i = 0;
        while (i < j) {
            Header localHeader = arrayOfHeader[i];
            if (localHeader.getName().equals(paramResponseHeader.getKey())) {
                return localHeader.getValue();
            }
            i += 1;
        }
        return null;
    }

    public int getStatusCode() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/DownloadResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */