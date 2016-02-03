package com.ideashower.readitlater.objects;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;

@TargetApi(11)
public class f
  extends e
{
  private ClipboardManager b;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public String a()
  {
    if (!this.b.hasPrimaryClip()) {}
    Object localObject;
    do
    {
      ClipData.Item localItem;
      do
      {
        do
        {
          return null;
        } while (!this.b.getPrimaryClipDescription().hasMimeType("text/plain"));
        localItem = this.b.getPrimaryClip().getItemAt(0);
      } while (localItem == null);
      if (localItem.getText() != null) {}
      for (localObject = localItem.getText().toString(); localObject != null; localObject = null) {
        return (String)localObject;
      }
      localObject = localItem.getUri();
    } while (localObject == null);
    return ((Uri)localObject).toString();
  }
  
  protected void a(String paramString)
  {
    paramString = ClipData.newPlainText(this.a.getString(2131492974), paramString);
    this.b.setPrimaryClip(paramString);
  }
  
  protected void b(Context paramContext)
  {
    this.b = ((ClipboardManager)paramContext.getSystemService("clipboard"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */