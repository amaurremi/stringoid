package com.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ParseFieldOperations
{
  static Map<String, ParseFieldOperationFactory> opDecoderMap = new HashMap();
  
  static ParseFieldOperation decode(JSONObject paramJSONObject)
    throws JSONException
  {
    String str = paramJSONObject.optString("__op");
    ParseFieldOperationFactory localParseFieldOperationFactory = (ParseFieldOperationFactory)opDecoderMap.get(str);
    if (localParseFieldOperationFactory == null) {
      throw new RuntimeException("Unable to decode operation of type " + str);
    }
    return localParseFieldOperationFactory.decode(paramJSONObject);
  }
  
  static ArrayList<Object> jsonArrayAsArrayList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONArray.length()) {
        return localArrayList;
      }
      try
      {
        localArrayList.add(paramJSONArray.get(i));
        i += 1;
      }
      catch (JSONException paramJSONArray)
      {
        throw new RuntimeException(paramJSONArray);
      }
    }
  }
  
  private static void registerDecoder(String paramString, ParseFieldOperationFactory paramParseFieldOperationFactory)
  {
    opDecoderMap.put(paramString, paramParseFieldOperationFactory);
  }
  
  static void registerDefaultDecoders()
  {
    registerDecoder("Batch", new ParseFieldOperationFactory()
    {
      public ParseFieldOperation decode(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        Object localObject = null;
        JSONArray localJSONArray = paramAnonymousJSONObject.getJSONArray("ops");
        int i = 0;
        paramAnonymousJSONObject = (JSONObject)localObject;
        for (;;)
        {
          if (i >= localJSONArray.length()) {
            return paramAnonymousJSONObject;
          }
          paramAnonymousJSONObject = ParseFieldOperations.decode(localJSONArray.getJSONObject(i)).mergeWithPrevious(paramAnonymousJSONObject);
          i += 1;
        }
      }
    });
    registerDecoder("Delete", new ParseFieldOperationFactory()
    {
      public ParseFieldOperation decode(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        return ParseDeleteOperation.getInstance();
      }
    });
    registerDecoder("Increment", new ParseFieldOperationFactory()
    {
      public ParseFieldOperation decode(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        return new ParseIncrementOperation((Number)paramAnonymousJSONObject.opt("amount"));
      }
    });
    registerDecoder("Add", new ParseFieldOperationFactory()
    {
      public ParseFieldOperation decode(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        return new ParseAddOperation(paramAnonymousJSONObject.opt("objects"));
      }
    });
    registerDecoder("AddUnique", new ParseFieldOperationFactory()
    {
      public ParseFieldOperation decode(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        return new ParseAddUniqueOperation(paramAnonymousJSONObject.opt("objects"));
      }
    });
    registerDecoder("Remove", new ParseFieldOperationFactory()
    {
      public ParseFieldOperation decode(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        return new ParseRemoveOperation(paramAnonymousJSONObject.opt("objects"));
      }
    });
    registerDecoder("AddRelation", new ParseFieldOperationFactory()
    {
      public ParseFieldOperation decode(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        return new ParseRelationOperation(null, null);
      }
    });
    registerDecoder("RemoveRelation", new ParseFieldOperationFactory()
    {
      public ParseFieldOperation decode(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        return new ParseRelationOperation(null, null);
      }
    });
  }
  
  private static abstract interface ParseFieldOperationFactory
  {
    public abstract ParseFieldOperation decode(JSONObject paramJSONObject)
      throws JSONException;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseFieldOperations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */