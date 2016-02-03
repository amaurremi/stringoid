package com.mobisystems.pdf.signatures;

import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFTrace;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

public class PDFCertificateStoreImpl
{
  private long _handle = 0L;
  
  public PDFCertificateStoreImpl()
  {
    PDFError.throwError(init());
  }
  
  private native void destroy();
  
  private native int init();
  
  private native boolean matchSubject(long paramLong1, long paramLong2);
  
  private native int matchSubject2(long paramLong, byte[] paramArrayOfByte);
  
  private native int setCRL(byte[] paramArrayOfByte, long paramLong);
  
  private native int setCert(byte[] paramArrayOfByte, long paramLong);
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public int findCertificateBySubject(long paramLong1, long paramLong2)
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance("AndroidCAStore");
      localKeyStore.load(null, null);
      Enumeration localEnumeration = localKeyStore.aliases();
      while (localEnumeration.hasMoreElements())
      {
        X509Certificate localX509Certificate = (X509Certificate)localKeyStore.getCertificate((String)localEnumeration.nextElement());
        Principal localPrincipal = localX509Certificate.getSubjectDN();
        if ((localPrincipal instanceof X500Principal))
        {
          int i = matchSubject2(paramLong1, ((X500Principal)localPrincipal).getEncoded());
          if (i == 0)
          {
            i = setCert(localX509Certificate.getEncoded(), paramLong2);
            return i;
          }
          if (i != 64538) {
            return i;
          }
        }
        else
        {
          return 64537;
        }
      }
    }
    catch (KeyStoreException localKeyStoreException)
    {
      PDFTrace.e("Error while looking a certificate", localKeyStoreException);
      return 64537;
    }
    catch (CertificateException localCertificateException)
    {
      PDFTrace.e("Error while looking a certificate", localCertificateException);
      return 64537;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      PDFTrace.e("Error while looking a certificate", localNoSuchAlgorithmException);
      return 64537;
    }
    catch (IOException localIOException)
    {
      PDFTrace.e("Error while looking a certificate", localIOException);
      return 64537;
    }
    return 64538;
  }
  
  /* Error */
  public int getCRLByUri(String paramString, long paramLong)
  {
    // Byte code:
    //   0: sipush 64549
    //   3: istore 5
    //   5: new 113	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 114	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 7
    //   14: aload 7
    //   16: astore 6
    //   18: new 116	java/net/URL
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 119	java/net/URL:<init>	(Ljava/lang/String;)V
    //   26: aload 7
    //   28: aconst_null
    //   29: invokestatic 125	com/mobisystems/pdf/signatures/UrlUtils:downloadUrl	(Ljava/net/URL;Ljava/io/OutputStream;Lcom/mobisystems/pdf/signatures/UrlUtils$AsyncTaskCallback;)V
    //   32: aload 7
    //   34: astore 6
    //   36: aload_0
    //   37: aload 7
    //   39: invokevirtual 128	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: lload_2
    //   43: invokespecial 130	com/mobisystems/pdf/signatures/PDFCertificateStoreImpl:setCRL	([BJ)I
    //   46: istore 4
    //   48: iload 4
    //   50: istore 5
    //   52: aload 7
    //   54: ifnull +12 -> 66
    //   57: aload 7
    //   59: invokevirtual 133	java/io/ByteArrayOutputStream:close	()V
    //   62: iload 4
    //   64: istore 5
    //   66: iload 5
    //   68: ireturn
    //   69: astore_1
    //   70: ldc -121
    //   72: aload_1
    //   73: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   76: pop
    //   77: iload 4
    //   79: ireturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore 7
    //   84: aload 7
    //   86: astore 6
    //   88: ldc -119
    //   90: aload_1
    //   91: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   94: pop
    //   95: aload 7
    //   97: ifnull -31 -> 66
    //   100: aload 7
    //   102: invokevirtual 133	java/io/ByteArrayOutputStream:close	()V
    //   105: sipush 64549
    //   108: ireturn
    //   109: astore_1
    //   110: ldc -121
    //   112: aload_1
    //   113: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   116: pop
    //   117: sipush 64549
    //   120: ireturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore 7
    //   125: aload 7
    //   127: astore 6
    //   129: ldc -119
    //   131: aload_1
    //   132: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   135: pop
    //   136: aload 7
    //   138: ifnull -72 -> 66
    //   141: aload 7
    //   143: invokevirtual 133	java/io/ByteArrayOutputStream:close	()V
    //   146: sipush 64549
    //   149: ireturn
    //   150: astore_1
    //   151: ldc -121
    //   153: aload_1
    //   154: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   157: pop
    //   158: sipush 64549
    //   161: ireturn
    //   162: astore_1
    //   163: aconst_null
    //   164: astore 7
    //   166: aload 7
    //   168: astore 6
    //   170: ldc -119
    //   172: aload_1
    //   173: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   176: pop
    //   177: aload 7
    //   179: ifnull -113 -> 66
    //   182: aload 7
    //   184: invokevirtual 133	java/io/ByteArrayOutputStream:close	()V
    //   187: sipush 64549
    //   190: ireturn
    //   191: astore_1
    //   192: ldc -121
    //   194: aload_1
    //   195: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   198: pop
    //   199: sipush 64549
    //   202: ireturn
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 7
    //   207: aload 7
    //   209: astore 6
    //   211: ldc -119
    //   213: aload_1
    //   214: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   217: pop
    //   218: aload 7
    //   220: ifnull -154 -> 66
    //   223: aload 7
    //   225: invokevirtual 133	java/io/ByteArrayOutputStream:close	()V
    //   228: sipush 64549
    //   231: ireturn
    //   232: astore_1
    //   233: ldc -121
    //   235: aload_1
    //   236: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   239: pop
    //   240: sipush 64549
    //   243: ireturn
    //   244: astore_1
    //   245: aconst_null
    //   246: astore 6
    //   248: aload 6
    //   250: ifnull +8 -> 258
    //   253: aload 6
    //   255: invokevirtual 133	java/io/ByteArrayOutputStream:close	()V
    //   258: aload_1
    //   259: athrow
    //   260: astore 6
    //   262: ldc -121
    //   264: aload 6
    //   266: invokestatic 103	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   269: pop
    //   270: goto -12 -> 258
    //   273: astore_1
    //   274: goto -26 -> 248
    //   277: astore_1
    //   278: goto -71 -> 207
    //   281: astore_1
    //   282: goto -116 -> 166
    //   285: astore_1
    //   286: goto -161 -> 125
    //   289: astore_1
    //   290: goto -206 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	PDFCertificateStoreImpl
    //   0	293	1	paramString	String
    //   0	293	2	paramLong	long
    //   46	32	4	i	int
    //   3	64	5	j	int
    //   16	238	6	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   260	5	6	localIOException	IOException
    //   12	212	7	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   57	62	69	java/io/IOException
    //   5	14	80	java/net/MalformedURLException
    //   100	105	109	java/io/IOException
    //   5	14	121	java/net/SocketTimeoutException
    //   141	146	150	java/io/IOException
    //   5	14	162	java/io/IOException
    //   182	187	191	java/io/IOException
    //   5	14	203	java/lang/InterruptedException
    //   223	228	232	java/io/IOException
    //   5	14	244	finally
    //   253	258	260	java/io/IOException
    //   18	32	273	finally
    //   36	48	273	finally
    //   88	95	273	finally
    //   129	136	273	finally
    //   170	177	273	finally
    //   211	218	273	finally
    //   18	32	277	java/lang/InterruptedException
    //   36	48	277	java/lang/InterruptedException
    //   18	32	281	java/io/IOException
    //   36	48	281	java/io/IOException
    //   18	32	285	java/net/SocketTimeoutException
    //   36	48	285	java/net/SocketTimeoutException
    //   18	32	289	java/net/MalformedURLException
    //   36	48	289	java/net/MalformedURLException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/signatures/PDFCertificateStoreImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */