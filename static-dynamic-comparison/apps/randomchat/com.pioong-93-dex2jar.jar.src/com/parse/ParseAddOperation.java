package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseAddOperation
  implements ParseFieldOperation
{
  protected final ArrayList<Object> objects = new ArrayList();
  
  public ParseAddOperation(Object paramObject)
  {
    this.objects.add(paramObject);
  }
  
  public ParseAddOperation(Collection<?> paramCollection)
  {
    this.objects.addAll(paramCollection);
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    if (paramObject == null) {
      return this.objects;
    }
    if ((paramObject instanceof JSONArray)) {
      return new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)paramObject), paramParseObject, paramString));
    }
    if ((paramObject instanceof List))
    {
      paramObject = new ArrayList((List)paramObject);
      ((ArrayList)paramObject).addAll(this.objects);
      return paramObject;
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
  
  public JSONObject encode()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__op", "Add");
    localJSONObject.put("objects", Parse.maybeReferenceAndEncode(this.objects));
    return localJSONObject;
  }
  
  public ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation)
  {
    if (paramParseFieldOperation == null) {
      return this;
    }
    if ((paramParseFieldOperation instanceof ParseDeleteOperation)) {
      return new ParseSetOperation(this.objects);
    }
    if ((paramParseFieldOperation instanceof ParseSetOperation))
    {
      paramParseFieldOperation = ((ParseSetOperation)paramParseFieldOperation).getValue();
      if ((paramParseFieldOperation instanceof JSONArray))
      {
        paramParseFieldOperation = ParseFieldOperations.jsonArrayAsArrayList((JSONArray)paramParseFieldOperation);
        paramParseFieldOperation.addAll(this.objects);
        return new ParseSetOperation(new JSONArray(paramParseFieldOperation));
      }
      if ((paramParseFieldOperation instanceof List))
      {
        paramParseFieldOperation = new ArrayList((List)paramParseFieldOperation);
        paramParseFieldOperation.addAll(this.objects);
        return new ParseSetOperation(paramParseFieldOperation);
      }
      throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
    }
    if ((paramParseFieldOperation instanceof ParseAddOperation))
    {
      paramParseFieldOperation = new ArrayList(((ParseAddOperation)paramParseFieldOperation).objects);
      paramParseFieldOperation.addAll(this.objects);
      return new ParseAddOperation(paramParseFieldOperation);
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseAddOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */