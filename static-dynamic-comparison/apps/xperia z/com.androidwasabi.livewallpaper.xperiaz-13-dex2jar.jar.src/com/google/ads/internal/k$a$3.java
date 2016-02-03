package com.google.ads.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class k$a$3
  implements DialogInterface.OnClickListener
{
  k$a$3(k.a parama, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    k.a.b(this.b).startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.a), "Share via"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/k$a$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */