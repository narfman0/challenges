import unittest
from main import climbing_stairs


class TestMethods(unittest.TestCase):
    def test_searching(self):
        with open('data.txt') as f:
            lines = f.readlines()
            self.assertEqual(89, climbing_stairs(int(lines[0])))
            self.assertEqual(10946, climbing_stairs(int(lines[1])))
            self.assertEqual(79757008057644623350300078764807923712509139103039448418553259155159833079730688, climbing_stairs(int(lines[2])))


if __name__ == '__main__':
    unittest.main()
