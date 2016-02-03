package org.jsoup.safety;

import org.jsoup.helper.Validate;

abstract class Whitelist$TypedValue
{
  private String value;
  
  Whitelist$TypedValue(String paramString)
  {
    Validate.notNull(paramString);
    this.value = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (TypedValue)paramObject;
        if (this.value != null) {
          break;
        }
      } while (((TypedValue)paramObject).value == null);
      return false;
    } while (this.value.equals(((TypedValue)paramObject).value));
    return false;
  }
  
  public int hashCode()
  {
    if (this.value == null) {}
    for (int i = 0;; i = this.value.hashCode()) {
      return i + 31;
    }
  }
  
  public String toString()
  {
    return this.value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/safety/Whitelist$TypedValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */