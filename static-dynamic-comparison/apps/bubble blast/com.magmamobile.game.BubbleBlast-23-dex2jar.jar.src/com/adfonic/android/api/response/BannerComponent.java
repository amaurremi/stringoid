package com.adfonic.android.api.response;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BannerComponent
{
  private static final String BEACON = "beacon";
  private static final String BEACONS = "beacons";
  private static final String CONTENT = "content";
  private static final String IMAGE = "image";
  private static final String NUM_BEACONS = "numBeacons";
  private static final String TAG_LINE = "tagline";
  private List<Beacon> beacons = new ArrayList();
  private Image image;
  private String tagLine;
  
  public static BannerComponent fromJson(JSONObject paramJSONObject)
    throws JSONException
  {
    BannerComponent localBannerComponent = new BannerComponent();
    Object localObject;
    if (paramJSONObject.has("image"))
    {
      localBannerComponent.image = Image.fromJson(paramJSONObject.getJSONObject("image"));
      localObject = paramJSONObject.optJSONObject("tagline");
      if (localObject != null) {
        localBannerComponent.tagLine = ((JSONObject)localObject).optString("content");
      }
    }
    if (paramJSONObject.has("beacons"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("beacons");
      int j = paramJSONObject.getInt("numBeacons");
      int i = 1;
      while (i < j + 1)
      {
        localObject = localBannerComponent.getBeaconKey(i);
        String str = paramJSONObject.getString((String)localObject);
        Beacon localBeacon = new Beacon();
        localBeacon.name = ((String)localObject);
        localBeacon.url = str;
        localBannerComponent.addBeacon(localBeacon);
        i += 1;
      }
    }
    return localBannerComponent;
  }
  
  private String getBeaconKey(int paramInt)
  {
    return "beacon" + paramInt;
  }
  
  public void addBeacon(Beacon paramBeacon)
  {
    this.beacons.add(paramBeacon);
  }
  
  public List<Beacon> getBeacons()
  {
    return this.beacons;
  }
  
  public ApiResponse.Format getFormat()
  {
    return ApiResponse.Format.BANNER;
  }
  
  public Image getImage()
  {
    return this.image;
  }
  
  public String getTagLine()
  {
    return this.tagLine;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/response/BannerComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */