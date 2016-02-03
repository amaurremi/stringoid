package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

public final class Query
  implements Serializable
{
  public static final String KILOMETERS = "km";
  public static final String MILES = "mi";
  public static final String MIXED = "mixed";
  public static final String POPULAR = "popular";
  public static final String RECENT = "recent";
  private static HttpParameter WITH_TWITTER_USER_ID = new HttpParameter("with_twitter_user_id", "true");
  private static final long serialVersionUID = -8108425822233599808L;
  private int count = -1;
  private String geocode = null;
  private String lang = null;
  private String locale = null;
  private long maxId = -1L;
  private String nextPageQuery = null;
  private String query = null;
  private String resultType = null;
  private String since = null;
  private long sinceId = -1L;
  private String until = null;
  
  public Query() {}
  
  public Query(String paramString)
  {
    this.query = paramString;
  }
  
  private void appendParameter(String paramString, long paramLong, List paramList)
  {
    if (0L <= paramLong) {
      paramList.add(new HttpParameter(paramString, String.valueOf(paramLong)));
    }
  }
  
  private void appendParameter(String paramString1, String paramString2, List paramList)
  {
    if (paramString2 != null) {
      paramList.add(new HttpParameter(paramString1, paramString2));
    }
  }
  
  private static Query createWithNextPageQuery(String paramString)
  {
    Query localQuery = new Query();
    localQuery.nextPageQuery = paramString;
    return localQuery;
  }
  
  HttpParameter[] asHttpParameterArray()
  {
    ArrayList localArrayList = new ArrayList(12);
    appendParameter("q", this.query, localArrayList);
    appendParameter("lang", this.lang, localArrayList);
    appendParameter("locale", this.locale, localArrayList);
    appendParameter("max_id", this.maxId, localArrayList);
    appendParameter("count", this.count, localArrayList);
    appendParameter("since", this.since, localArrayList);
    appendParameter("since_id", this.sinceId, localArrayList);
    appendParameter("geocode", this.geocode, localArrayList);
    appendParameter("until", this.until, localArrayList);
    appendParameter("result_type", this.resultType, localArrayList);
    localArrayList.add(WITH_TWITTER_USER_ID);
    return (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()]);
  }
  
  public Query count(int paramInt)
  {
    setCount(paramInt);
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Query)paramObject;
      if (this.maxId != ((Query)paramObject).maxId) {
        return false;
      }
      if (this.count != ((Query)paramObject).count) {
        return false;
      }
      if (this.sinceId != ((Query)paramObject).sinceId) {
        return false;
      }
      if (this.geocode != null)
      {
        if (this.geocode.equals(((Query)paramObject).geocode)) {}
      }
      else {
        while (((Query)paramObject).geocode != null) {
          return false;
        }
      }
      if (this.lang != null)
      {
        if (this.lang.equals(((Query)paramObject).lang)) {}
      }
      else {
        while (((Query)paramObject).lang != null) {
          return false;
        }
      }
      if (this.locale != null)
      {
        if (this.locale.equals(((Query)paramObject).locale)) {}
      }
      else {
        while (((Query)paramObject).locale != null) {
          return false;
        }
      }
      if (this.nextPageQuery != null)
      {
        if (this.nextPageQuery.equals(((Query)paramObject).nextPageQuery)) {}
      }
      else {
        while (((Query)paramObject).nextPageQuery != null) {
          return false;
        }
      }
      if (this.query != null)
      {
        if (this.query.equals(((Query)paramObject).query)) {}
      }
      else {
        while (((Query)paramObject).query != null) {
          return false;
        }
      }
      if (this.resultType != null)
      {
        if (this.resultType.equals(((Query)paramObject).resultType)) {}
      }
      else {
        while (((Query)paramObject).resultType != null) {
          return false;
        }
      }
      if (this.since != null)
      {
        if (this.since.equals(((Query)paramObject).since)) {}
      }
      else {
        while (((Query)paramObject).since != null) {
          return false;
        }
      }
      if (this.until == null) {
        break;
      }
    } while (this.until.equals(((Query)paramObject).until));
    for (;;)
    {
      return false;
      if (((Query)paramObject).until == null) {
        break;
      }
    }
  }
  
  public Query geoCode(GeoLocation paramGeoLocation, double paramDouble, String paramString)
  {
    setGeoCode(paramGeoLocation, paramDouble, paramString);
    return this;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getGeocode()
  {
    return this.geocode;
  }
  
  public String getLang()
  {
    return this.lang;
  }
  
  public String getLocale()
  {
    return this.locale;
  }
  
  public long getMaxId()
  {
    return this.maxId;
  }
  
  public String getQuery()
  {
    return this.query;
  }
  
  public String getResultType()
  {
    return this.resultType;
  }
  
  public String getSince()
  {
    return this.since;
  }
  
  public long getSinceId()
  {
    return this.sinceId;
  }
  
  public String getUntil()
  {
    return this.until;
  }
  
  public int hashCode()
  {
    int i3 = 0;
    int i;
    int j;
    label33:
    int k;
    label48:
    int i4;
    int i5;
    int m;
    label85:
    int i6;
    int n;
    label116:
    int i1;
    if (this.query != null)
    {
      i = this.query.hashCode();
      if (this.lang == null) {
        break label229;
      }
      j = this.lang.hashCode();
      if (this.locale == null) {
        break label234;
      }
      k = this.locale.hashCode();
      i4 = (int)(this.maxId ^ this.maxId >>> 32);
      i5 = this.count;
      if (this.since == null) {
        break label239;
      }
      m = this.since.hashCode();
      i6 = (int)(this.sinceId ^ this.sinceId >>> 32);
      if (this.geocode == null) {
        break label245;
      }
      n = this.geocode.hashCode();
      if (this.until == null) {
        break label251;
      }
      i1 = this.until.hashCode();
      label132:
      if (this.resultType == null) {
        break label257;
      }
    }
    label229:
    label234:
    label239:
    label245:
    label251:
    label257:
    for (int i2 = this.resultType.hashCode();; i2 = 0)
    {
      if (this.nextPageQuery != null) {
        i3 = this.nextPageQuery.hashCode();
      }
      return (i2 + (i1 + (n + ((m + (((k + (j + i * 31) * 31) * 31 + i4) * 31 + i5) * 31) * 31 + i6) * 31) * 31) * 31) * 31 + i3;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label48;
      m = 0;
      break label85;
      n = 0;
      break label116;
      i1 = 0;
      break label132;
    }
  }
  
  public Query lang(String paramString)
  {
    setLang(paramString);
    return this;
  }
  
  public Query locale(String paramString)
  {
    setLocale(paramString);
    return this;
  }
  
  public Query maxId(long paramLong)
  {
    setMaxId(paramLong);
    return this;
  }
  
  String nextPage()
  {
    return this.nextPageQuery;
  }
  
  public Query query(String paramString)
  {
    setQuery(paramString);
    return this;
  }
  
  public Query resultType(String paramString)
  {
    setResultType(paramString);
    return this;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setGeoCode(GeoLocation paramGeoLocation, double paramDouble, String paramString)
  {
    this.geocode = (paramGeoLocation.getLatitude() + "," + paramGeoLocation.getLongitude() + "," + paramDouble + paramString);
  }
  
  public void setLang(String paramString)
  {
    this.lang = paramString;
  }
  
  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }
  
  public void setMaxId(long paramLong)
  {
    this.maxId = paramLong;
  }
  
  public void setQuery(String paramString)
  {
    this.query = paramString;
  }
  
  public void setResultType(String paramString)
  {
    this.resultType = paramString;
  }
  
  public void setSince(String paramString)
  {
    this.since = paramString;
  }
  
  public void setSinceId(long paramLong)
  {
    this.sinceId = paramLong;
  }
  
  public void setUntil(String paramString)
  {
    this.until = paramString;
  }
  
  public Query since(String paramString)
  {
    setSince(paramString);
    return this;
  }
  
  public Query sinceId(long paramLong)
  {
    setSinceId(paramLong);
    return this;
  }
  
  public String toString()
  {
    return "Query{query='" + this.query + '\'' + ", lang='" + this.lang + '\'' + ", locale='" + this.locale + '\'' + ", maxId=" + this.maxId + ", count=" + this.count + ", since='" + this.since + '\'' + ", sinceId=" + this.sinceId + ", geocode='" + this.geocode + '\'' + ", until='" + this.until + '\'' + ", resultType='" + this.resultType + '\'' + ", nextPageQuery='" + this.nextPageQuery + '\'' + '}';
  }
  
  public Query until(String paramString)
  {
    setUntil(paramString);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */