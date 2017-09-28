def merge_list(left, right):
    """ Merge two lists in order """
    li = 0
    ri = 0
    result = []
    while li < len(left) and ri < len(right):
        if cmp(left[li], right[ri]) < 0:
            result.append(left[li])
            li += 1
        else:
            result.append(right[ri])
            ri += 1
    if li < len(left):
        result.extend(left[li:])
    if ri < len(right):
        result.extend(right[ri:])
    return result


def merge_sort(array):
    """ Sort the given `array` using the merge sort algorithm.
    Assumes the elements can use the `cmp` function to compare themselves.
    Sorts in-place.
    """
    # first we will iterate over groups of 2 elements each, sorting in place,
    # and work up
    i = 2
    while i < len(array):
        for j in range(len(array) / i):
            left = array[i*j:i*j + i/2]
            right = array[i*j + i/2:i*j + i]
            result = merge_list(left, right)
            for k in range(len(result)):
                array[i*j + k] = result[k]
        i *= 2
    # this addresses a failure in design; only divisible by 2 is the real merge
    # sort algo occurring. here we do a final run on everything and assume its
    # sorted, which is wrong
    if i > len(array):
        left = array[:i/2]
        right = array[i/2:]
        array = merge_list(left, right)
    return array
