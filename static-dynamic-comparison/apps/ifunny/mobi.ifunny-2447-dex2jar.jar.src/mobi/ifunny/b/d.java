package mobi.ifunny.b;

import com.google.gson.annotations.SerializedName;

public class d {
    @SerializedName("t")
    public final String a = "event";
    @SerializedName("ec")
    public final String b;
    @SerializedName("ea")
    public final String c;
    @SerializedName("el")
    public final String d;
    @SerializedName("ev")
    public final Long e;

    public d(String paramString1, String paramString2, String paramString3, Long paramLong) {
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
        this.e = paramLong;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */