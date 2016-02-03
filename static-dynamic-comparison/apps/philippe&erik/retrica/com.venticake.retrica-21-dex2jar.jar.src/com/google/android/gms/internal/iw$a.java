package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class iw$a
  extends ix.a
{
  private final int FW;
  private Activity og;
  
  public iw$a(int paramInt, Activity paramActivity)
  {
    this.FW = paramInt;
    this.og = paramActivity;
  }
  
  private void setActivity(Activity paramActivity)
  {
    this.og = paramActivity;
  }
  
  public void g(int paramInt, Bundle paramBundle)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBundle);
      paramBundle = this.og.createPendingResult(this.FW, (Intent)localObject, 1073741824);
      if (paramBundle != null) {}
    }
    for (;;)
    {
      return;
      try
      {
        paramBundle.send(1);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("AddressClientImpl", "Exception settng pending result", paramBundle);
        return;
      }
      localObject = null;
      if (paramBundle != null) {
        localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
      }
      paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(this.og, this.FW);
          return;
        }
        catch (IntentSender.SendIntentException paramBundle)
        {
          Log.w("AddressClientImpl", "Exception starting pending intent", paramBundle);
          return;
        }
      }
      try
      {
        paramBundle = this.og.createPendingResult(this.FW, new Intent(), 1073741824);
        if (paramBundle != null)
        {
          paramBundle.send(1);
          return;
        }
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("AddressClientImpl", "Exception setting pending result", paramBundle);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/iw$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */