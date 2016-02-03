package com.bfs.papertoss.cpp;

import com.bfs.papertoss.platform.Util;
import com.bfs.papertoss.vector.v3f;

public class Anim
{
  int m_count;
  float m_duration;
  float m_elapsed;
  v3f[] m_frames;
  
  Anim()
  {
    this.m_frames = null;
    this.m_count = 0;
    this.m_duration = 0.0F;
    this.m_elapsed = 0.0F;
  }
  
  Anim(v3f[] paramArrayOfv3f, int paramInt, float paramFloat)
  {
    this.m_frames = paramArrayOfv3f;
    this.m_count = paramInt;
    this.m_duration = paramFloat;
    this.m_elapsed = 0.0F;
  }
  
  v3f get(float paramFloat)
  {
    this.m_elapsed += paramFloat;
    paramFloat = Math.min(this.m_elapsed / this.m_duration, 1.0F);
    int i = Math.min((int)((this.m_count - 1) * paramFloat), this.m_count - 2);
    int j = i + 1;
    float f = i / (this.m_count - 1);
    paramFloat = (paramFloat - f) / (j / (this.m_count - 1) - f);
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      Util.ASSERT(bool);
      v3f localv3f = this.m_frames[j].minus(this.m_frames[i]).times(paramFloat);
      return this.m_frames[i].plus(localv3f);
    }
  }
  
  boolean isDone()
  {
    return this.m_elapsed >= this.m_duration;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/Anim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */