#!/bin/python
""" Code challenge https://www.codeeval.com/open_challenges/7/

Description:

You are given a prefix expression. Write a program which evaluates it.

Your program should accept a file as its first argument. The file contains one
prefix expression per line.

Your program should read this file and insert it into any data structure you
like. Traverse this data structure and evaluate the prefix expression. Each
token is delimited by a whitespace. You may assume that sum '+', multiplication
'*' and division '/' are the only valid operators appearing in the test data.

Print to stdout the output of the prefix expression, one per line.

Constraints:

    The evaluation result will always be an integer >= 0.
    The number of the test cases is <= 40.
"""
import sys


def prefix(expression):
    """ Evaluate the prefix expression """
    expression_parts = expression[:-1].split(' ')
    split_point = len(expression_parts)/2
    operators = expression_parts[:split_point]
    values = expression_parts[split_point:]
    result = int(values.pop(0))
    while operators:
        result = operation(operators.pop(), result, int(values.pop(0)))
    return result


def operation(operator, valueLeft, valueRight):
    """ So fun fact, the dictionary method evaluates each of the returns, so
    if valueRight is 0 but the operation is *, we'd still get a divide by zero
    error. This is obviously silly, python! Leaving this here for posterity:

    return {
        '+': valueLeft + valueRight,
        '/': valueLeft / valueRight,
        '*': valueLeft * valueRight,
    }[operator]
    """
    if operator == '+':
        return valueLeft + valueRight
    elif operator == '/':
        return valueLeft / valueRight
    elif operator == '*':
        return valueLeft * valueRight


if __name__ == '__main__':
    exit_code = 0
    with open(sys.argv[1]) as f:
        for expression in f.readlines():
            try:
                print(prefix(expression))
            except:
                exit_code = 1
                print 'Failed to evaluate expression: ' + expression
    sys.exit(exit_code)
