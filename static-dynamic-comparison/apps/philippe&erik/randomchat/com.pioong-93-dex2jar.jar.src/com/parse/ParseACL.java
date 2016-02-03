package com.parse;

import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseACL
{
  private static final String PUBLIC_KEY = "*";
  private static final String UNRESOLVED_KEY = "*unresolved";
  private static ParseACL defaultACL;
  private static boolean defaultACLUsesCurrentUser;
  private static ParseACL defaultACLWithCurrentUser;
  private static WeakReference<ParseUser> lastCurrentUser;
  private JSONObject permissionsById = new JSONObject();
  private boolean shared;
  private ParseUser unresolvedUser;
  
  public ParseACL() {}
  
  public ParseACL(ParseUser paramParseUser)
  {
    this();
    setReadAccess(paramParseUser, true);
    setWriteAccess(paramParseUser, true);
  }
  
  /* Error */
  static ParseACL createACLFromJSONObject(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 2	com/parse/ParseACL
    //   3: dup
    //   4: invokespecial 39	com/parse/ParseACL:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokestatic 61	com/parse/Parse:keys	(Lorg/json/JSONObject;)Ljava/lang/Iterable;
    //   12: invokeinterface 67 1 0
    //   17: astore_2
    //   18: aload_2
    //   19: invokeinterface 73 1 0
    //   24: ifne +5 -> 29
    //   27: aload_1
    //   28: areturn
    //   29: aload_2
    //   30: invokeinterface 77 1 0
    //   35: checkcast 79	java/lang/String
    //   38: astore_3
    //   39: aload_0
    //   40: aload_3
    //   41: invokevirtual 83	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   44: astore 4
    //   46: aload 4
    //   48: invokestatic 61	com/parse/Parse:keys	(Lorg/json/JSONObject;)Ljava/lang/Iterable;
    //   51: invokeinterface 67 1 0
    //   56: astore 4
    //   58: aload 4
    //   60: invokeinterface 73 1 0
    //   65: ifeq -47 -> 18
    //   68: aload_1
    //   69: aload 4
    //   71: invokeinterface 77 1 0
    //   76: checkcast 79	java/lang/String
    //   79: aload_3
    //   80: iconst_1
    //   81: invokespecial 87	com/parse/ParseACL:setAccess	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   84: goto -26 -> 58
    //   87: astore_0
    //   88: new 89	java/lang/RuntimeException
    //   91: dup
    //   92: new 91	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 93
    //   98: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 100	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 108	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramJSONObject	JSONObject
    //   7	62	1	localParseACL	ParseACL
    //   17	13	2	localIterator	java.util.Iterator
    //   38	42	3	str	String
    //   44	26	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	46	87	org/json/JSONException
  }
  
  private boolean getAccess(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = this.permissionsById.optJSONObject(paramString2);
      if (paramString2 == null) {
        return false;
      }
      if (paramString2.has(paramString1))
      {
        boolean bool = paramString2.getBoolean(paramString1);
        return bool;
      }
    }
    catch (JSONException paramString1)
    {
      throw new RuntimeException("JSON failure with ACL: " + paramString1.getMessage());
    }
    return false;
  }
  
  static ParseACL getDefaultACL()
  {
    if ((defaultACLUsesCurrentUser) && (defaultACL != null))
    {
      if (lastCurrentUser != null) {}
      for (ParseUser localParseUser = (ParseUser)lastCurrentUser.get(); ParseUser.getCurrentUser() == null; localParseUser = null) {
        return defaultACL;
      }
      if (localParseUser != ParseUser.getCurrentUser())
      {
        defaultACLWithCurrentUser = defaultACL.copy();
        defaultACLWithCurrentUser.setShared(true);
        defaultACLWithCurrentUser.setReadAccess(ParseUser.getCurrentUser(), true);
        defaultACLWithCurrentUser.setWriteAccess(ParseUser.getCurrentUser(), true);
        lastCurrentUser = new WeakReference(ParseUser.getCurrentUser());
      }
      return defaultACLWithCurrentUser;
    }
    return defaultACL;
  }
  
  private void prepareUnresolvedUser(ParseUser paramParseUser)
  {
    if (this.unresolvedUser != paramParseUser)
    {
      this.permissionsById.remove("*unresolved");
      this.unresolvedUser = paramParseUser;
      paramParseUser.registerSaveListener(new UserResolutionListener(this));
    }
  }
  
  private void resolveUser(ParseUser paramParseUser)
  {
    if (paramParseUser != this.unresolvedUser) {
      return;
    }
    try
    {
      if (this.permissionsById.has("*unresolved"))
      {
        this.permissionsById.put(paramParseUser.getObjectId(), this.permissionsById.get("*unresolved"));
        this.permissionsById.remove("*unresolved");
      }
      this.unresolvedUser = null;
      return;
    }
    catch (JSONException paramParseUser)
    {
      throw new RuntimeException(paramParseUser);
    }
  }
  
  private void setAccess(String paramString1, String paramString2, boolean paramBoolean)
  {
    JSONObject localJSONObject1;
    try
    {
      JSONObject localJSONObject2 = this.permissionsById.optJSONObject(paramString2);
      localJSONObject1 = localJSONObject2;
      if (localJSONObject2 == null)
      {
        if (!paramBoolean) {
          return;
        }
        localJSONObject1 = new JSONObject();
        this.permissionsById.put(paramString2, localJSONObject1);
      }
      if (paramBoolean)
      {
        localJSONObject1.put(paramString1, true);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      throw new RuntimeException("JSON failure with ACL: " + paramString1.getMessage());
    }
    localJSONObject1.remove(paramString1);
    if (localJSONObject1.length() == 0) {
      this.permissionsById.remove(paramString2);
    }
  }
  
  public static void setDefaultACL(ParseACL paramParseACL, boolean paramBoolean)
  {
    defaultACLWithCurrentUser = null;
    lastCurrentUser = null;
    if (paramParseACL != null)
    {
      defaultACL = paramParseACL.copy();
      defaultACL.setShared(true);
      defaultACLUsesCurrentUser = paramBoolean;
      return;
    }
    defaultACL = null;
  }
  
  private void setUnresolvedReadAccess(ParseUser paramParseUser, boolean paramBoolean)
  {
    prepareUnresolvedUser(paramParseUser);
    setReadAccess("*unresolved", paramBoolean);
  }
  
  private void setUnresolvedWriteAccess(ParseUser paramParseUser, boolean paramBoolean)
  {
    prepareUnresolvedUser(paramParseUser);
    setWriteAccess("*unresolved", paramBoolean);
  }
  
  private static void validateRoleState(ParseRole paramParseRole)
  {
    if (paramParseRole.getObjectId() == null) {
      throw new IllegalArgumentException("Roles must be saved to the server before they can be used in an ACL.");
    }
  }
  
  ParseACL copy()
  {
    ParseACL localParseACL = new ParseACL();
    try
    {
      localParseACL.permissionsById = new JSONObject(this.permissionsById.toString());
      localParseACL.unresolvedUser = this.unresolvedUser;
      if (this.unresolvedUser != null) {
        this.unresolvedUser.registerSaveListener(new UserResolutionListener(localParseACL));
      }
      return localParseACL;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public boolean getPublicReadAccess()
  {
    return getReadAccess("*");
  }
  
  public boolean getPublicWriteAccess()
  {
    return getWriteAccess("*");
  }
  
  public boolean getReadAccess(ParseUser paramParseUser)
  {
    if (paramParseUser == this.unresolvedUser) {
      return getReadAccess("*unresolved");
    }
    if (paramParseUser.getObjectId() == null) {
      throw new IllegalArgumentException("cannot getReadAccess for a user with null id");
    }
    return getReadAccess(paramParseUser.getObjectId());
  }
  
  public boolean getReadAccess(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot getReadAccess for null userId");
    }
    return getAccess("read", paramString);
  }
  
  public boolean getRoleReadAccess(ParseRole paramParseRole)
  {
    validateRoleState(paramParseRole);
    return getRoleReadAccess(paramParseRole.getName());
  }
  
  public boolean getRoleReadAccess(String paramString)
  {
    return getReadAccess("role:" + paramString);
  }
  
  public boolean getRoleWriteAccess(ParseRole paramParseRole)
  {
    validateRoleState(paramParseRole);
    return getRoleWriteAccess(paramParseRole.getName());
  }
  
  public boolean getRoleWriteAccess(String paramString)
  {
    return getWriteAccess("role:" + paramString);
  }
  
  public boolean getWriteAccess(ParseUser paramParseUser)
  {
    if (paramParseUser == this.unresolvedUser) {
      return getWriteAccess("*unresolved");
    }
    if (paramParseUser.getObjectId() == null) {
      throw new IllegalArgumentException("cannot getWriteAccess for a user with null id");
    }
    return getWriteAccess(paramParseUser.getObjectId());
  }
  
  public boolean getWriteAccess(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot getWriteAccess for null userId");
    }
    return getAccess("write", paramString);
  }
  
  boolean hasUnresolvedUser()
  {
    return this.unresolvedUser != null;
  }
  
  boolean isShared()
  {
    return this.shared;
  }
  
  public void setPublicReadAccess(boolean paramBoolean)
  {
    setReadAccess("*", paramBoolean);
  }
  
  public void setPublicWriteAccess(boolean paramBoolean)
  {
    setWriteAccess("*", paramBoolean);
  }
  
  public void setReadAccess(ParseUser paramParseUser, boolean paramBoolean)
  {
    if (paramParseUser.getObjectId() == null)
    {
      if (paramParseUser.isLazy())
      {
        setUnresolvedReadAccess(paramParseUser, paramBoolean);
        return;
      }
      throw new IllegalArgumentException("cannot setReadAccess for a user with null id");
    }
    setReadAccess(paramParseUser.getObjectId(), paramBoolean);
  }
  
  public void setReadAccess(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot setReadAccess for null userId");
    }
    setAccess("read", paramString, paramBoolean);
  }
  
  public void setRoleReadAccess(ParseRole paramParseRole, boolean paramBoolean)
  {
    validateRoleState(paramParseRole);
    setRoleReadAccess(paramParseRole.getName(), paramBoolean);
  }
  
  public void setRoleReadAccess(String paramString, boolean paramBoolean)
  {
    setReadAccess("role:" + paramString, paramBoolean);
  }
  
  public void setRoleWriteAccess(ParseRole paramParseRole, boolean paramBoolean)
  {
    validateRoleState(paramParseRole);
    setRoleWriteAccess(paramParseRole.getName(), paramBoolean);
  }
  
  public void setRoleWriteAccess(String paramString, boolean paramBoolean)
  {
    setWriteAccess("role:" + paramString, paramBoolean);
  }
  
  void setShared(boolean paramBoolean)
  {
    this.shared = paramBoolean;
  }
  
  public void setWriteAccess(ParseUser paramParseUser, boolean paramBoolean)
  {
    if (paramParseUser.getObjectId() == null)
    {
      if (paramParseUser.isLazy())
      {
        setUnresolvedWriteAccess(paramParseUser, paramBoolean);
        return;
      }
      throw new IllegalArgumentException("cannot setWriteAccess for a user with null id");
    }
    setWriteAccess(paramParseUser.getObjectId(), paramBoolean);
  }
  
  public void setWriteAccess(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("cannot setWriteAccess for null userId");
    }
    setAccess("write", paramString, paramBoolean);
  }
  
  JSONObject toJSONObject()
  {
    return this.permissionsById;
  }
  
  private static class UserResolutionListener
    extends GetCallback<ParseObject>
  {
    private final WeakReference<ParseACL> parent;
    
    public UserResolutionListener(ParseACL paramParseACL)
    {
      this.parent = new WeakReference(paramParseACL);
    }
    
    public void done(ParseObject paramParseObject, ParseException paramParseException)
    {
      try
      {
        paramParseException = (ParseACL)this.parent.get();
        if (paramParseException != null) {
          paramParseException.resolveUser((ParseUser)paramParseObject);
        }
        return;
      }
      finally
      {
        paramParseObject.unregisterSaveListener(this);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseACL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */