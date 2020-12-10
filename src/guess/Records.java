package guess;

public class Records {
    public static void main(String[] args) {
        String heading1 = "userName";
        String heading2 = "Attempts";
        String heading3 = "Duration";
        String divider = "__________________________";

        String name1 = "setName1";
        String name2 = "setName2";
        String name3 = "setName3";
        String name4 = "setName4";
        String name5 = "setName5";

        String Attempt1 = "setAttempts1";
        String Attempt2 = "setAttempts2";
        String Attempt3 = "setAttempts3";
        String Attempt4 = "setAttempts4";
        String Attempt5 = "setAttempts5";

        String Duration1 = "setDuration1";
        String Duration2 = "setDuration2";
        String Duration3 = "setDuration3";
        String Duration4 = "setDuration";
        String Duration5 = "setDuration5";

        System.out.println("");
        System.out.printf("%s %d %d %n", heading1, heading2, heading3);
        System.out.println(divider);

        System.out.printf("%s %d %d %n, name1, Attempt1, Duration1");
        System.out.printf("%s %d %d %n, name2, Attempt2, Duration2");
        System.out.printf("%s %d %d %n, name3, Attempt3, Duration3");
        System.out.printf("%s %d %d %n, name4, Attempt4, Duration4");
        System.out.printf("%s %d %d %n, name5, Attempt5, Duration5");


        System.out.println(divider);
        System.out.println("");
    }
}
