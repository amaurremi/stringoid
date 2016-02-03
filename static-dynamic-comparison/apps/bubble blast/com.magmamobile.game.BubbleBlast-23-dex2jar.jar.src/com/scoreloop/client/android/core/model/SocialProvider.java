package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.controller.SocialProviderController;
import com.scoreloop.client.android.core.utils.JSONUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SocialProvider
{
  @PublishedFor__1_0_0
  public static final String FACEBOOK_IDENTIFIER = "com.facebook.v1";
  @PublishedFor__1_0_0
  public static final String MYSPACE_IDENTIFIER = "com.myspace.v1";
  @PublishedFor__1_0_0
  public static final String TWITTER_IDENTIFIER = TwitterSocialProvider.a;
  private static List<Class<? extends SocialProvider>> a = new ArrayList();
  private static List<SocialProvider> b;
  private JSONObject c;
  
  static
  {
    a.add(FacebookSocialProvider.class);
    a.add(MySpaceSocialProvider.class);
    a.add(TwitterSocialProvider.class);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        localArrayList.add(localClass.newInstance());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new IllegalStateException(localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new IllegalStateException(localInstantiationException);
      }
    }
    b = localInstantiationException;
  }
  
  public static void a(User paramUser, JSONObject paramJSONObject)
  {
    Iterator localIterator = getSupportedProviders().iterator();
    while (localIterator.hasNext()) {
      ((SocialProvider)localIterator.next()).d(paramUser, paramJSONObject);
    }
  }
  
  public static boolean a(Class<?> paramClass)
  {
    return a.contains(paramClass);
  }
  
  public static void b(User paramUser, JSONObject paramJSONObject)
  {
    Iterator localIterator = getSupportedProviders().iterator();
    while (localIterator.hasNext()) {
      ((SocialProvider)localIterator.next()).c(paramUser, paramJSONObject);
    }
  }
  
  @PublishedFor__1_0_0
  public static SocialProvider getSocialProviderForIdentifier(String paramString)
  {
    Iterator localIterator = getSupportedProviders().iterator();
    while (localIterator.hasNext())
    {
      SocialProvider localSocialProvider = (SocialProvider)localIterator.next();
      if (localSocialProvider.getIdentifier().equalsIgnoreCase(paramString)) {
        return localSocialProvider;
      }
    }
    return null;
  }
  
  @PublishedFor__1_0_0
  public static List<SocialProvider> getSupportedProviders()
  {
    return b;
  }
  
  public abstract Class<? extends SocialProviderController> a();
  
  public void a(User paramUser, String paramString1, String paramString2, String paramString3)
  {
    if ((paramUser == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      throw new IllegalArgumentException();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("token", paramString1);
      localJSONObject.put("token_secret", paramString2);
      localJSONObject.put("uid", paramString3);
      this.c = localJSONObject;
      paramUser.a(localJSONObject, getIdentifier());
      return;
    }
    catch (JSONException paramUser)
    {
      throw new IllegalStateException(paramUser);
    }
  }
  
  public void c(User paramUser, JSONObject paramJSONObject)
  {
    if ((paramUser == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException();
    }
    if (!JSONUtils.a(paramJSONObject, getName())) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(getName());
      paramUser.a(paramJSONObject, getIdentifier());
      return;
    }
    catch (JSONException paramUser)
    {
      throw new IllegalStateException(paramUser);
    }
  }
  
  protected void d(User paramUser, JSONObject paramJSONObject)
  {
    if (paramUser.b(getIdentifier())) {
      this.c = paramUser.c(getIdentifier());
    }
    if (this.c == null) {
      return;
    }
    try
    {
      paramJSONObject.put(getName(), this.c);
      return;
    }
    catch (JSONException paramUser)
    {
      throw new IllegalStateException(paramUser);
    }
  }
  
  @PublishedFor__1_0_0
  public abstract String getIdentifier();
  
  @PublishedFor__1_0_0
  public final String getName()
  {
    return getIdentifier().split("\\.")[1];
  }
  
  @PublishedFor__1_0_0
  public final Integer getVersion()
  {
    return new Integer(getIdentifier().split("\\.")[2].substring(1));
  }
  
  @PublishedFor__1_0_0
  public abstract boolean isUserConnected(User paramUser);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/SocialProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */