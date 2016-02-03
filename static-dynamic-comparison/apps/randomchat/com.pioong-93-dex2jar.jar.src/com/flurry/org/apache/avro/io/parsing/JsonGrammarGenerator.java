package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonGrammarGenerator
  extends ValidatingGrammarGenerator
{
  public Symbol generate(Schema paramSchema)
  {
    return Symbol.root(new Symbol[] { generate(paramSchema, new HashMap()) });
  }
  
  public Symbol generate(Schema paramSchema, Map<ValidatingGrammarGenerator.LitS, Symbol> paramMap)
  {
    switch (paramSchema.getType())
    {
    default: 
      throw new RuntimeException("Unexpected schema type");
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
      localObject1 = super.generate(paramSchema, paramMap);
    }
    Object localObject2;
    do
    {
      return (Symbol)localObject1;
      return Symbol.seq(new Symbol[] { new Symbol.EnumLabelsAction(paramSchema.getEnumSymbols()), Symbol.ENUM });
      return Symbol.seq(new Symbol[] { Symbol.repeat(Symbol.ARRAY_END, new Symbol[] { Symbol.ITEM_END, generate(paramSchema.getElementType(), paramMap) }), Symbol.ARRAY_START });
      return Symbol.seq(new Symbol[] { Symbol.repeat(Symbol.MAP_END, new Symbol[] { Symbol.ITEM_END, generate(paramSchema.getValueType(), paramMap), Symbol.MAP_KEY_MARKER, Symbol.STRING }), Symbol.MAP_START });
      localObject2 = new ValidatingGrammarGenerator.LitS(paramSchema);
      localSymbol = (Symbol)paramMap.get(localObject2);
      localObject1 = localSymbol;
    } while (localSymbol != null);
    Object localObject1 = new Symbol[paramSchema.getFields().size() * 3 + 2];
    Symbol localSymbol = Symbol.seq((Symbol[])localObject1);
    paramMap.put(localObject2, localSymbol);
    int j = localObject1.length;
    int i = 0;
    j -= 1;
    localObject1[j] = Symbol.RECORD_START;
    paramSchema = paramSchema.getFields().iterator();
    while (paramSchema.hasNext())
    {
      localObject2 = (Schema.Field)paramSchema.next();
      j -= 1;
      localObject1[j] = new Symbol.FieldAdjustAction(i, ((Schema.Field)localObject2).name());
      j -= 1;
      localObject1[j] = generate(((Schema.Field)localObject2).schema(), paramMap);
      j -= 1;
      localObject1[j] = Symbol.FIELD_END;
      i += 1;
    }
    localObject1[(j - 1)] = Symbol.RECORD_END;
    return localSymbol;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/parsing/JsonGrammarGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */