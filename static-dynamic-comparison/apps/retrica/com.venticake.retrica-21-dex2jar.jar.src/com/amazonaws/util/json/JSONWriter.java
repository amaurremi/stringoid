package com.amazonaws.util.json;

import com.amazonaws.util.BinaryUtils;
import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;

public class JSONWriter
{
  private boolean comma = false;
  protected char mode = 'i';
  private JSONObject[] stack = new JSONObject[20];
  private int top = 0;
  protected Writer writer;
  
  public JSONWriter(Writer paramWriter)
  {
    this.writer = paramWriter;
  }
  
  private JSONWriter append(String paramString)
  {
    if (paramString == null) {
      throw new JSONException("Null pointer");
    }
    if ((this.mode == 'o') || (this.mode == 'a')) {
      try
      {
        if ((this.comma) && (this.mode == 'a')) {
          this.writer.write(44);
        }
        this.writer.write(paramString);
        if (this.mode == 'o') {
          this.mode = 'k';
        }
        this.comma = true;
        return this;
      }
      catch (IOException paramString)
      {
        throw new JSONException(paramString);
      }
    }
    throw new JSONException("Value out of sequence.");
  }
  
  private JSONWriter end(char paramChar1, char paramChar2)
  {
    if (this.mode != paramChar1)
    {
      if (paramChar1 == 'a') {}
      for (String str = "Misplaced endArray.";; str = "Misplaced endObject.") {
        throw new JSONException(str);
      }
    }
    pop(paramChar1);
    try
    {
      this.writer.write(paramChar2);
      this.comma = true;
      return this;
    }
    catch (IOException localIOException)
    {
      throw new JSONException(localIOException);
    }
  }
  
  private void pop(char paramChar)
  {
    char c1 = 'a';
    if (this.top <= 0) {
      throw new JSONException("Nesting error.");
    }
    if (this.stack[(this.top - 1)] == null) {}
    for (char c2 = 'a'; c2 != paramChar; c2 = 'k') {
      throw new JSONException("Nesting error.");
    }
    this.top -= 1;
    if (this.top == 0) {
      c1 = 'd';
    }
    for (;;)
    {
      this.mode = c1;
      return;
      if (this.stack[(this.top - 1)] != null) {
        c1 = 'k';
      }
    }
  }
  
  private void push(JSONObject paramJSONObject)
  {
    if (this.top >= 20) {
      throw new JSONException("Nesting too deep.");
    }
    this.stack[this.top] = paramJSONObject;
    if (paramJSONObject == null) {}
    for (char c = 'a';; c = 'k')
    {
      this.mode = c;
      this.top += 1;
      return;
    }
  }
  
  public JSONWriter endObject()
  {
    return end('k', '}');
  }
  
  public JSONWriter key(String paramString)
  {
    if (paramString == null) {
      throw new JSONException("Null key.");
    }
    if (this.mode == 'k') {
      try
      {
        this.stack[(this.top - 1)].putOnce(paramString, Boolean.TRUE);
        if (this.comma) {
          this.writer.write(44);
        }
        this.writer.write(JSONObject.quote(paramString));
        this.writer.write(58);
        this.comma = false;
        this.mode = 'o';
        return this;
      }
      catch (IOException paramString)
      {
        throw new JSONException(paramString);
      }
    }
    throw new JSONException("Misplaced key.");
  }
  
  public JSONWriter object()
  {
    if (this.mode == 'i') {
      this.mode = 'o';
    }
    if ((this.mode == 'o') || (this.mode == 'a'))
    {
      append("{");
      push(new JSONObject());
      this.comma = false;
      return this;
    }
    throw new JSONException("Misplaced object.");
  }
  
  public JSONWriter value(Object paramObject)
  {
    return append(JSONObject.valueToString(paramObject));
  }
  
  public JSONWriter value(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.mark();
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte, 0, arrayOfByte.length);
    paramByteBuffer.reset();
    return value(BinaryUtils.toBase64(arrayOfByte));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/json/JSONWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */