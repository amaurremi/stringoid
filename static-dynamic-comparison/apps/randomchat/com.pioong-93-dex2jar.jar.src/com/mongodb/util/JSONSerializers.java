package com.mongodb.util;

import com.mongodb.BasicDBObject;
import com.mongodb.Bytes;
import com.mongodb.DBObject;
import com.mongodb.DBRefBase;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.bson.types.BSONTimestamp;
import org.bson.types.Binary;
import org.bson.types.Code;
import org.bson.types.CodeWScope;
import org.bson.types.MaxKey;
import org.bson.types.MinKey;
import org.bson.types.ObjectId;

public class JSONSerializers
{
  static ClassMapBasedObjectSerializer addCommonSerializers()
  {
    ClassMapBasedObjectSerializer localClassMapBasedObjectSerializer = new ClassMapBasedObjectSerializer();
    localClassMapBasedObjectSerializer.addObjectSerializer(Object[].class, new ObjectArraySerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(Boolean.class, new ToStringSerializer(null));
    localClassMapBasedObjectSerializer.addObjectSerializer(Code.class, new CodeSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(CodeWScope.class, new CodeWScopeSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(DBObject.class, new DBObjectSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(DBRefBase.class, new DBRefBaseSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(Iterable.class, new IterableSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(Map.class, new MapSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(MaxKey.class, new MaxKeySerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(MinKey.class, new MinKeySerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(Number.class, new ToStringSerializer(null));
    localClassMapBasedObjectSerializer.addObjectSerializer(ObjectId.class, new ObjectIdSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(Pattern.class, new PatternSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(String.class, new StringSerializer(null));
    localClassMapBasedObjectSerializer.addObjectSerializer(UUID.class, new UUIDSerializer(localClassMapBasedObjectSerializer));
    return localClassMapBasedObjectSerializer;
  }
  
  public static ObjectSerializer getLegacy()
  {
    ClassMapBasedObjectSerializer localClassMapBasedObjectSerializer = addCommonSerializers();
    localClassMapBasedObjectSerializer.addObjectSerializer(Date.class, new LegacyDateSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(BSONTimestamp.class, new LegacyBSONTimestampSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(Binary.class, new LegacyBinarySerializer(null));
    localClassMapBasedObjectSerializer.addObjectSerializer(byte[].class, new LegacyBinarySerializer(null));
    return localClassMapBasedObjectSerializer;
  }
  
  public static ObjectSerializer getStrict()
  {
    ClassMapBasedObjectSerializer localClassMapBasedObjectSerializer = addCommonSerializers();
    localClassMapBasedObjectSerializer.addObjectSerializer(Date.class, new DateSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(BSONTimestamp.class, new BSONTimestampSerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(Binary.class, new BinarySerializer(localClassMapBasedObjectSerializer));
    localClassMapBasedObjectSerializer.addObjectSerializer(byte[].class, new ByteArraySerializer(localClassMapBasedObjectSerializer));
    return localClassMapBasedObjectSerializer;
  }
  
  private static class BSONTimestampSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    BSONTimestampSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      Object localObject = (BSONTimestamp)paramObject;
      paramObject = new BasicDBObject();
      ((BasicDBObject)paramObject).put("t", Integer.valueOf(((BSONTimestamp)localObject).getTime()));
      ((BasicDBObject)paramObject).put("i", Integer.valueOf(((BSONTimestamp)localObject).getInc()));
      localObject = new BasicDBObject();
      ((BasicDBObject)localObject).put("$timestamp", paramObject);
      this.serializer.serialize(localObject, paramStringBuilder);
    }
  }
  
  private static class BinarySerializer
    extends JSONSerializers.BinarySerializerBase
  {
    BinarySerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (Binary)paramObject;
      serialize(((Binary)paramObject).getData(), ((Binary)paramObject).getType(), paramStringBuilder);
    }
  }
  
  private static abstract class BinarySerializerBase
    extends JSONSerializers.CompoundObjectSerializer
  {
    BinarySerializerBase(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    protected void serialize(byte[] paramArrayOfByte, byte paramByte, StringBuilder paramStringBuilder)
    {
      BasicDBObject localBasicDBObject = new BasicDBObject();
      localBasicDBObject.put("$binary", new Base64Codec().encode(paramArrayOfByte));
      localBasicDBObject.put("$type", Byte.valueOf(paramByte));
      this.serializer.serialize(localBasicDBObject, paramStringBuilder);
    }
  }
  
  private static class ByteArraySerializer
    extends JSONSerializers.BinarySerializerBase
  {
    ByteArraySerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      serialize((byte[])paramObject, (byte)0, paramStringBuilder);
    }
  }
  
  private static class CodeSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    CodeSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (Code)paramObject;
      BasicDBObject localBasicDBObject = new BasicDBObject();
      localBasicDBObject.put("$code", ((Code)paramObject).getCode());
      this.serializer.serialize(localBasicDBObject, paramStringBuilder);
    }
  }
  
  private static class CodeWScopeSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    CodeWScopeSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (CodeWScope)paramObject;
      BasicDBObject localBasicDBObject = new BasicDBObject();
      localBasicDBObject.put("$code", ((CodeWScope)paramObject).getCode());
      localBasicDBObject.put("$scope", ((CodeWScope)paramObject).getScope());
      this.serializer.serialize(localBasicDBObject, paramStringBuilder);
    }
  }
  
  private static abstract class CompoundObjectSerializer
    extends AbstractObjectSerializer
  {
    protected final ObjectSerializer serializer;
    
    CompoundObjectSerializer(ObjectSerializer paramObjectSerializer)
    {
      this.serializer = paramObjectSerializer;
    }
  }
  
  private static class DBObjectSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    DBObjectSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      int i = 1;
      paramStringBuilder.append("{ ");
      paramObject = (DBObject)paramObject;
      Iterator localIterator = ((DBObject)paramObject).keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          JSON.string(paramStringBuilder, str);
          paramStringBuilder.append(" : ");
          this.serializer.serialize(((DBObject)paramObject).get(str), paramStringBuilder);
          break;
          paramStringBuilder.append(" , ");
        }
      }
      paramStringBuilder.append("}");
    }
  }
  
  private static class DBRefBaseSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    DBRefBaseSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (DBRefBase)paramObject;
      BasicDBObject localBasicDBObject = new BasicDBObject();
      localBasicDBObject.put("$ref", ((DBRefBase)paramObject).getRef());
      localBasicDBObject.put("$id", ((DBRefBase)paramObject).getId());
      this.serializer.serialize(localBasicDBObject, paramStringBuilder);
    }
  }
  
  private static class DateSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    DateSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (Date)paramObject;
      this.serializer.serialize(new BasicDBObject("$date", Long.valueOf(((Date)paramObject).getTime())), paramStringBuilder);
    }
  }
  
  private static class IterableSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    IterableSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      int i = 1;
      paramStringBuilder.append("[ ");
      paramObject = ((Iterable)paramObject).iterator();
      if (((Iterator)paramObject).hasNext())
      {
        Object localObject = ((Iterator)paramObject).next();
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          this.serializer.serialize(localObject, paramStringBuilder);
          break;
          paramStringBuilder.append(" , ");
        }
      }
      paramStringBuilder.append("]");
    }
  }
  
  private static class LegacyBSONTimestampSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    LegacyBSONTimestampSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (BSONTimestamp)paramObject;
      BasicDBObject localBasicDBObject = new BasicDBObject();
      localBasicDBObject.put("$ts", Integer.valueOf(((BSONTimestamp)paramObject).getTime()));
      localBasicDBObject.put("$inc", Integer.valueOf(((BSONTimestamp)paramObject).getInc()));
      this.serializer.serialize(localBasicDBObject, paramStringBuilder);
    }
  }
  
  private static class LegacyBinarySerializer
    extends AbstractObjectSerializer
  {
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("<Binary Data>");
    }
  }
  
  private static class LegacyDateSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    LegacyDateSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (Date)paramObject;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      localSimpleDateFormat.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
      this.serializer.serialize(new BasicDBObject("$date", localSimpleDateFormat.format((Date)paramObject)), paramStringBuilder);
    }
  }
  
  private static class MapSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    MapSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      int i = 1;
      paramStringBuilder.append("{ ");
      paramObject = ((Map)paramObject).entrySet().iterator();
      if (((Iterator)paramObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          JSON.string(paramStringBuilder, localEntry.getKey().toString());
          paramStringBuilder.append(" : ");
          this.serializer.serialize(localEntry.getValue(), paramStringBuilder);
          break;
          paramStringBuilder.append(" , ");
        }
      }
      paramStringBuilder.append("}");
    }
  }
  
  private static class MaxKeySerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    MaxKeySerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      this.serializer.serialize(new BasicDBObject("$maxKey", Integer.valueOf(1)), paramStringBuilder);
    }
  }
  
  private static class MinKeySerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    MinKeySerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      this.serializer.serialize(new BasicDBObject("$minKey", Integer.valueOf(1)), paramStringBuilder);
    }
  }
  
  private static class ObjectArraySerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    ObjectArraySerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("[ ");
      int i = 0;
      while (i < Array.getLength(paramObject))
      {
        if (i > 0) {
          paramStringBuilder.append(" , ");
        }
        this.serializer.serialize(Array.get(paramObject, i), paramStringBuilder);
        i += 1;
      }
      paramStringBuilder.append("]");
    }
  }
  
  private static class ObjectIdSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    ObjectIdSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      this.serializer.serialize(new BasicDBObject("$oid", paramObject.toString()), paramStringBuilder);
    }
  }
  
  private static class PatternSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    PatternSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      BasicDBObject localBasicDBObject = new BasicDBObject();
      localBasicDBObject.put("$regex", paramObject.toString());
      if (((Pattern)paramObject).flags() != 0) {
        localBasicDBObject.put("$options", Bytes.regexFlags(((Pattern)paramObject).flags()));
      }
      this.serializer.serialize(localBasicDBObject, paramStringBuilder);
    }
  }
  
  private static class StringSerializer
    extends AbstractObjectSerializer
  {
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      JSON.string(paramStringBuilder, (String)paramObject);
    }
  }
  
  private static class ToStringSerializer
    extends AbstractObjectSerializer
  {
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(paramObject.toString());
    }
  }
  
  private static class UUIDSerializer
    extends JSONSerializers.CompoundObjectSerializer
  {
    UUIDSerializer(ObjectSerializer paramObjectSerializer)
    {
      super();
    }
    
    public void serialize(Object paramObject, StringBuilder paramStringBuilder)
    {
      paramObject = (UUID)paramObject;
      BasicDBObject localBasicDBObject = new BasicDBObject();
      localBasicDBObject.put("$uuid", ((UUID)paramObject).toString());
      this.serializer.serialize(localBasicDBObject, paramStringBuilder);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/JSONSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */