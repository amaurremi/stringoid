package com.flurry.org.codehaus.jackson.io;

import com.flurry.org.codehaus.jackson.SerializableString;

public class SerializedString
  implements SerializableString
{
  protected char[] _quotedChars;
  protected byte[] _quotedUTF8Ref;
  protected byte[] _unquotedUTF8Ref;
  protected final String _value;
  
  public SerializedString(String paramString)
  {
    this._value = paramString;
  }
  
  public final char[] asQuotedChars()
  {
    char[] arrayOfChar2 = this._quotedChars;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = JsonStringEncoder.getInstance().quoteAsString(this._value);
      this._quotedChars = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public final byte[] asQuotedUTF8()
  {
    byte[] arrayOfByte2 = this._quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().quoteAsUTF8(this._value);
      this._quotedUTF8Ref = arrayOfByte1;
    }
    return arrayOfByte1;
  }
  
  public final byte[] asUnquotedUTF8()
  {
    byte[] arrayOfByte2 = this._unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().encodeAsUTF8(this._value);
      this._unquotedUTF8Ref = arrayOfByte1;
    }
    return arrayOfByte1;
  }
  
  public final int charLength()
  {
    return this._value.length();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      return false;
    }
    paramObject = (SerializedString)paramObject;
    return this._value.equals(((SerializedString)paramObject)._value);
  }
  
  public final String getValue()
  {
    return this._value;
  }
  
  public final int hashCode()
  {
    return this._value.hashCode();
  }
  
  public final String toString()
  {
    return this._value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/io/SerializedString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */