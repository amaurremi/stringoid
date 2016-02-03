package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;

public abstract class SpecificRecordBase
  implements SpecificRecord, Comparable<SpecificRecord>
{
  public int compareTo(SpecificRecord paramSpecificRecord)
  {
    return SpecificData.get().compare(this, paramSpecificRecord, getSchema());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof SpecificRecord)) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
    } while (compareTo((SpecificRecord)paramObject) == 0);
    return false;
  }
  
  public abstract Object get(int paramInt);
  
  public abstract Schema getSchema();
  
  public int hashCode()
  {
    return SpecificData.get().hashCode(this, getSchema());
  }
  
  public abstract void put(int paramInt, Object paramObject);
  
  public String toString()
  {
    return SpecificData.get().toString(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/specific/SpecificRecordBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */