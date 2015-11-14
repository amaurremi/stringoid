import difflib
import sys

matcher = difflib.SequenceMatcher()

with open(sys.argv[2]) as haystack_file:
    haystack = haystack_file.read()
    matcher.set_seq2(haystack)

with open(sys.argv[1]) as needle_file:
    for needle in needle_file:
        needle = needle[:-1]

        print needle

        if needle in haystack:
            print "Exact match"
        else:
            matcher.set_seq1(needle)

            tot = sum(n for _,_,n in matcher.get_matching_blocks()) / float(len(needle))

            print tot

        print ""
        print ""
