package com.gtp.go.weather.sharephoto;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.go.weatherex.home.a.e;
import com.gtp.a.a.c.c;
import com.jiubang.core.a.l;
import com.jiubang.core.a.u;

public class x
{
  public static final String a = c.a() + "/background/background.jpg";
  private Context b;
  private int c;
  private int d;
  
  public x(Context paramContext)
  {
    this.b = paramContext;
    paramContext = this.b.getResources().getDisplayMetrics();
    this.c = paramContext.widthPixels;
    this.d = paramContext.heightPixels;
  }
  
  private u b()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ALPHA_8;
        localObject1 = BitmapFactory.decodeFile(a, (BitmapFactory.Options)localObject1);
        if (localObject1 != null)
        {
          Object localObject2;
          Object localObject5;
          Object localObject3;
          return null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = e.a(this.b, (Bitmap)localObject1, 15);
          localObject5 = localObject1;
          localObject1 = localObject2;
          if (localObject5 == null) {
            break label97;
          }
          localObject2 = new u(this.b, 1, 0, 0, this.c, this.d, (Bitmap)localObject5);
          ((u)localObject2).b((Bitmap)localObject1);
          return (u)localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject1 = null;
        localOutOfMemoryError1.printStackTrace();
        localObject3 = null;
        localObject5 = localObject1;
        localObject1 = localObject3;
        continue;
      }
      label97:
      Object localObject4 = null;
    }
  }
  
  public l a()
  {
    return b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */