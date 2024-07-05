from unittest import TestCase

from sorting.quick import quick_sort, quick_sort_randomized


class TestSortingQuicksort(TestCase):
    def test_quicksort(self):
        array = [1, 7, 5, 4, 6, 2, 3, 8]
        result = quick_sort(array)
        for i in range(len(array)):
            self.assertEqual(i + 1, result[i])

    def test_quicksort_randomized(self):
        array = [1, 7, 5, 4, 6, 2, 3, 8]
        result = quick_sort_randomized(array)
        for i in range(len(array)):
            self.assertEqual(i + 1, result[i])
