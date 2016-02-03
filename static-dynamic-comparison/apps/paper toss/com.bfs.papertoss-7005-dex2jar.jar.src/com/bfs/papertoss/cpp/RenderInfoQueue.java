package com.bfs.papertoss.cpp;

import android.util.Log;

public class RenderInfoQueue
{
  private Level.RenderInfo m_first = null;
  private int m_size = 0;
  
  private void insert(Level.RenderInfo paramRenderInfo)
  {
    for (Level.RenderInfo localRenderInfo = this.m_first; localRenderInfo != null; localRenderInfo = localRenderInfo.next)
    {
      if (localRenderInfo.next == null)
      {
        localRenderInfo.next = paramRenderInfo;
        return;
      }
      if ((localRenderInfo.priority >= paramRenderInfo.priority) && (localRenderInfo.next.priority <= paramRenderInfo.priority))
      {
        paramRenderInfo.next = localRenderInfo.next;
        localRenderInfo.next = paramRenderInfo;
        return;
      }
    }
    Log.d("BFS", "Something weird happend inserting");
  }
  
  public void add(Level.RenderInfo paramRenderInfo)
  {
    this.m_size += 1;
    if (this.m_first == null)
    {
      this.m_first = paramRenderInfo;
      return;
    }
    if (paramRenderInfo.priority > this.m_first.priority)
    {
      paramRenderInfo.next = this.m_first;
      this.m_first = paramRenderInfo;
      return;
    }
    insert(paramRenderInfo);
  }
  
  public Level.RenderInfo poll()
  {
    this.m_size -= 1;
    Level.RenderInfo localRenderInfo = this.m_first;
    this.m_first = this.m_first.next;
    return localRenderInfo;
  }
  
  public int size()
  {
    return this.m_size;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/cpp/RenderInfoQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */