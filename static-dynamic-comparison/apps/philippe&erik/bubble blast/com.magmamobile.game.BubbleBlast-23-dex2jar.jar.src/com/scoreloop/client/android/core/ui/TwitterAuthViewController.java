package com.scoreloop.client.android.core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.utils.Logger;
import com.scoreloop.client.android.core.utils.OAuthBuilder;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TwitterAuthViewController
  extends AuthViewController
{
  TwitterAuthDialog a;
  private String b;
  
  public TwitterAuthViewController(Session paramSession, AuthViewController.Observer paramObserver)
  {
    super(paramSession, paramObserver);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(Activity paramActivity)
  {
    Object localObject = new OAuthBuilder();
    HashMap localHashMap = new HashMap();
    localHashMap.put("oauth_token", this.b);
    localObject = ((OAuthBuilder)localObject).a("http://twitter.com/oauth/authorize", localHashMap);
    this.a = new TwitterAuthDialog(paramActivity, 16973841, this);
    this.a.b();
    this.a.setCancelable(true);
    this.a.setCanceledOnTouchOutside(true);
    this.a.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        Logger.a("twitter auth view controller", "dialog dismissed");
      }
    });
    this.a.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        Logger.a("twitter auth view controller", "dialog cancelled");
      }
    });
    this.a.a(((URL)localObject).toString());
    this.a.show();
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/TwitterAuthViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */