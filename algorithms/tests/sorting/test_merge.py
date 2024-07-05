from unittest import TestCase

from algorithms.sorting.merge import merge_list, merge_sort, merge_sort_recursive


class TestSortingMerge(TestCase):
    def test_merge_list(self):
        left = [1, 4, 6]
        right = [2, 3, 5]
        result = merge_list(left, right)
        self.assertEqual(6, len(result))
        for i in range(len(result)):
            self.assertEqual(i + 1, result[i])

        left = [1, 4, 6, 7, 8, 9]
        right = [2, 3, 5]
        result = merge_list(left, right)
        self.assertEqual(9, len(result))
        for i in range(len(result)):
            self.assertEqual(i + 1, result[i])

    def test_merge_sort(self):
        array = [1, 7, 5, 4, 6, 8, 5, 3, 9]
        result = merge_sort(array)
        self.assertEqual([1, 3, 4, 5, 5, 6, 7, 8, 9], result)

    def test_merge_sort_recursive(self):
        array = [1, 7, 5, 4, 6, 8, 5, 3, 9, 8]
        result = merge_sort_recursive(array)
        self.assertEqual([1, 3, 4, 5, 5, 6, 7, 8, 8, 9], result)
