#!/usr/bin/env python

import sys

prices_count = 0
prices_sum = 0
key = 0


for line in sys.stdin:
    try:
        price = int(line.strip().split(",")[-7])
        prices_sum += price
        prices_count += 1
    except Exception as e:
        continue

if prices_count != 0:
    mean = prices_sum / prices_count
else:
    mean = 0

print(f'{key}\t{prices_count}\t{mean}')