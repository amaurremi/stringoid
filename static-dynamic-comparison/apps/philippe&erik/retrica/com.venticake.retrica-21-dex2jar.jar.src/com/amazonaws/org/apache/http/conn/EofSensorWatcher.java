package com.amazonaws.org.apache.http.conn;

import java.io.InputStream;

public abstract interface EofSensorWatcher
{
  public abstract boolean eofDetected(InputStream paramInputStream);
  
  public abstract boolean streamAbort(InputStream paramInputStream);
  
  public abstract boolean streamClosed(InputStream paramInputStream);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/EofSensorWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */