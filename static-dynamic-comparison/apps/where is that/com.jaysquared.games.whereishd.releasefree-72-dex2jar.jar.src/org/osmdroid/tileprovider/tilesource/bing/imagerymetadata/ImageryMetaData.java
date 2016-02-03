package org.osmdroid.tileprovider.tilesource.bing.imagerymetadata;

import org.json.JSONArray;
import org.json.JSONObject;

public class ImageryMetaData
{
  private static final String AUTH_RESULT_CODE = "authenticationResultCode";
  private static final String AUTH_RESULT_CODE_VALID = "ValidCredentials";
  private static final String ESTIMATED_TOTAL = "estimatedTotal";
  private static final String RESOURCE = "resources";
  private static final String RESOURCE_SETS = "resourceSets";
  private static final String STATUS_CODE = "statusCode";
  
  public static ImageryMetaDataResource getInstanceFromJSON(String paramString)
    throws Exception
  {
    if (paramString == null) {
      throw new Exception("JSON to parse is null");
    }
    paramString = new JSONObject(paramString);
    int i = paramString.getInt("statusCode");
    if (i != 200) {
      throw new Exception("Status code = " + i);
    }
    if ("ValidCredentials".compareToIgnoreCase(paramString.getString("authenticationResultCode")) != 0) {
      throw new Exception("authentication result code = " + paramString.getString("authenticationResultCode"));
    }
    paramString = paramString.getJSONArray("resourceSets");
    if ((paramString == null) || (paramString.length() < 1)) {
      throw new Exception("No results set found in json response");
    }
    if (paramString.getJSONObject(0).getInt("estimatedTotal") <= 0) {
      throw new Exception("No resource found in json response");
    }
    return ImageryMetaDataResource.getInstanceFromJSON(paramString.getJSONObject(0).getJSONArray("resources").getJSONObject(0));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/bing/imagerymetadata/ImageryMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */