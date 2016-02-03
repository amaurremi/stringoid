package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

final class a
        implements JsonDeserializer<java.util.Date>, JsonSerializer<java.util.Date> {
    private final DateFormat a;
    private final DateFormat b;
    private final DateFormat c;

    a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public a(int paramInt1, int paramInt2) {
        this(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
    }

    a(String paramString) {
        this(new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
    }

    a(DateFormat paramDateFormat1, DateFormat paramDateFormat2) {
        this.a = paramDateFormat1;
        this.b = paramDateFormat2;
        this.c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private java.util.Date a(JsonElement paramJsonElement) {
        java.util.Date localDate2;
        synchronized (this.b) {
            try {
                java.util.Date localDate1 = this.b.parse(paramJsonElement.getAsString());
                return localDate1;
            } catch (ParseException localParseException1) {
            }
        }
    }

    public JsonElement a(java.util.Date paramDate, Type arg2, JsonSerializationContext paramJsonSerializationContext) {
        synchronized (this.b) {
            paramDate = new JsonPrimitive(this.a.format(paramDate));
            return paramDate;
        }
    }

    public java.util.Date a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext) {
        if (!(paramJsonElement instanceof JsonPrimitive)) {
            throw new JsonParseException("The date should be a string value");
        }
        paramJsonElement = a(paramJsonElement);
        if (paramType == java.util.Date.class) {
            return paramJsonElement;
        }
        if (paramType == Timestamp.class) {
            return new Timestamp(paramJsonElement.getTime());
        }
        if (paramType == java.sql.Date.class) {
            return new java.sql.Date(paramJsonElement.getTime());
        }
        throw new IllegalArgumentException(getClass() + " cannot deserialize to " + paramType);
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a.class.getSimpleName());
        localStringBuilder.append('(').append(this.b.getClass().getSimpleName()).append(')');
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */