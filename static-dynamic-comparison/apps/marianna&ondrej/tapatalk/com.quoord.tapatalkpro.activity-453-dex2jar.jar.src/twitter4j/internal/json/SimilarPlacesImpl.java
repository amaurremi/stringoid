package twitter4j.internal.json;

import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.SimilarPlaces;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public class SimilarPlacesImpl
        extends ResponseListImpl<Place>
        implements SimilarPlaces {
    private static final long serialVersionUID = -7897806745732767803L;
    private final String token;

    SimilarPlacesImpl(ResponseList<Place> paramResponseList, HttpResponse paramHttpResponse, String paramString) {
        super(paramResponseList.size(), paramHttpResponse);
        addAll(paramResponseList);
        this.token = paramString;
    }

    static SimilarPlaces createSimilarPlaces(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        Object localObject = null;
        try {
            JSONObject localJSONObject1 = paramHttpResponse.asJSONObject();
            localObject = localJSONObject1;
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("result");
            localObject = localJSONObject1;
            paramHttpResponse = new SimilarPlacesImpl(PlaceJSONImpl.createPlaceList(localJSONObject2.getJSONArray("places"), paramHttpResponse, paramConfiguration), paramHttpResponse, localJSONObject2.getString("token"));
            return paramHttpResponse;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse.getMessage() + ":" + ((JSONObject) localObject).toString(), paramHttpResponse);
        }
    }

    public String getToken() {
        return this.token;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/SimilarPlacesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */