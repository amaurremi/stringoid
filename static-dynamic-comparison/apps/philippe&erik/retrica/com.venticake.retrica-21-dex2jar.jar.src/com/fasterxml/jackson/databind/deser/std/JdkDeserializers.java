package com.fasterxml.jackson.databind.deser.std;

public class JdkDeserializers
{
  public static StdDeserializer<?>[] all()
  {
    return new StdDeserializer[] { new StringDeserializer(), new JdkDeserializers.UUIDDeserializer(), new JdkDeserializers.URLDeserializer(), new JdkDeserializers.URIDeserializer(), new JdkDeserializers.CurrencyDeserializer(), new JdkDeserializers.PatternDeserializer(), new JdkDeserializers.LocaleDeserializer(), new JdkDeserializers.InetAddressDeserializer(), new JdkDeserializers.CharsetDeserializer(), new JdkDeserializers.AtomicBooleanDeserializer(), new ClassDeserializer(), new JdkDeserializers.StackTraceElementDeserializer() };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */