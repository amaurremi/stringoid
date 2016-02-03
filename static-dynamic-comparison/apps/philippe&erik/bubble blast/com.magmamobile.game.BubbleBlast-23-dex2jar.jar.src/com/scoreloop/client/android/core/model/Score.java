package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.utils.Formats;
import com.scoreloop.client.android.core.utils.JSONUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Score
  implements MessageTarget
{
  private String a;
  private String b;
  private Integer c;
  private Double d;
  private Integer e;
  private Double f;
  private Integer g;
  private Date h;
  private User i;
  private Map<String, Object> j;
  
  @PublishedFor__1_0_0
  public Score(Double paramDouble, Map<String, Object> paramMap)
  {
    this.f = paramDouble;
    if (paramMap != null)
    {
      this.j = new HashMap(paramMap);
      this.d = ((Double)this.j.get("SLContextKeyMinorResult"));
      this.c = ((Integer)this.j.get("SLContextKeyLevel"));
      this.e = ((Integer)this.j.get("SLContextKeyMode"));
      this.j.remove("SLContextKeyMinorResult");
      this.j.remove("SLContextKeyLevel");
      this.j.remove("SLContextKeyMode");
    }
  }
  
  public Score(JSONObject paramJSONObject)
    throws JSONException
  {
    a(paramJSONObject);
  }
  
  @PublishedFor__1_0_0
  public static boolean areModesEqual(Score paramScore1, Score paramScore2)
  {
    if ((paramScore1 == null) || (paramScore2 == null)) {
      throw new IllegalArgumentException();
    }
    return areModesEqual(paramScore1.getMode(), paramScore2.getMode());
  }
  
  @PublishedFor__1_0_0
  public static boolean areModesEqual(Integer paramInteger, Score paramScore)
  {
    if (paramScore == null) {
      throw new IllegalArgumentException();
    }
    return areModesEqual(paramInteger, paramScore.getMode());
  }
  
  @PublishedFor__1_0_0
  public static boolean areModesEqual(Integer paramInteger1, Integer paramInteger2)
  {
    if (paramInteger1 == null) {
      throw new IllegalArgumentException();
    }
    return paramInteger1.equals(paramInteger2);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(User paramUser)
  {
    this.i = paramUser;
  }
  
  public void a(Integer paramInteger)
  {
    this.g = paramInteger;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("id")) {
      this.b = paramJSONObject.getString("id");
    }
    if (paramJSONObject.has("device_id")) {
      this.a = paramJSONObject.getString("device_id");
    }
    if (paramJSONObject.has("result")) {
      this.f = Double.valueOf(paramJSONObject.getDouble("result"));
    }
    if (paramJSONObject.has("minor_result")) {
      this.d = Double.valueOf(paramJSONObject.getDouble("minor_result"));
    }
    if (paramJSONObject.has("level")) {
      this.c = Integer.valueOf(paramJSONObject.getInt("level"));
    }
    if (paramJSONObject.has("minor_result")) {
      this.e = Integer.valueOf(paramJSONObject.getInt("mode"));
    }
    String str;
    if (paramJSONObject.has("updated_at")) {
      str = paramJSONObject.getString("updated_at");
    }
    for (;;)
    {
      try
      {
        this.h = Formats.a.parse(str);
        if (paramJSONObject.has("user")) {
          this.i = new User(paramJSONObject.getJSONObject("user"));
        }
        if (paramJSONObject.has("context"))
        {
          if (paramJSONObject.isNull("context"))
          {
            paramJSONObject = null;
            this.j = paramJSONObject;
          }
        }
        else {
          return;
        }
      }
      catch (ParseException paramJSONObject)
      {
        throw new JSONException("Invalid format of the update date");
      }
      paramJSONObject = JSONUtils.a(paramJSONObject.getJSONObject("context"));
    }
  }
  
  public String b()
  {
    return "score";
  }
  
  public JSONObject c()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("device_id", this.a);
    localJSONObject.put("result", this.f);
    localJSONObject.put("level", this.c);
    if (this.i != null) {
      localJSONObject.put("user_id", this.i.getIdentifier());
    }
    if (this.h != null) {
      localJSONObject.put("updated_at", Formats.a.format(this.h));
    }
    localJSONObject.put("mode", this.e);
    localJSONObject.put("minor_result", this.d);
    if (this.j != null) {
      localJSONObject.put("context", JSONUtils.a(this.j));
    }
    return localJSONObject;
  }
  
  @PublishedFor__1_0_0
  public Map<String, Object> getContext()
  {
    return this.j;
  }
  
  @PublishedFor__1_0_0
  public String getIdentifier()
  {
    return this.b;
  }
  
  @PublishedFor__1_0_0
  public Integer getLevel()
  {
    return this.c;
  }
  
  @PublishedFor__1_0_0
  public Double getMinorResult()
  {
    return this.d;
  }
  
  @PublishedFor__1_0_0
  public Integer getMode()
  {
    return this.e;
  }
  
  @PublishedFor__1_0_0
  public Integer getRank()
  {
    return this.g;
  }
  
  @PublishedFor__1_0_0
  public Double getResult()
  {
    return this.f;
  }
  
  @PublishedFor__1_0_0
  public Date getUpdatedAt()
  {
    return this.h;
  }
  
  @PublishedFor__1_0_0
  public User getUser()
  {
    return this.i;
  }
  
  @PublishedFor__1_0_0
  public void setContext(Map<String, Object> paramMap)
  {
    this.j = paramMap;
  }
  
  @PublishedFor__1_0_0
  public void setLevel(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  @PublishedFor__1_0_0
  public void setMinorResult(Double paramDouble)
  {
    this.d = paramDouble;
  }
  
  @PublishedFor__1_0_0
  public void setMode(Integer paramInteger)
  {
    this.e = paramInteger;
  }
  
  @PublishedFor__1_0_0
  public void setResult(Double paramDouble)
  {
    this.f = paramDouble;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Score.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */