package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRemoveOperation
  implements ParseFieldOperation
{
  protected HashSet<Object> objects = new HashSet();
  
  public ParseRemoveOperation(Object paramObject)
  {
    this.objects.add(paramObject);
  }
  
  public ParseRemoveOperation(Collection<?> paramCollection)
  {
    this.objects.addAll(paramCollection);
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    if (paramObject == null)
    {
      paramObject = new ArrayList();
      return paramObject;
    }
    if ((paramObject instanceof JSONArray)) {
      return new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)paramObject), paramParseObject, paramString));
    }
    if ((paramObject instanceof List))
    {
      paramParseObject = new ArrayList((List)paramObject);
      paramParseObject.removeAll(this.objects);
      paramObject = new ArrayList(this.objects);
      ((ArrayList)paramObject).removeAll(paramParseObject);
      paramString = new HashSet();
      paramObject = ((ArrayList)paramObject).iterator();
      for (;;)
      {
        if (!((Iterator)paramObject).hasNext())
        {
          localObject = paramParseObject.iterator();
          for (;;)
          {
            paramObject = paramParseObject;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramObject = ((Iterator)localObject).next();
            if (((paramObject instanceof ParseObject)) && (paramString.contains(((ParseObject)paramObject).getObjectId()))) {
              ((Iterator)localObject).remove();
            }
          }
        }
        Object localObject = ((Iterator)paramObject).next();
        if ((localObject instanceof ParseObject)) {
          paramString.add(((ParseObject)localObject).getObjectId());
        }
      }
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
  
  public JSONObject encode()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__op", "Remove");
    localJSONObject.put("objects", Parse.maybeReferenceAndEncode(new ArrayList(this.objects)));
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
      if (((paramParseFieldOperation instanceof JSONArray)) || ((paramParseFieldOperation instanceof List))) {
        return new ParseSetOperation(apply(paramParseFieldOperation, null, null));
      }
      throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
    }
    if ((paramParseFieldOperation instanceof ParseRemoveOperation))
    {
      paramParseFieldOperation = new HashSet(((ParseRemoveOperation)paramParseFieldOperation).objects);
      paramParseFieldOperation.addAll(this.objects);
      return new ParseRemoveOperation(paramParseFieldOperation);
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseRemoveOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */