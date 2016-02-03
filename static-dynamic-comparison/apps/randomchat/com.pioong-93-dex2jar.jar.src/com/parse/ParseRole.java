package com.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ParseClassName("_Role")
public class ParseRole
  extends ParseObject
{
  private static final Pattern NAME_PATTERN = Pattern.compile("^[0-9a-zA-Z_\\- ]+$");
  
  ParseRole() {}
  
  public ParseRole(String paramString)
  {
    this();
    setName(paramString);
  }
  
  public ParseRole(String paramString, ParseACL paramParseACL)
  {
    this(paramString);
    setACL(paramParseACL);
  }
  
  public static ParseQuery<ParseRole> getQuery()
  {
    return ParseQuery.getQuery(ParseRole.class);
  }
  
  public String getName()
  {
    return getString("name");
  }
  
  public ParseRelation<ParseRole> getRoles()
  {
    return getRelation("roles");
  }
  
  public ParseRelation<ParseUser> getUsers()
  {
    return getRelation("users");
  }
  
  public void put(String paramString, Object paramObject)
  {
    if ("name".equals(paramString))
    {
      if (getObjectId() != null) {
        throw new IllegalArgumentException("A role's name can only be set before it has been saved.");
      }
      if (!(paramObject instanceof String)) {
        throw new IllegalArgumentException("A role's name must be a String.");
      }
      if (!NAME_PATTERN.matcher((String)paramObject).matches()) {
        throw new IllegalArgumentException("A role's name can only contain alphanumeric characters, _, -, and spaces.");
      }
    }
    super.put(paramString, paramObject);
  }
  
  public void setName(String paramString)
  {
    put("name", paramString);
  }
  
  protected void validateSave()
  {
    synchronized (this.mutex)
    {
      if ((getObjectId() == null) && (getName() == null)) {
        throw new IllegalStateException("New roles must specify a name.");
      }
    }
    super.validateSave();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */