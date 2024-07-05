from collections import defaultdict
from typing import List


class Solution:
    def findCircleNumUnion(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        province_count = n
        city_to_province = {}
        for i in range(n):
            province = set()
            province.add(i)
            city_to_province[i] = province
        for i in range(n):
            for j in range(i + 1, n):
                if isConnected[i][j] and city_to_province[j] != city_to_province[i]:
                    for city in city_to_province[j]:
                        city_to_province[i].add(city)
                    # Update each city pointing to this set to the new one
                    old_province = city_to_province[j]
                    for k in range(n):
                        if city_to_province[k] == old_province:
                            city_to_province[k] = city_to_province[i]

                    province_count -= 1
                    print(f"Connected {i} with {j}, {province_count} provinces remain")
        return province_count

    def findCircleNumDfs(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        connected = defaultdict(list)
        for i in range(n):
            for j in range(i + 1, n):
                if isConnected[i][j] == 1:
                    connected[i].append(j)
                    connected[j].append(i)
        visited = [False] * n

        def dfs(i):
            nonlocal visited
            nonlocal connected
            for j in connected[i]:
                if not visited[j]:
                    visited[j] = True
                    dfs(j)

        result = 0
        for i in range(n):
            if not visited[i]:
                visited[i] = True
                result += 1
                dfs(i)
        return result
