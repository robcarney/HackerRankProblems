#!/bin/python3

import math
import os
import random
import re
import sys
import time

USE_STDIN = False

# Complete the evenForest function below.
def evenForest(graph):
    memo = [0] * len(graph)
    getSubtreeAncestors(graph, 0, memo)
    return evenForestSubtree(graph, memo, 0)

def evenForestSubtree(graph, memo, start, parent=-1):
    edgesRemoved = 0
    toRemove = []
    for node in graph[start]:
        if node == parent:
            continue
        if memo[node] % 2 == 0:
            toRemove.append(node)
            edgesRemoved += 1
            memo[start] -= memo[node]
            edgesRemoved += evenForestSubtree(graph, memo, node, start)
    for node in toRemove:
        removeEdge(graph, start, node)
    for node in graph[start]:
        if node == parent:
            continue
        edgesRemoved += evenForestSubtree(graph, memo, node, start)
    return edgesRemoved

        
def removeEdge(graph, parent, child):
    graph[parent].remove(child)
    graph[child].remove(parent)



def getSubtreeAncestors(graph, start, memo, parent=-1):
    for node in graph[start]:
        if len(graph[node]) == 1:
            memo[node] = 1
        elif node == parent:
            continue
        else:
            getSubtreeAncestors(graph, node, memo, start)
    count = 1
    for node in graph[start]:
        count += memo[node]
    memo[start] = count


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
    graph = buildGraph(t_nodes, t_edges, t_to, t_from)

    res = evenForest(graph)

    print(str(res) + '\n')