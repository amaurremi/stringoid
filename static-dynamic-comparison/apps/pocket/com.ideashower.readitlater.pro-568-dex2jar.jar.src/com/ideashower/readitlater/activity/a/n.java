package com.ideashower.readitlater.activity.a;

import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.widget.EditText;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.d.f;
import com.pocket.c.e;
import com.pocket.user.UserMeta;
import com.pocket.user.a;

public class n
  extends m
{
  private String Z;
  private String aa;
  private f ad;
  
  public static n a(String paramString1, String paramString2, f paramf)
  {
    n localn = new n();
    localn.a("Send");
    localn.b(paramString1, paramString2, paramf);
    localn.a("Email Address", "Enter your email address and we'll send you instructions.");
    return localn;
  }
  
  protected void M()
  {
    as.k().h().b(this.Y.getText().toString());
    e.a(this.Z, this.aa, false, this.ad);
  }
  
  public AlertDialog.Builder a(AlertDialog.Builder paramBuilder)
  {
    this.Z = l().getString("type");
    this.aa = l().getString("template");
    paramBuilder = super.a(paramBuilder);
    this.Y.setInputType(32);
    return paramBuilder;
  }
  
  public void b(String paramString1, String paramString2, f paramf)
  {
    this.Z = paramString1;
    this.aa = paramString2;
    this.ad = paramf;
  }
  
  protected Bundle l(Bundle paramBundle)
  {
    paramBundle.putString("template", this.aa);
    paramBundle.putString("type", this.Z);
    return super.l(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */