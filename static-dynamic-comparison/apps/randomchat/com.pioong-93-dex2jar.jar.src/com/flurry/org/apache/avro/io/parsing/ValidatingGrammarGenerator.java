package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ValidatingGrammarGenerator
{
  public Symbol generate(Schema paramSchema)
  {
    return Symbol.root(new Symbol[] { generate(paramSchema, new HashMap()) });
  }
  
  public Symbol generate(Schema paramSchema, Map<LitS, Symbol> paramMap)
  {
    Object localObject3;
    switch (paramSchema.getType())
    {
    default: 
      throw new RuntimeException("Unexpected schema type");
    case ???: 
      localObject1 = Symbol.NULL;
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
    case ???: 
    case ???: 
      LitS localLitS;
      do
      {
        return (Symbol)localObject1;
        return Symbol.BOOLEAN;
        return Symbol.INT;
        return Symbol.LONG;
        return Symbol.FLOAT;
        return Symbol.DOUBLE;
        return Symbol.STRING;
        return Symbol.BYTES;
        return Symbol.seq(new Symbol[] { new Symbol.IntCheckAction(paramSchema.getFixedSize()), Symbol.FIXED });
        return Symbol.seq(new Symbol[] { new Symbol.IntCheckAction(paramSchema.getEnumSymbols().size()), Symbol.ENUM });
        return Symbol.seq(new Symbol[] { Symbol.repeat(Symbol.ARRAY_END, new Symbol[] { generate(paramSchema.getElementType(), paramMap) }), Symbol.ARRAY_START });
        return Symbol.seq(new Symbol[] { Symbol.repeat(Symbol.MAP_END, new Symbol[] { generate(paramSchema.getValueType(), paramMap), Symbol.STRING }), Symbol.MAP_START });
        localLitS = new LitS(paramSchema);
        localObject2 = (Symbol)paramMap.get(localLitS);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject3 = new Symbol[paramSchema.getFields().size()];
      localObject2 = Symbol.seq((Symbol[])localObject3);
      paramMap.put(localLitS, localObject2);
      i = localObject3.length;
      paramSchema = paramSchema.getFields().iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!paramSchema.hasNext()) {
          break;
        }
        localObject1 = (Schema.Field)paramSchema.next();
        i -= 1;
        localObject3[i] = generate(((Schema.Field)localObject1).schema(), paramMap);
      }
    }
    Object localObject2 = paramSchema.getTypes();
    Object localObject1 = new Symbol[((List)localObject2).size()];
    localObject2 = new String[((List)localObject2).size()];
    int i = 0;
    paramSchema = paramSchema.getTypes().iterator();
    while (paramSchema.hasNext())
    {
      localObject3 = (Schema)paramSchema.next();
      localObject1[i] = generate((Schema)localObject3, paramMap);
      localObject2[i] = ((Schema)localObject3).getFullName();
      i += 1;
    }
    return Symbol.seq(new Symbol[] { Symbol.alt((Symbol[])localObject1, (String[])localObject2), Symbol.UNION });
  }
  
  static class LitS
  {
    public final Schema actual;
    
    public LitS(Schema paramSchema)
    {
      this.actual = paramSchema;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof LitS)) {}
      while (this.actual != ((LitS)paramObject).actual) {
        return false;
      }
      return true;
    }
    
    public int hashCode()
    {
      return this.actual.hashCode();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/parsing/ValidatingGrammarGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */