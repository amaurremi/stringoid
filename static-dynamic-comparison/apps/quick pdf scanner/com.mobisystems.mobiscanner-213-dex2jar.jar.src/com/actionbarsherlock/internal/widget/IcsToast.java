package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.R.drawable;

public class IcsToast
  extends Toast
{
  public static final int LENGTH_LONG = 1;
  public static final int LENGTH_SHORT = 0;
  private static final String TAG = "Toast";
  
  public IcsToast(Context paramContext)
  {
    super(paramContext);
  }
  
  public static Toast makeText(Context paramContext, int paramInt1, int paramInt2)
  {
    return makeText(paramContext, paramContext.getResources().getString(paramInt1), paramInt2);
  }
  
  public static Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return Toast.makeText(paramContext, paramCharSequence, paramInt);
    }
    IcsToast localIcsToast = new IcsToast(paramContext);
    localIcsToast.setDuration(paramInt);
    paramContext = new TextView(paramContext);
    paramContext.setText(paramCharSequence);
    paramContext.setTextColor(-1);
    paramContext.setGravity(17);
    paramContext.setBackgroundResource(R.drawable.abs__toast_frame);
    localIcsToast.setView(paramContext);
    return localIcsToast;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.setText(paramCharSequence);
    }
    while (getView() == null) {
      return;
    }
    try
    {
      ((TextView)getView()).setText(paramCharSequence);
      return;
    }
    catch (ClassCastException paramCharSequence)
    {
      Log.e("Toast", "This Toast was not created with IcsToast.makeText", paramCharSequence);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/widget/IcsToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */