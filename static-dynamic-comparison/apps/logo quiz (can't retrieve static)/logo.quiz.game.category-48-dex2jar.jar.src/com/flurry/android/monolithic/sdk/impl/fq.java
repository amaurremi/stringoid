package com.flurry.android.monolithic.sdk.impl;

import org.json.JSONException;
import org.json.JSONObject;

public class fq
{
  ft a;
  JSONObject b;
  
  public fq(JSONObject paramJSONObject)
  {
    this.b = paramJSONObject;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.b != null) {
        if (this.b.getInt("code") != 200)
        {
          int i = this.b.getInt("code");
          bool1 = bool2;
          if (i != 201) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  public String b()
  {
    try
    {
      if (this.b != null)
      {
        String str = this.b.get("note").toString();
        return str;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "Bad response";
  }
  
  public JSONObject c()
  {
    return this.b;
  }
  
  public int d()
  {
    try
    {
      if (this.b != null)
      {
        int i = this.b.getInt("code");
        return i;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return 400;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */