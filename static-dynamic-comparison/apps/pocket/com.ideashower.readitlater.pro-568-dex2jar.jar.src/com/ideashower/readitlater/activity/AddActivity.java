package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.service.AddItemFromIntentService;
import com.ideashower.readitlater.service.AddOverlayService;
import com.ideashower.readitlater.service.WakefulAppService;
import com.ideashower.readitlater.util.y;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.a.c.k;

public class AddActivity
  extends Activity
{
  private static Pattern a;
  private static j b;
  
  private String a(Intent paramIntent, String paramString)
  {
    String str = paramIntent.getStringExtra(paramString);
    if (!k.c(str)) {
      return str;
    }
    long l = paramIntent.getLongExtra(paramString, 0L);
    if (l != 0L) {
      return String.valueOf(l);
    }
    return null;
  }
  
  private String a(String paramString)
  {
    if (a == null) {
      a = Pattern.compile("^https?:/\\/(www\\.)?twitter\\.com\\/.*\\/status(es)?\\/([0-9]+)", 2);
    }
    paramString = a.matcher(paramString);
    if (paramString.matches()) {
      return paramString.group(3);
    }
    return null;
  }
  
  private String a(ArrayList paramArrayList, Intent paramIntent)
  {
    Object localObject = a(paramIntent, "tweetStatusId");
    if (localObject != null) {}
    do
    {
      String str;
      do
      {
        return (String)localObject;
        str = a(paramIntent, "tweet_id");
        localObject = str;
      } while (str != null);
      paramIntent = a(paramIntent, "tweetid");
      localObject = paramIntent;
    } while (paramIntent != null);
    int i = paramArrayList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label91;
      }
      paramIntent = a((String)paramArrayList.get(i));
      localObject = paramIntent;
      if (!k.c(paramIntent)) {
        break;
      }
      i -= 1;
    }
    label91:
    return null;
  }
  
  public static void a(j paramj)
  {
    b = paramj;
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (i.a(com.ideashower.readitlater.h.a.bn))
    {
      AddOverlayService.a(this, paramString1, paramString2, paramBoolean);
      return;
    }
    Intent localIntent = new Intent(this, AddItemFromIntentService.class);
    localIntent.putExtra("newItemUrl", paramString1);
    if (paramString2 != null)
    {
      localIntent.putExtra("tweetId", paramString2);
      localIntent.putExtra("isGivenUrlTwitterUrl", paramBoolean);
    }
    com.ideashower.readitlater.service.a.a(this, localIntent);
  }
  
  public static void b(j paramj)
  {
    if (b == paramj) {
      b = null;
    }
  }
  
  private boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new com.ideashower.readitlater.db.operation.a(paramString1, paramString2, paramBoolean);
    paramString1.f();
    switch (paramString1.d_())
    {
    case -2: 
    default: 
      return true;
    }
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    String str = null;
    int j = 2131493734;
    boolean bool2 = false;
    int i = 0;
    super.onCreate(paramBundle);
    if (!as.l())
    {
      j = 2131493733;
      i = 1;
      paramBundle = WakefulAppService.a(this, j, 1);
      if (i != 0) {
        WakefulAppService.a(paramBundle, this);
      }
      paramBundle.show();
      AddOverlayService.a = paramBundle;
      if (!isFinishing()) {
        finish();
      }
      return;
    }
    ArrayList localArrayList = y.a(getIntent().getStringExtra("android.intent.extra.TEXT"));
    label100:
    boolean bool1;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      paramBundle = (String)localArrayList.get(0);
      if (paramBundle != null) {
        str = a(localArrayList, getIntent());
      }
      if ((str == null) || (localArrayList.size() != 1)) {
        break label181;
      }
      bool1 = true;
      label133:
      if (b != null) {
        break label194;
      }
      if (paramBundle == null) {
        break label187;
      }
      a(paramBundle, str, bool1);
    }
    label181:
    label187:
    for (int k = 2131493734;; k = 2131493732)
    {
      j = k;
      if (i.a(com.ideashower.readitlater.h.a.bn)) {
        break;
      }
      i = 1;
      j = k;
      break;
      paramBundle = null;
      break label100;
      bool1 = false;
      break label133;
    }
    label194:
    if (paramBundle != null) {
      bool2 = b(paramBundle, str, bool1);
    }
    if (bool2) {}
    for (i = j;; i = 2131493732)
    {
      b.a(bool2, this);
      k = 1;
      j = i;
      i = k;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/AddActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */