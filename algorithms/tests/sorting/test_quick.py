from unittest import TestCase

from sorting.quick import quick_sort


class TestSortingQuicksort(TestCase):
    def test_quicksort(self):
        array = [1, 7, 5, 4, 6, 2, 3, 8]
        result = quick_sort(array)
        for i in range(len(array)):
            self.assertEquals(i + 1, result[i])
