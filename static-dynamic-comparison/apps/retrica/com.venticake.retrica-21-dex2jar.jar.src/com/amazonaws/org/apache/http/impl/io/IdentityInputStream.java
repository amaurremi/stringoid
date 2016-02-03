package com.amazonaws.org.apache.http.impl.io;

import com.amazonaws.org.apache.http.io.BufferInfo;
import com.amazonaws.org.apache.http.io.SessionInputBuffer;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class IdentityInputStream
  extends InputStream
{
  private boolean closed = false;
  private final SessionInputBuffer in;
  
  public IdentityInputStream(SessionInputBuffer paramSessionInputBuffer)
  {
    if (paramSessionInputBuffer == null) {
      throw new IllegalArgumentException("Session input buffer may not be null");
    }
    this.in = paramSessionInputBuffer;
  }
  
  public int available()
  {
    if ((this.in instanceof BufferInfo)) {
      return ((BufferInfo)this.in).length();
    }
    return 0;
  }
  
  public void close()
  {
    this.closed = true;
  }
  
  public int read()
  {
    if (this.closed) {
      return -1;
    }
    return this.in.read();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.closed) {
      return -1;
    }
    return this.in.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/io/IdentityInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */