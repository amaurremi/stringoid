package org.jsoup.helper;

public final class Validate
{
  public static void fail(String paramString)
  {
    throw new IllegalArgumentException(paramString);
  }
  
  public static void isFalse(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("Must be false");
    }
  }
  
  public static void isFalse(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static void isTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException("Must be true");
    }
  }
  
  public static void isTrue(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static void noNullElements(Object[] paramArrayOfObject)
  {
    noNullElements(paramArrayOfObject, "Array must not contain any null objects");
  }
  
  public static void noNullElements(Object[] paramArrayOfObject, String paramString)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfObject[i] == null) {
        throw new IllegalArgumentException(paramString);
      }
      i += 1;
    }
  }
  
  public static void notEmpty(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("String must not be empty");
    }
  }
  
  public static void notEmpty(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new IllegalArgumentException(paramString2);
    }
  }
  
  public static void notNull(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("Object must not be null");
    }
  }
  
  public static void notNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/helper/Validate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */