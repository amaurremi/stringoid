package com.jiubang.goweather.c;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import com.gtp.a.a.b.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class f
{
  public static int a(LocationManager paramLocationManager, String paramString)
  {
    int i = 2;
    try
    {
      boolean bool = paramLocationManager.isProviderEnabled(paramString);
      if (bool) {
        i = 1;
      }
      return i;
    }
    catch (IllegalArgumentException paramLocationManager)
    {
      if (c.a()) {
        paramLocationManager.printStackTrace();
      }
      return 3;
    }
    catch (SecurityException paramLocationManager)
    {
      if (c.a()) {
        paramLocationManager.printStackTrace();
      }
    }
    return 3;
  }
  
  public static SQLiteDatabase a(Context paramContext, int paramInt)
  {
    Object localObject = paramContext.getFilesDir() + "/city";
    String str = (String)localObject + "/" + "go_city.db";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    try
    {
      if (new File(str).exists()) {
        break label145;
      }
      paramContext = paramContext.getResources().openRawResource(paramInt);
      localObject = new FileOutputStream(str);
      byte[] arrayOfByte = new byte[' '];
      for (;;)
      {
        paramInt = paramContext.read(arrayOfByte);
        if (paramInt <= 0) {
          break;
        }
        ((FileOutputStream)localObject).write(arrayOfByte, 0, paramInt);
      }
      ((FileOutputStream)localObject).close();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    paramContext.close();
    label145:
    paramContext = SQLiteDatabase.openOrCreateDatabase(str, null);
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */