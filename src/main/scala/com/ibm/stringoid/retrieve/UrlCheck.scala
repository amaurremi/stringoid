package com.ibm.stringoid.retrieve

import java.util.regex.Pattern

object UrlCheck {

  private val URL_PREFIX = "https?://[^\" ]*"
  val URL_REGEX          = "https?://[^\" ]+"

  val urlPrefixPattern = Pattern.compile(URL_PREFIX)
  val urlRegexPattern = Pattern.compile(URL_REGEX)
  
  private[this] def matches(string: String, pattern: Pattern): Boolean = {
    val matcher = pattern matcher string
    matcher.matches
  }

  def isUrlPrefix(string: String): Boolean =
    matches(string, urlPrefixPattern)

  def isUrlRegex(string: String): Boolean =
    matches(string, urlRegexPattern)
}
