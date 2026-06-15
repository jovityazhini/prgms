import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int k = 0; k < n; k++) {
            String str = sc.nextLine();

            int[] freq = new int[52];

            for (char ch : str.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z')
                    freq[ch - 'A']++;
                else if (ch >= 'a' && ch <= 'z')
                    freq[ch - 'a' + 26]++;
            }

            int maxFreq = 0;
            for (int f : freq)
                maxFreq = Math.max(maxFreq, f);

            for (int i = 0; i < 26; i++) {
                if (freq[i] == maxFreq)
                    System.out.print((char) ('A' + i));
            }

            for (int i = 26; i < 52; i++) {
                if (freq[i] == maxFreq)
                    System.out.print((char) ('a' + i - 26));
            }

            System.out.println();
        }

        sc.close();
    }
}
