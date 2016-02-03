package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.f;
import android.webkit.JavascriptInterface;
import com.ideashower.readitlater.e.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.l;
import com.pocket.p.o;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.a.c.k;
import org.codehaus.jackson.node.ObjectNode;

public class ReaderFragment$JSInterfaceVideo
  extends ReaderFragment.JSInterfaceConnection
{
  public ReaderFragment$JSInterfaceVideo(ReaderFragment paramReaderFragment)
  {
    super(paramReaderFragment, "PocketAndroidVideoInterface");
  }
  
  private int findVimeoDimension(String paramString1, String paramString2)
  {
    int i = 0;
    paramString1 = Pattern.compile(paramString1, 2).matcher(paramString2);
    if (paramString1.find()) {}
    try
    {
      i = Integer.valueOf(paramString1.group(1)).intValue();
      return i;
    }
    catch (Throwable paramString1)
    {
      e.a(paramString1);
    }
    return 0;
  }
  
  @JavascriptInterface
  public boolean isDarkTheme()
  {
    return m.a(m.a());
  }
  
  @JavascriptInterface
  public void loadVideoInNativePlayer(String paramString)
  {
    if (!isEnabled()) {}
    f localf;
    do
    {
      do
      {
        do
        {
          return;
          localf = this.a.m();
        } while ((localf == null) || (this.a.Q()));
        paramString = b.c(paramString);
      } while (!paramString.j());
      paramString = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:".concat(paramString.c())));
      paramString.addFlags(524288);
      paramString.addFlags(1073741824);
    } while (!o.a(localf, paramString));
    this.a.a(paramString);
  }
  
  @JavascriptInterface
  public String onHTML5VideoReady(String paramString, int paramInt)
  {
    int j = 0;
    if (!isEnabled()) {
      return "";
    }
    ObjectNode localObjectNode = l.b();
    if (k.c(paramString)) {
      return localObjectNode.toString();
    }
    int i;
    switch (paramInt)
    {
    default: 
      i = 0;
    }
    for (paramInt = j; (i <= 0) || (paramInt <= 0); paramInt = findVimeoDimension("\"height\"\\:([0-9]{1,4})", paramString))
    {
      return localObjectNode.toString();
      i = findVimeoDimension("\"width\"\\:([0-9]{1,4})", paramString);
    }
    localObjectNode.put("width", i);
    localObjectNode.put("height", paramInt);
    return localObjectNode.toString();
  }
  
  @JavascriptInterface
  public void showFlashVideoNotSupportedDialog()
  {
    if ((!isEnabled()) || (this.a.Q())) {
      return;
    }
    new AlertDialog.Builder(this.a.m()).setTitle(2131493099).setMessage(2131493098).setNeutralButton(2131492924, null).show();
  }
  
  @JavascriptInterface
  public void showOfflineVideoDialog()
  {
    if ((!isEnabled()) || (this.a.Q())) {
      return;
    }
    new AlertDialog.Builder(this.a.m()).setTitle(2131493126).setMessage(2131493125).setNeutralButton(2131492924, null).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ReaderFragment$JSInterfaceVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */