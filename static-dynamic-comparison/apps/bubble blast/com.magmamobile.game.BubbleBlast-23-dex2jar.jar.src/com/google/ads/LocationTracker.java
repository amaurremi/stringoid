package com.google.ads;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.google.ads.util.Base64;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class LocationTracker
{
  static String PROTO_TEMPLATE = "desc < role: 6 producer: 24 historical_role: 1 historical_producer: 12 timestamp: %d latlng < latitude_e7: %d longitude_e7: %d> radius: %d>";
  private Context mContext;
  
  LocationTracker(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private List<Location> getLastKnownLocations()
  {
    LocationManager localLocationManager = (LocationManager)this.mContext.getSystemService("location");
    Object localObject = localLocationManager.getProviders(false);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Location localLocation = localLocationManager.getLastKnownLocation((String)((Iterator)localObject).next());
      if ((localLocation != null) && (localLocation.hasAccuracy())) {
        localArrayList.add(localLocation);
      }
    }
    return localArrayList;
  }
  
  String encodeProto(String paramString)
  {
    try
    {
      Object localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject).init(1, new SecretKeySpec(new byte[] { 10, 55, -112, -47, -6, 7, 11, 75, -7, -121, 121, 69, 80, -61, 15, 5 }, "AES"));
      byte[] arrayOfByte = ((Cipher)localObject).getIV();
      paramString = ((Cipher)localObject).doFinal(paramString.getBytes());
      localObject = new byte[arrayOfByte.length + paramString.length];
      System.arraycopy(arrayOfByte, 0, localObject, 0, arrayOfByte.length);
      System.arraycopy(paramString, 0, localObject, arrayOfByte.length, paramString.length);
      paramString = Base64.encodeToString((byte[])localObject, 11);
      return paramString;
    }
    catch (GeneralSecurityException paramString) {}
    return null;
  }
  
  String getLocationParam()
  {
    List localList = getLastKnownLocations();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < localList.size())
    {
      String str = encodeProto(protoFromLocation((Location)localList.get(i)));
      if (str != null)
      {
        if (i != 0) {
          break label75;
        }
        localStringBuilder.append("e1+");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        i += 1;
        break;
        label75:
        localStringBuilder.append("+e1+");
      }
    }
    return localStringBuilder.toString();
  }
  
  String protoFromLocation(Location paramLocation)
  {
    return String.format(PROTO_TEMPLATE, new Object[] { Long.valueOf(paramLocation.getTime() * 1000L), Long.valueOf((paramLocation.getLatitude() * 1.0E7D)), Long.valueOf((paramLocation.getLongitude() * 1.0E7D)), Long.valueOf((paramLocation.getAccuracy() * 1000.0F)) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/LocationTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */