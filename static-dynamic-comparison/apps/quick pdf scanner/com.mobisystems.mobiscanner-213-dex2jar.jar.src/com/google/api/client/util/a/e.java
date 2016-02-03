package com.google.api.client.util.a;

public abstract class e
  extends b
{
  private static char[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  protected static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      int j = paramInt1 + 1;
      int i = paramCharSequence.charAt(paramInt1);
      if ((i < 55296) || (i > 57343)) {
        return i;
      }
      if (i <= 56319)
      {
        if (j == paramInt2) {
          return -i;
        }
        char c = paramCharSequence.charAt(j);
        if (Character.isLowSurrogate(c)) {
          return Character.toCodePoint(i, c);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + c + "' with value " + c + " at index " + j);
      }
      throw new IllegalArgumentException("Unexpected low surrogate character '" + i + "' with value " + i + " at index " + (j - 1));
    }
    throw new IndexOutOfBoundsException("Index exceeds specified range");
  }
  
  protected abstract int a(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  
  protected abstract char[] eP(int paramInt);
  
  protected final String j(String paramString, int paramInt)
  {
    int n = paramString.length();
    Object localObject1 = d.yV();
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = j;
    label73:
    int m;
    Object localObject2;
    if (k < n)
    {
      j = b(paramString, k, n);
      if (j < 0) {
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
      }
      char[] arrayOfChar = eP(j);
      if (Character.isSupplementaryCodePoint(j))
      {
        j = 2;
        m = j + k;
        if (arrayOfChar == null) {
          break label291;
        }
        int i1 = k - i;
        j = paramInt + i1 + arrayOfChar.length;
        localObject2 = localObject1;
        if (localObject1.length < j) {
          localObject2 = a((char[])localObject1, paramInt, j + n - k + 32);
        }
        j = paramInt;
        if (i1 > 0)
        {
          paramString.getChars(i, k, (char[])localObject2, paramInt);
          j = paramInt + i1;
        }
        paramInt = j;
        if (arrayOfChar.length > 0)
        {
          System.arraycopy(arrayOfChar, 0, localObject2, j, arrayOfChar.length);
          paramInt = j + arrayOfChar.length;
        }
        i = paramInt;
        paramInt = m;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      k = a(paramString, m, n);
      j = paramInt;
      paramInt = i;
      i = j;
      break;
      j = 1;
      break label73;
      k = n - i;
      j = paramInt;
      localObject2 = localObject1;
      if (k > 0)
      {
        j = k + paramInt;
        localObject2 = localObject1;
        if (localObject1.length < j) {
          localObject2 = a((char[])localObject1, paramInt, j);
        }
        paramString.getChars(i, n, (char[])localObject2, paramInt);
      }
      return new String((char[])localObject2, 0, j);
      label291:
      j = paramInt;
      paramInt = i;
      i = j;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */