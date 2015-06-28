package edu.illinois.wala.ipa.callgraph

import com.ibm.wala.ipa.callgraph.{Context, ContextKey, DelegatingContext}

class RichContext(val c: Context) extends AnyVal {
  def is(k: ContextKey) = c.get(k) != null
  def +(addedC: Context): Context = new DelegatingContext(c, addedC)
}