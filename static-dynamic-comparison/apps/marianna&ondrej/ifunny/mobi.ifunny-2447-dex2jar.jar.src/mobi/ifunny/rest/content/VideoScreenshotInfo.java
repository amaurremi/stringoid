package mobi.ifunny.rest.content;

public class VideoScreenshotInfo {
    public static final String SIZE_BIG = "big";
    public static final String SIZE_SMALL = "small";
    private String size;
    private String url;

    public VideoScreenshotInfo(String paramString1, String paramString2) {
        this.size = paramString1;
        this.url = paramString2;
    }

    public String getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/VideoScreenshotInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */