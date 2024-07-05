def selection_sort(array):
    """Sort the given `array` using the selection sort algorithm.
    Assumes the elements can use the `cmp` function to compare themselves.
    Sorts in-place.
    """
    for i in range(len(array)):
        smallest_index = i
        for j in range(i + 1, len(array)):
            if array[j] < array[smallest_index]:
                smallest_index = j
        temp = array[i]
        array[i] = array[smallest_index]
        array[smallest_index] = temp
    return array


def selection_sort_generator(array):
    """Sort the given `array` using the selection sort algorithm.
    Assumes the elements can use the `cmp` function to compare themselves.
    Returns a generator with values.
    """
    while array:
        smallest_index = 0
        for j in range(1, len(array)):
            if array[j] < array[smallest_index]:
                smallest_index = j
        smallest = array[smallest_index]
        del array[smallest_index]
        yield smallest
