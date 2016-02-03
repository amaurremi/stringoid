package com.chiralcode.colorpicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class a
  extends AlertDialog
{
  private ColorPicker fl;
  private final a fm;
  private DialogInterface.OnClickListener fn = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return;
      case -1: 
        paramAnonymousInt = a.a(a.this).getColor();
        a.b(a.this).onColorSelected(paramAnonymousInt);
        return;
      }
      paramAnonymousDialogInterface.dismiss();
    }
  };
  
  public a(Context paramContext, int paramInt, a parama)
  {
    super(paramContext);
    this.fm = parama;
    parama = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13);
    this.fl = new ColorPicker(paramContext);
    this.fl.setColor(paramInt);
    parama.addView(this.fl, localLayoutParams);
    setButton(-1, paramContext.getString(17039370), this.fn);
    setButton(-2, paramContext.getString(17039360), this.fn);
    setView(parama);
  }
  
  public static abstract interface a
  {
    public abstract void onColorSelected(int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/chiralcode/colorpicker/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */