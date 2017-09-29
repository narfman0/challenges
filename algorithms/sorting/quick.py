import random


def quick_sort_randomized(array):
    """ Sort array using the quicksort algorithm """
    if len(array) <= 1:
        return array
    pivot_index = random.randint(0, len(array) - 1)
    pivot = array[pivot_index]
    del array[pivot_index]
    left, right = partition(pivot, array, method=quick_sort_randomized)
    result = left
    result.append(pivot)
    result.extend(right)
    return result


def quick_sort(array):
    """ Sort array using the quicksort algorithm """
    if len(array) <= 1:
        return array
    pivot = array[-1]
    left, right = partition(pivot, array[:-1])
    result = left
    result.append(pivot)
    result.extend(right)
    return result


def partition(pivot, array, method=quick_sort):
    left = []
    right = []
    for item in array:
        if item < pivot:
            left.append(item)
        else:
            right.append(item)
    left = method(left)
    right = method(right)
    return left, right
