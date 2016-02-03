package com.google.analytics.midtier.proto.containertag;

import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.ExtendableMessageNano;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract interface TypeSystem
{
  public static final class Value
    extends ExtendableMessageNano
  {
    public static final Value[] EMPTY_ARRAY = new Value[0];
    public boolean boolean_ = false;
    public boolean containsReferences = false;
    public int[] escaping = WireFormatNano.EMPTY_INT_ARRAY;
    public String functionId = "";
    public long integer = 0L;
    public Value[] listItem = EMPTY_ARRAY;
    public String macroReference = "";
    public Value[] mapKey = EMPTY_ARRAY;
    public Value[] mapValue = EMPTY_ARRAY;
    public String string = "";
    public String tagReference = "";
    public Value[] templateToken = EMPTY_ARRAY;
    public int type = 1;
    
    public static Value parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new Value().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static Value parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (Value)MessageNano.mergeFrom(new Value(), paramArrayOfByte);
    }
    
    public final Value clear()
    {
      this.type = 1;
      this.string = "";
      this.listItem = EMPTY_ARRAY;
      this.mapKey = EMPTY_ARRAY;
      this.mapValue = EMPTY_ARRAY;
      this.macroReference = "";
      this.functionId = "";
      this.integer = 0L;
      this.boolean_ = false;
      this.templateToken = EMPTY_ARRAY;
      this.tagReference = "";
      this.escaping = WireFormatNano.EMPTY_INT_ARRAY;
      this.containsReferences = false;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label102:
      label116:
      label167:
      do
      {
        return true;
        if (!(paramObject instanceof Value)) {
          return false;
        }
        paramObject = (Value)paramObject;
        if (this.type != ((Value)paramObject).type) {
          break;
        }
        if (this.string != null) {
          break label208;
        }
        if (((Value)paramObject).string != null) {
          break;
        }
        if ((!Arrays.equals(this.listItem, ((Value)paramObject).listItem)) || (!Arrays.equals(this.mapKey, ((Value)paramObject).mapKey)) || (!Arrays.equals(this.mapValue, ((Value)paramObject).mapValue))) {
          break;
        }
        if (this.macroReference != null) {
          break label225;
        }
        if (((Value)paramObject).macroReference != null) {
          break;
        }
        if (this.functionId != null) {
          break label242;
        }
        if (((Value)paramObject).functionId != null) {
          break;
        }
        if ((this.integer != ((Value)paramObject).integer) || (this.boolean_ != ((Value)paramObject).boolean_) || (!Arrays.equals(this.templateToken, ((Value)paramObject).templateToken))) {
          break;
        }
        if (this.tagReference != null) {
          break label259;
        }
        if (((Value)paramObject).tagReference != null) {
          break;
        }
        if ((!Arrays.equals(this.escaping, ((Value)paramObject).escaping)) || (this.containsReferences != ((Value)paramObject).containsReferences)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label276;
        }
      } while (((Value)paramObject).unknownFieldData == null);
      label208:
      label225:
      label242:
      label259:
      label276:
      while (!this.unknownFieldData.equals(((Value)paramObject).unknownFieldData))
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
              } while (!this.string.equals(((Value)paramObject).string));
              break;
            } while (!this.macroReference.equals(((Value)paramObject).macroReference));
            break label102;
          } while (!this.functionId.equals(((Value)paramObject).functionId));
          break label116;
        } while (!this.tagReference.equals(((Value)paramObject).tagReference));
        break label167;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.type);
      int j = i;
      if (!this.string.equals("")) {
        j = i + CodedOutputByteBufferNano.computeStringSize(2, this.string);
      }
      i = j;
      Object localObject;
      int m;
      if (this.listItem != null)
      {
        localObject = this.listItem;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(3, localObject[k]);
          k += 1;
        }
      }
      j = i;
      if (this.mapKey != null)
      {
        localObject = this.mapKey;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(4, localObject[k]);
          k += 1;
        }
      }
      i = j;
      if (this.mapValue != null)
      {
        localObject = this.mapValue;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(5, localObject[k]);
          k += 1;
        }
      }
      j = i;
      if (!this.macroReference.equals("")) {
        j = i + CodedOutputByteBufferNano.computeStringSize(6, this.macroReference);
      }
      i = j;
      if (!this.functionId.equals("")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(7, this.functionId);
      }
      int k = i;
      if (this.integer != 0L) {
        k = i + CodedOutputByteBufferNano.computeInt64Size(8, this.integer);
      }
      j = k;
      if (this.containsReferences) {
        j = k + CodedOutputByteBufferNano.computeBoolSize(9, this.containsReferences);
      }
      i = j;
      if (this.escaping != null)
      {
        i = j;
        if (this.escaping.length > 0)
        {
          k = 0;
          localObject = this.escaping;
          m = localObject.length;
          i = 0;
          while (i < m)
          {
            k += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[i]);
            i += 1;
          }
          i = j + k + this.escaping.length * 1;
        }
      }
      j = i;
      if (this.templateToken != null)
      {
        localObject = this.templateToken;
        m = localObject.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(11, localObject[k]);
          k += 1;
        }
      }
      i = j;
      if (this.boolean_) {
        i = j + CodedOutputByteBufferNano.computeBoolSize(12, this.boolean_);
      }
      j = i;
      if (!this.tagReference.equals("")) {
        j = i + CodedOutputByteBufferNano.computeStringSize(13, this.tagReference);
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int i1 = 1;
      int n = 0;
      int j = this.type;
      int i;
      label43:
      label55:
      label67:
      label76:
      label85:
      int m;
      if (this.string == null)
      {
        i = 0;
        i = (j + 527) * 31 + i;
        if (this.listItem != null) {
          break label217;
        }
        j = i * 31;
        if (this.mapKey != null) {
          break label268;
        }
        j *= 31;
        if (this.mapValue != null) {
          break label321;
        }
        j *= 31;
        if (this.macroReference != null) {
          break label374;
        }
        i = 0;
        if (this.functionId != null) {
          break label385;
        }
        k = 0;
        int i2 = (int)(this.integer ^ this.integer >>> 32);
        if (!this.boolean_) {
          break label396;
        }
        m = 1;
        label110:
        i = (((j * 31 + i) * 31 + k) * 31 + i2) * 31 + m;
        if (this.templateToken != null) {
          break label402;
        }
        k = i * 31;
        label146:
        if (this.tagReference != null) {
          break label453;
        }
        i = 0;
        label155:
        i = k * 31 + i;
        if (this.escaping != null) {
          break label464;
        }
        j = i * 31;
        if (!this.containsReferences) {
          break label496;
        }
        i = i1;
        label184:
        if (this.unknownFieldData != null) {
          break label501;
        }
      }
      label217:
      label268:
      label321:
      label374:
      label385:
      label396:
      label402:
      label453:
      label464:
      label496:
      label501:
      for (int k = n;; k = this.unknownFieldData.hashCode())
      {
        return (j * 31 + i) * 31 + k;
        i = this.string.hashCode();
        break;
        k = 0;
        j = i;
        if (k >= this.listItem.length) {
          break label43;
        }
        if (this.listItem[k] == null) {}
        for (j = 0;; j = this.listItem[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.mapKey.length) {
          break label55;
        }
        if (this.mapKey[k] == null) {}
        for (j = 0;; j = this.mapKey[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.mapValue.length) {
          break label67;
        }
        if (this.mapValue[k] == null) {}
        for (j = 0;; j = this.mapValue[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        i = this.macroReference.hashCode();
        break label76;
        k = this.functionId.hashCode();
        break label85;
        m = 2;
        break label110;
        j = 0;
        k = i;
        if (j >= this.templateToken.length) {
          break label146;
        }
        if (this.templateToken[j] == null) {}
        for (k = 0;; k = this.templateToken[j].hashCode())
        {
          i = i * 31 + k;
          j += 1;
          break;
        }
        i = this.tagReference.hashCode();
        break label155;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.escaping.length) {
            break;
          }
          i = i * 31 + this.escaping[k];
          k += 1;
        }
        i = 2;
        break label184;
      }
    }
    
    public Value mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        case 8: 
          i = paramCodedInputByteBufferNano.readInt32();
          if ((i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5) || (i == 6) || (i == 7) || (i == 8) || (i == 9)) {
            this.type = i;
          } else {
            this.type = 1;
          }
          break;
        case 18: 
          this.string = paramCodedInputByteBufferNano.readString();
          break;
        case 26: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
          if (this.listItem == null) {}
          for (i = 0;; i = this.listItem.length)
          {
            localObject = new Value[i + j];
            if (this.listItem != null) {
              System.arraycopy(this.listItem, 0, localObject, 0, i);
            }
            this.listItem = ((Value[])localObject);
            while (i < this.listItem.length - 1)
            {
              this.listItem[i] = new Value();
              paramCodedInputByteBufferNano.readMessage(this.listItem[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.listItem[i] = new Value();
          paramCodedInputByteBufferNano.readMessage(this.listItem[i]);
          break;
        case 34: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
          if (this.mapKey == null) {}
          for (i = 0;; i = this.mapKey.length)
          {
            localObject = new Value[i + j];
            if (this.mapKey != null) {
              System.arraycopy(this.mapKey, 0, localObject, 0, i);
            }
            this.mapKey = ((Value[])localObject);
            while (i < this.mapKey.length - 1)
            {
              this.mapKey[i] = new Value();
              paramCodedInputByteBufferNano.readMessage(this.mapKey[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.mapKey[i] = new Value();
          paramCodedInputByteBufferNano.readMessage(this.mapKey[i]);
          break;
        case 42: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
          if (this.mapValue == null) {}
          for (i = 0;; i = this.mapValue.length)
          {
            localObject = new Value[i + j];
            if (this.mapValue != null) {
              System.arraycopy(this.mapValue, 0, localObject, 0, i);
            }
            this.mapValue = ((Value[])localObject);
            while (i < this.mapValue.length - 1)
            {
              this.mapValue[i] = new Value();
              paramCodedInputByteBufferNano.readMessage(this.mapValue[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.mapValue[i] = new Value();
          paramCodedInputByteBufferNano.readMessage(this.mapValue[i]);
          break;
        case 50: 
          this.macroReference = paramCodedInputByteBufferNano.readString();
          break;
        case 58: 
          this.functionId = paramCodedInputByteBufferNano.readString();
          break;
        case 64: 
          this.integer = paramCodedInputByteBufferNano.readInt64();
          break;
        case 72: 
          this.containsReferences = paramCodedInputByteBufferNano.readBool();
          break;
        case 80: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 80);
          i = this.escaping.length;
          localObject = new int[i + j];
          System.arraycopy(this.escaping, 0, localObject, 0, i);
          this.escaping = ((int[])localObject);
          while (i < this.escaping.length - 1)
          {
            this.escaping[i] = paramCodedInputByteBufferNano.readInt32();
            paramCodedInputByteBufferNano.readTag();
            i += 1;
          }
          this.escaping[i] = paramCodedInputByteBufferNano.readInt32();
          break;
        case 90: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
          if (this.templateToken == null) {}
          for (i = 0;; i = this.templateToken.length)
          {
            localObject = new Value[i + j];
            if (this.templateToken != null) {
              System.arraycopy(this.templateToken, 0, localObject, 0, i);
            }
            this.templateToken = ((Value[])localObject);
            while (i < this.templateToken.length - 1)
            {
              this.templateToken[i] = new Value();
              paramCodedInputByteBufferNano.readMessage(this.templateToken[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.templateToken[i] = new Value();
          paramCodedInputByteBufferNano.readMessage(this.templateToken[i]);
          break;
        case 96: 
          this.boolean_ = paramCodedInputByteBufferNano.readBool();
          break;
        case 106: 
          this.tagReference = paramCodedInputByteBufferNano.readString();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      paramCodedOutputByteBufferNano.writeInt32(1, this.type);
      if (!this.string.equals("")) {
        paramCodedOutputByteBufferNano.writeString(2, this.string);
      }
      Object localObject;
      int j;
      int i;
      if (this.listItem != null)
      {
        localObject = this.listItem;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(3, localObject[i]);
          i += 1;
        }
      }
      if (this.mapKey != null)
      {
        localObject = this.mapKey;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(4, localObject[i]);
          i += 1;
        }
      }
      if (this.mapValue != null)
      {
        localObject = this.mapValue;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(5, localObject[i]);
          i += 1;
        }
      }
      if (!this.macroReference.equals("")) {
        paramCodedOutputByteBufferNano.writeString(6, this.macroReference);
      }
      if (!this.functionId.equals("")) {
        paramCodedOutputByteBufferNano.writeString(7, this.functionId);
      }
      if (this.integer != 0L) {
        paramCodedOutputByteBufferNano.writeInt64(8, this.integer);
      }
      if (this.containsReferences) {
        paramCodedOutputByteBufferNano.writeBool(9, this.containsReferences);
      }
      if ((this.escaping != null) && (this.escaping.length > 0))
      {
        localObject = this.escaping;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeInt32(10, localObject[i]);
          i += 1;
        }
      }
      if (this.templateToken != null)
      {
        localObject = this.templateToken;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(11, localObject[i]);
          i += 1;
        }
      }
      if (this.boolean_) {
        paramCodedOutputByteBufferNano.writeBool(12, this.boolean_);
      }
      if (!this.tagReference.equals("")) {
        paramCodedOutputByteBufferNano.writeString(13, this.tagReference);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
    
    public static abstract interface Escaping
    {
      public static final int CONVERT_JS_VALUE_TO_EXPRESSION = 16;
      public static final int ESCAPE_CSS_STRING = 10;
      public static final int ESCAPE_HTML = 1;
      public static final int ESCAPE_HTML_ATTRIBUTE = 3;
      public static final int ESCAPE_HTML_ATTRIBUTE_NOSPACE = 4;
      public static final int ESCAPE_HTML_RCDATA = 2;
      public static final int ESCAPE_JS_REGEX = 9;
      public static final int ESCAPE_JS_STRING = 7;
      public static final int ESCAPE_JS_VALUE = 8;
      public static final int ESCAPE_URI = 12;
      public static final int FILTER_CSS_VALUE = 11;
      public static final int FILTER_HTML_ATTRIBUTES = 6;
      public static final int FILTER_HTML_ELEMENT_NAME = 5;
      public static final int FILTER_NORMALIZE_URI = 14;
      public static final int NORMALIZE_URI = 13;
      public static final int NO_AUTOESCAPE = 15;
      public static final int TEXT = 17;
    }
    
    public static abstract interface Type
    {
      public static final int BOOLEAN = 8;
      public static final int FUNCTION_ID = 5;
      public static final int INTEGER = 6;
      public static final int LIST = 2;
      public static final int MACRO_REFERENCE = 4;
      public static final int MAP = 3;
      public static final int STRING = 1;
      public static final int TAG_REFERENCE = 9;
      public static final int TEMPLATE = 7;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/midtier/proto/containertag/TypeSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */