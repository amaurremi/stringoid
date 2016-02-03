package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonToken;

public final class TokenBuffer$Segment
{
  private static final JsonToken[] TOKEN_TYPES_BY_INDEX = new JsonToken[16];
  protected Segment _next;
  protected long _tokenTypes;
  protected final Object[] _tokens = new Object[16];
  
  static
  {
    JsonToken[] arrayOfJsonToken = JsonToken.values();
    System.arraycopy(arrayOfJsonToken, 1, TOKEN_TYPES_BY_INDEX, 1, Math.min(15, arrayOfJsonToken.length - 1));
  }
  
  public Segment append(int paramInt, JsonToken paramJsonToken)
  {
    if (paramInt < 16)
    {
      set(paramInt, paramJsonToken);
      return null;
    }
    this._next = new Segment();
    this._next.set(0, paramJsonToken);
    return this._next;
  }
  
  public Segment append(int paramInt, JsonToken paramJsonToken, Object paramObject)
  {
    if (paramInt < 16)
    {
      set(paramInt, paramJsonToken, paramObject);
      return null;
    }
    this._next = new Segment();
    this._next.set(0, paramJsonToken, paramObject);
    return this._next;
  }
  
  public Object get(int paramInt)
  {
    return this._tokens[paramInt];
  }
  
  public Segment next()
  {
    return this._next;
  }
  
  public void set(int paramInt, JsonToken paramJsonToken)
  {
    long l2 = paramJsonToken.ordinal();
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 << (paramInt << 2);
    }
    this._tokenTypes = (l1 | this._tokenTypes);
  }
  
  public void set(int paramInt, JsonToken paramJsonToken, Object paramObject)
  {
    this._tokens[paramInt] = paramObject;
    long l2 = paramJsonToken.ordinal();
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 << (paramInt << 2);
    }
    this._tokenTypes = (l1 | this._tokenTypes);
  }
  
  public JsonToken type(int paramInt)
  {
    long l2 = this._tokenTypes;
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 >> (paramInt << 2);
    }
    paramInt = (int)l1;
    return TOKEN_TYPES_BY_INDEX[(paramInt & 0xF)];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/TokenBuffer$Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */