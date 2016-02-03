package org.codehaus.jackson.map.ser.std;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import org.codehaus.jackson.map.util.Provider;

public class StdJdkSerializers
  implements Provider
{
  public Collection provide()
  {
    HashMap localHashMap = new HashMap();
    ToStringSerializer localToStringSerializer = ToStringSerializer.instance;
    localHashMap.put(URL.class, localToStringSerializer);
    localHashMap.put(URI.class, localToStringSerializer);
    localHashMap.put(Currency.class, localToStringSerializer);
    localHashMap.put(UUID.class, localToStringSerializer);
    localHashMap.put(Pattern.class, localToStringSerializer);
    localHashMap.put(Locale.class, localToStringSerializer);
    localHashMap.put(Locale.class, localToStringSerializer);
    localHashMap.put(AtomicReference.class, StdJdkSerializers.AtomicReferenceSerializer.class);
    localHashMap.put(AtomicBoolean.class, StdJdkSerializers.AtomicBooleanSerializer.class);
    localHashMap.put(AtomicInteger.class, StdJdkSerializers.AtomicIntegerSerializer.class);
    localHashMap.put(AtomicLong.class, StdJdkSerializers.AtomicLongSerializer.class);
    localHashMap.put(File.class, StdJdkSerializers.FileSerializer.class);
    localHashMap.put(Class.class, StdJdkSerializers.ClassSerializer.class);
    localHashMap.put(Void.TYPE, NullSerializer.class);
    return localHashMap.entrySet();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdJdkSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */