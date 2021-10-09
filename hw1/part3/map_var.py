#var maper

import sys

prices_count = 0
prices_squared_sum = 0
prices_sum = 0
key = 0


for line in sys.stdin:
    try:
        price = int(line.strip().split(",")[-7])
    except Exception as e:
        continue
    prices_sum += price
    prices_squared_sum += price**2
    prices_count += 1

if prices_count != 0:
    mean = prices_sum/prices_count
    var = prices_squared_sum/prices_count - mean*mean
else:
    mean = 0
    var = 0

print(f'{key}\t{prices_count}\t{mean}\t{var}')