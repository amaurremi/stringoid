package com.google.api.client.util;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class q
  extends FilterInputStream
{
  private final p aed;
  
  public q(InputStream paramInputStream, Logger paramLogger, Level paramLevel, int paramInt)
  {
    super(paramInputStream);
    this.aed = new p(paramLogger, paramLevel, paramInt);
  }
  
  public void close()
  {
    this.aed.close();
    super.close();
  }
  
  public int read()
  {
    int i = super.read();
    this.aed.write(i);
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.aed.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */