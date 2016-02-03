package com.pocket.q.a;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings.System;
import android.support.v4.app.f;
import android.view.View;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import org.apache.a.c.k;

public class v
  extends a
{
  protected final com.ideashower.readitlater.h.h g;
  private String i;
  private Uri j;
  
  public v(com.ideashower.readitlater.activity.h paramh, com.ideashower.readitlater.h.h paramh1, String paramString, s params)
  {
    super(paramh, paramString, null, null, params);
    if (paramh1 == null) {
      throw new NullPointerException("mPref may not be null");
    }
    this.g = paramh1;
    a(i.a(paramh1));
  }
  
  private void a(Uri paramUri)
  {
    this.j = paramUri;
    if (paramUri != null) {}
    for (paramUri = paramUri.toString();; paramUri = null)
    {
      this.i = paramUri;
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (paramString != null) {}
    for (Uri localUri = Uri.parse(paramString);; localUri = null)
    {
      this.j = localUri;
      this.i = paramString;
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 55) || (paramInt2 != -1) || (paramIntent == null)) {
      return;
    }
    a((Uri)paramIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI"));
    i.b().a(this.g, this.i).a();
    this.h.g(true);
  }
  
  public boolean a()
  {
    String str = i.a(this.g);
    if (!k.a(str, this.i))
    {
      a(str);
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public int d()
  {
    return 1;
  }
  
  public String f()
  {
    f localf = this.h.m();
    if (this.j == null) {
      return localf.getString(2131493685);
    }
    return RingtoneManager.getRingtone(localf, this.j).getTitle(localf);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.RINGTONE_PICKER");
    paramView.putExtra("android.intent.extra.ringtone.TYPE", 2);
    paramView.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Settings.System.DEFAULT_NOTIFICATION_URI);
    paramView.putExtra("android.intent.extra.ringtone.EXISTING_URI", this.j);
    paramView.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
    paramView.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
    this.h.a(paramView, 55);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */