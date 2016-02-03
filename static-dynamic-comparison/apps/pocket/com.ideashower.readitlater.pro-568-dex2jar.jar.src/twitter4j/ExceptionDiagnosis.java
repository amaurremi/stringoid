package twitter4j;

import java.io.Serializable;

final class ExceptionDiagnosis
  implements Serializable
{
  private static final long serialVersionUID = 453958937114285988L;
  String hexString = "";
  int lineNumberHash;
  int stackLineHash;
  Throwable th;
  
  ExceptionDiagnosis(Throwable paramThrowable)
  {
    this(paramThrowable, new String[0]);
  }
  
  ExceptionDiagnosis(Throwable paramThrowable, String[] paramArrayOfString)
  {
    this.th = paramThrowable;
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    this.stackLineHash = 0;
    this.lineNumberHash = 0;
    int i = arrayOfStackTraceElement.length - 1;
    if (i >= 0)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      int k = paramArrayOfString.length;
      int j = 0;
      for (;;)
      {
        if (j < k)
        {
          String str = paramArrayOfString[j];
          if (localStackTraceElement.getClassName().startsWith(str))
          {
            this.stackLineHash = (localStackTraceElement.getClassName().hashCode() + localStackTraceElement.getMethodName().hashCode() + this.stackLineHash * 31);
            this.lineNumberHash = (this.lineNumberHash * 31 + localStackTraceElement.getLineNumber());
          }
        }
        else
        {
          i -= 1;
          break;
        }
        j += 1;
      }
    }
    this.hexString = (this.hexString + toHexString(this.stackLineHash) + "-" + toHexString(this.lineNumberHash));
    if (paramThrowable.getCause() != null) {
      this.hexString = (this.hexString + " " + new ExceptionDiagnosis(paramThrowable.getCause(), paramArrayOfString).asHexString());
    }
  }
  
  private String toHexString(int paramInt)
  {
    String str = "0000000" + Integer.toHexString(paramInt);
    return str.substring(str.length() - 8, str.length());
  }
  
  String asHexString()
  {
    return this.hexString;
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
      paramObject = (ExceptionDiagnosis)paramObject;
      if (this.lineNumberHash != ((ExceptionDiagnosis)paramObject).lineNumberHash) {
        return false;
      }
    } while (this.stackLineHash == ((ExceptionDiagnosis)paramObject).stackLineHash);
    return false;
  }
  
  int getLineNumberHash()
  {
    return this.lineNumberHash;
  }
  
  String getLineNumberHashAsHex()
  {
    return toHexString(this.lineNumberHash);
  }
  
  int getStackLineHash()
  {
    return this.stackLineHash;
  }
  
  String getStackLineHashAsHex()
  {
    return toHexString(this.stackLineHash);
  }
  
  public int hashCode()
  {
    return this.stackLineHash * 31 + this.lineNumberHash;
  }
  
  public String toString()
  {
    return "ExceptionDiagnosis{stackLineHash=" + this.stackLineHash + ", lineNumberHash=" + this.lineNumberHash + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/ExceptionDiagnosis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */