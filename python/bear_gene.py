#!/bin/python3

import math
import os
import random
import re
import sys

from collections import namedtuple

USE_STDIN = False

# Complete the steadyGene function below.
def steadyGeneOld(gene, geneLength):
    geneDict = buildStringDict(gene)
    evenCount = geneLength / 4
    numberOff = 0
    for c in geneDict.keys():
        if geneDict[c] > evenCount:
            numberOff += geneDict[c] - evenCount
    MemoEntry = namedtuple("MemoEntry", "length dict")
    memo = []
    for i in range(n):
        memo.append(MemoEntry(0, {}))
    lastStart = -1
    bestDict = {}
    for i in range(0,n):
        if geneDict[gene[i]] > evenCount:
            if lastStart == -1:
                lastStart = i
                currNumOff = 1
                j = i + 1
                newDict = buildStringDict("")
                while (currNumOff < numberOff):
                    if geneDict[gene[j]] - newDict[gene[j]] > evenCount:
                        currNumOff += 1
                        newDict[gene[j]] += 1
                    j += 1
                memo[i] = MemoEntry(j - i, newDict)
            else:
                lastEntry = memo[lastStart]
                if gene[lastEntry] == gene[i] and lastEntry.dict[gene[i]] > geneDict[gene[i]] - evenCount:
                    newDict = lastEntry.dict
                    newDict[gene[i]] -= 1
    return numberOff


def steadyGene(gene, geneLength):
    rightbound, currDict = getRightBound(gene, geneLength)
    if rightbound == 0:
        return 0
    evenCount = geneLength / 4
    geneDict = buildStringDict(gene)
    leftbound = 1
    memo = [0] * geneLength
    memo[0] = rightbound
    while rightbound < geneLength:
        curr = gene[leftbound - 1]
        currDict[curr] += 1
        while currDict[curr] > evenCount:
            currDict[gene[rightbound]] -= 1
            rightbound += 1
        memo[leftbound] = rightbound - leftbound
        leftbound += 1
    best = 500000
    for n in memo:
        if n < best and n != 0:
            best = n
    return best




def getRightBound(gene, geneLength):
    currDict = buildStringDict("")
    evenCount = geneLength / 4
    bound = geneLength
    for i in range(geneLength - 1, -1, -1):
        if currDict[gene[i]] >= evenCount:
            return bound, currDict
        else:
            currDict[gene[i]] += 1
            bound -= 1
    return bound, currDict



def buildStringDict(gene):
    result = {}
    result['G'] = 0
    result['C'] = 0
    result['A'] = 0
    result['T'] = 0
    for c in gene:
        result[c] += 1
    return result

if __name__ == '__main__':
    if USE_STDIN:
        inf = sys.stdin
    else:
        inf = open('in.txt', 'r')

    n = int(inf.readline().replace("\n",""))

    gene = inf.readline().replace("\n","")

    print(steadyGene(gene, n))