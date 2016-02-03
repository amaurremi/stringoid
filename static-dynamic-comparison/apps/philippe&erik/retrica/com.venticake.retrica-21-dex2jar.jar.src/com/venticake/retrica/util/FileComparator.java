package com.venticake.retrica.util;

import java.io.File;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileComparator
  implements Comparator<File>
{
  private Pattern p = Pattern.compile("[0-9]+");
  
  public int compare(File paramFile1, File paramFile2)
  {
    Object localObject = this.p.matcher(paramFile1.getName());
    paramFile1 = this.p.matcher(paramFile2.getName());
    if (((Matcher)localObject).find())
    {
      paramFile2 = ((Matcher)localObject).group(0);
      if (((Matcher)localObject).find(((Matcher)localObject).end())) {
        localObject = ((Matcher)localObject).group(0);
      }
    }
    for (long l1 = Long.valueOf(paramFile2 + (String)localObject).longValue();; l1 = 0L)
    {
      if (paramFile1.find())
      {
        paramFile2 = paramFile1.group(0);
        if (paramFile1.find(paramFile1.end())) {
          paramFile1 = paramFile1.group(0);
        }
      }
      for (long l2 = Long.valueOf(paramFile2 + paramFile1).longValue();; l2 = 0L)
      {
        if ((l1 == 0L) || (l2 == 0L)) {
          return 0;
        }
        if (l1 == l2) {
          return 0;
        }
        if (l1 > l2) {
          return -1;
        }
        return 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/util/FileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */