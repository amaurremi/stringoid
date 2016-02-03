package com.mobisystems.mobiscanner.controller;

import android.app.Application;
import android.preference.PreferenceManager;
import com.google.android.gms.analytics.b;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.g;
import com.mobisystems.mobiscanner.common.CommonPreferences;
import com.mobisystems.mobiscanner.error.a;
import com.mobisystems.mobiscanner.image.ImageOrientation;
import com.mobisystems.mobiscanner.model.DocumentModel;
import java.util.HashMap;

public class MyApplication
  extends Application
{
  HashMap<TrackerName, g> aDD = new HashMap();
  
  public g a(TrackerName paramTrackerName)
  {
    try
    {
      if (!this.aDD.containsKey(paramTrackerName))
      {
        g localg = c.o(this).N("UA-49881762-2");
        this.aDD.put(paramTrackerName, localg);
      }
      paramTrackerName = (g)this.aDD.get(paramTrackerName);
      return paramTrackerName;
    }
    finally {}
  }
  
  public void onCreate()
  {
    super.onCreate();
    a.ay(getApplicationContext());
    Thread.setDefaultUncaughtExceptionHandler(new b(a(TrackerName.aDE), Thread.getDefaultUncaughtExceptionHandler(), getApplicationContext()));
    int i = 0;
    for (;;)
    {
      if (i == 0) {}
      try
      {
        DocumentModel.aA(getApplicationContext());
        i = 1;
      }
      catch (Throwable localThrowable) {}
      PreferenceManager.setDefaultValues(this, 2131034112, true);
      CommonPreferences.W(getApplicationContext());
      ImageOrientation.init(getApplicationContext());
      return;
    }
  }
  
  public static enum TrackerName
  {
    private TrackerName() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/MyApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */