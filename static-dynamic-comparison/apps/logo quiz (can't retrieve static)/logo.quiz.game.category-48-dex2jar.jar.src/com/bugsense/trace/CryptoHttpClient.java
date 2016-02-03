package com.bugsense.trace;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;

public class CryptoHttpClient
  extends DefaultHttpClient
{
  protected static final int ANALYTICS = 0;
  private static final String BASE64KEYANALYTICS = "AAAAAQAAABROxuBB/aUFmT3yact6TK5IOds4eQAABIABAAVteWtleQAAATltDpSyAAAAAAAFWC41MDkAAAMgMIIDHDCCAoWgAwIBAgIJAJMoXqN3LTQpMA0GCSqGSIb3DQEBBQUAMIGmMQswCQYDVQQGEwJVUzELMAkGA1UECAwCREUxETAPBgNVBAcMCERlbGF3YXJlMRYwFAYDVQQKDA1CdWdTZW5zZSBJbmMuMR4wHAYDVQQLDBVDZXJ0aWZpY2F0ZSBBdXRob3JpdHkxHjAcBgNVBAMMFUNlcnRpZmljYXRlIEF1dGhvcml0eTEfMB0GCSqGSIb3DQEJARYQb3BzQGJ1Z3NlbnNlLmNvbTAeFw0xMjA4MjcxNTU4MzVaFw0yMjA4MjUxNTU4MzVaMIGmMQswCQYDVQQGEwJVUzELMAkGA1UECAwCREUxETAPBgNVBAcMCERlbGF3YXJlMRYwFAYDVQQKDA1CdWdTZW5zZSBJbmMuMR4wHAYDVQQLDBVDZXJ0aWZpY2F0ZSBBdXRob3JpdHkxHjAcBgNVBAMMFUNlcnRpZmljYXRlIEF1dGhvcml0eTEfMB0GCSqGSIb3DQEJARYQb3BzQGJ1Z3NlbnNlLmNvbTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAtKnp4mKe+5iOpV7BfiPWz/4KWjwLrQG2V89fmS8iJ2o63yjMgBYyRKgoHEp9h4TIwzmmTrZw63Q5wE0DnUQwMB+oNCAWCxzZxfGd9dz/omxFvbL1SiqTg7jNjjkzR6JVN3EmjY+CU742DTTKsa6eFTyaRfcexCj1gW+HHSef5q0CAwEAAaNQME4wHQYDVR0OBBYEFL6lHUJktOncX8C7umbgoombEmkGMB8GA1UdIwQYMBaAFL6lHUJktOncX8C7umbgoombEmkGMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEABKsEXB7Rn8nz5qgNhOHZtt/bTiA31PyT73sEVQftEOIwOY1CEVC8I6iGn/tBhyeIDpQOVUpTftlaX3UtBeSPzzfnv7a+eZFIdcsgCtSZJ3DpZiY0Fkk4MgbueQEMed1wxl7mfgWGC/fgyZNpw33VuTpSYIFx1FGw9JnBxWJCW9oAKo+JAbCJoSyLOAs15lw1qAknCtI=";
  private static final String BASE64KEYERRORS = "AAAAAQAAABTqE8O13A7h+0EkKxWZwl/MrC5GHgAABYgBAAVteWtleQAAATmbH+bhAAAAAAAFWC41MDkAAAReMIIEWjCCA0KgAwIBAgILBAAAAAABL07hQUMwDQYJKoZIhvcNAQEFBQAwVzELMAkGA1UEBhMCQkUxGTAXBgNVBAoTEEdsb2JhbFNpZ24gbnYtc2ExEDAOBgNVBAsTB1Jvb3QgQ0ExGzAZBgNVBAMTEkdsb2JhbFNpZ24gUm9vdCBDQTAeFw0xMTA0MTMxMDAwMDBaFw0yMjA0MTMxMDAwMDBaMFcxCzAJBgNVBAYTAkJFMRkwFwYDVQQKExBHbG9iYWxTaWduIG52LXNhMS0wKwYDVQQDEyRHbG9iYWxTaWduIERvbWFpbiBWYWxpZGF0aW9uIENBIC0gRzIwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCxo83A3zNAJuveWteUZtQBY8wzRIng4rjCRw2PrWmGHKhzQgvxcvstrLURcoMi9lbnLsVncZ0AHDK84+0uCEWp5vrdyIyDBcFvS9AmSgv2G0XATX6TvA0nhO0wo+nGJibdLR/Yi8POGdBb/Aif5NjiNeSgaKb2DaN0YEKyl4IkjkGk8i5eto6nbtlsfw07JDVq0KtbaveXAgA/UaanbnPKdw12fJu2MBoanPcfKHsOi0cf538FjMbJyLvP6dx6QS6hhtrUObLiE0CmqDr6D1MeT+xumAkbypp3s1WFhekuFrWdXlTxSnpsObpuFwY0s7JC4ffznJoLEUTeaniOsRNPAgMBAAGjggElMIIBITAOBgNVHQ8BAf8EBAMCAQYwEgYDVR0TAQH/BAgwBgEB/wIBADAdBgNVHQ4EFgQUlq36sFu5g2QqdsIcimnaQtz+/SgwRwYDVR0gBEAwPjA8BgRVHSAAMDQwMgYIKwYBBQUHAgEWJmh0dHBzOi8vd3d3Lmdsb2JhbHNpZ24uY29tL3JlcG9zaXRvcnkvMDMGA1UdHwQsMCowKKAmoCSGImh0dHA6Ly9jcmwuZ2xvYmFsc2lnbi5uZXQvcm9vdC5jcmwwPQYIKwYBBQUHAQEEMTAvMC0GCCsGAQUFBzABhiFodHRwOi8vb2NzcC5nbG9iYWxzaWduLmNvbS9yb290cjEwHwYDVR0jBBgwFoAUYHtmGkUNl8qJUC99BM00qP/8/UswDQYJKoZIhvcNAQEFBQADggEBADrn/K6vBUOAJ3VBX6jwKI8fj4N+sri6rnUxJ4il5blOBEPSregTAKPbGQEwnmw8Un9c3qtnw4QEVFGZnmMvvdW3wNXaAw5J0+Gzkk/fkk59riJqzti8/Hyua7aK6kVikBHTC3GnXgYi/0046rk6bs1nGgJ/S/O/DnlvvtUpMllZHZYIm3CP9x5cRntO0J20U8gSAhsNuzLrWVO5PhtWjRXI8UI/d/4f5W2eZh+r2rKDV7QMItKGvNoy18DtcIV8k6rwl9w5EdLYieuNkKO2UCXLbNmmw2/7iFS45JJwh855O/DeNr8DBAA9+e+eqWek9IY+I5e4KnHi7f5piGe/JlwA1dUF+2pp1as1qpadDzN/FNFE+2Q=";
  protected static final int ERRORS = 1;
  int KEY = 0;
  
  public CryptoHttpClient(int paramInt)
  {
    this.KEY = paramInt;
  }
  
  /* Error */
  private org.apache.http.conn.ssl.SSLSocketFactory newSslSocketFactory()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/bugsense/trace/CryptoHttpClient:KEY	I
    //   4: ifne +58 -> 62
    //   7: ldc 11
    //   9: astore_1
    //   10: aload_1
    //   11: invokestatic 35	biz/source_code/base64Coder/Base64Coder:decode	(Ljava/lang/String;)[B
    //   14: astore_2
    //   15: ldc 37
    //   17: invokestatic 43	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   20: astore_1
    //   21: new 45	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 48	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: astore_2
    //   30: aload_1
    //   31: aload_2
    //   32: ldc 50
    //   34: invokevirtual 56	java/lang/String:toCharArray	()[C
    //   37: invokevirtual 60	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   40: aload_2
    //   41: invokevirtual 65	java/io/InputStream:close	()V
    //   44: new 67	org/apache/http/conn/ssl/SSLSocketFactory
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 70	org/apache/http/conn/ssl/SSLSocketFactory:<init>	(Ljava/security/KeyStore;)V
    //   52: astore_1
    //   53: aload_1
    //   54: getstatic 74	org/apache/http/conn/ssl/SSLSocketFactory:ALLOW_ALL_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   57: invokevirtual 78	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   60: aload_1
    //   61: areturn
    //   62: ldc 14
    //   64: astore_1
    //   65: goto -55 -> 10
    //   68: astore_1
    //   69: aload_2
    //   70: invokevirtual 65	java/io/InputStream:close	()V
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: getstatic 83	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   79: new 85	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   86: ldc 88
    //   88: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 96	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 105	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: getstatic 111	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   108: ifeq +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   115: new 116	java/lang/AssertionError
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 119	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	CryptoHttpClient
    //   9	56	1	localObject1	Object
    //   68	6	1	localObject2	Object
    //   75	45	1	localException	Exception
    //   14	56	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   30	40	68	finally
    //   15	30	75	java/lang/Exception
    //   40	60	75	java/lang/Exception
    //   69	75	75	java/lang/Exception
  }
  
  protected ClientConnectionManager createClientConnectionManager()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("https", newSslSocketFactory(), 443));
    return new SingleClientConnManager(getParams(), localSchemeRegistry);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/CryptoHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */