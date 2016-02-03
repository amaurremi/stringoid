package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.util.k;

public class d
  extends b
{
  protected ErrorReport Y;
  protected int Z;
  private boolean aa;
  private boolean ad;
  
  public static d a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean, ErrorReport paramErrorReport)
  {
    d locald = new d();
    locald.a(paramInt1, paramErrorReport, paramBoolean);
    locald.b(paramInt2, paramString);
    return locald;
  }
  
  public static d a(int paramInt, ErrorReport paramErrorReport)
  {
    d locald = new d();
    locald.a(paramInt, paramErrorReport, true);
    paramErrorReport = paramErrorReport.b();
    switch (paramInt)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      locald.b(2131493090, paramErrorReport);
      return locald;
    case 1: 
    case 6: 
      locald.b(2131493167, paramErrorReport);
      return locald;
    }
    locald.b(2131493110, paramErrorReport);
    return locald;
  }
  
  public boolean M()
  {
    return this.ad;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    if (this.Y == null) {
      a(l().getInt("errorType"), (ErrorReport)l().getParcelable("errorReport"), l().getBoolean("showGetHelp"));
    }
    if (this.aa) {
      paramBuilder.setNegativeButton(c(2131492898), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          k.a(d.this.Z, d.this.Y, (a)d.this.m());
        }
      });
    }
    return paramBuilder;
  }
  
  protected void a(int paramInt, ErrorReport paramErrorReport, boolean paramBoolean)
  {
    this.Z = paramInt;
    this.Y = paramErrorReport;
    this.aa = paramBoolean;
  }
  
  public Dialog c(final Bundle paramBundle)
  {
    paramBundle = (AlertDialog)super.c(paramBundle);
    if (!this.aa) {
      paramBundle.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          paramAnonymousDialogInterface = paramBundle.getButton(-3);
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.setOnLongClickListener(new View.OnLongClickListener()
            {
              public boolean onLongClick(View paramAnonymous2View)
              {
                new AlertDialog.Builder(d.this.m()).setMessage(2131493140).setNegativeButton(2131492919, null).setPositiveButton(2131492964, new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    k.a(d.this.Z, d.this.Y, d.2.this.b);
                  }
                }).show();
                d.2.this.a.dismiss();
                return true;
              }
            });
          }
          while (!g.y()) {
            return;
          }
          throw new NullPointerException();
        }
      });
    }
    return paramBundle;
  }
  
  public void f()
  {
    super.f();
    this.ad = true;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putParcelable("errorReport", this.Y);
    paramBundle.putInt("errorType", this.Z);
    paramBundle.putBoolean("showGetHelp", this.aa);
    return paramBundle;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    this.ad = true;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.ad = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */