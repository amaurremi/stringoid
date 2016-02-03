package com.squareup.okio;

final class Segment
{
  static final int SIZE = 2048;
  final byte[] data = new byte['ࠀ'];
  int limit;
  Segment next;
  int pos;
  Segment prev;
  
  public void compact()
  {
    if (this.prev == this) {
      throw new IllegalStateException();
    }
    if (this.prev.limit - this.prev.pos + (this.limit - this.pos) > 2048) {
      return;
    }
    writeTo(this.prev, this.limit - this.pos);
    pop();
    SegmentPool.INSTANCE.recycle(this);
  }
  
  public Segment pop()
  {
    if (this.next != this) {}
    for (Segment localSegment = this.next;; localSegment = null)
    {
      this.prev.next = this.next;
      this.next.prev = this.prev;
      this.next = null;
      this.prev = null;
      return localSegment;
    }
  }
  
  public Segment push(Segment paramSegment)
  {
    paramSegment.prev = this;
    paramSegment.next = this.next;
    this.next.prev = paramSegment;
    this.next = paramSegment;
    return paramSegment;
  }
  
  public Segment split(int paramInt)
  {
    int i = this.limit - this.pos - paramInt;
    if ((paramInt <= 0) || (i <= 0)) {
      throw new IllegalArgumentException();
    }
    if (paramInt < i)
    {
      localSegment = SegmentPool.INSTANCE.take();
      System.arraycopy(this.data, this.pos, localSegment.data, localSegment.pos, paramInt);
      this.pos += paramInt;
      localSegment.limit += paramInt;
      this.prev.push(localSegment);
      return localSegment;
    }
    Segment localSegment = SegmentPool.INSTANCE.take();
    System.arraycopy(this.data, this.pos + paramInt, localSegment.data, localSegment.pos, i);
    this.limit -= i;
    localSegment.limit += i;
    push(localSegment);
    return this;
  }
  
  public void writeTo(Segment paramSegment, int paramInt)
  {
    if (paramSegment.limit - paramSegment.pos + paramInt > 2048) {
      throw new IllegalArgumentException();
    }
    if (paramSegment.limit + paramInt > 2048)
    {
      System.arraycopy(paramSegment.data, paramSegment.pos, paramSegment.data, 0, paramSegment.limit - paramSegment.pos);
      paramSegment.limit -= paramSegment.pos;
      paramSegment.pos = 0;
    }
    System.arraycopy(this.data, this.pos, paramSegment.data, paramSegment.limit, paramInt);
    paramSegment.limit += paramInt;
    this.pos += paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okio/Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */