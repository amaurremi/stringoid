package com.e.a;

import com.e.a.b.a.l;
import com.e.a.b.a.n;
import com.e.a.b.a.o;
import com.e.a.b.a.s;
import com.e.a.b.a.u;
import com.e.a.b.d;
import com.e.a.b.p;
import com.e.a.b.q;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URI;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class g
{
  private final String a;
  private final s b;
  private final String c;
  private final s d;
  private final String e;
  private final Certificate[] f;
  private final Certificate[] g;
  
  public g(InputStream paramInputStream)
  {
    try
    {
      p localp1 = new p(paramInputStream, q.d);
      this.a = localp1.a();
      this.c = localp1.a();
      this.b = new s();
      int k = localp1.b();
      int i = 0;
      while (i < k)
      {
        this.b.c(localp1.a());
        i += 1;
      }
      this.d = new s();
      this.d.b(localp1.a());
      k = localp1.b();
      i = j;
      while (i < k)
      {
        this.d.c(localp1.a());
        i += 1;
      }
      if (!a()) {
        break label237;
      }
      String str = localp1.a();
      if (str.length() > 0) {
        throw new IOException("expected \"\" but was \"" + str + "\"");
      }
    }
    finally
    {
      paramInputStream.close();
    }
    this.e = localp2.a();
    this.f = a(localp2);
    for (this.g = a(localp2);; this.g = null)
    {
      paramInputStream.close();
      return;
      label237:
      this.e = null;
      this.f = null;
    }
  }
  
  public g(URI paramURI, s params, HttpURLConnection paramHttpURLConnection)
  {
    this.a = paramURI.toString();
    this.b = params;
    this.c = paramHttpURLConnection.getRequestMethod();
    this.d = s.a(paramHttpURLConnection.getHeaderFields(), true);
    params = a(paramHttpURLConnection);
    if (params != null) {
      this.e = params.getSession().getCipherSuite();
    }
    try
    {
      paramURI = params.getSession().getPeerCertificates();
      this.f = paramURI;
      this.g = params.getSession().getLocalCertificates();
      return;
      this.e = null;
      this.f = null;
      this.g = null;
      return;
    }
    catch (SSLPeerUnverifiedException paramURI)
    {
      for (;;)
      {
        paramURI = (URI)localObject;
      }
    }
  }
  
  private SSLSocket a(HttpURLConnection paramHttpURLConnection)
  {
    if ((paramHttpURLConnection instanceof o)) {}
    for (paramHttpURLConnection = ((o)paramHttpURLConnection).a(); (paramHttpURLConnection instanceof n); paramHttpURLConnection = ((l)paramHttpURLConnection).b()) {
      return ((n)paramHttpURLConnection).t();
    }
    return null;
  }
  
  /* Error */
  private void a(Writer paramWriter, Certificate[] paramArrayOfCertificate)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +10 -> 11
    //   4: aload_1
    //   5: ldc -105
    //   7: invokevirtual 156	java/io/Writer:write	(Ljava/lang/String;)V
    //   10: return
    //   11: aload_1
    //   12: new 63	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: arraylength
    //   21: invokestatic 161	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   24: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: bipush 10
    //   29: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   32: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokevirtual 156	java/io/Writer:write	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: arraylength
    //   40: istore 4
    //   42: iconst_0
    //   43: istore_3
    //   44: iload_3
    //   45: iload 4
    //   47: if_icmpge -37 -> 10
    //   50: aload_2
    //   51: iload_3
    //   52: aaload
    //   53: invokevirtual 170	java/security/cert/Certificate:getEncoded	()[B
    //   56: invokestatic 175	com/e/a/b/b:b	([B)Ljava/lang/String;
    //   59: astore 5
    //   61: aload_1
    //   62: new 63	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   69: aload 5
    //   71: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: bipush 10
    //   76: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   79: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 156	java/io/Writer:write	(Ljava/lang/String;)V
    //   85: iload_3
    //   86: iconst_1
    //   87: iadd
    //   88: istore_3
    //   89: goto -45 -> 44
    //   92: astore_1
    //   93: new 61	java/io/IOException
    //   96: dup
    //   97: aload_1
    //   98: invokevirtual 178	java/security/cert/CertificateEncodingException:getMessage	()Ljava/lang/String;
    //   101: invokespecial 77	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	g
    //   0	105	1	paramWriter	Writer
    //   0	105	2	paramArrayOfCertificate	Certificate[]
    //   43	46	3	i	int
    //   40	8	4	j	int
    //   59	11	5	str	String
    // Exception table:
    //   from	to	target	type
    //   11	42	92	java/security/cert/CertificateEncodingException
    //   50	85	92	java/security/cert/CertificateEncodingException
  }
  
  private boolean a()
  {
    return this.a.startsWith("https://");
  }
  
  /* Error */
  private Certificate[] a(p paramp)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 44	com/e/a/b/p:b	()I
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_m1
    //   7: if_icmpne +7 -> 14
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_3
    //   13: areturn
    //   14: ldc -67
    //   16: invokestatic 195	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   19: astore 5
    //   21: iload_2
    //   22: anewarray 166	java/security/cert/Certificate
    //   25: astore 4
    //   27: iconst_0
    //   28: istore_2
    //   29: aload 4
    //   31: astore_3
    //   32: iload_2
    //   33: aload 4
    //   35: arraylength
    //   36: if_icmpge -24 -> 12
    //   39: aload 4
    //   41: iload_2
    //   42: aload 5
    //   44: new 197	java/io/ByteArrayInputStream
    //   47: dup
    //   48: aload_1
    //   49: invokevirtual 32	com/e/a/b/p:a	()Ljava/lang/String;
    //   52: ldc -57
    //   54: invokevirtual 203	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   57: invokestatic 206	com/e/a/b/b:a	([B)[B
    //   60: invokespecial 209	java/io/ByteArrayInputStream:<init>	([B)V
    //   63: invokevirtual 213	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   66: aastore
    //   67: iload_2
    //   68: iconst_1
    //   69: iadd
    //   70: istore_2
    //   71: goto -42 -> 29
    //   74: astore_1
    //   75: new 61	java/io/IOException
    //   78: dup
    //   79: aload_1
    //   80: invokevirtual 214	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   83: invokespecial 77	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	g
    //   0	87	1	paramp	p
    //   4	67	2	i	int
    //   11	21	3	localObject	Object
    //   25	15	4	arrayOfCertificate	Certificate[]
    //   19	24	5	localCertificateFactory	java.security.cert.CertificateFactory
    // Exception table:
    //   from	to	target	type
    //   14	27	74	java/security/cert/CertificateException
    //   32	67	74	java/security/cert/CertificateException
  }
  
  public void a(d paramd)
  {
    int j = 0;
    paramd = new BufferedWriter(new OutputStreamWriter(paramd.a(0), q.e));
    paramd.write(this.a + '\n');
    paramd.write(this.c + '\n');
    paramd.write(Integer.toString(this.b.e()) + '\n');
    int i = 0;
    while (i < this.b.e())
    {
      paramd.write(this.b.a(i) + ": " + this.b.b(i) + '\n');
      i += 1;
    }
    paramd.write(this.d.a() + '\n');
    paramd.write(Integer.toString(this.d.e()) + '\n');
    i = j;
    while (i < this.d.e())
    {
      paramd.write(this.d.a(i) + ": " + this.d.b(i) + '\n');
      i += 1;
    }
    if (a())
    {
      paramd.write(10);
      paramd.write(this.e + '\n');
      a(paramd, this.f);
      a(paramd, this.g);
    }
    paramd.close();
  }
  
  public boolean a(URI paramURI, String paramString, Map paramMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a.equals(paramURI.toString()))
    {
      bool1 = bool2;
      if (this.c.equals(paramString))
      {
        bool1 = bool2;
        if (new u(paramURI, this.d).a(this.b.a(false), paramMap)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */