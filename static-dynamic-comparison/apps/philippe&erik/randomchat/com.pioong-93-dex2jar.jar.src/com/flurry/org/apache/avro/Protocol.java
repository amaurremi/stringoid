package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.map.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Protocol
{
  private static final Set<String> MESSAGE_RESERVED = new HashSet();
  private static final Set<String> PROTOCOL_RESERVED;
  public static final Schema SYSTEM_ERROR;
  public static final Schema SYSTEM_ERRORS;
  public static final long VERSION = 1L;
  private String doc;
  private byte[] md5;
  private Map<String, Message> messages = new LinkedHashMap();
  private String name;
  private String namespace;
  Schema.Props props = new Schema.Props(PROTOCOL_RESERVED);
  private Schema.Names types = new Schema.Names();
  
  static
  {
    Collections.addAll(MESSAGE_RESERVED, new String[] { "doc", "response", "request", "errors", "one-way" });
    SYSTEM_ERROR = Schema.create(Schema.Type.STRING);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SYSTEM_ERROR);
    SYSTEM_ERRORS = Schema.createUnion(localArrayList);
    PROTOCOL_RESERVED = new HashSet();
    Collections.addAll(PROTOCOL_RESERVED, new String[] { "namespace", "protocol", "doc", "messages", "types", "errors" });
  }
  
  private Protocol() {}
  
  public Protocol(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2);
  }
  
  public Protocol(String paramString1, String paramString2, String paramString3)
  {
    this.name = paramString1;
    this.doc = paramString2;
    this.namespace = paramString3;
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    System.out.println(parse(new File(paramArrayOfString[0])));
  }
  
  private static Protocol parse(JsonParser paramJsonParser)
  {
    try
    {
      Protocol localProtocol = new Protocol();
      localProtocol.parse(Schema.MAPPER.readTree(paramJsonParser));
      return localProtocol;
    }
    catch (IOException paramJsonParser)
    {
      throw new SchemaParseException(paramJsonParser);
    }
  }
  
  public static Protocol parse(File paramFile)
    throws IOException
  {
    return parse(Schema.FACTORY.createJsonParser(paramFile));
  }
  
  public static Protocol parse(InputStream paramInputStream)
    throws IOException
  {
    return parse(Schema.FACTORY.createJsonParser(paramInputStream));
  }
  
  public static Protocol parse(String paramString)
  {
    try
    {
      paramString = parse(Schema.FACTORY.createJsonParser(new ByteArrayInputStream(paramString.getBytes("UTF-8"))));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new AvroRuntimeException(paramString);
    }
  }
  
  private void parse(JsonNode paramJsonNode)
  {
    parseNamespace(paramJsonNode);
    parseName(paramJsonNode);
    parseTypes(paramJsonNode);
    parseMessages(paramJsonNode);
    parseDoc(paramJsonNode);
    parseProps(paramJsonNode);
  }
  
  private void parseDoc(JsonNode paramJsonNode)
  {
    this.doc = parseDocNode(paramJsonNode);
  }
  
  private String parseDocNode(JsonNode paramJsonNode)
  {
    paramJsonNode = paramJsonNode.get("doc");
    if (paramJsonNode == null) {
      return null;
    }
    return paramJsonNode.getTextValue();
  }
  
  private Message parseMessage(String paramString, JsonNode paramJsonNode)
  {
    String str = parseDocNode(paramJsonNode);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1 = paramJsonNode.getFieldNames();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!MESSAGE_RESERVED.contains(localObject2))
      {
        localObject3 = paramJsonNode.get((String)localObject2);
        if ((((JsonNode)localObject3).isValueNode()) && (((JsonNode)localObject3).isTextual())) {
          localLinkedHashMap.put(localObject2, ((JsonNode)localObject3).getTextValue());
        }
      }
    }
    Object localObject2 = paramJsonNode.get("request");
    if ((localObject2 == null) || (!((JsonNode)localObject2).isArray())) {
      throw new SchemaParseException("No request specified: " + paramJsonNode);
    }
    localObject1 = new ArrayList();
    localObject2 = ((JsonNode)localObject2).iterator();
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (JsonNode)((Iterator)localObject2).next();
      localObject4 = ((JsonNode)localObject3).get("name");
      if (localObject4 == null) {
        throw new SchemaParseException("No param name: " + localObject3);
      }
      localObject5 = ((JsonNode)localObject3).get("type");
      if (localObject5 == null) {
        throw new SchemaParseException("No param type: " + localObject3);
      }
      ((List)localObject1).add(new Schema.Field(((JsonNode)localObject4).getTextValue(), Schema.parse((JsonNode)localObject5, this.types), null, ((JsonNode)localObject3).get("default")));
    }
    localObject1 = Schema.createRecord((List)localObject1);
    boolean bool = false;
    localObject2 = paramJsonNode.get("one-way");
    if (localObject2 != null)
    {
      if (!((JsonNode)localObject2).isBoolean()) {
        throw new SchemaParseException("one-way must be boolean: " + paramJsonNode);
      }
      bool = ((JsonNode)localObject2).getBooleanValue();
    }
    localObject2 = paramJsonNode.get("response");
    if ((!bool) && (localObject2 == null)) {
      throw new SchemaParseException("No response specified: " + paramJsonNode);
    }
    Object localObject4 = paramJsonNode.get("errors");
    if (bool)
    {
      if (localObject4 != null) {
        throw new SchemaParseException("one-way can't have errors: " + paramJsonNode);
      }
      if ((localObject2 != null) && (Schema.parse((JsonNode)localObject2, this.types).getType() != Schema.Type.NULL)) {
        throw new SchemaParseException("One way response must be null: " + paramJsonNode);
      }
      return new Message(paramString, str, localLinkedHashMap, (Schema)localObject1, null);
    }
    localObject2 = Schema.parse((JsonNode)localObject2, this.types);
    Object localObject3 = new ArrayList();
    ((List)localObject3).add(SYSTEM_ERROR);
    if (localObject4 != null)
    {
      if (!((JsonNode)localObject4).isArray()) {
        throw new SchemaParseException("Errors not an array: " + paramJsonNode);
      }
      paramJsonNode = ((JsonNode)localObject4).iterator();
      while (paramJsonNode.hasNext())
      {
        localObject4 = ((JsonNode)paramJsonNode.next()).getTextValue();
        localObject5 = this.types.get(localObject4);
        if (localObject5 == null) {
          throw new SchemaParseException("Undefined error: " + (String)localObject4);
        }
        if (!((Schema)localObject5).isError()) {
          throw new SchemaParseException("Not an error: " + (String)localObject4);
        }
        ((List)localObject3).add(localObject5);
      }
    }
    return new TwoWayMessage(paramString, str, localLinkedHashMap, (Schema)localObject1, (Schema)localObject2, Schema.createUnion((List)localObject3), null);
  }
  
  private void parseMessages(JsonNode paramJsonNode)
  {
    paramJsonNode = paramJsonNode.get("messages");
    if (paramJsonNode == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramJsonNode.getFieldNames();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.messages.put(str, parseMessage(str, paramJsonNode.get(str)));
      }
    }
  }
  
  private void parseName(JsonNode paramJsonNode)
  {
    JsonNode localJsonNode = paramJsonNode.get("protocol");
    if (localJsonNode == null) {
      throw new SchemaParseException("No protocol name specified: " + paramJsonNode);
    }
    this.name = localJsonNode.getTextValue();
  }
  
  private void parseNamespace(JsonNode paramJsonNode)
  {
    paramJsonNode = paramJsonNode.get("namespace");
    if (paramJsonNode == null) {
      return;
    }
    this.namespace = paramJsonNode.getTextValue();
    this.types.space(this.namespace);
  }
  
  private void parseProps(JsonNode paramJsonNode)
  {
    Iterator localIterator = paramJsonNode.getFieldNames();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!PROTOCOL_RESERVED.contains(str))
      {
        JsonNode localJsonNode = paramJsonNode.get(str);
        if ((localJsonNode.isValueNode()) && (localJsonNode.isTextual())) {
          addProp(str, localJsonNode.getTextValue());
        }
      }
    }
  }
  
  private void parseTypes(JsonNode paramJsonNode)
  {
    paramJsonNode = paramJsonNode.get("types");
    if (paramJsonNode == null) {}
    for (;;)
    {
      return;
      if (!paramJsonNode.isArray()) {
        throw new SchemaParseException("Types not an array: " + paramJsonNode);
      }
      paramJsonNode = paramJsonNode.iterator();
      while (paramJsonNode.hasNext())
      {
        JsonNode localJsonNode = (JsonNode)paramJsonNode.next();
        if (!localJsonNode.isObject()) {
          throw new SchemaParseException("Type not an object: " + localJsonNode);
        }
        Schema.parse(localJsonNode, this.types);
      }
    }
  }
  
  public void addProp(String paramString1, String paramString2)
  {
    try
    {
      this.props.add(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  @Deprecated
  public Message createMessage(String paramString1, String paramString2, Schema paramSchema)
  {
    return createMessage(paramString1, paramString2, new LinkedHashMap(), paramSchema);
  }
  
  @Deprecated
  public Message createMessage(String paramString1, String paramString2, Schema paramSchema1, Schema paramSchema2, Schema paramSchema3)
  {
    return createMessage(paramString1, paramString2, new LinkedHashMap(), paramSchema1, paramSchema2, paramSchema3);
  }
  
  public Message createMessage(String paramString1, String paramString2, Map<String, String> paramMap, Schema paramSchema)
  {
    return new Message(paramString1, paramString2, paramMap, paramSchema, null);
  }
  
  public Message createMessage(String paramString1, String paramString2, Map<String, String> paramMap, Schema paramSchema1, Schema paramSchema2, Schema paramSchema3)
  {
    return new TwoWayMessage(paramString1, paramString2, paramMap, paramSchema1, paramSchema2, paramSchema3, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Protocol)) {
        return false;
      }
      paramObject = (Protocol)paramObject;
    } while ((this.name.equals(((Protocol)paramObject).name)) && (this.namespace.equals(((Protocol)paramObject).namespace)) && (this.types.equals(((Protocol)paramObject).types)) && (this.messages.equals(((Protocol)paramObject).messages)) && (this.props.equals(this.props)));
    return false;
  }
  
  public String getDoc()
  {
    return this.doc;
  }
  
  public byte[] getMD5()
  {
    if (this.md5 == null) {}
    try
    {
      this.md5 = MessageDigest.getInstance("MD5").digest(toString().getBytes("UTF-8"));
      return this.md5;
    }
    catch (Exception localException)
    {
      throw new AvroRuntimeException(localException);
    }
  }
  
  public Map<String, Message> getMessages()
  {
    return this.messages;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNamespace()
  {
    return this.namespace;
  }
  
  public String getProp(String paramString)
  {
    try
    {
      paramString = (String)this.props.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Map<String, String> getProps()
  {
    return Collections.unmodifiableMap(this.props);
  }
  
  public Schema getType(String paramString)
  {
    return this.types.get(paramString);
  }
  
  public Collection<Schema> getTypes()
  {
    return this.types.values();
  }
  
  public int hashCode()
  {
    return this.name.hashCode() + this.namespace.hashCode() + this.types.hashCode() + this.messages.hashCode() + this.props.hashCode();
  }
  
  public void setTypes(Collection<Schema> paramCollection)
  {
    this.types = new Schema.Names();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Schema localSchema = (Schema)paramCollection.next();
      this.types.add(localSchema);
    }
  }
  
  void toJson(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    this.types.space(this.namespace);
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeStringField("protocol", this.name);
    paramJsonGenerator.writeStringField("namespace", this.namespace);
    if (this.doc != null) {
      paramJsonGenerator.writeStringField("doc", this.doc);
    }
    this.props.write(paramJsonGenerator);
    paramJsonGenerator.writeArrayFieldStart("types");
    Object localObject1 = new Schema.Names(this.namespace);
    Object localObject2 = this.types.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Schema localSchema = (Schema)((Iterator)localObject2).next();
      if (!((Schema.Names)localObject1).contains(localSchema)) {
        localSchema.toJson((Schema.Names)localObject1, paramJsonGenerator);
      }
    }
    paramJsonGenerator.writeEndArray();
    paramJsonGenerator.writeObjectFieldStart("messages");
    localObject1 = this.messages.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramJsonGenerator.writeFieldName((String)((Map.Entry)localObject2).getKey());
      ((Message)((Map.Entry)localObject2).getValue()).toJson(paramJsonGenerator);
    }
    paramJsonGenerator.writeEndObject();
    paramJsonGenerator.writeEndObject();
  }
  
  public String toString()
  {
    return toString(false);
  }
  
  public String toString(boolean paramBoolean)
  {
    try
    {
      Object localObject = new StringWriter();
      JsonGenerator localJsonGenerator = Schema.FACTORY.createJsonGenerator((Writer)localObject);
      if (paramBoolean) {
        localJsonGenerator.useDefaultPrettyPrinter();
      }
      toJson(localJsonGenerator);
      localJsonGenerator.flush();
      localObject = ((StringWriter)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AvroRuntimeException(localIOException);
    }
  }
  
  public class Message
  {
    private String doc;
    private String name;
    private final Schema.Props props = new Schema.Props(Protocol.MESSAGE_RESERVED);
    private Schema request;
    
    private Message(String paramString, Map<String, String> paramMap, Schema paramSchema)
    {
      this.name = paramString;
      this.doc = paramMap;
      Schema localSchema;
      this.request = localSchema;
      if (paramSchema != null)
      {
        this$1 = paramSchema.entrySet().iterator();
        while (Protocol.this.hasNext())
        {
          paramString = (Map.Entry)Protocol.this.next();
          addProp((String)paramString.getKey(), (String)paramString.getValue());
        }
      }
    }
    
    public void addProp(String paramString1, String paramString2)
    {
      try
      {
        this.props.add(paramString1, paramString2);
        return;
      }
      finally
      {
        paramString1 = finally;
        throw paramString1;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof Message)) {
          return false;
        }
        paramObject = (Message)paramObject;
      } while ((this.name.equals(((Message)paramObject).name)) && (this.request.equals(((Message)paramObject).request)) && (this.props.equals(((Message)paramObject).props)));
      return false;
    }
    
    public String getDoc()
    {
      return this.doc;
    }
    
    public Schema getErrors()
    {
      return Schema.createUnion(new ArrayList());
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getProp(String paramString)
    {
      try
      {
        paramString = (String)this.props.get(paramString);
        return paramString;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public Map<String, String> getProps()
    {
      return Collections.unmodifiableMap(this.props);
    }
    
    public Schema getRequest()
    {
      return this.request;
    }
    
    public Schema getResponse()
    {
      return Schema.create(Schema.Type.NULL);
    }
    
    public int hashCode()
    {
      return this.name.hashCode() + this.request.hashCode() + this.props.hashCode();
    }
    
    public boolean isOneWay()
    {
      return true;
    }
    
    void toJson(JsonGenerator paramJsonGenerator)
      throws IOException
    {
      paramJsonGenerator.writeStartObject();
      if (this.doc != null) {
        paramJsonGenerator.writeStringField("doc", this.doc);
      }
      this.props.write(paramJsonGenerator);
      paramJsonGenerator.writeFieldName("request");
      this.request.fieldsToJson(Protocol.this.types, paramJsonGenerator);
      toJson1(paramJsonGenerator);
      paramJsonGenerator.writeEndObject();
    }
    
    void toJson1(JsonGenerator paramJsonGenerator)
      throws IOException
    {
      paramJsonGenerator.writeStringField("response", "null");
      paramJsonGenerator.writeBooleanField("one-way", true);
    }
    
    public String toString()
    {
      try
      {
        Object localObject = new StringWriter();
        JsonGenerator localJsonGenerator = Schema.FACTORY.createJsonGenerator((Writer)localObject);
        toJson(localJsonGenerator);
        localJsonGenerator.flush();
        localObject = ((StringWriter)localObject).toString();
        return (String)localObject;
      }
      catch (IOException localIOException)
      {
        throw new AvroRuntimeException(localIOException);
      }
    }
  }
  
  private class TwoWayMessage
    extends Protocol.Message
  {
    private Schema errors;
    private Schema response;
    
    private TwoWayMessage(String paramString, Map<String, String> paramMap, Schema paramSchema1, Schema paramSchema2, Schema paramSchema3)
    {
      super(paramString, paramMap, paramSchema1, paramSchema2, null);
      this.response = paramSchema3;
      Schema localSchema;
      this.errors = localSchema;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!super.equals(paramObject)) {}
      do
      {
        do
        {
          return false;
        } while (!(paramObject instanceof TwoWayMessage));
        paramObject = (TwoWayMessage)paramObject;
      } while ((!this.response.equals(((TwoWayMessage)paramObject).response)) || (!this.errors.equals(((TwoWayMessage)paramObject).errors)));
      return true;
    }
    
    public Schema getErrors()
    {
      return this.errors;
    }
    
    public Schema getResponse()
    {
      return this.response;
    }
    
    public int hashCode()
    {
      return super.hashCode() + this.response.hashCode() + this.errors.hashCode();
    }
    
    public boolean isOneWay()
    {
      return false;
    }
    
    void toJson1(JsonGenerator paramJsonGenerator)
      throws IOException
    {
      paramJsonGenerator.writeFieldName("response");
      this.response.toJson(Protocol.this.types, paramJsonGenerator);
      Object localObject = this.errors.getTypes();
      if (((List)localObject).size() > 1)
      {
        localObject = Schema.createUnion(((List)localObject).subList(1, ((List)localObject).size()));
        paramJsonGenerator.writeFieldName("errors");
        ((Schema)localObject).toJson(Protocol.this.types, paramJsonGenerator);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/Protocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */