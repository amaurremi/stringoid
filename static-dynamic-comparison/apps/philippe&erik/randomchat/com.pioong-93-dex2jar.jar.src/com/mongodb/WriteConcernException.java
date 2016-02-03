package com.mongodb;

public class WriteConcernException
  extends MongoException
{
  private static final long serialVersionUID = 841056799207039974L;
  private final CommandResult commandResult;
  
  public WriteConcernException(CommandResult paramCommandResult)
  {
    super(paramCommandResult.getCode(), paramCommandResult.toString());
    this.commandResult = paramCommandResult;
  }
  
  public CommandResult getCommandResult()
  {
    return this.commandResult;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/WriteConcernException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */