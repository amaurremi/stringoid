package com.fasterxml.jackson.databind.util;

public abstract class NameTransformer
{
  public static final NameTransformer NOP = new NameTransformer()
  {
    public String transform(String paramAnonymousString)
    {
      return paramAnonymousString;
    }
  };
  
  public static NameTransformer chainedTransformer(NameTransformer paramNameTransformer1, NameTransformer paramNameTransformer2)
  {
    return new NameTransformer.Chained(paramNameTransformer1, paramNameTransformer2);
  }
  
  public static NameTransformer simpleTransformer(String paramString1, final String paramString2)
  {
    int j = 1;
    int i;
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      i = 1;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label49;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (j != 0)
        {
          new NameTransformer()
          {
            public String toString()
            {
              return "[PreAndSuffixTransformer('" + NameTransformer.this + "','" + paramString2 + "')]";
            }
            
            public String transform(String paramAnonymousString)
            {
              return NameTransformer.this + paramAnonymousString + paramString2;
            }
          };
          i = 0;
          break;
          label49:
          j = 0;
          continue;
        }
        new NameTransformer()
        {
          public String toString()
          {
            return "[PrefixTransformer('" + NameTransformer.this + "')]";
          }
          
          public String transform(String paramAnonymousString)
          {
            return NameTransformer.this + paramAnonymousString;
          }
        };
      }
    }
    if (j != 0) {
      new NameTransformer()
      {
        public String toString()
        {
          return "[SuffixTransformer('" + NameTransformer.this + "')]";
        }
        
        public String transform(String paramAnonymousString)
        {
          return paramAnonymousString + NameTransformer.this;
        }
      };
    }
    return NOP;
  }
  
  public abstract String transform(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/NameTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */