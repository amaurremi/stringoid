package com.scoreloop.client.android.core.controller;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.model.Game;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.SocialProvider;
import com.scoreloop.client.android.core.model.User;
import com.scoreloop.client.android.core.server.Request;
import com.scoreloop.client.android.core.server.RequestCompletionCallback;
import com.scoreloop.client.android.core.server.RequestMethod;
import com.scoreloop.client.android.core.server.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsersController
  extends RequestController
{
  private int b = 25;
  private boolean c = true;
  private SearchSpec d = null;
  private String e = null;
  private String f = null;
  private LoginSearchOperator g = LoginSearchOperator.PREFIX;
  private List<User> h = Collections.emptyList();
  private Integer i = null;
  
  @PublishedFor__1_0_0
  public UsersController(RequestControllerObserver paramRequestControllerObserver)
  {
    this(null, paramRequestControllerObserver);
  }
  
  @PublishedFor__1_0_0
  public UsersController(Session paramSession, RequestControllerObserver paramRequestControllerObserver)
  {
    super(paramSession, paramRequestControllerObserver);
  }
  
  private a a(String paramString, SearchSpec paramSearchSpec)
  {
    this.f = null;
    this.e = paramString;
    this.d = paramSearchSpec;
    return j();
  }
  
  private void a(List<User> paramList)
  {
    this.h = Collections.unmodifiableList(paramList);
    this.i = null;
  }
  
  private a j()
  {
    a locala = new a(c(), a(), this.c, this.b);
    if ((this.f == null) && (this.d == null)) {
      throw new IllegalStateException("Set a search list or use one of searchBy.. methods first");
    }
    locala.a(new b(this.e, this.d, this.f));
    return locala;
  }
  
  private SearchSpec k()
  {
    SearchSpec localSearchSpec = new SearchSpec(new i("login", i.a.ASCENDING));
    if (!this.c) {
      localSearchSpec.a(new b("skills_game_id", h.IS, a().getIdentifier()));
    }
    return localSearchSpec;
  }
  
  boolean a(Request paramRequest, Response paramResponse)
    throws Exception
  {
    int j = paramResponse.f();
    if (j != 200) {
      throw new Exception("Request failed with status:" + j);
    }
    paramRequest = new ArrayList();
    if (paramResponse.c())
    {
      paramResponse = paramResponse.d();
      int k = paramResponse.length();
      j = 0;
      while (j < k)
      {
        paramRequest.add(new User(paramResponse.getJSONObject(j).getJSONObject("user")));
        j += 1;
      }
      a(paramRequest);
    }
    for (;;)
    {
      return true;
      a(paramRequest);
      this.i = Integer.valueOf(paramResponse.e().getInt("users_count"));
    }
  }
  
  boolean g()
  {
    return true;
  }
  
  @PublishedFor__1_0_0
  public int getCountOfUsers()
  {
    if (this.i != null) {
      return this.i.intValue();
    }
    return getUsers().size();
  }
  
  @PublishedFor__1_0_0
  public int getSearchLimit()
  {
    return this.b;
  }
  
  @PublishedFor__1_0_0
  public LoginSearchOperator getSearchOperator()
  {
    return this.g;
  }
  
  @PublishedFor__1_0_0
  public boolean getSearchesGlobal()
  {
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public List<User> getUsers()
  {
    return this.h;
  }
  
  @PublishedFor__1_0_0
  public boolean isOverLimit()
  {
    return this.i != null;
  }
  
  @PublishedFor__1_0_0
  public void searchByEmail(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Parameter anEmail cannot be null");
    }
    SearchSpec localSearchSpec = k();
    localSearchSpec.a(new b("email", h.EXACT, paramString));
    paramString = a("UserEMailSearch", localSearchSpec);
    h();
    a(paramString);
  }
  
  @PublishedFor__1_0_0
  public void searchByLocalAddressBook()
  {
    Object localObject1 = k();
    Object localObject2 = AddressBook.a();
    ((AddressBook)localObject2).a(AddressBook.HashAlgorithm.MD5);
    ((AddressBook)localObject2).a("shwu2831j78s");
    localObject2 = ((AddressBook)localObject2).a(d().d());
    if (((List)localObject2).size() == 0)
    {
      a(Collections.emptyList());
      f();
      return;
    }
    if (((List)localObject2).size() == 1) {
      ((SearchSpec)localObject1).a(new b("email_digest", h.EQUALS_ANY, (String)((List)localObject2).get(0)));
    }
    for (;;)
    {
      localObject1 = a("UserAddressBookSearch", (SearchSpec)localObject1);
      h();
      a((Request)localObject1);
      return;
      ((SearchSpec)localObject1).a(new b("email_digest", h.EQUALS_ANY, (Collection)localObject2));
    }
  }
  
  @PublishedFor__1_0_0
  public void searchByLogin(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Parameter aLogin cannot be null");
    }
    SearchSpec localSearchSpec = k();
    h localh;
    if (this.g != null) {
      switch (1.a[this.g.ordinal()])
      {
      default: 
        localh = h.BEGINS_WITH;
      }
    }
    for (;;)
    {
      localSearchSpec.a(new b("login", localh, paramString));
      paramString = a("UserLoginSearch", localSearchSpec);
      h();
      a(paramString);
      return;
      localh = h.LIKE;
      continue;
      localh = h.EXACT;
      continue;
      localh = h.BEGINS_WITH;
    }
  }
  
  @PublishedFor__1_0_0
  public void searchBySocialProvider(SocialProvider paramSocialProvider)
  {
    if (paramSocialProvider == null) {
      throw new IllegalArgumentException("Parameter aSocialProvider cannot be null");
    }
    SearchSpec localSearchSpec = k();
    localSearchSpec.a(new b("social_provider_id", h.EXACT, paramSocialProvider.getIdentifier()));
    paramSocialProvider = a("#user_social_provider_search", localSearchSpec);
    paramSocialProvider.a(e());
    h();
    a(paramSocialProvider);
  }
  
  @PublishedFor__1_0_0
  public void setSearchLimit(int paramInt)
  {
    this.b = paramInt;
  }
  
  @PublishedFor__1_0_0
  public void setSearchOperator(LoginSearchOperator paramLoginSearchOperator)
  {
    if (paramLoginSearchOperator == null) {
      throw new IllegalArgumentException("Parameter aSearchOperator cannot be null");
    }
    this.g = paramLoginSearchOperator;
  }
  
  @PublishedFor__1_0_0
  public void setSearchesGlobal(boolean paramBoolean)
  {
    if ((a() == null) && (!paramBoolean)) {
      throw new IllegalArgumentException("cannot search not globally without game being set");
    }
    this.c = paramBoolean;
  }
  
  @PublishedFor__1_0_0
  public static enum LoginSearchOperator
  {
    private LoginSearchOperator() {}
  }
  
  private class a
    extends Request
  {
    private final Game b;
    private final int c;
    private final boolean e;
    private User f;
    private UsersController.b g;
    
    public a(RequestCompletionCallback paramRequestCompletionCallback, Game paramGame, boolean paramBoolean, int paramInt)
    {
      super();
      this.b = paramGame;
      this.e = paramBoolean;
      this.c = paramInt;
    }
    
    public String a()
    {
      if (this.e) {
        return "/service/users";
      }
      return String.format("/service/games/%s/users", new Object[] { this.b.getIdentifier() });
    }
    
    public void a(UsersController.b paramb)
    {
      this.g = paramb;
    }
    
    public void a(User paramUser)
    {
      this.f = paramUser;
    }
    
    public JSONObject b()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("limit", this.c);
        if (this.g != null)
        {
          if (this.f != null) {
            this.g.a(this.f.getIdentifier());
          }
          localJSONObject.put("search_list", this.g.a());
        }
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid data", localJSONException);
      }
    }
    
    public RequestMethod c()
    {
      return RequestMethod.GET;
    }
  }
  
  private static final class b
  {
    private String a;
    private SearchSpec b;
    private String c;
    
    b(String paramString1, SearchSpec paramSearchSpec, String paramString2)
    {
      this.a = paramString1;
      this.b = paramSearchSpec;
      this.c = paramString2;
    }
    
    JSONObject a()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("name", this.a);
        localJSONObject.put("definition", this.b.a());
        localJSONObject.put("id", this.c);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException("Invalid search spec data");
      }
    }
    
    void a(String paramString)
    {
      if (this.b != null) {
        this.b.a(new b("reference_user_id", h.EXACT, paramString));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/UsersController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */