package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.model.AuthRequestDelegate;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.SocialProvider;
import com.scoreloop.client.android.core.model.TwitterAuthRequest;
import com.scoreloop.client.android.core.ui.AuthViewController.Observer;
import com.scoreloop.client.android.core.ui.TwitterAuthViewController;

public class TwitterSocialProviderController
  extends SocialProviderController
  implements UserControllerObserver, AuthRequestDelegate, AuthViewController.Observer
{
  private TwitterAuthRequest d;
  private TwitterAuthViewController e;
  private TwitterAuthRequest f;
  private UserController g;
  
  public TwitterSocialProviderController(Session paramSession, SocialProviderControllerObserver paramSocialProviderControllerObserver)
  {
    super(paramSession, paramSocialProviderControllerObserver);
  }
  
  public void a()
  {
    f().didEnterInvalidCredentials(this);
  }
  
  public void a(TwitterAuthRequest paramTwitterAuthRequest)
  {
    if (paramTwitterAuthRequest == this.d)
    {
      this.e = new TwitterAuthViewController(g(), this);
      this.e.a(this.d.c());
      a(e(), this.e);
      return;
    }
    if (paramTwitterAuthRequest == this.f)
    {
      getSocialProvider().a(g().getUser(), this.f.c(), this.f.d(), this.f.e());
      if (this.g != null) {
        throw new IllegalStateException("_userController must be null at this point");
      }
      this.g = new UserController(this);
      this.g.setUser(g().getUser());
      this.g.submitUser();
      return;
    }
    throw new IllegalStateException("unexpected request");
  }
  
  public void a(TwitterAuthRequest paramTwitterAuthRequest, Throwable paramThrowable)
  {
    f().didFail(this, paramThrowable);
  }
  
  public void a(Throwable paramThrowable)
  {
    f().didFail(this, paramThrowable);
  }
  
  void b()
  {
    this.d = new TwitterAuthRequest(this);
    this.d.b();
  }
  
  public void c()
  {
    this.f = new TwitterAuthRequest(this);
    this.f.a(this.d.c(), this.d.d());
  }
  
  public void d()
  {
    f().userDidCancel(this);
  }
  
  public void onEmailAlreadyTaken(UserController paramUserController)
  {
    f().didFail(this, new IllegalStateException("twitter: SL user's email already taken"));
  }
  
  public void onEmailInvalidFormat(UserController paramUserController)
  {
    f().didFail(this, new IllegalStateException("twitter: SL user's email invalid format"));
  }
  
  public void onUsernameAlreadyTaken(UserController paramUserController)
  {
    f().didFail(this, new IllegalStateException("twitter: SL username already taken"));
  }
  
  public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
  {
    f().didFail(this, paramException);
  }
  
  public void requestControllerDidReceiveResponse(RequestController paramRequestController)
  {
    f().didSucceed(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/TwitterSocialProviderController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */