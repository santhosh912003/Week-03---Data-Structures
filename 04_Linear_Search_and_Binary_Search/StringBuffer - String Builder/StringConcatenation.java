public class StringConcatenation {
    public static void main(String[] args) {
        String[] words = {"Java", "is", "awesome", "!"};
        StringBuffer sb = new StringBuffer();

        for (String word : words) {
            sb.append(word);
        }

        String result = sb.toString();
        System.out.println("Concatenated string: " + result);
    }
}
