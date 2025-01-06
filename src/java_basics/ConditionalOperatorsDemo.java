package java_basics;

public class ConditionalOperatorsDemo {
    // Method to demonstrate the if-else operator
    public void ifElseDemo(int number) {
        if (number > 0) {
            System.out.println("The number " + number + " is positive.");
        } else if (number < 0) {
            System.out.println("The number " + number + " is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }

    // Method to demonstrate the switch-case operator
    public void switchCaseDemo(String day) {
        switch (day.toLowerCase()) {
            case "monday":
                System.out.println("It's Monday, the start of the week.");
                break;
            case "friday":
                System.out.println("It's Friday, almost the weekend.");
                break;
            case "sunday":
                System.out.println("It's Sunday, a day of rest.");
                break;
            default:
                System.out.println("It's a regular day.");
        }
    }

    // Method to demonstrate the ternary operator
    public void ternaryOperatorDemo(int age) {
        String category = (age < 18) ? "Minor" : "Adult";
        System.out.println("Age: " + age + " - Category: " + category);
    }

    // Method to demonstrate logical operators
    public void logicalOperatorsDemo(boolean hasJob, boolean hasSavings) {
        if (hasJob && hasSavings) {
            System.out.println("Financially stable.");
        } else if (hasJob || hasSavings) {
            System.out.println("Has potential for financial stability.");
        } else {
            System.out.println("Financially unstable.");
        }
    }

    public static void main(String[] args) {
        // Creating ConditionalOperatorsDemo object
        ConditionalOperatorsDemo demo = new ConditionalOperatorsDemo();

        // Demonstrating the if-else operator
        System.out.println("Demonstration of if-else operator:");
        demo.ifElseDemo(5);
        demo.ifElseDemo(-3);
        demo.ifElseDemo(0);

        // Demonstrating the switch-case operator
        System.out.println("\nDemonstration of switch-case operator:");
        demo.switchCaseDemo("Monday");
        demo.switchCaseDemo("Friday");
        demo.switchCaseDemo("Wednesday");

        // Demonstrating the ternary operator
        System.out.println("\nDemonstration of ternary operator:");
        demo.ternaryOperatorDemo(16);
        demo.ternaryOperatorDemo(21);

        // Demonstrating logical operators
        System.out.println("\nDemonstration of logical operators:");
        demo.logicalOperatorsDemo(true, true);
        demo.logicalOperatorsDemo(true, false);
        demo.logicalOperatorsDemo(false, false);
    }
}
