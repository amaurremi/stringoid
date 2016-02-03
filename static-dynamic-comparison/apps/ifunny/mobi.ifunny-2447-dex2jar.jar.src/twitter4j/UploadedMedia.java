package twitter4j;

import java.io.Serializable;

public final class UploadedMedia
        implements Serializable {
    private static final long serialVersionUID = 5393092535610604718L;
    private int imageHeight;
    private String imageType;
    private int imageWidth;
    private long mediaId;
    private long size;

    UploadedMedia(JSONObject paramJSONObject) {
        init(paramJSONObject);
    }

    private void init(JSONObject paramJSONObject) {
        this.mediaId = ParseUtil.getLong("media_id", paramJSONObject);
        this.size = ParseUtil.getLong("size", paramJSONObject);
        try {
            if (!paramJSONObject.isNull("image")) {
                paramJSONObject = paramJSONObject.getJSONObject("image");
                this.imageWidth = ParseUtil.getInt("w", paramJSONObject);
                this.imageHeight = ParseUtil.getInt("h", paramJSONObject);
                this.imageType = ParseUtil.getUnescapedString("image_type", paramJSONObject);
            }
            return;
        } catch (JSONException paramJSONObject) {
            throw new TwitterException(paramJSONObject);
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (UploadedMedia) paramObject;
            if (this.imageWidth != ((UploadedMedia) paramObject).imageWidth) {
                return false;
            }
            if (this.imageHeight != ((UploadedMedia) paramObject).imageHeight) {
                return false;
            }
            if (this.imageType != ((UploadedMedia) paramObject).imageType) {
                return false;
            }
            if (this.mediaId != ((UploadedMedia) paramObject).mediaId) {
                return false;
            }
        } while (this.size == ((UploadedMedia) paramObject).size);
        return false;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public String getImageType() {
        return this.imageType;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public long getMediaId() {
        return this.mediaId;
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        int j = (int) (this.mediaId ^ this.mediaId >>> 32);
        int k = this.imageWidth;
        int m = this.imageHeight;
        if (this.imageType != null) {
        }
        for (int i = this.imageType.hashCode(); ; i = 0) {
            return (i + ((j * 31 + k) * 31 + m) * 31) * 31 + (int) (this.size ^ this.size >>> 32);
        }
    }

    public String toString() {
        return "UploadedMedia{mediaId=" + this.mediaId + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", imageType='" + this.imageType + '\'' + ", size=" + this.size + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/UploadedMedia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */