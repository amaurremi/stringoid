package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import com.scoreloop.client.android.core.utils.Formats;
import com.scoreloop.client.android.core.utils.JSONUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity
{
  private Date a;
  private String b;
  private String c;
  
  public Activity(JSONObject paramJSONObject)
    throws JSONException
  {
    a(paramJSONObject);
  }
  
  private String a()
  {
    return this.c;
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    if (JSONUtils.a(paramJSONObject, "message")) {
      this.b = paramJSONObject.getString("message");
    }
    if (JSONUtils.a(paramJSONObject, "updated_at")) {}
    try
    {
      this.a = Formats.a.parse(paramJSONObject.getString("updated_at"));
      if (JSONUtils.a(paramJSONObject, "target_type"))
      {
        this.c = paramJSONObject.getString("target_type");
        return;
      }
    }
    catch (ParseException paramJSONObject)
    {
      throw new JSONException(paramJSONObject.getMessage());
    }
    this.c = null;
  }
  
  @PublishedFor__1_0_0
  public Date getDate()
  {
    return this.a;
  }
  
  @PublishedFor__1_0_0
  public String getMessage()
  {
    return this.b;
  }
  
  public String toString()
  {
    return getDate() + " ; " + getMessage() + " ; " + a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */