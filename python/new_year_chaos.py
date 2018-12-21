#!/bin/python3

import math
import os
import random
import re
import sys

USE_STDIN = False

# Complete the minimumBribes function below.
def minimumBribes(q):
    if len(q) <= 1:
        return 0, q
    else:
        inv1, l1 = minimumBribes(q[:len(q)//2])
        inv2, l2 = minimumBribes(q[len(q)//2:])
        inv3 = merge(l1, l2)


def merge(l1, l2):
    c1 = 0 
    c2 = 0
    inv = 0
    while (c1 < len(l1)):
        if l1[c1] <= l1[c2]:
            c1 += 1
            c2 += 1
        else:
            c1 += 1
            inv += 1
    return inv
    
    
        

def normalList(size):
    result = [0] * size
    for i in range(size):
        result[i] = i
    return result


if __name__ == '__main__':
    if USE_STDIN:
        inf = sys.stdin
    else:
        inf = open('in.txt', 'r')
    t = int(inf.readline())

    for t_itr in range(t):
        n = int(inf.readline())

        q = list(map(int, inf.readline().rstrip().split()))

        inv, l = minimumBribes(q)
        if (inv > len(q)):
            print("Too chaotic")
        else:
            print(inv)
