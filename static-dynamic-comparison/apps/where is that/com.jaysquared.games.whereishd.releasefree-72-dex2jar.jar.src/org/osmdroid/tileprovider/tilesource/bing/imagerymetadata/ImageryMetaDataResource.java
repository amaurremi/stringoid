package org.osmdroid.tileprovider.tilesource.bing.imagerymetadata;

import org.json.JSONArray;
import org.json.JSONObject;

public class ImageryMetaDataResource
{
  private static final String IMAGE_HEIGHT = "imageHeight";
  private static final String IMAGE_URL = "imageUrl";
  private static final String IMAGE_URL_SUBDOMAINS = "imageUrlSubdomains";
  private static final String IMAGE_WIDTH = "imageWidth";
  private static final String ZOOM_MAX = "ZoomMax";
  private static final String ZOOM_MIN = "ZoomMin";
  public int m_imageHeight = 256;
  public String m_imageUrl;
  public String[] m_imageUrlSubdomains;
  public int m_imageWidth = 256;
  public boolean m_isInitialised = false;
  private int m_subdomainsCounter = 0;
  public int m_zoomMax = 22;
  public int m_zoomMin = 1;
  
  public static ImageryMetaDataResource getDefaultInstance()
  {
    return new ImageryMetaDataResource();
  }
  
  public static ImageryMetaDataResource getInstanceFromJSON(JSONObject paramJSONObject)
    throws Exception
  {
    ImageryMetaDataResource localImageryMetaDataResource = new ImageryMetaDataResource();
    if (paramJSONObject == null) {
      throw new Exception("JSON to parse is null");
    }
    if (paramJSONObject.has("imageHeight")) {
      localImageryMetaDataResource.m_imageHeight = paramJSONObject.getInt("imageHeight");
    }
    if (paramJSONObject.has("imageWidth")) {
      localImageryMetaDataResource.m_imageWidth = paramJSONObject.getInt("imageWidth");
    }
    if (paramJSONObject.has("ZoomMin")) {
      localImageryMetaDataResource.m_zoomMin = paramJSONObject.getInt("ZoomMin");
    }
    if (paramJSONObject.has("ZoomMax")) {
      localImageryMetaDataResource.m_zoomMax = paramJSONObject.getInt("ZoomMax");
    }
    localImageryMetaDataResource.m_imageUrl = paramJSONObject.getString("imageUrl");
    if ((localImageryMetaDataResource.m_imageUrl != null) && (localImageryMetaDataResource.m_imageUrl.matches(".*?\\{.*?\\}.*?"))) {
      localImageryMetaDataResource.m_imageUrl = localImageryMetaDataResource.m_imageUrl.replaceAll("\\{.*?\\}", "%s");
    }
    paramJSONObject = paramJSONObject.getJSONArray("imageUrlSubdomains");
    int i;
    if ((paramJSONObject != null) && (paramJSONObject.length() >= 1))
    {
      localImageryMetaDataResource.m_imageUrlSubdomains = new String[paramJSONObject.length()];
      i = 0;
    }
    for (;;)
    {
      if (i >= paramJSONObject.length())
      {
        localImageryMetaDataResource.m_isInitialised = true;
        return localImageryMetaDataResource;
      }
      localImageryMetaDataResource.m_imageUrlSubdomains[i] = paramJSONObject.getString(i);
      i += 1;
    }
  }
  
  public String getSubDomain()
  {
    for (;;)
    {
      try
      {
        if (this.m_imageUrlSubdomains != null)
        {
          int i = this.m_imageUrlSubdomains.length;
          if (i > 0) {}
        }
        else
        {
          str = null;
          return str;
        }
        String str = this.m_imageUrlSubdomains[this.m_subdomainsCounter];
        if (this.m_subdomainsCounter < this.m_imageUrlSubdomains.length - 1) {
          this.m_subdomainsCounter += 1;
        } else {
          this.m_subdomainsCounter = 0;
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/bing/imagerymetadata/ImageryMetaDataResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */