package com.google.tagmanager.proto;

import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.ByteString.Output;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.ObjectStreamException;

public final class MutableResource
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class ResourceWithMetadata
    extends GeneratedMutableMessageLite<ResourceWithMetadata>
    implements MutableMessageLite
  {
    public static Parser<ResourceWithMetadata> PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
    public static final int RESOURCE_FIELD_NUMBER = 2;
    public static final int TIME_STAMP_FIELD_NUMBER = 1;
    private static final ResourceWithMetadata defaultInstance;
    private static volatile MessageLite immutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private MutableServing.Resource resource_;
    private long timeStamp_;
    
    static
    {
      defaultInstance = new ResourceWithMetadata(true);
      defaultInstance.initFields();
      defaultInstance.makeImmutable();
    }
    
    private ResourceWithMetadata()
    {
      initFields();
    }
    
    private ResourceWithMetadata(boolean paramBoolean) {}
    
    private void ensureResourceInitialized()
    {
      if (this.resource_ == MutableServing.Resource.getDefaultInstance()) {
        this.resource_ = MutableServing.Resource.newMessage();
      }
    }
    
    public static ResourceWithMetadata getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields()
    {
      this.resource_ = MutableServing.Resource.getDefaultInstance();
    }
    
    public static ResourceWithMetadata newMessage()
    {
      return new ResourceWithMetadata();
    }
    
    public ResourceWithMetadata clear()
    {
      assertMutable();
      super.clear();
      this.timeStamp_ = 0L;
      this.bitField0_ &= 0xFFFFFFFE;
      if (this.resource_ != MutableServing.Resource.getDefaultInstance()) {
        this.resource_.clear();
      }
      this.bitField0_ &= 0xFFFFFFFD;
      return this;
    }
    
    public ResourceWithMetadata clearResource()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFD;
      if (this.resource_ != MutableServing.Resource.getDefaultInstance()) {
        this.resource_.clear();
      }
      return this;
    }
    
    public ResourceWithMetadata clearTimeStamp()
    {
      assertMutable();
      this.bitField0_ &= 0xFFFFFFFE;
      this.timeStamp_ = 0L;
      return this;
    }
    
    public ResourceWithMetadata clone()
    {
      return newMessageForType().mergeFrom(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof ResourceWithMetadata)) {
        return super.equals(paramObject);
      }
      paramObject = (ResourceWithMetadata)paramObject;
      int i;
      int j;
      label69:
      boolean bool1;
      if ((1 != 0) && (hasTimeStamp() == ((ResourceWithMetadata)paramObject).hasTimeStamp()))
      {
        i = 1;
        j = i;
        if (hasTimeStamp())
        {
          if ((i == 0) || (getTimeStamp() != ((ResourceWithMetadata)paramObject).getTimeStamp())) {
            break label128;
          }
          j = 1;
        }
        if ((j == 0) || (hasResource() != ((ResourceWithMetadata)paramObject).hasResource())) {
          break label133;
        }
        bool1 = true;
        label87:
        bool2 = bool1;
        if (hasResource()) {
          if ((!bool1) || (!getResource().equals(((ResourceWithMetadata)paramObject).getResource()))) {
            break label139;
          }
        }
      }
      label128:
      label133:
      label139:
      for (boolean bool2 = true;; bool2 = false)
      {
        return bool2;
        i = 0;
        break;
        j = 0;
        break label69;
        bool1 = false;
        break label87;
      }
    }
    
    public final ResourceWithMetadata getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public MutableServing.Resource getMutableResource()
    {
      assertMutable();
      ensureResourceInitialized();
      this.bitField0_ |= 0x2;
      return this.resource_;
    }
    
    public Parser<ResourceWithMetadata> getParserForType()
    {
      return PARSER;
    }
    
    public MutableServing.Resource getResource()
    {
      return this.resource_;
    }
    
    public int getSerializedSize()
    {
      int i = 0 + CodedOutputStream.computeInt64Size(1, this.timeStamp_) + CodedOutputStream.computeMessageSize(2, this.resource_) + this.unknownFields.size();
      this.cachedSize = i;
      return i;
    }
    
    public long getTimeStamp()
    {
      return this.timeStamp_;
    }
    
    public boolean hasResource()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public boolean hasTimeStamp()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public int hashCode()
    {
      int i = 41;
      if (hasTimeStamp()) {
        i = 80454 + Internal.hashLong(getTimeStamp());
      }
      int j = i;
      if (hasResource()) {
        j = (i * 37 + 2) * 53 + getResource().hashCode();
      }
      return j * 29 + this.unknownFields.hashCode();
    }
    
    protected MessageLite internalImmutableDefault()
    {
      if (immutableDefault == null) {
        immutableDefault = internalImmutableDefault("com.google.tagmanager.proto.Resource$ResourceWithMetadata");
      }
      return immutableDefault;
    }
    
    public final boolean isInitialized()
    {
      if (!hasTimeStamp()) {}
      while ((!hasResource()) || (!getResource().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public ResourceWithMetadata mergeFrom(ResourceWithMetadata paramResourceWithMetadata)
    {
      if (this == paramResourceWithMetadata) {
        throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
      }
      assertMutable();
      if (paramResourceWithMetadata == getDefaultInstance()) {
        return this;
      }
      if (paramResourceWithMetadata.hasTimeStamp()) {
        setTimeStamp(paramResourceWithMetadata.getTimeStamp());
      }
      if (paramResourceWithMetadata.hasResource())
      {
        ensureResourceInitialized();
        this.resource_.mergeFrom(paramResourceWithMetadata.getResource());
        this.bitField0_ |= 0x2;
      }
      this.unknownFields = this.unknownFields.concat(paramResourceWithMetadata.unknownFields);
      return this;
    }
    
    public boolean mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    {
      assertMutable();
      try
      {
        ByteString.Output localOutput = ByteString.newOutput();
        CodedOutputStream localCodedOutputStream = CodedOutputStream.newInstance(localOutput);
        int i = 0;
        for (;;)
        {
          int j;
          if (i == 0) {
            j = paramCodedInputStream.readTag();
          }
          switch (j)
          {
          case 8: 
          case 18: 
          default: 
            for (;;)
            {
              if (parseUnknownField(paramCodedInputStream, localCodedOutputStream, paramExtensionRegistryLite, j)) {
                break label159;
              }
              i = 1;
              break;
              this.bitField0_ |= 0x1;
              this.timeStamp_ = paramCodedInputStream.readInt64();
              break;
              if (this.resource_ == MutableServing.Resource.getDefaultInstance()) {
                this.resource_ = MutableServing.Resource.newMessage();
              }
              this.bitField0_ |= 0x2;
              paramCodedInputStream.readMessage(this.resource_, paramExtensionRegistryLite);
              break;
              localCodedOutputStream.flush();
              this.unknownFields = localOutput.toByteString();
              return true;
            }
            break;
          case 0: 
            label159:
            i = 1;
          }
        }
        return false;
      }
      catch (IOException paramCodedInputStream) {}
    }
    
    public ResourceWithMetadata newMessageForType()
    {
      return new ResourceWithMetadata();
    }
    
    public ResourceWithMetadata setResource(MutableServing.Resource paramResource)
    {
      assertMutable();
      if (paramResource == null) {
        throw new NullPointerException();
      }
      this.bitField0_ |= 0x2;
      this.resource_ = paramResource;
      return this;
    }
    
    public ResourceWithMetadata setTimeStamp(long paramLong)
    {
      assertMutable();
      this.bitField0_ |= 0x1;
      this.timeStamp_ = paramLong;
      return this;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeToWithCachedSizes(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      int i = paramCodedOutputStream.getTotalBytesWritten();
      paramCodedOutputStream.writeInt64(1, this.timeStamp_);
      paramCodedOutputStream.writeMessageWithCachedSizes(2, this.resource_);
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
      int j = paramCodedOutputStream.getTotalBytesWritten();
      if (getCachedSize() != j - i) {
        throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/proto/MutableResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */