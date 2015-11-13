import sys
import re

from common import strip_port_number

RESULT_FILE=sys.argv[1]

first=True

with open(RESULT_FILE) as result_file:
    for line in result_file:
        if first:
            # Skip the header
            assert(line[:-1] == "req_start_time;;;res_end_time;;;status_code;;;method;;;content_type;;;req_uri")
            first = False
            continue

        try:
            m = re.match("""^([0-9.]*);;;([0-9.]*)?;;;([A-Z]*|[1-9][0-9][0-9]);;;([A-Z]*);;;(.*);;;(http.*)$""", line[:-1])

            req_start_time = float(m.group(1))
            res_end_time   = None if len(m.group(2)) == 0 else float(m.group(2))
            status_code    = m.group(3)
            http_verb      = m.group(4)
            content_type   = m.group(5)
            req_uri        = m.group(6)

            print strip_port_number(req_uri)
        except Exception, e:
            sys.stderr.write("Couldn't parse line:\n%s\n" % line)
            sys.stderr.write("Error: %s\n" % str(e))
            sys.exit(1)
