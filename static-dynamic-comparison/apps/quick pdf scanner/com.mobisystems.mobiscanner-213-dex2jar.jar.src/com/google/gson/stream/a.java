package com.google.gson.stream;

import com.google.gson.internal.a.f;
import com.google.gson.internal.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a
  implements Closeable
{
  private static final char[] ahl = ")]}'\n".toCharArray();
  private final c ahm = new c();
  private boolean ahn = false;
  private final char[] aho = new char['Ѐ'];
  private int ahp = 0;
  private int ahq = 1;
  private int ahr = 1;
  private JsonScope[] ahs = new JsonScope[32];
  private int aht = 0;
  private JsonToken ahu;
  private int ahv;
  private int ahw;
  private boolean ahx;
  private final Reader in;
  private String name;
  private int pos = 0;
  private String value;
  
  static
  {
    e.afp = new e()
    {
      public void e(a paramAnonymousa)
      {
        if ((paramAnonymousa instanceof f))
        {
          ((f)paramAnonymousa).zQ();
          return;
        }
        paramAnonymousa.zN();
        if (a.C(paramAnonymousa) != JsonToken.ahM) {
          throw new IllegalStateException("Expected a name but was " + paramAnonymousa.zN() + " " + " at line " + a.D(paramAnonymousa) + " column " + a.E(paramAnonymousa));
        }
        a.a(paramAnonymousa, a.F(paramAnonymousa));
        a.b(paramAnonymousa, null);
        a.a(paramAnonymousa, JsonToken.ahN);
      }
    };
  }
  
  public a(Reader paramReader)
  {
    a(JsonScope.ahE);
    this.ahx = false;
    if (paramReader == null) {
      throw new NullPointerException("in == null");
    }
    this.in = paramReader;
  }
  
  private void Ab()
  {
    aC(true);
    this.pos -= 1;
    if ((this.pos + ahl.length > this.ahp) && (!eQ(ahl.length))) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= ahl.length) {
        break label80;
      }
      if (this.aho[(this.pos + i)] != ahl[i]) {
        break;
      }
      i += 1;
    }
    label80:
    this.pos += ahl.length;
  }
  
  private JsonToken Ac()
  {
    zN();
    JsonToken localJsonToken = this.ahu;
    this.ahu = null;
    this.value = null;
    this.name = null;
    return localJsonToken;
  }
  
  private JsonToken Ad()
  {
    switch (aC(true))
    {
    case 59: 
    case 60: 
    default: 
      throw cO("Expected ':'");
    case 61: 
      Af();
      if (((this.pos < this.ahp) || (eQ(1))) && (this.aho[this.pos] == '>')) {
        this.pos += 1;
      }
      break;
    }
    this.ahs[(this.aht - 1)] = JsonScope.ahD;
    return Ae();
  }
  
  private JsonToken Ae()
  {
    int i = aC(true);
    switch (i)
    {
    default: 
      this.pos -= 1;
      return Ai();
    case 123: 
      a(JsonScope.ahB);
      localJsonToken = JsonToken.ahK;
      this.ahu = localJsonToken;
      return localJsonToken;
    case 91: 
      a(JsonScope.ahz);
      localJsonToken = JsonToken.ahI;
      this.ahu = localJsonToken;
      return localJsonToken;
    case 39: 
      Af();
    }
    this.value = nextString((char)i);
    JsonToken localJsonToken = JsonToken.ahN;
    this.ahu = localJsonToken;
    return localJsonToken;
  }
  
  private void Af()
  {
    if (!this.ahn) {
      throw cO("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
  }
  
  private void Ag()
  {
    int i;
    do
    {
      if ((this.pos >= this.ahp) && (!eQ(1))) {
        break;
      }
      char[] arrayOfChar = this.aho;
      i = this.pos;
      this.pos = (i + 1);
      i = arrayOfChar[i];
    } while ((i != 13) && (i != 10));
  }
  
  private char Ah()
  {
    if ((this.pos == this.ahp) && (!eQ(1))) {
      throw cO("Unterminated escape sequence");
    }
    char[] arrayOfChar = this.aho;
    int i = this.pos;
    this.pos = (i + 1);
    char c = arrayOfChar[i];
    switch (c)
    {
    default: 
      return c;
    case 'u': 
      if ((this.pos + 4 > this.ahp) && (!eQ(4))) {
        throw cO("Unterminated escape sequence");
      }
      int j = this.pos;
      c = '\000';
      i = j;
      if (i < j + 4)
      {
        int k = this.aho[i];
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
              break label259;
            }
            c = (char)(m + (k - 65 + 10));
          }
        }
        throw new NumberFormatException("\\u" + this.ahm.c(this.aho, this.pos, 4));
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
      label259:
      return '\r';
    }
    return '\f';
  }
  
  private JsonToken Ai()
  {
    this.value = aD(true);
    if (this.ahw == 0) {
      throw cO("Expected literal value");
    }
    this.ahu = Aj();
    if (this.ahu == JsonToken.ahN) {
      Af();
    }
    return this.ahu;
  }
  
  private JsonToken Aj()
  {
    if (this.ahv == -1) {
      return JsonToken.ahN;
    }
    if ((this.ahw == 4) && (('n' == this.aho[this.ahv]) || ('N' == this.aho[this.ahv])) && (('u' == this.aho[(this.ahv + 1)]) || ('U' == this.aho[(this.ahv + 1)])) && (('l' == this.aho[(this.ahv + 2)]) || ('L' == this.aho[(this.ahv + 2)])) && (('l' == this.aho[(this.ahv + 3)]) || ('L' == this.aho[(this.ahv + 3)])))
    {
      this.value = "null";
      return JsonToken.ahQ;
    }
    if ((this.ahw == 4) && (('t' == this.aho[this.ahv]) || ('T' == this.aho[this.ahv])) && (('r' == this.aho[(this.ahv + 1)]) || ('R' == this.aho[(this.ahv + 1)])) && (('u' == this.aho[(this.ahv + 2)]) || ('U' == this.aho[(this.ahv + 2)])) && (('e' == this.aho[(this.ahv + 3)]) || ('E' == this.aho[(this.ahv + 3)])))
    {
      this.value = "true";
      return JsonToken.ahP;
    }
    if ((this.ahw == 5) && (('f' == this.aho[this.ahv]) || ('F' == this.aho[this.ahv])) && (('a' == this.aho[(this.ahv + 1)]) || ('A' == this.aho[(this.ahv + 1)])) && (('l' == this.aho[(this.ahv + 2)]) || ('L' == this.aho[(this.ahv + 2)])) && (('s' == this.aho[(this.ahv + 3)]) || ('S' == this.aho[(this.ahv + 3)])) && (('e' == this.aho[(this.ahv + 4)]) || ('E' == this.aho[(this.ahv + 4)])))
    {
      this.value = "false";
      return JsonToken.ahP;
    }
    this.value = this.ahm.c(this.aho, this.ahv, this.ahw);
    return b(this.aho, this.ahv, this.ahw);
  }
  
  private CharSequence Ak()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = Math.min(this.pos, 20);
    localStringBuilder.append(this.aho, this.pos - i, i);
    i = Math.min(this.ahp - this.pos, 20);
    localStringBuilder.append(this.aho, this.pos, i);
    return localStringBuilder;
  }
  
  private void a(JsonScope paramJsonScope)
  {
    if (this.aht == this.ahs.length)
    {
      arrayOfJsonScope = new JsonScope[this.aht * 2];
      System.arraycopy(this.ahs, 0, arrayOfJsonScope, 0, this.aht);
      this.ahs = arrayOfJsonScope;
    }
    JsonScope[] arrayOfJsonScope = this.ahs;
    int i = this.aht;
    this.aht = (i + 1);
    arrayOfJsonScope[i] = paramJsonScope;
  }
  
  private void a(JsonToken paramJsonToken)
  {
    zN();
    if (this.ahu != paramJsonToken) {
      throw new IllegalStateException("Expected " + paramJsonToken + " but was " + zN() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    Ac();
  }
  
  private JsonToken aA(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.ahs[(this.aht - 1)] = JsonScope.ahA;
    }
    for (;;)
    {
      switch (aC(true))
      {
      default: 
        this.pos -= 1;
        return Ae();
        switch (aC(true))
        {
        case 44: 
        default: 
          throw cO("Unterminated array");
        case 93: 
          this.aht -= 1;
          localJsonToken = JsonToken.ahJ;
          this.ahu = localJsonToken;
          return localJsonToken;
        }
        Af();
      }
    }
    if (paramBoolean)
    {
      this.aht -= 1;
      localJsonToken = JsonToken.ahJ;
      this.ahu = localJsonToken;
      return localJsonToken;
    }
    Af();
    this.pos -= 1;
    this.value = "null";
    JsonToken localJsonToken = JsonToken.ahQ;
    this.ahu = localJsonToken;
    return localJsonToken;
  }
  
  private JsonToken aB(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      switch (aC(true))
      {
      default: 
        this.pos -= 1;
        i = aC(true);
        switch (i)
        {
        default: 
          Af();
          this.pos -= 1;
          this.name = aD(false);
          if (this.name.length() != 0) {
            break label215;
          }
          throw cO("Expected name");
        }
      case 125: 
        this.aht -= 1;
        localJsonToken = JsonToken.ahL;
        this.ahu = localJsonToken;
        return localJsonToken;
      }
    }
    else
    {
      switch (aC(true))
      {
      case 44: 
      case 59: 
      default: 
        throw cO("Unterminated object");
      }
      this.aht -= 1;
      localJsonToken = JsonToken.ahL;
      this.ahu = localJsonToken;
      return localJsonToken;
      Af();
      this.name = nextString((char)i);
    }
    label215:
    this.ahs[(this.aht - 1)] = JsonScope.ahC;
    JsonToken localJsonToken = JsonToken.ahM;
    this.ahu = localJsonToken;
    return localJsonToken;
  }
  
  private int aC(boolean paramBoolean)
  {
    char[] arrayOfChar = this.aho;
    int i = this.pos;
    int j = this.ahp;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i == j)
      {
        this.pos = i;
        if (!eQ(1))
        {
          if (!paramBoolean) {
            break;
          }
          throw new EOFException("End of input at line " + getLineNumber() + " column " + getColumnNumber());
        }
        m = this.pos;
        k = this.ahp;
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
        if ((i == k) && (!eQ(1))) {
          return j;
        }
        Af();
        switch (arrayOfChar[this.pos])
        {
        default: 
          return j;
        case '*': 
          this.pos += 1;
          if (!cN("*/")) {
            throw cO("Unterminated comment");
          }
          i = this.pos + 2;
          j = this.ahp;
          break;
        case '/': 
          this.pos += 1;
          Ag();
          i = this.pos;
          j = this.ahp;
        }
        break;
      case 35: 
        this.pos = i;
        Af();
        Ag();
        i = this.pos;
        j = this.ahp;
      }
    }
    return -1;
  }
  
  private String aD(boolean paramBoolean)
  {
    Object localObject3 = null;
    this.ahv = -1;
    this.ahw = 0;
    int i = 0;
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      int j;
      if (this.pos + i < this.ahp)
      {
        localObject2 = localObject1;
        j = i;
        switch (this.aho[(this.pos + i)])
        {
        default: 
          i += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          Af();
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
            this.ahv = this.pos;
            localObject1 = localObject3;
          }
          break;
        }
      }
      else
      {
        for (;;)
        {
          this.ahw += j;
          this.pos += j;
          return (String)localObject1;
          if (i < this.aho.length)
          {
            if (eQ(i + 1)) {
              break;
            }
            this.aho[this.ahp] = '\000';
            localObject2 = localObject1;
            j = i;
            break label205;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(this.aho, this.pos, i);
          this.ahw += i;
          this.pos = (i + this.pos);
          if (eQ(1)) {
            break label419;
          }
          j = 0;
          break label205;
          if (this.ahx)
          {
            localObject1 = "skipped!";
          }
          else if (localObject2 == null)
          {
            localObject1 = this.ahm.c(this.aho, this.pos, j);
          }
          else
          {
            ((StringBuilder)localObject2).append(this.aho, this.pos, j);
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
        label419:
        i = 0;
        localObject1 = localObject2;
      }
    }
  }
  
  private JsonToken b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
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
        return JsonToken.ahN;
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
        return JsonToken.ahN;
      }
      if (j == paramInt1 + paramInt2) {
        return JsonToken.ahO;
      }
      return JsonToken.ahN;
      j = paramInt1;
    }
  }
  
  private boolean cN(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.pos + paramString.length() > this.ahp)
    {
      bool1 = bool2;
      if (!eQ(paramString.length())) {}
    }
    else
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramString.length()) {
          break label82;
        }
        if (this.aho[(this.pos + i)] != paramString.charAt(i))
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
  
  private IOException cO(String paramString)
  {
    throw new MalformedJsonException(paramString + " at line " + getLineNumber() + " column " + getColumnNumber());
  }
  
  private boolean eQ(int paramInt)
  {
    char[] arrayOfChar = this.aho;
    int k = this.ahq;
    int i = this.ahr;
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
    this.ahq = k;
    this.ahr = i;
    if (this.ahp != this.pos)
    {
      this.ahp -= this.pos;
      System.arraycopy(arrayOfChar, this.pos, arrayOfChar, 0, this.ahp);
    }
    for (;;)
    {
      this.pos = 0;
      do
      {
        i = this.in.read(arrayOfChar, this.ahp, arrayOfChar.length - this.ahp);
        if (i == -1) {
          break;
        }
        this.ahp = (i + this.ahp);
        if ((this.ahq == 1) && (this.ahr == 1) && (this.ahp > 0) && (arrayOfChar[0] == 65279))
        {
          this.pos += 1;
          this.ahr -= 1;
        }
      } while (this.ahp < paramInt);
      return true;
      this.ahp = 0;
    }
    return false;
  }
  
  private int getColumnNumber()
  {
    int i = this.ahr;
    int j = 0;
    if (j < this.pos)
    {
      if (this.aho[j] == '\n') {
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
    int j = this.ahq;
    int i = 0;
    while (i < this.pos)
    {
      int k = j;
      if (this.aho[i] == '\n') {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private String nextString(char paramChar)
  {
    char[] arrayOfChar = this.aho;
    Object localObject1 = null;
    char c1 = this.pos;
    int i = this.ahp;
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
        if (this.ahx) {
          return "skipped!";
        }
        if (localObject1 == null) {
          return this.ahm.c(arrayOfChar, c1, c3 - c1 - 1);
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
      ((StringBuilder)localObject2).append(Ah());
      c2 = this.pos;
      i = this.ahp;
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
      if (eQ(1)) {
        break;
      }
      throw cO("Unterminated string");
      label241:
      c2 = c3;
    }
  }
  
  public void beginArray()
  {
    a(JsonToken.ahI);
  }
  
  public void beginObject()
  {
    a(JsonToken.ahK);
  }
  
  public void close()
  {
    this.value = null;
    this.ahu = null;
    this.ahs[0] = JsonScope.ahG;
    this.aht = 1;
    this.in.close();
  }
  
  public void endArray()
  {
    a(JsonToken.ahJ);
  }
  
  public void endObject()
  {
    a(JsonToken.ahL);
  }
  
  public boolean hasNext()
  {
    zN();
    return (this.ahu != JsonToken.ahL) && (this.ahu != JsonToken.ahJ);
  }
  
  public final boolean isLenient()
  {
    return this.ahn;
  }
  
  public boolean nextBoolean()
  {
    zN();
    if (this.ahu != JsonToken.ahP) {
      throw new IllegalStateException("Expected a boolean but was " + this.ahu + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    if (this.value == "true") {}
    for (boolean bool = true;; bool = false)
    {
      Ac();
      return bool;
    }
  }
  
  public double nextDouble()
  {
    zN();
    if ((this.ahu != JsonToken.ahN) && (this.ahu != JsonToken.ahO)) {
      throw new IllegalStateException("Expected a double but was " + this.ahu + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    double d = Double.parseDouble(this.value);
    if ((d >= 1.0D) && (this.value.startsWith("0"))) {
      throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    if ((!this.ahn) && ((Double.isNaN(d)) || (Double.isInfinite(d)))) {
      throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    Ac();
    return d;
  }
  
  public int nextInt()
  {
    zN();
    if ((this.ahu != JsonToken.ahN) && (this.ahu != JsonToken.ahO)) {
      throw new IllegalStateException("Expected an int but was " + this.ahu + " at line " + getLineNumber() + " column " + getColumnNumber());
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
    Ac();
    return i;
  }
  
  public long nextLong()
  {
    zN();
    if ((this.ahu != JsonToken.ahN) && (this.ahu != JsonToken.ahO)) {
      throw new IllegalStateException("Expected a long but was " + this.ahu + " at line " + getLineNumber() + " column " + getColumnNumber());
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
    Ac();
    return l1;
  }
  
  public String nextName()
  {
    zN();
    if (this.ahu != JsonToken.ahM) {
      throw new IllegalStateException("Expected a name but was " + zN() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    String str = this.name;
    Ac();
    return str;
  }
  
  public void nextNull()
  {
    zN();
    if (this.ahu != JsonToken.ahQ) {
      throw new IllegalStateException("Expected null but was " + this.ahu + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    Ac();
  }
  
  public String nextString()
  {
    zN();
    if ((this.ahu != JsonToken.ahN) && (this.ahu != JsonToken.ahO)) {
      throw new IllegalStateException("Expected a string but was " + zN() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
    String str = this.value;
    Ac();
    return str;
  }
  
  public final void setLenient(boolean paramBoolean)
  {
    this.ahn = paramBoolean;
  }
  
  /* Error */
  public void skipValue()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 92	com/google/gson/stream/a:ahx	Z
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_0
    //   8: invokespecial 270	com/google/gson/stream/a:Ac	()Lcom/google/gson/stream/JsonToken;
    //   11: astore_3
    //   12: aload_3
    //   13: getstatic 154	com/google/gson/stream/JsonToken:ahI	Lcom/google/gson/stream/JsonToken;
    //   16: if_acmpeq +14 -> 30
    //   19: getstatic 148	com/google/gson/stream/JsonToken:ahK	Lcom/google/gson/stream/JsonToken;
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
    //   42: putfield 92	com/google/gson/stream/a:ahx	Z
    //   45: return
    //   46: aload_3
    //   47: getstatic 280	com/google/gson/stream/JsonToken:ahJ	Lcom/google/gson/stream/JsonToken;
    //   50: if_acmpeq +16 -> 66
    //   53: getstatic 289	com/google/gson/stream/JsonToken:ahL	Lcom/google/gson/stream/JsonToken;
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
    //   76: putfield 92	com/google/gson/stream/a:ahx	Z
    //   79: aload_3
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	a
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
    return getClass().getSimpleName() + " near " + Ak();
  }
  
  public JsonToken zN()
  {
    Object localObject;
    if (this.ahu != null) {
      localObject = this.ahu;
    }
    do
    {
      JsonToken localJsonToken;
      do
      {
        do
        {
          return (JsonToken)localObject;
          switch (2.ahy[this.ahs[(this.aht - 1)].ordinal()])
          {
          default: 
            throw new AssertionError();
          case 1: 
            if (this.ahn) {
              Ab();
            }
            this.ahs[(this.aht - 1)] = JsonScope.ahF;
            localJsonToken = Ae();
            localObject = localJsonToken;
          }
        } while (this.ahn);
        localObject = localJsonToken;
      } while (this.ahu == JsonToken.ahI);
      localObject = localJsonToken;
    } while (this.ahu == JsonToken.ahK);
    throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.ahu + " at line " + getLineNumber() + " column " + getColumnNumber());
    return aA(true);
    return aA(false);
    return aB(true);
    return Ad();
    return aB(false);
    if (aC(false) == -1) {
      return JsonToken.ahR;
    }
    this.pos -= 1;
    if (!this.ahn) {
      throw cO("Expected EOF");
    }
    return Ae();
    throw new IllegalStateException("JsonReader is closed");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/stream/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */