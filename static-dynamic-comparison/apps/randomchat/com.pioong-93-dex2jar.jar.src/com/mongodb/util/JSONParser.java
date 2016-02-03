package com.mongodb.util;

import org.bson.BSONCallback;

class JSONParser
{
  BSONCallback _callback;
  int pos = 0;
  String s;
  
  public JSONParser(String paramString)
  {
    this(paramString, null);
  }
  
  public JSONParser(String paramString, BSONCallback paramBSONCallback)
  {
    this.s = paramString;
    paramString = paramBSONCallback;
    if (paramBSONCallback == null) {
      paramString = new JSONCallback();
    }
    this._callback = paramString;
  }
  
  public boolean check(char paramChar)
  {
    return get() == paramChar;
  }
  
  protected void doCallback(String paramString, Object paramObject)
  {
    if (paramObject == null) {
      this._callback.gotNull(paramString);
    }
    do
    {
      return;
      if ((paramObject instanceof String))
      {
        this._callback.gotString(paramString, (String)paramObject);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        this._callback.gotBoolean(paramString, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ((paramObject instanceof Integer))
      {
        this._callback.gotInt(paramString, ((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject instanceof Long))
      {
        this._callback.gotLong(paramString, ((Long)paramObject).longValue());
        return;
      }
    } while (!(paramObject instanceof Double));
    this._callback.gotDouble(paramString, ((Double)paramObject).doubleValue());
  }
  
  public char get()
  {
    skipWS();
    if (this.pos < this.s.length()) {
      return this.s.charAt(this.pos);
    }
    return 65535;
  }
  
  public Object parse()
  {
    return parse(null);
  }
  
  protected Object parse(String paramString)
  {
    switch (get())
    {
    default: 
      throw new JSONParseException(this.s, this.pos);
    case 'n': 
      read('n');
      read('u');
      read('l');
      read('l');
      return null;
    case 'N': 
      read('N');
      read('a');
      read('N');
      return Double.valueOf(NaN.0D);
    case 't': 
      read('t');
      read('r');
      read('u');
      read('e');
      return Boolean.valueOf(true);
    case 'f': 
      read('f');
      read('a');
      read('l');
      read('s');
      read('e');
      return Boolean.valueOf(false);
    case '"': 
    case '\'': 
      return parseString(true);
    case '+': 
    case '-': 
    case '0': 
    case '1': 
    case '2': 
    case '3': 
    case '4': 
    case '5': 
    case '6': 
    case '7': 
    case '8': 
    case '9': 
      return parseNumber();
    case '[': 
      return parseArray(paramString);
    }
    return parseObject(paramString);
  }
  
  public Object parseArray()
  {
    return parseArray(null);
  }
  
  protected Object parseArray(String paramString)
  {
    if (paramString != null) {
      this._callback.arrayStart(paramString);
    }
    int j;
    for (;;)
    {
      read('[');
      j = get();
      int i = 0;
      for (;;)
      {
        if (j == 93) {
          break label122;
        }
        paramString = String.valueOf(i);
        doCallback(paramString, parse(paramString));
        j = get();
        if (j != 44) {
          break;
        }
        read(',');
        i += 1;
      }
      this._callback.arrayStart();
    }
    if (j == 93) {}
    label122:
    for (;;)
    {
      read(']');
      return this._callback.arrayDone();
      throw new JSONParseException(this.s, this.pos);
    }
  }
  
  public void parseExponent()
  {
    this.pos += 1;
    if ((check('-')) || (check('+'))) {}
    for (this.pos += 1;; this.pos += 1)
    {
      if (this.pos < this.s.length()) {}
      switch (this.s.charAt(this.pos))
      {
      default: 
        return;
      }
    }
  }
  
  public void parseFraction()
  {
    this.pos += 1;
    for (;;)
    {
      if (this.pos < this.s.length()) {}
      switch (this.s.charAt(this.pos))
      {
      default: 
        return;
      case '0': 
      case '1': 
      case '2': 
      case '3': 
      case '4': 
      case '5': 
      case '6': 
      case '7': 
      case '8': 
      case '9': 
        this.pos += 1;
        break;
      case 'E': 
      case 'e': 
        parseExponent();
      }
    }
  }
  
  public Number parseNumber()
  {
    get();
    k = this.pos;
    int j = 0;
    if (!check('-'))
    {
      i = j;
      if (!check('+')) {}
    }
    else
    {
      this.pos += 1;
      i = j;
    }
    if (this.pos < this.s.length()) {}
    switch (this.s.charAt(this.pos))
    {
    default: 
      if (i == 0) {
        break;
      }
    }
    do
    {
      do
      {
        try
        {
          localObject = Double.valueOf(this.s.substring(k, this.pos));
          return (Number)localObject;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Object localObject;
          Long localLong;
          throw new JSONParseException(this.s, k, localNumberFormatException);
        }
        this.pos += 1;
        break;
        i = 1;
        parseFraction();
        break;
        i = 1;
        parseExponent();
        break;
        localLong = Long.valueOf(this.s.substring(k, this.pos));
        localObject = localLong;
      } while (localLong.longValue() > 2147483647L);
      localObject = localLong;
    } while (localLong.longValue() < -2147483648L);
    int i = localLong.intValue();
    return Integer.valueOf(i);
  }
  
  public Object parseObject()
  {
    return parseObject(null);
  }
  
  protected Object parseObject(String paramString)
  {
    if (paramString != null) {
      this._callback.objectStart(paramString);
    }
    for (;;)
    {
      read('{');
      get();
      while (get() != '}')
      {
        paramString = parseString(false);
        read(':');
        doCallback(paramString, parse(paramString));
        if (get() != ',') {
          break;
        }
        read(',');
      }
      this._callback.objectStart();
    }
    read('}');
    return this._callback.objectDone();
  }
  
  public String parseString(boolean paramBoolean)
  {
    char c2 = '\000';
    StringBuilder localStringBuilder;
    int i;
    if (check('\''))
    {
      c2 = '\'';
      if (c2 > 0) {
        read(c2);
      }
      localStringBuilder = new StringBuilder();
      i = this.pos;
    }
    for (;;)
    {
      char c3;
      if (this.pos < this.s.length())
      {
        c3 = this.s.charAt(this.pos);
        if (c2 <= 0) {
          break label144;
        }
        if (c3 != c2) {
          break label158;
        }
      }
      label144:
      while ((c3 == ':') || (c3 == ' '))
      {
        localStringBuilder.append(this.s.substring(i, this.pos));
        if (c2 > 0) {
          read(c2);
        }
        return localStringBuilder.toString();
        if (check('"'))
        {
          c2 = '"';
          break;
        }
        if (!paramBoolean) {
          break;
        }
        throw new JSONParseException(this.s, this.pos);
      }
      label158:
      if (c3 == '\\')
      {
        this.pos += 1;
        c3 = get();
        char c1 = '\000';
        switch (c3)
        {
        }
        for (;;)
        {
          localStringBuilder.append(this.s.substring(i, this.pos - 1));
          if (c1 != 0)
          {
            this.pos += 1;
            localStringBuilder.append(c1);
          }
          i = this.pos;
          break;
          localStringBuilder.append(this.s.substring(i, this.pos - 1));
          this.pos += 1;
          i = this.pos;
          readHex();
          readHex();
          readHex();
          readHex();
          localStringBuilder.append((char)Integer.parseInt(this.s.substring(i, i + 4), 16));
          i = this.pos;
          break;
          c1 = '\n';
          continue;
          c1 = '\r';
          continue;
          c1 = '\t';
          continue;
          c1 = '\b';
          continue;
          c1 = '"';
          continue;
          c1 = '\\';
        }
      }
      this.pos += 1;
    }
  }
  
  public char read()
  {
    if (this.pos >= this.s.length()) {
      throw new IllegalStateException("string done");
    }
    String str = this.s;
    int i = this.pos;
    this.pos = (i + 1);
    return str.charAt(i);
  }
  
  public void read(char paramChar)
  {
    if (!check(paramChar)) {
      throw new JSONParseException(this.s, this.pos);
    }
    this.pos += 1;
  }
  
  public void readHex()
  {
    if ((this.pos < this.s.length()) && (((this.s.charAt(this.pos) >= '0') && (this.s.charAt(this.pos) <= '9')) || ((this.s.charAt(this.pos) >= 'A') && (this.s.charAt(this.pos) <= 'F')) || ((this.s.charAt(this.pos) >= 'a') && (this.s.charAt(this.pos) <= 'f'))))
    {
      this.pos += 1;
      return;
    }
    throw new JSONParseException(this.s, this.pos);
  }
  
  public void skipWS()
  {
    while ((this.pos < this.s.length()) && (Character.isWhitespace(this.s.charAt(this.pos)))) {
      this.pos += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/JSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */