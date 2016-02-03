package com.google.ads.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class g$a$6
  implements DialogInterface.OnClickListener
{
  g$a$6(JsPromptResult paramJsPromptResult, EditText paramEditText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.confirm(this.b.getText().toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/g$a$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */