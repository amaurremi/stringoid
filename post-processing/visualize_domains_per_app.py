import sys
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.ticker import ScalarFormatter, FormatStrFormatter

import seaborn as sns

name = 'count unique domains'
df = pd.read_csv(sys.argv[1])
df.columns = ['application', name]
df.index = range(len(df))

# print some statistics:
print df
print df[name].describe()
print df.quantile([.62, .625, .63, .8225, .85, .9, .95, .975, .99])

# plot histogram:
# axes = df[name].plot(kind='hist', bins=10000, facecolor='gray')
axes = sns.distplot(df[name], bins=5000, kde=False)
axes.set_xscale('log')
axes.set_yscale('log')
axes.get_xaxis().set_major_formatter(FormatStrFormatter('%.0f'))
axes.get_yaxis().set_major_formatter(FormatStrFormatter('%.0f'))
axes.set_xlim(0,1000)
axes.set_ylim(0,1500)
axes.set_xlabel('unique domains')
axes.set_ylabel('number of applications')
plt.tight_layout()

fig = axes.get_figure()
fig.savefig('domains_per_app.pdf')

plt.show()