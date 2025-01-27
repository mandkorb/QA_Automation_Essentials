package language_basics;

public class Enums {
    // Enum for demonstrating basic operations
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // Enum with additional properties and methods
    public enum Severity {
        LOW(1), MEDIUM(2), HIGH(3), CRITICAL(4);

        private final int level;

        Severity(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }

    // Demonstrates basic enum usage
    public static void enumBasics() {
        Day today = Day.WEDNESDAY;

        // Printing an enum value
        System.out.println("Today is: " + today);

        // Loop through all enum values
        System.out.println("Days of the week:");
        for (Day day : Day.values()) {
            System.out.println(day);
        }
    }

    // Demonstrates enum with properties and methods
    public static void enumWithProperties() {
        Severity severity = Severity.HIGH;

        // Printing enum with property
        System.out.println("Severity: " + severity + ", Level: " + severity.getLevel());

        // Loop through all enum values with their properties
        System.out.println("Severity levels:");
        for (Severity sev : Severity.values()) {
            System.out.println(sev + " (Level " + sev.getLevel() + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enum Basics:");
        enumBasics();

        System.out.println("\nEnum with Properties:");
        enumWithProperties();
    }
}

