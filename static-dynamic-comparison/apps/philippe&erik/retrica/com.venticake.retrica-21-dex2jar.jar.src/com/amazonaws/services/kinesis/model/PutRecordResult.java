package com.amazonaws.services.kinesis.model;

import java.io.Serializable;

public class PutRecordResult
  implements Serializable
{
  private String sequenceNumber;
  private String shardId;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    int i;
    label47:
    label56:
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (!(paramObject instanceof PutRecordResult));
        paramObject = (PutRecordResult)paramObject;
        if (((PutRecordResult)paramObject).getShardId() != null) {
          break;
        }
        i = 1;
        if (getShardId() != null) {
          break label151;
        }
        j = 1;
        bool1 = bool2;
      } while ((i ^ j) != 0);
      if (((PutRecordResult)paramObject).getShardId() == null) {
        break;
      }
      bool1 = bool2;
    } while (!((PutRecordResult)paramObject).getShardId().equals(getShardId()));
    if (((PutRecordResult)paramObject).getSequenceNumber() == null)
    {
      i = 1;
      label100:
      if (getSequenceNumber() != null) {
        break label161;
      }
    }
    label151:
    label161:
    for (int j = 1;; j = 0)
    {
      bool1 = bool2;
      if ((i ^ j) != 0) {
        break;
      }
      if (((PutRecordResult)paramObject).getSequenceNumber() != null)
      {
        bool1 = bool2;
        if (!((PutRecordResult)paramObject).getSequenceNumber().equals(getSequenceNumber())) {
          break;
        }
      }
      return true;
      i = 0;
      break label47;
      j = 0;
      break label56;
      i = 0;
      break label100;
    }
  }
  
  public String getSequenceNumber()
  {
    return this.sequenceNumber;
  }
  
  public String getShardId()
  {
    return this.shardId;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (getShardId() == null)
    {
      i = 0;
      if (getSequenceNumber() != null) {
        break label39;
      }
    }
    for (;;)
    {
      return (i + 31) * 31 + j;
      i = getShardId().hashCode();
      break;
      label39:
      j = getSequenceNumber().hashCode();
    }
  }
  
  public void setSequenceNumber(String paramString)
  {
    this.sequenceNumber = paramString;
  }
  
  public void setShardId(String paramString)
  {
    this.shardId = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    if (getShardId() != null) {
      localStringBuilder.append("ShardId: " + getShardId() + ",");
    }
    if (getSequenceNumber() != null) {
      localStringBuilder.append("SequenceNumber: " + getSequenceNumber());
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/PutRecordResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */