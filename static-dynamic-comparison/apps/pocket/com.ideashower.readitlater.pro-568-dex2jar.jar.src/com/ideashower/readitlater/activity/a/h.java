package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a;

public class h
  extends b
{
  private int Y;
  
  public static h b(int paramInt)
  {
    h localh = new h();
    localh.d(paramInt);
    localh.c(2131493069, 2131493068);
    return localh;
  }
  
  private void d(int paramInt)
  {
    this.Y = paramInt;
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    paramBuilder = super.a(paramBuilder);
    this.Y = l().getInt("label");
    paramBuilder.setNeutralButton(c(2131492879), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).setPositiveButton(c(this.Y), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        g.a((a)h.this.m());
      }
    });
    return paramBuilder;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putInt("label", this.Y);
    return paramBundle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */