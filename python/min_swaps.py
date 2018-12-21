#!/bin/python3

import math
import os
import random
import re
import sys

USE_STDIN = False

def countInversions(q):
    inversions, q = countInversionsHelper(q)
    return inversions


def countInversionsHelper(q):
    if len(q) <= 1:
        return 0, q
    else:
        split = len(q) // 2
        inv1, l1 = countInversionsHelper(q[:split])
        inv2, l2 = countInversionsHelper(q[split:])
        print("Merging ", l1, l2)
        inv3, q = merge(l1, l2)
        print("Inversions: %d" % (inv1+inv2+inv3))
        return inv1 + inv2 + inv3, q


def merge(l1, l2):
    c1 = 0 
    c2 = 0
    inv = 0
    result = []
    while (c1 < len(l1) and c2 < len(l2)):
        if l1[c1] <= l2[c2]:
            result.append(l1[c1])
            c1 += 1
        else:
            result.append(l2[c2])
            c2 += 1
            inv += len(l1) - c1
    if (c1 < len(l1)):
        result.extend(l1[c1:])
    if (c2 < len(l2)):
        result.extend(l2[c2:])
    return inv, result

if __name__ == '__main__':
    if USE_STDIN:
        inf = sys.stdin
    else:
        inf = open('in.txt', 'r')

    n = int(inf.readline())

    arr = list(map(int, inf.readline().rstrip().split()))

    res = countInversions(arr)

    print(res)