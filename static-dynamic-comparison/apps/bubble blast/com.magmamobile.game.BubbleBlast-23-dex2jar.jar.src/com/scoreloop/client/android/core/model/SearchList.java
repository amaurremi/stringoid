package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchList
{
  private final String a;
  private String b;
  
  public SearchList(String paramString)
  {
    this.a = paramString;
  }
  
  SearchList(String paramString1, String paramString2)
  {
    this(paramString1);
    this.b = paramString2;
  }
  
  public SearchList(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.getString("id");
    this.b = paramJSONObject.getString("name");
  }
  
  static SearchList a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    Object localObject = Session.getCurrentSession();
    if (localObject != null)
    {
      localObject = ((Session)localObject).getUser().c();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SearchList localSearchList = (SearchList)((Iterator)localObject).next();
          if (paramString.equalsIgnoreCase(localSearchList.getIdentifier())) {
            return localSearchList;
          }
        }
      }
    }
    return new SearchList(paramString, "");
  }
  
  @PublishedFor__1_0_0
  public static SearchList getBuddiesScoreSearchList()
  {
    return a("701bb990-80d8-11de-8a39-0800200c9a66");
  }
  
  @PublishedFor__1_0_0
  public static SearchList getDefaultScoreSearchList()
  {
    Object localObject = Session.getCurrentSession();
    if (localObject != null)
    {
      localObject = ((Session)localObject).getUser().c();
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        return (SearchList)((List)localObject).get(0);
      }
    }
    return getGlobalScoreSearchList();
  }
  
  @PublishedFor__1_0_0
  public static SearchList getGlobalScoreSearchList()
  {
    return a("428a66d4-e6ca-4ff0-b7ea-f482ba4541a1");
  }
  
  @PublishedFor__1_0_0
  public static SearchList getLocalScoreSearchList()
  {
    return a("#local");
  }
  
  @PublishedFor__1_0_0
  public static SearchList getTwentyFourHourScoreSearchList()
  {
    return a("428a66d4-e6ca-4ff0-b7ea-f482ba4541a2");
  }
  
  @PublishedFor__1_0_0
  public static SearchList getUserCountryLocationScoreSearchList()
  {
    return a("428a66d4-e6ca-4ff0-b7ea-f482ba4541a3");
  }
  
  @PublishedFor__1_0_0
  public static SearchList getUserNationalityScoreSearchList()
  {
    return a("428a66d4-e6ca-4ff0-b7ea-f482ba4541a4");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof SearchList)) {
      return super.equals(paramObject);
    }
    paramObject = (SearchList)paramObject;
    if ((getIdentifier() == null) || (((SearchList)paramObject).getIdentifier() == null)) {
      throw new IllegalStateException();
    }
    return getIdentifier().equalsIgnoreCase(((SearchList)paramObject).getIdentifier());
  }
  
  @PublishedFor__1_0_0
  public String getIdentifier()
  {
    return this.a;
  }
  
  @PublishedFor__1_0_0
  public String getName()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    if (getIdentifier() == null) {
      throw new IllegalStateException();
    }
    return getIdentifier().hashCode();
  }
  
  @PublishedFor__1_0_0
  public void setName(String paramString)
  {
    this.b = paramString;
  }
  
  @PublishedFor__1_0_0
  public String toString()
  {
    return getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/SearchList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */