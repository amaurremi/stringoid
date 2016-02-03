package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.Schema.Type;
import com.flurry.org.apache.avro.io.BinaryEncoder;
import com.flurry.org.apache.avro.io.Encoder;
import com.flurry.org.apache.avro.io.EncoderFactory;
import com.flurry.org.codehaus.jackson.JsonNode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ResolvingGrammarGenerator
  extends ValidatingGrammarGenerator
{
  private static EncoderFactory factory = new EncoderFactory().configureBufferSize(32);
  
  private static int bestBranch(Schema paramSchema1, Schema paramSchema2)
  {
    Schema.Type localType = paramSchema2.getType();
    int i = 0;
    Iterator localIterator = paramSchema1.getTypes().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        i = 0;
        paramSchema1 = paramSchema1.getTypes().iterator();
        if (paramSchema1.hasNext()) {
          break;
        }
        return -1;
      }
      Object localObject = (Schema)localIterator.next();
      if (localType == ((Schema)localObject).getType()) {
        if ((localType == Schema.Type.RECORD) || (localType == Schema.Type.ENUM) || (localType == Schema.Type.FIXED))
        {
          String str = paramSchema2.getFullName();
          localObject = ((Schema)localObject).getFullName();
          if (((str != null) && (str.equals(localObject))) || ((str == localObject) && (localType == Schema.Type.RECORD))) {
            return i;
          }
        }
        else
        {
          return i;
        }
      }
      i += 1;
    }
    paramSchema2 = (Schema)paramSchema1.next();
    switch (localType)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      switch (paramSchema2.getType())
      {
      case NULL: 
      default: 
        break;
      case MAP: 
      case RECORD: 
        return i;
        switch (paramSchema2.getType())
        {
        }
        break;
      }
    }
    return i;
  }
  
  public static void encode(Encoder paramEncoder, Schema paramSchema, JsonNode paramJsonNode)
    throws IOException
  {
    Object localObject2;
    Object localObject1;
    switch (paramSchema.getType())
    {
    default: 
      return;
    case ARRAY: 
      localObject2 = paramSchema.getFields().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Schema.Field localField = (Schema.Field)((Iterator)localObject2).next();
        String str = localField.name();
        localObject1 = paramJsonNode.get(str);
        paramSchema = (Schema)localObject1;
        if (localObject1 == null) {
          paramSchema = localField.defaultValue();
        }
        if (paramSchema == null) {
          throw new AvroTypeException("No default value for: " + str);
        }
        encode(paramEncoder, localField.schema(), paramSchema);
      }
    case BOOLEAN: 
      paramEncoder.writeEnum(paramSchema.getEnumOrdinal(paramJsonNode.getTextValue()));
      return;
    case BYTES: 
      paramEncoder.writeArrayStart();
      paramEncoder.setItemCount(paramJsonNode.size());
      paramSchema = paramSchema.getElementType();
      paramJsonNode = paramJsonNode.iterator();
      for (;;)
      {
        if (!paramJsonNode.hasNext())
        {
          paramEncoder.writeArrayEnd();
          return;
        }
        localObject1 = (JsonNode)paramJsonNode.next();
        paramEncoder.startItem();
        encode(paramEncoder, paramSchema, (JsonNode)localObject1);
      }
    case DOUBLE: 
      paramEncoder.writeMapStart();
      paramEncoder.setItemCount(paramJsonNode.size());
      paramSchema = paramSchema.getValueType();
      localObject1 = paramJsonNode.getFieldNames();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext())
        {
          paramEncoder.writeMapEnd();
          return;
        }
        paramEncoder.startItem();
        localObject2 = (String)((Iterator)localObject1).next();
        paramEncoder.writeString((String)localObject2);
        encode(paramEncoder, paramSchema, paramJsonNode.get((String)localObject2));
      }
    case ENUM: 
      paramEncoder.writeIndex(0);
      encode(paramEncoder, (Schema)paramSchema.getTypes().get(0), paramJsonNode);
      return;
    case FIXED: 
      if (!paramJsonNode.isTextual()) {
        throw new AvroTypeException("Non-string default value for fixed: " + paramJsonNode);
      }
      localObject1 = paramJsonNode.getTextValue().getBytes("ISO-8859-1");
      paramJsonNode = (JsonNode)localObject1;
      if (localObject1.length != paramSchema.getFixedSize())
      {
        paramJsonNode = new byte[paramSchema.getFixedSize()];
        if (paramSchema.getFixedSize() <= localObject1.length) {
          break label450;
        }
      }
      for (int i = localObject1.length;; i = paramSchema.getFixedSize())
      {
        System.arraycopy(localObject1, 0, paramJsonNode, 0, i);
        paramEncoder.writeFixed(paramJsonNode);
        return;
      }
    case FLOAT: 
      if (!paramJsonNode.isTextual()) {
        throw new AvroTypeException("Non-string default value for string: " + paramJsonNode);
      }
      paramEncoder.writeString(paramJsonNode.getTextValue());
      return;
    case INT: 
      if (!paramJsonNode.isTextual()) {
        throw new AvroTypeException("Non-string default value for bytes: " + paramJsonNode);
      }
      paramEncoder.writeBytes(paramJsonNode.getTextValue().getBytes("ISO-8859-1"));
      return;
    case LONG: 
      if (!paramJsonNode.isNumber()) {
        throw new AvroTypeException("Non-numeric default value for int: " + paramJsonNode);
      }
      paramEncoder.writeInt(paramJsonNode.getIntValue());
      return;
    case MAP: 
      if (!paramJsonNode.isNumber()) {
        throw new AvroTypeException("Non-numeric default value for long: " + paramJsonNode);
      }
      paramEncoder.writeLong(paramJsonNode.getLongValue());
      return;
    case NULL: 
      if (!paramJsonNode.isNumber()) {
        throw new AvroTypeException("Non-numeric default value for float: " + paramJsonNode);
      }
      paramEncoder.writeFloat((float)paramJsonNode.getDoubleValue());
      return;
    case RECORD: 
      if (!paramJsonNode.isNumber()) {
        throw new AvroTypeException("Non-numeric default value for double: " + paramJsonNode);
      }
      paramEncoder.writeDouble(paramJsonNode.getDoubleValue());
      return;
    case STRING: 
      label450:
      if (!paramJsonNode.isBoolean()) {
        throw new AvroTypeException("Non-boolean default for boolean: " + paramJsonNode);
      }
      paramEncoder.writeBoolean(paramJsonNode.getBooleanValue());
      return;
    }
    if (!paramJsonNode.isNull()) {
      throw new AvroTypeException("Non-null default value for null type: " + paramJsonNode);
    }
    paramEncoder.writeNull();
  }
  
  private static byte[] getBinary(Schema paramSchema, JsonNode paramJsonNode)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    BinaryEncoder localBinaryEncoder = factory.binaryEncoder(localByteArrayOutputStream, null);
    encode(localBinaryEncoder, paramSchema, paramJsonNode);
    localBinaryEncoder.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static Symbol mkEnumAdjust(List<String> paramList1, List<String> paramList2)
  {
    Object[] arrayOfObject = new Object[paramList1.size()];
    int i = 0;
    if (i >= arrayOfObject.length) {
      return new Symbol.EnumAdjustAction(paramList2.size(), arrayOfObject);
    }
    int j = paramList2.indexOf(paramList1.get(i));
    if (j == -1) {}
    for (Object localObject = "No match for " + (String)paramList1.get(i);; localObject = new Integer(j))
    {
      arrayOfObject[i] = localObject;
      i += 1;
      break;
    }
  }
  
  private Symbol resolveRecords(Schema paramSchema1, Schema paramSchema2, Map<ValidatingGrammarGenerator.LitS, Symbol> paramMap)
    throws IOException
  {
    Object localObject3 = new LitS2(paramSchema1, paramSchema2);
    Object localObject2 = (Symbol)paramMap.get(localObject3);
    Object localObject1 = localObject2;
    Object localObject5;
    int i;
    int j;
    Object localObject4;
    if (localObject2 == null)
    {
      localObject5 = paramSchema1.getFields();
      localObject2 = paramSchema2.getFields();
      localObject1 = new Schema.Field[((List)localObject2).size()];
      i = 0;
      j = ((List)localObject5).size() + 1;
      localObject4 = ((List)localObject5).iterator();
      if (((Iterator)localObject4).hasNext()) {
        break label193;
      }
      localObject4 = ((List)localObject2).iterator();
      label99:
      if (((Iterator)localObject4).hasNext()) {
        break label233;
      }
      localObject4 = new Symbol[j];
      i = j - 1;
      localObject4[i] = new Symbol.FieldOrderAction((Schema.Field[])localObject1);
      localObject1 = Symbol.seq((Symbol[])localObject4);
      paramMap.put(localObject3, localObject1);
      localObject3 = ((List)localObject5).iterator();
      label163:
      if (((Iterator)localObject3).hasNext()) {
        break label338;
      }
      paramSchema2 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!paramSchema2.hasNext())
      {
        return (Symbol)localObject1;
        label193:
        Schema.Field localField = paramSchema2.getField(((Schema.Field)((Iterator)localObject4).next()).name());
        if (localField == null) {
          break;
        }
        localObject1[i] = localField;
        i += 1;
        break;
        label233:
        localField = (Schema.Field)((Iterator)localObject4).next();
        if (paramSchema1.getField(localField.name()) != null) {
          break label99;
        }
        if (localField.defaultValue() == null)
        {
          paramSchema1 = Symbol.error("Found " + paramSchema1.toString(true) + ", expecting " + paramSchema2.toString(true));
          paramMap.put(localObject3, paramSchema1);
          return paramSchema1;
        }
        localObject1[i] = localField;
        j += 3;
        i += 1;
        break label99;
        label338:
        localObject5 = (Schema.Field)((Iterator)localObject3).next();
        localField = paramSchema2.getField(((Schema.Field)localObject5).name());
        if (localField == null)
        {
          i -= 1;
          localObject4[i] = new Symbol.SkipAction(generate(((Schema.Field)localObject5).schema(), ((Schema.Field)localObject5).schema(), paramMap));
          break label163;
        }
        i -= 1;
        localObject4[i] = generate(((Schema.Field)localObject5).schema(), localField.schema(), paramMap);
        break label163;
      }
      localObject2 = (Schema.Field)paramSchema2.next();
      if (paramSchema1.getField(((Schema.Field)localObject2).name()) == null)
      {
        localObject3 = getBinary(((Schema.Field)localObject2).schema(), ((Schema.Field)localObject2).defaultValue());
        i -= 1;
        localObject4[i] = new Symbol.DefaultStartAction((byte[])localObject3);
        i -= 1;
        localObject4[i] = generate(((Schema.Field)localObject2).schema(), ((Schema.Field)localObject2).schema(), paramMap);
        i -= 1;
        localObject4[i] = Symbol.DEFAULT_END_ACTION;
      }
    }
  }
  
  private Symbol resolveUnion(Schema paramSchema1, Schema paramSchema2, Map<ValidatingGrammarGenerator.LitS, Symbol> paramMap)
    throws IOException
  {
    Object localObject = paramSchema1.getTypes();
    int i = ((List)localObject).size();
    paramSchema1 = new Symbol[i];
    String[] arrayOfString = new String[i];
    i = 0;
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return Symbol.seq(new Symbol[] { Symbol.alt(paramSchema1, arrayOfString), new Symbol.WriterUnionAction() });
      }
      Schema localSchema = (Schema)((Iterator)localObject).next();
      paramSchema1[i] = generate(localSchema, paramSchema2, paramMap);
      arrayOfString[i] = localSchema.getFullName();
      i += 1;
    }
  }
  
  public final Symbol generate(Schema paramSchema1, Schema paramSchema2)
    throws IOException
  {
    return Symbol.root(new Symbol[] { generate(paramSchema1, paramSchema2, new HashMap()) });
  }
  
  public Symbol generate(Schema paramSchema1, Schema paramSchema2, Map<ValidatingGrammarGenerator.LitS, Symbol> paramMap)
    throws IOException
  {
    Schema.Type localType1 = paramSchema1.getType();
    Schema.Type localType2 = paramSchema2.getType();
    if (localType1 == localType2)
    {
      switch (localType1)
      {
      default: 
        throw new AvroTypeException("Unkown type for schema: " + localType1);
      case UNION: 
        return Symbol.NULL;
      case STRING: 
        return Symbol.BOOLEAN;
      case LONG: 
        return Symbol.INT;
      case MAP: 
        return Symbol.LONG;
      case NULL: 
        return Symbol.FLOAT;
      case RECORD: 
        return Symbol.DOUBLE;
      case FLOAT: 
        return Symbol.STRING;
      case INT: 
        return Symbol.BYTES;
      case FIXED: 
        if ((!paramSchema1.getFullName().equals(paramSchema2.getFullName())) || (paramSchema1.getFixedSize() != paramSchema2.getFixedSize())) {
          break;
        }
        return Symbol.seq(new Symbol[] { new Symbol.IntCheckAction(paramSchema1.getFixedSize()), Symbol.FIXED });
      case BOOLEAN: 
        if ((paramSchema1.getFullName() != null) && (!paramSchema1.getFullName().equals(paramSchema2.getFullName()))) {
          break;
        }
        return Symbol.seq(new Symbol[] { mkEnumAdjust(paramSchema1.getEnumSymbols(), paramSchema2.getEnumSymbols()), Symbol.ENUM });
      case BYTES: 
        return Symbol.seq(new Symbol[] { Symbol.repeat(Symbol.ARRAY_END, new Symbol[] { generate(paramSchema1.getElementType(), paramSchema2.getElementType(), paramMap) }), Symbol.ARRAY_START });
      case DOUBLE: 
        return Symbol.seq(new Symbol[] { Symbol.repeat(Symbol.MAP_END, new Symbol[] { generate(paramSchema1.getValueType(), paramSchema2.getValueType(), paramMap), Symbol.STRING }), Symbol.MAP_START });
      case ARRAY: 
        return resolveRecords(paramSchema1, paramSchema2, paramMap);
      case ENUM: 
        return resolveUnion(paramSchema1, paramSchema2, paramMap);
      }
    }
    else
    {
      if (localType1 == Schema.Type.UNION) {
        return resolveUnion(paramSchema1, paramSchema2, paramMap);
      }
      switch (localType2)
      {
      case FIXED: 
      default: 
        throw new RuntimeException("Unexpected schema type: " + localType2);
      case MAP: 
        switch (localType1)
        {
        }
        break;
      }
    }
    int i;
    do
    {
      for (;;)
      {
        return Symbol.error("Found " + paramSchema1.toString(true) + ", expecting " + paramSchema2.toString(true));
        return Symbol.resolve(super.generate(paramSchema1, paramMap), Symbol.LONG);
        switch (localType1)
        {
        default: 
          break;
        case LONG: 
        case MAP: 
          return Symbol.resolve(super.generate(paramSchema1, paramMap), Symbol.FLOAT);
          switch (localType1)
          {
          }
          break;
        }
      }
      return Symbol.resolve(super.generate(paramSchema1, paramMap), Symbol.DOUBLE);
      i = bestBranch(paramSchema2, paramSchema1);
    } while (i < 0);
    return Symbol.seq(new Symbol[] { new Symbol.UnionAdjustAction(i, generate(paramSchema1, (Schema)paramSchema2.getTypes().get(i), paramMap)), Symbol.UNION });
  }
  
  static class LitS2
    extends ValidatingGrammarGenerator.LitS
  {
    public Schema expected;
    
    public LitS2(Schema paramSchema1, Schema paramSchema2)
    {
      super();
      this.expected = paramSchema2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof LitS2)) {}
      do
      {
        return false;
        paramObject = (LitS2)paramObject;
      } while ((this.actual != ((LitS2)paramObject).actual) || (this.expected != ((LitS2)paramObject).expected));
      return true;
    }
    
    public int hashCode()
    {
      return super.hashCode() + this.expected.hashCode();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/parsing/ResolvingGrammarGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */