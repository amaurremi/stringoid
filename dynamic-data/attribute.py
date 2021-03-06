import difflib
import json
import os
import re
import sys
import urlparse

# Encapsulates the many (partial-)matching attemps one can do.
class URLStringMatcher:
    def __init__(self, blob):
        self.blob = blob
        self.lower_blob = blob.lower()
        self.matcher = difflib.SequenceMatcher()
        self.matcher.set_seq2(blob)

    def score(self, url):
        no_port = re.sub(":[0-9]+/", "/", url)

        if url in self.blob or no_port in self.blob:
            return 1.0

        if url.lower() in self.lower_blob or no_port.lower() in self.lower_blob:
            return 1.0

        try:
            p = urlparse.urlparse(no_port.lower())

            bits = []

            if p.netloc:
                bits.append(p.netloc)

            path = p.path
            if path.startswith('/'):
                path = path[1:]

            if path.endswith('/'):
                path = path[:-1]

            bits.append(path)

            #for k,v in urlparse.parse_qsl(p.query):
            #    if k:
            #        bits.append(k)
            #    if v:
            #        bits.append(v)

            bit_found = 0

            for b in bits:
                if b in self.lower_blob:
                    bit_found += 1

            return float(bit_found) / float(len(bits))
        except:
            return 0.0

        # self.matcher.set_seq1(url)
        # s1 = sum(n for _,_,n in self.matcher.get_matching_blocks()) / float(len(url))

        # self.matcher.set_seq1(no_port)
        # s2 = sum(n for _,_,n in self.matcher.get_matching_blocks()) / float(len(url))

        # return max(s1, s2)
        return 0.0

def app_to_paths(quasi_name):
    base = os.path.basename(quasi_name)

    if base.endswith(".apk"):
        base = base[:-4]

    request_file   = "./http-traffic/%s.txt" % base
    response_file  = "./http-traffic/%s_responses.txt" % base
    static_file    = "./static-app-content/%s.content" % base
    automaton_file = "./automata/%s.automaton" % base
    enum_file      = "./enumerated/%s.urls" % base

    return {
        "app_name"             : base,
        "request_file"         : request_file,
        "response_file"        : response_file,
        "static_file"          : static_file,
        "automaton_file"       : automaton_file,
        "enumerated_urls_file" : enum_file
    }

def load_requests(request_file):
    rs = []
    with open(request_file) as rf:
        for line in rf:
            m = re.match("""^.*;;;(http.*)$""", line[:-1])
            if m is not None:
                rs.append(m.group(1))

    return rs

def load_lines(path):
    lines = []
    with open(path) as fp:
        for line in fp:
            lines.append(line[:-1])
    return lines

def load_file(path):
    with open(path) as fp:
        return fp.read()

def load_app_data(paths):
    obj = {}

    obj["requests"] = load_requests(paths["request_file"])
    obj["unique_requests"] = list(set(obj["requests"]))

    obj["static_content"] = load_file(paths["static_file"])
    obj["response_content"] = load_file(paths["response_file"])

    obj["enumerated_urls"] = load_lines(paths["enumerated_urls_file"])

    return obj

def attribute(obj):
    static     = URLStringMatcher(obj["static_content"])
    response   = URLStringMatcher(obj["response_content"])
    enumerated = URLStringMatcher("\n".join(set(obj["enumerated_urls"])))

    count_static = 0
    count_response = 0
    count_exact = 0
    not_found = 0

    for request in obj["unique_requests"]:
        s1 = s2 = s3 = -1.0

        s3 = enumerated.score(request)
        if s3 > 0.99:
            print "%15s   %s" % ("%.2f - EXACT" % s3, request)
            count_exact += 1
            continue

        s1 = static.score(request)
        if s1 > 0.99:
            print "%15s   %s" % ("%.2f - STATIC" % s1, request)
            count_static += 1
            continue

        s2 = response.score(request)
        if s2 > 0.99:
            print "%15s   %s" % ("%.2f - RESPONSE" % s2, request)
            count_response += 1
            continue

        print "%15s   %s" % ("%.2f - NOTFOUND" % max(s1,s2,s3), request)
        not_found += 1

    print "Exact matches     : %d" % count_exact
    print "In static content : %d" % count_static
    print "In responses exa  : %d" % count_response
    print "Not found         : %d" % not_found
    print "-----------------------"
    print "Total             : %d" % len(obj["unique_requests"])
    print "Non-uniques       : %d" % len(obj["requests"])
    
    return None

if __name__ == "__main__":
    if len(sys.argv) != 2:
        sys.stderr.write("Usage: %s app.apk.\n" % sys.argv[0])
        sys.exit(1)

    paths = app_to_paths(sys.argv[1])

    print "--------------------------------------------------------------"
    print "  %30s" % paths["app_name"]
    print "--------------------------------------------------------------"

    data  = load_app_data(paths)

    attribute(data)
