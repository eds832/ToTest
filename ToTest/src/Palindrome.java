

public class Palindrome {
    public static boolean isPalindrome(String word) {
    	StringBuilder str = new StringBuilder(word);
    	
        return word.equalsIgnoreCase(str.reverse().toString());
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}