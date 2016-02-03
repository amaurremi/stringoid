package com.mobisystems.pdf.signatures;

import com.mobisystems.pdf.PDFError;

public class PDFTimeStampServerImpl
{
  private long _handle = 0L;
  
  public PDFTimeStampServerImpl()
  {
    PDFError.throwError(init());
  }
  
  private native void destroy();
  
  private native int init();
  
  private native int setTsResult(byte[] paramArrayOfByte, long paramLong);
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  /* Error */
  public int requestTimeStamp(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    // Byte code:
    //   0: new 43	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 44	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: astore 6
    //   13: new 46	java/net/URL
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 49	java/net/URL:<init>	(Ljava/lang/String;)V
    //   21: aload_2
    //   22: ldc 51
    //   24: ldc 53
    //   26: aload 7
    //   28: aconst_null
    //   29: invokestatic 59	com/mobisystems/pdf/signatures/UrlUtils:downloadUrlPost	(Ljava/net/URL;[BLjava/lang/String;Ljava/lang/String;Ljava/io/OutputStream;Lcom/mobisystems/pdf/signatures/UrlUtils$AsyncTaskCallback;)V
    //   32: aload 7
    //   34: astore 6
    //   36: aload_0
    //   37: aload 7
    //   39: invokevirtual 63	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: lload_3
    //   43: invokespecial 65	com/mobisystems/pdf/signatures/PDFTimeStampServerImpl:setTsResult	([BJ)I
    //   46: istore 5
    //   48: aload 7
    //   50: ifnull +8 -> 58
    //   53: aload 7
    //   55: invokevirtual 68	java/io/ByteArrayOutputStream:close	()V
    //   58: iload 5
    //   60: ireturn
    //   61: astore_1
    //   62: ldc 70
    //   64: aload_1
    //   65: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   68: pop
    //   69: iload 5
    //   71: ireturn
    //   72: astore_1
    //   73: aconst_null
    //   74: astore 7
    //   76: aload 7
    //   78: astore 6
    //   80: ldc 78
    //   82: aload_1
    //   83: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   86: pop
    //   87: aload 7
    //   89: ifnull +8 -> 97
    //   92: aload 7
    //   94: invokevirtual 68	java/io/ByteArrayOutputStream:close	()V
    //   97: sipush 64549
    //   100: ireturn
    //   101: astore_1
    //   102: ldc 70
    //   104: aload_1
    //   105: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   108: pop
    //   109: goto -12 -> 97
    //   112: astore_1
    //   113: aconst_null
    //   114: astore 7
    //   116: aload 7
    //   118: astore 6
    //   120: ldc 78
    //   122: aload_1
    //   123: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   126: pop
    //   127: aload 7
    //   129: ifnull +8 -> 137
    //   132: aload 7
    //   134: invokevirtual 68	java/io/ByteArrayOutputStream:close	()V
    //   137: sipush 64549
    //   140: ireturn
    //   141: astore_1
    //   142: ldc 70
    //   144: aload_1
    //   145: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   148: pop
    //   149: goto -12 -> 137
    //   152: astore_1
    //   153: aconst_null
    //   154: astore 7
    //   156: aload 7
    //   158: astore 6
    //   160: ldc 78
    //   162: aload_1
    //   163: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   166: pop
    //   167: aload 7
    //   169: ifnull +8 -> 177
    //   172: aload 7
    //   174: invokevirtual 68	java/io/ByteArrayOutputStream:close	()V
    //   177: sipush 64549
    //   180: ireturn
    //   181: astore_1
    //   182: ldc 70
    //   184: aload_1
    //   185: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   188: pop
    //   189: goto -12 -> 177
    //   192: astore_1
    //   193: aconst_null
    //   194: astore 7
    //   196: aload 7
    //   198: astore 6
    //   200: ldc 78
    //   202: aload_1
    //   203: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   206: pop
    //   207: aload 7
    //   209: ifnull +8 -> 217
    //   212: aload 7
    //   214: invokevirtual 68	java/io/ByteArrayOutputStream:close	()V
    //   217: sipush 64549
    //   220: ireturn
    //   221: astore_1
    //   222: ldc 70
    //   224: aload_1
    //   225: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   228: pop
    //   229: goto -12 -> 217
    //   232: astore_1
    //   233: aconst_null
    //   234: astore 6
    //   236: aload 6
    //   238: ifnull +8 -> 246
    //   241: aload 6
    //   243: invokevirtual 68	java/io/ByteArrayOutputStream:close	()V
    //   246: aload_1
    //   247: athrow
    //   248: astore_2
    //   249: ldc 70
    //   251: aload_2
    //   252: invokestatic 76	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   255: pop
    //   256: goto -10 -> 246
    //   259: astore_1
    //   260: goto -24 -> 236
    //   263: astore_1
    //   264: goto -68 -> 196
    //   267: astore_1
    //   268: goto -112 -> 156
    //   271: astore_1
    //   272: goto -156 -> 116
    //   275: astore_1
    //   276: goto -200 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	PDFTimeStampServerImpl
    //   0	279	1	paramString	String
    //   0	279	2	paramArrayOfByte	byte[]
    //   0	279	3	paramLong	long
    //   46	24	5	i	int
    //   11	231	6	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   7	206	7	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   53	58	61	java/io/IOException
    //   0	9	72	java/net/MalformedURLException
    //   92	97	101	java/io/IOException
    //   0	9	112	java/net/SocketTimeoutException
    //   132	137	141	java/io/IOException
    //   0	9	152	java/io/IOException
    //   172	177	181	java/io/IOException
    //   0	9	192	java/lang/InterruptedException
    //   212	217	221	java/io/IOException
    //   0	9	232	finally
    //   241	246	248	java/io/IOException
    //   13	32	259	finally
    //   36	48	259	finally
    //   80	87	259	finally
    //   120	127	259	finally
    //   160	167	259	finally
    //   200	207	259	finally
    //   13	32	263	java/lang/InterruptedException
    //   36	48	263	java/lang/InterruptedException
    //   13	32	267	java/io/IOException
    //   36	48	267	java/io/IOException
    //   13	32	271	java/net/SocketTimeoutException
    //   36	48	271	java/net/SocketTimeoutException
    //   13	32	275	java/net/MalformedURLException
    //   36	48	275	java/net/MalformedURLException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFTimeStampServerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */