package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.reflect.TypeToken;

class q
        implements TypeAdapterFactory {
    private final TypeToken<?> a;
    private final boolean b;
    private final Class<?> c;
    private final JsonSerializer<?> d;
    private final JsonDeserializer<?> e;

    private q(Object paramObject, TypeToken<?> paramTypeToken, boolean paramBoolean, Class<?> paramClass) {
        JsonSerializer localJsonSerializer;
        if ((paramObject instanceof JsonSerializer)) {
            localJsonSerializer = (JsonSerializer) paramObject;
            this.d = localJsonSerializer;
            if (!(paramObject instanceof JsonDeserializer)) {
                break label85;
            }
            paramObject = (JsonDeserializer) paramObject;
            label35:
            this.e = ((JsonDeserializer) paramObject);
            if ((this.d == null) && (this.e == null)) {
                break label90;
            }
        }
        label85:
        label90:
        for (boolean bool = true; ; bool = false) {
            .Gson.Preconditions.checkArgument(bool);
            this.a = paramTypeToken;
            this.b = paramBoolean;
            this.c = paramClass;
            return;
            localJsonSerializer = null;
            break;
            paramObject = null;
            break label35;
        }
    }

    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        boolean bool;
        if (this.a != null) {
            if ((this.a.equals(paramTypeToken)) || ((this.b) && (this.a.getType() == paramTypeToken.getRawType()))) {
                bool = true;
            }
        }
        while (bool) {
            return new o(this.d, this.e, paramGson, paramTypeToken, this, null);
            bool = false;
            continue;
            bool = this.c.isAssignableFrom(paramTypeToken.getRawType());
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */