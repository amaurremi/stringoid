package com.google.android.gms.internal;

import java.io.IOException;

public class lz$a
  extends IOException
{
  lz$a(int paramInt1, int paramInt2)
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + paramInt1 + " limit " + paramInt2 + ").");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lz$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */