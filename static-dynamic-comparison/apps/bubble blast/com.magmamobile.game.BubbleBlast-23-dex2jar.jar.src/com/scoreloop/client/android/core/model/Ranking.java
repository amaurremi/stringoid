package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import org.json.JSONException;
import org.json.JSONObject;

public class Ranking
{
  private Integer a;
  private Integer b;
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = Integer.valueOf(paramJSONObject.getInt("rank"));
    this.b = Integer.valueOf(paramJSONObject.getInt("total"));
    if (this.a.intValue() == 0) {
      this.a = null;
    }
  }
  
  @PublishedFor__1_0_0
  public Integer getRank()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Ranking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */