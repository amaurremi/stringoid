package com.jiubang.playsdk.a;

import android.text.TextUtils;
import com.jiubang.playsdk.a.a.c;
import com.jiubang.playsdk.e.f;
import com.jiubang.playsdk.g.l;
import java.util.Map;

public class n
  implements t
{
  private String b(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramArrayOfByte = l.a(paramArrayOfByte); TextUtils.isEmpty(paramArrayOfByte); paramArrayOfByte = new String(paramArrayOfByte)) {
      throw new y("数据为空");
    }
    return paramArrayOfByte;
  }
  
  public c a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return f.b(b(paramArrayOfByte, paramBoolean));
  }
  
  public Map a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return f.a(b(paramArrayOfByte, paramBoolean), paramLong, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */