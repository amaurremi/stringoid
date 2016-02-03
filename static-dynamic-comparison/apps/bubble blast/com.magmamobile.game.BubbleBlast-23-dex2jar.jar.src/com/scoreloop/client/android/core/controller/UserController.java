package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import com.scoreloop.client.android.core.utils.JSONUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserController
  extends RequestController
{
  private static final Pattern b = Pattern.compile(".*taken.*", 2);
  private User c;
  
  @PublishedFor__1_0_0
  public UserController(UserControllerObserver paramUserControllerObserver)
  {
    this(null, paramUserControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public UserController(Session paramSession, UserControllerObserver paramUserControllerObserver)
  {
    super(paramSession, paramUserControllerObserver);
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    int i = paramResponse.f();
    Object localObject = paramRequest.c();
    paramRequest = paramResponse.e();
    switch (i)
    {
    default: 
      throw new Exception("Request failed");
    case 200: 
    case 201: 
      switch (1.a[localObject.ordinal()])
      {
      }
      do
      {
        do
        {
          if (localObject != RequestMethod.DELETE)
          {
            paramResponse = getUser();
            if (paramRequest.has("user")) {
              paramResponse.a(paramRequest.getJSONObject("user"));
            }
            if (paramRequest.has("context"))
            {
              paramResponse.setContext(JSONUtils.a(paramRequest.getJSONObject("context")));
              paramResponse.e(paramRequest.getString("version"));
            }
          }
          return true;
        } while ((paramRequest.has("user")) || (paramRequest.has("context")));
        throw new Exception("Request failed");
      } while (paramRequest.has("buddy_id"));
      throw new Exception("Request failed");
    case 422: 
      if ((localObject != RequestMethod.PUT) && (localObject != RequestMethod.POST)) {
        throw new Exception("Request failed");
      }
      paramRequest = paramRequest.getJSONObject("error");
      if (!(paramRequest.get("args") instanceof JSONArray)) {
        break;
      }
    }
    for (paramRequest = paramRequest.getJSONArray("args");; paramRequest = null)
    {
      int j;
      int k;
      int m;
      if (paramRequest == null)
      {
        j = 0;
        k = 0;
        i = 0;
        m = 0;
        label288:
        if (k >= j) {
          break label375;
        }
        localObject = paramRequest.getJSONArray(k);
        paramResponse = ((JSONArray)localObject).getString(0);
        localObject = ((JSONArray)localObject).getString(1);
        n = m;
        if ("email".equalsIgnoreCase(paramResponse.trim()))
        {
          if (!b.matcher((CharSequence)localObject).matches()) {
            break label518;
          }
          i = 1;
        }
      }
      for (int n = 1;; n = m)
      {
        k += 1;
        m = n;
        break label288;
        j = paramRequest.length();
        break;
        label375:
        if (i != 0)
        {
          if (m != 0)
          {
            ((UserControllerObserver)b()).onEmailAlreadyTaken(this);
            return false;
          }
          ((UserControllerObserver)b()).onEmailInvalidFormat(this);
          return false;
        }
        ((UserControllerObserver)b()).onUsernameAlreadyTaken(this);
        return false;
        paramResponse = getUser();
        localObject = new HashMap();
        ((Map)localObject).put("oldUserContext", new HashMap(paramResponse.getContext()));
        paramResponse.setContext(JSONUtils.a(paramRequest.getJSONObject("context")));
        paramResponse.e(paramRequest.getString("version"));
        ((Map)localObject).put("newUserContext", new HashMap(paramResponse.getContext()));
        throw new Exception("Request failed");
        label518:
        i = 1;
      }
    }
  }
  
  @PublishedFor__1_0_0
  public void addAsBuddy()
  {
    Object localObject = getUser();
    User localUser = e();
    if (((User)localObject).a(d()))
    {
      b(new Exception("User you're trying to add as buddy is a current session user"));
      return;
    }
    localObject = new b(c(), (User)localObject, localUser);
    h();
    a((Request)localObject);
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public User getUser()
  {
    if (this.c == null)
    {
      this.c = super.e();
      if (this.c == null) {
        throw new IllegalStateException("No session user assigned");
      }
    }
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public void loadBuddies()
  {
    Object localObject = getUser();
    localObject = new g(c(), a(), (User)localObject);
    h();
    a((Request)localObject);
  }
  
  @PublishedFor__1_0_0
  public void loadUser()
  {
    Object localObject = getUser();
    localObject = new c(c(), a(), (User)localObject);
    h();
    a((Request)localObject);
  }
  
  @PublishedFor__1_0_0
  public void loadUserContext()
  {
    if (a() == null) {
      throw new IllegalStateException("user context is being held within a null game, therefore it's kinda hard to retrieve");
    }
    Object localObject = getUser();
    localObject = new a(c(), (User)localObject, a());
    h();
    a((Request)localObject);
  }
  
  @PublishedFor__1_0_0
  public void loadUserDetail()
  {
    User localUser = getUser();
    Object localObject = e();
    if (!localUser.a(d())) {}
    for (;;)
    {
      localObject = new d(c(), a(), localUser, (User)localObject);
      h();
      a((Request)localObject);
      return;
      localObject = null;
    }
  }
  
  @PublishedFor__1_0_0
  public void loadUserWithIdentifier(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("anIdentifier parameter cannot be null");
    }
    this.c = new User();
    this.c.d(paramString);
    loadUser();
  }
  
  @PublishedFor__1_0_0
  public void removeAsBuddy()
  {
    Object localObject = getUser();
    User localUser = e();
    localObject = new e(c(), (User)localObject, localUser);
    h();
    a((Request)localObject);
  }
  
  @PublishedFor__1_0_0
  public void setUser(User paramUser)
  {
    this.c = paramUser;
  }
  
  @PublishedFor__1_0_0
  public void submitUser()
  {
    f localf = new f(c(), a(), getUser());
    h();
    a(localf);
  }
  
  @PublishedFor__1_0_0
  public void submitUserContext()
  {
    if (a() == null) {
      throw new IllegalStateException("trying to put user context into a null game...");
    }
    Object localObject = getUser();
    localObject = new h(c(), (User)localObject, a());
    h();
    a((Request)localObject);
  }
  
  private static class a
    extends UserController.c
  {
    private final Game c;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, User paramUser, Game paramGame)
    {
      super(paramGame, paramUser);
      this.c = paramGame;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/users/%s/context", new Object[] { this.c.getIdentifier(), this.b.getIdentifier() });
    }
    
    public RequestMethod c()
    {
      return RequestMethod.GET;
    }
  }
  
  private static class b
    extends UserController.d
  {
    public b(RequestCompletionCallback paramRequestCompletionCallback, User paramUser1, User paramUser2)
    {
      super(null, paramUser1, paramUser2);
    }
    
    public String a()
    {
      return String.format("/service/users/%s/buddies", new Object[] { this.c.getIdentifier() });
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("buddy_id", this.b.getIdentifier());
        localJSONObject1.put("buddyhood", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException();
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.POST;
    }
  }
  
  private static class c
    extends Request
  {
    protected Game a;
    protected User b;
    
    public c(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, User paramUser)
    {
      super();
      this.b = paramUser;
      this.a = paramGame;
    }
    
    public String a()
    {
      if ((this.a != null) && (this.a.getIdentifier() != null)) {
        return String.format("/service/games/%s/users/%s", new Object[] { this.a.getIdentifier(), this.b.getIdentifier() });
      }
      return String.format("/service/users/%s", new Object[] { this.b.getIdentifier() });
    }
    
    public JSONObject b()
    {
      return null;
    }
    
    public RequestMethod c()
    {
      return RequestMethod.GET;
    }
  }
  
  private static class d
    extends UserController.c
  {
    protected User c;
    
    public d(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, User paramUser1, User paramUser2)
    {
      super(paramGame, paramUser1);
      this.c = paramUser2;
    }
    
    public String a()
    {
      if ((this.a != null) && (this.a.getIdentifier() != null)) {
        return String.format("/service/games/%s/users/%s/detail", new Object[] { this.a.getIdentifier(), this.b.getIdentifier() });
      }
      return String.format("/service/users/%s/detail", new Object[] { this.b.getIdentifier() });
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (this.c != null) {
          localJSONObject.put("reference_user_id", this.c.getIdentifier());
        }
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid user data");
      }
    }
  }
  
  private static class e
    extends UserController.d
  {
    public e(RequestCompletionCallback paramRequestCompletionCallback, User paramUser1, User paramUser2)
    {
      super(null, paramUser1, paramUser2);
    }
    
    public String a()
    {
      return String.format("/service/users/%s/buddies/%s", new Object[] { this.c.getIdentifier(), this.b.getIdentifier() });
    }
    
    public JSONObject b()
    {
      return null;
    }
    
    public RequestMethod c()
    {
      return RequestMethod.DELETE;
    }
  }
  
  private static class f
    extends UserController.c
  {
    private String c;
    private String e;
    
    public f(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, User paramUser)
    {
      super(paramGame, paramUser);
      this.c = paramUser.getLogin();
      this.e = paramUser.getEmailAddress();
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        this.b.setLogin(this.c);
        this.b.setEmailAddress(this.e);
        localJSONObject.put("user", this.b.d());
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid user data", localJSONException);
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.PUT;
    }
  }
  
  private static class g
    extends UserController.c
  {
    public g(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, User paramUser)
    {
      super(paramGame, paramUser);
    }
    
    public String a()
    {
      if ((this.a != null) && (this.a.getIdentifier() != null)) {
        return String.format("/service/users/%s/buddies", new Object[] { this.b.getIdentifier() });
      }
      return String.format("/service/users/%s/buddies", new Object[] { this.b.getIdentifier() });
    }
  }
  
  private static class h
    extends UserController.c
  {
    private final Game c;
    
    public h(RequestCompletionCallback paramRequestCompletionCallback, User paramUser, Game paramGame)
    {
      super(paramGame, paramUser);
      this.c = paramGame;
    }
    
    public String a()
    {
      return String.format("/service/games/%s/users/%s/context", new Object[] { this.c.getIdentifier(), this.b.getIdentifier() });
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (this.b != null)
        {
          localJSONObject.put("context", JSONUtils.a(this.b.getContext()));
          localJSONObject.put("version", this.b.e());
        }
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid user data");
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.POST;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/UserController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */