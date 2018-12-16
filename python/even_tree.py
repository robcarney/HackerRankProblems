#!/bin/python3

import math
import sys
import os
import random
import re
import sys

USE_STDIN = False

# Complete the evenForest function below.
def evenForest(graph):
    return nodesInTree(graph, 0)


def nodesInTree(graph, start):
    toExplore = [start]
    explored = {}
    for i in range(len(graph)):
        explored[i] = False
    count = 0
    while toExplore:
        curr = toExplore.pop()
        explored[curr] = True
        count += 1
        for node in graph[curr]:
            if not explored[node]:
                toExplore.append(node)
    return count


def buildGraph(t_nodes, t_edges, t_from, t_to):
    graph = []
    for i in range(t_nodes):
        graph.append([])
    for i in range(t_edges):
        graph[t_from[i]-1].append(t_to[i]-1)
        graph[t_to[i]-1].append(t_from[i]-1)
    return graph


if __name__ == '__main__':
    if USE_STDIN:
        inf = sys.stdin
    else:
        inf = open('in.txt', 'r')
    opf = sys.stdout

    t_nodes, t_edges = map(int, inf.readline().rstrip().split())

    t_from = [0] * t_edges
    t_to = [0] * t_edges

    for i in range(t_edges):
        t_from[i], t_to[i] = map(int, inf.readline().rstrip().split())
    print(t_to)
    print(t_from)
    graph = buildGraph(t_nodes, t_edges, t_to, t_from)
    print(graph)

    res = evenForest(graph)

    print(str(res) + '\n')