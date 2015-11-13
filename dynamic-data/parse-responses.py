import sys
import re

from common import strip_port_number

RESULT_FILE=sys.argv[1]

MYREGEX="""https?://[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789\-._~:/?#@!$&'()*+,;=]*"""

with open(RESULT_FILE) as result_file:
    for line in result_file:
        m = re.match("""^---([0-9.]*);;;([0-9.]*)?;;;([A-Z]*||[1-9][0-9][0-9]);;;([A-Z]*);;;(.*);;;(http.*)$""", line[:-1])

        if m is not None:
            # This is a request line.
            pass
        else:
            us = re.findall(MYREGEX, line)
            for u in us:
                print strip_port_number(u)
