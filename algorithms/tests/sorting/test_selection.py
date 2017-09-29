from unittest import TestCase

from sorting.selection import selection_sort, selection_sort_generator


class TestSortingSelection(TestCase):
    def test_selection(self):
        array = [1, 7, 5, 4, 6]
        result = selection_sort(array)
        self.assertEquals(1, result[0])
        self.assertEquals(4, result[1])
        self.assertEquals(5, result[2])
        self.assertEquals(6, result[3])
        self.assertEquals(7, result[4])

    def test_selection_generator(self):
        array = [1, 7, 5, 4, 6]
        result = list(selection_sort_generator(array))
        self.assertEquals(1, result[0])
        self.assertEquals(4, result[1])
        self.assertEquals(5, result[2])
        self.assertEquals(6, result[3])
        self.assertEquals(7, result[4])
