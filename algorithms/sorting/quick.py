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


def partition(pivot, array):
    left = []
    right = []
    for item in array:
        if item < pivot:
            left.append(item)
        else:
            right.append(item)
    left = quick_sort(left)
    right = quick_sort(right)
    return left, right
