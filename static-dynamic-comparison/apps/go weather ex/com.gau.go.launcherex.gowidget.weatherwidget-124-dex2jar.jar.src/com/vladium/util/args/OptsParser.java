package com.vladium.util.args;

import com.vladium.util.IConstants;
import com.vladium.util.ResourceLoader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class OptsParser
  implements IOptsParser
{
  private static final int CANONICAL_OPT_PREFIX = 1;
  private static final String[] OPT_PREFIXES = { "--", "-" };
  private static final char[] OPT_VALUE_SEPARATORS = { 58, 61 };
  private static final int STATE_ERROR = 3;
  private static final int STATE_FREE_ARGS = 2;
  private static final int STATE_OPT = 0;
  private static final int STATE_OPT_VALUE = 1;
  private final OptDefMetadata m_metadata;
  private final String m_msgPrefix;
  
  OptsParser(String paramString1, ClassLoader paramClassLoader, String paramString2, String[] paramArrayOfString)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("null input: metadataResourceName");
    }
    this.m_msgPrefix = paramString2;
    paramString2 = null;
    InputStream localInputStream;
    try
    {
      localInputStream = ResourceLoader.getResourceAsStream(paramString1, paramClassLoader);
      if (localInputStream == null)
      {
        paramString2 = localInputStream;
        throw new IllegalArgumentException("resource [" + paramString1 + "] could not be loaded via [" + paramClassLoader + "]");
      }
    }
    finally
    {
      if (paramString2 == null) {}
    }
    try
    {
      paramString2.close();
      throw paramString1;
      paramString2 = localInputStream;
      this.m_metadata = parseOptDefMetadata(new InputStreamReader(localInputStream), paramArrayOfString);
      if (localInputStream != null) {}
      try
      {
        localInputStream.close();
        return;
      }
      catch (IOException paramString1) {}
    }
    catch (IOException paramClassLoader)
    {
      for (;;) {}
    }
  }
  
  OptsParser(String paramString, ClassLoader paramClassLoader, String[] paramArrayOfString)
  {
    this(paramString, paramClassLoader, null, paramArrayOfString);
  }
  
  private String formatMessage(String paramString)
  {
    if (this.m_msgPrefix == null) {
      return paramString;
    }
    return this.m_msgPrefix.concat(paramString);
  }
  
  private static String getOptCanonicalName(String paramString, OptDef paramOptDef)
  {
    if (paramOptDef.isPattern())
    {
      String str1 = paramOptDef.getCanonicalName();
      paramOptDef = paramOptDef.getNames();
      int i = 0;
      while (i < paramOptDef.length)
      {
        String str2 = paramOptDef[i];
        if (paramString.startsWith(str2)) {
          return str1.concat(paramString.substring(str2.length()));
        }
        i += 1;
      }
      throw new IllegalStateException("failed to detect pattern prefix for [" + paramString + "]");
    }
    return paramOptDef.getCanonicalName();
  }
  
  private static void getOptNameAndValue(String paramString, String[] paramArrayOfString)
  {
    paramArrayOfString[0] = null;
    paramArrayOfString[1] = null;
    int i = 0;
    for (;;)
    {
      if (i < OPT_PREFIXES.length)
      {
        if ((!paramString.startsWith(OPT_PREFIXES[i])) || (paramString.length() <= OPT_PREFIXES[i].length())) {
          break label165;
        }
        paramString = paramString.substring(OPT_PREFIXES[i].length());
        int m = 0;
        int j = Integer.MAX_VALUE;
        i = 0;
        while (i < OPT_VALUE_SEPARATORS.length)
        {
          int i1 = paramString.indexOf(OPT_VALUE_SEPARATORS[i]);
          int n = m;
          int k = j;
          if (i1 > 0)
          {
            n = m;
            k = j;
            if (i1 < j)
            {
              n = OPT_VALUE_SEPARATORS[i];
              k = i1;
            }
          }
          i += 1;
          m = n;
          j = k;
        }
        if (m != 0)
        {
          paramArrayOfString[0] = paramString.substring(0, j);
          paramArrayOfString[1] = paramString.substring(j + 1);
        }
      }
      else
      {
        return;
      }
      paramArrayOfString[0] = paramString;
      return;
      label165:
      i += 1;
    }
  }
  
  private static boolean isOpt(String paramString, int paramInt, OptDef paramOptDef)
  {
    boolean bool = true;
    if ((paramOptDef != null) && (paramInt < paramOptDef.getValueCardinality()[1])) {}
    for (;;)
    {
      return false;
      paramInt = 0;
      while (paramInt < OPT_PREFIXES.length)
      {
        if (paramString.startsWith(OPT_PREFIXES[paramInt]))
        {
          if (paramString.length() > OPT_PREFIXES[paramInt].length()) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
        paramInt += 1;
      }
    }
  }
  
  private static OptDefMetadata parseOptDefMetadata(Reader paramReader, String[] paramArrayOfString)
  {
    paramReader = new MetadataParser().parse(paramReader);
    OptDefMetadata localOptDefMetadata = new OptDefMetadata();
    int i = 0;
    while (i < paramReader.length)
    {
      localOptDefMetadata.addOptDef(paramReader[i]);
      i += 1;
    }
    Object localObject;
    if (paramArrayOfString != null)
    {
      localObject = new OptDef(true);
      ((OptDef)localObject).setNames(paramArrayOfString);
      ((OptDef)localObject).setDescription("display usage information");
      ((OptDef)localObject).setValueCardinality(OptDef.C_ZERO);
      ((OptDef)localObject).setRequired(false);
      ((OptDef)localObject).setDetailedOnly(false);
      ((OptDef)localObject).setMergeable(false);
      localOptDefMetadata.addOptDef((OptDef)localObject);
    }
    i = 0;
    while (i < paramReader.length)
    {
      paramArrayOfString = paramReader[i];
      localObject = paramArrayOfString.getRequiresSet();
      int j;
      OptDef localOptDef;
      if (localObject != null)
      {
        j = 0;
        while (j < localObject.length)
        {
          localOptDef = localOptDefMetadata.getOptDef(localObject[j], null);
          if (localOptDef == null) {
            throw new IllegalArgumentException("option [" + paramArrayOfString.getCanonicalName() + "] specifies an unknown option [" + localObject[j] + "] in its 'requires' set");
          }
          if (localOptDef == paramArrayOfString) {
            throw new IllegalArgumentException("option [" + paramArrayOfString.getCanonicalName() + "] specifies itself in its 'requires' set");
          }
          j += 1;
        }
      }
      localObject = paramArrayOfString.getExcludesSet();
      if (localObject != null)
      {
        j = 0;
        while (j < localObject.length)
        {
          localOptDef = localOptDefMetadata.getOptDef(localObject[j], null);
          if (localOptDef == null) {
            throw new IllegalArgumentException("option [" + paramArrayOfString.getCanonicalName() + "] specifies an unknown option [" + localObject[j] + "] in its 'excludes' set");
          }
          if (localOptDef.isRequired()) {
            throw new IllegalArgumentException("option [" + paramArrayOfString.getCanonicalName() + "] specifies a required option [" + localObject[j] + "] in its 'excludes' set");
          }
          if (localOptDef == paramArrayOfString) {
            throw new IllegalArgumentException("option [" + paramArrayOfString.getCanonicalName() + "] specifies itself in its 'excludes' set");
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localOptDefMetadata;
  }
  
  public IOptsParser.IOpts parse(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      try
      {
        throw new IllegalArgumentException("null input: args");
      }
      finally {}
    }
    Opts localOpts = new Opts();
    String[] arrayOfString1 = new String[2];
    String[] arrayOfString2 = new String[1];
    int i = 0;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int k = 0;
    int j = 0;
    Object localObject4;
    while (j < paramArrayOfString.length)
    {
      localObject4 = paramArrayOfString[j];
      if (localObject4 != null) {
        break label1059;
      }
      throw new IllegalArgumentException("null input: args[" + j + "]");
      if (!isOpt((String)localObject4, k, (OptDef)localObject3)) {
        break label1131;
      }
      k = 0;
      getOptNameAndValue((String)localObject4, arrayOfString1);
      localObject4 = arrayOfString1[0];
      localObject3 = this.m_metadata.getOptDef((String)localObject4, arrayOfString2);
      if (localObject3 == null)
      {
        localOpts.addError(formatMessage("unknown option '" + (String)localObject4 + "'"));
        i = 3;
      }
      else
      {
        String str1 = getOptCanonicalName((String)localObject4, (OptDef)localObject3);
        String str2 = arrayOfString2[0];
        localObject2 = localOpts.getOpt(str1);
        if (((OptDef)localObject3).isMergeable())
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label1095;
          }
          localObject1 = new Opt((String)localObject4, str1, str2);
          localOpts.addOpt((Opt)localObject1, (OptDef)localObject3, (String)localObject4);
          break label1095;
        }
        if (localObject2 == null)
        {
          localObject1 = new Opt((String)localObject4, str1, str2);
          localOpts.addOpt((Opt)localObject1, (OptDef)localObject3, (String)localObject4);
          break label1095;
        }
        localOpts.addError(formatMessage("option '" + (String)localObject4 + "' cannot be specified more than once"));
        localObject1 = localObject2;
        break label1095;
        if (localObject1 != null)
        {
          k = 1;
          if (localObject3.getValueCardinality()[1] < 1)
          {
            localOpts.addError(formatMessage("option '" + ((Opt)localObject2).getName() + "' does not accept values: '" + (String)localObject1 + "'"));
            i = 3;
            break label1136;
          }
          j += 1;
          ((Opt)localObject2).addValue((String)localObject1);
          break label1136;
        }
        localObject1 = paramArrayOfString[j];
        localObject4 = ((OptDef)localObject3).getValueCardinality();
        if (isOpt((String)localObject1, k, (OptDef)localObject3))
        {
          if (k >= localObject4[0]) {
            break label1142;
          }
          localOpts.addError(formatMessage("option '" + ((Opt)localObject2).getName() + "' does not accept fewer than " + localObject4[0] + " value(s)"));
          i = 3;
          break label1136;
        }
        if (k >= localObject4[1]) {
          break label1147;
        }
        k += 1;
        j += 1;
        ((Opt)localObject2).addValue((String)localObject1);
        break label1136;
        if (isOpt(paramArrayOfString[j], k, (OptDef)localObject3)) {
          i = 0;
        } else {
          localOpts.setFreeArgs(paramArrayOfString, j);
        }
      }
    }
    if (j == paramArrayOfString.length)
    {
      if (localObject2 == null) {
        break label710;
      }
      paramArrayOfString = ((OptDef)localObject3).getValueCardinality();
      if (k < paramArrayOfString[0]) {
        localOpts.addError(formatMessage("option '" + ((Opt)localObject2).getName() + "' does not accept fewer than " + paramArrayOfString[0] + " value(s)"));
      }
    }
    for (;;)
    {
      paramArrayOfString = localOpts.getOpts();
      if (paramArrayOfString == null) {
        break label1054;
      }
      localObject1 = new HashSet();
      ((Set)localObject1).addAll(this.m_metadata.getRequiredOpts());
      i = 0;
      while (i < paramArrayOfString.length)
      {
        ((Set)localObject1).remove(paramArrayOfString[i].getCanonicalName());
        i += 1;
      }
      label710:
      localOpts.setFreeArgs(paramArrayOfString, j);
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localOpts.addError(formatMessage("missing required option '" + (String)((Iterator)localObject1).next() + "'"));
          continue;
          label795:
          if (i < paramArrayOfString.length)
          {
            localObject1 = paramArrayOfString[i];
            localObject2 = this.m_metadata.getOptDef(((IOptsParser.IOpt)localObject1).getCanonicalName(), null);
            localObject3 = ((OptDef)localObject2).getRequiresSet();
            if (localObject3 != null)
            {
              j = 0;
              label837:
              if (j < localObject3.length)
              {
                if (localOpts.getOpt(localObject3[j]) != null) {
                  break label1157;
                }
                localOpts.addError(formatMessage("option '" + ((IOptsParser.IOpt)localObject1).getName() + "' requires option '" + localObject3[j] + "'"));
                break label1157;
              }
            }
            localObject3 = ((OptDef)localObject2).getExcludesSet();
            if (localObject3 != null) {
              j = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (j < localObject3.length)
      {
        localObject4 = localOpts.getOpt(localObject3[j]);
        if (localObject4 != null) {
          localOpts.addError(formatMessage("option '" + ((IOptsParser.IOpt)localObject1).getName() + "' cannot be used with option '" + ((Opt)localObject4).getName() + "'"));
        }
      }
      else
      {
        if (((OptDef)localObject2).isUsage()) {
          if (!((IOptsParser.IOpt)localObject1).getName().equals(((IOptsParser.IOpt)localObject1).getCanonicalName())) {
            break label1049;
          }
        }
        label1049:
        for (j = 1;; j = 2)
        {
          localOpts.setUsageRequested(j);
          i += 1;
          break;
        }
        label1054:
        return localOpts;
        label1059:
        switch (i)
        {
        }
        break;
        label1095:
        localObject4 = arrayOfString1[1];
        i = j;
        if (localObject4 == null) {
          i = j + 1;
        }
        int m = 1;
        j = i;
        localObject2 = localObject1;
        i = m;
        localObject1 = localObject4;
        break;
        label1131:
        i = 2;
        break;
        for (;;)
        {
          label1136:
          localObject1 = null;
          break;
          label1142:
          i = 0;
          continue;
          label1147:
          i = 2;
        }
        i = 0;
        break label795;
        label1157:
        j += 1;
        break label837;
      }
      j += 1;
    }
  }
  
  public void usage(PrintWriter paramPrintWriter, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        localObject = OPT_PREFIXES[1];
        Iterator localIterator = this.m_metadata.getOptDefs();
        if (localIterator.hasNext())
        {
          OptDef localOptDef = (OptDef)localIterator.next();
          if ((paramInt1 < 2) && (localOptDef.isDetailedOnly())) {
            continue;
          }
          StringBuffer localStringBuffer = new StringBuffer("  ");
          String str1 = localOptDef.getCanonicalName();
          boolean bool = localOptDef.isPattern();
          localStringBuffer.append((String)localObject);
          localStringBuffer.append(str1);
          if (bool) {
            localStringBuffer.append('*');
          }
          String[] arrayOfString = localOptDef.getNames();
          paramInt2 = 0;
          if (paramInt2 < arrayOfString.length)
          {
            String str2 = arrayOfString[paramInt2];
            if (str2.equals(str1)) {
              break label403;
            }
            localStringBuffer.append(", ");
            localStringBuffer.append((String)localObject);
            localStringBuffer.append(str2);
            if (!bool) {
              break label403;
            }
            localStringBuffer.append('*');
            break label403;
          }
          str1 = localOptDef.getValueMnemonic();
          if (str1 != null)
          {
            localStringBuffer.append(' ');
            localStringBuffer.append(str1);
          }
          int i = 16 - localStringBuffer.length();
          if (i >= 2) {
            break label410;
          }
          paramPrintWriter.println(localStringBuffer);
          localStringBuffer.setLength(0);
          paramInt2 = 0;
          if (paramInt2 < 16)
          {
            localStringBuffer.append(' ');
            paramInt2 += 1;
            continue;
            if (paramInt2 < i)
            {
              localStringBuffer.append(' ');
              paramInt2 += 1;
              continue;
            }
          }
          if (localOptDef.isRequired()) {
            localStringBuffer.append("{required} ");
          }
          localStringBuffer.append(localOptDef.getDescription());
          paramPrintWriter.println(localStringBuffer);
          continue;
        }
        if (paramInt1 >= 2) {
          break label400;
        }
      }
      finally {}
      Object localObject = this.m_metadata.getUsageOptDef();
      if ((localObject != null) && (((OptDef)localObject).getNames() != null) && (((OptDef)localObject).getNames().length > 1))
      {
        paramPrintWriter.println();
        paramPrintWriter.println("  {use '" + localObject.getNames()[1] + "' option to see detailed usage help}");
      }
      label400:
      return;
      label403:
      paramInt2 += 1;
      continue;
      label410:
      paramInt2 = 0;
    }
  }
  
  static final class MetadataParser
  {
    private static final OptsParser.OptDef[] EMPTY_OPTDEF_ARRAY = new OptsParser.OptDef[0];
    private static final Map KEYWORDS = new HashMap(17);
    private int m_currentChar;
    private Reader m_in;
    private List m_opts;
    private OptsParser.Token m_token;
    
    static
    {
      KEYWORDS.put(OptsParser.Token.OPTIONAL.getValue(), OptsParser.Token.OPTIONAL);
      KEYWORDS.put(OptsParser.Token.REQUIRED.getValue(), OptsParser.Token.REQUIRED);
      KEYWORDS.put(OptsParser.Token.VALUES.getValue(), OptsParser.Token.VALUES);
      KEYWORDS.put(OptsParser.Token.REQUIRES.getValue(), OptsParser.Token.REQUIRES);
      KEYWORDS.put(OptsParser.Token.EXCLUDES.getValue(), OptsParser.Token.EXCLUDES);
      KEYWORDS.put(OptsParser.Token.MERGEABLE.getValue(), OptsParser.Token.MERGEABLE);
      KEYWORDS.put(OptsParser.Token.DETAILEDONLY.getValue(), OptsParser.Token.DETAILEDONLY);
      KEYWORDS.put(OptsParser.Token.PATTERN.getValue(), OptsParser.Token.PATTERN);
    }
    
    private void consumeWS()
    {
      if (this.m_currentChar == -1) {}
      for (;;)
      {
        return;
        while (Character.isWhitespace((char)this.m_currentChar)) {
          nextChar();
        }
      }
    }
    
    private void nextChar()
    {
      try
      {
        this.m_currentChar = this.m_in.read();
        return;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("I/O error while parsing: " + localIOException);
      }
    }
    
    OptsParser.Token accept()
    {
      OptsParser.Token localToken = this.m_token;
      nextToken();
      return localToken;
    }
    
    OptsParser.Token accept(int paramInt)
    {
      OptsParser.Token localToken = this.m_token;
      if (this.m_token.getID() == paramInt)
      {
        nextToken();
        return localToken;
      }
      throw new IllegalArgumentException("parse error: invalid token [" + this.m_token + "], expected type [" + paramInt + "]");
    }
    
    int[] cardinality()
    {
      OptsParser.Token localToken = accept(9);
      if ("0".equals(localToken.getValue())) {
        return OptsParser.OptDef.C_ZERO;
      }
      if ("1".equals(localToken.getValue())) {
        return OptsParser.OptDef.C_ONE;
      }
      return OptsParser.OptDef.C_ZERO_OR_ONE;
    }
    
    String[] namelist()
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(accept(1).getValue());
      while (this.m_token.getID() == 4)
      {
        accept();
        localArrayList.add(accept(1).getValue());
      }
      String[] arrayOfString = new String[localArrayList.size()];
      localArrayList.toArray(arrayOfString);
      return arrayOfString;
    }
    
    void nextToken()
    {
      consumeWS();
      StringBuffer localStringBuffer;
      switch (this.m_currentChar)
      {
      default: 
        localStringBuffer = new StringBuffer();
      }
      while (Character.isLetter((char)this.m_currentChar))
      {
        localStringBuffer.append((char)this.m_currentChar);
        nextChar();
        continue;
        this.m_token = OptsParser.Token.EOF;
        return;
        nextChar();
        this.m_token = OptsParser.Token.COLON;
        return;
        nextChar();
        this.m_token = OptsParser.Token.SEMICOLON;
        return;
        nextChar();
        this.m_token = OptsParser.Token.COMMA;
        return;
        nextChar();
        this.m_token = OptsParser.Token.LBRACKET;
        return;
        nextChar();
        this.m_token = OptsParser.Token.RBRACKET;
        return;
        nextChar();
        this.m_token = new OptsParser.Token(9, "0");
        return;
        nextChar();
        this.m_token = new OptsParser.Token(9, "1");
        return;
        nextChar();
        this.m_token = new OptsParser.Token(9, "?");
        return;
        localStringBuffer = new StringBuffer();
        nextChar();
        while (this.m_currentChar != 39)
        {
          localStringBuffer.append((char)this.m_currentChar);
          nextChar();
        }
        nextChar();
        this.m_token = new OptsParser.Token(1, localStringBuffer.toString());
        return;
        localStringBuffer = new StringBuffer();
        nextChar();
        while (this.m_currentChar != 34)
        {
          localStringBuffer.append((char)this.m_currentChar);
          nextChar();
        }
        nextChar();
        this.m_token = new OptsParser.Token(11, localStringBuffer.toString());
        return;
      }
      OptsParser.Token localToken = (OptsParser.Token)KEYWORDS.get(localStringBuffer.toString());
      if (localToken == null) {
        throw new IllegalArgumentException("parse error: unrecognized keyword [" + localStringBuffer + "]");
      }
      this.m_token = localToken;
    }
    
    OptsParser.OptDef optdef()
    {
      OptsParser.OptDef localOptDef = new OptsParser.OptDef(false);
      localOptDef.setNames(optnamelist());
      accept(2);
      optmetadata(localOptDef);
      accept(3);
      return localOptDef;
    }
    
    void optmetadata(OptsParser.OptDef paramOptDef)
    {
      switch (this.m_token.getID())
      {
      default: 
        throw new IllegalArgumentException("parse error: invalid token " + this.m_token + ", expected " + OptsParser.Token.REQUIRED + " or " + OptsParser.Token.OPTIONAL);
      case 8: 
        accept();
        paramOptDef.setRequired(true);
      }
      for (;;)
      {
        accept(4);
        if (this.m_token.getID() == 14)
        {
          accept();
          paramOptDef.setMergeable(true);
          accept(4);
        }
        if (this.m_token.getID() == 15)
        {
          accept();
          paramOptDef.setDetailedOnly(true);
          accept(4);
        }
        if (this.m_token.getID() == 16)
        {
          accept();
          paramOptDef.setPattern(true);
          accept(4);
        }
        accept(10);
        accept(2);
        paramOptDef.setValueCardinality(cardinality());
        accept(4);
        if (this.m_token.getID() == 1)
        {
          paramOptDef.setValueMnemonic(this.m_token.getValue());
          accept();
          accept(4);
        }
        if (this.m_token.getID() == 12)
        {
          accept();
          accept(5);
          paramOptDef.setRequiresSet(namelist());
          accept(6);
          accept(4);
        }
        if (this.m_token.getID() == 13)
        {
          accept();
          accept(5);
          paramOptDef.setExcludesSet(namelist());
          accept(6);
          accept(4);
        }
        paramOptDef.setDescription(accept(11).getValue());
        return;
        accept();
        paramOptDef.setRequired(false);
      }
    }
    
    String[] optnamelist()
    {
      return namelist();
    }
    
    OptsParser.OptDef[] parse(Reader paramReader)
    {
      if (paramReader == null) {
        throw new IllegalArgumentException("null input: in");
      }
      this.m_in = paramReader;
      nextChar();
      nextToken();
      while (this.m_token != OptsParser.Token.EOF)
      {
        if (this.m_opts == null) {
          this.m_opts = new ArrayList();
        }
        this.m_opts.add(optdef());
      }
      if ((this.m_opts == null) || (this.m_opts.size() == 0)) {
        paramReader = EMPTY_OPTDEF_ARRAY;
      }
      for (;;)
      {
        this.m_in = null;
        this.m_opts = null;
        return paramReader;
        paramReader = new OptsParser.OptDef[this.m_opts.size()];
        this.m_opts.toArray(paramReader);
      }
    }
  }
  
  static final class Opt
    implements IOptsParser.IOpt
  {
    private final String m_canonicalName;
    private final String m_name;
    private final String m_patternPrefix;
    private ArrayList m_values;
    
    Opt(String paramString1, String paramString2, String paramString3)
    {
      this.m_name = paramString1;
      this.m_canonicalName = paramString2;
      this.m_patternPrefix = paramString3;
    }
    
    void addValue(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: value");
      }
      if (this.m_values == null) {
        this.m_values = new ArrayList();
      }
      this.m_values.add(paramString);
    }
    
    public String getCanonicalName()
    {
      return this.m_canonicalName;
    }
    
    public String getFirstValue()
    {
      if (this.m_values == null) {
        return null;
      }
      return (String)this.m_values.get(0);
    }
    
    public String getName()
    {
      return this.m_name;
    }
    
    public String getPatternPrefix()
    {
      return this.m_patternPrefix;
    }
    
    public int getValueCount()
    {
      if (this.m_values == null) {
        return 0;
      }
      return this.m_values.size();
    }
    
    public String[] getValues()
    {
      if (this.m_values == null) {
        return IConstants.EMPTY_STRING_ARRAY;
      }
      String[] arrayOfString = new String[this.m_values.size()];
      this.m_values.toArray(arrayOfString);
      return arrayOfString;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer(this.m_name);
      if (!this.m_canonicalName.equals(this.m_name)) {
        localStringBuffer.append(" [" + this.m_canonicalName + "]");
      }
      if (this.m_values != null)
      {
        localStringBuffer.append(": ");
        localStringBuffer.append(this.m_values);
      }
      return localStringBuffer.toString();
    }
  }
  
  static final class OptDef
  {
    static final int[] C_ONE;
    static final int[] C_ONE_OR_MORE = { 1, Integer.MAX_VALUE };
    static final int[] C_ZERO = { 0, 0 };
    static final int[] C_ZERO_OR_MORE;
    static final int[] C_ZERO_OR_ONE;
    private String m_description;
    private boolean m_detailedOnly;
    private String[] m_excludesSet;
    private boolean m_mergeable;
    private String[] m_names;
    private boolean m_pattern;
    private boolean m_required;
    private String[] m_requiresSet;
    private final boolean m_usage;
    private int[] m_valueCardinality;
    private String m_valueMnemonic;
    
    static
    {
      C_ONE = new int[] { 1, 1 };
      C_ZERO_OR_ONE = new int[] { 0, 1 };
      C_ZERO_OR_MORE = new int[] { 0, Integer.MAX_VALUE };
    }
    
    OptDef(boolean paramBoolean)
    {
      this.m_usage = paramBoolean;
    }
    
    String getCanonicalName()
    {
      return this.m_names[0];
    }
    
    String getDescription()
    {
      return this.m_description;
    }
    
    String[] getExcludesSet()
    {
      return this.m_excludesSet;
    }
    
    String[] getNames()
    {
      return this.m_names;
    }
    
    String[] getRequiresSet()
    {
      return this.m_requiresSet;
    }
    
    int[] getValueCardinality()
    {
      return this.m_valueCardinality;
    }
    
    String getValueMnemonic()
    {
      return this.m_valueMnemonic;
    }
    
    boolean isDetailedOnly()
    {
      return this.m_detailedOnly;
    }
    
    boolean isMergeable()
    {
      return this.m_mergeable;
    }
    
    boolean isPattern()
    {
      return this.m_pattern;
    }
    
    boolean isRequired()
    {
      return this.m_required;
    }
    
    boolean isUsage()
    {
      return this.m_usage;
    }
    
    void setDescription(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: description");
      }
      this.m_description = paramString;
    }
    
    void setDetailedOnly(boolean paramBoolean)
    {
      this.m_detailedOnly = paramBoolean;
    }
    
    void setExcludesSet(String[] paramArrayOfString)
    {
      if (paramArrayOfString == null) {
        throw new IllegalArgumentException("null input: names");
      }
      if (paramArrayOfString.length > 0) {}
      for (;;)
      {
        this.m_excludesSet = paramArrayOfString;
        return;
        paramArrayOfString = null;
      }
    }
    
    void setMergeable(boolean paramBoolean)
    {
      this.m_mergeable = paramBoolean;
    }
    
    void setNames(String[] paramArrayOfString)
    {
      if (paramArrayOfString == null) {
        throw new IllegalArgumentException("null input: names");
      }
      this.m_names = paramArrayOfString;
    }
    
    void setPattern(boolean paramBoolean)
    {
      this.m_pattern = paramBoolean;
    }
    
    void setRequired(boolean paramBoolean)
    {
      this.m_required = paramBoolean;
    }
    
    void setRequiresSet(String[] paramArrayOfString)
    {
      if (paramArrayOfString == null) {
        throw new IllegalArgumentException("null input: names");
      }
      if (paramArrayOfString.length > 0) {}
      for (;;)
      {
        this.m_requiresSet = paramArrayOfString;
        return;
        paramArrayOfString = null;
      }
    }
    
    void setValueCardinality(int[] paramArrayOfInt)
    {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 2)) {
        throw new IllegalArgumentException("null or invalid input: cardinality");
      }
      this.m_valueCardinality = paramArrayOfInt;
    }
    
    void setValueMnemonic(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: mnemonic");
      }
      this.m_valueMnemonic = paramString;
    }
  }
  
  static final class OptDefMetadata
  {
    final Map m_optdefMap = new HashMap();
    final List m_optdefs = new ArrayList();
    final Map m_patternOptDefMap = new HashMap();
    final Set m_requiredOpts = new HashSet();
    private OptsParser.OptDef m_usageOptDef;
    
    void addOptDef(OptsParser.OptDef paramOptDef)
    {
      if (paramOptDef == null) {
        throw new IllegalArgumentException("null input: optdef");
      }
      Map localMap;
      String[] arrayOfString;
      int i;
      if (paramOptDef.isPattern())
      {
        localMap = this.m_patternOptDefMap;
        arrayOfString = paramOptDef.getNames();
        i = 0;
      }
      for (;;)
      {
        if (i >= arrayOfString.length) {
          break label116;
        }
        if (localMap.containsKey(arrayOfString[i]))
        {
          throw new IllegalArgumentException("duplicate option name [" + arrayOfString[i] + "]");
          localMap = this.m_optdefMap;
          break;
        }
        localMap.put(arrayOfString[i], paramOptDef);
        i += 1;
      }
      label116:
      this.m_optdefs.add(paramOptDef);
      if (paramOptDef.isRequired()) {
        this.m_requiredOpts.add(paramOptDef.getCanonicalName());
      }
      if (paramOptDef.isUsage())
      {
        if (this.m_usageOptDef != null) {
          throw new IllegalArgumentException("usage optdef set already");
        }
        this.m_usageOptDef = paramOptDef;
      }
    }
    
    OptsParser.OptDef getOptDef(String paramString, String[] paramArrayOfString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: name");
      }
      if (paramArrayOfString != null) {
        paramArrayOfString[0] = null;
      }
      OptsParser.OptDef localOptDef = (OptsParser.OptDef)this.m_optdefMap.get(paramString);
      Object localObject = localOptDef;
      if (localOptDef == null)
      {
        Iterator localIterator = this.m_patternOptDefMap.entrySet().iterator();
        String str;
        do
        {
          localObject = localOptDef;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (Map.Entry)localIterator.next();
          str = (String)((Map.Entry)localObject).getKey();
        } while (!paramString.startsWith(str));
        if (paramArrayOfString != null) {
          paramArrayOfString[0] = str;
        }
        localObject = (OptsParser.OptDef)((Map.Entry)localObject).getValue();
      }
      return (OptsParser.OptDef)localObject;
    }
    
    Iterator getOptDefs()
    {
      return this.m_optdefs.iterator();
    }
    
    OptsParser.OptDef getPatternOptDefs(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: pattern");
      }
      return (OptsParser.OptDef)this.m_patternOptDefMap.get(paramString);
    }
    
    Set getRequiredOpts()
    {
      return this.m_requiredOpts;
    }
    
    OptsParser.OptDef getUsageOptDef()
    {
      return this.m_usageOptDef;
    }
  }
  
  static final class Opts
    implements IOptsParser.IOpts
  {
    private static final int DEFAULT_ERROR_WIDTH = 80;
    private static final IOptsParser.IOpt[] EMPTY_OPT_ARRAY = new IOptsParser.IOpt[0];
    private List m_errors;
    private String[] m_freeArgs;
    private final Map m_nameMap = new HashMap();
    private final List m_opts = new ArrayList();
    private final Map m_patternMap = new HashMap();
    private int m_usageRequestLevel;
    
    void addError(String paramString)
    {
      if (paramString != null)
      {
        if (this.m_errors == null) {
          this.m_errors = new ArrayList();
        }
        this.m_errors.add(paramString);
      }
    }
    
    void addOpt(OptsParser.Opt paramOpt, OptsParser.OptDef paramOptDef, String paramString)
    {
      if (paramOpt == null) {
        throw new IllegalArgumentException("null input: opt");
      }
      if (paramOptDef == null) {
        throw new IllegalArgumentException("null input: optdef");
      }
      if (paramString == null) {
        throw new IllegalArgumentException("null input: occuranceName");
      }
      this.m_opts.add(paramOpt);
      String[] arrayOfString = paramOptDef.getNames();
      int i;
      if (paramOpt.getPatternPrefix() != null) {
        i = 1;
      }
      while (i != 0)
      {
        paramString = paramString.substring(paramOpt.getPatternPrefix().length());
        i = 0;
        for (;;)
        {
          if (i < arrayOfString.length)
          {
            this.m_nameMap.put(arrayOfString[i].concat(paramString), paramOpt);
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        paramOptDef = paramOptDef.getCanonicalName();
        paramString = (List)this.m_patternMap.get(paramOptDef);
        paramOptDef = paramString;
        if (paramString == null)
        {
          paramString = new ArrayList();
          i = 0;
          for (;;)
          {
            paramOptDef = paramString;
            if (i >= arrayOfString.length) {
              break;
            }
            this.m_patternMap.put(arrayOfString[i], paramString);
            i += 1;
          }
        }
        paramOptDef.add(paramOpt);
      }
      for (;;)
      {
        return;
        i = 0;
        while (i < arrayOfString.length)
        {
          this.m_nameMap.put(arrayOfString[i], paramOpt);
          i += 1;
        }
      }
    }
    
    public void error(PrintWriter paramPrintWriter, int paramInt)
    {
      if (hasErrors())
      {
        Iterator localIterator = this.m_errors.iterator();
        while (localIterator.hasNext()) {
          paramPrintWriter.println(localIterator.next());
        }
      }
    }
    
    String errorsToString()
    {
      if (!hasErrors()) {
        return "<no errors>";
      }
      CharArrayWriter localCharArrayWriter = new CharArrayWriter();
      PrintWriter localPrintWriter = new PrintWriter(localCharArrayWriter);
      error(localPrintWriter, 80);
      localPrintWriter.flush();
      return localCharArrayWriter.toString();
    }
    
    public String[] getFreeArgs()
    {
      if (hasErrors()) {
        throw new IllegalStateException(errorsToString());
      }
      return this.m_freeArgs;
    }
    
    OptsParser.Opt getOpt(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: occuranceName");
      }
      return (OptsParser.Opt)this.m_nameMap.get(paramString);
    }
    
    public IOptsParser.IOpt[] getOpts()
    {
      if (hasErrors()) {
        return null;
      }
      if (this.m_opts.isEmpty()) {
        return EMPTY_OPT_ARRAY;
      }
      IOptsParser.IOpt[] arrayOfIOpt = new IOptsParser.IOpt[this.m_opts.size()];
      this.m_opts.toArray(arrayOfIOpt);
      return arrayOfIOpt;
    }
    
    public IOptsParser.IOpt[] getOpts(String paramString)
    {
      if (hasErrors()) {
        return null;
      }
      paramString = (List)this.m_patternMap.get(paramString);
      if ((paramString == null) || (paramString.isEmpty())) {
        return EMPTY_OPT_ARRAY;
      }
      IOptsParser.IOpt[] arrayOfIOpt = new IOptsParser.IOpt[paramString.size()];
      paramString.toArray(arrayOfIOpt);
      return arrayOfIOpt;
    }
    
    public boolean hasArg(String paramString)
    {
      if (hasErrors()) {
        throw new IllegalStateException(errorsToString());
      }
      return this.m_nameMap.containsKey(paramString);
    }
    
    boolean hasErrors()
    {
      return (this.m_errors != null) && (!this.m_errors.isEmpty());
    }
    
    void setFreeArgs(String[] paramArrayOfString, int paramInt)
    {
      if (paramArrayOfString == null) {
        throw new IllegalArgumentException("null input: args");
      }
      if ((paramInt < 0) || (paramInt > paramArrayOfString.length)) {
        throw new IllegalArgumentException("invalid start index: " + paramInt);
      }
      this.m_freeArgs = new String[paramArrayOfString.length - paramInt];
      System.arraycopy(paramArrayOfString, paramInt, this.m_freeArgs, 0, this.m_freeArgs.length);
    }
    
    void setUsageRequested(int paramInt)
    {
      this.m_usageRequestLevel = paramInt;
    }
    
    public int usageRequestLevel()
    {
      return this.m_usageRequestLevel;
    }
  }
  
  private static final class Token
  {
    static final int CARD_ID = 9;
    static final Token COLON;
    static final int COLON_ID = 2;
    static final Token COMMA;
    static final int COMMA_ID = 4;
    static final Token DETAILEDONLY = new Token(15, "detailedonly");
    static final int DETAILEDONLY_ID = 15;
    static final Token EOF = new Token(0, "<EOF>");
    static final int EOF_ID = 0;
    static final Token EXCLUDES;
    static final int EXCLUDES_ID = 13;
    static final Token LBRACKET;
    static final int LBRACKET_ID = 5;
    static final Token MERGEABLE;
    static final int MERGEABLE_ID = 14;
    static final Token OPTIONAL;
    static final int OPTIONAL_ID = 7;
    static final Token PATTERN = new Token(16, "pattern");
    static final int PATTERN_ID = 16;
    static final Token RBRACKET;
    static final int RBRACKET_ID = 6;
    static final Token REQUIRED;
    static final int REQUIRED_ID = 8;
    static final Token REQUIRES;
    static final int REQUIRES_ID = 12;
    static final Token SEMICOLON;
    static final int SEMICOLON_ID = 3;
    static final int STRING_ID = 1;
    static final int TEXT_ID = 11;
    static final Token VALUES;
    static final int VALUES_ID = 10;
    private final int m_ID;
    private final String m_value;
    
    static
    {
      COLON = new Token(2, ":");
      SEMICOLON = new Token(3, ";");
      COMMA = new Token(4, ",");
      LBRACKET = new Token(5, "{");
      RBRACKET = new Token(6, "}");
      OPTIONAL = new Token(7, "optional");
      REQUIRED = new Token(8, "required");
      VALUES = new Token(10, "values");
      REQUIRES = new Token(12, "requires");
      EXCLUDES = new Token(13, "excludes");
      MERGEABLE = new Token(14, "mergeable");
    }
    
    Token(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: value");
      }
      this.m_ID = paramInt;
      this.m_value = paramString;
    }
    
    int getID()
    {
      return this.m_ID;
    }
    
    String getValue()
    {
      return this.m_value;
    }
    
    public String toString()
    {
      return this.m_ID + ": [" + this.m_value + "]";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/args/OptsParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */