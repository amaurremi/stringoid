import sys
import urlparse
import re
import json
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

apps_per_domain = {}
for line in open(sys.argv[1]):
  parts = line.split(';;;')
  if len(parts) is 2:
    app = parts[0]
    url = parts[1]
    try:
      domain = urlparse.urlparse(url).netloc
      domain = domain.replace('\n', '')
      if domain is not None and '___' not in domain:
        if domain not in apps_per_domain:
          apps_per_domain[domain] = [app]
        else:
          if app not in apps_per_domain[domain]:
            apps_per_domain[domain].append(app)
    except ValueError:
      pass

for dom in apps_per_domain:
  apps_per_domain[dom] = [len(apps_per_domain[dom])]

df = pd.DataFrame(apps_per_domain).T.sort_values(0, ascending=False)
df.columns = ['apps per domain']
print df
df.to_csv('data/apps_per_domain.csv')