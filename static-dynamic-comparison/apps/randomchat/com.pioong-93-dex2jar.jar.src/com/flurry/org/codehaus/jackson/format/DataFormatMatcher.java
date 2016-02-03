package com.flurry.org.codehaus.jackson.format;

import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.io.MergedStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataFormatMatcher
{
  protected final byte[] _bufferedData;
  protected final int _bufferedLength;
  protected final JsonFactory _match;
  protected final MatchStrength _matchStrength;
  protected final InputStream _originalStream;
  
  protected DataFormatMatcher(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt, JsonFactory paramJsonFactory, MatchStrength paramMatchStrength)
  {
    this._originalStream = paramInputStream;
    this._bufferedData = paramArrayOfByte;
    this._bufferedLength = paramInt;
    this._match = paramJsonFactory;
    this._matchStrength = paramMatchStrength;
  }
  
  public JsonParser createParserWithMatch()
    throws IOException
  {
    if (this._match == null) {
      return null;
    }
    if (this._originalStream == null) {
      return this._match.createJsonParser(this._bufferedData, 0, this._bufferedLength);
    }
    return this._match.createJsonParser(getDataStream());
  }
  
  public InputStream getDataStream()
  {
    if (this._originalStream == null) {
      return new ByteArrayInputStream(this._bufferedData, 0, this._bufferedLength);
    }
    return new MergedStream(null, this._originalStream, this._bufferedData, 0, this._bufferedLength);
  }
  
  public JsonFactory getMatch()
  {
    return this._match;
  }
  
  public MatchStrength getMatchStrength()
  {
    if (this._matchStrength == null) {
      return MatchStrength.INCONCLUSIVE;
    }
    return this._matchStrength;
  }
  
  public String getMatchedFormatName()
  {
    return this._match.getFormatName();
  }
  
  public boolean hasMatch()
  {
    return this._match != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/format/DataFormatMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */