package org.jsoup.parser;

import java.util.Locale;
import org.jsoup.helper.Validate;

class CharacterReader
{
  static final char EOF = '￿';
  private final char[] input;
  private final int length;
  private int mark = 0;
  private int pos = 0;
  
  CharacterReader(String paramString)
  {
    Validate.notNull(paramString);
    this.input = paramString.toCharArray();
    this.length = this.input.length;
  }
  
  void advance()
  {
    this.pos += 1;
  }
  
  char consume()
  {
    if (isEmpty()) {}
    int j;
    for (int i = 65535;; j = this.input[this.pos])
    {
      this.pos += 1;
      return i;
    }
  }
  
  String consumeAsString()
  {
    char[] arrayOfChar = this.input;
    int i = this.pos;
    this.pos = (i + 1);
    return new String(arrayOfChar, i, 1);
  }
  
  String consumeDigitSequence()
  {
    int i = this.pos;
    while (this.pos < this.length)
    {
      int j = this.input[this.pos];
      if ((j < 48) || (j > 57)) {
        break;
      }
      this.pos += 1;
    }
    return new String(this.input, i, this.pos - i);
  }
  
  String consumeHexSequence()
  {
    int i = this.pos;
    while (this.pos < this.length)
    {
      int j = this.input[this.pos];
      if (((j < 48) || (j > 57)) && ((j < 65) || (j > 70)) && ((j < 97) || (j > 102))) {
        break;
      }
      this.pos += 1;
    }
    return new String(this.input, i, this.pos - i);
  }
  
  String consumeLetterSequence()
  {
    int i = this.pos;
    while (this.pos < this.length)
    {
      int j = this.input[this.pos];
      if (((j < 65) || (j > 90)) && ((j < 97) || (j > 122))) {
        break;
      }
      this.pos += 1;
    }
    return new String(this.input, i, this.pos - i);
  }
  
  String consumeLetterThenDigitSequence()
  {
    int i = this.pos;
    int j;
    while (this.pos < this.length)
    {
      j = this.input[this.pos];
      if (((j < 65) || (j > 90)) && ((j < 97) || (j > 122))) {
        break;
      }
      this.pos += 1;
    }
    while (!isEmpty())
    {
      j = this.input[this.pos];
      if ((j < 48) || (j > 57)) {
        break;
      }
      this.pos += 1;
    }
    return new String(this.input, i, this.pos - i);
  }
  
  String consumeTo(char paramChar)
  {
    int i = nextIndexOf(paramChar);
    if (i != -1)
    {
      String str = new String(this.input, this.pos, i);
      this.pos = (i + this.pos);
      return str;
    }
    return consumeToEnd();
  }
  
  String consumeTo(String paramString)
  {
    int i = nextIndexOf(paramString);
    if (i != -1)
    {
      paramString = new String(this.input, this.pos, i);
      this.pos = (i + this.pos);
      return paramString;
    }
    return consumeToEnd();
  }
  
  String consumeToAny(char... paramVarArgs)
  {
    int j = this.pos;
    for (;;)
    {
      int i;
      if (this.pos < this.length) {
        i = 0;
      }
      while (i < paramVarArgs.length)
      {
        if (this.input[this.pos] == paramVarArgs[i])
        {
          if (this.pos <= j) {
            break label86;
          }
          return new String(this.input, j, this.pos - j);
        }
        i += 1;
      }
      this.pos += 1;
    }
    label86:
    return "";
  }
  
  String consumeToEnd()
  {
    String str = new String(this.input, this.pos, this.length - this.pos);
    this.pos = this.length;
    return str;
  }
  
  boolean containsIgnoreCase(String paramString)
  {
    String str = paramString.toLowerCase(Locale.ENGLISH);
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    return (nextIndexOf(str) > -1) || (nextIndexOf(paramString) > -1);
  }
  
  char current()
  {
    if (isEmpty()) {
      return 65535;
    }
    return this.input[this.pos];
  }
  
  boolean isEmpty()
  {
    return this.pos >= this.length;
  }
  
  void mark()
  {
    this.mark = this.pos;
  }
  
  boolean matchConsume(String paramString)
  {
    if (matches(paramString))
    {
      this.pos += paramString.length();
      return true;
    }
    return false;
  }
  
  boolean matchConsumeIgnoreCase(String paramString)
  {
    if (matchesIgnoreCase(paramString))
    {
      this.pos += paramString.length();
      return true;
    }
    return false;
  }
  
  boolean matches(char paramChar)
  {
    return (!isEmpty()) && (this.input[this.pos] == paramChar);
  }
  
  boolean matches(String paramString)
  {
    int j = paramString.length();
    if (j > this.length - this.pos) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label53;
      }
      if (paramString.charAt(i) != this.input[(this.pos + i)]) {
        break;
      }
      i += 1;
    }
    label53:
    return true;
  }
  
  boolean matchesAny(char... paramVarArgs)
  {
    if (isEmpty()) {}
    for (;;)
    {
      return false;
      int j = this.input[this.pos];
      int k = paramVarArgs.length;
      int i = 0;
      while (i < k)
      {
        if (paramVarArgs[i] == j) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  boolean matchesDigit()
  {
    if (isEmpty()) {}
    int i;
    do
    {
      return false;
      i = this.input[this.pos];
    } while ((i < 48) || (i > 57));
    return true;
  }
  
  boolean matchesIgnoreCase(String paramString)
  {
    int j = paramString.length();
    if (j > this.length - this.pos) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label59;
      }
      if (Character.toUpperCase(paramString.charAt(i)) != Character.toUpperCase(this.input[(this.pos + i)])) {
        break;
      }
      i += 1;
    }
    label59:
    return true;
  }
  
  boolean matchesLetter()
  {
    if (isEmpty()) {}
    int i;
    do
    {
      return false;
      i = this.input[this.pos];
    } while (((i < 65) || (i > 90)) && ((i < 97) || (i > 122)));
    return true;
  }
  
  int nextIndexOf(char paramChar)
  {
    int i = this.pos;
    while (i < this.length)
    {
      if (paramChar == this.input[i]) {
        return i - this.pos;
      }
      i += 1;
    }
    return -1;
  }
  
  int nextIndexOf(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.charAt(0);
    int j;
    for (int i = this.pos; i < this.length; i = j + 1)
    {
      j = i;
      if (m != this.input[i])
      {
        j = i;
        do
        {
          i = j + 1;
          j = i;
          if (i >= this.length) {
            break;
          }
          j = i;
        } while (m != this.input[i]);
        j = i;
      }
      if (j < this.length)
      {
        int k = j + 1;
        int n = paramCharSequence.length() + k - 1;
        i = 1;
        while ((k < n) && (paramCharSequence.charAt(i) == this.input[k]))
        {
          k += 1;
          i += 1;
        }
        if (k == n) {
          return j - this.pos;
        }
      }
    }
    return -1;
  }
  
  int pos()
  {
    return this.pos;
  }
  
  void rewindToMark()
  {
    this.pos = this.mark;
  }
  
  public String toString()
  {
    return new String(this.input, this.pos, this.length - this.pos);
  }
  
  void unconsume()
  {
    this.pos -= 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/parser/CharacterReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */