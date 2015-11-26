import sys
import json
import re

def parse_result_file(result_file):
    with open(result_file) as lines:
        line_no = 0
    
        for line in lines:
            line_no += 1
            m = re.match("""\(([^,]*),Success\((.*)\)\)""", line)
    
            if m is not None:
                app_url = m.group(1)
                details = m.group(2)

                try:
                    obj = json.loads(details)
                    yield (app_url, obj)
                except:
                    sys.stderr.write("Error in JSON output on line %d.\n" % line_no)
                    sys.exit(1)
            else:
                sys.stderr.write("Couldn't parse line %d.\n" % line_no)
                sys.exit(1)

def render_urls(result_object):
    url_objects = map(lambda x: x["url"], result_object["result"]["url2methods"])

    for url_object in url_objects:
        segments = url_object["concat"]
        yield "".join(map(lambda s : render_url_segment(s), segments))

def render_url_segment(url_segment):
    k = url_segment["kind"]  
    assert(k == "constant")
    return url_segment["value"]

if __name__ == "__main__":
    for (app_name, result) in parse_result_file(sys.argv[1]):
        for url in render_urls(result):
            try:
                print url
            except:
                print url.encode('utf-8')
