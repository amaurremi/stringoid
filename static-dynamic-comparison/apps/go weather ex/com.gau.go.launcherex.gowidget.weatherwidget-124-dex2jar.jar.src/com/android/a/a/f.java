package com.android.a.a;

import java.io.FilterInputStream;
import java.io.InputStream;

class f
  extends FilterInputStream
{
  private int a = 0;
  
  private f(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read()
  {
    int i = super.read();
    if (i != -1) {
      this.a += 1;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.a += paramInt1;
    }
    return paramInt1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */