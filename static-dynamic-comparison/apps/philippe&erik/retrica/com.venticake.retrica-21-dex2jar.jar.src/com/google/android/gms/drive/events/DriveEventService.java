package com.google.android.gms.drive.events;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.internal.hm;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class DriveEventService
  extends IntentService
{
  private static final LinkedBlockingDeque<DriveEvent> Ih = new LinkedBlockingDeque();
  private final String mName;
  
  protected DriveEventService()
  {
    this("DriveEventService");
  }
  
  protected DriveEventService(String paramString)
  {
    super(paramString);
    this.mName = paramString;
  }
  
  private void a(DriveEvent paramDriveEvent)
  {
    for (;;)
    {
      try
      {
        switch (paramDriveEvent.getType())
        {
        case 1: 
          Log.w(this.mName, "Unrecognized event: " + paramDriveEvent);
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        Log.wtf(this.mName, "Service does not implement listener for type:" + paramDriveEvent.getType(), localClassCastException);
        return;
        hm.a(paramDriveEvent instanceof FileConflictEvent, "Unexpected event type: %s", new Object[] { paramDriveEvent });
        a((FileConflictEvent)paramDriveEvent);
        return;
      }
      catch (Exception localException)
      {
        Log.w(this.mName, "Error handling event: " + paramDriveEvent, localException);
        return;
      }
      hm.a(paramDriveEvent instanceof ChangeEvent, "Unexpected event type: %s", new Object[] { paramDriveEvent });
      onChangeEvent((ChangeEvent)paramDriveEvent);
      return;
    }
  }
  
  public void a(FileConflictEvent paramFileConflictEvent)
  {
    Log.w("DriveEventService", "Unhandled FileConflictEvent: " + paramFileConflictEvent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    new Binder()
    {
      protected boolean onTransact(int paramAnonymousInt1, Parcel paramAnonymousParcel1, Parcel paramAnonymousParcel2, int paramAnonymousInt2)
      {
        Log.d("DriveEventService", "onTransact");
        paramAnonymousParcel1 = (DriveEvent)paramAnonymousParcel1.readParcelable(DriveEventService.this.getClassLoader());
        DriveEventService.gn().add(paramAnonymousParcel1);
        DriveEventService.this.startService(new Intent(DriveEventService.this, DriveEventService.this.getClass()));
        return true;
      }
    };
  }
  
  public void onChangeEvent(ChangeEvent paramChangeEvent)
  {
    Log.w("DriveEventService", "Unhandled ChangeEvent: " + paramChangeEvent);
  }
  
  protected final void onHandleIntent(Intent paramIntent)
  {
    paramIntent.setExtrasClassLoader(getClassLoader());
    DriveEvent localDriveEvent = (DriveEvent)paramIntent.getParcelableExtra("event");
    paramIntent = localDriveEvent;
    if (localDriveEvent == null) {
      paramIntent = (DriveEvent)Ih.poll();
    }
    if (paramIntent != null)
    {
      a(paramIntent);
      return;
    }
    Log.e("DriveEventService", "The event queue is unexpectedly empty.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/events/DriveEventService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */