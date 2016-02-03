package twitter4j;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

import twitter4j.conf.Configuration;

final class PlaceJSONImpl
        extends TwitterResponseImpl
        implements Serializable, Place {
    private static final long serialVersionUID = -6368276880878829754L;
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

    PlaceJSONImpl() {
    }

    PlaceJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        super(paramHttpResponse);
        paramHttpResponse = paramHttpResponse.asJSONObject();
        init(paramHttpResponse);
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, paramHttpResponse);
        }
    }

    PlaceJSONImpl(JSONObject paramJSONObject) {
        init(paramJSONObject);
    }

    static ResponseList<Place> createPlaceList(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        Object localObject = null;
        try {
            JSONObject localJSONObject = paramHttpResponse.asJSONObject();
            localObject = localJSONObject;
            paramHttpResponse = createPlaceList(localJSONObject.getJSONObject("result").getJSONArray("places"), paramHttpResponse, paramConfiguration);
            return paramHttpResponse;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse.getMessage() + ":" + ((JSONObject) localObject).toString(), paramHttpResponse);
        }
    }

    static ResponseList<Place> createPlaceList(JSONArray paramJSONArray, HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        for (; ; ) {
            int i;
            try {
                int j = paramJSONArray.length();
                paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
                i = 0;
                if (i < j) {
                    JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
                    PlaceJSONImpl localPlaceJSONImpl = new PlaceJSONImpl(localJSONObject);
                    paramHttpResponse.add(localPlaceJSONImpl);
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(localPlaceJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(paramHttpResponse, paramJSONArray);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramJSONArray) {
                throw new TwitterException(paramJSONArray);
            }
            i += 1;
        }
    }

    private void init(JSONObject paramJSONObject) {
        for (; ; ) {
            try {
                this.name = ParseUtil.getUnescapedString("name", paramJSONObject);
                this.streetAddress = ParseUtil.getUnescapedString("street_address", paramJSONObject);
                this.countryCode = ParseUtil.getRawString("country_code", paramJSONObject);
                this.id = ParseUtil.getRawString("id", paramJSONObject);
                this.country = ParseUtil.getRawString("country", paramJSONObject);
                if (!paramJSONObject.isNull("place_type")) {
                    this.placeType = ParseUtil.getRawString("place_type", paramJSONObject);
                    this.url = ParseUtil.getRawString("url", paramJSONObject);
                    this.fullName = ParseUtil.getRawString("full_name", paramJSONObject);
                    if (!paramJSONObject.isNull("bounding_box")) {
                        Object localObject = paramJSONObject.getJSONObject("bounding_box");
                        this.boundingBoxType = ParseUtil.getRawString("type", (JSONObject) localObject);
                        this.boundingBoxCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(((JSONObject) localObject).getJSONArray("coordinates"));
                        if (paramJSONObject.isNull("geometry")) {
                            break label390;
                        }
                        localObject = paramJSONObject.getJSONObject("geometry");
                        this.geometryType = ParseUtil.getRawString("type", (JSONObject) localObject);
                        localObject = ((JSONObject) localObject).getJSONArray("coordinates");
                        if (!this.geometryType.equals("Point")) {
                            break label351;
                        }
                        this.geometryCoordinates = ((GeoLocation[][]) Array.newInstance(GeoLocation.class, new int[]{1, 1}));
                        this.geometryCoordinates[0][0] = new GeoLocation(((JSONArray) localObject).getDouble(1), ((JSONArray) localObject).getDouble(0));
                        if (paramJSONObject.isNull("contained_within")) {
                            break;
                        }
                        localObject = paramJSONObject.getJSONArray("contained_within");
                        this.containedWithIn = new Place[((JSONArray) localObject).length()];
                        int i = 0;
                        if (i >= ((JSONArray) localObject).length()) {
                            return;
                        }
                        this.containedWithIn[i] = new PlaceJSONImpl(((JSONArray) localObject).getJSONObject(i));
                        i += 1;
                        continue;
                    }
                } else {
                    this.placeType = ParseUtil.getRawString("type", paramJSONObject);
                    continue;
                }
                this.boundingBoxType = null;
            } catch (JSONException localJSONException) {
                throw new TwitterException(localJSONException.getMessage() + ":" + paramJSONObject.toString(), localJSONException);
            }
            this.boundingBoxCoordinates = ((GeoLocation[][]) null);
            continue;
            label351:
            if (this.geometryType.equals("Polygon")) {
                this.geometryCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(localJSONException);
            } else {
                this.geometryType = null;
                this.geometryCoordinates = ((GeoLocation[][]) null);
                continue;
                label390:
                this.geometryType = null;
                this.geometryCoordinates = ((GeoLocation[][]) null);
            }
        }
        this.containedWithIn = null;
    }

    public int compareTo(Place paramPlace) {
        return this.id.compareTo(paramPlace.getId());
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (paramObject == null) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (this == paramObject);
            if (!(paramObject instanceof Place)) {
                break;
            }
            bool1 = bool2;
        } while (((Place) paramObject).getId().equals(this.id));
        return false;
    }

    public GeoLocation[][] getBoundingBoxCoordinates() {
        return this.boundingBoxCoordinates;
    }

    public String getBoundingBoxType() {
        return this.boundingBoxType;
    }

    public Place[] getContainedWithIn() {
        return this.containedWithIn;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getFullName() {
        return this.fullName;
    }

    public GeoLocation[][] getGeometryCoordinates() {
        return this.geometryCoordinates;
    }

    public String getGeometryType() {
        return this.geometryType;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPlaceType() {
        return this.placeType;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getURL() {
        return this.url;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        Object localObject2 = null;
        StringBuilder localStringBuilder = new StringBuilder().append("PlaceJSONImpl{name='").append(this.name).append('\'').append(", streetAddress='").append(this.streetAddress).append('\'').append(", countryCode='").append(this.countryCode).append('\'').append(", id='").append(this.id).append('\'').append(", country='").append(this.country).append('\'').append(", placeType='").append(this.placeType).append('\'').append(", url='").append(this.url).append('\'').append(", fullName='").append(this.fullName).append('\'').append(", boundingBoxType='").append(this.boundingBoxType).append('\'').append(", boundingBoxCoordinates=");
        if (this.boundingBoxCoordinates == null) {
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
        for (Object localObject1 = localObject2; ; localObject1 = Arrays.asList(this.containedWithIn)) {
            return localObject1 + '}';
            localObject1 = Arrays.asList(this.boundingBoxCoordinates);
            break;
            localObject1 = Arrays.asList(this.geometryCoordinates);
            break label225;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/PlaceJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */