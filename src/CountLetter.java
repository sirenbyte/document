public class CountLetter {
    private static final int ASCII_A_LOWERCASE = 97;
    private static final int ASCII_Z_LOWERCASE = 122;
    private static final String SYMBOL_FOR_END_STRING = "!";

    public static String repeatLetterCountInString(String inputString) {
        if (inputString.length() == 0) {
            throw new RuntimeException("empty");
        }
        int counter = 1;
        StringBuilder outputString = new StringBuilder();
        inputString += SYMBOL_FOR_END_STRING;
        for (int i = 0; i < inputString.length() - 1; i++) {
            char current = inputString.charAt(i);
            if ((int) current < ASCII_A_LOWERCASE || (int) current > ASCII_Z_LOWERCASE) {
                throw new RuntimeException("not letter");
            }
            if (current == inputString.charAt(i + 1)) {
                counter++;
            } else {
                outputString.append(counter).append(current);
                counter = 1;
            }
        }
        return outputString.toString();
    }

    public static void main(String[] args) {
        System.out.println(repeatLetterCountInString("a"));
    }

    public static Boolean testForPositiveCase() {
        return repeatLetterCountInString("aaabzzzaafff").equals("3a1b3z2a3f");
    }

    public static Boolean testForIncludingSymbol() {
        String inputString = "!!$@^";
        try {
            repeatLetterCountInString(inputString);
            return false;
        } catch (RuntimeException e) {
            return true;
        }
    }

    public static Boolean testForEmptyString() {
        String empty = " ";
        try {
            repeatLetterCountInString(empty);
            return false;
        } catch (RuntimeException e) {
            return true;
        }
    }
}
