package com.millennialmedia.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class MMNotification
  extends MMJSObject
  implements DialogInterface.OnClickListener
{
  private int index;
  
  /* Error */
  public MMJSResponse alert(final HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/millennialmedia/android/MMNotification:contextRef	Ljava/lang/ref/WeakReference;
    //   6: invokevirtual 29	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   9: checkcast 31	android/content/Context
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +57 -> 71
    //   17: new 8	com/millennialmedia/android/MMNotification$1
    //   20: dup
    //   21: aload_0
    //   22: aload_2
    //   23: aload_1
    //   24: invokespecial 34	com/millennialmedia/android/MMNotification$1:<init>	(Lcom/millennialmedia/android/MMNotification;Landroid/content/Context;Ljava/util/HashMap;)V
    //   27: invokestatic 40	com/millennialmedia/android/MMAdViewSDK:runOnUiThread	(Ljava/lang/Runnable;)V
    //   30: aload_0
    //   31: invokevirtual 45	java/lang/Object:wait	()V
    //   34: new 47	com/millennialmedia/android/MMJSResponse
    //   37: dup
    //   38: invokespecial 48	com/millennialmedia/android/MMJSResponse:<init>	()V
    //   41: astore_1
    //   42: aload_1
    //   43: iconst_1
    //   44: putfield 51	com/millennialmedia/android/MMJSResponse:result	I
    //   47: aload_1
    //   48: new 53	java/lang/Integer
    //   51: dup
    //   52: aload_0
    //   53: getfield 55	com/millennialmedia/android/MMNotification:index	I
    //   56: invokespecial 58	java/lang/Integer:<init>	(I)V
    //   59: putfield 62	com/millennialmedia/android/MMJSResponse:response	Ljava/lang/Object;
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   71: aconst_null
    //   72: astore_1
    //   73: goto -11 -> 62
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	MMNotification
    //   0	81	1	paramHashMap	HashMap<String, String>
    //   12	11	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   30	62	66	java/lang/Exception
    //   2	13	76	finally
    //   17	30	76	finally
    //   30	62	76	finally
    //   67	71	76	finally
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
        return MMJSResponse.responseWithSuccess();
      }
      return MMJSResponse.responseWithError("The required permissions to vibrate are not set.");
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/MMNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */