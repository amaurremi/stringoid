package twitter4j.internal.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import twitter4j.MediaEntity.Size;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class TwitterAPIConfigurationJSONImpl
        extends TwitterResponseImpl
        implements TwitterAPIConfiguration {
    private static final long serialVersionUID = 5786291660087491465L;
    private int charactersReservedPerMedia;
    private int maxMediaPerUpload;
    private String[] nonUsernamePaths;
    private int photoSizeLimit;
    private Map<Integer, MediaEntity.Size> photoSizes;
    private int shortURLLength;
    private int shortURLLengthHttps;

    TwitterAPIConfigurationJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        super(paramHttpResponse);
        try {
            JSONObject localJSONObject2 = paramHttpResponse.asJSONObject();
            this.photoSizeLimit = z_T4JInternalParseUtil.getInt("photo_size_limit", localJSONObject2);
            this.shortURLLength = z_T4JInternalParseUtil.getInt("short_url_length", localJSONObject2);
            this.shortURLLengthHttps = z_T4JInternalParseUtil.getInt("short_url_length_https", localJSONObject2);
            this.charactersReservedPerMedia = z_T4JInternalParseUtil.getInt("characters_reserved_per_media", localJSONObject2);
            JSONObject localJSONObject3 = localJSONObject2.getJSONObject("photo_sizes");
            this.photoSizes = new HashMap(4);
            this.photoSizes.put(MediaEntity.Size.LARGE, new MediaEntityJSONImpl.Size(localJSONObject3.getJSONObject("large")));
            if (localJSONObject3.isNull("med")) {
            }
            for (JSONObject localJSONObject1 = localJSONObject3.getJSONObject("medium"); ; localJSONObject1 = localJSONObject3.getJSONObject("med")) {
                this.photoSizes.put(MediaEntity.Size.MEDIUM, new MediaEntityJSONImpl.Size(localJSONObject1));
                this.photoSizes.put(MediaEntity.Size.SMALL, new MediaEntityJSONImpl.Size(localJSONObject3.getJSONObject("small")));
                this.photoSizes.put(MediaEntity.Size.THUMB, new MediaEntityJSONImpl.Size(localJSONObject3.getJSONObject("thumb")));
                if (paramConfiguration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.clearThreadLocalMap();
                    DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse.asJSONObject());
                }
                paramHttpResponse = localJSONObject2.getJSONArray("non_username_paths");
                this.nonUsernamePaths = new String[paramHttpResponse.length()];
                int i = 0;
                while (i < paramHttpResponse.length()) {
                    this.nonUsernamePaths[i] = paramHttpResponse.getString(i);
                    i += 1;
                }
            }
            this.maxMediaPerUpload = z_T4JInternalParseUtil.getInt("max_media_per_upload", localJSONObject2);
            return;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse);
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof TwitterAPIConfigurationJSONImpl)) {
                return false;
            }
            paramObject = (TwitterAPIConfigurationJSONImpl) paramObject;
            if (this.charactersReservedPerMedia != ((TwitterAPIConfigurationJSONImpl) paramObject).charactersReservedPerMedia) {
                return false;
            }
            if (this.maxMediaPerUpload != ((TwitterAPIConfigurationJSONImpl) paramObject).maxMediaPerUpload) {
                return false;
            }
            if (this.photoSizeLimit != ((TwitterAPIConfigurationJSONImpl) paramObject).photoSizeLimit) {
                return false;
            }
            if (this.shortURLLength != ((TwitterAPIConfigurationJSONImpl) paramObject).shortURLLength) {
                return false;
            }
            if (this.shortURLLengthHttps != ((TwitterAPIConfigurationJSONImpl) paramObject).shortURLLengthHttps) {
                return false;
            }
            if (!Arrays.equals(this.nonUsernamePaths, ((TwitterAPIConfigurationJSONImpl) paramObject).nonUsernamePaths)) {
                return false;
            }
            if (this.photoSizes == null) {
                break;
            }
        } while (this.photoSizes.equals(((TwitterAPIConfigurationJSONImpl) paramObject).photoSizes));
        for (; ; ) {
            return false;
            if (((TwitterAPIConfigurationJSONImpl) paramObject).photoSizes == null) {
                break;
            }
        }
    }

    public int getCharactersReservedPerMedia() {
        return this.charactersReservedPerMedia;
    }

    public int getMaxMediaPerUpload() {
        return this.maxMediaPerUpload;
    }

    public String[] getNonUsernamePaths() {
        return this.nonUsernamePaths;
    }

    public int getPhotoSizeLimit() {
        return this.photoSizeLimit;
    }

    public Map<Integer, MediaEntity.Size> getPhotoSizes() {
        return this.photoSizes;
    }

    public int getShortURLLength() {
        return this.shortURLLength;
    }

    public int getShortURLLengthHttps() {
        return this.shortURLLengthHttps;
    }

    public int hashCode() {
        int j = 0;
        int k = this.photoSizeLimit;
        int m = this.shortURLLength;
        int n = this.shortURLLengthHttps;
        int i1 = this.charactersReservedPerMedia;
        if (this.photoSizes != null) {
        }
        for (int i = this.photoSizes.hashCode(); ; i = 0) {
            if (this.nonUsernamePaths != null) {
                j = Arrays.hashCode(this.nonUsernamePaths);
            }
            return (((((k * 31 + m) * 31 + n) * 31 + i1) * 31 + i) * 31 + j) * 31 + this.maxMediaPerUpload;
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder().append("TwitterAPIConfigurationJSONImpl{photoSizeLimit=").append(this.photoSizeLimit).append(", shortURLLength=").append(this.shortURLLength).append(", shortURLLengthHttps=").append(this.shortURLLengthHttps).append(", charactersReservedPerMedia=").append(this.charactersReservedPerMedia).append(", photoSizes=").append(this.photoSizes).append(", nonUsernamePaths=");
        if (this.nonUsernamePaths == null) {
        }
        for (Object localObject = null; ; localObject = Arrays.asList(this.nonUsernamePaths)) {
            return localObject + ", maxMediaPerUpload=" + this.maxMediaPerUpload + '}';
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/TwitterAPIConfigurationJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */