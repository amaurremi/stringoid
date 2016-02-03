package com.parse;

public abstract class GetDataCallback
  extends ParseCallback<byte[]>
{
  public abstract void done(byte[] paramArrayOfByte, ParseException paramParseException);
  
  final void internalDone(byte[] paramArrayOfByte, ParseException paramParseException)
  {
    done(paramArrayOfByte, paramParseException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/GetDataCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */