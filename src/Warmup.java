    import java.util.ArrayList;
    import java.util.Arrays;
    /**
     You can add different types to an ArrayList if you don't specify
     the type as below.

     If you leave the type blank for Arraylist, the type will default to the Object class
     */

    class Warmup {
        public static void main(String[] args) {
            Dog dog1 = new Dog("Doggy",10);
            Cat cat1 = new Cat("Kitty",11);
            String s1 = new String("Stringy");
            Integer i1 = 20;
            Double d1 = 3.3;

            /* Step 1; Create an ArrayList variable of your favorite name and then add all the objects dog1,cat1,s1,i1,d1 */
            ArrayList boppernickel = new ArrayList<>(Arrays.asList(dog1, cat1, s1, i1, d1));

            /* Step 2: print the list you made by just printing System.out.println(listYouMade); */
            System.out.println(boppernickel);

        /* Worked for me.  Easy stuff.
           Q: So why not do this all the time?
           A: Good question.  Try getting the Dog object or the Cat object out of your list.
           It's possible, but you have to know what object your getting out.
           For example if I put a dog at index 0, I could get it out using Dog d2 =  (Dog) (listYouMade.get(0));
        */

            /* Step 3 - Get the dog or the cat and print the name and age*/
            Dog dog1ButGottenOut = (Dog) boppernickel.get(0);
            System.out.println(dog1ButGottenOut.getAge());
            System.out.println(dog1ButGottenOut.getName());

            /* Step 4 - Get the String and print the length */
            String s1ButGottenOut = (String) boppernickel.get(2);
            System.out.println(s1ButGottenOut.length());
        }
    }