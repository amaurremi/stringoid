package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.f;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

public final class n
{
  public static final m<Character> agA = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Character paramAnonymousCharacter)
    {
      if (paramAnonymousCharacter == null) {}
      for (paramAnonymousCharacter = null;; paramAnonymousCharacter = String.valueOf(paramAnonymousCharacter))
      {
        paramAnonymousb.cM(paramAnonymousCharacter);
        return;
      }
    }
    
    public Character n(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      paramAnonymousa = paramAnonymousa.nextString();
      if (paramAnonymousa.length() != 1) {
        throw new JsonSyntaxException("Expecting character, got: " + paramAnonymousa);
      }
      return Character.valueOf(paramAnonymousa.charAt(0));
    }
  };
  public static final com.google.gson.n agB = a(Character.TYPE, Character.class, agA);
  public static final m<String> agC = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, String paramAnonymousString)
    {
      paramAnonymousb.cM(paramAnonymousString);
    }
    
    public String o(com.google.gson.stream.a paramAnonymousa)
    {
      JsonToken localJsonToken = paramAnonymousa.zN();
      if (localJsonToken == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      if (localJsonToken == JsonToken.ahP) {
        return Boolean.toString(paramAnonymousa.nextBoolean());
      }
      return paramAnonymousa.nextString();
    }
  };
  public static final com.google.gson.n agD = a(String.class, agC);
  public static final m<StringBuilder> agE = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, StringBuilder paramAnonymousStringBuilder)
    {
      if (paramAnonymousStringBuilder == null) {}
      for (paramAnonymousStringBuilder = null;; paramAnonymousStringBuilder = paramAnonymousStringBuilder.toString())
      {
        paramAnonymousb.cM(paramAnonymousStringBuilder);
        return;
      }
    }
    
    public StringBuilder p(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      return new StringBuilder(paramAnonymousa.nextString());
    }
  };
  public static final com.google.gson.n agF = a(StringBuilder.class, agE);
  public static final m<StringBuffer> agG = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, StringBuffer paramAnonymousStringBuffer)
    {
      if (paramAnonymousStringBuffer == null) {}
      for (paramAnonymousStringBuffer = null;; paramAnonymousStringBuffer = paramAnonymousStringBuffer.toString())
      {
        paramAnonymousb.cM(paramAnonymousStringBuffer);
        return;
      }
    }
    
    public StringBuffer q(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      return new StringBuffer(paramAnonymousa.nextString());
    }
  };
  public static final com.google.gson.n agH = a(StringBuffer.class, agG);
  public static final m<URL> agI = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, URL paramAnonymousURL)
    {
      if (paramAnonymousURL == null) {}
      for (paramAnonymousURL = null;; paramAnonymousURL = paramAnonymousURL.toExternalForm())
      {
        paramAnonymousb.cM(paramAnonymousURL);
        return;
      }
    }
    
    public URL r(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ) {
        paramAnonymousa.nextNull();
      }
      do
      {
        return null;
        paramAnonymousa = paramAnonymousa.nextString();
      } while ("null".equals(paramAnonymousa));
      return new URL(paramAnonymousa);
    }
  };
  public static final com.google.gson.n agJ = a(URL.class, agI);
  public static final m<URI> agK = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, URI paramAnonymousURI)
    {
      if (paramAnonymousURI == null) {}
      for (paramAnonymousURI = null;; paramAnonymousURI = paramAnonymousURI.toASCIIString())
      {
        paramAnonymousb.cM(paramAnonymousURI);
        return;
      }
    }
    
    public URI s(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ) {
        paramAnonymousa.nextNull();
      }
      for (;;)
      {
        return null;
        try
        {
          paramAnonymousa = paramAnonymousa.nextString();
          if ("null".equals(paramAnonymousa)) {
            continue;
          }
          paramAnonymousa = new URI(paramAnonymousa);
          return paramAnonymousa;
        }
        catch (URISyntaxException paramAnonymousa)
        {
          throw new JsonIOException(paramAnonymousa);
        }
      }
    }
  };
  public static final com.google.gson.n agL = a(URI.class, agK);
  public static final m<InetAddress> agM = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, InetAddress paramAnonymousInetAddress)
    {
      if (paramAnonymousInetAddress == null) {}
      for (paramAnonymousInetAddress = null;; paramAnonymousInetAddress = paramAnonymousInetAddress.getHostAddress())
      {
        paramAnonymousb.cM(paramAnonymousInetAddress);
        return;
      }
    }
    
    public InetAddress t(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      return InetAddress.getByName(paramAnonymousa.nextString());
    }
  };
  public static final com.google.gson.n agN = b(InetAddress.class, agM);
  public static final m<UUID> agO = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, UUID paramAnonymousUUID)
    {
      if (paramAnonymousUUID == null) {}
      for (paramAnonymousUUID = null;; paramAnonymousUUID = paramAnonymousUUID.toString())
      {
        paramAnonymousb.cM(paramAnonymousUUID);
        return;
      }
    }
    
    public UUID u(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      return UUID.fromString(paramAnonymousa.nextString());
    }
  };
  public static final com.google.gson.n agP = a(UUID.class, agO);
  public static final com.google.gson.n agQ = new com.google.gson.n()
  {
    public <T> m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.zZ() != Timestamp.class) {
        return null;
      }
      new m()
      {
        public void a(com.google.gson.stream.b paramAnonymous2b, Timestamp paramAnonymous2Timestamp)
        {
          this.agY.a(paramAnonymous2b, paramAnonymous2Timestamp);
        }
        
        public Timestamp w(com.google.gson.stream.a paramAnonymous2a)
        {
          paramAnonymous2a = (Date)this.agY.b(paramAnonymous2a);
          if (paramAnonymous2a != null) {
            return new Timestamp(paramAnonymous2a.getTime());
          }
          return null;
        }
      };
    }
  };
  public static final m<Calendar> agR = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Calendar paramAnonymousCalendar)
    {
      if (paramAnonymousCalendar == null)
      {
        paramAnonymousb.zX();
        return;
      }
      paramAnonymousb.zV();
      paramAnonymousb.cL("year");
      paramAnonymousb.A(paramAnonymousCalendar.get(1));
      paramAnonymousb.cL("month");
      paramAnonymousb.A(paramAnonymousCalendar.get(2));
      paramAnonymousb.cL("dayOfMonth");
      paramAnonymousb.A(paramAnonymousCalendar.get(5));
      paramAnonymousb.cL("hourOfDay");
      paramAnonymousb.A(paramAnonymousCalendar.get(11));
      paramAnonymousb.cL("minute");
      paramAnonymousb.A(paramAnonymousCalendar.get(12));
      paramAnonymousb.cL("second");
      paramAnonymousb.A(paramAnonymousCalendar.get(13));
      paramAnonymousb.zW();
    }
    
    public Calendar x(com.google.gson.stream.a paramAnonymousa)
    {
      int j = 0;
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      paramAnonymousa.beginObject();
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      while (paramAnonymousa.zN() != JsonToken.ahL)
      {
        String str = paramAnonymousa.nextName();
        int i = paramAnonymousa.nextInt();
        if ("year".equals(str)) {
          i2 = i;
        } else if ("month".equals(str)) {
          i1 = i;
        } else if ("dayOfMonth".equals(str)) {
          n = i;
        } else if ("hourOfDay".equals(str)) {
          m = i;
        } else if ("minute".equals(str)) {
          k = i;
        } else if ("second".equals(str)) {
          j = i;
        }
      }
      paramAnonymousa.endObject();
      return new GregorianCalendar(i2, i1, n, m, k, j);
    }
  };
  public static final com.google.gson.n agS = b(Calendar.class, GregorianCalendar.class, agR);
  public static final m<Locale> agT = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Locale paramAnonymousLocale)
    {
      if (paramAnonymousLocale == null) {}
      for (paramAnonymousLocale = null;; paramAnonymousLocale = paramAnonymousLocale.toString())
      {
        paramAnonymousb.cM(paramAnonymousLocale);
        return;
      }
    }
    
    public Locale y(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      Object localObject = new StringTokenizer(paramAnonymousa.nextString(), "_");
      if (((StringTokenizer)localObject).hasMoreElements()) {}
      for (paramAnonymousa = ((StringTokenizer)localObject).nextToken();; paramAnonymousa = null)
      {
        if (((StringTokenizer)localObject).hasMoreElements()) {}
        for (String str = ((StringTokenizer)localObject).nextToken();; str = null)
        {
          if (((StringTokenizer)localObject).hasMoreElements()) {}
          for (localObject = ((StringTokenizer)localObject).nextToken();; localObject = null)
          {
            if ((str == null) && (localObject == null)) {
              return new Locale(paramAnonymousa);
            }
            if (localObject == null) {
              return new Locale(paramAnonymousa, str);
            }
            return new Locale(paramAnonymousa, str, (String)localObject);
          }
        }
      }
    }
  };
  public static final com.google.gson.n agU = a(Locale.class, agT);
  public static final m<h> agV = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, h paramAnonymoush)
    {
      if ((paramAnonymoush == null) || (paramAnonymoush.zx()))
      {
        paramAnonymousb.zX();
        return;
      }
      if (paramAnonymoush.zw())
      {
        paramAnonymoush = paramAnonymoush.zA();
        if (paramAnonymoush.zD())
        {
          paramAnonymousb.a(paramAnonymoush.zo());
          return;
        }
        if (paramAnonymoush.zC())
        {
          paramAnonymousb.az(paramAnonymoush.zt());
          return;
        }
        paramAnonymousb.cM(paramAnonymoush.zp());
        return;
      }
      if (paramAnonymoush.zu())
      {
        paramAnonymousb.zT();
        paramAnonymoush = paramAnonymoush.zz().iterator();
        while (paramAnonymoush.hasNext()) {
          a(paramAnonymousb, (h)paramAnonymoush.next());
        }
        paramAnonymousb.zU();
        return;
      }
      if (paramAnonymoush.zv())
      {
        paramAnonymousb.zV();
        paramAnonymoush = paramAnonymoush.zy().entrySet().iterator();
        while (paramAnonymoush.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramAnonymoush.next();
          paramAnonymousb.cL((String)localEntry.getKey());
          a(paramAnonymousb, (h)localEntry.getValue());
        }
        paramAnonymousb.zW();
        return;
      }
      throw new IllegalArgumentException("Couldn't write " + paramAnonymoush.getClass());
    }
    
    public h z(com.google.gson.stream.a paramAnonymousa)
    {
      switch (n.23.acN[paramAnonymousa.zN().ordinal()])
      {
      default: 
        throw new IllegalArgumentException();
      case 3: 
        return new k(paramAnonymousa.nextString());
      case 1: 
        return new k(new LazilyParsedNumber(paramAnonymousa.nextString()));
      case 2: 
        return new k(Boolean.valueOf(paramAnonymousa.nextBoolean()));
      case 4: 
        paramAnonymousa.nextNull();
        return i.aeN;
      case 5: 
        localObject = new f();
        paramAnonymousa.beginArray();
        while (paramAnonymousa.hasNext()) {
          ((f)localObject).b(z(paramAnonymousa));
        }
        paramAnonymousa.endArray();
        return (h)localObject;
      }
      Object localObject = new j();
      paramAnonymousa.beginObject();
      while (paramAnonymousa.hasNext()) {
        ((j)localObject).a(paramAnonymousa.nextName(), z(paramAnonymousa));
      }
      paramAnonymousa.endObject();
      return (h)localObject;
    }
  };
  public static final com.google.gson.n agW = a(h.class, agV);
  public static final com.google.gson.n agX = zY();
  public static final m<Class> agi = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Class paramAnonymousClass)
    {
      throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + paramAnonymousClass.getName() + ". Forgot to register a type adapter?");
    }
    
    public Class m(com.google.gson.stream.a paramAnonymousa)
    {
      throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
  };
  public static final com.google.gson.n agj = a(Class.class, agi);
  public static final m<BitSet> agk = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, BitSet paramAnonymousBitSet)
    {
      if (paramAnonymousBitSet == null)
      {
        paramAnonymousb.zX();
        return;
      }
      paramAnonymousb.zT();
      int i = 0;
      if (i < paramAnonymousBitSet.length())
      {
        if (paramAnonymousBitSet.get(i)) {}
        for (int j = 1;; j = 0)
        {
          paramAnonymousb.A(j);
          i += 1;
          break;
        }
      }
      paramAnonymousb.zU();
    }
    
    public BitSet v(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      BitSet localBitSet = new BitSet();
      paramAnonymousa.beginArray();
      Object localObject = paramAnonymousa.zN();
      int i = 0;
      if (localObject != JsonToken.ahJ)
      {
        boolean bool;
        switch (n.23.acN[localObject.ordinal()])
        {
        default: 
          throw new JsonSyntaxException("Invalid bitset value type: " + localObject);
        case 1: 
          if (paramAnonymousa.nextInt() != 0) {
            bool = true;
          }
          break;
        }
        for (;;)
        {
          if (bool) {
            localBitSet.set(i);
          }
          i += 1;
          localObject = paramAnonymousa.zN();
          break;
          bool = false;
          continue;
          bool = paramAnonymousa.nextBoolean();
          continue;
          localObject = paramAnonymousa.nextString();
          try
          {
            int j = Integer.parseInt((String)localObject);
            if (j != 0) {
              bool = true;
            } else {
              bool = false;
            }
          }
          catch (NumberFormatException paramAnonymousa)
          {
            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + (String)localObject);
          }
        }
      }
      paramAnonymousa.endArray();
      return localBitSet;
    }
  };
  public static final com.google.gson.n agl = a(BitSet.class, agk);
  public static final m<Boolean> agm = new m()
  {
    public Boolean A(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      if (paramAnonymousa.zN() == JsonToken.ahN) {
        return Boolean.valueOf(Boolean.parseBoolean(paramAnonymousa.nextString()));
      }
      return Boolean.valueOf(paramAnonymousa.nextBoolean());
    }
    
    public void a(com.google.gson.stream.b paramAnonymousb, Boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean == null)
      {
        paramAnonymousb.zX();
        return;
      }
      paramAnonymousb.az(paramAnonymousBoolean.booleanValue());
    }
  };
  public static final m<Boolean> agn = new m()
  {
    public Boolean A(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      return Boolean.valueOf(paramAnonymousa.nextString());
    }
    
    public void a(com.google.gson.stream.b paramAnonymousb, Boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean == null) {}
      for (paramAnonymousBoolean = "null";; paramAnonymousBoolean = paramAnonymousBoolean.toString())
      {
        paramAnonymousb.cM(paramAnonymousBoolean);
        return;
      }
    }
  };
  public static final com.google.gson.n ago = a(Boolean.TYPE, Boolean.class, agm);
  public static final m<Number> agp = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
    {
      paramAnonymousb.a(paramAnonymousNumber);
    }
    
    public Number d(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      try
      {
        byte b = (byte)paramAnonymousa.nextInt();
        return Byte.valueOf(b);
      }
      catch (NumberFormatException paramAnonymousa)
      {
        throw new JsonSyntaxException(paramAnonymousa);
      }
    }
  };
  public static final com.google.gson.n agq = a(Byte.TYPE, Byte.class, agp);
  public static final m<Number> agr = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
    {
      paramAnonymousb.a(paramAnonymousNumber);
    }
    
    public Number d(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      try
      {
        short s = (short)paramAnonymousa.nextInt();
        return Short.valueOf(s);
      }
      catch (NumberFormatException paramAnonymousa)
      {
        throw new JsonSyntaxException(paramAnonymousa);
      }
    }
  };
  public static final com.google.gson.n ags = a(Short.TYPE, Short.class, agr);
  public static final m<Number> agt = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
    {
      paramAnonymousb.a(paramAnonymousNumber);
    }
    
    public Number d(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      try
      {
        int i = paramAnonymousa.nextInt();
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramAnonymousa)
      {
        throw new JsonSyntaxException(paramAnonymousa);
      }
    }
  };
  public static final com.google.gson.n agu = a(Integer.TYPE, Integer.class, agt);
  public static final m<Number> agv = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
    {
      paramAnonymousb.a(paramAnonymousNumber);
    }
    
    public Number d(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      try
      {
        long l = paramAnonymousa.nextLong();
        return Long.valueOf(l);
      }
      catch (NumberFormatException paramAnonymousa)
      {
        throw new JsonSyntaxException(paramAnonymousa);
      }
    }
  };
  public static final m<Number> agw = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
    {
      paramAnonymousb.a(paramAnonymousNumber);
    }
    
    public Number d(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      return Float.valueOf((float)paramAnonymousa.nextDouble());
    }
  };
  public static final m<Number> agx = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
    {
      paramAnonymousb.a(paramAnonymousNumber);
    }
    
    public Number d(com.google.gson.stream.a paramAnonymousa)
    {
      if (paramAnonymousa.zN() == JsonToken.ahQ)
      {
        paramAnonymousa.nextNull();
        return null;
      }
      return Double.valueOf(paramAnonymousa.nextDouble());
    }
  };
  public static final m<Number> agy = new m()
  {
    public void a(com.google.gson.stream.b paramAnonymousb, Number paramAnonymousNumber)
    {
      paramAnonymousb.a(paramAnonymousNumber);
    }
    
    public Number d(com.google.gson.stream.a paramAnonymousa)
    {
      JsonToken localJsonToken = paramAnonymousa.zN();
      switch (n.23.acN[localJsonToken.ordinal()])
      {
      case 2: 
      case 3: 
      default: 
        throw new JsonSyntaxException("Expecting number, got: " + localJsonToken);
      case 4: 
        paramAnonymousa.nextNull();
        return null;
      }
      return new LazilyParsedNumber(paramAnonymousa.nextString());
    }
  };
  public static final com.google.gson.n agz = a(Number.class, agy);
  
  public static <TT> com.google.gson.n a(Class<TT> paramClass, final m<TT> paramm)
  {
    new com.google.gson.n()
    {
      public <T> m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.zZ() == this.aha) {
          return paramm;
        }
        return null;
      }
      
      public String toString()
      {
        return "Factory[type=" + this.aha.getName() + ",adapter=" + paramm + "]";
      }
    };
  }
  
  public static <TT> com.google.gson.n a(Class<TT> paramClass1, final Class<TT> paramClass2, final m<? super TT> paramm)
  {
    new com.google.gson.n()
    {
      public <T> m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
      {
        paramAnonymousd = paramAnonymousa.zZ();
        if ((paramAnonymousd == this.ahc) || (paramAnonymousd == paramClass2)) {
          return paramm;
        }
        return null;
      }
      
      public String toString()
      {
        return "Factory[type=" + paramClass2.getName() + "+" + this.ahc.getName() + ",adapter=" + paramm + "]";
      }
    };
  }
  
  public static <TT> com.google.gson.n b(Class<TT> paramClass, final m<TT> paramm)
  {
    new com.google.gson.n()
    {
      public <T> m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
      {
        if (this.ahg.isAssignableFrom(paramAnonymousa.zZ())) {
          return paramm;
        }
        return null;
      }
      
      public String toString()
      {
        return "Factory[typeHierarchy=" + this.ahg.getName() + ",adapter=" + paramm + "]";
      }
    };
  }
  
  public static <TT> com.google.gson.n b(Class<TT> paramClass, final Class<? extends TT> paramClass1, final m<? super TT> paramm)
  {
    new com.google.gson.n()
    {
      public <T> m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
      {
        paramAnonymousd = paramAnonymousa.zZ();
        if ((paramAnonymousd == this.ahe) || (paramAnonymousd == paramClass1)) {
          return paramm;
        }
        return null;
      }
      
      public String toString()
      {
        return "Factory[type=" + this.ahe.getName() + "+" + paramClass1.getName() + ",adapter=" + paramm + "]";
      }
    };
  }
  
  public static <TT> com.google.gson.n zY()
  {
    new com.google.gson.n()
    {
      public <T> m<T> a(d paramAnonymousd, com.google.gson.b.a<T> paramAnonymousa)
      {
        paramAnonymousa = paramAnonymousa.zZ();
        if ((!Enum.class.isAssignableFrom(paramAnonymousa)) || (paramAnonymousa == Enum.class)) {
          return null;
        }
        paramAnonymousd = paramAnonymousa;
        if (!paramAnonymousa.isEnum()) {
          paramAnonymousd = paramAnonymousa.getSuperclass();
        }
        return new n.a(paramAnonymousd);
      }
    };
  }
  
  private static final class a<T extends Enum<T>>
    extends m<T>
  {
    private final Map<String, T> ahh = new HashMap();
    private final Map<T, String> ahi = new HashMap();
    
    public a(Class<T> paramClass)
    {
      for (;;)
      {
        try
        {
          Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
          int j = arrayOfEnum.length;
          int i = 0;
          if (i < j)
          {
            Enum localEnum = arrayOfEnum[i];
            String str = localEnum.name();
            com.google.gson.a.b localb = (com.google.gson.a.b)paramClass.getField(str).getAnnotation(com.google.gson.a.b.class);
            if (localb != null)
            {
              str = localb.yS();
              this.ahh.put(str, localEnum);
              this.ahi.put(localEnum, str);
              i += 1;
            }
          }
          else
          {
            return;
          }
        }
        catch (NoSuchFieldException paramClass)
        {
          throw new AssertionError();
        }
      }
    }
    
    public T B(com.google.gson.stream.a parama)
    {
      if (parama.zN() == JsonToken.ahQ)
      {
        parama.nextNull();
        return null;
      }
      return (Enum)this.ahh.get(parama.nextString());
    }
    
    public void a(com.google.gson.stream.b paramb, T paramT)
    {
      if (paramT == null) {}
      for (paramT = null;; paramT = (String)this.ahi.get(paramT))
      {
        paramb.cM(paramT);
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */