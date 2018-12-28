#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the steadyGene function below.
def steadyGene(gene):

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    gene = input()

    result = steadyGene(gene)

    fptr.write(str(result) + '\n')

    fptr.close()