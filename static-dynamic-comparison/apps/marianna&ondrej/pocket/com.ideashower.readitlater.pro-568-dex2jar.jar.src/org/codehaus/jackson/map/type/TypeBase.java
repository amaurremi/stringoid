package org.codehaus.jackson.map.type;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.type.JavaType;

public abstract class TypeBase
  extends JavaType
  implements JsonSerializableWithType
{
  volatile String _canonicalName;
  
  @Deprecated
  protected TypeBase(Class paramClass, int paramInt)
  {
    super(paramClass, paramInt);
  }
  
  protected TypeBase(Class paramClass, int paramInt, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramInt);
    this._valueHandler = paramObject1;
    this._typeHandler = paramObject2;
  }
  
  protected static StringBuilder _classSignature(Class paramClass, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (paramClass.isPrimitive()) {
      if (paramClass == Boolean.TYPE) {
        paramStringBuilder.append('Z');
      }
    }
    do
    {
      return paramStringBuilder;
      if (paramClass == Byte.TYPE)
      {
        paramStringBuilder.append('B');
        return paramStringBuilder;
      }
      if (paramClass == Short.TYPE)
      {
        paramStringBuilder.append('S');
        return paramStringBuilder;
      }
      if (paramClass == Character.TYPE)
      {
        paramStringBuilder.append('C');
        return paramStringBuilder;
      }
      if (paramClass == Integer.TYPE)
      {
        paramStringBuilder.append('I');
        return paramStringBuilder;
      }
      if (paramClass == Long.TYPE)
      {
        paramStringBuilder.append('J');
        return paramStringBuilder;
      }
      if (paramClass == Float.TYPE)
      {
        paramStringBuilder.append('F');
        return paramStringBuilder;
      }
      if (paramClass == Double.TYPE)
      {
        paramStringBuilder.append('D');
        return paramStringBuilder;
      }
      if (paramClass == Void.TYPE)
      {
        paramStringBuilder.append('V');
        return paramStringBuilder;
      }
      throw new IllegalStateException("Unrecognized primitive type: " + paramClass.getName());
      paramStringBuilder.append('L');
      paramClass = paramClass.getName();
      int j = paramClass.length();
      int i = 0;
      while (i < j)
      {
        char c2 = paramClass.charAt(i);
        char c1 = c2;
        if (c2 == '.') {
          c1 = '/';
        }
        paramStringBuilder.append(c1);
        i += 1;
      }
    } while (!paramBoolean);
    paramStringBuilder.append(';');
    return paramStringBuilder;
  }
  
  protected abstract String buildCanonicalName();
  
  public abstract StringBuilder getErasedSignature(StringBuilder paramStringBuilder);
  
  public abstract StringBuilder getGenericSignature(StringBuilder paramStringBuilder);
  
  public Object getTypeHandler()
  {
    return this._typeHandler;
  }
  
  public Object getValueHandler()
  {
    return this._valueHandler;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeString(toCanonical());
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer.writeTypePrefixForScalar(this, paramJsonGenerator);
    serialize(paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForScalar(this, paramJsonGenerator);
  }
  
  public String toCanonical()
  {
    String str2 = this._canonicalName;
    String str1 = str2;
    if (str2 == null) {
      str1 = buildCanonicalName();
    }
    return str1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/type/TypeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */