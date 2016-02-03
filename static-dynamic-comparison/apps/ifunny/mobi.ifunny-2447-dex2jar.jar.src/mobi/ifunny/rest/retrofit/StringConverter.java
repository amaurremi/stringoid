package mobi.ifunny.rest.retrofit;

import java.io.IOException;
import java.lang.reflect.Type;

import mobi.ifunny.util.s;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;
import retrofit.mime.TypedString;

public class StringConverter
        implements Converter {
    public String fromBody(TypedInput paramTypedInput, Type paramType) {
        try {
            paramTypedInput = s.a(paramTypedInput.in());
            return paramTypedInput;
        } catch (IOException paramTypedInput) {
            throw new ConversionException(paramTypedInput);
        }
    }

    public TypedOutput toBody(Object paramObject) {
        if (!(paramObject instanceof String)) {
            return null;
        }
        return new TypedString((String) paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/StringConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */