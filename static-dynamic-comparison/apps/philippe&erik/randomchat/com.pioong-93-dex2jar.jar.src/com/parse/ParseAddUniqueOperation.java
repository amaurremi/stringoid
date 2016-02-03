package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseAddUniqueOperation
  implements ParseFieldOperation
{
  protected LinkedHashSet<Object> objects = new LinkedHashSet();
  
  public ParseAddUniqueOperation(Object paramObject)
  {
    this.objects.add(paramObject);
  }
  
  public ParseAddUniqueOperation(Collection<?> paramCollection)
  {
    this.objects.addAll(paramCollection);
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    if (paramObject == null)
    {
      paramObject = new ArrayList(this.objects);
      return paramObject;
    }
    if ((paramObject instanceof JSONArray)) {
      return new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)paramObject), paramParseObject, paramString));
    }
    if ((paramObject instanceof List))
    {
      paramParseObject = new ArrayList((List)paramObject);
      paramString = new HashMap();
      int i = 0;
      label79:
      Iterator localIterator;
      if (i >= paramParseObject.size()) {
        localIterator = this.objects.iterator();
      }
      for (;;)
      {
        paramObject = paramParseObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramObject = localIterator.next();
        if ((paramObject instanceof ParseObject))
        {
          Integer localInteger = (Integer)paramString.get(((ParseObject)paramObject).getObjectId());
          if (localInteger != null)
          {
            paramParseObject.set(localInteger.intValue(), paramObject);
            continue;
            if ((paramParseObject.get(i) instanceof ParseObject)) {
              paramString.put(((ParseObject)paramParseObject.get(i)).getObjectId(), Integer.valueOf(i));
            }
            i += 1;
            break label79;
          }
          paramParseObject.add(paramObject);
          continue;
        }
        if (!paramParseObject.contains(paramObject)) {
          paramParseObject.add(paramObject);
        }
      }
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
  
  public JSONObject encode()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__op", "AddUnique");
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
    if ((paramParseFieldOperation instanceof ParseAddUniqueOperation)) {
      return new ParseAddUniqueOperation((List)apply(new ArrayList(((ParseAddUniqueOperation)paramParseFieldOperation).objects), null, null));
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseAddUniqueOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */