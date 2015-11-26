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

            for k,v in urlparse.parse_qsl(p.query):
                print "Q %s" % repr((netloc,k))
                print "V %s" % repr((netloc,k,v))
        except Exception, e:
            pass
