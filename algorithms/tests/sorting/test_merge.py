from unittest import TestCase

from sorting.merge import merge_list, merge_sort


class TestSortingMerge(TestCase):
    def test_merge_list(self):
        left = [1, 4, 6]
        right = [2, 3, 5]
        result = merge_list(left, right)
        self.assertEquals(6, len(result))
        for i in range(len(result)):
            self.assertEquals(i + 1, result[i])

        left = [1, 4, 6, 7, 8, 9]
        right = [2, 3, 5]
        result = merge_list(left, right)
        self.assertEquals(9, len(result))
        for i in range(len(result)):
            self.assertEquals(i + 1, result[i])


    def test_merge_sort(self):
        array = [1, 7, 5, 4, 6, 8, 5, 3, 9]
        result = merge_sort(array)
        self.assertEquals(9, len(result))
        self.assertEquals(1, result[0])
        self.assertEquals(3, result[1])
        self.assertEquals(4, result[2])
        self.assertEquals(5, result[3])
        self.assertEquals(5, result[4])
        self.assertEquals(6, result[5])
        self.assertEquals(7, result[6])
        self.assertEquals(8, result[7])
        self.assertEquals(9, result[8])
