#!/usr/bin/env python
# encoding: utf-8
import sys
import re

from urlparse import urlparse

RESULT_FILE=sys.argv[1]

MYREGEX="""https?://[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789\-._~:/?#@!$&'()*+,;=]*"""

with open(RESULT_FILE) as result_file:
    for line in result_file:
        m = re.match("""^---([0-9.]*);;;([0-9.]*);;;([1-9][0-9][0-9]);;;([A-Z]*);;;(.*);;;(http.*)$""", line[:-1])

        if m is not None:
            # This is a request line.
            pass
        else:
            us = re.findall(MYREGEX, line)
            for u in us:
                print u
