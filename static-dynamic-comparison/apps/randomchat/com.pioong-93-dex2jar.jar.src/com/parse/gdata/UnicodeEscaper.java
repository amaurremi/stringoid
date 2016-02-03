package com.parse.gdata;

import java.io.IOException;

public abstract class UnicodeEscaper
  implements Escaper
{
  private static final int DEST_PAD = 32;
  private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal()
  {
    protected char[] initialValue()
    {
      return new char['Ѐ'];
    }
  };
  
  protected static final int codePointAt(CharSequence paramCharSequence, int paramInt1, int paramInt2)
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
  
  private static final char[] growBuffer(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  public Appendable escape(final Appendable paramAppendable)
  {
    Preconditions.checkNotNull(paramAppendable);
    new Appendable()
    {
      char[] decodedChars = new char[2];
      int pendingHighSurrogate = -1;
      
      private void outputChars(char[] paramAnonymousArrayOfChar, int paramAnonymousInt)
        throws IOException
      {
        int i = 0;
        for (;;)
        {
          if (i >= paramAnonymousInt) {
            return;
          }
          paramAppendable.append(paramAnonymousArrayOfChar[i]);
          i += 1;
        }
      }
      
      public Appendable append(char paramAnonymousChar)
        throws IOException
      {
        if (this.pendingHighSurrogate != -1)
        {
          if (!Character.isLowSurrogate(paramAnonymousChar)) {
            throw new IllegalArgumentException("Expected low surrogate character but got '" + paramAnonymousChar + "' with value " + paramAnonymousChar);
          }
          arrayOfChar = UnicodeEscaper.this.escape(Character.toCodePoint((char)this.pendingHighSurrogate, paramAnonymousChar));
          if (arrayOfChar != null) {
            outputChars(arrayOfChar, arrayOfChar.length);
          }
          for (;;)
          {
            this.pendingHighSurrogate = -1;
            return this;
            paramAppendable.append((char)this.pendingHighSurrogate);
            paramAppendable.append(paramAnonymousChar);
          }
        }
        if (Character.isHighSurrogate(paramAnonymousChar))
        {
          this.pendingHighSurrogate = paramAnonymousChar;
          return this;
        }
        if (Character.isLowSurrogate(paramAnonymousChar)) {
          throw new IllegalArgumentException("Unexpected low surrogate character '" + paramAnonymousChar + "' with value " + paramAnonymousChar);
        }
        char[] arrayOfChar = UnicodeEscaper.this.escape(paramAnonymousChar);
        if (arrayOfChar != null)
        {
          outputChars(arrayOfChar, arrayOfChar.length);
          return this;
        }
        paramAppendable.append(paramAnonymousChar);
        return this;
      }
      
      public Appendable append(CharSequence paramAnonymousCharSequence)
        throws IOException
      {
        return append(paramAnonymousCharSequence, 0, paramAnonymousCharSequence.length());
      }
      
      public Appendable append(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        int k;
        int j;
        if (paramAnonymousInt1 < paramAnonymousInt2)
        {
          k = paramAnonymousInt1;
          j = paramAnonymousInt1;
          i = k;
          if (this.pendingHighSurrogate != -1)
          {
            char c = paramAnonymousCharSequence.charAt(paramAnonymousInt1);
            if (!Character.isLowSurrogate(c)) {
              throw new IllegalArgumentException("Expected low surrogate character but got " + c);
            }
            arrayOfChar = UnicodeEscaper.this.escape(Character.toCodePoint((char)this.pendingHighSurrogate, c));
            if (arrayOfChar == null) {
              break label157;
            }
            outputChars(arrayOfChar, arrayOfChar.length);
          }
        }
        for (int i = k + 1;; i = k)
        {
          this.pendingHighSurrogate = -1;
          j = paramAnonymousInt1 + 1;
          j = UnicodeEscaper.this.nextEscapeIndex(paramAnonymousCharSequence, j, paramAnonymousInt2);
          if (j > i) {
            paramAppendable.append(paramAnonymousCharSequence, i, j);
          }
          if (j != paramAnonymousInt2) {
            break;
          }
          return this;
          label157:
          paramAppendable.append((char)this.pendingHighSurrogate);
        }
        paramAnonymousInt1 = UnicodeEscaper.codePointAt(paramAnonymousCharSequence, j, paramAnonymousInt2);
        if (paramAnonymousInt1 < 0)
        {
          this.pendingHighSurrogate = (-paramAnonymousInt1);
          return this;
        }
        char[] arrayOfChar = UnicodeEscaper.this.escape(paramAnonymousInt1);
        if (arrayOfChar != null)
        {
          outputChars(arrayOfChar, arrayOfChar.length);
          label223:
          if (!Character.isSupplementaryCodePoint(paramAnonymousInt1)) {
            break label269;
          }
        }
        label269:
        for (paramAnonymousInt1 = 2;; paramAnonymousInt1 = 1)
        {
          j += paramAnonymousInt1;
          i = j;
          break;
          i = Character.toChars(paramAnonymousInt1, this.decodedChars, 0);
          outputChars(this.decodedChars, i);
          break label223;
        }
      }
    };
  }
  
  public String escape(String paramString)
  {
    int i = paramString.length();
    int j = nextEscapeIndex(paramString, 0, i);
    if (j == i) {
      return paramString;
    }
    return escapeSlow(paramString, j);
  }
  
  protected abstract char[] escape(int paramInt);
  
  protected final String escapeSlow(String paramString, int paramInt)
  {
    int n = paramString.length();
    Object localObject1 = (char[])DEST_TL.get();
    int i = 0;
    int m = 0;
    int k = paramInt;
    paramInt = i;
    int j;
    Object localObject2;
    if (k >= n)
    {
      j = n - m;
      localObject2 = localObject1;
      i = paramInt;
      if (j > 0)
      {
        i = paramInt + j;
        localObject2 = localObject1;
        if (localObject1.length < i) {
          localObject2 = growBuffer((char[])localObject1, paramInt, i);
        }
        paramString.getChars(m, n, (char[])localObject2, paramInt);
      }
      return new String((char[])localObject2, 0, i);
    }
    int i1 = codePointAt(paramString, k, n);
    if (i1 < 0) {
      throw new IllegalArgumentException("Trailing high surrogate at end of input");
    }
    char[] arrayOfChar = escape(i1);
    Object localObject3 = localObject1;
    i = paramInt;
    if (arrayOfChar != null)
    {
      i = k - m;
      j = paramInt + i + arrayOfChar.length;
      localObject2 = localObject1;
      if (localObject1.length < j) {
        localObject2 = growBuffer((char[])localObject1, paramInt, n - k + j + 32);
      }
      j = paramInt;
      if (i > 0)
      {
        paramString.getChars(m, k, (char[])localObject2, paramInt);
        j = paramInt + i;
      }
      localObject3 = localObject2;
      i = j;
      if (arrayOfChar.length > 0)
      {
        System.arraycopy(arrayOfChar, 0, localObject2, j, arrayOfChar.length);
        i = j + arrayOfChar.length;
        localObject3 = localObject2;
      }
    }
    if (Character.isSupplementaryCodePoint(i1)) {}
    for (paramInt = 2;; paramInt = 1)
    {
      m = k + paramInt;
      k = nextEscapeIndex(paramString, m, n);
      localObject1 = localObject3;
      paramInt = i;
      break;
    }
  }
  
  protected int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {}
    do
    {
      return paramInt1;
      i = codePointAt(paramCharSequence, paramInt1, paramInt2);
    } while ((i < 0) || (escape(i) != null));
    if (Character.isSupplementaryCodePoint(i)) {}
    for (int i = 2;; i = 1)
    {
      paramInt1 += i;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/gdata/UnicodeEscaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */