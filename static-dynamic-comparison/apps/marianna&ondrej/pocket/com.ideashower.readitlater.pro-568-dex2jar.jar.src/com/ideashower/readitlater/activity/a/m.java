package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class m
  extends b
{
  protected EditText Y;
  private String Z;
  
  protected void M() {}
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    Object localObject = l().getString("title");
    String str = l().getString("message");
    paramBuilder.setTitle((CharSequence)localObject).setMessage(str).setPositiveButton(this.Z, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        m.this.M();
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localObject = LayoutInflater.from(m()).inflate(2130903096, null);
    this.Y = ((EditText)((View)localObject).findViewById(2131230945));
    paramBuilder.setView((View)localObject);
    return paramBuilder;
  }
  
  public void a(String paramString)
  {
    this.Z = paramString;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putString("actionLabel", this.Z);
    return super.l(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */