package com.google.api.client.http;

import com.google.api.client.util.ab;
import com.google.api.client.util.g;
import com.google.api.client.util.m;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public final class t
{
  private final p aaN;
  private InputStream abI;
  private final String abJ;
  private final String abK;
  aa abL;
  private final q abM;
  private boolean abN;
  private int abs;
  private boolean abt;
  private final int statusCode;
  private final String statusMessage;
  
  t(q paramq, aa paramaa)
  {
    this.abM = paramq;
    this.abs = paramq.xA();
    this.abt = paramq.xB();
    this.abL = paramaa;
    this.abJ = paramaa.getContentEncoding();
    int j = paramaa.getStatusCode();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    this.statusCode = i;
    Object localObject1 = paramaa.getReasonPhrase();
    this.statusMessage = ((String)localObject1);
    Logger localLogger = w.aao;
    StringBuilder localStringBuilder;
    Object localObject3;
    if ((this.abt) && (localLogger.isLoggable(Level.CONFIG)))
    {
      i = 1;
      if (i == 0) {
        break label284;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("-------------- RESPONSE --------------").append(ab.aeg);
      localObject3 = paramaa.xV();
      if (localObject3 == null) {
        break label235;
      }
      localStringBuilder.append((String)localObject3);
      label145:
      localStringBuilder.append(ab.aeg);
    }
    for (;;)
    {
      localObject3 = paramq.xD();
      if (i != 0)
      {
        localObject1 = localStringBuilder;
        label168:
        ((n)localObject3).a(paramaa, (StringBuilder)localObject1);
        localObject1 = paramaa.getContentType();
        paramaa = (aa)localObject1;
        if (localObject1 == null) {
          paramaa = paramq.xD().getContentType();
        }
        this.abK = paramaa;
        if (paramaa != null) {
          break label272;
        }
      }
      label235:
      label272:
      for (paramq = (q)localObject2;; paramq = new p(paramaa))
      {
        this.aaN = paramq;
        if (i != 0) {
          localLogger.config(localStringBuilder.toString());
        }
        return;
        i = 0;
        break;
        localStringBuilder.append(this.statusCode);
        if (localObject1 == null) {
          break label145;
        }
        localStringBuilder.append(' ').append((String)localObject1);
        break label145;
        localObject1 = null;
        break label168;
      }
      label284:
      localStringBuilder = null;
    }
  }
  
  private boolean xP()
  {
    boolean bool = true;
    int i = getStatusCode();
    if ((xN().getRequestMethod().equals("HEAD")) || (i / 100 == 1) || (i == 204) || (i == 304))
    {
      xO();
      bool = false;
    }
    return bool;
  }
  
  public void disconnect()
  {
    xO();
    this.abL.disconnect();
  }
  
  public <T> T f(Class<T> paramClass)
  {
    if (!xP()) {
      return null;
    }
    return (T)this.abM.xH().a(getContent(), xR(), paramClass);
  }
  
  public InputStream getContent()
  {
    Object localObject5;
    if (!this.abN)
    {
      localObject4 = this.abL.getContent();
      if (localObject4 != null) {
        localObject5 = localObject4;
      }
    }
    try
    {
      localObject6 = this.abJ;
      Object localObject1 = localObject4;
      if (localObject6 != null)
      {
        localObject1 = localObject4;
        localObject5 = localObject4;
        if (((String)localObject6).contains("gzip"))
        {
          localObject5 = localObject4;
          localObject1 = new GZIPInputStream((InputStream)localObject4);
        }
      }
      localObject5 = localObject1;
      localObject6 = localObject1;
      Logger localLogger;
      ((InputStream)localObject4).close();
    }
    catch (EOFException localEOFException)
    {
      for (;;)
      {
        try
        {
          localLogger = w.aao;
          localObject4 = localObject1;
          localObject5 = localObject1;
          localObject6 = localObject1;
          if (this.abt)
          {
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            if (localLogger.isLoggable(Level.CONFIG))
            {
              localObject5 = localObject1;
              localObject6 = localObject1;
              localObject4 = new com.google.api.client.util.q((InputStream)localObject1, localLogger, Level.CONFIG, this.abs);
            }
          }
          localObject5 = localObject4;
          localObject6 = localObject4;
          this.abI = ((InputStream)localObject4);
          this.abN = true;
          return this.abI;
        }
        finally
        {
          Object localObject6;
          localObject4 = localObject6;
          continue;
        }
        localEOFException = localEOFException;
        ((InputStream)localObject5).close();
      }
    }
    finally {}
    throw ((Throwable)localObject2);
  }
  
  public String getContentType()
  {
    return this.abK;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public n xC()
  {
    return this.abM.xD();
  }
  
  public boolean xL()
  {
    return v.eG(this.statusCode);
  }
  
  public String xM()
  {
    return this.statusMessage;
  }
  
  public q xN()
  {
    return this.abM;
  }
  
  public void xO()
  {
    InputStream localInputStream = getContent();
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public String xQ()
  {
    InputStream localInputStream = getContent();
    if (localInputStream == null) {
      return "";
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    m.b(localInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toString(xR().name());
  }
  
  public Charset xR()
  {
    if ((this.aaN == null) || (this.aaN.xw() == null)) {
      return g.ISO_8859_1;
    }
    return this.aaN.xw();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */