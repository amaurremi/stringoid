package com.mongodb;

public class LazyWriteableDBDecoder
  extends LazyDBDecoder
{
  public static DBDecoderFactory FACTORY = new LazyDBDecoderFactory();
  
  public DBCallback getDBCallback(DBCollection paramDBCollection)
  {
    return new LazyWriteableDBCallback(paramDBCollection);
  }
  
  static class LazyDBDecoderFactory
    implements DBDecoderFactory
  {
    public DBDecoder create()
    {
      return new LazyWriteableDBDecoder();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/LazyWriteableDBDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */