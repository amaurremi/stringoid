package com.jumptap.adtag.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderUtil
{
  private static final int BUFFER_SIZE = 1024;
  
  public static StringBuilder getFileContent(Context paramContext, String paramString)
    throws JtException
  {
    StringBuilder localStringBuilder = null;
    if (0 == 0)
    {
      localStringBuilder = new StringBuilder();
      byte[] arrayOfByte = new byte['Ѐ'];
      try
      {
        paramContext = paramContext.getResources().getAssets().open(paramString);
        for (;;)
        {
          int i = paramContext.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localStringBuilder.append(new StringBuffer(new String(arrayOfByte, 0, i)));
        }
        paramContext.close();
      }
      catch (IOException paramContext)
      {
        throw new JtException("Cannot load " + paramString + " from asset folder" + paramContext.getMessage());
      }
    }
    return localStringBuilder;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/utils/FileReaderUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */