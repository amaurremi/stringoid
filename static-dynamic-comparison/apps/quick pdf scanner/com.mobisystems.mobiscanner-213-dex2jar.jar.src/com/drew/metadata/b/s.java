package com.drew.metadata.b;

import com.drew.lang.c;
import com.drew.metadata.b;
import java.util.HashMap;

public class s
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(0), "GPS Version ID");
    gb.put(Integer.valueOf(1), "GPS Latitude Ref");
    gb.put(Integer.valueOf(2), "GPS Latitude");
    gb.put(Integer.valueOf(3), "GPS Longitude Ref");
    gb.put(Integer.valueOf(4), "GPS Longitude");
    gb.put(Integer.valueOf(5), "GPS Altitude Ref");
    gb.put(Integer.valueOf(6), "GPS Altitude");
    gb.put(Integer.valueOf(7), "GPS Time-Stamp");
    gb.put(Integer.valueOf(8), "GPS Satellites");
    gb.put(Integer.valueOf(9), "GPS Status");
    gb.put(Integer.valueOf(10), "GPS Measure Mode");
    gb.put(Integer.valueOf(11), "GPS DOP");
    gb.put(Integer.valueOf(12), "GPS Speed Ref");
    gb.put(Integer.valueOf(13), "GPS Speed");
    gb.put(Integer.valueOf(14), "GPS Track Ref");
    gb.put(Integer.valueOf(15), "GPS Track");
    gb.put(Integer.valueOf(16), "GPS Img Direction Ref");
    gb.put(Integer.valueOf(17), "GPS Img Direction");
    gb.put(Integer.valueOf(18), "GPS Map Datum");
    gb.put(Integer.valueOf(19), "GPS Dest Latitude Ref");
    gb.put(Integer.valueOf(20), "GPS Dest Latitude");
    gb.put(Integer.valueOf(21), "GPS Dest Longitude Ref");
    gb.put(Integer.valueOf(22), "GPS Dest Longitude");
    gb.put(Integer.valueOf(23), "GPS Dest Bearing Ref");
    gb.put(Integer.valueOf(24), "GPS Dest Bearing");
    gb.put(Integer.valueOf(25), "GPS Dest Distance Ref");
    gb.put(Integer.valueOf(26), "GPS Dest Distance");
    gb.put(Integer.valueOf(27), "GPS Processing Method");
    gb.put(Integer.valueOf(28), "GPS Area Information");
    gb.put(Integer.valueOf(29), "GPS Date Stamp");
    gb.put(Integer.valueOf(30), "GPS Differential");
  }
  
  public s()
  {
    a(new r(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public c dj()
  {
    Object localObject2 = af(2);
    Object localObject1 = af(4);
    String str2 = getString(1);
    String str1 = getString(3);
    if ((localObject2 == null) || (localObject2.length != 3)) {}
    do
    {
      do
      {
        return null;
      } while ((localObject1 == null) || (localObject1.length != 3) || (str2 == null) || (str1 == null));
      localObject2 = c.a(localObject2[0], localObject2[1], localObject2[2], str2.equalsIgnoreCase("S"));
      localObject1 = c.a(localObject1[0], localObject1[1], localObject1[2], str1.equalsIgnoreCase("W"));
    } while ((localObject2 == null) || (localObject1 == null));
    return new c(((Double)localObject2).doubleValue(), ((Double)localObject1).doubleValue());
  }
  
  public String getName()
  {
    return "GPS";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */