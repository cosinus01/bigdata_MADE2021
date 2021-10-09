# var reducer
import sys

aggregated_prices_count = 0
aggregated_var = 0
aggregated_mean= 0

for line in sys.stdin:

    key, prices_count, mean, var = line.split('\t')

    prices_count = int(prices_count)
    mean = float(mean)
    squared_mean = float(var)


    if aggregated_prices_count + prices_count != 0:
        aggregated_mean = (aggregated_prices_count * aggregated_mean + prices_count * mean) / (aggregated_prices_count + prices_count)


    if aggregated_prices_count + prices_count != 0:
        aggregated_var = (aggregated_prices_count * aggregated_var + prices_count * var) / (aggregated_prices_count + prices_count) +  aggregated_prices_count * prices_count * ((aggregated_mean - mean) / (aggregated_prices_count + prices_count)) ** 2

    aggregated_prices_count += prices_count

print(aggregated_var)