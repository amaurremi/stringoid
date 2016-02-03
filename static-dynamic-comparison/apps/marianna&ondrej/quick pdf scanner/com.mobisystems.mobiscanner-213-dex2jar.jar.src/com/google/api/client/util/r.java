package com.google.api.client.util;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class r
  extends FilterOutputStream
{
  private final p aed;
  
  public r(OutputStream paramOutputStream, Logger paramLogger, Level paramLevel, int paramInt)
  {
    super(paramOutputStream);
    this.aed = new p(paramLogger, paramLevel, paramInt);
  }
  
  public void close()
  {
    this.aed.close();
    super.close();
  }
  
  public void write(int paramInt)
  {
    this.out.write(paramInt);
    this.aed.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.aed.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final p yT()
  {
    return this.aed;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */