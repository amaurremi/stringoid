package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.utils.Formats;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class Achievement
  implements MessageTarget
{
  private String b;
  private Award c;
  private int d;
  private Date e;
  private String f;
  private boolean g;
  
  static
  {
    if (!Achievement.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public Achievement(Award paramAward, User paramUser)
  {
    this.c = paramAward;
    this.f = paramUser.getIdentifier();
    this.d = paramAward.c();
  }
  
  public Achievement(AwardList paramAwardList, JSONObject paramJSONObject, boolean paramBoolean)
    throws JSONException
  {
    a(paramJSONObject, paramAwardList, paramBoolean);
  }
  
  private void a(JSONObject paramJSONObject, AwardList paramAwardList, boolean paramBoolean)
    throws JSONException
  {
    String str = paramJSONObject.getString("achievable_list_id");
    if ((paramBoolean) && (!str.equals(paramAwardList.a()))) {
      throw new JSONException("invalid achievable_list_id " + str);
    }
    str = paramJSONObject.getString("achievable_identifier");
    this.c = paramAwardList.a(str);
    if (this.c == null) {
      throw new JSONException("invalid achievable_identifier " + str);
    }
    paramAwardList = paramJSONObject.getString("achievable_type");
    if (!paramAwardList.equals(this.c.e())) {
      throw new JSONException("invalid achievable_type " + paramAwardList);
    }
    this.d = paramJSONObject.getInt("achieved_count");
    if (!this.c.b(this.d)) {
      throw new JSONException("invalid achieved_count " + this.d);
    }
    if (paramJSONObject.has("id")) {
      this.b = paramJSONObject.getString("id");
    }
    if (paramJSONObject.has("user_id")) {
      this.f = paramJSONObject.getString("user_id");
    }
    if (paramJSONObject.has("achieved_at")) {}
    try
    {
      paramAwardList = paramJSONObject.getString("achieved_at");
      this.e = Formats.a.parse(paramAwardList);
      if (paramJSONObject.has("needs_sync")) {
        this.g = paramJSONObject.getBoolean("needs_sync");
      }
      return;
    }
    catch (ParseException paramJSONObject)
    {
      throw new JSONException("Invalid format of the update date");
    }
  }
  
  public static String h()
  {
    return "achievement";
  }
  
  public Award a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    boolean bool = f();
    this.d = paramInt;
    if (f() != bool) {
      this.e = new Date();
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a(Achievement paramAchievement)
  {
    boolean bool2 = false;
    int i = paramAchievement.c();
    if (i > c())
    {
      a(i);
      bool2 = true;
    }
    String str = paramAchievement.getIdentifier();
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (str != getIdentifier())
      {
        this.b = str;
        bool1 = true;
      }
    }
    paramAchievement = paramAchievement.d();
    bool2 = bool1;
    if (paramAchievement != null)
    {
      bool2 = bool1;
      if (paramAchievement != d())
      {
        this.e = paramAchievement;
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public String b()
  {
    return h();
  }
  
  public int c()
  {
    return this.d;
  }
  
  public Date d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return a().a(c());
  }
  
  public JSONObject g()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("achievable_list_id", a().d().a());
    localJSONObject.put("achievable_identifier", a().a());
    localJSONObject.put("achievable_type", a().e());
    localJSONObject.put("achieved_count", c());
    localJSONObject.put("id", getIdentifier());
    localJSONObject.put("user_id", e());
    if (d() != null) {
      localJSONObject.put("achieved_at", Formats.a.format(d()));
    }
    if (this.g) {
      localJSONObject.put("needs_sync", true);
    }
    return localJSONObject;
  }
  
  public String getIdentifier()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "Achievement [award=" + a() + ", value=" + c() + ", isAchieved=" + f() + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Achievement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */