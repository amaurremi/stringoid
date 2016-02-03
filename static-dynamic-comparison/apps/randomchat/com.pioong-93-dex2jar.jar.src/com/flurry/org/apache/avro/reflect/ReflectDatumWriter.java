package com.flurry.org.apache.avro.reflect;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.Encoder;
import com.flurry.org.apache.avro.specific.SpecificDatumWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public class ReflectDatumWriter<T>
  extends SpecificDatumWriter<T>
{
  public ReflectDatumWriter()
  {
    this(ReflectData.get());
  }
  
  public ReflectDatumWriter(Schema paramSchema)
  {
    this(paramSchema, ReflectData.get());
  }
  
  protected ReflectDatumWriter(Schema paramSchema, ReflectData paramReflectData)
  {
    super(paramSchema, paramReflectData);
  }
  
  protected ReflectDatumWriter(ReflectData paramReflectData)
  {
    super(paramReflectData);
  }
  
  public ReflectDatumWriter(Class<T> paramClass)
  {
    this(paramClass, ReflectData.get());
  }
  
  public ReflectDatumWriter(Class<T> paramClass, ReflectData paramReflectData)
  {
    this(paramReflectData.getSchema(paramClass), paramReflectData);
  }
  
  protected Iterator<Object> getArrayElements(final Object paramObject)
  {
    if ((paramObject instanceof Collection)) {
      return ((Collection)paramObject).iterator();
    }
    new Iterator()
    {
      private int i = 0;
      private final int length = Array.getLength(paramObject);
      
      public boolean hasNext()
      {
        return this.i < this.length;
      }
      
      public Object next()
      {
        Object localObject = paramObject;
        int j = this.i;
        this.i = (j + 1);
        return Array.get(localObject, j);
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  protected long getArraySize(Object paramObject)
  {
    if ((paramObject instanceof Collection)) {
      return ((Collection)paramObject).size();
    }
    return Array.getLength(paramObject);
  }
  
  protected void write(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    Object localObject;
    if ((paramObject instanceof Byte)) {
      localObject = Integer.valueOf(((Byte)paramObject).intValue());
    }
    for (;;)
    {
      try
      {
        super.write(paramSchema, localObject, paramEncoder);
        return;
      }
      catch (NullPointerException paramObject)
      {
        paramEncoder = new NullPointerException("in " + paramSchema.getFullName() + " " + ((NullPointerException)paramObject).getMessage());
        if (((NullPointerException)paramObject).getCause() != null) {
          break;
        }
      }
      localObject = paramObject;
      if ((paramObject instanceof Short)) {
        localObject = Integer.valueOf(((Short)paramObject).intValue());
      }
    }
    for (paramSchema = (Schema)paramObject;; paramSchema = ((NullPointerException)paramObject).getCause())
    {
      paramEncoder.initCause(paramSchema);
      throw paramEncoder;
    }
  }
  
  protected void writeBytes(Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    if ((paramObject instanceof byte[]))
    {
      paramEncoder.writeBytes((byte[])paramObject);
      return;
    }
    super.writeBytes(paramObject, paramEncoder);
  }
  
  protected void writeString(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    Object localObject = paramObject;
    if (paramSchema.getProp("java-class") != null) {
      localObject = paramObject.toString();
    }
    writeString(localObject, paramEncoder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/reflect/ReflectDatumWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */