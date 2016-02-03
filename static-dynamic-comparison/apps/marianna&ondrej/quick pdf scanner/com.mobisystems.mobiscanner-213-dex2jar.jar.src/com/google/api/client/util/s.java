package com.google.api.client.util;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class s
  implements aa
{
  private final aa aaZ;
  private final int abs;
  private final Level aeb;
  private final Logger aec;
  
  public s(aa paramaa, Logger paramLogger, Level paramLevel, int paramInt)
  {
    this.aaZ = paramaa;
    this.aec = paramLogger;
    this.aeb = paramLevel;
    this.abs = paramInt;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    r localr = new r(paramOutputStream, this.aec, this.aeb, this.abs);
    try
    {
      this.aaZ.writeTo(localr);
      localr.yT().close();
      paramOutputStream.flush();
      return;
    }
    finally
    {
      localr.yT().close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */