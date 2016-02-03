package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Message;
import com.scoreloop.client.android.core.model.MessageControllerEmailReceiver;
import com.scoreloop.client.android.core.model.MessageReceiver;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.SocialProvider;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import com.scoreloop.client.android.core.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageController
  extends RequestController
{
  @PublishedFor__1_0_0
  public static final String MessageControllerInvitationTarget = "kSLCMessageControllerInvitationTarget";
  private Message b;
  
  @PublishedFor__1_0_0
  public MessageController(RequestControllerObserver paramRequestControllerObserver)
  {
    this(null, paramRequestControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public MessageController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private Message j()
  {
    if (this.b == null) {
      this.b = new Message();
    }
    return this.b;
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public void addReceiverWithUsers(Object paramObject, List<User> paramList)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("null argument");
    }
    if ((paramObject instanceof MessageControllerEmailReceiver))
    {
      if ((paramList == null) || (paramList.size() == 0)) {
        throw new IllegalArgumentException("some users should be passed");
      }
    }
    else if (!SocialProvider.a(paramObject.getClass())) {
      throw new IllegalArgumentException("we don't support such provider");
    }
    ArrayList localArrayList = null;
    if (paramList != null) {
      localArrayList = new ArrayList(paramList);
    }
    paramObject = new MessageReceiver(paramObject, localArrayList);
    j().a((MessageReceiver)paramObject);
  }
  
  @PublishedFor__1_0_0
  public int countReceivers()
  {
    return j().d().size();
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public Object getTarget()
  {
    return j().b();
  }
  
  @PublishedFor__1_0_0
  public String getText()
  {
    return j().c();
  }
  
  @PublishedFor__1_0_0
  public boolean isSubmitAllowed()
  {
    if (getTarget() == null) {
      return false;
    }
    if (j().d().isEmpty()) {
      return false;
    }
    Iterator localIterator = j().d().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((MessageReceiver)localIterator.next()).a();
      if (((localObject instanceof SocialProvider)) && (!((SocialProvider)localObject).isUserConnected(e()))) {
        return false;
      }
    }
    return true;
  }
  
  @PublishedFor__1_0_0
  public void removeAllReceiversOfType(Class<?> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException();
    }
    Logger.a("removeAll invoked");
    Iterator localIterator = j().d().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        MessageReceiver localMessageReceiver = (MessageReceiver)localIterator.next();
        Logger.a("checking " + localMessageReceiver.a() + " against " + paramClass);
        if (localMessageReceiver.a().getClass().equals(paramClass))
        {
          Logger.a("got it, removing");
          j().b(localMessageReceiver);
        }
      }
      else
      {
        return;
      }
      Logger.a("nooope");
    }
  }
  
  @PublishedFor__1_0_0
  public void setTarget(Object paramObject)
  {
    j().a(paramObject);
  }
  
  @PublishedFor__1_0_0
  public void setText(String paramString)
  {
    j().a(paramString);
  }
  
  @PublishedFor__1_0_0
  public void submitMessage()
  {
    if (!isSubmitAllowed()) {
      throw new IllegalStateException("submitting is not allowed");
    }
    h();
    a(new a(j(), c()));
  }
  
  private class a
    extends Request
  {
    private Message b;
    
    public a(Message paramMessage, RequestCompletionCallback paramRequestCompletionCallback)
    {
      super();
      this.b = paramMessage.a();
    }
    
    public String a()
    {
      return String.format("/service/games/%s/users/%s/message", new Object[] { MessageController.this.a().getIdentifier(), MessageController.this.e().getIdentifier() });
    }
    
    public JSONObject b()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("message", this.b.e());
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException(localJSONException);
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.POST;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/MessageController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */