# mean reducer
import sys

aggregated_mean = 0
aggregated_prices_count = 0

for line in sys.stdin:
    key, prices_count, mean = line.split('\t')

    prices_count = int(prices_count)
    mean = float(mean)

    if aggregated_prices_count + prices_count != 0:
        aggregated_mean = (aggregated_prices_count * aggregated_mean + prices_count * mean) / (aggregated_prices_count + prices_count)
    aggregated_prices_count += prices_count
print(aggregated_mean)