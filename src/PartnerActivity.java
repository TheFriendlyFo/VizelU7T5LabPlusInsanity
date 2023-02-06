    import java.util.ArrayList;

    public class PartnerActivity {
        public static void main(String[] args) {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            nums.add(10);
            nums.add(30);
            nums.add(25);
            nums.add(40);
            nums.add(55);
            nums.add(45);
            nums.add(20);

            int sum = nums.stream().mapToInt(num -> num).sum();

            ArrayList<String> words = new ArrayList<>();
            words.add("candle");
            words.add("dandelion");
            words.add("eagle");
            words.add("garage");
            words.add("hamburger");
            words.add("imitate");
            words.add("jello");

            for (int i = words.size() - 1; i >= 0 ; i++) {
                System.out.println(words.get(i));
            }

            for (String word : words) {
                if (word.charAt(0) == 'h') break;
                System.out.println(word);
            }


            System.out.println(sum);  // TEST: this should print 225
        }
    }
