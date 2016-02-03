package com.scoreloop.client.android.core.controller;

import com.a.a.c;
import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.FacebookSocialProvider;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.SocialProvider;
import com.scoreloop.client.android.core.ui.AuthViewController.Observer;
import com.scoreloop.client.android.core.ui.FacebookAuthViewController;
import java.util.List;

public class FacebookSocialProviderController
  extends SocialProviderController
{
  private boolean d;
  private UserController e;
  private FacebookAuthViewController f;
  
  @PublishedFor__1_0_0
  public FacebookSocialProviderController(Session paramSession, SocialProviderControllerObserver paramSocialProviderControllerObserver)
  {
    super(paramSession, paramSocialProviderControllerObserver);
  }
  
  private c c()
  {
    return ((FacebookSocialProvider)getSocialProvider()).c();
  }
  
  private void d()
  {
    c().d().remove(this);
  }
  
  public void a()
  {
    ((FacebookSocialProvider)getSocialProvider()).a(g().getUser(), c().h(), e());
    d();
    this.d = true;
    this.f.a(true);
    f().didSucceed(this);
  }
  
  void b()
  {
    if (getSocialProvider().isUserConnected(g().getUser()))
    {
      a();
      return;
    }
    this.f = new FacebookAuthViewController(g(), new b(null));
    a(e(), this.f);
  }
  
  private final class a
    implements UserControllerObserver
  {
    private a() {}
    
    public void onEmailAlreadyTaken(UserController paramUserController)
    {
      FacebookSocialProviderController.a(FacebookSocialProviderController.this).a(false);
      FacebookSocialProviderController.this.f().didFail(FacebookSocialProviderController.this, new IllegalStateException());
    }
    
    public void onEmailInvalidFormat(UserController paramUserController)
    {
      FacebookSocialProviderController.a(FacebookSocialProviderController.this).a(false);
      FacebookSocialProviderController.this.f().didFail(FacebookSocialProviderController.this, new IllegalStateException());
    }
    
    public void onUsernameAlreadyTaken(UserController paramUserController)
    {
      FacebookSocialProviderController.a(FacebookSocialProviderController.this).a(false);
      FacebookSocialProviderController.this.f().didFail(FacebookSocialProviderController.this, new IllegalStateException());
    }
    
    public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
    {
      FacebookSocialProviderController.a(FacebookSocialProviderController.this).a(false);
      FacebookSocialProviderController.this.f().didFail(FacebookSocialProviderController.this, paramException);
    }
    
    public void requestControllerDidReceiveResponse(RequestController paramRequestController)
    {
      FacebookSocialProviderController.this.a();
    }
  }
  
  private final class b
    implements AuthViewController.Observer
  {
    private b() {}
    
    public void a()
    {
      FacebookSocialProviderController.a(FacebookSocialProviderController.this).a(false);
      FacebookSocialProviderController.this.f().didEnterInvalidCredentials(FacebookSocialProviderController.this);
    }
    
    public void a(Throwable paramThrowable)
    {
      FacebookSocialProviderController.a(FacebookSocialProviderController.this).a(false);
      FacebookSocialProviderController.this.f().didFail(FacebookSocialProviderController.this, paramThrowable);
    }
    
    public void c()
    {
      if (FacebookSocialProviderController.b(FacebookSocialProviderController.this)) {
        return;
      }
      FacebookSocialProviderController.a(FacebookSocialProviderController.this, new UserController(FacebookSocialProviderController.this.g(), new FacebookSocialProviderController.a(FacebookSocialProviderController.this, null)));
      FacebookSocialProviderController.c(FacebookSocialProviderController.this).setUser(FacebookSocialProviderController.this.g().getUser());
      FacebookSocialProviderController.c(FacebookSocialProviderController.this).loadUser();
    }
    
    public void d()
    {
      FacebookSocialProviderController.this.f().userDidCancel(FacebookSocialProviderController.this);
      FacebookSocialProviderController.a(FacebookSocialProviderController.this).a(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/FacebookSocialProviderController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */