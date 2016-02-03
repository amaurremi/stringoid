package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;

class BridgeMMNotification
  extends MMJSObject
  implements DialogInterface.OnClickListener
{
  private int index;
  
  public MMJSResponse alert(final HashMap<String, String> paramHashMap)
  {
    try
    {
      paramHashMap = runOnUiThreadFuture(new Callable()
      {
        public MMJSResponse call()
        {
          Object localObject1 = (MMWebView)BridgeMMNotification.this.mmWebViewRef.get();
          if (localObject1 != null)
          {
            Object localObject2 = ((MMWebView)localObject1).getActivity();
            localObject1 = paramHashMap;
            if (localObject2 != null)
            {
              if (!((Activity)localObject2).isFinishing())
              {
                localObject2 = new AlertDialog.Builder((Context)localObject2).create();
                if (((HashMap)localObject1).containsKey("title")) {
                  ((AlertDialog)localObject2).setTitle((CharSequence)((HashMap)localObject1).get("title"));
                }
                if (((HashMap)localObject1).containsKey("message")) {
                  ((AlertDialog)localObject2).setMessage((CharSequence)((HashMap)localObject1).get("message"));
                }
                if (((HashMap)localObject1).containsKey("cancelButton")) {
                  ((AlertDialog)localObject2).setButton(-2, (CharSequence)((HashMap)localObject1).get("cancelButton"), BridgeMMNotification.this);
                }
                if (((HashMap)localObject1).containsKey("buttons"))
                {
                  localObject1 = ((String)((HashMap)localObject1).get("buttons")).split(",");
                  if (localObject1.length > 0) {
                    ((AlertDialog)localObject2).setButton(-3, localObject1[0], BridgeMMNotification.this);
                  }
                  if (localObject1.length > 1) {
                    ((AlertDialog)localObject2).setButton(-1, localObject1[1], BridgeMMNotification.this);
                  }
                }
                ((AlertDialog)localObject2).show();
              }
              localObject1 = new MMJSResponse();
              ((MMJSResponse)localObject1).result = 1;
              ((MMJSResponse)localObject1).response = Integer.valueOf(BridgeMMNotification.this.index);
              return (MMJSResponse)localObject1;
            }
          }
          return null;
        }
      });
      return paramHashMap;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -2) {}
    try
    {
      this.index = 0;
      if (paramInt == -3) {
        this.index = 1;
      }
      if (paramInt == -1) {
        this.index = 2;
      }
      paramDialogInterface.cancel();
      notify();
      return;
    }
    finally {}
  }
  
  public MMJSResponse vibrate(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    long l = 0L;
    if (paramHashMap.containsKey("duration")) {
      l = (Float.parseFloat((String)paramHashMap.get("duration")) * 1000.0D);
    }
    if ((localContext != null) && (l > 0L))
    {
      if (localContext.getPackageManager().checkPermission("android.permission.VIBRATE", localContext.getPackageName()) == 0)
      {
        ((Vibrator)localContext.getSystemService("vibrator")).vibrate(l);
        return MMJSResponse.responseWithSuccess("Vibrating for " + l);
      }
      return MMJSResponse.responseWithError("The required permissions to vibrate are not set.");
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/BridgeMMNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */