package com.google.gson.stream;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader
  implements Closeable
{
  private static final String FALSE = "false";
  private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
  private static final String TRUE = "true";
  private final char[] buffer = new char['Ѐ'];
  private int bufferStartColumn = 1;
  private int bufferStartLine = 1;
  private final Reader in;
  private boolean lenient = false;
  private int limit = 0;
  private String name;
  private int pos = 0;
  private boolean skipping;
  private JsonScope[] stack = new JsonScope[32];
  private int stackSize = 0;
  private final StringPool stringPool = new StringPool();
  private JsonToken token;
  private String value;
  private int valueLength;
  private int valuePos;
  
  static
  {
    com.google.gson.internal.JsonReaderInternalAccess.INSTANCE = new JsonReader.1();
  }
  
  public JsonReader(Reader paramReader)
  {
    push(JsonScope.EMPTY_DOCUMENT);
    this.skipping = false;
    if (paramReader == null) {
      throw new NullPointerException("in == null");
    }
    this.in = paramReader;
  }
  
  private JsonToken advance()
  {
    peek();
    JsonToken localJsonToken = this.token;
    this.token = null;
    this.value = null;
    this.name = null;
    return localJsonToken;
  }
  
  private void checkLenient()
  {
    if (!this.lenient) {
      throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
  }
  
  private void consumeNonExecutePrefix()
  {
    nextNonWhitespace(true);
    this.pos -= 1;
    if ((this.pos + NON_EXECUTE_PREFIX.length > this.limit) && (!fillBuffer(NON_EXECUTE_PREFIX.length))) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= NON_EXECUTE_PREFIX.length) {
        break label80;
      }
      if (this.buffer[(this.pos + i)] != NON_EXECUTE_PREFIX[i]) {
        break;
      }
      i += 1;
    }
    label80:
    this.pos += NON_EXECUTE_PREFIX.length;
  }
  
  private JsonToken decodeLiteral()
  {
    if (this.valuePos == -1) {
      return JsonToken.STRING;
    }
    if ((this.valueLength == 4) && (('n' == this.buffer[this.valuePos]) || ('N' == this.buffer[this.valuePos])) && (('u' == this.buffer[(this.valuePos + 1)]) || ('U' == this.buffer[(this.valuePos + 1)])) && (('l' == this.buffer[(this.valuePos + 2)]) || ('L' == this.buffer[(this.valuePos + 2)])) && (('l' == this.buffer[(this.valuePos + 3)]) || ('L' == this.buffer[(this.valuePos + 3)])))
    {
      this.value = "null";
      return JsonToken.NULL;
    }
    if ((this.valueLength == 4) && (('t' == this.buffer[this.valuePos]) || ('T' == this.buffer[this.valuePos])) && (('r' == this.buffer[(this.valuePos + 1)]) || ('R' == this.buffer[(this.valuePos + 1)])) && (('u' == this.buffer[(this.valuePos + 2)]) || ('U' == this.buffer[(this.valuePos + 2)])) && (('e' == this.buffer[(this.valuePos + 3)]) || ('E' == this.buffer[(this.valuePos + 3)])))
    {
      this.value = "true";
      return JsonToken.BOOLEAN;
    }
    if ((this.valueLength == 5) && (('f' == this.buffer[this.valuePos]) || ('F' == this.buffer[this.valuePos])) && (('a' == this.buffer[(this.valuePos + 1)]) || ('A' == this.buffer[(this.valuePos + 1)])) && (('l' == this.buffer[(this.valuePos + 2)]) || ('L' == this.buffer[(this.valuePos + 2)])) && (('s' == this.buffer[(this.valuePos + 3)]) || ('S' == this.buffer[(this.valuePos + 3)])) && (('e' == this.buffer[(this.valuePos + 4)]) || ('E' == this.buffer[(this.valuePos + 4)])))
    {
      this.value = "false";
      return JsonToken.BOOLEAN;
    }
    this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
    return decodeNumber(this.buffer, this.valuePos, this.valueLength);
  }
  
  private JsonToken decodeNumber(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[paramInt1];
    int j;
    if (i == 45)
    {
      j = paramInt1 + 1;
      i = paramArrayOfChar[j];
    }
    for (;;)
    {
      int m;
      int k;
      if (i == 48)
      {
        i = j + 1;
        j = paramArrayOfChar[i];
        m = j;
        k = i;
        if (j == 46)
        {
          j = i + 1;
          for (i = paramArrayOfChar[j];; i = paramArrayOfChar[j])
          {
            m = i;
            k = j;
            if (i < 48) {
              break;
            }
            m = i;
            k = j;
            if (i > 57) {
              break;
            }
            j += 1;
          }
        }
      }
      else
      {
        if ((i >= 49) && (i <= 57))
        {
          m = j + 1;
          for (k = paramArrayOfChar[m];; k = paramArrayOfChar[m])
          {
            j = k;
            i = m;
            if (k < 48) {
              break;
            }
            j = k;
            i = m;
            if (k > 57) {
              break;
            }
            m += 1;
          }
        }
        return JsonToken.STRING;
      }
      if (m != 101)
      {
        j = k;
        if (m != 69) {}
      }
      else
      {
        k += 1;
        m = paramArrayOfChar[k];
        if (m != 43)
        {
          j = m;
          i = k;
          if (m != 45) {}
        }
        else
        {
          i = k + 1;
          j = paramArrayOfChar[i];
        }
        if ((j >= 48) && (j <= 57))
        {
          i += 1;
          for (k = paramArrayOfChar[i];; k = paramArrayOfChar[i])
          {
            j = i;
            if (k < 48) {
              break;
            }
            j = i;
            if (k > 57) {
              break;
            }
            i += 1;
          }
        }
        return JsonToken.STRING;
      }
      if (j == paramInt1 + paramInt2) {
        return JsonToken.NUMBER;
      }
      return JsonToken.STRING;
      j = paramInt1;
    }
  }
  
  private void expect(JsonToken paramJsonToken)
  {
    peek();
    if (this.token != paramJsonToken) {
      throw new IllegalStateException("Expected " + paramJsonToken + " but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    advance();
  }
  
  private boolean fillBuffer(int paramInt)
  {
    char[] arrayOfChar = this.buffer;
    int k = this.bufferStartLine;
    int i = this.bufferStartColumn;
    int m = this.pos;
    int j = 0;
    if (j < m)
    {
      if (arrayOfChar[j] == '\n')
      {
        k += 1;
        i = 1;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    this.bufferStartLine = k;
    this.bufferStartColumn = i;
    if (this.limit != this.pos)
    {
      this.limit -= this.pos;
      System.arraycopy(arrayOfChar, this.pos, arrayOfChar, 0, this.limit);
    }
    for (;;)
    {
      this.pos = 0;
      do
      {
        i = this.in.read(arrayOfChar, this.limit, arrayOfChar.length - this.limit);
        if (i == -1) {
          break;
        }
        this.limit = (i + this.limit);
        if ((this.bufferStartLine == 1) && (this.bufferStartColumn == 1) && (this.limit > 0) && (arrayOfChar[0] == 65279))
        {
          this.pos += 1;
          this.bufferStartColumn -= 1;
        }
      } while (this.limit < paramInt);
      return true;
      this.limit = 0;
    }
    return false;
  }
  
  private int getColumnNumber()
  {
    int i = this.bufferStartColumn;
    int j = 0;
    if (j < this.pos)
    {
      if (this.buffer[j] == '\n') {
        i = 1;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  private int getLineNumber()
  {
    int j = this.bufferStartLine;
    int i = 0;
    while (i < this.pos)
    {
      int k = j;
      if (this.buffer[i] == '\n') {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private JsonToken nextInArray(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.stack[(this.stackSize - 1)] = JsonScope.NONEMPTY_ARRAY;
    }
    for (;;)
    {
      switch (nextNonWhitespace(true))
      {
      default: 
        this.pos -= 1;
        return nextValue();
        switch (nextNonWhitespace(true))
        {
        case 44: 
        default: 
          throw syntaxError("Unterminated array");
        case 93: 
          this.stackSize -= 1;
          localJsonToken = JsonToken.END_ARRAY;
          this.token = localJsonToken;
          return localJsonToken;
        }
        checkLenient();
      }
    }
    if (paramBoolean)
    {
      this.stackSize -= 1;
      localJsonToken = JsonToken.END_ARRAY;
      this.token = localJsonToken;
      return localJsonToken;
    }
    checkLenient();
    this.pos -= 1;
    this.value = "null";
    JsonToken localJsonToken = JsonToken.NULL;
    this.token = localJsonToken;
    return localJsonToken;
  }
  
  private JsonToken nextInObject(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      switch (nextNonWhitespace(true))
      {
      default: 
        this.pos -= 1;
        i = nextNonWhitespace(true);
        switch (i)
        {
        default: 
          checkLenient();
          this.pos -= 1;
          this.name = nextLiteral(false);
          if (this.name.length() != 0) {
            break label214;
          }
          throw syntaxError("Expected name");
        }
      case 125: 
        this.stackSize -= 1;
        localJsonToken = JsonToken.END_OBJECT;
        this.token = localJsonToken;
        return localJsonToken;
      }
    }
    else
    {
      switch (nextNonWhitespace(true))
      {
      case 44: 
      case 59: 
      default: 
        throw syntaxError("Unterminated object");
      }
      this.stackSize -= 1;
      localJsonToken = JsonToken.END_OBJECT;
      this.token = localJsonToken;
      return localJsonToken;
      checkLenient();
      this.name = nextString((char)i);
    }
    label214:
    this.stack[(this.stackSize - 1)] = JsonScope.DANGLING_NAME;
    JsonToken localJsonToken = JsonToken.NAME;
    this.token = localJsonToken;
    return localJsonToken;
  }
  
  private String nextLiteral(boolean paramBoolean)
  {
    Object localObject3 = null;
    this.valuePos = -1;
    this.valueLength = 0;
    int i = 0;
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      int j;
      if (this.pos + i < this.limit)
      {
        localObject2 = localObject1;
        j = i;
        switch (this.buffer[(this.pos + i)])
        {
        default: 
          i += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          checkLenient();
          j = i;
          localObject2 = localObject1;
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          label205:
          if ((paramBoolean) && (localObject2 == null))
          {
            this.valuePos = this.pos;
            localObject1 = localObject3;
          }
          break;
        }
      }
      else
      {
        for (;;)
        {
          this.valueLength += j;
          this.pos += j;
          return (String)localObject1;
          if (i < this.buffer.length)
          {
            if (fillBuffer(i + 1)) {
              break;
            }
            this.buffer[this.limit] = '\000';
            localObject2 = localObject1;
            j = i;
            break label205;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(this.buffer, this.pos, i);
          this.valueLength += i;
          this.pos = (i + this.pos);
          if (fillBuffer(1)) {
            break label419;
          }
          j = 0;
          break label205;
          if (this.skipping)
          {
            localObject1 = "skipped!";
          }
          else if (localObject2 == null)
          {
            localObject1 = this.stringPool.get(this.buffer, this.pos, j);
          }
          else
          {
            ((StringBuilder)localObject2).append(this.buffer, this.pos, j);
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
        label419:
        i = 0;
        localObject1 = localObject2;
      }
    }
  }
  
  private int nextNonWhitespace(boolean paramBoolean)
  {
    char[] arrayOfChar = this.buffer;
    int i = this.pos;
    int j = this.limit;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i == j)
      {
        this.pos = i;
        if (!fillBuffer(1))
        {
          if (!paramBoolean) {
            break;
          }
          throw new EOFException("End of input at line " + getLineNumber() + " column " + getColumnNumber());
        }
        m = this.pos;
        k = this.limit;
      }
      i = m + 1;
      j = arrayOfChar[m];
      switch (j)
      {
      default: 
        this.pos = i;
        return j;
      case 9: 
      case 10: 
      case 13: 
      case 32: 
        j = k;
        break;
      case 47: 
        this.pos = i;
        if (i == k)
        {
          this.pos -= 1;
          boolean bool = fillBuffer(2);
          this.pos += 1;
          if (!bool) {
            return j;
          }
        }
        checkLenient();
        switch (arrayOfChar[this.pos])
        {
        default: 
          return j;
        case '*': 
          this.pos += 1;
          if (!skipTo("*/")) {
            throw syntaxError("Unterminated comment");
          }
          i = this.pos + 2;
          j = this.limit;
          break;
        case '/': 
          this.pos += 1;
          skipToEndOfLine();
          i = this.pos;
          j = this.limit;
        }
        break;
      case 35: 
        this.pos = i;
        checkLenient();
        skipToEndOfLine();
        i = this.pos;
        j = this.limit;
      }
    }
    return -1;
  }
  
  private String nextString(char paramChar)
  {
    char[] arrayOfChar = this.buffer;
    Object localObject1 = null;
    char c1 = this.pos;
    int i = this.limit;
    char c2 = c1;
    label22:
    char c3;
    Object localObject2;
    if (c2 < i)
    {
      c3 = c2 + '\001';
      c2 = arrayOfChar[c2];
      if (c2 == paramChar)
      {
        this.pos = c3;
        if (this.skipping) {
          return "skipped!";
        }
        if (localObject1 == null) {
          return this.stringPool.get(arrayOfChar, c1, c3 - c1 - 1);
        }
        ((StringBuilder)localObject1).append(arrayOfChar, c1, c3 - c1 - 1);
        return ((StringBuilder)localObject1).toString();
      }
      if (c2 != '\\') {
        break label241;
      }
      this.pos = c3;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c1, c3 - c1 - 1);
      ((StringBuilder)localObject2).append(readEscapeCharacter());
      c2 = this.pos;
      i = this.limit;
      localObject1 = localObject2;
      c1 = c2;
    }
    for (;;)
    {
      break label22;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c1, c2 - c1);
      this.pos = c2;
      localObject1 = localObject2;
      if (fillBuffer(1)) {
        break;
      }
      throw syntaxError("Unterminated string");
      label241:
      c2 = c3;
    }
  }
  
  private JsonToken nextValue()
  {
    int i = nextNonWhitespace(true);
    switch (i)
    {
    default: 
      this.pos -= 1;
      return readLiteral();
    case 123: 
      push(JsonScope.EMPTY_OBJECT);
      localJsonToken = JsonToken.BEGIN_OBJECT;
      this.token = localJsonToken;
      return localJsonToken;
    case 91: 
      push(JsonScope.EMPTY_ARRAY);
      localJsonToken = JsonToken.BEGIN_ARRAY;
      this.token = localJsonToken;
      return localJsonToken;
    case 39: 
      checkLenient();
    }
    this.value = nextString((char)i);
    JsonToken localJsonToken = JsonToken.STRING;
    this.token = localJsonToken;
    return localJsonToken;
  }
  
  private JsonToken objectValue()
  {
    switch (nextNonWhitespace(true))
    {
    case 59: 
    case 60: 
    default: 
      throw syntaxError("Expected ':'");
    case 61: 
      checkLenient();
      if (((this.pos < this.limit) || (fillBuffer(1))) && (this.buffer[this.pos] == '>')) {
        this.pos += 1;
      }
      break;
    }
    this.stack[(this.stackSize - 1)] = JsonScope.NONEMPTY_OBJECT;
    return nextValue();
  }
  
  private void push(JsonScope paramJsonScope)
  {
    if (this.stackSize == this.stack.length)
    {
      arrayOfJsonScope = new JsonScope[this.stackSize * 2];
      System.arraycopy(this.stack, 0, arrayOfJsonScope, 0, this.stackSize);
      this.stack = arrayOfJsonScope;
    }
    JsonScope[] arrayOfJsonScope = this.stack;
    int i = this.stackSize;
    this.stackSize = (i + 1);
    arrayOfJsonScope[i] = paramJsonScope;
  }
  
  private char readEscapeCharacter()
  {
    if ((this.pos == this.limit) && (!fillBuffer(1))) {
      throw syntaxError("Unterminated escape sequence");
    }
    char[] arrayOfChar = this.buffer;
    int i = this.pos;
    this.pos = (i + 1);
    char c = arrayOfChar[i];
    switch (c)
    {
    default: 
      return c;
    case 'u': 
      if ((this.pos + 4 > this.limit) && (!fillBuffer(4))) {
        throw syntaxError("Unterminated escape sequence");
      }
      int j = this.pos;
      c = '\000';
      i = j;
      if (i < j + 4)
      {
        int k = this.buffer[i];
        int m = (char)(c << '\004');
        if ((k >= 48) && (k <= 57)) {
          c = (char)(m + (k - 48));
        }
        for (;;)
        {
          i += 1;
          break;
          if ((k >= 97) && (k <= 102))
          {
            c = (char)(m + (k - 97 + 10));
          }
          else
          {
            if ((k < 65) || (k > 70)) {
              break label260;
            }
            c = (char)(m + (k - 65 + 10));
          }
        }
        throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
      }
      this.pos += 4;
      return c;
    case 't': 
      return '\t';
    case 'b': 
      return '\b';
    case 'n': 
      return '\n';
    case 'r': 
      label260:
      return '\r';
    }
    return '\f';
  }
  
  private JsonToken readLiteral()
  {
    this.value = nextLiteral(true);
    if (this.valueLength == 0) {
      throw syntaxError("Expected literal value");
    }
    this.token = decodeLiteral();
    if (this.token == JsonToken.STRING) {
      checkLenient();
    }
    return this.token;
  }
  
  private boolean skipTo(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.pos + paramString.length() > this.limit)
    {
      bool1 = bool2;
      if (!fillBuffer(paramString.length())) {}
    }
    else
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramString.length()) {
          break label82;
        }
        if (this.buffer[(this.pos + i)] != paramString.charAt(i))
        {
          this.pos += 1;
          break;
        }
        i += 1;
      }
      label82:
      bool1 = true;
    }
    return bool1;
  }
  
  private void skipToEndOfLine()
  {
    int i;
    do
    {
      if ((this.pos >= this.limit) && (!fillBuffer(1))) {
        break;
      }
      char[] arrayOfChar = this.buffer;
      i = this.pos;
      this.pos = (i + 1);
      i = arrayOfChar[i];
    } while ((i != 13) && (i != 10));
  }
  
  private IOException syntaxError(String paramString)
  {
    throw new MalformedJsonException(paramString + " at line " + getLineNumber() + " column " + getColumnNumber());
  }
  
  public void beginArray()
  {
    expect(JsonToken.BEGIN_ARRAY);
  }
  
  public void beginObject()
  {
    expect(JsonToken.BEGIN_OBJECT);
  }
  
  public void close()
  {
    this.value = null;
    this.token = null;
    this.stack[0] = JsonScope.CLOSED;
    this.stackSize = 1;
    this.in.close();
  }
  
  public void endArray()
  {
    expect(JsonToken.END_ARRAY);
  }
  
  public void endObject()
  {
    expect(JsonToken.END_OBJECT);
  }
  
  public boolean hasNext()
  {
    peek();
    return (this.token != JsonToken.END_OBJECT) && (this.token != JsonToken.END_ARRAY);
  }
  
  public final boolean isLenient()
  {
    return this.lenient;
  }
  
  public boolean nextBoolean()
  {
    peek();
    if (this.token != JsonToken.BOOLEAN) {
      throw new IllegalStateException("Expected a boolean but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    if (this.value == "true") {}
    for (boolean bool = true;; bool = false)
    {
      advance();
      return bool;
    }
  }
  
  public double nextDouble()
  {
    peek();
    if ((this.token != JsonToken.STRING) && (this.token != JsonToken.NUMBER)) {
      throw new IllegalStateException("Expected a double but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    double d = Double.parseDouble(this.value);
    if ((d >= 1.0D) && (this.value.startsWith("0"))) {
      throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    if ((!this.lenient) && ((Double.isNaN(d)) || (Double.isInfinite(d)))) {
      throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    advance();
    return d;
  }
  
  public int nextInt()
  {
    peek();
    if ((this.token != JsonToken.STRING) && (this.token != JsonToken.NUMBER)) {
      throw new IllegalStateException("Expected an int but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    int i;
    try
    {
      i = Integer.parseInt(this.value);
      if ((i >= 1L) && (this.value.startsWith("0"))) {
        throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      double d;
      int j;
      do
      {
        d = Double.parseDouble(this.value);
        j = (int)d;
        i = j;
      } while (j == d);
      throw new NumberFormatException("Expected an int but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    advance();
    return i;
  }
  
  public long nextLong()
  {
    peek();
    if ((this.token != JsonToken.STRING) && (this.token != JsonToken.NUMBER)) {
      throw new IllegalStateException("Expected a long but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    long l1;
    try
    {
      l1 = Long.parseLong(this.value);
      if ((l1 >= 1L) && (this.value.startsWith("0"))) {
        throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      double d;
      long l2;
      do
      {
        d = Double.parseDouble(this.value);
        l2 = d;
        l1 = l2;
      } while (l2 == d);
      throw new NumberFormatException("Expected a long but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    advance();
    return l1;
  }
  
  public String nextName()
  {
    peek();
    if (this.token != JsonToken.NAME) {
      throw new IllegalStateException("Expected a name but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    String str = this.name;
    advance();
    return str;
  }
  
  public void nextNull()
  {
    peek();
    if (this.token != JsonToken.NULL) {
      throw new IllegalStateException("Expected null but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    advance();
  }
  
  public String nextString()
  {
    peek();
    if ((this.token != JsonToken.STRING) && (this.token != JsonToken.NUMBER)) {
      throw new IllegalStateException("Expected a string but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    String str = this.value;
    advance();
    return str;
  }
  
  public JsonToken peek()
  {
    Object localObject;
    if (this.token != null) {
      localObject = this.token;
    }
    do
    {
      JsonToken localJsonToken;
      do
      {
        do
        {
          return (JsonToken)localObject;
          switch (JsonReader.2.$SwitchMap$com$google$gson$stream$JsonScope[this.stack[(this.stackSize - 1)].ordinal()])
          {
          default: 
            throw new AssertionError();
          case 1: 
            if (this.lenient) {
              consumeNonExecutePrefix();
            }
            this.stack[(this.stackSize - 1)] = JsonScope.NONEMPTY_DOCUMENT;
            localJsonToken = nextValue();
            localObject = localJsonToken;
          }
        } while (this.lenient);
        localObject = localJsonToken;
      } while (this.token == JsonToken.BEGIN_ARRAY);
      localObject = localJsonToken;
    } while (this.token == JsonToken.BEGIN_OBJECT);
    throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    return nextInArray(true);
    return nextInArray(false);
    return nextInObject(true);
    return objectValue();
    return nextInObject(false);
    if (nextNonWhitespace(false) == -1) {
      return JsonToken.END_DOCUMENT;
    }
    this.pos -= 1;
    if (!this.lenient) {
      throw syntaxError("Expected EOF");
    }
    return nextValue();
    throw new IllegalStateException("JsonReader is closed");
  }
  
  public final void setLenient(boolean paramBoolean)
  {
    this.lenient = paramBoolean;
  }
  
  /* Error */
  public void skipValue()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 96	com/google/gson/stream/JsonReader:skipping	Z
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_0
    //   8: invokespecial 212	com/google/gson/stream/JsonReader:advance	()Lcom/google/gson/stream/JsonToken;
    //   11: astore_3
    //   12: aload_3
    //   13: getstatic 310	com/google/gson/stream/JsonToken:BEGIN_ARRAY	Lcom/google/gson/stream/JsonToken;
    //   16: if_acmpeq +14 -> 30
    //   19: getstatic 304	com/google/gson/stream/JsonToken:BEGIN_OBJECT	Lcom/google/gson/stream/JsonToken;
    //   22: astore 4
    //   24: aload_3
    //   25: aload 4
    //   27: if_acmpne +19 -> 46
    //   30: iload_2
    //   31: iconst_1
    //   32: iadd
    //   33: istore_1
    //   34: iload_1
    //   35: istore_2
    //   36: iload_1
    //   37: ifne -30 -> 7
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 96	com/google/gson/stream/JsonReader:skipping	Z
    //   45: return
    //   46: aload_3
    //   47: getstatic 238	com/google/gson/stream/JsonToken:END_ARRAY	Lcom/google/gson/stream/JsonToken;
    //   50: if_acmpeq +16 -> 66
    //   53: getstatic 253	com/google/gson/stream/JsonToken:END_OBJECT	Lcom/google/gson/stream/JsonToken;
    //   56: astore 4
    //   58: iload_2
    //   59: istore_1
    //   60: aload_3
    //   61: aload 4
    //   63: if_acmpne -29 -> 34
    //   66: iload_2
    //   67: iconst_1
    //   68: isub
    //   69: istore_1
    //   70: goto -36 -> 34
    //   73: astore_3
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 96	com/google/gson/stream/JsonReader:skipping	Z
    //   79: aload_3
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	JsonReader
    //   33	37	1	i	int
    //   6	63	2	j	int
    //   11	50	3	localJsonToken1	JsonToken
    //   73	7	3	localObject	Object
    //   22	40	4	localJsonToken2	JsonToken
    // Exception table:
    //   from	to	target	type
    //   7	24	73	finally
    //   46	58	73	finally
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + " at line " + getLineNumber() + " column " + getColumnNumber();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/gson/stream/JsonReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */