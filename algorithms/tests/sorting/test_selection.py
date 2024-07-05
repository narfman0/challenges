from unittest import TestCase

from algorithms.sorting.selection import selection_sort, selection_sort_generator


class TestSortingSelection(TestCase):
    def test_selection(self):
        array = [1, 7, 5, 4, 6]
        result = selection_sort(array)
        self.assertEqual(1, result[0])
        self.assertEqual(4, result[1])
        self.assertEqual(5, result[2])
        self.assertEqual(6, result[3])
        self.assertEqual(7, result[4])

    def test_selection_generator(self):
        array = [1, 7, 5, 4, 6]
        result = list(selection_sort_generator(array))
        self.assertEqual(1, result[0])
        self.assertEqual(4, result[1])
        self.assertEqual(5, result[2])
        self.assertEqual(6, result[3])
        self.assertEqual(7, result[4])
