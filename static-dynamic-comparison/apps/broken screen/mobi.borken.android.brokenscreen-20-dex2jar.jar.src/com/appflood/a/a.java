package com.appflood.a;

import android.content.Context;
import android.os.Environment;
import com.appflood.e.c;
import com.appflood.e.j;
import java.io.File;

public final class a
{
  private File a;
  
  public a(String paramString, Context paramContext)
  {
    if (c.i)
    {
      this.a = new File(Environment.getExternalStorageDirectory(), paramString);
      if (!this.a.exists()) {
        this.a.mkdirs();
      }
    }
    for (;;)
    {
      if (!this.a.exists()) {
        j.b(null, "cache dir " + this.a.getAbsolutePath() + " init fail");
      }
      return;
      this.a = paramContext.getDir(paramString, 1);
    }
  }
  
  public final File a(String paramString)
  {
    return new File(this.a, j.a(paramString));
  }
  
  public final boolean a(String paramString, byte[] paramArrayOfByte)
  {
    return com.appflood.e.a.a(a(paramString), paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */