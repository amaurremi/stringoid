package com.mobisystems.mobiscanner.error;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.util.Log;
import com.mobisystems.mobiscanner.common.d;

public class b
{
  public static void a(final Activity paramActivity, Throwable paramThrowable)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setTitle(2131296737);
    localBuilder.setMessage(paramActivity.getString(2131296804));
    localBuilder.setNegativeButton(paramActivity.getString(2131296834), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.setPositiveButton(paramActivity.getString(2131296831), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        b.a(this.aHa, paramActivity);
      }
    });
    paramThrowable = localBuilder.create();
    paramThrowable.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        this.aHb.finish();
      }
    });
    paramThrowable.show();
  }
  
  public static void a(Context paramContext, Throwable paramThrowable)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, ErrorActivity.class);
      localIntent.putExtra(Throwable.class.getName(), paramThrowable);
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("ErrorManager", "Error creating activity", paramContext);
    }
  }
  
  public static void a(Throwable paramThrowable, Context paramContext)
  {
    try
    {
      paramContext = new c(paramContext, d.ac(paramContext));
      paramContext.g(paramThrowable);
      paramContext.HV();
      paramContext.send();
      return;
    }
    catch (Throwable paramThrowable)
    {
      Log.e("ErrorManager", "Error sending report", paramThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/error/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */