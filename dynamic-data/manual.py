import difflib
import json
import os
import re
import sys
import urlparse

def green(s):
    return "\033[1;32m%s\033[1;m" % s

class URLStringMatcher:
    def __init__(self, blob):
        self.blob = blob
        self.lower_blob = blob.lower()
        self.matcher = difflib.SequenceMatcher()
        self.matcher.set_seq2(blob)

    def exact_match(self, url):
        no_port = re.sub(":[0-9]+/", "/", url)

        if url in self.blob or no_port in self.blob:
            return True

        if url.lower() in self.lower_blob or no_port.lower() in self.lower_blob:
            return True

        return False

    def interactive_match(self, url):
        no_port = re.sub(":[0-9]+/", "/", url)

        p = urlparse.urlparse(no_port)

        parts = list(p)

        parts[1] = p.netloc
        parts[2] = p.path
        parts[3] = p.query

        if p.netloc.lower() in self.lower_blob:
            parts[1] = green(p.netloc)

        path_elems = p.path.split('/')
        colored_path_elems = map(lambda e : green(e) if e and e in self.blob else e, path_elems)
        parts[2] = '/'.join(colored_path_elems)

        qpairs = urlparse.parse_qsl(p.query)
        cqpairs = map(lambda (k,v): (green(k) if k in self.blob else k, green(v) if v in self.blob else v), qpairs)

        cquery = "" if not cqpairs else "?" + "&".join(map(lambda (k,v): "%s=%s" % (k,v), cqpairs))
        parts[3] = cquery

        colored = urlparse.urlunparse(parts)

        print ""
        print colored
        print ""

        response = "."
        while response != "y" and response != "n":
            response = raw_input("Match ? (y/n) ")
        return response == "y"

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
        "enumerated_urls_file" : enum_file,
        "json_output"          : "./classified/%s.json" % base
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

    static_hits = 0
    response_hits = 0
    response_manual_hits = 0

    unattributed = []

    for request in obj["unique_requests"]:
        if static.exact_match(request):
            static_hits += 1
            continue 

        if response.exact_match(request):
            response_hits += 1
            continue

        if response.interactive_match(request):
            response_manual_hits += 1
            continue

        unattributed.append(request)        

    return {
        "unique" : len(obj["unique_requests"]),
        "total" : len(obj["requests"]),
        "in_static" : static_hits,
        "in_response_exact" : response_hits,
        "in_response_confirmed" : response_manual_hits,
        "unattributed" : unattributed
    }

if __name__ == "__main__":
    if len(sys.argv) != 2:
        sys.stderr.write("Usage: %s app.apk.\n" % sys.argv[0])
        sys.exit(1)

    paths = app_to_paths(sys.argv[1])

    print "--------------------------------------------------------------"
    print "  %30s" % paths["app_name"]
    print "--------------------------------------------------------------"

    data = load_app_data(paths)

    attribution = attribute(data)

    with open(paths["json_output"], "w") as fp:
        fp.write(json.dumps(attribution, indent=2))
