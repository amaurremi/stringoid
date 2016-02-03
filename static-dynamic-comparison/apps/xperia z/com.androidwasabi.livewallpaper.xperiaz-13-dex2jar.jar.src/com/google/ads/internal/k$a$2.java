package com.google.ads.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class k$a$2
  implements DialogInterface.OnClickListener
{
  k$a$2(k.a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new Thread(new j(k.a.a(this.a).d(), k.a.b(this.a).getApplicationContext())).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/k$a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */