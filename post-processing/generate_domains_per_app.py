import sys
import urlparse
import re
import json
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

domains_per_app = {}
for line in open(sys.argv[1]):
  parts = line.split(';;;')
  if len(parts) is 2:
    app = parts[0]
    url = parts[1]
    try:
      domain = urlparse.urlparse(url).netloc
      domain = domain.replace('\n', '')
      if domain is not None and '___' not in domain:
        if app not in domains_per_app:
          domains_per_app[app] = [domain]
        else:
          if domain not in domains_per_app[app]:
            domains_per_app[app].append(domain)
    except ValueError:
      pass

for app in domains_per_app:
  domains_per_app[app] = [len(domains_per_app[app])]

df = pd.DataFrame(domains_per_app).T.sort_values(0, ascending=False)
df.columns = ['domains per app']
print df
df.to_csv('data/domains_per_app.csv')