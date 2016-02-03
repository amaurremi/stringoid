package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.ui.AuthViewController.Observer;
import com.scoreloop.client.android.core.ui.MySpaceAuthViewController;
import com.scoreloop.client.android.core.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class MySpaceSocialProviderController
  extends SocialProviderController
  implements UserControllerObserver
{
  private UserController d;
  
  @PublishedFor__1_0_0
  public MySpaceSocialProviderController(Session paramSession, SocialProviderControllerObserver paramSocialProviderControllerObserver)
  {
    super(paramSession, paramSocialProviderControllerObserver);
  }
  
  public void b()
  {
    MySpaceAuthViewController localMySpaceAuthViewController = new MySpaceAuthViewController(g(), new AuthViewController.Observer()
    {
      public void a()
      {
        MySpaceSocialProviderController.this.f().didEnterInvalidCredentials(MySpaceSocialProviderController.this);
      }
      
      public void a(Throwable paramAnonymousThrowable)
      {
        MySpaceSocialProviderController.this.f().didFail(MySpaceSocialProviderController.this, paramAnonymousThrowable);
      }
      
      public void c()
      {
        if (MySpaceSocialProviderController.a(MySpaceSocialProviderController.this) == null) {
          MySpaceSocialProviderController.a(MySpaceSocialProviderController.this, new UserController(MySpaceSocialProviderController.this.g(), MySpaceSocialProviderController.this));
        }
        MySpaceSocialProviderController.a(MySpaceSocialProviderController.this).setUser(MySpaceSocialProviderController.this.g().getUser());
        MySpaceSocialProviderController.a(MySpaceSocialProviderController.this).submitUser();
      }
      
      public void d()
      {
        MySpaceSocialProviderController.this.f().userDidCancel(MySpaceSocialProviderController.this);
      }
    });
    a(e(), localMySpaceAuthViewController);
  }
  
  public void onEmailAlreadyTaken(UserController paramUserController)
  {
    throw new IllegalStateException();
  }
  
  public void onEmailInvalidFormat(UserController paramUserController)
  {
    throw new IllegalStateException();
  }
  
  public void onUsernameAlreadyTaken(UserController paramUserController)
  {
    throw new IllegalStateException();
  }
  
  public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
  {
    f().didFail(this, paramException);
  }
  
  public void requestControllerDidReceiveResponse(RequestController paramRequestController)
  {
    f().didSucceed(this);
    try
    {
      Logger.a("user object: ", "USER: " + g().getUser().d().toString(4));
      return;
    }
    catch (JSONException paramRequestController)
    {
      paramRequestController.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/MySpaceSocialProviderController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */