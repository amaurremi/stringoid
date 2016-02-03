package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.utils.Formats;
import com.scoreloop.client.android.core.utils.JSONUtils;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class User
{
  private static Map<String, b> a = new HashMap();
  private Map<String, JSONObject> A = new HashMap();
  private Activity B;
  private String C;
  private a b;
  private boolean c;
  private String d;
  private String e;
  private String f;
  private Integer g;
  private String h;
  private List<User> i;
  private Map<String, Object> j;
  private String k;
  private Details l = new Details();
  private Date m;
  private String n;
  private String o;
  private Gender p = Gender.UNKNOWN;
  private String q;
  private a r;
  private Date s;
  private String t;
  private String u;
  private Integer v;
  private b w;
  private a x;
  private List<SearchList> y;
  private List<SearchList> z;
  
  static
  {
    a.put("anonymous", b.anonymous);
    a.put("active", b.active);
    a.put("deleted", b.deleted);
    a.put("passive", b.passive);
    a.put("pending", b.pending);
    a.put("suspended", b.suspended);
  }
  
  public User() {}
  
  public User(JSONObject paramJSONObject)
    throws JSONException
  {
    this();
    a(paramJSONObject);
  }
  
  private Integer i()
  {
    return this.g;
  }
  
  private String j()
  {
    return this.h;
  }
  
  private b k()
  {
    return this.w;
  }
  
  public Money a()
  {
    if ((i() == null) || (j() == null)) {
      return new Money("SLD", new BigDecimal(0));
    }
    return new Money(j(), new BigDecimal(i().intValue()));
  }
  
  public void a(String paramString)
  {
    this.n = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    int i2 = 0;
    if (paramJSONObject.has("id")) {
      this.q = paramJSONObject.getString("id");
    }
    if (paramJSONObject.has("login")) {
      this.t = paramJSONObject.optString("login");
    }
    if (paramJSONObject.has("email")) {
      this.o = paramJSONObject.optString("email");
    }
    if (paramJSONObject.has("state"))
    {
      localObject = paramJSONObject.optString("state").toLowerCase();
      if (!a.containsKey(localObject)) {
        throw new IllegalStateException("could not parse json representation of User due to unknown state given: '" + (String)localObject + "'");
      }
      this.w = ((b)a.get(localObject));
    }
    if (paramJSONObject.has("device_id")) {
      this.n = paramJSONObject.optString("device_id");
    }
    if (paramJSONObject.has("gender"))
    {
      localObject = paramJSONObject.getString("gender");
      if ("m".equalsIgnoreCase((String)localObject)) {
        this.p = Gender.MALE;
      }
    }
    else if (paramJSONObject.has("date_of_birth"))
    {
      if (!paramJSONObject.isNull("date_of_birth")) {
        break label512;
      }
      this.m = null;
    }
    ArrayList localArrayList;
    int i1;
    for (;;)
    {
      localObject = paramJSONObject.optJSONObject("balance");
      if (localObject != null)
      {
        this.g = Integer.valueOf(((JSONObject)localObject).getInt("amount"));
        this.h = ((JSONObject)localObject).getString("currency");
      }
      localObject = paramJSONObject.optJSONObject("avatar");
      if (localObject != null)
      {
        this.f = ((JSONObject)localObject).getString("head");
        this.e = ((JSONObject)localObject).getString("hair");
        this.d = ((JSONObject)localObject).getString("body");
      }
      SocialProvider.b(this, paramJSONObject);
      localObject = paramJSONObject.optJSONObject("skill");
      if (localObject != null) {
        this.v = Integer.valueOf(((JSONObject)localObject).getInt("value"));
      }
      localObject = paramJSONObject.optJSONObject("agility");
      if (localObject != null) {
        this.b = new a((JSONObject)localObject);
      }
      localObject = paramJSONObject.optJSONObject("strategy");
      if (localObject != null) {
        this.x = new a((JSONObject)localObject);
      }
      localObject = paramJSONObject.optJSONObject("knowledge");
      if (localObject != null) {
        this.r = new a((JSONObject)localObject);
      }
      localObject = paramJSONObject.optJSONArray("score_lists");
      if (localObject == null) {
        break label549;
      }
      localArrayList = new ArrayList();
      i1 = 0;
      for (;;)
      {
        if (i1 < ((JSONArray)localObject).length())
        {
          localArrayList.add(new SearchList(((JSONArray)localObject).getJSONObject(i1)));
          i1 += 1;
          continue;
          if ("f".equalsIgnoreCase((String)localObject))
          {
            this.p = Gender.FEMALE;
            break;
          }
          this.p = Gender.UNKNOWN;
          break;
          try
          {
            label512:
            this.m = Formats.b.parse(paramJSONObject.getString("date_of_birth"));
          }
          catch (ParseException paramJSONObject)
          {
            throw new JSONException("Invalid format of the birth date");
          }
        }
      }
    }
    this.y = localArrayList;
    label549:
    Object localObject = paramJSONObject.optJSONArray("challenge_lists");
    if (localObject != null)
    {
      localArrayList = new ArrayList();
      i1 = 0;
      while (i1 < ((JSONArray)localObject).length())
      {
        localArrayList.add(new SearchList(((JSONArray)localObject).getJSONObject(i1)));
        i1 += 1;
      }
      this.z = localArrayList;
    }
    if (paramJSONObject.has("last_active_at")) {}
    try
    {
      this.s = Formats.a.parse(paramJSONObject.getString("last_active_at"));
      if (JSONUtils.a(paramJSONObject, "last_activity")) {
        this.B = new Activity(paramJSONObject.getJSONObject("last_activity"));
      }
      if (JSONUtils.a(paramJSONObject, "nationality")) {
        this.C = paramJSONObject.getString("nationality");
      }
      localObject = paramJSONObject.optJSONArray("buddies");
      if (localObject != null)
      {
        localArrayList = new ArrayList();
        i1 = i2;
        while (i1 < ((JSONArray)localObject).length())
        {
          localArrayList.add(new User(((JSONArray)localObject).getJSONObject(i1)));
          i1 += 1;
        }
        this.i = localArrayList;
      }
    }
    catch (ParseException paramJSONObject)
    {
      throw new JSONException("Invalid format of the 'last active at' date");
    }
    this.l.a(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    this.A.put(paramString, paramJSONObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a(Session paramSession)
  {
    return paramSession.getUser().equals(this);
  }
  
  public String b()
  {
    return this.n;
  }
  
  public boolean b(String paramString)
  {
    return this.A.containsKey(paramString);
  }
  
  List<SearchList> c()
  {
    return this.y;
  }
  
  public JSONObject c(String paramString)
  {
    return (JSONObject)this.A.get(paramString);
  }
  
  public JSONObject d()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id", this.q);
    localJSONObject1.put("login", this.t);
    localJSONObject1.put("device_id", this.n);
    localJSONObject1.put("password", this.u);
    localJSONObject1.put("password_confirmation", this.u);
    localJSONObject1.put("email", this.o);
    if (this.p != Gender.UNKNOWN) {
      localJSONObject1.put("gender", this.p.getJSONString());
    }
    if (this.m != null) {
      localJSONObject1.put("date_of_birth", Formats.b.format(this.m));
    }
    if ((this.d != null) || (this.e != null) || (this.d != null))
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject1.put("avatar", localJSONObject2);
      localJSONObject2.put("hair", this.e);
      localJSONObject2.put("head", this.f);
      localJSONObject2.put("body", this.d);
    }
    if (this.C != null) {
      localJSONObject1.put("nationality", this.C);
    }
    SocialProvider.a(this, localJSONObject1);
    return localJSONObject1;
  }
  
  public void d(String paramString)
  {
    this.q = paramString;
  }
  
  public String e()
  {
    return this.k;
  }
  
  public void e(String paramString)
  {
    this.k = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == null) {
      bool1 = false;
    }
    Object localObject;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      if (!(paramObject instanceof User)) {
        return super.equals(paramObject);
      }
      localObject = (User)paramObject;
      if ((getIdentifier() != null) && (((User)localObject).getIdentifier() != null)) {
        return getIdentifier().equalsIgnoreCase(((User)localObject).getIdentifier());
      }
      paramObject = getLogin();
      localObject = ((User)localObject).getLogin();
      if ((paramObject == null) || (localObject == null)) {
        break;
      }
      bool1 = bool2;
    } while (((String)paramObject).equalsIgnoreCase((String)localObject));
    return false;
  }
  
  public JSONObject f()
  {
    return (JSONObject)this.A.get(TwitterSocialProvider.a);
  }
  
  public JSONObject g()
  {
    return (JSONObject)this.A.get("com.myspace.v1");
  }
  
  @PublishedFor__1_0_0
  public List<User> getBuddyUsers()
  {
    return this.i;
  }
  
  @PublishedFor__1_0_0
  public Map<String, Object> getContext()
  {
    return this.j;
  }
  
  @PublishedFor__1_0_0
  public Date getDateOfBirth()
  {
    return this.m;
  }
  
  @PublishedFor__1_0_0
  public Details getDetail()
  {
    return this.l;
  }
  
  @PublishedFor__1_0_0
  public String getDisplayName()
  {
    if ((this.t != null) && (!this.t.equals(""))) {
      return this.t;
    }
    if (h() != null) {
      try
      {
        String str = String.format("%s %s", new Object[] { h().getString("first_name"), h().getString("last_name") });
        return str;
      }
      catch (JSONException localJSONException)
      {
        return "somebody";
      }
    }
    if ((this.o != null) && (!this.o.equals(""))) {
      return this.o;
    }
    return "somebody";
  }
  
  @PublishedFor__1_0_0
  public String getEmailAddress()
  {
    return this.o;
  }
  
  @PublishedFor__1_0_0
  public String getIdentifier()
  {
    return this.q;
  }
  
  @PublishedFor__1_0_0
  public Date getLastActiveAt()
  {
    return this.s;
  }
  
  @PublishedFor__1_0_0
  public Activity getLastActivity()
  {
    return this.B;
  }
  
  @PublishedFor__1_0_0
  public String getLogin()
  {
    return this.t;
  }
  
  @PublishedFor__1_0_0
  public Integer getSkillValue()
  {
    return this.v;
  }
  
  public JSONObject h()
  {
    return (JSONObject)this.A.get("com.facebook.v1");
  }
  
  public int hashCode()
  {
    if (getLogin() == null) {
      return "".hashCode();
    }
    return getLogin().hashCode();
  }
  
  @PublishedFor__1_0_0
  public boolean isActive()
  {
    return b.active.equals(k());
  }
  
  @PublishedFor__1_0_0
  public boolean isAnonymous()
  {
    return b.anonymous.equals(k());
  }
  
  @PublishedFor__1_0_0
  public boolean isAuthenticated()
  {
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public boolean isChallengable()
  {
    return (isAnonymous()) || (isPassive()) || (isPending()) || (isActive());
  }
  
  @PublishedFor__1_0_0
  public boolean isConnectedToSocialProviderWithIdentifier(String paramString)
  {
    SocialProvider localSocialProvider = SocialProvider.getSocialProviderForIdentifier(paramString);
    if (localSocialProvider == null) {
      throw new IllegalArgumentException("could not find provider for id: '" + paramString + "'");
    }
    return localSocialProvider.isUserConnected(this);
  }
  
  @PublishedFor__1_0_0
  public boolean isPassive()
  {
    return b.passive.equals(k());
  }
  
  @PublishedFor__1_0_0
  public boolean isPending()
  {
    return b.pending.equals(k());
  }
  
  @PublishedFor__1_0_0
  public void setContext(Map<String, Object> paramMap)
  {
    this.j = paramMap;
  }
  
  @PublishedFor__1_0_0
  public void setDateOfBirth(Date paramDate)
  {
    this.m = paramDate;
  }
  
  @PublishedFor__1_0_0
  public void setEmailAddress(String paramString)
  {
    this.o = paramString;
  }
  
  @PublishedFor__1_0_0
  public void setLogin(String paramString)
  {
    this.t = paramString;
  }
  
  @PublishedFor__1_0_0
  public void setPassword(String paramString)
  {
    this.u = paramString;
  }
  
  public String toString()
  {
    if (getLogin() == null)
    {
      if (getIdentifier() == null) {
        return "[empty user]";
      }
      return getIdentifier();
    }
    return getLogin();
  }
  
  public class Details
  {
    private Double b;
    private Integer c;
    private Integer d;
    
    public Details() {}
    
    void a(JSONObject paramJSONObject)
    {
      if (paramJSONObject.has("winning_probability")) {
        this.b = Double.valueOf(paramJSONObject.optDouble("winning_probability"));
      }
      if (paramJSONObject.has("challenges_lost")) {
        this.d = Integer.valueOf(paramJSONObject.optInt("challenges_lost"));
      }
      if (paramJSONObject.has("challenges_won")) {
        this.c = Integer.valueOf(paramJSONObject.optInt("challenges_won"));
      }
    }
    
    @PublishedFor__1_0_0
    public Integer getChallengesLost()
    {
      return this.d;
    }
    
    @PublishedFor__1_0_0
    public Integer getChallengesWon()
    {
      return this.c;
    }
    
    @PublishedFor__1_0_0
    public Double getWinningProbability()
    {
      return this.b;
    }
  }
  
  public static enum Gender
  {
    private String a;
    
    private Gender(String paramString)
    {
      this.a = paramString;
    }
    
    public String getJSONString()
    {
      return this.a;
    }
  }
  
  static class a
  {
    private final String a;
    private final int b;
    private final int c;
    
    public a(JSONObject paramJSONObject)
      throws JSONException
    {
      this.a = paramJSONObject.getString("decoration");
      this.b = paramJSONObject.getInt("threshold");
      this.c = paramJSONObject.getInt("value");
    }
  }
  
  private static enum b
  {
    static
    {
      active = new b("active", 1);
      deleted = new b("deleted", 2);
      passive = new b("passive", 3);
      pending = new b("pending", 4);
      suspended = new b("suspended", 5);
    }
    
    private b() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */