package com.e.a.b;

import java.io.IOException;
import java.io.OutputStream;

public abstract class a
  extends OutputStream
{
  protected boolean a;
  
  protected final void a()
  {
    if (this.a) {
      throw new IOException("stream closed");
    }
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public final void write(int paramInt)
  {
    write(new byte[] { (byte)paramInt });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */