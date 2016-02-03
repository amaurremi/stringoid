package org.bson.types;

import org.bson.BSONObject;

public class CodeWScope
  extends Code
{
  private static final long serialVersionUID = -6284832275113680002L;
  final BSONObject _scope;
  
  public CodeWScope(String paramString, BSONObject paramBSONObject)
  {
    super(paramString);
    this._scope = paramBSONObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CodeWScope)) {}
    do
    {
      return false;
      paramObject = (CodeWScope)paramObject;
    } while ((!this._code.equals(((CodeWScope)paramObject)._code)) || (!this._scope.equals(((CodeWScope)paramObject)._scope)));
    return true;
  }
  
  public BSONObject getScope()
  {
    return this._scope;
  }
  
  public int hashCode()
  {
    return this._code.hashCode() ^ this._scope.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/types/CodeWScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */