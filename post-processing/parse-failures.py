import sys
import re
import json

ma = {}

for line in open(sys.argv[1]):
    line = line[:-1]

    m = re.match("""^\(([^,]*),Failure\((.*)\)\)$""", line)

    if m is not None:
        app_path  = m.group(1)
        exception = m.group(2)

        p = app_path.rfind('/')
        apk = app_path[p+1:]

        ma[apk] = (app_path, exception)

print "Parsing of error file done."

all_data = json.load(open("smaller.json"))

print "Parsing of meta data done."

for d in all_data:
    if "apk_url" in d:
        url = d["apk_url"]
        apk = url[url.rfind('/') + 1:]

        if apk in ma:
            print apk
            print ma[apk][0]
            print url
            print ma[apk][1]
            print ""

