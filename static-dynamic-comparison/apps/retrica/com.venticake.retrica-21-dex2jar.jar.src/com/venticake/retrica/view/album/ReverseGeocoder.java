package com.venticake.retrica.view.album;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public final class ReverseGeocoder
  extends Thread
{
  private static Criteria LOCATION_CRITERIA;
  private static final int MAX_COUNTRY_NAME_LENGTH = 8;
  private static final int MAX_LOCALITY_MILE_RANGE = 20;
  private static final String TAG = "ReverseGeocoder";
  private static Address sCurrentAddress;
  private static final Deque<MediaSet> sQueue = new Deque();
  private final Context mContext;
  private Geocoder mGeocoder;
  
  static
  {
    LOCATION_CRITERIA = new Criteria();
    LOCATION_CRITERIA.setAccuracy(2);
    LOCATION_CRITERIA.setPowerRequirement(0);
    LOCATION_CRITERIA.setBearingRequired(false);
    LOCATION_CRITERIA.setSpeedRequired(false);
    LOCATION_CRITERIA.setAltitudeRequired(false);
  }
  
  public ReverseGeocoder(Context paramContext)
  {
    super("ReverseGeocoder");
    this.mContext = paramContext;
    start();
  }
  
  private String checkNull(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.equals("null"));
    return "";
  }
  
  private String getLocalityAdminForAddress(Address paramAddress, boolean paramBoolean)
  {
    if (paramAddress == null) {
      paramAddress = "";
    }
    String str1;
    String str2;
    do
    {
      do
      {
        return paramAddress;
        str1 = paramAddress.getLocality();
        if ((str1 == null) || ("null".equals(str1))) {
          break;
        }
        str2 = paramAddress.getAdminArea();
        paramAddress = str1;
      } while (str2 == null);
      paramAddress = str1;
    } while (str2.length() <= 0);
    return str1 + ", " + str2;
    return null;
  }
  
  private Address lookupAddress(double paramDouble1, double paramDouble2)
  {
    long l = (((paramDouble1 + 90.0D) * 2.0D * 90.0D + (180.0D + paramDouble2)) * 6378137.0D);
    try
    {
      Object localObject = this.mGeocoder.getFromLocation(paramDouble1, paramDouble2, 1);
      if (!((List)localObject).isEmpty())
      {
        localObject = (Address)((List)localObject).get(0);
        DataOutputStream localDataOutputStream = new DataOutputStream(new BufferedOutputStream(new ByteArrayOutputStream(), 256));
        Locale localLocale = ((Address)localObject).getLocale();
        Utils.writeUTF(localDataOutputStream, localLocale.getLanguage());
        Utils.writeUTF(localDataOutputStream, localLocale.getCountry());
        Utils.writeUTF(localDataOutputStream, localLocale.getVariant());
        Utils.writeUTF(localDataOutputStream, ((Address)localObject).getThoroughfare());
        int j = ((Address)localObject).getMaxAddressLineIndex();
        localDataOutputStream.writeInt(j);
        int i = 0;
        for (;;)
        {
          if (i >= j)
          {
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getFeatureName());
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getLocality());
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getAdminArea());
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getSubAdminArea());
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getCountryName());
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getCountryCode());
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getPostalCode());
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getPhone());
            Utils.writeUTF(localDataOutputStream, ((Address)localObject).getUrl());
            localDataOutputStream.flush();
            localDataOutputStream.close();
            return (Address)localObject;
          }
          Utils.writeUTF(localDataOutputStream, ((Address)localObject).getAddressLine(i));
          i += 1;
        }
      }
      return null;
    }
    catch (IOException localIOException)
    {
      return null;
    }
  }
  
  private boolean process(MediaSet paramMediaSet)
  {
    if (!paramMediaSet.mLatLongDetermined)
    {
      paramMediaSet.mReverseGeocodedLocationComputed = true;
      return false;
    }
    paramMediaSet.mReverseGeocodedLocation = computeMostGranularCommonLocation(paramMediaSet);
    paramMediaSet.mReverseGeocodedLocationComputed = true;
    return true;
  }
  
  private String valueIfEqual(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.equalsIgnoreCase(paramString2))) {
      return paramString1;
    }
    return null;
  }
  
  protected String computeMostGranularCommonLocation(MediaSet paramMediaSet)
  {
    double d1 = paramMediaSet.mMinLatLatitude;
    double d2 = paramMediaSet.mMinLatLongitude;
    double d3 = paramMediaSet.mMaxLatLatitude;
    double d4 = paramMediaSet.mMaxLatLongitude;
    if (Math.abs(paramMediaSet.mMaxLatLatitude - paramMediaSet.mMinLatLatitude) < Math.abs(paramMediaSet.mMaxLonLongitude - paramMediaSet.mMinLonLongitude))
    {
      d1 = paramMediaSet.mMinLonLatitude;
      d2 = paramMediaSet.mMinLonLongitude;
      d3 = paramMediaSet.mMaxLonLatitude;
      d4 = paramMediaSet.mMaxLonLongitude;
    }
    Object localObject1 = lookupAddress(d1, d2);
    paramMediaSet = lookupAddress(d3, d4);
    Object localObject4 = localObject1;
    if (localObject1 == null) {
      localObject4 = paramMediaSet;
    }
    if (paramMediaSet == null) {}
    for (Object localObject11 = localObject4;; localObject11 = paramMediaSet)
    {
      if ((localObject4 == null) || (localObject11 == null))
      {
        paramMediaSet = null;
        return paramMediaSet;
      }
      Object localObject2 = (LocationManager)this.mContext.getSystemService("location");
      Object localObject3 = ((LocationManager)localObject2).getAllProviders();
      paramMediaSet = null;
      int i = 0;
      label168:
      Object localObject5;
      Object localObject12;
      Object localObject13;
      Object localObject10;
      label224:
      Object localObject8;
      Object localObject6;
      if (i >= ((List)localObject3).size())
      {
        localObject1 = paramMediaSet;
        localObject2 = "";
        localObject3 = "";
        localObject5 = Locale.getDefault().getCountry();
        localObject12 = localObject5;
        localObject13 = localObject3;
        localObject10 = localObject2;
        if (localObject1 != null)
        {
          paramMediaSet = lookupAddress(((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
          if (paramMediaSet != null) {
            break label567;
          }
          paramMediaSet = sCurrentAddress;
          localObject12 = localObject5;
          localObject13 = localObject3;
          localObject10 = localObject2;
          if (paramMediaSet != null)
          {
            localObject12 = localObject5;
            localObject13 = localObject3;
            localObject10 = localObject2;
            if (paramMediaSet.getCountryCode() != null)
            {
              localObject10 = checkNull(paramMediaSet.getLocality());
              localObject12 = checkNull(paramMediaSet.getCountryCode());
              localObject13 = checkNull(paramMediaSet.getAdminArea());
            }
          }
        }
        localObject2 = checkNull(((Address)localObject4).getLocality());
        paramMediaSet = checkNull(((Address)localObject11).getLocality());
        localObject8 = checkNull(((Address)localObject4).getAdminArea());
        localObject1 = checkNull(((Address)localObject11).getAdminArea());
        localObject5 = checkNull(((Address)localObject4).getCountryCode());
        localObject6 = checkNull(((Address)localObject11).getCountryCode());
        if ((!((String)localObject10).equals(localObject2)) || (!((String)localObject10).equals(paramMediaSet))) {
          break label768;
        }
        if (!((String)localObject10).equals(localObject2)) {
          break label574;
        }
        if (paramMediaSet.length() != 0) {
          break label1316;
        }
        paramMediaSet = (MediaSet)localObject1;
        if (!((String)localObject12).equals(localObject6)) {
          paramMediaSet = localObject1 + " " + (String)localObject6;
        }
      }
      label567:
      label574:
      label688:
      label768:
      label1313:
      label1316:
      for (;;)
      {
        localObject3 = localObject5;
        Object localObject7 = localObject2;
        localObject1 = localObject8;
        Object localObject9 = localObject2;
        localObject6 = localObject5;
        localObject5 = localObject1;
        for (;;)
        {
          localObject1 = valueIfEqual(((Address)localObject4).getAddressLine(0), ((Address)localObject11).getAddressLine(0));
          if ((localObject1 == null) || ("null".equals(localObject1))) {
            break label688;
          }
          if (((String)localObject10).equals(paramMediaSet)) {
            break label1313;
          }
          return localObject1 + " - " + paramMediaSet;
          paramMediaSet = (String)((List)localObject3).get(i);
          if (paramMediaSet != null) {}
          for (paramMediaSet = ((LocationManager)localObject2).getLastKnownLocation(paramMediaSet);; paramMediaSet = null)
          {
            localObject1 = paramMediaSet;
            if (paramMediaSet != null) {
              break label168;
            }
            i += 1;
            break;
          }
          sCurrentAddress = paramMediaSet;
          break label224;
          localObject3 = localObject2;
          if (((String)localObject2).length() == 0)
          {
            localObject2 = localObject8 + " " + (String)localObject5;
            localObject3 = localObject2;
            if (!((String)localObject12).equals(localObject5)) {
              localObject3 = localObject2 + " " + (String)localObject5;
            }
          }
          localObject2 = localObject6;
          localObject8 = localObject1;
          localObject9 = paramMediaSet;
          localObject7 = paramMediaSet;
          paramMediaSet = (MediaSet)localObject3;
          localObject3 = localObject6;
          localObject5 = localObject1;
          localObject6 = localObject2;
        }
        String str = valueIfEqual(((Address)localObject4).getThoroughfare(), ((Address)localObject11).getThoroughfare());
        localObject2 = localObject3;
        Object localObject15 = localObject5;
        localObject1 = localObject6;
        paramMediaSet = (MediaSet)localObject7;
        Object localObject14 = localObject8;
        localObject10 = localObject9;
        if (str != null)
        {
          localObject2 = localObject3;
          localObject15 = localObject5;
          localObject1 = localObject6;
          paramMediaSet = (MediaSet)localObject7;
          localObject14 = localObject8;
          localObject10 = localObject9;
          if (!"null".equals(str))
          {
            return str;
            localObject10 = localObject2;
            localObject15 = localObject1;
            localObject2 = localObject6;
            localObject14 = localObject8;
            localObject1 = localObject5;
          }
        }
        localObject3 = valueIfEqual((String)localObject10, paramMediaSet);
        if ((localObject3 != null) && (!"".equals(localObject3)))
        {
          if ((localObject14 != null) && (((String)localObject14).length() > 0))
          {
            if (!((String)localObject1).equals(localObject12)) {
              return localObject3 + ", " + (String)localObject14 + " " + (String)localObject1;
            }
            return localObject3 + ", " + (String)localObject14;
          }
        }
        else
        {
          if ((((String)localObject13).equals(localObject14)) && (((String)localObject13).equals(localObject15)))
          {
            localObject3 = localObject10;
            if ("".equals(localObject10)) {
              localObject3 = paramMediaSet;
            }
            localObject5 = paramMediaSet;
            if ("".equals(paramMediaSet)) {
              localObject5 = localObject3;
            }
            if (!"".equals(localObject3))
            {
              if (((String)localObject3).equals(localObject5)) {
                return localObject3 + ", " + (String)localObject13;
              }
              return localObject3 + " - " + (String)localObject5;
            }
          }
          if ((int)LocationMediaFilter.toMile(LocationMediaFilter.distanceBetween(d1, d2, d3, d4)) < 20)
          {
            localObject3 = getLocalityAdminForAddress((Address)localObject4, true);
            paramMediaSet = (MediaSet)localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject3 = getLocalityAdminForAddress((Address)localObject11, true);
            paramMediaSet = (MediaSet)localObject3;
            if (localObject3 != null) {
              break;
            }
          }
          localObject3 = valueIfEqual((String)localObject14, (String)localObject15);
          if ((localObject3 != null) && (!"".equals(localObject3)))
          {
            paramMediaSet = (MediaSet)localObject3;
            if (((String)localObject1).equals(localObject12)) {
              break;
            }
            paramMediaSet = (MediaSet)localObject3;
            if (localObject1 == null) {
              break;
            }
            paramMediaSet = (MediaSet)localObject3;
            if (((String)localObject1).length() <= 0) {
              break;
            }
            return localObject3 + " " + (String)localObject1;
          }
          localObject3 = valueIfEqual((String)localObject1, (String)localObject2);
          if (localObject3 != null)
          {
            paramMediaSet = (MediaSet)localObject3;
            if (!"".equals(localObject3)) {
              break;
            }
          }
          localObject3 = ((Address)localObject4).getCountryName();
          localObject4 = ((Address)localObject11).getCountryName();
          paramMediaSet = (MediaSet)localObject3;
          if (localObject3 == null) {
            paramMediaSet = (MediaSet)localObject1;
          }
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = localObject2;
          }
          if ((paramMediaSet == null) || (localObject3 == null)) {
            return null;
          }
          if ((paramMediaSet.length() > 8) || (((String)localObject3).length() > 8)) {
            return localObject1 + " - " + (String)localObject2;
          }
          return paramMediaSet + " - " + (String)localObject3;
        }
        return (String)localObject3;
        return (String)localObject1;
      }
    }
  }
  
  public void enqueue(MediaSet paramMediaSet)
  {
    synchronized (sQueue)
    {
      ???.addFirst(paramMediaSet);
      ???.notify();
      return;
    }
  }
  
  protected String getReverseGeocodedLocation(double paramDouble1, double paramDouble2, int paramInt)
  {
    int i = 1;
    Object localObject1 = null;
    Address localAddress = lookupAddress(paramDouble1, paramDouble2);
    if (localAddress != null)
    {
      localObject1 = localAddress.getAddressLine(0);
      if ((localObject1 == null) || ("null".equals(localObject1))) {
        break label52;
      }
    }
    for (;;)
    {
      if (i == paramInt)
      {
        return (String)localObject1;
        label52:
        localObject1 = localAddress.getThoroughfare();
        if ((localObject1 != null) && (!"null".equals(localObject1))) {
          continue;
        }
        localObject1 = localAddress.getFeatureName();
        if ((localObject1 == null) || ("null".equals(localObject1))) {}
      }
      else
      {
        String str = localAddress.getLocality();
        Object localObject2 = localObject1;
        int j = i;
        if (str != null)
        {
          localObject2 = localObject1;
          j = i;
          if (!"null".equals(str))
          {
            localObject2 = str;
            if (localObject1 != null)
            {
              localObject2 = str;
              if (((String)localObject1).length() > 0) {
                localObject2 = localObject1 + ", " + str;
              }
            }
            j = i + 1;
          }
        }
        if (j == paramInt) {
          return (String)localObject2;
        }
        str = localAddress.getAdminArea();
        if ((str != null) && (!"null".equals(str)))
        {
          localObject1 = str;
          if (localObject2 != null)
          {
            localObject1 = str;
            if (((String)localObject2).length() > 0) {
              localObject1 = localObject2 + ", " + str;
            }
          }
          i = j + 1;
          localObject2 = localObject1;
        }
        for (;;)
        {
          localObject1 = localObject2;
          if (i == paramInt) {
            break;
          }
          str = localAddress.getCountryCode();
          localObject1 = localObject2;
          if (str == null) {
            break;
          }
          localObject1 = localObject2;
          if ("null".equals(str)) {
            break;
          }
          if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
            return localObject2 + ", " + str;
          }
          return localAddress.getCountryName();
          i = j;
        }
      }
      i = 0;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 344	android/os/Process:setThreadPriority	(I)V
    //   5: getstatic 33	com/venticake/retrica/view/album/ReverseGeocoder:sQueue	Lcom/venticake/retrica/view/album/Deque;
    //   8: astore_1
    //   9: aload_0
    //   10: new 124	android/location/Geocoder
    //   13: dup
    //   14: aload_0
    //   15: getfield 62	com/venticake/retrica/view/album/ReverseGeocoder:mContext	Landroid/content/Context;
    //   18: invokespecial 346	android/location/Geocoder:<init>	(Landroid/content/Context;)V
    //   21: putfield 122	com/venticake/retrica/view/album/ReverseGeocoder:mGeocoder	Landroid/location/Geocoder;
    //   24: aload_1
    //   25: invokevirtual 349	com/venticake/retrica/view/album/Deque:clear	()V
    //   28: aload_1
    //   29: monitorenter
    //   30: aload_1
    //   31: invokevirtual 353	com/venticake/retrica/view/album/Deque:pollFirst	()Ljava/lang/Object;
    //   34: checkcast 216	com/venticake/retrica/view/album/MediaSet
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +16 -> 55
    //   42: aload_1
    //   43: monitorexit
    //   44: aload_0
    //   45: aload_2
    //   46: invokespecial 355	com/venticake/retrica/view/album/ReverseGeocoder:process	(Lcom/venticake/retrica/view/album/MediaSet;)Z
    //   49: pop
    //   50: goto -22 -> 28
    //   53: astore_1
    //   54: return
    //   55: aload_1
    //   56: invokevirtual 358	java/lang/Object:wait	()V
    //   59: goto -29 -> 30
    //   62: astore_2
    //   63: aload_1
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ReverseGeocoder
    //   8	35	1	localDeque	Deque
    //   53	11	1	localInterruptedException	InterruptedException
    //   37	9	2	localMediaSet	MediaSet
    //   62	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	30	53	java/lang/InterruptedException
    //   44	50	53	java/lang/InterruptedException
    //   65	67	53	java/lang/InterruptedException
    //   30	38	62	finally
    //   42	44	62	finally
    //   55	59	62	finally
    //   63	65	62	finally
  }
  
  public void shutdown()
  {
    interrupt();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/ReverseGeocoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */