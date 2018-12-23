#!/bin/python3

import math
import os
import random
import re
import sys

USE_STDIN = False

# Complete the commonChild function below.
def commonChild(s1, s2):
    if len(s1) < 1 or len(s2) < 1:
        return 0
    memo = [[0] * len(s2) for n in range(len(s1))]
    for i in range(len(s1)):
        if s1[i] == s2[0]:
            memo[i][0] = 1
        elif i >= 1:
            memo[i][0] = memo[i-1][0]
        else:
            memo[i][0] = 0
    memo[0][0] = 0
    for j in range(len(s2)):
        if s1[0] == s2[j]:
            memo[0][j] = 1
        elif j >= 1:
            memo[0][j] = memo[0][j-1]
        else:
            memo[0][j] = 0
    for i in range(1, len(s1)):
        for j in range(1, len(s2)):
            bestHere = 0
            if s1[i] == s2[j]:
                bestHere = 1 + memo[i-1][j-1]
            else:
                bestHere = max(memo[i][j-1], memo[i-1][j])
            memo[i][j] = bestHere
    return memo[len(s1)-1][len(s2)-1]

if __name__ == '__main__':
    if USE_STDIN:
        inf = sys.stdin
    else:
        inf = open('in.txt', 'r')
    
    s1 = inf.readline().replace("\n","")

    s2 = inf.readline().replace("\n","")

    result = commonChild(s1, s2)

    print(result)