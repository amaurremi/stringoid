package com.vungle.publisher.protocol.message;

import javax.inject.Inject;
import javax.inject.Singleton;

public final class RequestConfigResponse
  extends BaseJsonSerializable
{
  public Boolean a;
  public Integer b;
  public Integer c;
  public a d;
  
  @Singleton
  public static class Factory
    extends JsonDeserializationFactory<RequestConfigResponse>
  {}
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/RequestConfigResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */