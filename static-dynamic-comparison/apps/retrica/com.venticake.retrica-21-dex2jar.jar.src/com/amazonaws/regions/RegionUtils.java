package com.amazonaws.regions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RegionUtils
{
  private static final Log log = LogFactory.getLog("com.amazonaws.request");
  private static List<Region> regions;
  
  public static Region getRegion(String paramString)
  {
    Iterator localIterator = getRegions().iterator();
    while (localIterator.hasNext())
    {
      Region localRegion = (Region)localIterator.next();
      if (localRegion.getName().equals(paramString)) {
        return localRegion;
      }
    }
    return null;
  }
  
  public static List<Region> getRegions()
  {
    try
    {
      if (regions == null) {
        init();
      }
      List localList = regions;
      return localList;
    }
    finally {}
  }
  
  public static void init()
  {
    try
    {
      String str = System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride");
      if (str == null) {}
    }
    finally
    {
      try
      {
        loadRegionsFromOverrideFile();
        if (regions == null) {
          initSDKRegions();
        }
        if (regions != null) {
          break label59;
        }
        throw new RuntimeException("Failed to initialize the regions.");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        throw new RuntimeException("Couldn't find regions override file specified", localFileNotFoundException);
      }
      localObject = finally;
    }
    label59:
  }
  
  private static void initRegions(InputStream paramInputStream, boolean paramBoolean)
  {
    try
    {
      regions = new RegionMetadataParser().parseRegionMetadata(paramInputStream, paramBoolean);
      return;
    }
    catch (Exception paramInputStream)
    {
      log.warn("Failed to parse regional endpoints", paramInputStream);
    }
  }
  
  private static void initSDKRegions()
  {
    if (log.isDebugEnabled()) {
      log.debug("Initializing the regions from the region file bundled with the SDK...");
    }
    initRegions(RegionUtils.class.getResourceAsStream("regions.xml"), true);
  }
  
  private static void loadRegionsFromOverrideFile()
  {
    String str = System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride");
    if (log.isDebugEnabled()) {
      log.debug("Using local override of the regions file (" + str + ") to initiate regions data...");
    }
    initRegions(new FileInputStream(new File(str)), false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/regions/RegionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */