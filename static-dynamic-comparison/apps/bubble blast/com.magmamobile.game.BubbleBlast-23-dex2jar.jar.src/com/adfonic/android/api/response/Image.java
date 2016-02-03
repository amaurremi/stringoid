package com.adfonic.android.api.response;

import org.json.JSONException;
import org.json.JSONObject;

public class Image
{
  private static final String HEIGHT = "height";
  private static final String URL = "url";
  private static final String WIDTH = "width";
  public int height;
  public String url;
  public int width;
  
  public static Image fromJson(JSONObject paramJSONObject)
    throws JSONException
  {
    Image localImage = new Image();
    localImage.url = paramJSONObject.getString("url");
    localImage.width = Integer.parseInt(paramJSONObject.getString("width"));
    localImage.height = Integer.parseInt(paramJSONObject.getString("height"));
    return localImage;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/response/Image.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */