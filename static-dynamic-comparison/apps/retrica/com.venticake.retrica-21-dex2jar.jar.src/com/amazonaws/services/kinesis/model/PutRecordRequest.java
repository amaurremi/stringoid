package com.amazonaws.services.kinesis.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class PutRecordRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private ByteBuffer data;
  private String explicitHashKey;
  private String partitionKey;
  private String sequenceNumberForOrdering;
  private String streamName;
  
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
    label100:
    label109:
    label153:
    label162:
    label206:
    label215:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
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
                    } while (!(paramObject instanceof PutRecordRequest));
                    paramObject = (PutRecordRequest)paramObject;
                    if (((PutRecordRequest)paramObject).getStreamName() != null) {
                      break;
                    }
                    i = 1;
                    if (getStreamName() != null) {
                      break label310;
                    }
                    j = 1;
                    bool1 = bool2;
                  } while ((i ^ j) != 0);
                  if (((PutRecordRequest)paramObject).getStreamName() == null) {
                    break;
                  }
                  bool1 = bool2;
                } while (!((PutRecordRequest)paramObject).getStreamName().equals(getStreamName()));
                if (((PutRecordRequest)paramObject).getData() != null) {
                  break label315;
                }
                i = 1;
                if (getData() != null) {
                  break label320;
                }
                j = 1;
                bool1 = bool2;
              } while ((i ^ j) != 0);
              if (((PutRecordRequest)paramObject).getData() == null) {
                break;
              }
              bool1 = bool2;
            } while (!((PutRecordRequest)paramObject).getData().equals(getData()));
            if (((PutRecordRequest)paramObject).getPartitionKey() != null) {
              break label325;
            }
            i = 1;
            if (getPartitionKey() != null) {
              break label330;
            }
            j = 1;
            bool1 = bool2;
          } while ((i ^ j) != 0);
          if (((PutRecordRequest)paramObject).getPartitionKey() == null) {
            break;
          }
          bool1 = bool2;
        } while (!((PutRecordRequest)paramObject).getPartitionKey().equals(getPartitionKey()));
        if (((PutRecordRequest)paramObject).getExplicitHashKey() != null) {
          break label335;
        }
        i = 1;
        if (getExplicitHashKey() != null) {
          break label340;
        }
        j = 1;
        bool1 = bool2;
      } while ((i ^ j) != 0);
      if (((PutRecordRequest)paramObject).getExplicitHashKey() == null) {
        break;
      }
      bool1 = bool2;
    } while (!((PutRecordRequest)paramObject).getExplicitHashKey().equals(getExplicitHashKey()));
    if (((PutRecordRequest)paramObject).getSequenceNumberForOrdering() == null)
    {
      i = 1;
      label259:
      if (getSequenceNumberForOrdering() != null) {
        break label350;
      }
    }
    label310:
    label315:
    label320:
    label325:
    label330:
    label335:
    label340:
    label350:
    for (int j = 1;; j = 0)
    {
      bool1 = bool2;
      if ((i ^ j) != 0) {
        break;
      }
      if (((PutRecordRequest)paramObject).getSequenceNumberForOrdering() != null)
      {
        bool1 = bool2;
        if (!((PutRecordRequest)paramObject).getSequenceNumberForOrdering().equals(getSequenceNumberForOrdering())) {
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
      j = 0;
      break label109;
      i = 0;
      break label153;
      j = 0;
      break label162;
      i = 0;
      break label206;
      j = 0;
      break label215;
      i = 0;
      break label259;
    }
  }
  
  public ByteBuffer getData()
  {
    return this.data;
  }
  
  public String getExplicitHashKey()
  {
    return this.explicitHashKey;
  }
  
  public String getPartitionKey()
  {
    return this.partitionKey;
  }
  
  public String getSequenceNumberForOrdering()
  {
    return this.sequenceNumberForOrdering;
  }
  
  public String getStreamName()
  {
    return this.streamName;
  }
  
  public int hashCode()
  {
    int n = 0;
    int i;
    int j;
    label21:
    int k;
    label30:
    int m;
    if (getStreamName() == null)
    {
      i = 0;
      if (getData() != null) {
        break label85;
      }
      j = 0;
      if (getPartitionKey() != null) {
        break label96;
      }
      k = 0;
      if (getExplicitHashKey() != null) {
        break label107;
      }
      m = 0;
      label40:
      if (getSequenceNumberForOrdering() != null) {
        break label119;
      }
    }
    for (;;)
    {
      return (m + (k + (j + (i + 31) * 31) * 31) * 31) * 31 + n;
      i = getStreamName().hashCode();
      break;
      label85:
      j = getData().hashCode();
      break label21;
      label96:
      k = getPartitionKey().hashCode();
      break label30;
      label107:
      m = getExplicitHashKey().hashCode();
      break label40;
      label119:
      n = getSequenceNumberForOrdering().hashCode();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    if (getStreamName() != null) {
      localStringBuilder.append("StreamName: " + getStreamName() + ",");
    }
    if (getData() != null) {
      localStringBuilder.append("Data: " + getData() + ",");
    }
    if (getPartitionKey() != null) {
      localStringBuilder.append("PartitionKey: " + getPartitionKey() + ",");
    }
    if (getExplicitHashKey() != null) {
      localStringBuilder.append("ExplicitHashKey: " + getExplicitHashKey() + ",");
    }
    if (getSequenceNumberForOrdering() != null) {
      localStringBuilder.append("SequenceNumberForOrdering: " + getSequenceNumberForOrdering());
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public PutRecordRequest withData(ByteBuffer paramByteBuffer)
  {
    this.data = paramByteBuffer;
    return this;
  }
  
  public PutRecordRequest withExplicitHashKey(String paramString)
  {
    this.explicitHashKey = paramString;
    return this;
  }
  
  public PutRecordRequest withPartitionKey(String paramString)
  {
    this.partitionKey = paramString;
    return this;
  }
  
  public PutRecordRequest withSequenceNumberForOrdering(String paramString)
  {
    this.sequenceNumberForOrdering = paramString;
    return this;
  }
  
  public PutRecordRequest withStreamName(String paramString)
  {
    this.streamName = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/PutRecordRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */