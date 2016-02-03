package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

class ProtoExtensionRegistry
{
  private static ExtensionRegistryLite registry;
  
  public static ExtensionRegistryLite getRegistry()
  {
    try
    {
      if (registry == null)
      {
        registry = ExtensionRegistryLite.newInstance();
        Serving.registerAllExtensions(registry);
      }
      ExtensionRegistryLite localExtensionRegistryLite = registry;
      return localExtensionRegistryLite;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/ProtoExtensionRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */