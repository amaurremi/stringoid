package com.vladium.jcd.lib;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class UDataInputStream
  extends DataInputStream
{
  public UDataInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final int readU2()
    throws IOException
  {
    return 0xFFFF & readShort();
  }
  
  public final long readU4()
    throws IOException
  {
    return readInt() & 0xFFFFFFFF;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/lib/UDataInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */