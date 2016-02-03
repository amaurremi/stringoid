package com.google.tagmanager.proto;

import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.containertag.proto.Serving.SupplementedResource;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract interface Resource
{
  public static final class ResourceWithMetadata
    extends ExtendableMessageNano
  {
    public static final ResourceWithMetadata[] EMPTY_ARRAY = new ResourceWithMetadata[0];
    public Serving.Resource resource = null;
    public Serving.SupplementedResource supplementedResource = null;
    public long timeStamp = 0L;
    
    public static ResourceWithMetadata parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new ResourceWithMetadata().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static ResourceWithMetadata parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (ResourceWithMetadata)MessageNano.mergeFrom(new ResourceWithMetadata(), paramArrayOfByte);
    }
    
    public final ResourceWithMetadata clear()
    {
      this.timeStamp = 0L;
      this.resource = null;
      this.supplementedResource = null;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label61:
      do
      {
        return true;
        if (!(paramObject instanceof ResourceWithMetadata)) {
          return false;
        }
        paramObject = (ResourceWithMetadata)paramObject;
        if (this.timeStamp != ((ResourceWithMetadata)paramObject).timeStamp) {
          break;
        }
        if (this.resource != null) {
          break label77;
        }
        if (((ResourceWithMetadata)paramObject).resource != null) {
          break;
        }
        if (this.supplementedResource != null) {
          break label94;
        }
        if (((ResourceWithMetadata)paramObject).supplementedResource != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label111;
        }
      } while (((ResourceWithMetadata)paramObject).unknownFieldData == null);
      label77:
      label94:
      label111:
      while (!this.unknownFieldData.equals(((ResourceWithMetadata)paramObject).unknownFieldData))
      {
        do
        {
          do
          {
            return false;
          } while (!this.resource.equals(((ResourceWithMetadata)paramObject).resource));
          break;
        } while (!this.supplementedResource.equals(((ResourceWithMetadata)paramObject).supplementedResource));
        break label61;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int j = 0 + CodedOutputByteBufferNano.computeInt64Size(1, this.timeStamp);
      int i = j;
      if (this.resource != null) {
        i = j + CodedOutputByteBufferNano.computeMessageSize(2, this.resource);
      }
      j = i;
      if (this.supplementedResource != null) {
        j = i + CodedOutputByteBufferNano.computeMessageSize(3, this.supplementedResource);
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = (int)(this.timeStamp ^ this.timeStamp >>> 32);
      int i;
      int j;
      if (this.resource == null)
      {
        i = 0;
        if (this.supplementedResource != null) {
          break label75;
        }
        j = 0;
        label35:
        if (this.unknownFieldData != null) {
          break label86;
        }
      }
      for (;;)
      {
        return (((m + 527) * 31 + i) * 31 + j) * 31 + k;
        i = this.resource.hashCode();
        break;
        label75:
        j = this.supplementedResource.hashCode();
        break label35;
        label86:
        k = this.unknownFieldData.hashCode();
      }
    }
    
    public ResourceWithMetadata mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputByteBufferNano.readTag();
        switch (i)
        {
        default: 
          if (this.unknownFieldData == null) {
            this.unknownFieldData = new ArrayList();
          }
          if (WireFormatNano.storeUnknownField(this.unknownFieldData, paramCodedInputByteBufferNano, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.timeStamp = paramCodedInputByteBufferNano.readInt64();
          break;
        case 18: 
          this.resource = new Serving.Resource();
          paramCodedInputByteBufferNano.readMessage(this.resource);
          break;
        case 26: 
          this.supplementedResource = new Serving.SupplementedResource();
          paramCodedInputByteBufferNano.readMessage(this.supplementedResource);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      paramCodedOutputByteBufferNano.writeInt64(1, this.timeStamp);
      if (this.resource != null) {
        paramCodedOutputByteBufferNano.writeMessage(2, this.resource);
      }
      if (this.supplementedResource != null) {
        paramCodedOutputByteBufferNano.writeMessage(3, this.supplementedResource);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/proto/Resource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */