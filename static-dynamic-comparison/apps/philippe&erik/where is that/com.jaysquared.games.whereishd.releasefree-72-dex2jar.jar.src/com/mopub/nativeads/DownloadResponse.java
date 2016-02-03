package com.mopub.nativeads;

class DownloadResponse
{
  private byte[] bytes;
  private final long contentLength;
  private final int statusCode;
  
  /* Error */
  DownloadResponse(org.apache.http.HttpResponse paramHttpResponse)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 17	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: newarray <illegal type>
    //   8: putfield 19	com/mopub/nativeads/DownloadResponse:bytes	[B
    //   11: new 21	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 22	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_3
    //   22: new 24	java/io/BufferedInputStream
    //   25: dup
    //   26: aload_1
    //   27: invokeinterface 30 1 0
    //   32: invokeinterface 36 1 0
    //   37: invokespecial 39	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_2
    //   41: aload_2
    //   42: aload 4
    //   44: invokestatic 45	com/mopub/common/util/Streams:copyContent	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   47: aload_0
    //   48: aload 4
    //   50: invokevirtual 49	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   53: putfield 19	com/mopub/nativeads/DownloadResponse:bytes	[B
    //   56: aload_2
    //   57: invokestatic 53	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   60: aload 4
    //   62: invokestatic 53	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   65: aload_0
    //   66: aload_1
    //   67: invokeinterface 57 1 0
    //   72: invokeinterface 63 1 0
    //   77: putfield 65	com/mopub/nativeads/DownloadResponse:statusCode	I
    //   80: aload_0
    //   81: aload_1
    //   82: invokeinterface 30 1 0
    //   87: invokeinterface 69 1 0
    //   92: putfield 71	com/mopub/nativeads/DownloadResponse:contentLength	J
    //   95: return
    //   96: astore_2
    //   97: aload_3
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 53	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   103: aload 4
    //   105: invokestatic 53	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_3
    //   111: aload_2
    //   112: astore_1
    //   113: aload_3
    //   114: astore_2
    //   115: goto -16 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	DownloadResponse
    //   0	118	1	paramHttpResponse	org.apache.http.HttpResponse
    //   40	17	2	localBufferedInputStream	java.io.BufferedInputStream
    //   96	16	2	localObject1	Object
    //   114	1	2	localObject2	Object
    //   21	77	3	localObject3	Object
    //   110	4	3	localObject4	Object
    //   18	86	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   22	41	96	finally
    //   41	56	110	finally
  }
  
  byte[] getByteArray()
  {
    return this.bytes;
  }
  
  long getContentLength()
  {
    return this.contentLength;
  }
  
  int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/DownloadResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */