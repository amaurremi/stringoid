package mobi.ifunny.rest.retrofit;

import retrofit.mime.TypedByteArray;

public class TypedByteArrayWithFilename
        extends TypedByteArray {
    private static final String FILENAME = "php.sucks";

    public TypedByteArrayWithFilename(String paramString, byte[] paramArrayOfByte) {
        super(paramString, paramArrayOfByte);
    }

    public String fileName() {
        return "php.sucks";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/TypedByteArrayWithFilename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */