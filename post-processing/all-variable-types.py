import re
import sys
import json

with open(sys.argv[1]) as result_file:
    for line in result_file:
        m = re.match("""^\(hdfs.*,Success\((.*)\)\)$""", line)

        if m is None:
            continue

        data = json.loads(m.group(1))
        results = data["result"]

        automata = []

        for (automaton, _) in results:
            for transition in automaton["transitions"]:
                if transition["label"]["kind"] == "variable":
                    print transition["label"]["value"]["type"]
