package com.scoreloop.client.android.core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.util.Log;
import com.a.a.a;
import com.a.a.a.a;
import com.a.a.c;
import com.a.a.c.a;
import com.a.a.f;
import com.a.a.h;
import com.scoreloop.client.android.core.model.FacebookSocialProvider;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.SocialProvider;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.utils.Logger;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthViewController
  extends AuthViewController
{
  public FacebookPermissionDialog a;
  public boolean b;
  private FacebookLoginDialog c;
  private Activity d;
  private boolean e;
  private h f;
  private a.a g;
  private b h;
  
  public FacebookAuthViewController(Session paramSession, AuthViewController.Observer paramObserver)
  {
    super(paramSession, paramObserver);
  }
  
  private void f()
  {
    if (this.a != null) {
      this.a.dismiss();
    }
    this.a = null;
  }
  
  private void g()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
    this.c = null;
  }
  
  private void h()
  {
    this.h = new b(null);
    FacebookSocialProvider.b().d().add(this.h);
  }
  
  a.a a()
  {
    return this.g;
  }
  
  public void a(Activity paramActivity)
  {
    this.e = false;
    this.d = paramActivity;
    h();
    ((FacebookSocialProvider)SocialProvider.getSocialProviderForIdentifier("com.facebook.v1")).c();
    this.g = new c(null);
    this.f = new a(null);
    this.c = new FacebookLoginDialog(paramActivity, a());
    this.c.show();
    this.c.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        FacebookAuthViewController.this.e().d();
      }
    });
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.e = true;
    }
    f();
    g();
  }
  
  void b()
  {
    f localf = d.a(this.f);
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_id", d().getUser().getIdentifier());
    Log.d("inform", "STARTING REQUEST ------------------------------------------------------------------");
    localf.b("http://apps.facebook.com/scoreloop/scoreloop/sdk", localHashMap);
  }
  
  public Activity c()
  {
    return this.d;
  }
  
  private class a
    implements h
  {
    private a() {}
    
    public void a(f paramf) {}
    
    public void a(f paramf, Object paramObject)
    {
      Logger.a("parsing FB response...");
      try
      {
        Logger.d("fbresponse", paramObject.toString());
        paramf = paramObject.toString().split("SL123456789#");
        if (paramf.length > 1)
        {
          paramObject = paramf[1].split("#", 2);
          paramf = "";
          if (paramObject.length > 1)
          {
            paramObject = paramObject[0];
            paramf = (f)paramObject;
            if (((String)paramObject).equalsIgnoreCase("ok"))
            {
              Logger.a("FB response parsed OK");
              FacebookAuthViewController.this.e().c();
              FacebookAuthViewController.this.b = true;
              return;
            }
          }
        }
      }
      catch (IOException paramf)
      {
        for (;;)
        {
          Logger.b("cannot print debug response to SDCard");
        }
        paramf = "GOT app's boundary but the message was != OK : " + paramf;
        Logger.a("facebook response parser", paramf);
        FacebookAuthViewController.this.e().a(new IllegalArgumentException(paramf));
      }
      for (;;)
      {
        FacebookAuthViewController.a(FacebookAuthViewController.this, true);
        return;
        Logger.a("facebook response parser", "DID NOT FIND APP BOUNDARY IN THE RESPONSE");
        FacebookAuthViewController.this.e().a(new IllegalArgumentException("DID NOT FIND APP BOUNDARY IN THE RESPONSE"));
      }
    }
    
    public void a(f paramf, Throwable paramThrowable)
    {
      FacebookAuthViewController.this.e().a(paramThrowable);
    }
    
    public void b(f paramf)
    {
      throw new IllegalStateException();
    }
  }
  
  private class b
    extends c.a
  {
    private b() {}
    
    public void a(c paramc, Long paramLong)
    {
      if ((FacebookAuthViewController.a(FacebookAuthViewController.this)) || (FacebookAuthViewController.this.b)) {
        return;
      }
      FacebookAuthViewController.this.a = new FacebookPermissionDialog(FacebookAuthViewController.this.c(), new a(null));
      FacebookAuthViewController.this.a.show();
      FacebookAuthViewController.b(FacebookAuthViewController.this);
    }
    
    private final class a
      extends a.a
    {
      private a() {}
      
      public void a(a parama)
      {
        FacebookAuthViewController.this.b();
      }
      
      public void a(a parama, Throwable paramThrowable)
      {
        FacebookAuthViewController.this.e().a(paramThrowable);
      }
      
      public void b(a parama)
      {
        FacebookAuthViewController.this.e().d();
      }
    }
  }
  
  private final class c
    extends a.a
  {
    private c() {}
    
    public void a(a parama, Throwable paramThrowable)
    {
      FacebookAuthViewController.this.a(false);
      FacebookAuthViewController.this.e().a(paramThrowable);
    }
    
    public void b(a parama)
    {
      FacebookAuthViewController.this.a(false);
      FacebookAuthViewController.this.e().d();
    }
  }
  
  private static class d
    extends f
  {
    public d(c paramc, h paramh)
    {
      super(paramh);
    }
    
    public static f a(h paramh)
    {
      return new d(c.a(), paramh);
    }
    
    protected Object a(String paramString)
    {
      return paramString;
    }
    
    protected boolean c()
    {
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/FacebookAuthViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */