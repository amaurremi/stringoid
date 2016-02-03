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

public abstract interface Debug
{
  public static final class DataLayerEventEvaluationInfo
    extends ExtendableMessageNano
  {
    public static final DataLayerEventEvaluationInfo[] EMPTY_ARRAY = new DataLayerEventEvaluationInfo[0];
    public Debug.ResolvedFunctionCall[] results = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
    public Debug.RuleEvaluationStepInfo rulesEvaluation = null;
    
    public static DataLayerEventEvaluationInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new DataLayerEventEvaluationInfo().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static DataLayerEventEvaluationInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (DataLayerEventEvaluationInfo)MessageNano.mergeFrom(new DataLayerEventEvaluationInfo(), paramArrayOfByte);
    }
    
    public final DataLayerEventEvaluationInfo clear()
    {
      this.rulesEvaluation = null;
      this.results = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
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
        if (!(paramObject instanceof DataLayerEventEvaluationInfo)) {
          return false;
        }
        paramObject = (DataLayerEventEvaluationInfo)paramObject;
        if (this.rulesEvaluation != null) {
          break label65;
        }
        if (((DataLayerEventEvaluationInfo)paramObject).rulesEvaluation != null) {
          break;
        }
        if (!Arrays.equals(this.results, ((DataLayerEventEvaluationInfo)paramObject).results)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label82;
        }
      } while (((DataLayerEventEvaluationInfo)paramObject).unknownFieldData == null);
      label65:
      label82:
      while (!this.unknownFieldData.equals(((DataLayerEventEvaluationInfo)paramObject).unknownFieldData))
      {
        do
        {
          return false;
        } while (!this.rulesEvaluation.equals(((DataLayerEventEvaluationInfo)paramObject).rulesEvaluation));
        break;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (this.rulesEvaluation != null) {
        i = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.rulesEvaluation);
      }
      int k = i;
      if (this.results != null)
      {
        Debug.ResolvedFunctionCall[] arrayOfResolvedFunctionCall = this.results;
        int m = arrayOfResolvedFunctionCall.length;
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(2, arrayOfResolvedFunctionCall[j]);
          j += 1;
        }
      }
      i = k + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int m = 0;
      int k;
      if (this.rulesEvaluation == null)
      {
        i = 0;
        i += 527;
        if (this.results != null) {
          break label58;
        }
        k = i * 31;
        label30:
        if (this.unknownFieldData != null) {
          break label109;
        }
      }
      label58:
      label109:
      for (int i = m;; i = this.unknownFieldData.hashCode())
      {
        return k * 31 + i;
        i = this.rulesEvaluation.hashCode();
        break;
        int j = 0;
        k = i;
        if (j >= this.results.length) {
          break label30;
        }
        if (this.results[j] == null) {}
        for (k = 0;; k = this.results[j].hashCode())
        {
          i = i * 31 + k;
          j += 1;
          break;
        }
      }
    }
    
    public DataLayerEventEvaluationInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
          paramCodedInputByteBufferNano.readMessage(this.rulesEvaluation);
          break;
        case 18: 
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          if (this.results == null) {}
          for (i = 0;; i = this.results.length)
          {
            Debug.ResolvedFunctionCall[] arrayOfResolvedFunctionCall = new Debug.ResolvedFunctionCall[i + j];
            if (this.results != null) {
              System.arraycopy(this.results, 0, arrayOfResolvedFunctionCall, 0, i);
            }
            this.results = arrayOfResolvedFunctionCall;
            while (i < this.results.length - 1)
            {
              this.results[i] = new Debug.ResolvedFunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.results[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.results[i] = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.results[i]);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.rulesEvaluation != null) {
        paramCodedOutputByteBufferNano.writeMessage(1, this.rulesEvaluation);
      }
      if (this.results != null)
      {
        Debug.ResolvedFunctionCall[] arrayOfResolvedFunctionCall = this.results;
        int j = arrayOfResolvedFunctionCall.length;
        int i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(2, arrayOfResolvedFunctionCall[i]);
          i += 1;
        }
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class DebugEvents
    extends ExtendableMessageNano
  {
    public static final DebugEvents[] EMPTY_ARRAY = new DebugEvents[0];
    public Debug.EventInfo[] event = Debug.EventInfo.EMPTY_ARRAY;
    
    public static DebugEvents parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new DebugEvents().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static DebugEvents parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (DebugEvents)MessageNano.mergeFrom(new DebugEvents(), paramArrayOfByte);
    }
    
    public final DebugEvents clear()
    {
      this.event = Debug.EventInfo.EMPTY_ARRAY;
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
        if (!(paramObject instanceof DebugEvents)) {
          return false;
        }
        paramObject = (DebugEvents)paramObject;
        if (!Arrays.equals(this.event, ((DebugEvents)paramObject).event)) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label51;
        }
      } while (((DebugEvents)paramObject).unknownFieldData == null);
      label51:
      while (!this.unknownFieldData.equals(((DebugEvents)paramObject).unknownFieldData)) {
        return false;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      int i = 0;
      if (this.event != null)
      {
        Debug.EventInfo[] arrayOfEventInfo = this.event;
        int m = arrayOfEventInfo.length;
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(1, arrayOfEventInfo[j]);
          j += 1;
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
      int k;
      if (this.event == null)
      {
        k = 17 * 31;
        if (this.unknownFieldData != null) {
          break label87;
        }
      }
      label87:
      for (i = m;; i = this.unknownFieldData.hashCode())
      {
        return k * 31 + i;
        int j = 0;
        k = i;
        if (j >= this.event.length) {
          break;
        }
        if (this.event[j] == null) {}
        for (k = 0;; k = this.event[j].hashCode())
        {
          i = i * 31 + k;
          j += 1;
          break;
        }
      }
    }
    
    public DebugEvents mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (this.event == null) {}
          for (i = 0;; i = this.event.length)
          {
            Debug.EventInfo[] arrayOfEventInfo = new Debug.EventInfo[i + j];
            if (this.event != null) {
              System.arraycopy(this.event, 0, arrayOfEventInfo, 0, i);
            }
            this.event = arrayOfEventInfo;
            while (i < this.event.length - 1)
            {
              this.event[i] = new Debug.EventInfo();
              paramCodedInputByteBufferNano.readMessage(this.event[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.event[i] = new Debug.EventInfo();
          paramCodedInputByteBufferNano.readMessage(this.event[i]);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.event != null)
      {
        Debug.EventInfo[] arrayOfEventInfo = this.event;
        int j = arrayOfEventInfo.length;
        int i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(1, arrayOfEventInfo[i]);
          i += 1;
        }
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class EventInfo
    extends ExtendableMessageNano
  {
    public static final EventInfo[] EMPTY_ARRAY = new EventInfo[0];
    public String containerId = "";
    public String containerVersion = "";
    public Debug.DataLayerEventEvaluationInfo dataLayerEventResult = null;
    public int eventType = 1;
    public String key = "";
    public Debug.MacroEvaluationInfo macroResult = null;
    
    public static EventInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new EventInfo().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static EventInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (EventInfo)MessageNano.mergeFrom(new EventInfo(), paramArrayOfByte);
    }
    
    public final EventInfo clear()
    {
      this.eventType = 1;
      this.containerVersion = "";
      this.containerId = "";
      this.key = "";
      this.macroResult = null;
      this.dataLayerEventResult = null;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label60:
      label74:
      label88:
      label102:
      do
      {
        return true;
        if (!(paramObject instanceof EventInfo)) {
          return false;
        }
        paramObject = (EventInfo)paramObject;
        if (this.eventType != ((EventInfo)paramObject).eventType) {
          break;
        }
        if (this.containerVersion != null) {
          break label118;
        }
        if (((EventInfo)paramObject).containerVersion != null) {
          break;
        }
        if (this.containerId != null) {
          break label135;
        }
        if (((EventInfo)paramObject).containerId != null) {
          break;
        }
        if (this.key != null) {
          break label152;
        }
        if (((EventInfo)paramObject).key != null) {
          break;
        }
        if (this.macroResult != null) {
          break label169;
        }
        if (((EventInfo)paramObject).macroResult != null) {
          break;
        }
        if (this.dataLayerEventResult != null) {
          break label186;
        }
        if (((EventInfo)paramObject).dataLayerEventResult != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label203;
        }
      } while (((EventInfo)paramObject).unknownFieldData == null);
      label118:
      label135:
      label152:
      label169:
      label186:
      label203:
      while (!this.unknownFieldData.equals(((EventInfo)paramObject).unknownFieldData))
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
                } while (!this.containerVersion.equals(((EventInfo)paramObject).containerVersion));
                break;
              } while (!this.containerId.equals(((EventInfo)paramObject).containerId));
              break label60;
            } while (!this.key.equals(((EventInfo)paramObject).key));
            break label74;
          } while (!this.macroResult.equals(((EventInfo)paramObject).macroResult));
          break label88;
        } while (!this.dataLayerEventResult.equals(((EventInfo)paramObject).dataLayerEventResult));
        break label102;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (this.eventType != 1) {
        j = 0 + CodedOutputByteBufferNano.computeInt32Size(1, this.eventType);
      }
      int i = j;
      if (!this.containerVersion.equals("")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(2, this.containerVersion);
      }
      j = i;
      if (!this.containerId.equals("")) {
        j = i + CodedOutputByteBufferNano.computeStringSize(3, this.containerId);
      }
      i = j;
      if (!this.key.equals("")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(4, this.key);
      }
      j = i;
      if (this.macroResult != null) {
        j = i + CodedOutputByteBufferNano.computeMessageSize(6, this.macroResult);
      }
      i = j;
      if (this.dataLayerEventResult != null) {
        i = j + CodedOutputByteBufferNano.computeMessageSize(7, this.dataLayerEventResult);
      }
      i += WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int i1 = 0;
      int i2 = this.eventType;
      int i;
      int j;
      label27:
      int k;
      label36:
      int m;
      label46:
      int n;
      if (this.containerVersion == null)
      {
        i = 0;
        if (this.containerId != null) {
          break label114;
        }
        j = 0;
        if (this.key != null) {
          break label125;
        }
        k = 0;
        if (this.macroResult != null) {
          break label136;
        }
        m = 0;
        if (this.dataLayerEventResult != null) {
          break label148;
        }
        n = 0;
        label56:
        if (this.unknownFieldData != null) {
          break label160;
        }
      }
      for (;;)
      {
        return ((((((i2 + 527) * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
        i = this.containerVersion.hashCode();
        break;
        label114:
        j = this.containerId.hashCode();
        break label27;
        label125:
        k = this.key.hashCode();
        break label36;
        label136:
        m = this.macroResult.hashCode();
        break label46;
        label148:
        n = this.dataLayerEventResult.hashCode();
        break label56;
        label160:
        i1 = this.unknownFieldData.hashCode();
      }
    }
    
    public EventInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if ((i == 1) || (i == 2)) {
            this.eventType = i;
          } else {
            this.eventType = 1;
          }
          break;
        case 18: 
          this.containerVersion = paramCodedInputByteBufferNano.readString();
          break;
        case 26: 
          this.containerId = paramCodedInputByteBufferNano.readString();
          break;
        case 34: 
          this.key = paramCodedInputByteBufferNano.readString();
          break;
        case 50: 
          this.macroResult = new Debug.MacroEvaluationInfo();
          paramCodedInputByteBufferNano.readMessage(this.macroResult);
          break;
        case 58: 
          this.dataLayerEventResult = new Debug.DataLayerEventEvaluationInfo();
          paramCodedInputByteBufferNano.readMessage(this.dataLayerEventResult);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.eventType != 1) {
        paramCodedOutputByteBufferNano.writeInt32(1, this.eventType);
      }
      if (!this.containerVersion.equals("")) {
        paramCodedOutputByteBufferNano.writeString(2, this.containerVersion);
      }
      if (!this.containerId.equals("")) {
        paramCodedOutputByteBufferNano.writeString(3, this.containerId);
      }
      if (!this.key.equals("")) {
        paramCodedOutputByteBufferNano.writeString(4, this.key);
      }
      if (this.macroResult != null) {
        paramCodedOutputByteBufferNano.writeMessage(6, this.macroResult);
      }
      if (this.dataLayerEventResult != null) {
        paramCodedOutputByteBufferNano.writeMessage(7, this.dataLayerEventResult);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
    
    public static abstract interface EventType
    {
      public static final int DATA_LAYER_EVENT = 1;
      public static final int MACRO_REFERENCE = 2;
    }
  }
  
  public static final class MacroEvaluationInfo
    extends ExtendableMessageNano
  {
    public static final MacroEvaluationInfo[] EMPTY_ARRAY = new MacroEvaluationInfo[0];
    public static final Extension<MacroEvaluationInfo> macro = Extension.create(47497405, new Extension.TypeLiteral() {});
    public Debug.ResolvedFunctionCall result = null;
    public Debug.RuleEvaluationStepInfo rulesEvaluation = null;
    
    public static MacroEvaluationInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new MacroEvaluationInfo().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static MacroEvaluationInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (MacroEvaluationInfo)MessageNano.mergeFrom(new MacroEvaluationInfo(), paramArrayOfByte);
    }
    
    public final MacroEvaluationInfo clear()
    {
      this.rulesEvaluation = null;
      this.result = null;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label49:
      do
      {
        return true;
        if (!(paramObject instanceof MacroEvaluationInfo)) {
          return false;
        }
        paramObject = (MacroEvaluationInfo)paramObject;
        if (this.rulesEvaluation != null) {
          break label65;
        }
        if (((MacroEvaluationInfo)paramObject).rulesEvaluation != null) {
          break;
        }
        if (this.result != null) {
          break label82;
        }
        if (((MacroEvaluationInfo)paramObject).result != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label99;
        }
      } while (((MacroEvaluationInfo)paramObject).unknownFieldData == null);
      label65:
      label82:
      label99:
      while (!this.unknownFieldData.equals(((MacroEvaluationInfo)paramObject).unknownFieldData))
      {
        do
        {
          do
          {
            return false;
          } while (!this.rulesEvaluation.equals(((MacroEvaluationInfo)paramObject).rulesEvaluation));
          break;
        } while (!this.result.equals(((MacroEvaluationInfo)paramObject).result));
        break label49;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (this.rulesEvaluation != null) {
        i = 0 + CodedOutputByteBufferNano.computeMessageSize(1, this.rulesEvaluation);
      }
      int j = i;
      if (this.result != null) {
        j = i + CodedOutputByteBufferNano.computeMessageSize(3, this.result);
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int k = 0;
      int i;
      int j;
      if (this.rulesEvaluation == null)
      {
        i = 0;
        if (this.result != null) {
          break label54;
        }
        j = 0;
        label20:
        if (this.unknownFieldData != null) {
          break label65;
        }
      }
      for (;;)
      {
        return ((i + 527) * 31 + j) * 31 + k;
        i = this.rulesEvaluation.hashCode();
        break;
        label54:
        j = this.result.hashCode();
        break label20;
        label65:
        k = this.unknownFieldData.hashCode();
      }
    }
    
    public MacroEvaluationInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          this.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
          paramCodedInputByteBufferNano.readMessage(this.rulesEvaluation);
          break;
        case 26: 
          this.result = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.result);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.rulesEvaluation != null) {
        paramCodedOutputByteBufferNano.writeMessage(1, this.rulesEvaluation);
      }
      if (this.result != null) {
        paramCodedOutputByteBufferNano.writeMessage(3, this.result);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class ResolvedFunctionCall
    extends ExtendableMessageNano
  {
    public static final ResolvedFunctionCall[] EMPTY_ARRAY = new ResolvedFunctionCall[0];
    public String associatedRuleName = "";
    public Debug.ResolvedProperty[] properties = Debug.ResolvedProperty.EMPTY_ARRAY;
    public TypeSystem.Value result = null;
    
    public static ResolvedFunctionCall parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new ResolvedFunctionCall().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static ResolvedFunctionCall parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (ResolvedFunctionCall)MessageNano.mergeFrom(new ResolvedFunctionCall(), paramArrayOfByte);
    }
    
    public final ResolvedFunctionCall clear()
    {
      this.properties = Debug.ResolvedProperty.EMPTY_ARRAY;
      this.result = null;
      this.associatedRuleName = "";
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
        if (!(paramObject instanceof ResolvedFunctionCall)) {
          return false;
        }
        paramObject = (ResolvedFunctionCall)paramObject;
        if (!Arrays.equals(this.properties, ((ResolvedFunctionCall)paramObject).properties)) {
          break;
        }
        if (this.result != null) {
          break label79;
        }
        if (((ResolvedFunctionCall)paramObject).result != null) {
          break;
        }
        if (this.associatedRuleName != null) {
          break label96;
        }
        if (((ResolvedFunctionCall)paramObject).associatedRuleName != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label113;
        }
      } while (((ResolvedFunctionCall)paramObject).unknownFieldData == null);
      label79:
      label96:
      label113:
      while (!this.unknownFieldData.equals(((ResolvedFunctionCall)paramObject).unknownFieldData))
      {
        do
        {
          do
          {
            return false;
          } while (!this.result.equals(((ResolvedFunctionCall)paramObject).result));
          break;
        } while (!this.associatedRuleName.equals(((ResolvedFunctionCall)paramObject).associatedRuleName));
        break label63;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      int j = 0;
      if (this.properties != null)
      {
        Debug.ResolvedProperty[] arrayOfResolvedProperty = this.properties;
        int m = arrayOfResolvedProperty.length;
        int k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(1, arrayOfResolvedProperty[k]);
          k += 1;
        }
      }
      j = i;
      if (this.result != null) {
        j = i + CodedOutputByteBufferNano.computeMessageSize(2, this.result);
      }
      i = j;
      if (!this.associatedRuleName.equals("")) {
        i = j + CodedOutputByteBufferNano.computeStringSize(3, this.associatedRuleName);
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
      if (this.properties == null)
      {
        j = 17 * 31;
        if (this.result != null) {
          break label113;
        }
        i = 0;
        if (this.associatedRuleName != null) {
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
        if (k >= this.properties.length) {
          break;
        }
        if (this.properties[k] == null) {}
        for (j = 0;; j = this.properties[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        label113:
        i = this.result.hashCode();
        break label28;
        label124:
        k = this.associatedRuleName.hashCode();
        break label37;
        label135:
        m = this.unknownFieldData.hashCode();
      }
    }
    
    public ResolvedFunctionCall mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (this.properties == null) {}
          for (i = 0;; i = this.properties.length)
          {
            Debug.ResolvedProperty[] arrayOfResolvedProperty = new Debug.ResolvedProperty[i + j];
            if (this.properties != null) {
              System.arraycopy(this.properties, 0, arrayOfResolvedProperty, 0, i);
            }
            this.properties = arrayOfResolvedProperty;
            while (i < this.properties.length - 1)
            {
              this.properties[i] = new Debug.ResolvedProperty();
              paramCodedInputByteBufferNano.readMessage(this.properties[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.properties[i] = new Debug.ResolvedProperty();
          paramCodedInputByteBufferNano.readMessage(this.properties[i]);
          break;
        case 18: 
          this.result = new TypeSystem.Value();
          paramCodedInputByteBufferNano.readMessage(this.result);
          break;
        case 26: 
          this.associatedRuleName = paramCodedInputByteBufferNano.readString();
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (this.properties != null)
      {
        Debug.ResolvedProperty[] arrayOfResolvedProperty = this.properties;
        int j = arrayOfResolvedProperty.length;
        int i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(1, arrayOfResolvedProperty[i]);
          i += 1;
        }
      }
      if (this.result != null) {
        paramCodedOutputByteBufferNano.writeMessage(2, this.result);
      }
      if (!this.associatedRuleName.equals("")) {
        paramCodedOutputByteBufferNano.writeString(3, this.associatedRuleName);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class ResolvedProperty
    extends ExtendableMessageNano
  {
    public static final ResolvedProperty[] EMPTY_ARRAY = new ResolvedProperty[0];
    public String key = "";
    public TypeSystem.Value value = null;
    
    public static ResolvedProperty parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new ResolvedProperty().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static ResolvedProperty parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (ResolvedProperty)MessageNano.mergeFrom(new ResolvedProperty(), paramArrayOfByte);
    }
    
    public final ResolvedProperty clear()
    {
      this.key = "";
      this.value = null;
      this.unknownFieldData = null;
      this.cachedSize = -1;
      return this;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      label49:
      do
      {
        return true;
        if (!(paramObject instanceof ResolvedProperty)) {
          return false;
        }
        paramObject = (ResolvedProperty)paramObject;
        if (this.key != null) {
          break label65;
        }
        if (((ResolvedProperty)paramObject).key != null) {
          break;
        }
        if (this.value != null) {
          break label82;
        }
        if (((ResolvedProperty)paramObject).value != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label99;
        }
      } while (((ResolvedProperty)paramObject).unknownFieldData == null);
      label65:
      label82:
      label99:
      while (!this.unknownFieldData.equals(((ResolvedProperty)paramObject).unknownFieldData))
      {
        do
        {
          do
          {
            return false;
          } while (!this.key.equals(((ResolvedProperty)paramObject).key));
          break;
        } while (!this.value.equals(((ResolvedProperty)paramObject).value));
        break label49;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (!this.key.equals("")) {
        i = 0 + CodedOutputByteBufferNano.computeStringSize(1, this.key);
      }
      int j = i;
      if (this.value != null) {
        j = i + CodedOutputByteBufferNano.computeMessageSize(2, this.value);
      }
      i = j + WireFormatNano.computeWireSize(this.unknownFieldData);
      this.cachedSize = i;
      return i;
    }
    
    public int hashCode()
    {
      int k = 0;
      int i;
      int j;
      if (this.key == null)
      {
        i = 0;
        if (this.value != null) {
          break label54;
        }
        j = 0;
        label20:
        if (this.unknownFieldData != null) {
          break label65;
        }
      }
      for (;;)
      {
        return ((i + 527) * 31 + j) * 31 + k;
        i = this.key.hashCode();
        break;
        label54:
        j = this.value.hashCode();
        break label20;
        label65:
        k = this.unknownFieldData.hashCode();
      }
    }
    
    public ResolvedProperty mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        case 18: 
          this.value = new TypeSystem.Value();
          paramCodedInputByteBufferNano.readMessage(this.value);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      if (!this.key.equals("")) {
        paramCodedOutputByteBufferNano.writeString(1, this.key);
      }
      if (this.value != null) {
        paramCodedOutputByteBufferNano.writeMessage(2, this.value);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class ResolvedRule
    extends ExtendableMessageNano
  {
    public static final ResolvedRule[] EMPTY_ARRAY = new ResolvedRule[0];
    public Debug.ResolvedFunctionCall[] addMacros = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
    public Debug.ResolvedFunctionCall[] addTags = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
    public Debug.ResolvedFunctionCall[] negativePredicates = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
    public Debug.ResolvedFunctionCall[] positivePredicates = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
    public Debug.ResolvedFunctionCall[] removeMacros = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
    public Debug.ResolvedFunctionCall[] removeTags = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
    public TypeSystem.Value result = null;
    
    public static ResolvedRule parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new ResolvedRule().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static ResolvedRule parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (ResolvedRule)MessageNano.mergeFrom(new ResolvedRule(), paramArrayOfByte);
    }
    
    public final ResolvedRule clear()
    {
      this.positivePredicates = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
      this.negativePredicates = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
      this.addTags = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
      this.removeTags = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
      this.addMacros = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
      this.removeMacros = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
      this.result = null;
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
        if (!(paramObject instanceof ResolvedRule)) {
          return false;
        }
        paramObject = (ResolvedRule)paramObject;
        if ((!Arrays.equals(this.positivePredicates, ((ResolvedRule)paramObject).positivePredicates)) || (!Arrays.equals(this.negativePredicates, ((ResolvedRule)paramObject).negativePredicates)) || (!Arrays.equals(this.addTags, ((ResolvedRule)paramObject).addTags)) || (!Arrays.equals(this.removeTags, ((ResolvedRule)paramObject).removeTags)) || (!Arrays.equals(this.addMacros, ((ResolvedRule)paramObject).addMacros)) || (!Arrays.equals(this.removeMacros, ((ResolvedRule)paramObject).removeMacros))) {
          break;
        }
        if (this.result != null) {
          break label135;
        }
        if (((ResolvedRule)paramObject).result != null) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label152;
        }
      } while (((ResolvedRule)paramObject).unknownFieldData == null);
      label135:
      label152:
      while (!this.unknownFieldData.equals(((ResolvedRule)paramObject).unknownFieldData))
      {
        do
        {
          return false;
        } while (!this.result.equals(((ResolvedRule)paramObject).result));
        break;
      }
      return true;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      int j = 0;
      Debug.ResolvedFunctionCall[] arrayOfResolvedFunctionCall;
      int m;
      int k;
      if (this.positivePredicates != null)
      {
        arrayOfResolvedFunctionCall = this.positivePredicates;
        m = arrayOfResolvedFunctionCall.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(1, arrayOfResolvedFunctionCall[k]);
          k += 1;
        }
      }
      j = i;
      if (this.negativePredicates != null)
      {
        arrayOfResolvedFunctionCall = this.negativePredicates;
        m = arrayOfResolvedFunctionCall.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(2, arrayOfResolvedFunctionCall[k]);
          k += 1;
        }
      }
      i = j;
      if (this.addTags != null)
      {
        arrayOfResolvedFunctionCall = this.addTags;
        m = arrayOfResolvedFunctionCall.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(3, arrayOfResolvedFunctionCall[k]);
          k += 1;
        }
      }
      j = i;
      if (this.removeTags != null)
      {
        arrayOfResolvedFunctionCall = this.removeTags;
        m = arrayOfResolvedFunctionCall.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(4, arrayOfResolvedFunctionCall[k]);
          k += 1;
        }
      }
      i = j;
      if (this.addMacros != null)
      {
        arrayOfResolvedFunctionCall = this.addMacros;
        m = arrayOfResolvedFunctionCall.length;
        k = 0;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += CodedOutputByteBufferNano.computeMessageSize(5, arrayOfResolvedFunctionCall[k]);
          k += 1;
        }
      }
      j = i;
      if (this.removeMacros != null)
      {
        arrayOfResolvedFunctionCall = this.removeMacros;
        m = arrayOfResolvedFunctionCall.length;
        k = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(6, arrayOfResolvedFunctionCall[k]);
          k += 1;
        }
      }
      i = j;
      if (this.result != null) {
        i = j + CodedOutputByteBufferNano.computeMessageSize(7, this.result);
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
      if (this.positivePredicates == null)
      {
        j = 17 * 31;
        if (this.negativePredicates != null) {
          break label161;
        }
        j *= 31;
        label31:
        if (this.addTags != null) {
          break label214;
        }
        j *= 31;
        label43:
        if (this.removeTags != null) {
          break label267;
        }
        j *= 31;
        label55:
        if (this.addMacros != null) {
          break label320;
        }
        j *= 31;
        label67:
        if (this.removeMacros != null) {
          break label373;
        }
        j *= 31;
        label79:
        if (this.result != null) {
          break label426;
        }
        i = 0;
        label88:
        if (this.unknownFieldData != null) {
          break label437;
        }
      }
      label161:
      label214:
      label267:
      label320:
      label373:
      label426:
      label437:
      for (int k = m;; k = this.unknownFieldData.hashCode())
      {
        return (j * 31 + i) * 31 + k;
        k = 0;
        j = i;
        if (k >= this.positivePredicates.length) {
          break;
        }
        if (this.positivePredicates[k] == null) {}
        for (j = 0;; j = this.positivePredicates[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.negativePredicates.length) {
          break label31;
        }
        if (this.negativePredicates[k] == null) {}
        for (j = 0;; j = this.negativePredicates[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.addTags.length) {
          break label43;
        }
        if (this.addTags[k] == null) {}
        for (j = 0;; j = this.addTags[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.removeTags.length) {
          break label55;
        }
        if (this.removeTags[k] == null) {}
        for (j = 0;; j = this.removeTags[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.addMacros.length) {
          break label67;
        }
        if (this.addMacros[k] == null) {}
        for (j = 0;; j = this.addMacros[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = i;
        if (k >= this.removeMacros.length) {
          break label79;
        }
        if (this.removeMacros[k] == null) {}
        for (j = 0;; j = this.removeMacros[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        i = this.result.hashCode();
        break label88;
      }
    }
    
    public ResolvedRule mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      for (;;)
      {
        int i = paramCodedInputByteBufferNano.readTag();
        int j;
        Debug.ResolvedFunctionCall[] arrayOfResolvedFunctionCall;
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
          if (this.positivePredicates == null) {}
          for (i = 0;; i = this.positivePredicates.length)
          {
            arrayOfResolvedFunctionCall = new Debug.ResolvedFunctionCall[i + j];
            if (this.positivePredicates != null) {
              System.arraycopy(this.positivePredicates, 0, arrayOfResolvedFunctionCall, 0, i);
            }
            this.positivePredicates = arrayOfResolvedFunctionCall;
            while (i < this.positivePredicates.length - 1)
            {
              this.positivePredicates[i] = new Debug.ResolvedFunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.positivePredicates[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.positivePredicates[i] = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.positivePredicates[i]);
          break;
        case 18: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          if (this.negativePredicates == null) {}
          for (i = 0;; i = this.negativePredicates.length)
          {
            arrayOfResolvedFunctionCall = new Debug.ResolvedFunctionCall[i + j];
            if (this.negativePredicates != null) {
              System.arraycopy(this.negativePredicates, 0, arrayOfResolvedFunctionCall, 0, i);
            }
            this.negativePredicates = arrayOfResolvedFunctionCall;
            while (i < this.negativePredicates.length - 1)
            {
              this.negativePredicates[i] = new Debug.ResolvedFunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.negativePredicates[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.negativePredicates[i] = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.negativePredicates[i]);
          break;
        case 26: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
          if (this.addTags == null) {}
          for (i = 0;; i = this.addTags.length)
          {
            arrayOfResolvedFunctionCall = new Debug.ResolvedFunctionCall[i + j];
            if (this.addTags != null) {
              System.arraycopy(this.addTags, 0, arrayOfResolvedFunctionCall, 0, i);
            }
            this.addTags = arrayOfResolvedFunctionCall;
            while (i < this.addTags.length - 1)
            {
              this.addTags[i] = new Debug.ResolvedFunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.addTags[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.addTags[i] = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.addTags[i]);
          break;
        case 34: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
          if (this.removeTags == null) {}
          for (i = 0;; i = this.removeTags.length)
          {
            arrayOfResolvedFunctionCall = new Debug.ResolvedFunctionCall[i + j];
            if (this.removeTags != null) {
              System.arraycopy(this.removeTags, 0, arrayOfResolvedFunctionCall, 0, i);
            }
            this.removeTags = arrayOfResolvedFunctionCall;
            while (i < this.removeTags.length - 1)
            {
              this.removeTags[i] = new Debug.ResolvedFunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.removeTags[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.removeTags[i] = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.removeTags[i]);
          break;
        case 42: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
          if (this.addMacros == null) {}
          for (i = 0;; i = this.addMacros.length)
          {
            arrayOfResolvedFunctionCall = new Debug.ResolvedFunctionCall[i + j];
            if (this.addMacros != null) {
              System.arraycopy(this.addMacros, 0, arrayOfResolvedFunctionCall, 0, i);
            }
            this.addMacros = arrayOfResolvedFunctionCall;
            while (i < this.addMacros.length - 1)
            {
              this.addMacros[i] = new Debug.ResolvedFunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.addMacros[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.addMacros[i] = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.addMacros[i]);
          break;
        case 50: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
          if (this.removeMacros == null) {}
          for (i = 0;; i = this.removeMacros.length)
          {
            arrayOfResolvedFunctionCall = new Debug.ResolvedFunctionCall[i + j];
            if (this.removeMacros != null) {
              System.arraycopy(this.removeMacros, 0, arrayOfResolvedFunctionCall, 0, i);
            }
            this.removeMacros = arrayOfResolvedFunctionCall;
            while (i < this.removeMacros.length - 1)
            {
              this.removeMacros[i] = new Debug.ResolvedFunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.removeMacros[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.removeMacros[i] = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.removeMacros[i]);
          break;
        case 58: 
          this.result = new TypeSystem.Value();
          paramCodedInputByteBufferNano.readMessage(this.result);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      Debug.ResolvedFunctionCall[] arrayOfResolvedFunctionCall;
      int j;
      int i;
      if (this.positivePredicates != null)
      {
        arrayOfResolvedFunctionCall = this.positivePredicates;
        j = arrayOfResolvedFunctionCall.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(1, arrayOfResolvedFunctionCall[i]);
          i += 1;
        }
      }
      if (this.negativePredicates != null)
      {
        arrayOfResolvedFunctionCall = this.negativePredicates;
        j = arrayOfResolvedFunctionCall.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(2, arrayOfResolvedFunctionCall[i]);
          i += 1;
        }
      }
      if (this.addTags != null)
      {
        arrayOfResolvedFunctionCall = this.addTags;
        j = arrayOfResolvedFunctionCall.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(3, arrayOfResolvedFunctionCall[i]);
          i += 1;
        }
      }
      if (this.removeTags != null)
      {
        arrayOfResolvedFunctionCall = this.removeTags;
        j = arrayOfResolvedFunctionCall.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(4, arrayOfResolvedFunctionCall[i]);
          i += 1;
        }
      }
      if (this.addMacros != null)
      {
        arrayOfResolvedFunctionCall = this.addMacros;
        j = arrayOfResolvedFunctionCall.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(5, arrayOfResolvedFunctionCall[i]);
          i += 1;
        }
      }
      if (this.removeMacros != null)
      {
        arrayOfResolvedFunctionCall = this.removeMacros;
        j = arrayOfResolvedFunctionCall.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(6, arrayOfResolvedFunctionCall[i]);
          i += 1;
        }
      }
      if (this.result != null) {
        paramCodedOutputByteBufferNano.writeMessage(7, this.result);
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
  
  public static final class RuleEvaluationStepInfo
    extends ExtendableMessageNano
  {
    public static final RuleEvaluationStepInfo[] EMPTY_ARRAY = new RuleEvaluationStepInfo[0];
    public Debug.ResolvedFunctionCall[] enabledFunctions = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
    public Debug.ResolvedRule[] rules = Debug.ResolvedRule.EMPTY_ARRAY;
    
    public static RuleEvaluationStepInfo parseFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
      throws IOException
    {
      return new RuleEvaluationStepInfo().mergeFrom(paramCodedInputByteBufferNano);
    }
    
    public static RuleEvaluationStepInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferNanoException
    {
      return (RuleEvaluationStepInfo)MessageNano.mergeFrom(new RuleEvaluationStepInfo(), paramArrayOfByte);
    }
    
    public final RuleEvaluationStepInfo clear()
    {
      this.rules = Debug.ResolvedRule.EMPTY_ARRAY;
      this.enabledFunctions = Debug.ResolvedFunctionCall.EMPTY_ARRAY;
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
        if (!(paramObject instanceof RuleEvaluationStepInfo)) {
          return false;
        }
        paramObject = (RuleEvaluationStepInfo)paramObject;
        if ((!Arrays.equals(this.rules, ((RuleEvaluationStepInfo)paramObject).rules)) || (!Arrays.equals(this.enabledFunctions, ((RuleEvaluationStepInfo)paramObject).enabledFunctions))) {
          break;
        }
        if (this.unknownFieldData != null) {
          break label65;
        }
      } while (((RuleEvaluationStepInfo)paramObject).unknownFieldData == null);
      label65:
      while (!this.unknownFieldData.equals(((RuleEvaluationStepInfo)paramObject).unknownFieldData)) {
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
      if (this.rules != null)
      {
        localObject = this.rules;
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
      int k = i;
      if (this.enabledFunctions != null)
      {
        localObject = this.enabledFunctions;
        m = localObject.length;
        j = 0;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          i += CodedOutputByteBufferNano.computeMessageSize(2, localObject[j]);
          j += 1;
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
      int k;
      if (this.rules == null)
      {
        j = 17 * 31;
        if (this.enabledFunctions != null) {
          break label99;
        }
        k = j * 31;
        label31:
        if (this.unknownFieldData != null) {
          break label154;
        }
      }
      label99:
      label154:
      for (i = m;; i = this.unknownFieldData.hashCode())
      {
        return k * 31 + i;
        k = 0;
        j = i;
        if (k >= this.rules.length) {
          break;
        }
        if (this.rules[k] == null) {}
        for (j = 0;; j = this.rules[k].hashCode())
        {
          i = i * 31 + j;
          k += 1;
          break;
        }
        k = 0;
        i = j;
        j = k;
        k = i;
        if (j >= this.enabledFunctions.length) {
          break label31;
        }
        if (this.enabledFunctions[j] == null) {}
        for (k = 0;; k = this.enabledFunctions[j].hashCode())
        {
          i = i * 31 + k;
          j += 1;
          break;
        }
      }
    }
    
    public RuleEvaluationStepInfo mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (this.rules == null) {}
          for (i = 0;; i = this.rules.length)
          {
            localObject = new Debug.ResolvedRule[i + j];
            if (this.rules != null) {
              System.arraycopy(this.rules, 0, localObject, 0, i);
            }
            this.rules = ((Debug.ResolvedRule[])localObject);
            while (i < this.rules.length - 1)
            {
              this.rules[i] = new Debug.ResolvedRule();
              paramCodedInputByteBufferNano.readMessage(this.rules[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.rules[i] = new Debug.ResolvedRule();
          paramCodedInputByteBufferNano.readMessage(this.rules[i]);
          break;
        case 18: 
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          if (this.enabledFunctions == null) {}
          for (i = 0;; i = this.enabledFunctions.length)
          {
            localObject = new Debug.ResolvedFunctionCall[i + j];
            if (this.enabledFunctions != null) {
              System.arraycopy(this.enabledFunctions, 0, localObject, 0, i);
            }
            this.enabledFunctions = ((Debug.ResolvedFunctionCall[])localObject);
            while (i < this.enabledFunctions.length - 1)
            {
              this.enabledFunctions[i] = new Debug.ResolvedFunctionCall();
              paramCodedInputByteBufferNano.readMessage(this.enabledFunctions[i]);
              paramCodedInputByteBufferNano.readTag();
              i += 1;
            }
          }
          this.enabledFunctions[i] = new Debug.ResolvedFunctionCall();
          paramCodedInputByteBufferNano.readMessage(this.enabledFunctions[i]);
        }
      }
    }
    
    public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
      throws IOException
    {
      Object localObject;
      int j;
      int i;
      if (this.rules != null)
      {
        localObject = this.rules;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(1, localObject[i]);
          i += 1;
        }
      }
      if (this.enabledFunctions != null)
      {
        localObject = this.enabledFunctions;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          paramCodedOutputByteBufferNano.writeMessage(2, localObject[i]);
          i += 1;
        }
      }
      WireFormatNano.writeUnknownFields(this.unknownFieldData, paramCodedOutputByteBufferNano);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/containertag/proto/Debug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */