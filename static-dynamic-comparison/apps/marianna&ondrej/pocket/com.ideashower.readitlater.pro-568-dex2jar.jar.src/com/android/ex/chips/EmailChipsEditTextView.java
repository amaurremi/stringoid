package com.android.ex.chips;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class EmailChipsEditTextView
  extends a
{
  public EmailChipsEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected Dialog a(Context paramContext)
  {
    new AlertDialog.Builder(paramContext).setPositiveButton(2131492995, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        EmailChipsEditTextView.this.onClick(null);
      }
    }).create();
  }
  
  protected void a() {}
  
  protected void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  protected void a(z paramz, int paramInt, Context paramContext) {}
  
  protected void b(String paramString)
  {
    this.i = paramString;
    this.h.setTitle(paramString);
    this.h.setCancelable(true);
    this.h.setCanceledOnTouchOutside(true);
    this.h.setOnDismissListener(this);
    this.h.show();
  }
  
  protected ListView getAlternatesListView()
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/EmailChipsEditTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */