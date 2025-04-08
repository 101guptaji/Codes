package INterview;

public class test1 {
    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "dasun";



        int count = 0;

        int n1 = s1.length(), n2 = s2.length();

        if (n1 == n2) { // replace
            int i = 0, j = 0;
            while (i < n1 && j < n2) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    count++;
                }
                i++;
                j++;
            }
        } else if (n1 > n2) {
            int i = 0, j=0;
            while (i < n1 && j<n2) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    count++;
                    i++;
                }
                else{
                    i++;
                    j++;
                }
            }
        }
        else{
            int i = 0, j=0;
            while (i < n1 && j<n2) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    count++;
                    j++;
                }
                else{
                    i++;
                    j++;
                }
            }
        }

        System.out.println(count);
    }
}
