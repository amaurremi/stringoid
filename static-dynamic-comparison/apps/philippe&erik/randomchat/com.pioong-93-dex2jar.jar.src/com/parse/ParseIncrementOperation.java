package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

class ParseIncrementOperation
  implements ParseFieldOperation
{
  private Number amount;
  
  public ParseIncrementOperation(Number paramNumber)
  {
    this.amount = paramNumber;
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    if (paramObject == null) {
      return this.amount;
    }
    if ((paramObject instanceof Number)) {
      return Parse.addNumbers((Number)paramObject, this.amount);
    }
    throw new IllegalArgumentException("You cannot increment a non-number.");
  }
  
  public JSONObject encode()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__op", "Increment");
    localJSONObject.put("amount", this.amount);
    return localJSONObject;
  }
  
  public ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation)
  {
    if (paramParseFieldOperation == null) {
      return this;
    }
    if ((paramParseFieldOperation instanceof ParseDeleteOperation)) {
      return new ParseSetOperation(this.amount);
    }
    if ((paramParseFieldOperation instanceof ParseSetOperation))
    {
      paramParseFieldOperation = ((ParseSetOperation)paramParseFieldOperation).getValue();
      if ((paramParseFieldOperation instanceof Number)) {
        return new ParseSetOperation(Parse.addNumbers((Number)paramParseFieldOperation, this.amount));
      }
      throw new IllegalArgumentException("You cannot increment a non-number.");
    }
    if ((paramParseFieldOperation instanceof ParseIncrementOperation)) {
      return new ParseIncrementOperation(Parse.addNumbers(((ParseIncrementOperation)paramParseFieldOperation).amount, this.amount));
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseIncrementOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */