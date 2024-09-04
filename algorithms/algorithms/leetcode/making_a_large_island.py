from collections import deque
from typing import List


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)

        def calculate_area(x: int, y: int, mark_visited: bool) -> tuple[int, deque]:
            result = 0
            visited = set()
            frontier = deque()
            frontier.append((x, y))
            adjacent_water_coords = deque()
            while frontier:
                x, y = frontier.pop()
                if (x, y) in visited:
                    continue
                visited.add((x, y))
                if grid[y][x] in (1, 3):
                    result += 1
                    if mark_visited:
                        grid[y][x] == 3
                    if x < n - 1:
                        frontier.append((x + 1, y))
                    if x > 0:
                        frontier.append((x - 1, y))
                    if y > 0:
                        frontier.append((x, y - 1))
                    if y < n - 1:
                        frontier.append((x, y + 1))
                elif grid[y][x] == 0:
                    adjacent_water_coords.append((x, y))
            return result, adjacent_water_coords

        max_area = 1
        for y in range(n):
            for x in range(n):
                if grid[y][x] == 1:
                    area, adjacent_water_coords = calculate_area(x, y, True)
                    if area == n**2:
                        return area
                    for adjacent_water_coord in adjacent_water_coords:
                        ax, ay = adjacent_water_coord
                        grid[ay][ax] = 1
                        area, _ = calculate_area(ax, ay, False)
                        max_area = max(max_area, area)
                        grid[ay][ax] = 0
        return max_area
