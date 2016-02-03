package retrofit.converter;

import java.lang.reflect.Type;

import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public abstract interface Converter {
    public abstract Object fromBody(TypedInput paramTypedInput, Type paramType);

    public abstract TypedOutput toBody(Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/converter/Converter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */