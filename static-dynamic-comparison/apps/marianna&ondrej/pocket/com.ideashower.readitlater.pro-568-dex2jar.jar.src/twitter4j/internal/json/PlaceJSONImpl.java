package twitter4j.internal.json;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import twitter4j.GeoLocation;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class PlaceJSONImpl
  extends TwitterResponseImpl
  implements Serializable, Place
{
  private static final long serialVersionUID = -2873364341474633812L;
  private GeoLocation[][] boundingBoxCoordinates;
  private String boundingBoxType;
  private Place[] containedWithIn;
  private String country;
  private String countryCode;
  private String fullName;
  private GeoLocation[][] geometryCoordinates;
  private String geometryType;
  private String id;
  private String name;
  private String placeType;
  private String streetAddress;
  private String url;
  
  PlaceJSONImpl() {}
  
  PlaceJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    super(paramHttpResponse);
    paramHttpResponse = paramHttpResponse.asJSONObject();
    init(paramHttpResponse);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse);
    }
  }
  
  PlaceJSONImpl(JSONObject paramJSONObject)
  {
    init(paramJSONObject);
  }
  
  PlaceJSONImpl(JSONObject paramJSONObject, HttpResponse paramHttpResponse)
  {
    super(paramHttpResponse);
    init(paramJSONObject);
  }
  
  static ResponseList createPlaceList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    Object localObject = null;
    try
    {
      JSONObject localJSONObject = paramHttpResponse.asJSONObject();
      localObject = localJSONObject;
      paramHttpResponse = createPlaceList(localJSONObject.getJSONObject("result").getJSONArray("places"), paramHttpResponse, paramConfiguration);
      return paramHttpResponse;
    }
    catch (JSONException paramHttpResponse)
    {
      throw new TwitterException(paramHttpResponse.getMessage() + ":" + ((JSONObject)localObject).toString(), paramHttpResponse);
    }
  }
  
  static ResponseList createPlaceList(JSONArray paramJSONArray, HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    if (paramConfiguration.isJSONStoreEnabled()) {
      DataObjectFactoryUtil.clearThreadLocalMap();
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramJSONArray.length();
        paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          PlaceJSONImpl localPlaceJSONImpl = new PlaceJSONImpl(localJSONObject);
          paramHttpResponse.add(localPlaceJSONImpl);
          if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(localPlaceJSONImpl, localJSONObject);
          }
        }
        else
        {
          if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, paramJSONArray);
          }
          return paramHttpResponse;
        }
      }
      catch (JSONException paramJSONArray)
      {
        throw new TwitterException(paramJSONArray);
      }
      catch (TwitterException paramJSONArray)
      {
        throw paramJSONArray;
      }
      i += 1;
    }
  }
  
  private void init(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.name = z_T4JInternalParseUtil.getUnescapedString("name", paramJSONObject);
        this.streetAddress = z_T4JInternalParseUtil.getUnescapedString("street_address", paramJSONObject);
        this.countryCode = z_T4JInternalParseUtil.getRawString("country_code", paramJSONObject);
        this.id = z_T4JInternalParseUtil.getRawString("id", paramJSONObject);
        this.country = z_T4JInternalParseUtil.getRawString("country", paramJSONObject);
        if (!paramJSONObject.isNull("place_type"))
        {
          this.placeType = z_T4JInternalParseUtil.getRawString("place_type", paramJSONObject);
          this.url = z_T4JInternalParseUtil.getRawString("url", paramJSONObject);
          this.fullName = z_T4JInternalParseUtil.getRawString("full_name", paramJSONObject);
          if (!paramJSONObject.isNull("bounding_box"))
          {
            Object localObject = paramJSONObject.getJSONObject("bounding_box");
            this.boundingBoxType = z_T4JInternalParseUtil.getRawString("type", (JSONObject)localObject);
            this.boundingBoxCoordinates = z_T4JInternalJSONImplFactory.coordinatesAsGeoLocationArray(((JSONObject)localObject).getJSONArray("coordinates"));
            if (paramJSONObject.isNull("geometry")) {
              break label390;
            }
            localObject = paramJSONObject.getJSONObject("geometry");
            this.geometryType = z_T4JInternalParseUtil.getRawString("type", (JSONObject)localObject);
            localObject = ((JSONObject)localObject).getJSONArray("coordinates");
            if (!this.geometryType.equals("Point")) {
              break label351;
            }
            this.geometryCoordinates = ((GeoLocation[][])Array.newInstance(GeoLocation.class, new int[] { 1, 1 }));
            this.geometryCoordinates[0][0] = new GeoLocation(((JSONArray)localObject).getDouble(0), ((JSONArray)localObject).getDouble(1));
            if (paramJSONObject.isNull("contained_within")) {
              break;
            }
            localObject = paramJSONObject.getJSONArray("contained_within");
            this.containedWithIn = new Place[((JSONArray)localObject).length()];
            int i = 0;
            if (i >= ((JSONArray)localObject).length()) {
              return;
            }
            this.containedWithIn[i] = new PlaceJSONImpl(((JSONArray)localObject).getJSONObject(i));
            i += 1;
            continue;
          }
        }
        else
        {
          this.placeType = z_T4JInternalParseUtil.getRawString("type", paramJSONObject);
          continue;
        }
        this.boundingBoxType = null;
      }
      catch (JSONException localJSONException)
      {
        throw new TwitterException(localJSONException.getMessage() + ":" + paramJSONObject.toString(), localJSONException);
      }
      this.boundingBoxCoordinates = ((GeoLocation[][])null);
      continue;
      label351:
      if (this.geometryType.equals("Polygon"))
      {
        this.geometryCoordinates = z_T4JInternalJSONImplFactory.coordinatesAsGeoLocationArray(localJSONException);
      }
      else
      {
        this.geometryType = null;
        this.geometryCoordinates = ((GeoLocation[][])null);
        continue;
        label390:
        this.geometryType = null;
        this.geometryCoordinates = ((GeoLocation[][])null);
      }
    }
    this.containedWithIn = null;
  }
  
  public int compareTo(Place paramPlace)
  {
    return this.id.compareTo(paramPlace.getId());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      if (!(paramObject instanceof Place)) {
        break;
      }
      bool1 = bool2;
    } while (((Place)paramObject).getId().equals(this.id));
    return false;
  }
  
  public GeoLocation[][] getBoundingBoxCoordinates()
  {
    return this.boundingBoxCoordinates;
  }
  
  public String getBoundingBoxType()
  {
    return this.boundingBoxType;
  }
  
  public Place[] getContainedWithIn()
  {
    return this.containedWithIn;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public GeoLocation[][] getGeometryCoordinates()
  {
    return this.geometryCoordinates;
  }
  
  public String getGeometryType()
  {
    return this.geometryType;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPlaceType()
  {
    return this.placeType;
  }
  
  public String getStreetAddress()
  {
    return this.streetAddress;
  }
  
  public String getURL()
  {
    return this.url;
  }
  
  public int hashCode()
  {
    return this.id.hashCode();
  }
  
  public String toString()
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("PlaceJSONImpl{name='").append(this.name).append('\'').append(", streetAddress='").append(this.streetAddress).append('\'').append(", countryCode='").append(this.countryCode).append('\'').append(", id='").append(this.id).append('\'').append(", country='").append(this.country).append('\'').append(", placeType='").append(this.placeType).append('\'').append(", url='").append(this.url).append('\'').append(", fullName='").append(this.fullName).append('\'').append(", boundingBoxType='").append(this.boundingBoxType).append('\'').append(", boundingBoxCoordinates=");
    if (this.boundingBoxCoordinates == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", geometryType='").append(this.geometryType).append('\'').append(", geometryCoordinates=");
      if (this.geometryCoordinates != null) {
        break label271;
      }
      localObject1 = null;
      label225:
      localStringBuilder = localStringBuilder.append(localObject1).append(", containedWithIn=");
      if (this.containedWithIn != null) {
        break label282;
      }
    }
    label271:
    label282:
    for (Object localObject1 = localObject2;; localObject1 = Arrays.asList(this.containedWithIn))
    {
      return localObject1 + '}';
      localObject1 = Arrays.asList(this.boundingBoxCoordinates);
      break;
      localObject1 = Arrays.asList(this.geometryCoordinates);
      break label225;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/PlaceJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */