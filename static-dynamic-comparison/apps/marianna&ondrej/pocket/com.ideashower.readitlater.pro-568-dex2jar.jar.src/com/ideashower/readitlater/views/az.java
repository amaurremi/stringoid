package com.ideashower.readitlater.views;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.ideashower.readitlater.util.a.c;
import com.ideashower.readitlater.util.e;
import java.net.URL;

public class az
  extends AsyncTask
{
  private final String b;
  
  private az(UrlImageView paramUrlImageView, String paramString)
  {
    this.b = paramString;
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = c.a(new URL(this.b), UrlImageView.getBitmapOptions());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      e.a(paramVarArgs);
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.b.equals(UrlImageView.a(this.a)))) {
      this.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */