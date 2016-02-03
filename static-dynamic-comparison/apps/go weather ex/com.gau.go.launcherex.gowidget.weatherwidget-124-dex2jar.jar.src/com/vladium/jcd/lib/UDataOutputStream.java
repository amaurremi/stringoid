package com.vladium.jcd.lib;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class UDataOutputStream
  extends DataOutputStream
{
  public UDataOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public final void writeU2(int paramInt)
    throws IOException
  {
    writeShort((short)paramInt);
  }
  
  public final void writeU4(long paramLong)
    throws IOException
  {
    writeInt((int)paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/lib/UDataOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */