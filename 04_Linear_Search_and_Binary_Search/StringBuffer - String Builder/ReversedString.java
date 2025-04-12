public class ReversedString {
    public static void main(String[] args) {
        String input = "hello";
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        String reversed = sb.toString();
        System.out.println("Reversed string: " + reversed);
    }
}
