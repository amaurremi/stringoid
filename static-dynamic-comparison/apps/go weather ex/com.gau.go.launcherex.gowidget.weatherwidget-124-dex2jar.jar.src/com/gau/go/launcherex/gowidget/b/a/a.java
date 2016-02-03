package com.gau.go.launcherex.gowidget.b.a;

import android.os.AsyncTask;
import android.os.Environment;
import com.gau.go.launcherex.gowidget.statistics.y;
import java.io.File;
import java.io.IOException;

public class a
  extends AsyncTask
{
  protected Void a(Void... paramVarArgs)
  {
    if (y.a())
    {
      paramVarArgs = new File(Environment.getExternalStorageDirectory(), "/GOWeatherEX");
      if (!paramVarArgs.exists()) {
        paramVarArgs.mkdirs();
      }
      paramVarArgs = new File(paramVarArgs, ".nomedia");
      if (paramVarArgs.exists()) {}
    }
    try
    {
      paramVarArgs.createNewFile();
      return null;
    }
    catch (IOException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */