package com.mongodb.util;

import com.mongodb.Bytes;
import java.util.Iterator;
import java.util.List;
import org.bson.util.ClassMap;

class ClassMapBasedObjectSerializer
  extends AbstractObjectSerializer
{
  private ClassMap<ObjectSerializer> _serializers = new ClassMap();
  
  void addObjectSerializer(Class paramClass, ObjectSerializer paramObjectSerializer)
  {
    this._serializers.put(paramClass, paramObjectSerializer);
  }
  
  public void serialize(Object paramObject, StringBuilder paramStringBuilder)
  {
    Object localObject2 = Bytes.applyEncodingHooks(paramObject);
    if (localObject2 == null)
    {
      paramStringBuilder.append(" null ");
      return;
    }
    paramObject = null;
    Iterator localIterator = ClassMap.getAncestry(localObject2.getClass()).iterator();
    while (localIterator.hasNext())
    {
      paramObject = (Class)localIterator.next();
      localObject1 = (ObjectSerializer)this._serializers.get(paramObject);
      paramObject = localObject1;
      if (localObject1 != null) {
        paramObject = localObject1;
      }
    }
    Object localObject1 = paramObject;
    if (paramObject == null)
    {
      localObject1 = paramObject;
      if (localObject2.getClass().isArray()) {
        localObject1 = (ObjectSerializer)this._serializers.get(Object[].class);
      }
    }
    if (localObject1 == null) {
      throw new RuntimeException("json can't serialize type : " + localObject2.getClass());
    }
    ((ObjectSerializer)localObject1).serialize(localObject2, paramStringBuilder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/ClassMapBasedObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */