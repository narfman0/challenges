from typing import List


class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        n = len(maze)
        m = len(maze[0])
        entrance_y, entrance_x = entrance
        unvisited = [(entrance_x, entrance_y)]
        maze[entrance_y][entrance_x] = "+"
        steps = 0

        def is_exit(x: int, y: int) -> bool:
            return (
                ((x == 0 or x == m - 1) or (y == 0 or y == n - 1))
                and (x != entrance_x or y != entrance_y)
                and maze[y][x] == "."
            )

        def is_valid(x: int, y: int) -> bool:
            return (x >= 0 and x < m) and (y >= 0 and y < n)

        while unvisited:
            next_set = []
            steps += 1
            for i in range(len(unvisited)):
                cx, cy = unvisited[i]
                for tx, ty in [(cx + 1, cy), (cx - 1, cy), (cx, cy - 1), (cx, cy + 1)]:
                    if not is_valid(tx, ty):
                        continue
                    if is_exit(tx, ty):
                        return steps
                    if maze[ty][tx] == ".":
                        maze[ty][tx] = "+"
                        next_set.append((tx, ty))
            unvisited = next_set
        return -1
