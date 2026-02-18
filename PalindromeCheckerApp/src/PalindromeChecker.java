public class PalindromeChecker {
    public static void main(String[] args) {
        String input = new String("madam");
        String reverse;
        boolean isPalindrome = true;
        for(int i=0; i<input.length()/2; i++){
            if(input.charAt(i) != input.charAt(input.length()-1-i)){
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println("The String is a palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }
    }
}
