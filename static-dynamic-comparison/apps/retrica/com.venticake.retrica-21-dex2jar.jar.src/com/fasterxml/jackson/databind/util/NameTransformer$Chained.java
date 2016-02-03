package com.fasterxml.jackson.databind.util;

public class NameTransformer$Chained
  extends NameTransformer
{
  protected final NameTransformer _t1;
  protected final NameTransformer _t2;
  
  public NameTransformer$Chained(NameTransformer paramNameTransformer1, NameTransformer paramNameTransformer2)
  {
    this._t1 = paramNameTransformer1;
    this._t2 = paramNameTransformer2;
  }
  
  public String toString()
  {
    return "[ChainedTransformer(" + this._t1 + ", " + this._t2 + ")]";
  }
  
  public String transform(String paramString)
  {
    return this._t1.transform(this._t2.transform(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/NameTransformer$Chained.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */