package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
        implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, FieldNamingStrategy paramFieldNamingStrategy, Excluder paramExcluder) {
        this.constructorConstructor = paramConstructorConstructor;
        this.fieldNamingPolicy = paramFieldNamingStrategy;
        this.excluder = paramExcluder;
    }

    private j createBoundField(Gson paramGson, Field paramField, String paramString, TypeToken<?> paramTypeToken, boolean paramBoolean1, boolean paramBoolean2) {
        return new i(this, paramString, paramBoolean1, paramBoolean2, paramGson, paramField, paramTypeToken, Primitives.isPrimitive(paramTypeToken.getRawType()));
    }

    private Map<String, j> getBoundFields(Gson paramGson, TypeToken<?> paramTypeToken, Class<?> paramClass) {
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        if (paramClass.isInterface()) {
            return localLinkedHashMap;
        }
        Type localType1 = paramTypeToken.getType();
        while (paramClass != Object.class) {
            Field[] arrayOfField = paramClass.getDeclaredFields();
            int j = arrayOfField.length;
            int i = 0;
            if (i < j) {
                Object localObject = arrayOfField[i];
                boolean bool1 = excludeField((Field) localObject, true);
                boolean bool2 = excludeField((Field) localObject, false);
                if ((!bool1) && (!bool2)) {
                }
                do {
                    i += 1;
                    break;
                    ((Field) localObject).setAccessible(true);
                    Type localType2 =.
                    Gson.Types.resolve(paramTypeToken.getType(), paramClass, ((Field) localObject).getGenericType());
                    localObject = createBoundField(paramGson, (Field) localObject, getFieldName((Field) localObject), TypeToken.get(localType2), bool1, bool2);
                    localObject = (j) localLinkedHashMap.put(((j) localObject).g, localObject);
                } while (localObject == null);
                throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + ((j) localObject).g);
            }
            paramTypeToken = TypeToken.get(.Gson.Types.resolve(paramTypeToken.getType(), paramClass, paramClass.getGenericSuperclass()))
            ;
            paramClass = paramTypeToken.getRawType();
        }
        return localLinkedHashMap;
    }

    private TypeAdapter<?> getFieldAdapter(Gson paramGson, Field paramField, TypeToken<?> paramTypeToken) {
        paramField = (JsonAdapter) paramField.getAnnotation(JsonAdapter.class);
        if (paramField != null) {
            paramField = JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(this.constructorConstructor, paramGson, paramTypeToken, paramField);
            if (paramField != null) {
                return paramField;
            }
        }
        return paramGson.getAdapter(paramTypeToken);
    }

    private String getFieldName(Field paramField) {
        SerializedName localSerializedName = (SerializedName) paramField.getAnnotation(SerializedName.class);
        if (localSerializedName == null) {
            return this.fieldNamingPolicy.translateName(paramField);
        }
        return localSerializedName.value();
    }

    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
        Class localClass = paramTypeToken.getRawType();
        if (!Object.class.isAssignableFrom(localClass)) {
            return null;
        }
        return new ReflectiveTypeAdapterFactory.Adapter(this.constructorConstructor.get(paramTypeToken), getBoundFields(paramGson, paramTypeToken, localClass), null);
    }

    public boolean excludeField(Field paramField, boolean paramBoolean) {
        return (!this.excluder.excludeClass(paramField.getType(), paramBoolean)) && (!this.excluder.excludeField(paramField, paramBoolean));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/bind/ReflectiveTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */