package com.vladium.util;

import java.io.File;

public abstract interface IConstants
{
  public static final File[] EMPTY_FILE_ARRAY = new File[0];
  public static final int[] EMPTY_INT_ARRAY = new int[0];
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final String EOL = System.getProperty("line.separator", "\n");
  public static final String INDENT_INCREMENT = "  ";
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/IConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */