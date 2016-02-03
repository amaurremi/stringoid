package com.google.analytics.containertag.proto;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;
import com.google.tagmanager.protobuf.nano.Extension;
import com.google.tagmanager.protobuf.nano.Extension.TypeLiteral;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract interface Serving
{
  public static final class CacheOption
    extends ExtendableMessageNano
  {
    public static final CacheOption[] EMPTY_ARRAY = new CacheOption[0];
    public int expirationSeconds = 0;
    public int gcacheExpirationSeconds = 0;
    public int level = 1;
    
    public static CacheOption parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new CacheOption().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static CacheOption parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (CacheOption)MessageNano.mergeFrom(new CacheOption(), paramArrayOfByte);
    }
    
    public final CacheOption clear()
    {
      this.level = 1;
      this.expirationSeconds = 0;
      this.gcacheExpirationSeconds = 0;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof CacheOption)) {
          return false;
        }
        paramObject = (CacheOption)paramObject;
        if ((this.level != ((CacheOption)paramObject).level) || (this.expirationSeconds != ((CacheOption)paramObject).expirationSeconds) || (this.gcacheExpirationSeconds != ((CacheOption)paramObject).gcacheExpirationSeconds)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label70;
        }
      } while (((CacheOption)paramObject).unknownFieldData == null);
      label70:
      while (!this.unknownFieldData.equals(((CacheOption)paramObject).unknownFieldData)) {
        return false;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (this.level != 1) {
        j = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.level);
      }
      int i = j;
      if (this.expirationSeconds != 0) {
        i = j + CodedOutputByteBufferNano.computeInt32Size(2, this.expirationSeconds);
      }
      j = i;
      if (this.gcacheExpirationSeconds != 0) {
        j = i + CodedOutputByteBufferNano.computeInt32Size(3, this.gcacheExpirationSeconds);
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int j = this.level;
      int k = this.expirationSeconds;
      int m = this.gcacheExpirationSeconds;
      if (this.unknownFieldData == null) {}
      for (int i = 0;; i = this.unknownFieldData.hashCode()) {
        return (((j + 527) * 31 + k) * 31 + m) * 31 + i;
      }
    }
    
    public CacheOption mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          i = paramCodedInputByteBufferNano.readInt32();
          if ((i == 1) || (i == 2) || (i == 3)) {
            this.level = i;
          } else {
            this.level = 1;
          }
          break;
        case 16: 
          this.expirationSeconds = paramCodedInputByteBufferNano.readInt32();
          break;
        case 24: 
          this.gcacheExpirationSeconds = paramCodedInputByteBufferNano.readInt32();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.level != 1) {
        paramCodedOutputByteBufferNano.writeInt32(1, this.level);
      }
      if (this.expirationSeconds != 0) {
        paramCodedOutputByteBufferNano.writeInt32(2, this.expirationSeconds);
      }
      if (this.gcacheExpirationSeconds != 0) {
        paramCodedOutputByteBufferNano.writeInt32(3, this.gcacheExpirationSeconds);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
    
    public static abstract interface CacheLevel
    {
      public static final int NO_CACHE = 1;
      public static final int PRIVATE = 2;
      public static final int PUBLIC = 3;
    }
  }
  
  public static final class Container
    extends ExtendableMessageNano
  {
    public static final Container[] EMPTY_ARRAY = new Container[0];
    public String containerId = "";
    public Serving.Resource jsResource = null;
    public int state = 1;
    public String version = "";
    
    public static Container parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new Container().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static Container parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (Container)MessageNano.mergeFrom(new Container(), paramArrayOfByte);
    }
    
    public final Container clear()
    {
      this.jsResource = null;
      this.containerId = "";
      this.state = 1;
      this.version = "";
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label49:
      label74:
      do
      {
        return true;
        if (!(paramObject instanceof Container)) {
          return false;
        }
        paramObject = (Container)paramObject;
        if (this.jsResource != null) {
          break label90;
        }
        if (((Container)paramObject).jsResource != null) {
          break;
        }
        if (this.containerId != null) {
          break label107;
        }
        if (((Container)paramObject).containerId != null) {
          break;
        }
        if (this.state != ((Container)paramObject).state) {
          break;
        }
        if (this.version != null) {
          break label124;
        }
        if (((Container)paramObject).version != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label141;
        }
      } while (((Container)paramObject).unknownFieldData == null);
      label90:
      label107:
      label124:
      label141:
      while (!this.unknownFieldData.equals(((Container)paramObject).unknownFieldData))
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (!this.jsResource.equals(((Container)paramObject).jsResource));
            break;
          } while (!this.containerId.equals(((Container)paramObject).containerId));
          break label49;
        } while (!this.version.equals(((Container)paramObject).version));
        break label74;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (this.jsResource != null) {
        i = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.jsResource);
      }
      int j = i + CodedOutputByteBufferNano.computeStringSize(3, this.containerId) + CodedOutputByteBufferNano.computeInt32Size(4, this.state);
      i = j;
      if (!this.version.equals("")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(5, this.version);
      }
      i += WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int m = 0;
      int i;
      int j;
      label21:
      int n;
      int k;
      if (this.jsResource == null)
      {
        i = 0;
        if (this.containerId != null) {
          break label82;
        }
        j = 0;
        n = this.state;
        if (this.version != null) {
          break label93;
        }
        k = 0;
        label36:
        if (this.unknownFieldData != null) {
          break label104;
        }
      }
      for (;;)
      {
        return ((((i + 527) * 31 + j) * 31 + n) * 31 + k) * 31 + m;
        i = this.jsResource.hashCode();
        break;
        label82:
        j = this.containerId.hashCode();
        break label21;
        label93:
        k = this.version.hashCode();
        break label36;
        label104:
        m = this.unknownFieldData.hashCode();
      }
    }
    
    public Container mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        case 10: 
          this.jsResource = new Serving.Resource();
          paramCodedInputByteBufferNano.readMessage(this.jsResource);
          break;
        case 26: 
          this.containerId = paramCodedInputByteBufferNano.readString();
          break;
        case 32: 
          i = paramCodedInputByteBufferNano.readInt32();
          if ((i == 1) || (i == 2)) {
            this.state = i;
          } else {
            this.state = 1;
          }
          break;
        case 42: 
          this.version = paramCodedInputByteBufferNano.readString();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.jsResource != null) {
        paramCodedOutputByteBufferNano.writeMessage(1, this.jsResource);
      }
      paramCodedOutputByteBufferNano.writeString(3, this.containerId);
      paramCodedOutputByteBufferNano.writeInt32(4, this.state);
      if (!this.version.equals("")) {
        paramCodedOutputByteBufferNano.writeString(5, this.version);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class FunctionCall
    extends ExtendableMessageNano
  {
    public static final FunctionCall[] EMPTY_ARRAY = new FunctionCall[0];
    public int function = 0;
    public boolean liveOnly = false;
    public int name = 0;
    public int[] property = WireFormatNano.EMPTY_INT_ARRAY;
    public boolean serverSide = false;
    
    public static FunctionCall parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new FunctionCall().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static FunctionCall parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (FunctionCall)MessageNano.mergeFrom(new FunctionCall(), paramArrayOfByte);
    }
    
    public final FunctionCall clear()
    {
      this.property = WireFormatNano.EMPTY_INT_ARRAY;
      this.function = 0;
      this.name = 0;
      this.liveOnly = false;
      this.serverSide = false;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof FunctionCall)) {
          return false;
        }
        paramObject = (FunctionCall)paramObject;
        if ((!Arrays.equals(this.property, ((FunctionCall)paramObject).property)) || (this.function != ((FunctionCall)paramObject).function) || (this.name != ((FunctionCall)paramObject).name) || (this.liveOnly != ((FunctionCall)paramObject).liveOnly) || (this.serverSide != ((FunctionCall)paramObject).serverSide)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label95;
        }
      } while (((FunctionCall)paramObject).unknownFieldData == null);
      label95:
      while (!this.unknownFieldData.equals(((FunctionCall)paramObject).unknownFieldData)) {
        return false;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (this.serverSide) {
        i = 0 + CodedOutputByteBufferNano.computeBoolSize(1, this.serverSide);
      }
      int k = i + CodedOutputByteBufferNano.computeInt32Size(2, this.function);
      i = k;
      if (this.property != null)
      {
        i = k;
        if (this.property.length > 0)
        {
          j = 0;
          int[] arrayOfInt = this.property;
          int m = arrayOfInt.length;
          i = 0;
          while (i < m)
          {
            j += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
            i += 1;
          }
          i = k + j + this.property.length * 1;
        }
      }
      int j = i;
      if (this.name != 0) {
        j = i + CodedOutputByteBufferNano.computeInt32Size(4, this.name);
      }
      i = j;
      if (this.liveOnly) {
        i = j + CodedOutputByteBufferNano.computeBoolSize(6, this.liveOnly);
      }
      i += WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int m = 1;
      int i = 17;
      int j;
      int n;
      int i1;
      label40:
      int k;
      if (this.property == null)
      {
        j = 17 * 31;
        n = this.function;
        i1 = this.name;
        if (!this.liveOnly) {
          break label122;
        }
        i = 1;
        if (!this.serverSide) {
          break label127;
        }
        k = m;
        label50:
        if (this.unknownFieldData != null) {
          break label132;
        }
      }
      label122:
      label127:
      label132:
      for (m = 0;; m = this.unknownFieldData.hashCode())
      {
        return ((((j * 31 + n) * 31 + i1) * 31 + i) * 31 + k) * 31 + m;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.property.length) {
            break;
          }
          i = i * 31 + this.property[k];
          k += 1;
        }
        i = 2;
        break label40;
        k = 2;
        break label50;
      }
    }
    
    public FunctionCall mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.serverSide = paramCodedInputByteBufferNano.readBool();
          break;
        case 16: 
          this.function = paramCodedInputByteBufferNano.readInt32();
          break;
        case 24: 
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 24);
          i = this.property.length;
          int[] arrayOfInt = new int[i + j];
          System.arraycopy(this.property, 0, arrayOfInt, 0, i);
          this.property = arrayOfInt;
          while (i < this.property.length - 1)
          {
            this.property[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.property[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 32: 
          this.name = paramCodedInputByteBufferNano.readInt32();
          break;
        case 48: 
          this.liveOnly = paramCodedInputByteBufferNano.readBool();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.serverSide) {
        paramCodedOutputByteBufferNano.writeBool(1, this.serverSide);
      }
      paramCodedOutputByteBufferNano.writeInt32(2, this.function);
      if (this.property != null)
      {
        int[] arrayOfInt = this.property;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(3, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.name != 0) {
        paramCodedOutputByteBufferNano.writeInt32(4, this.name);
      }
      if (this.liveOnly) {
        paramCodedOutputByteBufferNano.writeBool(6, this.liveOnly);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class GaExperimentRandom
    extends ExtendableMessageNano
  {
    public static final GaExperimentRandom[] EMPTY_ARRAY = new GaExperimentRandom[0];
    public String key = "";
    public long lifetimeInMilliseconds = 0L;
    public long maxRandom = 2147483647L;
    public long minRandom = 0L;
    public boolean retainOriginalValue = false;
    
    public static GaExperimentRandom parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new GaExperimentRandom().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static GaExperimentRandom parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (GaExperimentRandom)MessageNano.mergeFrom(new GaExperimentRandom(), paramArrayOfByte);
    }
    
    public final GaExperimentRandom clear()
    {
      this.key = "";
      this.minRandom = 0L;
      this.maxRandom = 2147483647L;
      this.retainOriginalValue = false;
      this.lifetimeInMilliseconds = 0L;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof GaExperimentRandom)) {
          return false;
        }
        paramObject = (GaExperimentRandom)paramObject;
        if (this.key != null) {
          break label98;
        }
        if (((GaExperimentRandom)paramObject).key != null) {
          break;
        }
        if ((this.minRandom != ((GaExperimentRandom)paramObject).minRandom) || (this.maxRandom != ((GaExperimentRandom)paramObject).maxRandom) || (this.retainOriginalValue != ((GaExperimentRandom)paramObject).retainOriginalValue) || (this.lifetimeInMilliseconds != ((GaExperimentRandom)paramObject).lifetimeInMilliseconds)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label115;
        }
      } while (((GaExperimentRandom)paramObject).unknownFieldData == null);
      label98:
      label115:
      while (!this.unknownFieldData.equals(((GaExperimentRandom)paramObject).unknownFieldData))
      {
        do
        {
          return false;
        } while (!this.key.equals(((GaExperimentRandom)paramObject).key));
        break;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (!this.key.equals("")) {
        j = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.key);
      }
      int i = j;
      if (this.minRandom != 0L) {
        i = j + CodedOutputByteBufferNano.computeInt64Size(2, this.minRandom);
      }
      j = i;
      if (this.maxRandom != 2147483647L) {
        j = i + CodedOutputByteBufferNano.computeInt64Size(3, this.maxRandom);
      }
      i = j;
      if (this.retainOriginalValue) {
        i = j + CodedOutputByteBufferNano.computeBoolSize(4, this.retainOriginalValue);
      }
      j = i;
      if (this.lifetimeInMilliseconds != 0L) {
        j = i + CodedOutputByteBufferNano.computeInt64Size(5, this.lifetimeInMilliseconds);
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int k = 0;
      int i;
      int m;
      int n;
      int j;
      label50:
      int i1;
      if (this.key == null)
      {
        i = 0;
        m = (int)(this.minRandom ^ this.minRandom >>> 32);
        n = (int)(this.maxRandom ^ this.maxRandom >>> 32);
        if (!this.retainOriginalValue) {
          break label117;
        }
        j = 1;
        i1 = (int)(this.lifetimeInMilliseconds ^ this.lifetimeInMilliseconds >>> 32);
        if (this.unknownFieldData != null) {
          break label122;
        }
      }
      for (;;)
      {
        return (((((i + 527) * 31 + m) * 31 + n) * 31 + j) * 31 + i1) * 31 + k;
        i = this.key.hashCode();
        break;
        label117:
        j = 2;
        break label50;
        label122:
        k = this.unknownFieldData.hashCode();
      }
    }
    
    public GaExperimentRandom mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        case 10: 
          this.key = paramCodedInputByteBufferNano.readString();
          break;
        case 16: 
          this.minRandom = paramCodedInputByteBufferNano.readInt64();
          break;
        case 24: 
          this.maxRandom = paramCodedInputByteBufferNano.readInt64();
          break;
        case 32: 
          this.retainOriginalValue = paramCodedInputByteBufferNano.readBool();
          break;
        case 40: 
          this.lifetimeInMilliseconds = paramCodedInputByteBufferNano.readInt64();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (!this.key.equals("")) {
        paramCodedOutputByteBufferNano.writeString(1, this.key);
      }
      if (this.minRandom != 0L) {
        paramCodedOutputByteBufferNano.writeInt64(2, this.minRandom);
      }
      if (this.maxRandom != 2147483647L) {
        paramCodedOutputByteBufferNano.writeInt64(3, this.maxRandom);
      }
      if (this.retainOriginalValue) {
        paramCodedOutputByteBufferNano.writeBool(4, this.retainOriginalValue);
      }
      if (this.lifetimeInMilliseconds != 0L) {
        paramCodedOutputByteBufferNano.writeInt64(5, this.lifetimeInMilliseconds);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class GaExperimentSupplemental
    extends ExtendableMessageNano
  {
    public static final GaExperimentSupplemental[] EMPTY_ARRAY = new GaExperimentSupplemental[0];
    public Serving.GaExperimentRandom[] experimentRandom = Serving.GaExperimentRandom.EMPTY_ARRAY;
    public TypeSystem.Value[] valueToClear = TypeSystem.Value.EMPTY_ARRAY;
    public TypeSystem.Value[] valueToPush = TypeSystem.Value.EMPTY_ARRAY;
    
    public static GaExperimentSupplemental parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new GaExperimentSupplemental().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static GaExperimentSupplemental parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (GaExperimentSupplemental)MessageNano.mergeFrom(new GaExperimentSupplemental(), paramArrayOfByte);
    }
    
    public final GaExperimentSupplemental clear()
    {
      this.valueToPush = TypeSystem.Value.EMPTY_ARRAY;
      this.valueToClear = TypeSystem.Value.EMPTY_ARRAY;
      this.experimentRandom = Serving.GaExperimentRandom.EMPTY_ARRAY;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof GaExperimentSupplemental)) {
          return false;
        }
        paramObject = (GaExperimentSupplemental)paramObject;
        if ((!Arrays.equals(this.valueToPush, ((GaExperimentSupplemental)paramObject).valueToPush)) || (!Arrays.equals(this.valueToClear, ((GaExperimentSupplemental)paramObject).valueToClear)) || (!Arrays.equals(this.experimentRandom, ((GaExperimentSupplemental)paramObject).experimentRandom))) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label79;
        }
      } while (((GaExperimentSupplemental)paramObject).unknownFieldData == null);
      label79:
      while (!this.unknownFieldData.equals(((GaExperimentSupplemental)paramObject).unknownFieldData)) {
        return false;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      int j = 0;
      Object localObject;
      int m;
      if (this.valueToPush != null)
      {
        localObject = this.valueToPush;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(1, localObject[k]);
          k += 1;
        }
      }
      j = i;
      if (this.valueToClear != null)
      {
        localObject = this.valueToClear;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(2, localObject[k]);
          k += 1;
        }
      }
      int k = j;
      if (this.experimentRandom != null)
      {
        localObject = this.experimentRandom;
        m = localObject.length;
        i = 0;
        for (;;)
        {
          k = j;
          if (i >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(3, localObject[i]);
          i += 1;
        }
      }
      i = k + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int m = 0;
      int i = 17;
      int j;
      label31:
      int k;
      if (this.valueToPush == null)
      {
        j = 17 * 31;
        if (this.valueToClear != null) {
          break label111;
        }
        j *= 31;
        if (this.experimentRandom != null) {
          break label164;
        }
        k = j * 31;
        label43:
        if (this.unknownFieldData != null) {
          break label219;
        }
      }
      label111:
      label164:
      label219:
      for (i = m;; i = this.unknownFieldData.hashCode())
      {
        return k * 31 + i;
        k = 0;
        j = i;
        if (k >= this.valueToPush.length) {
          break;
        }
        if (this.valueToPush[k] == null) {}
        for (j = 0;; j = this.valueToPush[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.valueToClear.length) {
          break label31;
        }
        if (this.valueToClear[k] == null) {}
        for (j = 0;; j = this.valueToClear[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = k;
        k = i;
        if (j >= this.experimentRandom.length) {
          break label43;
        }
        if (this.experimentRandom[j] == null) {}
        for (k = 0;; k = this.experimentRandom[j].hashCode())
        {
          i = i * 31 + k;
          j += 1;
          break;
        }
      }
    }
    
    public GaExperimentSupplemental mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputByteBufferNano.readTag();
        int j;
        Object localObject;
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
        case 10: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
          if (this.valueToPush == null) {}
          for (i = 0;; i = this.valueToPush.length)
          {
            localObject = new TypeSystem.Value[i + j];
            if (this.valueToPush != null) {
              System.arraycopy(this.valueToPush, 0, localObject, 0, i);
            }
            this.valueToPush = ((TypeSystem.Value[])localObject);
            while (i < this.valueToPush.length - 1)
            {
              this.valueToPush[i] = new TypeSystem.Value();
              paramCodedInputByteBufferNano.readMessage(this.valueToPush[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.valueToPush[i] = new TypeSystem.Value();
          paramCodedInputByteBufferNano.readMessage(this.valueToPush[i]);
          break;
        case 18: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          if (this.valueToClear == null) {}
          for (i = 0;; i = this.valueToClear.length)
          {
            localObject = new TypeSystem.Value[i + j];
            if (this.valueToClear != null) {
              System.arraycopy(this.valueToClear, 0, localObject, 0, i);
            }
            this.valueToClear = ((TypeSystem.Value[])localObject);
            while (i < this.valueToClear.length - 1)
            {
              this.valueToClear[i] = new TypeSystem.Value();
              paramCodedInputByteBufferNano.readMessage(this.valueToClear[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.valueToClear[i] = new TypeSystem.Value();
          paramCodedInputByteBufferNano.readMessage(this.valueToClear[i]);
          break;
        case 26: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
          if (this.experimentRandom == null) {}
          for (i = 0;; i = this.experimentRandom.length)
          {
            localObject = new Serving.GaExperimentRandom[i + j];
            if (this.experimentRandom != null) {
              System.arraycopy(this.experimentRandom, 0, localObject, 0, i);
            }
            this.experimentRandom = ((Serving.GaExperimentRandom[])localObject);
            while (i < this.experimentRandom.length - 1)
            {
              this.experimentRandom[i] = new Serving.GaExperimentRandom();
              paramCodedInputByteBufferNano.readMessage(this.experimentRandom[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.experimentRandom[i] = new Serving.GaExperimentRandom();
          paramCodedInputByteBufferNano.readMessage(this.experimentRandom[i]);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      Object localObject;
      int j;
      int i;
      if (this.valueToPush != null)
      {
        localObject = this.valueToPush;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(1, localObject[i]);
          i += 1;
        }
      }
      if (this.valueToClear != null)
      {
        localObject = this.valueToClear;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(2, localObject[i]);
          i += 1;
        }
      }
      if (this.experimentRandom != null)
      {
        localObject = this.experimentRandom;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(3, localObject[i]);
          i += 1;
        }
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class Property
    extends ExtendableMessageNano
  {
    public static final Property[] EMPTY_ARRAY = new Property[0];
    public int key = 0;
    public int value = 0;
    
    public static Property parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new Property().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static Property parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (Property)MessageNano.mergeFrom(new Property(), paramArrayOfByte);
    }
    
    public final Property clear()
    {
      this.key = 0;
      this.value = 0;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof Property)) {
          return false;
        }
        paramObject = (Property)paramObject;
        if ((this.key != ((Property)paramObject).key) || (this.value != ((Property)paramObject).value)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label59;
        }
      } while (((Property)paramObject).unknownFieldData == null);
      label59:
      while (!this.unknownFieldData.equals(((Property)paramObject).unknownFieldData)) {
        return false;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.key) + CodedOutputByteBufferNano.computeInt32Size(2, this.value) + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int j = this.key;
      int k = this.value;
      if (this.unknownFieldData == null) {}
      for (int i = 0;; i = this.unknownFieldData.hashCode()) {
        return ((j + 527) * 31 + k) * 31 + i;
      }
    }
    
    public Property mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.key = paramCodedInputByteBufferNano.readInt32();
          break;
        case 16: 
          this.value = paramCodedInputByteBufferNano.readInt32();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      paramCodedOutputByteBufferNano.writeInt32(1, this.key);
      paramCodedOutputByteBufferNano.writeInt32(2, this.value);
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class Resource
    extends ExtendableMessageNano
  {
    public static final Resource[] EMPTY_ARRAY = new Resource[0];
    private static final String TEMPLATE_VERSION_SET_DEFAULT = "0";
    public String[] key = WireFormatNano.EMPTY_STRING_ARRAY;
    public Serving.CacheOption liveJsCacheOption = null;
    public Serving.FunctionCall[] macro = Serving.FunctionCall.EMPTY_ARRAY;
    public String malwareScanAuthCode = "";
    public boolean oBSOLETEEnableAutoEventTracking = false;
    public Serving.FunctionCall[] predicate = Serving.FunctionCall.EMPTY_ARRAY;
    public String previewAuthCode = "";
    public Serving.Property[] property = Serving.Property.EMPTY_ARRAY;
    public float reportingSampleRate = 0.0F;
    public int resourceFormatVersion = 0;
    public Serving.Rule[] rule = Serving.Rule.EMPTY_ARRAY;
    public String[] supplemental = WireFormatNano.EMPTY_STRING_ARRAY;
    public Serving.FunctionCall[] tag = Serving.FunctionCall.EMPTY_ARRAY;
    public String templateVersionSet = "0";
    public String[] usageContext = WireFormatNano.EMPTY_STRING_ARRAY;
    public TypeSystem.Value[] value = TypeSystem.Value.EMPTY_ARRAY;
    public String version = "";
    
    public static Resource parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new Resource().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static Resource parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (Resource)MessageNano.mergeFrom(new Resource(), paramArrayOfByte);
    }
    
    public final Resource clear()
    {
      this.supplemental = WireFormatNano.EMPTY_STRING_ARRAY;
      this.key = WireFormatNano.EMPTY_STRING_ARRAY;
      this.value = TypeSystem.Value.EMPTY_ARRAY;
      this.property = Serving.Property.EMPTY_ARRAY;
      this.macro = Serving.FunctionCall.EMPTY_ARRAY;
      this.tag = Serving.FunctionCall.EMPTY_ARRAY;
      this.predicate = Serving.FunctionCall.EMPTY_ARRAY;
      this.rule = Serving.Rule.EMPTY_ARRAY;
      this.previewAuthCode = "";
      this.malwareScanAuthCode = "";
      this.templateVersionSet = "0";
      this.version = "";
      this.liveJsCacheOption = null;
      this.reportingSampleRate = 0.0F;
      this.oBSOLETEEnableAutoEventTracking = false;
      this.usageContext = WireFormatNano.EMPTY_STRING_ARRAY;
      this.resourceFormatVersion = 0;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label161:
      label175:
      label189:
      label203:
      do
      {
        return true;
        if (!(paramObject instanceof Resource)) {
          return false;
        }
        paramObject = (Resource)paramObject;
        if ((!Arrays.equals(this.supplemental, ((Resource)paramObject).supplemental)) || (!Arrays.equals(this.key, ((Resource)paramObject).key)) || (!Arrays.equals(this.value, ((Resource)paramObject).value)) || (!Arrays.equals(this.property, ((Resource)paramObject).property)) || (!Arrays.equals(this.macro, ((Resource)paramObject).macro)) || (!Arrays.equals(this.tag, ((Resource)paramObject).tag)) || (!Arrays.equals(this.predicate, ((Resource)paramObject).predicate)) || (!Arrays.equals(this.rule, ((Resource)paramObject).rule))) {
          break;
        }
        if (this.previewAuthCode != null) {
          break label267;
        }
        if (((Resource)paramObject).previewAuthCode != null) {
          break;
        }
        if (this.malwareScanAuthCode != null) {
          break label284;
        }
        if (((Resource)paramObject).malwareScanAuthCode != null) {
          break;
        }
        if (this.templateVersionSet != null) {
          break label301;
        }
        if (((Resource)paramObject).templateVersionSet != null) {
          break;
        }
        if (this.version != null) {
          break label318;
        }
        if (((Resource)paramObject).version != null) {
          break;
        }
        if (this.liveJsCacheOption != null) {
          break label335;
        }
        if (((Resource)paramObject).liveJsCacheOption != null) {
          break;
        }
        if ((this.reportingSampleRate != ((Resource)paramObject).reportingSampleRate) || (this.oBSOLETEEnableAutoEventTracking != ((Resource)paramObject).oBSOLETEEnableAutoEventTracking) || (!Arrays.equals(this.usageContext, ((Resource)paramObject).usageContext)) || (this.resourceFormatVersion != ((Resource)paramObject).resourceFormatVersion)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label352;
        }
      } while (((Resource)paramObject).unknownFieldData == null);
      label267:
      label284:
      label301:
      label318:
      label335:
      label352:
      while (!this.unknownFieldData.equals(((Resource)paramObject).unknownFieldData))
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
                  return false;
                } while (!this.previewAuthCode.equals(((Resource)paramObject).previewAuthCode));
                break;
              } while (!this.malwareScanAuthCode.equals(((Resource)paramObject).malwareScanAuthCode));
              break label161;
            } while (!this.templateVersionSet.equals(((Resource)paramObject).templateVersionSet));
            break label175;
          } while (!this.version.equals(((Resource)paramObject).version));
          break label189;
        } while (!this.liveJsCacheOption.equals(((Resource)paramObject).liveJsCacheOption));
        break label203;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      int j = i;
      Object localObject;
      if (this.key != null)
      {
        j = i;
        if (this.key.length > 0)
        {
          j = 0;
          localObject = this.key;
          k = localObject.length;
          i = 0;
          while (i < k)
          {
            j += CodedOutputByteBufferNano.computeStringSizeNoTag(localObject[i]);
            i += 1;
          }
          j = 0 + j + this.key.length * 1;
        }
      }
      i = j;
      int m;
      if (this.value != null)
      {
        localObject = this.value;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(2, localObject[k]);
          k += 1;
        }
      }
      j = i;
      if (this.property != null)
      {
        localObject = this.property;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(3, localObject[k]);
          k += 1;
        }
      }
      i = j;
      if (this.macro != null)
      {
        localObject = this.macro;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(4, localObject[k]);
          k += 1;
        }
      }
      j = i;
      if (this.tag != null)
      {
        localObject = this.tag;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(5, localObject[k]);
          k += 1;
        }
      }
      i = j;
      if (this.predicate != null)
      {
        localObject = this.predicate;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(6, localObject[k]);
          k += 1;
        }
      }
      j = i;
      if (this.rule != null)
      {
        localObject = this.rule;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(7, localObject[k]);
          k += 1;
        }
      }
      i = j;
      if (!this.previewAuthCode.equals("")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(9, this.previewAuthCode);
      }
      j = i;
      if (!this.malwareScanAuthCode.equals("")) {
        j = i + CodedOutputByteBufferNano.computeStringSize(10, this.malwareScanAuthCode);
      }
      i = j;
      if (!this.templateVersionSet.equals("0")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(12, this.templateVersionSet);
      }
      j = i;
      if (!this.version.equals("")) {
        j = i + CodedOutputByteBufferNano.computeStringSize(13, this.version);
      }
      int k = j;
      if (this.liveJsCacheOption != null) {
        k = j + CodedOutputByteBufferNano.computeMessageSize(14, this.liveJsCacheOption);
      }
      i = k;
      if (this.reportingSampleRate != 0.0F) {
        i = k + CodedOutputByteBufferNano.computeFloatSize(15, this.reportingSampleRate);
      }
      j = i;
      if (this.usageContext != null)
      {
        j = i;
        if (this.usageContext.length > 0)
        {
          k = 0;
          localObject = this.usageContext;
          m = localObject.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeStringSizeNoTag(localObject[j]);
            j += 1;
          }
          j = i + k + this.usageContext.length * 2;
        }
      }
      k = j;
      if (this.resourceFormatVersion != 0) {
        k = j + CodedOutputByteBufferNano.computeInt32Size(17, this.resourceFormatVersion);
      }
      i = k;
      if (this.oBSOLETEEnableAutoEventTracking) {
        i = k + CodedOutputByteBufferNano.computeBoolSize(18, this.oBSOLETEEnableAutoEventTracking);
      }
      j = i;
      if (this.supplemental != null)
      {
        j = i;
        if (this.supplemental.length > 0)
        {
          k = 0;
          localObject = this.supplemental;
          m = localObject.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeStringSizeNoTag(localObject[j]);
            j += 1;
          }
          j = i + k + this.supplemental.length * 2;
        }
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i = 17;
      int j;
      label31:
      label43:
      label55:
      label67:
      label79:
      label91:
      label103:
      label112:
      int k;
      label121:
      int m;
      label131:
      int n;
      label141:
      int i1;
      label151:
      int i2;
      if (this.supplemental == null)
      {
        j = 17 * 31;
        if (this.key != null) {
          break label302;
        }
        j *= 31;
        if (this.value != null) {
          break label355;
        }
        j *= 31;
        if (this.property != null) {
          break label408;
        }
        j *= 31;
        if (this.macro != null) {
          break label461;
        }
        j *= 31;
        if (this.tag != null) {
          break label514;
        }
        j *= 31;
        if (this.predicate != null) {
          break label567;
        }
        j *= 31;
        if (this.rule != null) {
          break label620;
        }
        j *= 31;
        if (this.previewAuthCode != null) {
          break label673;
        }
        i = 0;
        if (this.malwareScanAuthCode != null) {
          break label684;
        }
        k = 0;
        if (this.templateVersionSet != null) {
          break label695;
        }
        m = 0;
        if (this.version != null) {
          break label707;
        }
        n = 0;
        if (this.liveJsCacheOption != null) {
          break label719;
        }
        i1 = 0;
        int i4 = Float.floatToIntBits(this.reportingSampleRate);
        if (!this.oBSOLETEEnableAutoEventTracking) {
          break label731;
        }
        i2 = 1;
        label170:
        i = ((((((j * 31 + i) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i4) * 31 + i2;
        if (this.usageContext != null) {
          break label737;
        }
        k = i * 31;
        label224:
        j = this.resourceFormatVersion;
        if (this.unknownFieldData != null) {
          break label788;
        }
      }
      label302:
      label355:
      label408:
      label461:
      label514:
      label567:
      label620:
      label673:
      label684:
      label695:
      label707:
      label719:
      label731:
      label737:
      label788:
      for (i = i3;; i = this.unknownFieldData.hashCode())
      {
        return (k * 31 + j) * 31 + i;
        k = 0;
        j = i;
        if (k >= this.supplemental.length) {
          break;
        }
        if (this.supplemental[k] == null) {}
        for (j = 0;; j = this.supplemental[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.key.length) {
          break label31;
        }
        if (this.key[k] == null) {}
        for (j = 0;; j = this.key[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.value.length) {
          break label43;
        }
        if (this.value[k] == null) {}
        for (j = 0;; j = this.value[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.property.length) {
          break label55;
        }
        if (this.property[k] == null) {}
        for (j = 0;; j = this.property[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.macro.length) {
          break label67;
        }
        if (this.macro[k] == null) {}
        for (j = 0;; j = this.macro[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.tag.length) {
          break label79;
        }
        if (this.tag[k] == null) {}
        for (j = 0;; j = this.tag[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.predicate.length) {
          break label91;
        }
        if (this.predicate[k] == null) {}
        for (j = 0;; j = this.predicate[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.rule.length) {
          break label103;
        }
        if (this.rule[k] == null) {}
        for (j = 0;; j = this.rule[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        i = this.previewAuthCode.hashCode();
        break label112;
        k = this.malwareScanAuthCode.hashCode();
        break label121;
        m = this.templateVersionSet.hashCode();
        break label131;
        n = this.version.hashCode();
        break label141;
        i1 = this.liveJsCacheOption.hashCode();
        break label151;
        i2 = 2;
        break label170;
        j = 0;
        k = i;
        if (j >= this.usageContext.length) {
          break label224;
        }
        if (this.usageContext[j] == null) {}
        for (k = 0;; k = this.usageContext[j].hashCode())
        {
          i = i * 31 + k;
          j += 1;
          break;
        }
      }
    }
    
    public Resource mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputByteBufferNano.readTag();
        int j;
        Object localObject;
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
        case 10: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
          i = this.key.length;
          localObject = new String[i + j];
          System.arraycopy(this.key, 0, localObject, 0, i);
          this.key = ((String[])localObject);
          while (i < this.key.length - 1)
          {
            this.key[i] = paramCodedInputByteBufferNano.readString();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.key[i] = paramCodedInputByteBufferNano.readString();
          break;
        case 18: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          if (this.value == null) {}
          for (i = 0;; i = this.value.length)
          {
            localObject = new TypeSystem.Value[i + j];
            if (this.value != null) {
              System.arraycopy(this.value, 0, localObject, 0, i);
            }
            this.value = ((TypeSystem.Value[])localObject);
            while (i < this.value.length - 1)
            {
              this.value[i] = new TypeSystem.Value();
              paramCodedInputByteBufferNano.readMessage(this.value[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.value[i] = new TypeSystem.Value();
          paramCodedInputByteBufferNano.readMessage(this.value[i]);
          break;
        case 26: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
          if (this.property == null) {}
          for (i = 0;; i = this.property.length)
          {
            localObject = new Serving.Property[i + j];
            if (this.property != null) {
              System.arraycopy(this.property, 0, localObject, 0, i);
            }
            this.property = ((Serving.Property[])localObject);
            while (i < this.property.length - 1)
            {
              this.property[i] = new Serving.Property();
              paramCodedInputByteBufferNano.readMessage(this.property[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.property[i] = new Serving.Property();
          paramCodedInputByteBufferNano.readMessage(this.property[i]);
          break;
        case 34: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
          if (this.macro == null) {}
          for (i = 0;; i = this.macro.length)
          {
            localObject = new Serving.FunctionCall[i + j];
            if (this.macro != null) {
              System.arraycopy(this.macro, 0, localObject, 0, i);
            }
            this.macro = ((Serving.FunctionCall[])localObject);
            while (i < this.macro.length - 1)
            {
              this.macro[i] = new Serving.FunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.macro[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.macro[i] = new Serving.FunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.macro[i]);
          break;
        case 42: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
          if (this.tag == null) {}
          for (i = 0;; i = this.tag.length)
          {
            localObject = new Serving.FunctionCall[i + j];
            if (this.tag != null) {
              System.arraycopy(this.tag, 0, localObject, 0, i);
            }
            this.tag = ((Serving.FunctionCall[])localObject);
            while (i < this.tag.length - 1)
            {
              this.tag[i] = new Serving.FunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.tag[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.tag[i] = new Serving.FunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.tag[i]);
          break;
        case 50: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
          if (this.predicate == null) {}
          for (i = 0;; i = this.predicate.length)
          {
            localObject = new Serving.FunctionCall[i + j];
            if (this.predicate != null) {
              System.arraycopy(this.predicate, 0, localObject, 0, i);
            }
            this.predicate = ((Serving.FunctionCall[])localObject);
            while (i < this.predicate.length - 1)
            {
              this.predicate[i] = new Serving.FunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.predicate[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.predicate[i] = new Serving.FunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.predicate[i]);
          break;
        case 58: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 58);
          if (this.rule == null) {}
          for (i = 0;; i = this.rule.length)
          {
            localObject = new Serving.Rule[i + j];
            if (this.rule != null) {
              System.arraycopy(this.rule, 0, localObject, 0, i);
            }
            this.rule = ((Serving.Rule[])localObject);
            while (i < this.rule.length - 1)
            {
              this.rule[i] = new Serving.Rule();
              paramCodedInputByteBufferNano.readMessage(this.rule[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.rule[i] = new Serving.Rule();
          paramCodedInputByteBufferNano.readMessage(this.rule[i]);
          break;
        case 74: 
          this.previewAuthCode = paramCodedInputByteBufferNano.readString();
          break;
        case 82: 
          this.malwareScanAuthCode = paramCodedInputByteBufferNano.readString();
          break;
        case 98: 
          this.templateVersionSet = paramCodedInputByteBufferNano.readString();
          break;
        case 106: 
          this.version = paramCodedInputByteBufferNano.readString();
          break;
        case 114: 
          this.liveJsCacheOption = new Serving.CacheOption();
          paramCodedInputByteBufferNano.readMessage(this.liveJsCacheOption);
          break;
        case 125: 
          this.reportingSampleRate = paramCodedInputByteBufferNano.readFloat();
          break;
        case 130: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 130);
          i = this.usageContext.length;
          localObject = new String[i + j];
          System.arraycopy(this.usageContext, 0, localObject, 0, i);
          this.usageContext = ((String[])localObject);
          while (i < this.usageContext.length - 1)
          {
            this.usageContext[i] = paramCodedInputByteBufferNano.readString();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.usageContext[i] = paramCodedInputByteBufferNano.readString();
          break;
        case 136: 
          this.resourceFormatVersion = paramCodedInputByteBufferNano.readInt32();
          break;
        case 144: 
          this.oBSOLETEEnableAutoEventTracking = paramCodedInputByteBufferNano.readBool();
          break;
        case 154: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 154);
          i = this.supplemental.length;
          localObject = new String[i + j];
          System.arraycopy(this.supplemental, 0, localObject, 0, i);
          this.supplemental = ((String[])localObject);
          while (i < this.supplemental.length - 1)
          {
            this.supplemental[i] = paramCodedInputByteBufferNano.readString();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.supplemental[i] = paramCodedInputByteBufferNano.readString();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      Object localObject;
      int j;
      int i;
      if (this.key != null)
      {
        localObject = this.key;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeString(1, localObject[i]);
          i += 1;
        }
      }
      if (this.value != null)
      {
        localObject = this.value;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(2, localObject[i]);
          i += 1;
        }
      }
      if (this.property != null)
      {
        localObject = this.property;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(3, localObject[i]);
          i += 1;
        }
      }
      if (this.macro != null)
      {
        localObject = this.macro;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(4, localObject[i]);
          i += 1;
        }
      }
      if (this.tag != null)
      {
        localObject = this.tag;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(5, localObject[i]);
          i += 1;
        }
      }
      if (this.predicate != null)
      {
        localObject = this.predicate;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(6, localObject[i]);
          i += 1;
        }
      }
      if (this.rule != null)
      {
        localObject = this.rule;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(7, localObject[i]);
          i += 1;
        }
      }
      if (!this.previewAuthCode.equals("")) {
        paramCodedOutputByteBufferNano.writeString(9, this.previewAuthCode);
      }
      if (!this.malwareScanAuthCode.equals("")) {
        paramCodedOutputByteBufferNano.writeString(10, this.malwareScanAuthCode);
      }
      if (!this.templateVersionSet.equals("0")) {
        paramCodedOutputByteBufferNano.writeString(12, this.templateVersionSet);
      }
      if (!this.version.equals("")) {
        paramCodedOutputByteBufferNano.writeString(13, this.version);
      }
      if (this.liveJsCacheOption != null) {
        paramCodedOutputByteBufferNano.writeMessage(14, this.liveJsCacheOption);
      }
      if (this.reportingSampleRate != 0.0F) {
        paramCodedOutputByteBufferNano.writeFloat(15, this.reportingSampleRate);
      }
      if (this.usageContext != null)
      {
        localObject = this.usageContext;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeString(16, localObject[i]);
          i += 1;
        }
      }
      if (this.resourceFormatVersion != 0) {
        paramCodedOutputByteBufferNano.writeInt32(17, this.resourceFormatVersion);
      }
      if (this.oBSOLETEEnableAutoEventTracking) {
        paramCodedOutputByteBufferNano.writeBool(18, this.oBSOLETEEnableAutoEventTracking);
      }
      if (this.supplemental != null)
      {
        localObject = this.supplemental;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeString(19, localObject[i]);
          i += 1;
        }
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static abstract interface ResourceState
  {
    public static final int LIVE = 2;
    public static final int PREVIEW = 1;
  }
  
  public static abstract interface ResourceType
  {
    public static final int CLEAR_CACHE = 6;
    public static final int GET_COOKIE = 5;
    public static final int JS_RESOURCE = 1;
    public static final int NS_RESOURCE = 2;
    public static final int PIXEL_COLLECTION = 3;
    public static final int RAW_PROTO = 7;
    public static final int SET_COOKIE = 4;
  }
  
  public static final class Rule
    extends ExtendableMessageNano
  {
    public static final Rule[] EMPTY_ARRAY = new Rule[0];
    public int[] addMacro = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] addMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] addTag = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] addTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] negativePredicate = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] positivePredicate = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] removeMacro = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] removeMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] removeTag = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] removeTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
    
    public static Rule parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new Rule().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static Rule parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (Rule)MessageNano.mergeFrom(new Rule(), paramArrayOfByte);
    }
    
    public final Rule clear()
    {
      this.positivePredicate = WireFormatNano.EMPTY_INT_ARRAY;
      this.negativePredicate = WireFormatNano.EMPTY_INT_ARRAY;
      this.addTag = WireFormatNano.EMPTY_INT_ARRAY;
      this.removeTag = WireFormatNano.EMPTY_INT_ARRAY;
      this.addTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
      this.removeTagRuleName = WireFormatNano.EMPTY_INT_ARRAY;
      this.addMacro = WireFormatNano.EMPTY_INT_ARRAY;
      this.removeMacro = WireFormatNano.EMPTY_INT_ARRAY;
      this.addMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
      this.removeMacroRuleName = WireFormatNano.EMPTY_INT_ARRAY;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof Rule)) {
          return false;
        }
        paramObject = (Rule)paramObject;
        if ((!Arrays.equals(this.positivePredicate, ((Rule)paramObject).positivePredicate)) || (!Arrays.equals(this.negativePredicate, ((Rule)paramObject).negativePredicate)) || (!Arrays.equals(this.addTag, ((Rule)paramObject).addTag)) || (!Arrays.equals(this.removeTag, ((Rule)paramObject).removeTag)) || (!Arrays.equals(this.addTagRuleName, ((Rule)paramObject).addTagRuleName)) || (!Arrays.equals(this.removeTagRuleName, ((Rule)paramObject).removeTagRuleName)) || (!Arrays.equals(this.addMacro, ((Rule)paramObject).addMacro)) || (!Arrays.equals(this.removeMacro, ((Rule)paramObject).removeMacro)) || (!Arrays.equals(this.addMacroRuleName, ((Rule)paramObject).addMacroRuleName)) || (!Arrays.equals(this.removeMacroRuleName, ((Rule)paramObject).removeMacroRuleName))) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label177;
        }
      } while (((Rule)paramObject).unknownFieldData == null);
      label177:
      while (!this.unknownFieldData.equals(((Rule)paramObject).unknownFieldData)) {
        return false;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      int i = j;
      int[] arrayOfInt;
      int k;
      if (this.positivePredicate != null)
      {
        i = j;
        if (this.positivePredicate.length > 0)
        {
          j = 0;
          arrayOfInt = this.positivePredicate;
          k = arrayOfInt.length;
          i = 0;
          while (i < k)
          {
            j += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
            i += 1;
          }
          i = 0 + j + this.positivePredicate.length * 1;
        }
      }
      j = i;
      int m;
      if (this.negativePredicate != null)
      {
        j = i;
        if (this.negativePredicate.length > 0)
        {
          k = 0;
          arrayOfInt = this.negativePredicate;
          m = arrayOfInt.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + this.negativePredicate.length * 1;
        }
      }
      i = j;
      if (this.addTag != null)
      {
        i = j;
        if (this.addTag.length > 0)
        {
          k = 0;
          arrayOfInt = this.addTag;
          m = arrayOfInt.length;
          i = 0;
          while (i < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
            i += 1;
          }
          i = j + k + this.addTag.length * 1;
        }
      }
      j = i;
      if (this.removeTag != null)
      {
        j = i;
        if (this.removeTag.length > 0)
        {
          k = 0;
          arrayOfInt = this.removeTag;
          m = arrayOfInt.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + this.removeTag.length * 1;
        }
      }
      i = j;
      if (this.addTagRuleName != null)
      {
        i = j;
        if (this.addTagRuleName.length > 0)
        {
          k = 0;
          arrayOfInt = this.addTagRuleName;
          m = arrayOfInt.length;
          i = 0;
          while (i < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
            i += 1;
          }
          i = j + k + this.addTagRuleName.length * 1;
        }
      }
      j = i;
      if (this.removeTagRuleName != null)
      {
        j = i;
        if (this.removeTagRuleName.length > 0)
        {
          k = 0;
          arrayOfInt = this.removeTagRuleName;
          m = arrayOfInt.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + this.removeTagRuleName.length * 1;
        }
      }
      i = j;
      if (this.addMacro != null)
      {
        i = j;
        if (this.addMacro.length > 0)
        {
          k = 0;
          arrayOfInt = this.addMacro;
          m = arrayOfInt.length;
          i = 0;
          while (i < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
            i += 1;
          }
          i = j + k + this.addMacro.length * 1;
        }
      }
      j = i;
      if (this.removeMacro != null)
      {
        j = i;
        if (this.removeMacro.length > 0)
        {
          k = 0;
          arrayOfInt = this.removeMacro;
          m = arrayOfInt.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + this.removeMacro.length * 1;
        }
      }
      i = j;
      if (this.addMacroRuleName != null)
      {
        i = j;
        if (this.addMacroRuleName.length > 0)
        {
          k = 0;
          arrayOfInt = this.addMacroRuleName;
          m = arrayOfInt.length;
          i = 0;
          while (i < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
            i += 1;
          }
          i = j + k + this.addMacroRuleName.length * 1;
        }
      }
      j = i;
      if (this.removeMacroRuleName != null)
      {
        j = i;
        if (this.removeMacroRuleName.length > 0)
        {
          k = 0;
          arrayOfInt = this.removeMacroRuleName;
          m = arrayOfInt.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + this.removeMacroRuleName.length * 1;
        }
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int j = 17;
      if (this.positivePredicate == null)
      {
        i = 17 * 31;
        if (this.negativePredicate != null) {
          break label172;
        }
        i *= 31;
        if (this.addTag != null) {
          break label206;
        }
        i *= 31;
        if (this.removeTag != null) {
          break label240;
        }
        i *= 31;
        if (this.addTagRuleName != null) {
          break label274;
        }
        i *= 31;
        if (this.removeTagRuleName != null) {
          break label308;
        }
        i *= 31;
        if (this.addMacro != null) {
          break label342;
        }
        i *= 31;
        if (this.removeMacro != null) {
          break label376;
        }
        i *= 31;
        if (this.addMacroRuleName != null) {
          break label410;
        }
        i *= 31;
        if (this.removeMacroRuleName != null) {
          break label444;
        }
        j = i * 31;
        if (this.unknownFieldData != null) {
          break label476;
        }
      }
      label172:
      label206:
      label240:
      label274:
      label308:
      label342:
      label376:
      label410:
      label444:
      label476:
      for (int i = 0;; i = this.unknownFieldData.hashCode())
      {
        return j * 31 + i;
        int k = 0;
        for (;;)
        {
          i = j;
          if (k >= this.positivePredicate.length) {
            break;
          }
          j = j * 31 + this.positivePredicate[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.negativePredicate.length) {
            break;
          }
          j = j * 31 + this.negativePredicate[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.addTag.length) {
            break;
          }
          j = j * 31 + this.addTag[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.removeTag.length) {
            break;
          }
          j = j * 31 + this.removeTag[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.addTagRuleName.length) {
            break;
          }
          j = j * 31 + this.addTagRuleName[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.removeTagRuleName.length) {
            break;
          }
          j = j * 31 + this.removeTagRuleName[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.addMacro.length) {
            break;
          }
          j = j * 31 + this.addMacro[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.removeMacro.length) {
            break;
          }
          j = j * 31 + this.removeMacro[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.addMacroRuleName.length) {
            break;
          }
          j = j * 31 + this.addMacroRuleName[k];
          k += 1;
        }
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.removeMacroRuleName.length) {
            break;
          }
          i = i * 31 + this.removeMacroRuleName[k];
          k += 1;
        }
      }
    }
    
    public Rule mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputByteBufferNano.readTag();
        int j;
        int[] arrayOfInt;
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
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
          i = this.positivePredicate.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.positivePredicate, 0, arrayOfInt, 0, i);
          this.positivePredicate = arrayOfInt;
          while (i < this.positivePredicate.length - 1)
          {
            this.positivePredicate[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.positivePredicate[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 16: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 16);
          i = this.negativePredicate.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.negativePredicate, 0, arrayOfInt, 0, i);
          this.negativePredicate = arrayOfInt;
          while (i < this.negativePredicate.length - 1)
          {
            this.negativePredicate[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.negativePredicate[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 24: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 24);
          i = this.addTag.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.addTag, 0, arrayOfInt, 0, i);
          this.addTag = arrayOfInt;
          while (i < this.addTag.length - 1)
          {
            this.addTag[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.addTag[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 32: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 32);
          i = this.removeTag.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.removeTag, 0, arrayOfInt, 0, i);
          this.removeTag = arrayOfInt;
          while (i < this.removeTag.length - 1)
          {
            this.removeTag[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.removeTag[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 40: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 40);
          i = this.addTagRuleName.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.addTagRuleName, 0, arrayOfInt, 0, i);
          this.addTagRuleName = arrayOfInt;
          while (i < this.addTagRuleName.length - 1)
          {
            this.addTagRuleName[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.addTagRuleName[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 48: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 48);
          i = this.removeTagRuleName.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.removeTagRuleName, 0, arrayOfInt, 0, i);
          this.removeTagRuleName = arrayOfInt;
          while (i < this.removeTagRuleName.length - 1)
          {
            this.removeTagRuleName[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.removeTagRuleName[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 56: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 56);
          i = this.addMacro.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.addMacro, 0, arrayOfInt, 0, i);
          this.addMacro = arrayOfInt;
          while (i < this.addMacro.length - 1)
          {
            this.addMacro[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.addMacro[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 64: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 64);
          i = this.removeMacro.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.removeMacro, 0, arrayOfInt, 0, i);
          this.removeMacro = arrayOfInt;
          while (i < this.removeMacro.length - 1)
          {
            this.removeMacro[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.removeMacro[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 72: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 72);
          i = this.addMacroRuleName.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.addMacroRuleName, 0, arrayOfInt, 0, i);
          this.addMacroRuleName = arrayOfInt;
          while (i < this.addMacroRuleName.length - 1)
          {
            this.addMacroRuleName[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.addMacroRuleName[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 80: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 80);
          i = this.removeMacroRuleName.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.removeMacroRuleName, 0, arrayOfInt, 0, i);
          this.removeMacroRuleName = arrayOfInt;
          while (i < this.removeMacroRuleName.length - 1)
          {
            this.removeMacroRuleName[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.removeMacroRuleName[i] = paramCodedInputByteBufferNano.readInt32();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      int[] arrayOfInt;
      int j;
      int i;
      if (this.positivePredicate != null)
      {
        arrayOfInt = this.positivePredicate;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(1, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.negativePredicate != null)
      {
        arrayOfInt = this.negativePredicate;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(2, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.addTag != null)
      {
        arrayOfInt = this.addTag;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(3, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.removeTag != null)
      {
        arrayOfInt = this.removeTag;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(4, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.addTagRuleName != null)
      {
        arrayOfInt = this.addTagRuleName;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(5, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.removeTagRuleName != null)
      {
        arrayOfInt = this.removeTagRuleName;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(6, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.addMacro != null)
      {
        arrayOfInt = this.addMacro;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(7, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.removeMacro != null)
      {
        arrayOfInt = this.removeMacro;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(8, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.addMacroRuleName != null)
      {
        arrayOfInt = this.addMacroRuleName;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(9, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.removeMacroRuleName != null)
      {
        arrayOfInt = this.removeMacroRuleName;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(10, arrayOfInt[i]);
          i += 1;
        }
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class ServingValue
    extends ExtendableMessageNano
  {
    public static final ServingValue[] EMPTY_ARRAY = new ServingValue[0];
    public static final Extension<ServingValue> ext = Extension.create(101, new Extension.TypeLiteral() {});
    public int[] listItem = WireFormatNano.EMPTY_INT_ARRAY;
    public int macroNameReference = 0;
    public int macroReference = 0;
    public int[] mapKey = WireFormatNano.EMPTY_INT_ARRAY;
    public int[] mapValue = WireFormatNano.EMPTY_INT_ARRAY;
    public int tagReference = 0;
    public int[] templateToken = WireFormatNano.EMPTY_INT_ARRAY;
    
    public static ServingValue parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new ServingValue().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static ServingValue parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (ServingValue)MessageNano.mergeFrom(new ServingValue(), paramArrayOfByte);
    }
    
    public final ServingValue clear()
    {
      this.listItem = WireFormatNano.EMPTY_INT_ARRAY;
      this.mapKey = WireFormatNano.EMPTY_INT_ARRAY;
      this.mapValue = WireFormatNano.EMPTY_INT_ARRAY;
      this.macroReference = 0;
      this.templateToken = WireFormatNano.EMPTY_INT_ARRAY;
      this.macroNameReference = 0;
      this.tagReference = 0;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof ServingValue)) {
          return false;
        }
        paramObject = (ServingValue)paramObject;
        if ((!Arrays.equals(this.listItem, ((ServingValue)paramObject).listItem)) || (!Arrays.equals(this.mapKey, ((ServingValue)paramObject).mapKey)) || (!Arrays.equals(this.mapValue, ((ServingValue)paramObject).mapValue)) || (this.macroReference != ((ServingValue)paramObject).macroReference) || (!Arrays.equals(this.templateToken, ((ServingValue)paramObject).templateToken)) || (this.macroNameReference != ((ServingValue)paramObject).macroNameReference) || (this.tagReference != ((ServingValue)paramObject).tagReference)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label126;
        }
      } while (((ServingValue)paramObject).unknownFieldData == null);
      label126:
      while (!this.unknownFieldData.equals(((ServingValue)paramObject).unknownFieldData)) {
        return false;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      int i = j;
      int[] arrayOfInt;
      if (this.listItem != null)
      {
        i = j;
        if (this.listItem.length > 0)
        {
          j = 0;
          arrayOfInt = this.listItem;
          k = arrayOfInt.length;
          i = 0;
          while (i < k)
          {
            j += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
            i += 1;
          }
          i = 0 + j + this.listItem.length * 1;
        }
      }
      j = i;
      int m;
      if (this.mapKey != null)
      {
        j = i;
        if (this.mapKey.length > 0)
        {
          k = 0;
          arrayOfInt = this.mapKey;
          m = arrayOfInt.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + this.mapKey.length * 1;
        }
      }
      int k = j;
      if (this.mapValue != null)
      {
        k = j;
        if (this.mapValue.length > 0)
        {
          k = 0;
          arrayOfInt = this.mapValue;
          m = arrayOfInt.length;
          i = 0;
          while (i < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
            i += 1;
          }
          k = j + k + this.mapValue.length * 1;
        }
      }
      i = k;
      if (this.macroReference != 0) {
        i = k + CodedOutputByteBufferNano.computeInt32Size(4, this.macroReference);
      }
      j = i;
      if (this.templateToken != null)
      {
        j = i;
        if (this.templateToken.length > 0)
        {
          k = 0;
          arrayOfInt = this.templateToken;
          m = arrayOfInt.length;
          j = 0;
          while (j < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + this.templateToken.length * 1;
        }
      }
      i = j;
      if (this.macroNameReference != 0) {
        i = j + CodedOutputByteBufferNano.computeInt32Size(6, this.macroNameReference);
      }
      j = i;
      if (this.tagReference != 0) {
        j = i + CodedOutputByteBufferNano.computeInt32Size(7, this.tagReference);
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int j = 17;
      int k;
      int m;
      if (this.listItem == null)
      {
        i = 17 * 31;
        if (this.mapKey != null) {
          break label132;
        }
        i *= 31;
        if (this.mapValue != null) {
          break label166;
        }
        k = i * 31;
        i = k * 31 + this.macroReference;
        if (this.templateToken != null) {
          break label198;
        }
        j = i * 31;
        k = this.macroNameReference;
        m = this.tagReference;
        if (this.unknownFieldData != null) {
          break label230;
        }
      }
      label132:
      label166:
      label198:
      label230:
      for (int i = 0;; i = this.unknownFieldData.hashCode())
      {
        return ((j * 31 + k) * 31 + m) * 31 + i;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= this.listItem.length) {
            break;
          }
          j = j * 31 + this.listItem[k];
          k += 1;
        }
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= this.mapKey.length) {
            break;
          }
          j = j * 31 + this.mapKey[k];
          k += 1;
        }
        j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.mapValue.length) {
            break;
          }
          i = i * 31 + this.mapValue[j];
          j += 1;
        }
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.templateToken.length) {
            break;
          }
          i = i * 31 + this.templateToken[k];
          k += 1;
        }
      }
    }
    
    public ServingValue mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputByteBufferNano.readTag();
        int j;
        int[] arrayOfInt;
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
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
          i = this.listItem.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.listItem, 0, arrayOfInt, 0, i);
          this.listItem = arrayOfInt;
          while (i < this.listItem.length - 1)
          {
            this.listItem[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.listItem[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 16: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 16);
          i = this.mapKey.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.mapKey, 0, arrayOfInt, 0, i);
          this.mapKey = arrayOfInt;
          while (i < this.mapKey.length - 1)
          {
            this.mapKey[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.mapKey[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 24: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 24);
          i = this.mapValue.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.mapValue, 0, arrayOfInt, 0, i);
          this.mapValue = arrayOfInt;
          while (i < this.mapValue.length - 1)
          {
            this.mapValue[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.mapValue[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 32: 
          this.macroReference = paramCodedInputByteBufferNano.readInt32();
          break;
        case 40: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 40);
          i = this.templateToken.length;
          arrayOfInt = new int[i + j];
          System.arraycopy(this.templateToken, 0, arrayOfInt, 0, i);
          this.templateToken = arrayOfInt;
          while (i < this.templateToken.length - 1)
          {
            this.templateToken[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.templateToken[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 48: 
          this.macroNameReference = paramCodedInputByteBufferNano.readInt32();
          break;
        case 56: 
          this.tagReference = paramCodedInputByteBufferNano.readInt32();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      int[] arrayOfInt;
      int j;
      int i;
      if (this.listItem != null)
      {
        arrayOfInt = this.listItem;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(1, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.mapKey != null)
      {
        arrayOfInt = this.mapKey;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(2, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.mapValue != null)
      {
        arrayOfInt = this.mapValue;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(3, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.macroReference != 0) {
        paramCodedOutputByteBufferNano.writeInt32(4, this.macroReference);
      }
      if (this.templateToken != null)
      {
        arrayOfInt = this.templateToken;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(5, arrayOfInt[i]);
          i += 1;
        }
      }
      if (this.macroNameReference != 0) {
        paramCodedOutputByteBufferNano.writeInt32(6, this.macroNameReference);
      }
      if (this.tagReference != 0) {
        paramCodedOutputByteBufferNano.writeInt32(7, this.tagReference);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class Supplemental
    extends ExtendableMessageNano
  {
    public static final Supplemental[] EMPTY_ARRAY = new Supplemental[0];
    public Serving.GaExperimentSupplemental experimentSupplemental = null;
    public String name = "";
    public TypeSystem.Value value = null;
    
    public static Supplemental parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new Supplemental().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static Supplemental parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (Supplemental)MessageNano.mergeFrom(new Supplemental(), paramArrayOfByte);
    }
    
    public final Supplemental clear()
    {
      this.name = "";
      this.value = null;
      this.experimentSupplemental = null;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label49:
      label63:
      do
      {
        return true;
        if (!(paramObject instanceof Supplemental)) {
          return false;
        }
        paramObject = (Supplemental)paramObject;
        if (this.name != null) {
          break label79;
        }
        if (((Supplemental)paramObject).name != null) {
          break;
        }
        if (this.value != null) {
          break label96;
        }
        if (((Supplemental)paramObject).value != null) {
          break;
        }
        if (this.experimentSupplemental != null) {
          break label113;
        }
        if (((Supplemental)paramObject).experimentSupplemental != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label130;
        }
      } while (((Supplemental)paramObject).unknownFieldData == null);
      label79:
      label96:
      label113:
      label130:
      while (!this.unknownFieldData.equals(((Supplemental)paramObject).unknownFieldData))
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (!this.name.equals(((Supplemental)paramObject).name));
            break;
          } while (!this.value.equals(((Supplemental)paramObject).value));
          break label49;
        } while (!this.experimentSupplemental.equals(((Supplemental)paramObject).experimentSupplemental));
        break label63;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (!this.name.equals("")) {
        j = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.name);
      }
      int i = j;
      if (this.value != null) {
        i = j + CodedOutputByteBufferNano.computeMessageSize(2, this.value);
      }
      j = i;
      if (this.experimentSupplemental != null) {
        j = i + CodedOutputByteBufferNano.computeMessageSize(3, this.experimentSupplemental);
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int m = 0;
      int i;
      int j;
      label21:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.value != null) {
          break label70;
        }
        j = 0;
        if (this.experimentSupplemental != null) {
          break label81;
        }
        k = 0;
        label30:
        if (this.unknownFieldData != null) {
          break label92;
        }
      }
      for (;;)
      {
        return (((i + 527) * 31 + j) * 31 + k) * 31 + m;
        i = this.name.hashCode();
        break;
        label70:
        j = this.value.hashCode();
        break label21;
        label81:
        k = this.experimentSupplemental.hashCode();
        break label30;
        label92:
        m = this.unknownFieldData.hashCode();
      }
    }
    
    public Supplemental mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        case 10: 
          this.name = paramCodedInputByteBufferNano.readString();
          break;
        case 18: 
          this.value = new TypeSystem.Value();
          paramCodedInputByteBufferNano.readMessage(this.value);
          break;
        case 26: 
          this.experimentSupplemental = new Serving.GaExperimentSupplemental();
          paramCodedInputByteBufferNano.readMessage(this.experimentSupplemental);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (!this.name.equals("")) {
        paramCodedOutputByteBufferNano.writeString(1, this.name);
      }
      if (this.value != null) {
        paramCodedOutputByteBufferNano.writeMessage(2, this.value);
      }
      if (this.experimentSupplemental != null) {
        paramCodedOutputByteBufferNano.writeMessage(3, this.experimentSupplemental);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class SupplementedResource
    extends ExtendableMessageNano
  {
    public static final SupplementedResource[] EMPTY_ARRAY = new SupplementedResource[0];
    public String fingerprint = "";
    public Serving.Resource resource = null;
    public Serving.Supplemental[] supplemental = Serving.Supplemental.EMPTY_ARRAY;
    
    public static SupplementedResource parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new SupplementedResource().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static SupplementedResource parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (SupplementedResource)MessageNano.mergeFrom(new SupplementedResource(), paramArrayOfByte);
    }
    
    public final SupplementedResource clear()
    {
      this.supplemental = Serving.Supplemental.EMPTY_ARRAY;
      this.resource = null;
      this.fingerprint = "";
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label63:
      do
      {
        return true;
        if (!(paramObject instanceof SupplementedResource)) {
          return false;
        }
        paramObject = (SupplementedResource)paramObject;
        if (!Arrays.equals(this.supplemental, ((SupplementedResource)paramObject).supplemental)) {
          break;
        }
        if (this.resource != null) {
          break label79;
        }
        if (((SupplementedResource)paramObject).resource != null) {
          break;
        }
        if (this.fingerprint != null) {
          break label96;
        }
        if (((SupplementedResource)paramObject).fingerprint != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label113;
        }
      } while (((SupplementedResource)paramObject).unknownFieldData == null);
      label79:
      label96:
      label113:
      while (!this.unknownFieldData.equals(((SupplementedResource)paramObject).unknownFieldData))
      {
        do
        {
          do
          {
            return false;
          } while (!this.resource.equals(((SupplementedResource)paramObject).resource));
          break;
        } while (!this.fingerprint.equals(((SupplementedResource)paramObject).fingerprint));
        break label63;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      int j = 0;
      if (this.supplemental != null)
      {
        Serving.Supplemental[] arrayOfSupplemental = this.supplemental;
        int m = arrayOfSupplemental.length;
        int k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(1, arrayOfSupplemental[k]);
          k += 1;
        }
      }
      j = i;
      if (this.resource != null) {
        j = i + CodedOutputByteBufferNano.computeMessageSize(2, this.resource);
      }
      i = j;
      if (!this.fingerprint.equals("")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(3, this.fingerprint);
      }
      i += WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int m = 0;
      int i = 17;
      int j;
      label28:
      int k;
      if (this.supplemental == null)
      {
        j = 17 * 31;
        if (this.resource != null) {
          break label113;
        }
        i = 0;
        if (this.fingerprint != null) {
          break label124;
        }
        k = 0;
        label37:
        if (this.unknownFieldData != null) {
          break label135;
        }
      }
      for (;;)
      {
        return ((j * 31 + i) * 31 + k) * 31 + m;
        k = 0;
        j = i;
        if (k >= this.supplemental.length) {
          break;
        }
        if (this.supplemental[k] == null) {}
        for (j = 0;; j = this.supplemental[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        label113:
        i = this.resource.hashCode();
        break label28;
        label124:
        k = this.fingerprint.hashCode();
        break label37;
        label135:
        m = this.unknownFieldData.hashCode();
      }
    }
    
    public SupplementedResource mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        case 10: 
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
          if (this.supplemental == null) {}
          for (i = 0;; i = this.supplemental.length)
          {
            Serving.Supplemental[] arrayOfSupplemental = new Serving.Supplemental[i + j];
            if (this.supplemental != null) {
              System.arraycopy(this.supplemental, 0, arrayOfSupplemental, 0, i);
            }
            this.supplemental = arrayOfSupplemental;
            while (i < this.supplemental.length - 1)
            {
              this.supplemental[i] = new Serving.Supplemental();
              paramCodedInputByteBufferNano.readMessage(this.supplemental[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.supplemental[i] = new Serving.Supplemental();
          paramCodedInputByteBufferNano.readMessage(this.supplemental[i]);
          break;
        case 18: 
          this.resource = new Serving.Resource();
          paramCodedInputByteBufferNano.readMessage(this.resource);
          break;
        case 26: 
          this.fingerprint = paramCodedInputByteBufferNano.readString();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.supplemental != null)
      {
        Serving.Supplemental[] arrayOfSupplemental = this.supplemental;
        int j = arrayOfSupplemental.length;
        int i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(1, arrayOfSupplemental[i]);
          i += 1;
        }
      }
      if (this.resource != null) {
        paramCodedOutputByteBufferNano.writeMessage(2, this.resource);
      }
      if (!this.fingerprint.equals("")) {
        paramCodedOutputByteBufferNano.writeString(3, this.fingerprint);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/containertag/proto/Serving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */