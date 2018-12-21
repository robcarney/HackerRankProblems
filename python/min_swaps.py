#!/bin/python3

import math
import os
import random
import re
import sys

USE_STDIN = False

def minSwaps(arr):
    seen = []
    swaps = 0
    next = 1
    for curr in arr:
        if curr in seen:
            continue
        seen.append(curr)
        next = arr[curr - 1]
        count = 1
        while next != curr:
            count += 1
            seen.append(next)
            next = arr[next - 1]
        swaps += count - 1
    return swaps



if __name__ == '__main__':
    if USE_STDIN:
        inf = sys.stdin
    else:
        inf = open('in.txt', 'r')

    n = int(inf.readline())

    arr = list(map(int, inf.readline().rstrip().split()))

    res = minSwaps(arr)

    print(res)