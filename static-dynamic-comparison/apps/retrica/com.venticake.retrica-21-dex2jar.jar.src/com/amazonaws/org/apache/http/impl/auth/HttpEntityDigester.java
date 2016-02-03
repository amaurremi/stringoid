package com.amazonaws.org.apache.http.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

class HttpEntityDigester
  extends OutputStream
{
  private boolean closed;
  private byte[] digest;
  private final MessageDigest digester;
  
  HttpEntityDigester(MessageDigest paramMessageDigest)
  {
    this.digester = paramMessageDigest;
    this.digester.reset();
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    this.digest = this.digester.digest();
    super.close();
  }
  
  public byte[] getDigest()
  {
    return this.digest;
  }
  
  public void write(int paramInt)
  {
    if (this.closed) {
      throw new IOException("Stream has been already closed");
    }
    this.digester.update((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.closed) {
      throw new IOException("Stream has been already closed");
    }
    this.digester.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/HttpEntityDigester.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */