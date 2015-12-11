import sys

from resultsparser import parse_result_file
from resultsparser import render_urls

if __name__ == "__main__":
    errors = 0

    for (app_name, success, result) in parse_result_file(sys.argv[1]):
        if not success:
            errors += 1
        else:
            for url in render_urls(result):
                try:
                    print url
                except:
                    print url.encode('utf-8')

    print "There were %d apps with errors." % errors
