package com.ideashower.readitlater.util;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ideashower.readitlater.a.g;
import com.pocket.p.o;

public class h
{
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    if ((paramString4 != null) && (g.y()))
    {
      localIntent.setType("application/image");
      localIntent.putExtra("android.intent.extra.STREAM", Uri.parse(paramString4));
    }
    for (;;)
    {
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString1 });
      localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
      if (paramString3 != null) {
        localIntent.putExtra("android.intent.extra.TEXT", paramString3);
      }
      if (!o.a(paramContext, localIntent)) {
        break;
      }
      paramContext.startActivity(localIntent);
      return;
      localIntent.setType("plain/text");
    }
    new AlertDialog.Builder(paramContext).setTitle(2131493124).setMessage(2131493123).setPositiveButton(2131492924, null).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */