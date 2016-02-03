package com.flurry.org.apache.avro;

public class UnresolvedUnionException
  extends AvroRuntimeException
{
  private Schema unionSchema;
  private Object unresolvedDatum;
  
  public UnresolvedUnionException(Schema paramSchema, Object paramObject)
  {
    super("Not in union " + paramSchema + ": " + paramObject);
    this.unionSchema = paramSchema;
    this.unresolvedDatum = paramObject;
  }
  
  public Schema getUnionSchema()
  {
    return this.unionSchema;
  }
  
  public Object getUnresolvedDatum()
  {
    return this.unresolvedDatum;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/UnresolvedUnionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */