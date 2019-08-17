public class NonEmptyTile {
    public int numTilePossibilities(String tiles) {
        HashSet<String> results = new HashSet<>();
        tilePossibilitiesLength(results, tiles, new HashSet<>(), "");
        return results.size();
    }

    private void tilePossibilitiesLength(HashSet<String> results, String tiles,
                                         HashSet<Integer> usedIdxs, String current) {
        for(int i=0; i<tiles.length() && current.length() < tiles.length(); i++){
            if(!usedIdxs.contains(i)){
                HashSet<Integer> iUsed = new HashSet<>(usedIdxs);
                iUsed.add(i);
                String icurrent = current + tiles.charAt(i);
                results.add(icurrent);
                tilePossibilitiesLength(results, tiles, iUsed, icurrent);
            }
        }
    }
}
