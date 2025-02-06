class CompressedStringIterator {
    private String compressedString;
    private int index;
    private char currentChar;
    private int count;

    public CompressedStringIterator(String compressedString) {
        this.compressedString = compressedString;
        this.index = 0;
        this.currentChar = '\0';  // Will store the current character
        this.count = 0;  // Will store the remaining occurrences of the current character
    }

    public char next() {
        if (!hasNext()) {
            return ' ';  // Return a space if no characters are left
        }

        // Decrement count since we are returning the current character
        count--;

        // Return the current character
        char result = currentChar;

        // If the count is 0, move to the next character and its count in the compressed string
        if (count == 0) {
            moveToNextCharacter();
        }

        return result;
    }

    public boolean hasNext() {
        return index < compressedString.length() || count > 0;
    }

    private void moveToNextCharacter() {
        // Move to the next character in the compressed string
        if (index < compressedString.length()) {
            currentChar = compressedString.charAt(index++);
            // Read the count (next number in the string)
            int numStartIndex = index;
            while (index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
                index++;
            }
            count = Integer.parseInt(compressedString.substring(numStartIndex, index));
        }
    }
}
