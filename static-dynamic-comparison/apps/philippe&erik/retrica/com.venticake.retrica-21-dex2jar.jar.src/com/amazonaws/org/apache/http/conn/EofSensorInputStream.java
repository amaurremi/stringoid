package com.amazonaws.org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class EofSensorInputStream
  extends InputStream
  implements ConnectionReleaseTrigger
{
  private final EofSensorWatcher eofWatcher;
  private boolean selfClosed;
  protected InputStream wrappedStream;
  
  public EofSensorInputStream(InputStream paramInputStream, EofSensorWatcher paramEofSensorWatcher)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Wrapped stream may not be null.");
    }
    this.wrappedStream = paramInputStream;
    this.selfClosed = false;
    this.eofWatcher = paramEofSensorWatcher;
  }
  
  public void abortConnection()
  {
    this.selfClosed = true;
    checkAbort();
  }
  
  public int available()
  {
    int i = 0;
    if (isReadAllowed()) {}
    try
    {
      i = this.wrappedStream.available();
      return i;
    }
    catch (IOException localIOException)
    {
      checkAbort();
      throw localIOException;
    }
  }
  
  protected void checkAbort()
  {
    boolean bool;
    if (this.wrappedStream != null) {
      bool = true;
    }
    try
    {
      if (this.eofWatcher != null) {
        bool = this.eofWatcher.streamAbort(this.wrappedStream);
      }
      if (bool) {
        this.wrappedStream.close();
      }
      return;
    }
    finally
    {
      this.wrappedStream = null;
    }
  }
  
  protected void checkClose()
  {
    boolean bool;
    if (this.wrappedStream != null) {
      bool = true;
    }
    try
    {
      if (this.eofWatcher != null) {
        bool = this.eofWatcher.streamClosed(this.wrappedStream);
      }
      if (bool) {
        this.wrappedStream.close();
      }
      return;
    }
    finally
    {
      this.wrappedStream = null;
    }
  }
  
  protected void checkEOF(int paramInt)
  {
    boolean bool;
    if ((this.wrappedStream != null) && (paramInt < 0)) {
      bool = true;
    }
    try
    {
      if (this.eofWatcher != null) {
        bool = this.eofWatcher.eofDetected(this.wrappedStream);
      }
      if (bool) {
        this.wrappedStream.close();
      }
      return;
    }
    finally
    {
      this.wrappedStream = null;
    }
  }
  
  public void close()
  {
    this.selfClosed = true;
    checkClose();
  }
  
  protected boolean isReadAllowed()
  {
    if (this.selfClosed) {
      throw new IOException("Attempted read on closed stream.");
    }
    return this.wrappedStream != null;
  }
  
  public int read()
  {
    int i = -1;
    if (isReadAllowed()) {}
    try
    {
      i = this.wrappedStream.read();
      checkEOF(i);
      return i;
    }
    catch (IOException localIOException)
    {
      checkAbort();
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i = -1;
    if (isReadAllowed()) {}
    try
    {
      i = this.wrappedStream.read(paramArrayOfByte);
      checkEOF(i);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      checkAbort();
      throw paramArrayOfByte;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (isReadAllowed()) {}
    try
    {
      i = this.wrappedStream.read(paramArrayOfByte, paramInt1, paramInt2);
      checkEOF(i);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      checkAbort();
      throw paramArrayOfByte;
    }
  }
  
  public void releaseConnection()
  {
    close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/EofSensorInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */