package com.flurry.org.apache.avro.reflect;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.Decoder;
import com.flurry.org.apache.avro.specific.SpecificDatumReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

public class ReflectDatumReader<T>
  extends SpecificDatumReader<T>
{
  public ReflectDatumReader()
  {
    this(null, null, ReflectData.get());
  }
  
  public ReflectDatumReader(Schema paramSchema)
  {
    this(paramSchema, paramSchema, ReflectData.get());
  }
  
  public ReflectDatumReader(Schema paramSchema1, Schema paramSchema2)
  {
    this(paramSchema1, paramSchema2, ReflectData.get());
  }
  
  protected ReflectDatumReader(Schema paramSchema1, Schema paramSchema2, ReflectData paramReflectData)
  {
    super(paramSchema1, paramSchema2, paramReflectData);
  }
  
  public ReflectDatumReader(Class<T> paramClass)
  {
    this(ReflectData.get().getSchema(paramClass));
  }
  
  protected void addToArray(Object paramObject1, long paramLong, Object paramObject2)
  {
    if ((paramObject1 instanceof Collection))
    {
      ((Collection)paramObject1).add(paramObject2);
      return;
    }
    Array.set(paramObject1, (int)paramLong, paramObject2);
  }
  
  protected Object createString(String paramString)
  {
    return paramString;
  }
  
  protected Object newArray(Object paramObject, int paramInt, Schema paramSchema)
  {
    ReflectData localReflectData = ReflectData.get();
    Class localClass = ReflectData.getClassProp(paramSchema, "java-class");
    if (localClass != null)
    {
      if ((paramObject instanceof Collection))
      {
        ((Collection)paramObject).clear();
        return paramObject;
      }
      if (localClass.isAssignableFrom(ArrayList.class)) {
        return new ArrayList();
      }
      return ReflectData.newInstance(localClass, paramSchema);
    }
    localClass = ReflectData.getClassProp(paramSchema, "java-element-class");
    paramObject = localClass;
    if (localClass == null) {
      paramObject = localReflectData.getClass(paramSchema.getElementType());
    }
    return Array.newInstance((Class)paramObject, paramInt);
  }
  
  protected Object peekArray(Object paramObject)
  {
    return null;
  }
  
  protected Object readBytes(Object paramObject, Decoder paramDecoder)
    throws IOException
  {
    paramObject = paramDecoder.readBytes(null);
    paramDecoder = new byte[((ByteBuffer)paramObject).remaining()];
    ((ByteBuffer)paramObject).get(paramDecoder);
    return paramDecoder;
  }
  
  protected Object readInt(Object paramObject, Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    paramDecoder = Integer.valueOf(paramDecoder.readInt());
    paramSchema = paramSchema.getProp("java-class");
    if (Byte.class.getName().equals(paramSchema)) {
      paramObject = Byte.valueOf(((Integer)paramDecoder).byteValue());
    }
    do
    {
      return paramObject;
      paramObject = paramDecoder;
    } while (!Short.class.getName().equals(paramSchema));
    return Short.valueOf(((Integer)paramDecoder).shortValue());
  }
  
  protected Object readString(Object paramObject, Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    paramDecoder = (String)readString(null, paramDecoder);
    paramSchema = ReflectData.getClassProp(paramSchema, "java-class");
    paramObject = paramDecoder;
    if (paramSchema != null) {}
    try
    {
      paramObject = paramSchema.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramDecoder });
      return paramObject;
    }
    catch (NoSuchMethodException paramObject)
    {
      throw new AvroRuntimeException((Throwable)paramObject);
    }
    catch (InstantiationException paramObject)
    {
      throw new AvroRuntimeException((Throwable)paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new AvroRuntimeException((Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      throw new AvroRuntimeException((Throwable)paramObject);
    }
  }
  
  protected Object readString(Object paramObject, Decoder paramDecoder)
    throws IOException
  {
    return super.readString(null, paramDecoder).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/reflect/ReflectDatumReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */