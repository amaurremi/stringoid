package com.ideashower.readitlater.e;

import com.ideashower.readitlater.f.f;
import com.ideashower.readitlater.util.e;
import com.pocket.k.a;
import com.pocket.m.a.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;

public class y
  extends c
{
  private int c;
  private long d;
  private String e;
  private long f;
  private String g;
  private String h;
  private String i;
  private String j;
  private JSONArray k;
  private JSONArray l;
  private JSONArray m;
  private boolean n;
  private boolean o;
  private JSONArray p;
  
  public y() {}
  
  public y(int paramInt, long paramLong)
  {
    this.c = paramInt;
    this.d = paramLong;
  }
  
  public static y a(Status paramStatus, boolean paramBoolean)
  {
    y localy = new y();
    localy.a(paramStatus.getId());
    localy.a(paramStatus.getText());
    Object localObject = paramStatus.getCreatedAt();
    if (localObject != null) {
      localy.b(((Date)localObject).getTime());
    }
    localy.b(paramStatus.getUser().getScreenName());
    localy.c(paramStatus.getUser().getName());
    localy.d(paramStatus.getUser().getProfileImageURL());
    localy.b(paramStatus.isFavorited());
    localy.a(paramStatus.isRetweetedByMe());
    localy.c(a(paramStatus.getURLEntities()));
    localy.a(a(paramStatus.getUserMentionEntities()));
    localy.b(a(paramStatus.getHashtagEntities()));
    localy.d(a(paramStatus.getMediaEntities()));
    if (paramBoolean)
    {
      localObject = new com.pocket.k.d(27, 27);
      if (localy.a() <= 0) {
        break label216;
      }
    }
    label216:
    for (paramStatus = com.pocket.m.a.d.a(localy.a());; paramStatus = com.pocket.m.a.d.a())
    {
      f.a(localy.h(), (a)localObject, paramStatus).a(true, k.b).b();
      return localy;
    }
  }
  
  public static JSONArray a(HashtagEntity[] paramArrayOfHashtagEntity)
  {
    int i1 = 0;
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      if ((paramArrayOfHashtagEntity != null) && (i1 < paramArrayOfHashtagEntity.length))
      {
        JSONObject localJSONObject = new JSONObject();
        HashtagEntity localHashtagEntity = paramArrayOfHashtagEntity[i1];
        try
        {
          localJSONObject.put("text", localHashtagEntity.getText());
          localJSONObject.put("position", new int[] { localHashtagEntity.getStart(), localHashtagEntity.getEnd() });
          localJSONArray.put(localJSONObject);
          i1 += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            e.a(localJSONException);
          }
        }
      }
    }
    return localJSONArray;
  }
  
  public static JSONArray a(MediaEntity[] paramArrayOfMediaEntity)
  {
    JSONArray localJSONArray1 = new JSONArray();
    if (paramArrayOfMediaEntity != null)
    {
      int i1 = 0;
      for (;;)
      {
        if (i1 < paramArrayOfMediaEntity.length)
        {
          JSONObject localJSONObject = new JSONObject();
          MediaEntity localMediaEntity = paramArrayOfMediaEntity[i1];
          try
          {
            localJSONObject.put("text", localMediaEntity.getText());
            localJSONObject.put("display_url", localMediaEntity.getDisplayURL());
            localJSONObject.put("expanded_url", localMediaEntity.getExpandedURL());
            localJSONObject.put("media_url", localMediaEntity.getMediaURL());
            JSONArray localJSONArray2 = new JSONArray();
            localJSONArray2.put(localMediaEntity.getStart());
            localJSONArray2.put(localMediaEntity.getEnd());
            localJSONArray1.put(localJSONObject);
            i1 += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              e.a(localJSONException);
            }
          }
        }
      }
    }
    return localJSONArray1;
  }
  
  public static JSONArray a(URLEntity[] paramArrayOfURLEntity)
  {
    JSONArray localJSONArray1 = new JSONArray();
    if (paramArrayOfURLEntity != null)
    {
      int i1 = 0;
      for (;;)
      {
        if (i1 < paramArrayOfURLEntity.length)
        {
          URLEntity localURLEntity = paramArrayOfURLEntity[i1];
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("display_url", localURLEntity.getDisplayURL());
            localJSONObject.put("expended_url", localURLEntity.getExpandedURL());
            JSONArray localJSONArray2 = new JSONArray();
            localJSONArray2.put(localURLEntity.getStart());
            localJSONArray2.put(localURLEntity.getEnd());
            localJSONObject.put("postition", localJSONArray2);
            localJSONObject.put("url", localURLEntity.getURL());
            localJSONObject.put("text", localURLEntity.getText());
            localJSONArray1.put(localJSONObject);
            i1 += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              e.a(localJSONException);
            }
          }
        }
      }
    }
    return localJSONArray1;
  }
  
  public static JSONArray a(UserMentionEntity[] paramArrayOfUserMentionEntity)
  {
    int i1 = 0;
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      if ((paramArrayOfUserMentionEntity != null) && (i1 < paramArrayOfUserMentionEntity.length))
      {
        JSONObject localJSONObject = new JSONObject();
        UserMentionEntity localUserMentionEntity = paramArrayOfUserMentionEntity[i1];
        try
        {
          localJSONObject.put("text", localUserMentionEntity.getScreenName());
          localJSONObject.put("position", new int[] { localUserMentionEntity.getStart(), localUserMentionEntity.getEnd() });
          localJSONArray.put(localJSONObject);
          i1 += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            e.a(localJSONException);
          }
        }
      }
    }
    return localJSONArray;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.k = paramJSONArray;
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public void b(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
  }
  
  public void b(JSONArray paramJSONArray)
  {
    this.l = paramJSONArray;
  }
  
  public void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public void c(String paramString)
  {
    this.h = paramString;
  }
  
  public void c(JSONArray paramJSONArray)
  {
    this.p = paramJSONArray;
  }
  
  public long d()
  {
    return this.f;
  }
  
  public void d(String paramString)
  {
    this.i = paramString;
  }
  
  public void d(JSONArray paramJSONArray)
  {
    this.m = paramJSONArray;
  }
  
  public long e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public String h()
  {
    return this.i;
  }
  
  public JSONArray i()
  {
    return this.k;
  }
  
  public JSONArray j()
  {
    return this.l;
  }
  
  public boolean k()
  {
    return this.o;
  }
  
  public JSONArray l()
  {
    return this.p;
  }
  
  public long m()
  {
    return Long.valueOf(this.d).longValue();
  }
  
  public boolean n()
  {
    return this.f != 0L;
  }
  
  public String o()
  {
    Date localDate = new Date(this.f);
    return new SimpleDateFormat("d MMM yy").format(localDate);
  }
  
  public JSONArray p()
  {
    return this.m;
  }
  
  public String toString()
  {
    return "TweetItem [tweetId=" + this.d + ", tweetText=" + this.e + ", tweetTime=" + this.f + ", tweetUserHandle=" + this.g + ", tweetUserName=" + this.h + ", tweetUserImageUrl=" + this.i + ", tweetErrorDownloading=" + this.j + ", tweetUrlEntities=" + this.p + ", tweetRetweeted=" + this.n + ", tweetFavorited=" + this.o + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */