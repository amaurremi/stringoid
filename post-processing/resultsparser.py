import sys
import json
import re

def parse_result_file(result_file):
    with open(result_file) as lines:
        line_no = 0
    
        for line in lines:
            line_no += 1
            m = re.match("""\(([^,]*),(Success|Failure)\((.*)\)\)""", line)
    
            if m is not None:
                app_url = m.group(1)
                success = m.group(2)
                details = m.group(3)

                if success == "Success":
                    try:
                        obj = json.loads(details)
                        yield (app_url, True, obj)
                    except:
                        sys.stderr.write("Error in JSON output on line %d.\n" % line_no)
                else:
                    yield (app_url, False, details)
            else:
                sys.stderr.write("Couldn't parse line %d.\n" % line_no)

def render_urls(result_object):
    url_objects = map(lambda x: x["url"], result_object["result"]["url2methods"])

    for url_object in url_objects:
        segments = url_object["concat"]
        yield "".join(map(lambda s : render_url_segment(s), segments))

def render_url_segment(url_segment):
    k = url_segment["kind"]

    if k == "constant":
        return url_segment["value"]
    elif k == "variable":
        return "____"
    elif k == "missing":
        return "????"
    else:
        raise Exception("Unknown kind: %s." % k)
