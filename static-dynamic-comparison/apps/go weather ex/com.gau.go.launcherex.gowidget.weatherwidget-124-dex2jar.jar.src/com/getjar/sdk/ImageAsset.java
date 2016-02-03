package com.getjar.sdk;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageAsset
{
  public static final String ICON_IMAGE_TYPE = "ICON";
  public static final String INTERSTITIAL_IMAGE_TYPE = "INTERSTITIAL";
  private final int _height;
  private final String _type;
  private final String _url;
  private final int _width;
  
  protected ImageAsset(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      try
      {
        throw new IllegalArgumentException("'imageJson' can not be NULL");
      }
      catch (JSONException paramJSONObject)
      {
        throw new GetjarException(paramJSONObject);
      }
    }
    if (!paramJSONObject.has("url")) {
      throw new IllegalStateException("'imageJson' does not contain 'url'");
    }
    if (!paramJSONObject.has("type")) {
      throw new IllegalStateException("'imageJson' does not contain 'type'");
    }
    if (!paramJSONObject.has("width")) {
      throw new IllegalStateException("'imageJson' does not contain 'width'");
    }
    if (!paramJSONObject.has("height")) {
      throw new IllegalStateException("'imageJson' does not contain 'height'");
    }
    this._url = paramJSONObject.getString("url");
    this._type = paramJSONObject.getString("type");
    this._width = paramJSONObject.getInt("width");
    this._height = paramJSONObject.getInt("height");
  }
  
  public int getHeight()
  {
    return this._height;
  }
  
  public String getType()
  {
    return this._type;
  }
  
  public String getUrl()
  {
    return this._url;
  }
  
  public int getWidth()
  {
    return this._width;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/ImageAsset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */