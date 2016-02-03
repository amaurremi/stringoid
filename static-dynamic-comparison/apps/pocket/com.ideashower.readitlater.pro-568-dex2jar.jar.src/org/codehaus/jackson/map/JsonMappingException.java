package org.codehaus.jackson.map;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;

public class JsonMappingException
  extends JsonProcessingException
{
  static final int MAX_REFS_TO_LIST = 1000;
  private static final long serialVersionUID = 1L;
  protected LinkedList _path;
  
  public JsonMappingException(String paramString)
  {
    super(paramString);
  }
  
  public JsonMappingException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public JsonMappingException(String paramString, JsonLocation paramJsonLocation)
  {
    super(paramString, paramJsonLocation);
  }
  
  public JsonMappingException(String paramString, JsonLocation paramJsonLocation, Throwable paramThrowable)
  {
    super(paramString, paramJsonLocation, paramThrowable);
  }
  
  public static JsonMappingException from(JsonParser paramJsonParser, String paramString)
  {
    return new JsonMappingException(paramString, paramJsonParser.getTokenLocation());
  }
  
  public static JsonMappingException from(JsonParser paramJsonParser, String paramString, Throwable paramThrowable)
  {
    return new JsonMappingException(paramString, paramJsonParser.getTokenLocation(), paramThrowable);
  }
  
  public static JsonMappingException wrapWithPath(Throwable paramThrowable, Object paramObject, int paramInt)
  {
    return wrapWithPath(paramThrowable, new JsonMappingException.Reference(paramObject, paramInt));
  }
  
  public static JsonMappingException wrapWithPath(Throwable paramThrowable, Object paramObject, String paramString)
  {
    return wrapWithPath(paramThrowable, new JsonMappingException.Reference(paramObject, paramString));
  }
  
  public static JsonMappingException wrapWithPath(Throwable paramThrowable, JsonMappingException.Reference paramReference)
  {
    if ((paramThrowable instanceof JsonMappingException)) {}
    String str1;
    for (paramThrowable = (JsonMappingException)paramThrowable;; paramThrowable = new JsonMappingException(str1, null, paramThrowable))
    {
      paramThrowable.prependPath(paramReference);
      return paramThrowable;
      String str2 = paramThrowable.getMessage();
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() != 0) {}
      }
      else
      {
        str1 = "(was " + paramThrowable.getClass().getName() + ")";
      }
    }
  }
  
  protected void _appendPathDesc(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this._path.iterator();
    while (localIterator.hasNext())
    {
      paramStringBuilder.append(((JsonMappingException.Reference)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        paramStringBuilder.append("->");
      }
    }
  }
  
  public String getMessage()
  {
    Object localObject = super.getMessage();
    if (this._path == null) {
      return (String)localObject;
    }
    if (localObject == null) {}
    for (localObject = new StringBuilder();; localObject = new StringBuilder((String)localObject))
    {
      ((StringBuilder)localObject).append(" (through reference chain: ");
      _appendPathDesc((StringBuilder)localObject);
      ((StringBuilder)localObject).append(')');
      return ((StringBuilder)localObject).toString();
    }
  }
  
  public List getPath()
  {
    if (this._path == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(this._path);
  }
  
  public void prependPath(Object paramObject, int paramInt)
  {
    prependPath(new JsonMappingException.Reference(paramObject, paramInt));
  }
  
  public void prependPath(Object paramObject, String paramString)
  {
    prependPath(new JsonMappingException.Reference(paramObject, paramString));
  }
  
  public void prependPath(JsonMappingException.Reference paramReference)
  {
    if (this._path == null) {
      this._path = new LinkedList();
    }
    if (this._path.size() < 1000) {
      this._path.addFirst(paramReference);
    }
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + getMessage();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/JsonMappingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */