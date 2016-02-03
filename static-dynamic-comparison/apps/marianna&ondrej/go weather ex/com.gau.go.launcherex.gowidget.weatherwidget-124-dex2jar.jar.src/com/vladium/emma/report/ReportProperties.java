package com.vladium.emma.report;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.util.Files;
import com.vladium.util.IProperties;
import com.vladium.util.IProperties.IMapper;
import com.vladium.util.IntIntMap;
import com.vladium.util.IntVector;
import com.vladium.util.ObjectIntMap;
import com.vladium.util.Property;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class ReportProperties
  implements IAppErrorCodes
{
  private static final ObjectIntMap COLUMNS;
  private static final boolean REMOVE_DUPLICATE_COLUMNS = true;
  public static final IProperties.IMapper REPORT_PROPERTY_MAPPER = new ReportPropertyMapper(null);
  
  static
  {
    ObjectIntMap localObjectIntMap = new ObjectIntMap();
    localObjectIntMap.put("name", 0);
    localObjectIntMap.put("class", 1);
    localObjectIntMap.put("method", 2);
    localObjectIntMap.put("block", 3);
    localObjectIntMap.put("line", 4);
    COLUMNS = localObjectIntMap;
  }
  
  private static String getReportProperty(IProperties paramIProperties, String paramString1, String paramString2, boolean paramBoolean)
  {
    return getReportProperty(paramIProperties, paramString1, paramString2, paramBoolean, null);
  }
  
  private static String getReportProperty(IProperties paramIProperties, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    paramIProperties = paramIProperties.getProperty("report.".concat(paramString1).concat(".").concat(paramString2), paramString3);
    if ((!paramBoolean) && (paramIProperties != null) && (paramIProperties.trim().length() == 0)) {
      return paramString3;
    }
    return paramIProperties;
  }
  
  public static ParsedProperties parseProperties(IProperties paramIProperties, String paramString)
  {
    ParsedProperties localParsedProperties = new ParsedProperties();
    localParsedProperties.setOutEncoding(getReportProperty(paramIProperties, paramString, "out.encoding", false));
    Object localObject1 = getReportProperty(paramIProperties, paramString, "out.dir", true);
    Object localObject2 = getReportProperty(paramIProperties, paramString, "out.file", false);
    int i;
    if (localObject2 != null)
    {
      localObject1 = Files.newFile((String)localObject1, (String)localObject2);
      localObject2 = ((File)localObject1).getParentFile();
      if (localObject2 != null) {
        localParsedProperties.setOutDir((File)localObject2);
      }
      localParsedProperties.setOutFile(new File(((File)localObject1).getName()));
      if (!"count".equals(getReportProperty(paramIProperties, paramString, "units", true, "instr"))) {
        break label345;
      }
      i = 0;
      label113:
      localParsedProperties.setUnitsType(i);
      localParsedProperties.setViewType(1);
      localParsedProperties.setHideClasses(Property.toBoolean(getReportProperty(paramIProperties, paramString, "hideclasses", true, "true")));
      if (localParsedProperties.getViewType() == 0) {
        localParsedProperties.setHideClasses(false);
      }
      localObject1 = getReportProperty(paramIProperties, paramString, "depth", false, "package");
      if (!"all".equals(localObject1)) {
        break label351;
      }
      localParsedProperties.setDepth(AllItem.getTypeMetadata().getTypeID());
      label193:
      if ((localParsedProperties.getHideClasses()) && (localParsedProperties.getViewType() == 1) && (localParsedProperties.getDepth() == 3)) {
        localParsedProperties.setDepth(2);
      }
      localObject2 = new HashSet();
      localObject4 = getReportProperty(paramIProperties, paramString, "columns", false, "class,method,block,line,name");
      localObject1 = new IntVector();
      localObject3 = new int[1];
      localObject4 = new StringTokenizer((String)localObject4, ",");
    }
    for (;;)
    {
      if (!((StringTokenizer)localObject4).hasMoreTokens()) {
        break label513;
      }
      localObject5 = ((StringTokenizer)localObject4).nextToken().trim();
      if (!COLUMNS.get(localObject5, (int[])localObject3))
      {
        throw new EMMARuntimeException("INVALID_COLUMN_NAME", new Object[] { localObject5 });
        if (localObject1 == null) {
          break;
        }
        localParsedProperties.setOutDir(new File((String)localObject1));
        break;
        label345:
        i = 1;
        break label113;
        label351:
        if ("package".equals(localObject1))
        {
          localParsedProperties.setDepth(PackageItem.getTypeMetadata().getTypeID());
          break label193;
        }
        if ("source".equals(localObject1))
        {
          localParsedProperties.setDepth(SrcFileItem.getTypeMetadata().getTypeID());
          break label193;
        }
        if ("class".equals(localObject1))
        {
          localParsedProperties.setDepth(ClassItem.getTypeMetadata().getTypeID());
          break label193;
        }
        if ("method".equals(localObject1))
        {
          localParsedProperties.setDepth(MethodItem.getTypeMetadata().getTypeID());
          break label193;
        }
        throw new EMMARuntimeException("INVALID_PARAMETER_VALUE", new Object[] { "depth", localObject1 });
      }
      if (!((Set)localObject2).contains(localObject5))
      {
        ((Set)localObject2).add(localObject5);
        ((IntVector)localObject1).add(localObject3[0]);
      }
    }
    label513:
    localParsedProperties.setColumnOrder(((IntVector)localObject1).values());
    localObject1 = getReportProperty(paramIProperties, paramString, "sort", false, "+block,+name");
    Object localObject3 = new IntVector();
    Object localObject4 = new int[1];
    Object localObject5 = new StringTokenizer((String)localObject1, ",");
    if (((StringTokenizer)localObject5).hasMoreTokens())
    {
      localObject1 = ((StringTokenizer)localObject5).nextToken().trim();
      switch (((String)localObject1).charAt(0))
      {
      case ',': 
      default: 
        i = 1;
      }
      for (;;)
      {
        if (((Set)localObject2).contains(localObject1))
        {
          COLUMNS.get(localObject1, (int[])localObject4);
          ((IntVector)localObject3).add(localObject4[0]);
          ((IntVector)localObject3).add(i);
        }
        localParsedProperties.setSortOrder(((IntVector)localObject3).values());
        break;
        i = 1;
        localObject1 = ((String)localObject1).substring(1);
        continue;
        i = -1;
        localObject1 = ((String)localObject1).substring(1);
      }
    }
    localObject1 = getReportProperty(paramIProperties, paramString, "metrics", true, "method:70,block:80,line:80,class:100");
    paramIProperties = new IntIntMap();
    paramString = new int[1];
    localObject1 = new StringTokenizer((String)localObject1, ",");
    while (((StringTokenizer)localObject1).hasMoreTokens())
    {
      localObject3 = ((StringTokenizer)localObject1).nextToken().trim();
      i = ((String)localObject3).indexOf(':');
      if (i > 0) {
        try
        {
          double d = Double.parseDouble(((String)localObject3).substring(i + 1));
          if ((d >= 0.0D) && (d <= 101.0D))
          {
            localObject3 = ((String)localObject3).substring(0, i);
            if (((Set)localObject2).contains(localObject3))
            {
              COLUMNS.get(localObject3, paramString);
              paramIProperties.put(paramString[0], (int)Math.round(100.0D * d / 100.0D));
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace(System.out);
        }
      }
    }
    localParsedProperties.setMetrics(paramIProperties);
    localParsedProperties.validate();
    return localParsedProperties;
  }
  
  public static final class ParsedProperties
  {
    private int[] m_columnOrder;
    private int m_depth;
    private boolean m_hideClasses;
    private IntIntMap m_metrics;
    private File m_outDir;
    private String m_outEncoding;
    private File m_outFile;
    private int[] m_sortOrder;
    private int m_unitsType;
    private int m_viewType;
    
    public int[] getColumnOrder()
    {
      return this.m_columnOrder;
    }
    
    public int getDepth()
    {
      return this.m_depth;
    }
    
    public boolean getHideClasses()
    {
      return this.m_hideClasses;
    }
    
    public IntIntMap getMetrics()
    {
      return this.m_metrics;
    }
    
    public File getOutDir()
    {
      return this.m_outDir;
    }
    
    public String getOutEncoding()
    {
      return this.m_outEncoding;
    }
    
    public File getOutFile()
    {
      return this.m_outFile;
    }
    
    public int[] getSortOrder()
    {
      return this.m_sortOrder;
    }
    
    public int getUnitsType()
    {
      return this.m_unitsType;
    }
    
    public int getViewType()
    {
      return this.m_viewType;
    }
    
    public void setColumnOrder(int[] paramArrayOfInt)
    {
      this.m_columnOrder = paramArrayOfInt;
    }
    
    public void setDepth(int paramInt)
    {
      this.m_depth = paramInt;
    }
    
    public void setHideClasses(boolean paramBoolean)
    {
      this.m_hideClasses = paramBoolean;
    }
    
    public void setMetrics(IntIntMap paramIntIntMap)
    {
      this.m_metrics = paramIntIntMap;
    }
    
    public void setOutDir(File paramFile)
    {
      this.m_outDir = paramFile;
    }
    
    public void setOutEncoding(String paramString)
    {
      this.m_outEncoding = paramString;
    }
    
    public void setOutFile(File paramFile)
    {
      this.m_outFile = paramFile;
    }
    
    public void setSortOrder(int[] paramArrayOfInt)
    {
      this.m_sortOrder = paramArrayOfInt;
    }
    
    public void setUnitsType(int paramInt)
    {
      this.m_unitsType = paramInt;
    }
    
    public void setViewType(int paramInt)
    {
      this.m_viewType = paramInt;
    }
    
    void validate()
      throws IllegalArgumentException
    {}
  }
  
  private static final class ReportPropertyMapper
    implements IProperties.IMapper
  {
    public String getMappedKey(String paramString)
    {
      if ((paramString != null) && (paramString.startsWith("report.")))
      {
        int i = paramString.indexOf('.', "report.".length());
        if (i > 0) {
          return "report.".concat(paramString.substring(i + 1));
        }
      }
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/ReportProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */