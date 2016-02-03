package com.badlogic.gdx.backends.android.a.a;

import java.io.Writer;

class o
  extends Writer
{
  private StringBuilder b = new StringBuilder();
  
  o(d paramd) {}
  
  private void a()
  {
    if (this.b.length() > 0) {
      this.b.delete(0, this.b.length());
    }
  }
  
  public void close()
  {
    a();
  }
  
  public void flush()
  {
    a();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i >= paramInt2) {
      return;
    }
    char c = paramArrayOfChar[(paramInt1 + i)];
    if (c == '\n') {
      a();
    }
    for (;;)
    {
      i += 1;
      break;
      this.b.append(c);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */