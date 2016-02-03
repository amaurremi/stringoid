package com.google.android.gms.drive.events;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.internal.fq;

public abstract class DriveEventService
  extends IntentService
{
  private final String mName;
  
  protected DriveEventService(String paramString)
  {
    super(paramString);
    this.mName = paramString;
  }
  
  public void a(ConflictEvent paramConflictEvent)
  {
    Log.w("DriveEventService", "Unhandled ConflictEvent: " + paramConflictEvent);
  }
  
  public void onChangeEvent(ChangeEvent paramChangeEvent)
  {
    Log.w("DriveEventService", "Unhandled ChangeEvent: " + paramChangeEvent);
  }
  
  protected final void onHandleIntent(Intent paramIntent)
  {
    paramIntent.setExtrasClassLoader(getClassLoader());
    DriveEvent localDriveEvent = (DriveEvent)paramIntent.getParcelableExtra("event");
    for (;;)
    {
      try
      {
        switch (localDriveEvent.getType())
        {
        case 1: 
          Log.w(this.mName, "Unrecognized event: " + paramIntent);
          return;
        }
      }
      catch (ClassCastException paramIntent)
      {
        Log.wtf(this.mName, "Service does not implement listener for type:" + localDriveEvent.getType(), paramIntent);
        return;
        fq.a(localDriveEvent instanceof ConflictEvent, "Unexpected event type: " + localDriveEvent);
        a((ConflictEvent)localDriveEvent);
        return;
      }
      catch (Exception localException)
      {
        Log.w(this.mName, "Error handling event: " + paramIntent, localException);
        return;
      }
      fq.a(localDriveEvent instanceof ChangeEvent, "Unexpected event type: " + localDriveEvent);
      onChangeEvent((ChangeEvent)localDriveEvent);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/events/DriveEventService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */