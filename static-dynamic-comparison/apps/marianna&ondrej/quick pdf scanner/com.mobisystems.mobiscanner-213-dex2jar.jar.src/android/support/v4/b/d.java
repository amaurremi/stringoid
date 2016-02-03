package android.support.v4.b;

import android.util.Log;
import java.io.Writer;

public class d
  extends Writer
{
  private StringBuilder I = new StringBuilder(128);
  private final String mTag;
  
  public d(String paramString)
  {
    this.mTag = paramString;
  }
  
  private void n()
  {
    if (this.I.length() > 0)
    {
      Log.d(this.mTag, this.I.toString());
      this.I.delete(0, this.I.length());
    }
  }
  
  public void close()
  {
    n();
  }
  
  public void flush()
  {
    n();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        n();
      }
      for (;;)
      {
        i += 1;
        break;
        this.I.append(c);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */