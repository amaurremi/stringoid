package com.mocoplex.adlib;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class SubAdlibAdViewCore
  extends LinearLayout
{
  protected Handler a;
  public boolean b = false;
  
  public SubAdlibAdViewCore(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubAdlibAdViewCore(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void clearAdView()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public void failed()
  {
    if (this.a != null) {
      this.a.sendMessage(Message.obtain(this.a, -1));
    }
  }
  
  public void gotAd()
  {
    if (this.a != null) {
      this.a.sendMessage(Message.obtain(this.a, 0));
    }
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public abstract void query();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/SubAdlibAdViewCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */