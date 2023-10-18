class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        List<String> wordsList = new ArrayList(Arrays.asList(words));
        int count = 0;
        for (Iterator<String> wordsIterator = wordsList.iterator(); wordsIterator.hasNext();) {
            String word = wordsIterator.next();
            wordsIterator.remove();
            if (wordsList.contains(reverse(word))) count++;
        }
        return count;
    }

    private String reverse(String input) {
        return new StringBuffer(input).reverse().toString();
    }
}