import urlparse
import sys
import re

import json

url_file = sys.argv[1]

fragments = {}

domains = []
pairs = []
triples = []

with open(url_file) as fp:
    for line in fp:
        try:
            p = urlparse.urlparse(line[:-1])

            if not p.scheme or not str(p.netloc):
                continue

            netloc = re.sub(":[0-9]+$", "", p.netloc).lower()
            path = str(p.path)

            # domains.append(netloc)
            print "D (%s)" % repr(netloc)

            if path:
                #pairs.append((netloc, path))
                print "P %s" % repr((netloc,path))

            for k,v in urlparse.parse_qsl(p.query):
                print "T %s" % repr((netloc,path,k))
                #triples.append((netloc, path, k))
        except Exception, e:
            pass
