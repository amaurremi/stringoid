package retrofit;

public final class Profiler$RequestInformation {
    private final String baseUrl;
    private final long contentLength;
    private final String contentType;
    private final String method;
    private final String relativePath;

    public Profiler$RequestInformation(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4) {
        this.method = paramString1;
        this.baseUrl = paramString2;
        this.relativePath = paramString3;
        this.contentLength = paramLong;
        this.contentType = paramString4;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getMethod() {
        return this.method;
    }

    public String getRelativePath() {
        return this.relativePath;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Profiler$RequestInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */