package com.google.tagmanager.proto;

import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.containertag.proto.Serving.Resource.Builder;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.Builder;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

public final class Resource
{
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class ResourceWithMetadata
    extends GeneratedMessageLite
    implements Resource.ResourceWithMetadataOrBuilder
  {
    public static Parser<ResourceWithMetadata> PARSER = new AbstractParser()
    {
      public Resource.ResourceWithMetadata parsePartialFrom(CodedInputStream paramAnonymousCodedInputStream, ExtensionRegistryLite paramAnonymousExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return new Resource.ResourceWithMetadata(paramAnonymousCodedInputStream, paramAnonymousExtensionRegistryLite, null);
      }
    };
    public static final int RESOURCE_FIELD_NUMBER = 2;
    public static final int TIME_STAMP_FIELD_NUMBER = 1;
    private static final ResourceWithMetadata defaultInstance;
    private static volatile MutableMessageLite mutableDefault = null;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private Serving.Resource resource_;
    private long timeStamp_;
    private final ByteString unknownFields;
    
    static
    {
      defaultInstance = new ResourceWithMetadata(true);
      defaultInstance.initFields();
    }
    
    /* Error */
    private ResourceWithMetadata(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 63	com/google/tagmanager/protobuf/GeneratedMessageLite:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 65	com/google/tagmanager/proto/Resource$ResourceWithMetadata:memoizedIsInitialized	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 67	com/google/tagmanager/proto/Resource$ResourceWithMetadata:memoizedSerializedSize	I
      //   14: aload_0
      //   15: invokespecial 56	com/google/tagmanager/proto/Resource$ResourceWithMetadata:initFields	()V
      //   18: invokestatic 73	com/google/tagmanager/protobuf/ByteString:newOutput	()Lcom/google/tagmanager/protobuf/ByteString$Output;
      //   21: astore 6
      //   23: aload 6
      //   25: invokestatic 79	com/google/tagmanager/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/google/tagmanager/protobuf/CodedOutputStream;
      //   28: astore 7
      //   30: iconst_0
      //   31: istore_3
      //   32: iload_3
      //   33: ifne +205 -> 238
      //   36: aload_1
      //   37: invokevirtual 85	com/google/tagmanager/protobuf/CodedInputStream:readTag	()I
      //   40: istore 4
      //   42: iload 4
      //   44: lookupswitch	default:+263->307, 0:+266->310, 8:+54->98, 18:+103->147
      //   80: aload_0
      //   81: aload_1
      //   82: aload 7
      //   84: aload_2
      //   85: iload 4
      //   87: invokevirtual 89	com/google/tagmanager/proto/Resource$ResourceWithMetadata:parseUnknownField	(Lcom/google/tagmanager/protobuf/CodedInputStream;Lcom/google/tagmanager/protobuf/CodedOutputStream;Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;I)Z
      //   90: ifne -58 -> 32
      //   93: iconst_1
      //   94: istore_3
      //   95: goto -63 -> 32
      //   98: aload_0
      //   99: aload_0
      //   100: getfield 91	com/google/tagmanager/proto/Resource$ResourceWithMetadata:bitField0_	I
      //   103: iconst_1
      //   104: ior
      //   105: putfield 91	com/google/tagmanager/proto/Resource$ResourceWithMetadata:bitField0_	I
      //   108: aload_0
      //   109: aload_1
      //   110: invokevirtual 95	com/google/tagmanager/protobuf/CodedInputStream:readInt64	()J
      //   113: putfield 97	com/google/tagmanager/proto/Resource$ResourceWithMetadata:timeStamp_	J
      //   116: goto -84 -> 32
      //   119: astore_1
      //   120: aload_1
      //   121: aload_0
      //   122: invokevirtual 101	com/google/tagmanager/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/tagmanager/protobuf/MessageLite;)Lcom/google/tagmanager/protobuf/InvalidProtocolBufferException;
      //   125: athrow
      //   126: astore_1
      //   127: aload 7
      //   129: invokevirtual 104	com/google/tagmanager/protobuf/CodedOutputStream:flush	()V
      //   132: aload_0
      //   133: aload 6
      //   135: invokevirtual 110	com/google/tagmanager/protobuf/ByteString$Output:toByteString	()Lcom/google/tagmanager/protobuf/ByteString;
      //   138: putfield 112	com/google/tagmanager/proto/Resource$ResourceWithMetadata:unknownFields	Lcom/google/tagmanager/protobuf/ByteString;
      //   141: aload_0
      //   142: invokevirtual 115	com/google/tagmanager/proto/Resource$ResourceWithMetadata:makeExtensionsImmutable	()V
      //   145: aload_1
      //   146: athrow
      //   147: aconst_null
      //   148: astore 5
      //   150: aload_0
      //   151: getfield 91	com/google/tagmanager/proto/Resource$ResourceWithMetadata:bitField0_	I
      //   154: iconst_2
      //   155: iand
      //   156: iconst_2
      //   157: if_icmpne +12 -> 169
      //   160: aload_0
      //   161: getfield 117	com/google/tagmanager/proto/Resource$ResourceWithMetadata:resource_	Lcom/google/analytics/containertag/proto/Serving$Resource;
      //   164: invokevirtual 123	com/google/analytics/containertag/proto/Serving$Resource:toBuilder	()Lcom/google/analytics/containertag/proto/Serving$Resource$Builder;
      //   167: astore 5
      //   169: aload_0
      //   170: aload_1
      //   171: getstatic 124	com/google/analytics/containertag/proto/Serving$Resource:PARSER	Lcom/google/tagmanager/protobuf/Parser;
      //   174: aload_2
      //   175: invokevirtual 128	com/google/tagmanager/protobuf/CodedInputStream:readMessage	(Lcom/google/tagmanager/protobuf/Parser;Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;)Lcom/google/tagmanager/protobuf/MessageLite;
      //   178: checkcast 119	com/google/analytics/containertag/proto/Serving$Resource
      //   181: putfield 117	com/google/tagmanager/proto/Resource$ResourceWithMetadata:resource_	Lcom/google/analytics/containertag/proto/Serving$Resource;
      //   184: aload 5
      //   186: ifnull +22 -> 208
      //   189: aload 5
      //   191: aload_0
      //   192: getfield 117	com/google/tagmanager/proto/Resource$ResourceWithMetadata:resource_	Lcom/google/analytics/containertag/proto/Serving$Resource;
      //   195: invokevirtual 134	com/google/analytics/containertag/proto/Serving$Resource$Builder:mergeFrom	(Lcom/google/analytics/containertag/proto/Serving$Resource;)Lcom/google/analytics/containertag/proto/Serving$Resource$Builder;
      //   198: pop
      //   199: aload_0
      //   200: aload 5
      //   202: invokevirtual 138	com/google/analytics/containertag/proto/Serving$Resource$Builder:buildPartial	()Lcom/google/analytics/containertag/proto/Serving$Resource;
      //   205: putfield 117	com/google/tagmanager/proto/Resource$ResourceWithMetadata:resource_	Lcom/google/analytics/containertag/proto/Serving$Resource;
      //   208: aload_0
      //   209: aload_0
      //   210: getfield 91	com/google/tagmanager/proto/Resource$ResourceWithMetadata:bitField0_	I
      //   213: iconst_2
      //   214: ior
      //   215: putfield 91	com/google/tagmanager/proto/Resource$ResourceWithMetadata:bitField0_	I
      //   218: goto -186 -> 32
      //   221: astore_1
      //   222: new 60	com/google/tagmanager/protobuf/InvalidProtocolBufferException
      //   225: dup
      //   226: aload_1
      //   227: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
      //   230: invokespecial 145	com/google/tagmanager/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
      //   233: aload_0
      //   234: invokevirtual 101	com/google/tagmanager/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/tagmanager/protobuf/MessageLite;)Lcom/google/tagmanager/protobuf/InvalidProtocolBufferException;
      //   237: athrow
      //   238: aload 7
      //   240: invokevirtual 104	com/google/tagmanager/protobuf/CodedOutputStream:flush	()V
      //   243: aload_0
      //   244: aload 6
      //   246: invokevirtual 110	com/google/tagmanager/protobuf/ByteString$Output:toByteString	()Lcom/google/tagmanager/protobuf/ByteString;
      //   249: putfield 112	com/google/tagmanager/proto/Resource$ResourceWithMetadata:unknownFields	Lcom/google/tagmanager/protobuf/ByteString;
      //   252: aload_0
      //   253: invokevirtual 115	com/google/tagmanager/proto/Resource$ResourceWithMetadata:makeExtensionsImmutable	()V
      //   256: return
      //   257: astore_1
      //   258: aload_0
      //   259: aload 6
      //   261: invokevirtual 110	com/google/tagmanager/protobuf/ByteString$Output:toByteString	()Lcom/google/tagmanager/protobuf/ByteString;
      //   264: putfield 112	com/google/tagmanager/proto/Resource$ResourceWithMetadata:unknownFields	Lcom/google/tagmanager/protobuf/ByteString;
      //   267: goto -15 -> 252
      //   270: astore_1
      //   271: aload_0
      //   272: aload 6
      //   274: invokevirtual 110	com/google/tagmanager/protobuf/ByteString$Output:toByteString	()Lcom/google/tagmanager/protobuf/ByteString;
      //   277: putfield 112	com/google/tagmanager/proto/Resource$ResourceWithMetadata:unknownFields	Lcom/google/tagmanager/protobuf/ByteString;
      //   280: aload_1
      //   281: athrow
      //   282: astore_2
      //   283: aload_0
      //   284: aload 6
      //   286: invokevirtual 110	com/google/tagmanager/protobuf/ByteString$Output:toByteString	()Lcom/google/tagmanager/protobuf/ByteString;
      //   289: putfield 112	com/google/tagmanager/proto/Resource$ResourceWithMetadata:unknownFields	Lcom/google/tagmanager/protobuf/ByteString;
      //   292: goto -151 -> 141
      //   295: astore_1
      //   296: aload_0
      //   297: aload 6
      //   299: invokevirtual 110	com/google/tagmanager/protobuf/ByteString$Output:toByteString	()Lcom/google/tagmanager/protobuf/ByteString;
      //   302: putfield 112	com/google/tagmanager/proto/Resource$ResourceWithMetadata:unknownFields	Lcom/google/tagmanager/protobuf/ByteString;
      //   305: aload_1
      //   306: athrow
      //   307: goto -227 -> 80
      //   310: iconst_1
      //   311: istore_3
      //   312: goto -280 -> 32
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	315	0	this	ResourceWithMetadata
      //   0	315	1	paramCodedInputStream	CodedInputStream
      //   0	315	2	paramExtensionRegistryLite	ExtensionRegistryLite
      //   31	281	3	i	int
      //   40	46	4	j	int
      //   148	53	5	localBuilder	Serving.Resource.Builder
      //   21	277	6	localOutput	com.google.tagmanager.protobuf.ByteString.Output
      //   28	211	7	localCodedOutputStream	CodedOutputStream
      // Exception table:
      //   from	to	target	type
      //   36	42	119	com/google/tagmanager/protobuf/InvalidProtocolBufferException
      //   80	93	119	com/google/tagmanager/protobuf/InvalidProtocolBufferException
      //   98	116	119	com/google/tagmanager/protobuf/InvalidProtocolBufferException
      //   150	169	119	com/google/tagmanager/protobuf/InvalidProtocolBufferException
      //   169	184	119	com/google/tagmanager/protobuf/InvalidProtocolBufferException
      //   189	208	119	com/google/tagmanager/protobuf/InvalidProtocolBufferException
      //   208	218	119	com/google/tagmanager/protobuf/InvalidProtocolBufferException
      //   36	42	126	finally
      //   80	93	126	finally
      //   98	116	126	finally
      //   120	126	126	finally
      //   150	169	126	finally
      //   169	184	126	finally
      //   189	208	126	finally
      //   208	218	126	finally
      //   222	238	126	finally
      //   36	42	221	java/io/IOException
      //   80	93	221	java/io/IOException
      //   98	116	221	java/io/IOException
      //   150	169	221	java/io/IOException
      //   169	184	221	java/io/IOException
      //   189	208	221	java/io/IOException
      //   208	218	221	java/io/IOException
      //   238	243	257	java/io/IOException
      //   238	243	270	finally
      //   127	132	282	java/io/IOException
      //   127	132	295	finally
    }
    
    private ResourceWithMetadata(GeneratedMessageLite.Builder paramBuilder)
    {
      super();
      this.unknownFields = paramBuilder.getUnknownFields();
    }
    
    private ResourceWithMetadata(boolean paramBoolean)
    {
      this.unknownFields = ByteString.EMPTY;
    }
    
    public static ResourceWithMetadata getDefaultInstance()
    {
      return defaultInstance;
    }
    
    private void initFields()
    {
      this.timeStamp_ = 0L;
      this.resource_ = Serving.Resource.getDefaultInstance();
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$100();
    }
    
    public static Builder newBuilder(ResourceWithMetadata paramResourceWithMetadata)
    {
      return newBuilder().mergeFrom(paramResourceWithMetadata);
    }
    
    public static ResourceWithMetadata parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ResourceWithMetadata)PARSER.parseDelimitedFrom(paramInputStream);
    }
    
    public static ResourceWithMetadata parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ResourceWithMetadata)PARSER.parseDelimitedFrom(paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ResourceWithMetadata parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return (ResourceWithMetadata)PARSER.parseFrom(paramByteString);
    }
    
    public static ResourceWithMetadata parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ResourceWithMetadata)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
    }
    
    public static ResourceWithMetadata parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return (ResourceWithMetadata)PARSER.parseFrom(paramCodedInputStream);
    }
    
    public static ResourceWithMetadata parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ResourceWithMetadata)PARSER.parseFrom(paramCodedInputStream, paramExtensionRegistryLite);
    }
    
    public static ResourceWithMetadata parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return (ResourceWithMetadata)PARSER.parseFrom(paramInputStream);
    }
    
    public static ResourceWithMetadata parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return (ResourceWithMetadata)PARSER.parseFrom(paramInputStream, paramExtensionRegistryLite);
    }
    
    public static ResourceWithMetadata parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return (ResourceWithMetadata)PARSER.parseFrom(paramArrayOfByte);
    }
    
    public static ResourceWithMetadata parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return (ResourceWithMetadata)PARSER.parseFrom(paramArrayOfByte, paramExtensionRegistryLite);
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
    
    public ResourceWithMetadata getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public Parser<ResourceWithMetadata> getParserForType()
    {
      return PARSER;
    }
    
    public Serving.Resource getResource()
    {
      return this.resource_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = 0 + CodedOutputStream.computeInt64Size(1, this.timeStamp_);
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeMessageSize(2, this.resource_);
      }
      i = j + this.unknownFields.size();
      this.memoizedSerializedSize = i;
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
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = ResourceWithMetadata.class.hashCode() + 779;
      int i = j;
      if (hasTimeStamp()) {
        i = (j * 37 + 1) * 53 + Internal.hashLong(getTimeStamp());
      }
      j = i;
      if (hasResource()) {
        j = (i * 37 + 2) * 53 + getResource().hashCode();
      }
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected MutableMessageLite internalMutableDefault()
    {
      if (mutableDefault == null) {
        mutableDefault = internalMutableDefault("com.google.tagmanager.proto.MutableResource$ResourceWithMetadata");
      }
      return mutableDefault;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = true;
      int i = this.memoizedIsInitialized;
      if (i != -1)
      {
        if (i == 1) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      if (!hasTimeStamp())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      if (!hasResource())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      if (!getResource().isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      getSerializedSize();
      if ((this.bitField0_ & 0x1) == 1) {
        paramCodedOutputStream.writeInt64(1, this.timeStamp_);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramCodedOutputStream.writeMessage(2, this.resource_);
      }
      paramCodedOutputStream.writeRawBytes(this.unknownFields);
    }
    
    public static final class Builder
      extends GeneratedMessageLite.Builder<Resource.ResourceWithMetadata, Builder>
      implements Resource.ResourceWithMetadataOrBuilder
    {
      private int bitField0_;
      private Serving.Resource resource_ = Serving.Resource.getDefaultInstance();
      private long timeStamp_;
      
      private Builder()
      {
        maybeForceBuilderInitialization();
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      private void maybeForceBuilderInitialization() {}
      
      public Resource.ResourceWithMetadata build()
      {
        Resource.ResourceWithMetadata localResourceWithMetadata = buildPartial();
        if (!localResourceWithMetadata.isInitialized()) {
          throw newUninitializedMessageException(localResourceWithMetadata);
        }
        return localResourceWithMetadata;
      }
      
      public Resource.ResourceWithMetadata buildPartial()
      {
        Resource.ResourceWithMetadata localResourceWithMetadata = new Resource.ResourceWithMetadata(this, null);
        int k = this.bitField0_;
        int i = 0;
        if ((k & 0x1) == 1) {
          i = 0x0 | 0x1;
        }
        Resource.ResourceWithMetadata.access$302(localResourceWithMetadata, this.timeStamp_);
        int j = i;
        if ((k & 0x2) == 2) {
          j = i | 0x2;
        }
        Resource.ResourceWithMetadata.access$402(localResourceWithMetadata, this.resource_);
        Resource.ResourceWithMetadata.access$502(localResourceWithMetadata, j);
        return localResourceWithMetadata;
      }
      
      public Builder clear()
      {
        super.clear();
        this.timeStamp_ = 0L;
        this.bitField0_ &= 0xFFFFFFFE;
        this.resource_ = Serving.Resource.getDefaultInstance();
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
      }
      
      public Builder clearResource()
      {
        this.resource_ = Serving.Resource.getDefaultInstance();
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
      }
      
      public Builder clearTimeStamp()
      {
        this.bitField0_ &= 0xFFFFFFFE;
        this.timeStamp_ = 0L;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Resource.ResourceWithMetadata getDefaultInstanceForType()
      {
        return Resource.ResourceWithMetadata.getDefaultInstance();
      }
      
      public Serving.Resource getResource()
      {
        return this.resource_;
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
      
      public final boolean isInitialized()
      {
        if (!hasTimeStamp()) {}
        while ((!hasResource()) || (!getResource().isInitialized())) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(Resource.ResourceWithMetadata paramResourceWithMetadata)
      {
        if (paramResourceWithMetadata == Resource.ResourceWithMetadata.getDefaultInstance()) {
          return this;
        }
        if (paramResourceWithMetadata.hasTimeStamp()) {
          setTimeStamp(paramResourceWithMetadata.getTimeStamp());
        }
        if (paramResourceWithMetadata.hasResource()) {
          mergeResource(paramResourceWithMetadata.getResource());
        }
        setUnknownFields(getUnknownFields().concat(paramResourceWithMetadata.unknownFields));
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        try
        {
          paramCodedInputStream = (Resource.ResourceWithMetadata)Resource.ResourceWithMetadata.PARSER.parsePartialFrom(paramCodedInputStream, paramExtensionRegistryLite);
          return this;
        }
        catch (InvalidProtocolBufferException paramExtensionRegistryLite)
        {
          localObject1 = localObject2;
          paramCodedInputStream = (Resource.ResourceWithMetadata)paramExtensionRegistryLite.getUnfinishedMessage();
          localObject1 = paramCodedInputStream;
          throw paramExtensionRegistryLite;
        }
        finally
        {
          if (localObject1 != null) {
            mergeFrom((Resource.ResourceWithMetadata)localObject1);
          }
        }
      }
      
      public Builder mergeResource(Serving.Resource paramResource)
      {
        if (((this.bitField0_ & 0x2) == 2) && (this.resource_ != Serving.Resource.getDefaultInstance())) {}
        for (this.resource_ = Serving.Resource.newBuilder(this.resource_).mergeFrom(paramResource).buildPartial();; this.resource_ = paramResource)
        {
          this.bitField0_ |= 0x2;
          return this;
        }
      }
      
      public Builder setResource(Serving.Resource.Builder paramBuilder)
      {
        this.resource_ = paramBuilder.build();
        this.bitField0_ |= 0x2;
        return this;
      }
      
      public Builder setResource(Serving.Resource paramResource)
      {
        if (paramResource == null) {
          throw new NullPointerException();
        }
        this.resource_ = paramResource;
        this.bitField0_ |= 0x2;
        return this;
      }
      
      public Builder setTimeStamp(long paramLong)
      {
        this.bitField0_ |= 0x1;
        this.timeStamp_ = paramLong;
        return this;
      }
    }
  }
  
  public static abstract interface ResourceWithMetadataOrBuilder
    extends MessageLiteOrBuilder
  {
    public abstract Serving.Resource getResource();
    
    public abstract long getTimeStamp();
    
    public abstract boolean hasResource();
    
    public abstract boolean hasTimeStamp();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/proto/Resource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */