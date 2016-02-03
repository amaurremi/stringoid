package com.pioong.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;

public class MyProgressDialog
  extends Dialog
{
  public MyProgressDialog(Context paramContext)
  {
    super(paramContext, 2131165184);
  }
  
  public static MyProgressDialog show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return show(paramContext, paramCharSequence1, paramCharSequence2, false);
  }
  
  public static MyProgressDialog show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    return show(paramContext, paramCharSequence1, paramCharSequence2, paramBoolean, false, null);
  }
  
  public static MyProgressDialog show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return show(paramContext, paramCharSequence1, paramCharSequence2, paramBoolean1, paramBoolean2, null);
  }
  
  public static MyProgressDialog show(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramCharSequence2 = new MyProgressDialog(paramContext);
    paramCharSequence2.setTitle(paramCharSequence1);
    paramCharSequence2.setCancelable(paramBoolean2);
    paramCharSequence2.setOnCancelListener(paramOnCancelListener);
    paramCharSequence2.addContentView(new ProgressBar(paramContext), new ViewGroup.LayoutParams(-2, -2));
    paramCharSequence2.show();
    return paramCharSequence2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/customview/MyProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */