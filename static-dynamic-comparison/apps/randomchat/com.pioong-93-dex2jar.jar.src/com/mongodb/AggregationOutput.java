package com.mongodb;

public class AggregationOutput
{
  protected final DBObject _cmd;
  protected final CommandResult _commandResult;
  protected final Iterable<DBObject> _resultSet;
  
  public AggregationOutput(DBObject paramDBObject, CommandResult paramCommandResult)
  {
    this._commandResult = paramCommandResult;
    this._cmd = paramDBObject;
    if (paramCommandResult.containsField("result"))
    {
      this._resultSet = ((Iterable)paramCommandResult.get("result"));
      return;
    }
    throw new IllegalArgumentException("result undefined");
  }
  
  public DBObject getCommand()
  {
    return this._cmd;
  }
  
  public CommandResult getCommandResult()
  {
    return this._commandResult;
  }
  
  public ServerAddress getServerUsed()
  {
    return this._commandResult.getServerUsed();
  }
  
  public Iterable<DBObject> results()
  {
    return this._resultSet;
  }
  
  public String toString()
  {
    return this._commandResult.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/AggregationOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */