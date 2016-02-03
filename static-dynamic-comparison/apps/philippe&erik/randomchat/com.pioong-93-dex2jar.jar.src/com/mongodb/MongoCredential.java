package com.mongodb;

import java.util.Arrays;
import org.bson.util.annotations.Immutable;

@Immutable
public final class MongoCredential
{
  public static final String GSSAPI_MECHANISM = "GSSAPI";
  public static final String MONGODB_CR_MECHANISM = "MONGODB-CR";
  private final String mechanism;
  private final char[] password;
  private final String source;
  private final String userName;
  
  MongoCredential(String paramString1, String paramString2, String paramString3, char[] paramArrayOfChar)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("mechanism can not be null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("username can not be null");
    }
    if ((paramString1.equals("MONGODB-CR")) && (paramArrayOfChar == null)) {
      throw new IllegalArgumentException("Password can not be null for MONGODB-CR mechanism");
    }
    if ((paramString1.equals("GSSAPI")) && (paramArrayOfChar != null)) {
      throw new IllegalArgumentException("Password must be null for the GSSAPI mechanism");
    }
    this.mechanism = paramString1;
    this.userName = paramString2;
    this.source = paramString3;
    if (paramArrayOfChar != null) {}
    for (paramString1 = (char[])paramArrayOfChar.clone();; paramString1 = null)
    {
      this.password = paramString1;
      return;
    }
  }
  
  public static MongoCredential createGSSAPICredential(String paramString)
  {
    return new MongoCredential("GSSAPI", paramString, "$external", null);
  }
  
  public static MongoCredential createMongoCRCredential(String paramString1, String paramString2, char[] paramArrayOfChar)
  {
    return new MongoCredential("MONGODB-CR", paramString1, paramString2, paramArrayOfChar);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (MongoCredential)paramObject;
      if (!this.mechanism.equals(((MongoCredential)paramObject).mechanism)) {
        return false;
      }
      if (!Arrays.equals(this.password, ((MongoCredential)paramObject).password)) {
        return false;
      }
      if (!this.source.equals(((MongoCredential)paramObject).source)) {
        return false;
      }
    } while (this.userName.equals(((MongoCredential)paramObject).userName));
    return false;
  }
  
  public String getMechanism()
  {
    return this.mechanism;
  }
  
  public char[] getPassword()
  {
    if (this.password == null) {
      return null;
    }
    return (char[])this.password.clone();
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public int hashCode()
  {
    int j = this.mechanism.hashCode();
    int k = this.userName.hashCode();
    int m = this.source.hashCode();
    if (this.password != null) {}
    for (int i = Arrays.hashCode(this.password);; i = 0) {
      return ((j * 31 + k) * 31 + m) * 31 + i;
    }
  }
  
  public String toString()
  {
    return "MongoCredential{mechanism='" + this.mechanism + '\'' + ", userName='" + this.userName + '\'' + ", source='" + this.source + '\'' + ", password=<hidden>" + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoCredential.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */