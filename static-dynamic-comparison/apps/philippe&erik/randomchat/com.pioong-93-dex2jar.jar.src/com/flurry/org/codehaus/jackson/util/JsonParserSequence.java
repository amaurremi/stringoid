package com.flurry.org.codehaus.jackson.util;

import com.flurry.org.codehaus.jackson.JsonParseException;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParserSequence
  extends JsonParserDelegate
{
  protected int _nextParser;
  protected final JsonParser[] _parsers;
  
  protected JsonParserSequence(JsonParser[] paramArrayOfJsonParser)
  {
    super(paramArrayOfJsonParser[0]);
    this._parsers = paramArrayOfJsonParser;
    this._nextParser = 1;
  }
  
  public static JsonParserSequence createFlattened(JsonParser paramJsonParser1, JsonParser paramJsonParser2)
  {
    if ((!(paramJsonParser1 instanceof JsonParserSequence)) && (!(paramJsonParser2 instanceof JsonParserSequence))) {
      return new JsonParserSequence(new JsonParser[] { paramJsonParser1, paramJsonParser2 });
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramJsonParser1 instanceof JsonParserSequence))
    {
      ((JsonParserSequence)paramJsonParser1).addFlattenedActiveParsers(localArrayList);
      if (!(paramJsonParser2 instanceof JsonParserSequence)) {
        break label103;
      }
      ((JsonParserSequence)paramJsonParser2).addFlattenedActiveParsers(localArrayList);
    }
    for (;;)
    {
      return new JsonParserSequence((JsonParser[])localArrayList.toArray(new JsonParser[localArrayList.size()]));
      localArrayList.add(paramJsonParser1);
      break;
      label103:
      localArrayList.add(paramJsonParser2);
    }
  }
  
  protected void addFlattenedActiveParsers(List<JsonParser> paramList)
  {
    int i = this._nextParser - 1;
    int j = this._parsers.length;
    if (i < j)
    {
      JsonParser localJsonParser = this._parsers[i];
      if ((localJsonParser instanceof JsonParserSequence)) {
        ((JsonParserSequence)localJsonParser).addFlattenedActiveParsers(paramList);
      }
      for (;;)
      {
        i += 1;
        break;
        paramList.add(localJsonParser);
      }
    }
  }
  
  public void close()
    throws IOException
  {
    do
    {
      this.delegate.close();
    } while (switchToNext());
  }
  
  public int containedParsersCount()
  {
    return this._parsers.length;
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = this.delegate.nextToken();
    if (localJsonToken != null) {
      return localJsonToken;
    }
    while (switchToNext())
    {
      localJsonToken = this.delegate.nextToken();
      if (localJsonToken != null) {
        return localJsonToken;
      }
    }
    return null;
  }
  
  protected boolean switchToNext()
  {
    if (this._nextParser >= this._parsers.length) {
      return false;
    }
    JsonParser[] arrayOfJsonParser = this._parsers;
    int i = this._nextParser;
    this._nextParser = (i + 1);
    this.delegate = arrayOfJsonParser[i];
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/util/JsonParserSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */