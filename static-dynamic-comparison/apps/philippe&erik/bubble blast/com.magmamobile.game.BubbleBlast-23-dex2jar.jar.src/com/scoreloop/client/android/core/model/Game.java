package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import org.json.JSONException;
import org.json.JSONObject;

public class Game
  implements MessageTarget
{
  @PublishedFor__1_0_0
  public static final String CONTEXT_KEY_LEVEL = "SLContextKeyLevel";
  @PublishedFor__1_0_0
  public static final String CONTEXT_KEY_MINOR_RESULT = "SLContextKeyMinorResult";
  @PublishedFor__1_0_0
  public static final String CONTEXT_KEY_MODE = "SLContextKeyMode";
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private Integer f;
  private Integer g;
  private Integer h;
  private Integer i;
  private String j;
  private final String k;
  private String l;
  private String m;
  
  Game(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException("id and secret must be passed");
    }
    this.d = paramString1;
    this.k = paramString2;
  }
  
  public Game(JSONObject paramJSONObject)
    throws JSONException
  {
    this(null, null);
    a(paramJSONObject);
  }
  
  public String a()
  {
    return this.k;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("id")) {
      this.d = paramJSONObject.getString("id");
    }
    if (paramJSONObject.has("name")) {
      this.j = paramJSONObject.getString("name");
    }
    if (paramJSONObject.has("min_level")) {
      this.h = Integer.valueOf(paramJSONObject.getInt("min_level"));
    }
    if (paramJSONObject.has("max_level")) {
      this.f = Integer.valueOf(paramJSONObject.getInt("max_level"));
    }
    if (paramJSONObject.has("mode_count"))
    {
      this.i = Integer.valueOf(0);
      this.g = Integer.valueOf(paramJSONObject.getInt("mode_count") - 1);
    }
    if (paramJSONObject.has("characteristic")) {
      this.a = paramJSONObject.getString("characteristic");
    }
    if (paramJSONObject.has("description")) {
      this.b = paramJSONObject.getString("description");
    }
    if (paramJSONObject.has("version")) {
      this.m = paramJSONObject.getString("version");
    }
    if (paramJSONObject.has("image_url")) {
      this.e = paramJSONObject.getString("image_url");
    }
    if (paramJSONObject.has("download_url")) {
      this.c = paramJSONObject.getString("download_url");
    }
    if (paramJSONObject.has("state")) {
      this.l = paramJSONObject.getString("state");
    }
  }
  
  public String b()
  {
    return "game";
  }
  
  @PublishedFor__1_0_0
  public String getIdentifier()
  {
    return this.d;
  }
  
  @PublishedFor__1_0_0
  public Integer getLevelCount()
  {
    if (!hasLevels()) {
      return Integer.valueOf(1);
    }
    return Integer.valueOf(getMaxLevel().intValue() - getMinLevel().intValue());
  }
  
  @PublishedFor__1_0_0
  public Integer getMaxLevel()
  {
    return this.f;
  }
  
  @PublishedFor__1_0_0
  public Integer getMaxMode()
  {
    return this.g;
  }
  
  @PublishedFor__1_0_0
  public Integer getMinLevel()
  {
    return this.h;
  }
  
  @PublishedFor__1_0_0
  public Integer getMinMode()
  {
    return this.i;
  }
  
  @PublishedFor__1_0_0
  public Integer getModeCount()
  {
    if (!hasModes()) {
      return Integer.valueOf(1);
    }
    return Integer.valueOf(getMaxMode().intValue() - getMinMode().intValue());
  }
  
  @PublishedFor__1_0_0
  public String getName()
  {
    return this.j;
  }
  
  @PublishedFor__1_0_0
  public String getVersion()
  {
    return this.m;
  }
  
  @PublishedFor__1_0_0
  public boolean hasLevels()
  {
    return (getMinLevel() != null) && (getMaxLevel() != null);
  }
  
  @PublishedFor__1_0_0
  public boolean hasModes()
  {
    return (getMinMode() != null) && (getMaxMode() != null);
  }
  
  @PublishedFor__1_0_0
  public void setMaxLevel(Integer paramInteger)
  {
    this.f = paramInteger;
  }
  
  @PublishedFor__1_0_0
  public void setMaxMode(Integer paramInteger)
  {
    this.g = paramInteger;
  }
  
  @PublishedFor__1_0_0
  public void setMinLevel(Integer paramInteger)
  {
    this.h = paramInteger;
  }
  
  @PublishedFor__1_0_0
  public void setMinMode(Integer paramInteger)
  {
    this.i = paramInteger;
  }
  
  @PublishedFor__1_0_0
  public void setName(String paramString)
  {
    this.j = paramString;
  }
  
  @PublishedFor__1_0_0
  public void setVersion(String paramString)
  {
    this.m = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Game.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */