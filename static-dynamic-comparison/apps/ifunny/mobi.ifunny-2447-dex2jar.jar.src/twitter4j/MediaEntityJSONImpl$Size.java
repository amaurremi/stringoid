package twitter4j;

class MediaEntityJSONImpl$Size
        implements MediaEntity.Size {
    private static final long serialVersionUID = -2515842281909325169L;
    int height;
    int resize;
    int width;

    MediaEntityJSONImpl$Size(JSONObject paramJSONObject) {
        this.width = paramJSONObject.getInt("w");
        this.height = paramJSONObject.getInt("h");
        if ("fit".equals(paramJSONObject.getString("resize"))) {
        }
        for (int i = 100; ; i = 101) {
            this.resize = i;
            return;
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof Size)) {
                return false;
            }
            paramObject = (Size) paramObject;
            if (this.height != ((Size) paramObject).height) {
                return false;
            }
            if (this.resize != ((Size) paramObject).resize) {
                return false;
            }
        } while (this.width == ((Size) paramObject).width);
        return false;
    }

    public int getHeight() {
        return this.height;
    }

    public int getResize() {
        return this.resize;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31 + this.height) * 31 + this.resize;
    }

    public String toString() {
        return "Size{width=" + this.width + ", height=" + this.height + ", resize=" + this.resize + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/MediaEntityJSONImpl$Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */