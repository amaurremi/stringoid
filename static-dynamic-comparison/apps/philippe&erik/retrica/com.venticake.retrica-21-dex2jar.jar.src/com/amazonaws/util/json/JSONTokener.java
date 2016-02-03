package com.amazonaws.util.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class JSONTokener
{
  private int character;
  private boolean eof;
  private int index;
  private int line;
  private char previous;
  private Reader reader;
  private boolean usePrevious;
  
  public JSONTokener(Reader paramReader)
  {
    if (paramReader.markSupported()) {}
    for (;;)
    {
      this.reader = paramReader;
      this.eof = false;
      this.usePrevious = false;
      this.previous = '\000';
      this.index = 0;
      this.character = 1;
      this.line = 1;
      return;
      paramReader = new BufferedReader(paramReader);
    }
  }
  
  public JSONTokener(String paramString)
  {
    this(new StringReader(paramString));
  }
  
  public void back()
  {
    if ((this.usePrevious) || (this.index <= 0)) {
      throw new JSONException("Stepping back two steps is not supported");
    }
    this.index -= 1;
    this.character -= 1;
    this.usePrevious = true;
    this.eof = false;
  }
  
  public boolean end()
  {
    return (this.eof) && (!this.usePrevious);
  }
  
  public char next()
  {
    int k = 0;
    int i;
    int j;
    if (this.usePrevious)
    {
      this.usePrevious = false;
      i = this.previous;
      this.index += 1;
      if (this.previous != '\r') {
        break label113;
      }
      this.line += 1;
      if (i != 10) {
        break label108;
      }
      j = k;
      label56:
      this.character = j;
    }
    for (;;)
    {
      this.previous = ((char)i);
      return this.previous;
      try
      {
        j = this.reader.read();
        i = j;
        if (j > 0) {
          break;
        }
        this.eof = true;
        i = 0;
      }
      catch (IOException localIOException)
      {
        throw new JSONException(localIOException);
      }
      label108:
      j = 1;
      break label56;
      label113:
      if (i == 10)
      {
        this.line += 1;
        this.character = 0;
      }
      else
      {
        this.character += 1;
      }
    }
  }
  
  public String next(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfChar[i] = next();
      if (end()) {
        throw syntaxError("Substring bounds error");
      }
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public char nextClean()
  {
    char c;
    do
    {
      c = next();
    } while ((c != 0) && (c <= ' '));
    return c;
  }
  
  public String nextString(char paramChar)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      char c = next();
      switch (c)
      {
      default: 
        if (c == paramChar) {
          return localStringBuffer.toString();
        }
        break;
      case '\000': 
      case '\n': 
      case '\r': 
        throw syntaxError("Unterminated string");
      case '\\': 
        c = next();
        switch (c)
        {
        default: 
          throw syntaxError("Illegal escape.");
        case 'b': 
          localStringBuffer.append('\b');
          break;
        case 't': 
          localStringBuffer.append('\t');
          break;
        case 'n': 
          localStringBuffer.append('\n');
          break;
        case 'f': 
          localStringBuffer.append('\f');
          break;
        case 'r': 
          localStringBuffer.append('\r');
          break;
        case 'u': 
          localStringBuffer.append((char)Integer.parseInt(next(4), 16));
          break;
        case '"': 
        case '\'': 
        case '/': 
        case '\\': 
          localStringBuffer.append(c);
        }
        break;
      }
      localStringBuffer.append(c);
    }
  }
  
  public Object nextValue()
  {
    char c = nextClean();
    switch (c)
    {
    default: 
      localObject = new StringBuffer();
    }
    while ((c >= ' ') && (",:]}/\\\"[{;=#".indexOf(c) < 0))
    {
      ((StringBuffer)localObject).append(c);
      c = next();
      continue;
      return nextString(c);
      back();
      return new JSONObject(this);
      back();
      return new JSONArray(this);
    }
    back();
    Object localObject = ((StringBuffer)localObject).toString().trim();
    if (((String)localObject).equals("")) {
      throw syntaxError("Missing value");
    }
    return JSONObject.stringToValue((String)localObject);
  }
  
  public JSONException syntaxError(String paramString)
  {
    return new JSONException(paramString + toString());
  }
  
  public String toString()
  {
    return " at " + this.index + " [character " + this.character + " line " + this.line + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/json/JSONTokener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */