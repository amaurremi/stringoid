import difflib
import json
import os
import re
import sys

# Encapsulates the many (partial-)matching attemps one can do.
class URLStringMatcher:
    def __init__(self, blob):
        self.blob = blob
        self.lower_blob = blob.tolower()
        self.matcher = difflib.SequenceMatcher()
        self.matcher.set_seq2(blob)

    def score(url):
        no_port = re.sub(":[0-9]+/", "/", url)

        if url in self.blob or no_port in self.blob:
            return 1.0

        if url.tolower() in self.lower_blob or no_port.tolower() in self.lower_blob:
            return 1.0

        matcher.set_seq1(url)
        s1 = sum(n for _,_,n in matcher.get_matching_blocks()) / float(len(url))

        matcher.set_seq1(no_port)
        s2 = sum(n for _,_,n in matcher.get_matching_blocks()) / float(len(url))

        return max(s1, s2)

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
    enumerated = URLStringMatcher(set(obj["enumerated_urls"]))

    for request in obj["unique_requests"]:
        found = False

        if static.score(request) > 0.99:
            print "%15s   %s" % ("STATIC", request)
            found = True

        if response.score(request) > 0.99:
            print "%15s   %s" % ("RESPONSE", request)
            found = True

        if enumerated.score(request) > 0.99:
            print "%15s   %s" % ("EXACT", request)
            found = True

        if not found:
            print "%15s   %s" % ("NOTFOUND", request)

    return None

if __name__ == "__main__":
    if len(sys.argv) != 2:
        sys.stderr.write("Usage: %s app.apk.\n" % sys.argv[0])
        sys.exit(1)

    paths = app_to_paths(sys.argv[1])
    data  = load_app_data(paths)

    attribute(data)
