import sys
import re

from urlparse import urlparse

RESULT_FILE=sys.argv[1]

with open(RESULT_FILE) as result_file:
    for line in result_file:
        m = re.match("""^([0-9.]*);([0-9.]*);([1-9][0-9][0-9]);([^;]*);(.*)$""", line[:-1])

        if m is None:
            continue

        req_start_time = float(m.group(1))
        res_end_time   = float(m.group(2))
        status_code    = int(m.group(3))
        content_type   = m.group(4)
        req_uri        = m.group(5)

        pr = urlparse(req_uri)

        print pr.netloc


