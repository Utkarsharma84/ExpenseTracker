import java.util.Scanner;

class ExpenseTracker {
    private String[] categories;
    private double[] amounts;
    private int size;

    // Constructor
    public ExpenseTracker(int capacity) {
        categories = new String[capacity];
        amounts = new double[capacity];
        size = 0;
    }

    // Add new expense
    public void addExpense(String category, double amount) {
        if (size < categories.length) {
            categories[size] = category;
            amounts[size] = amount;
            size++;
            System.out.println("✅ Expense added successfully!");
        } else {
            System.out.println("❌ Expense list is full!");
        }
    }

    // Show all expenses
    public void showExpenses() {
        if (size == 0) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        System.out.println("\n📜 Expense List:");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + categories[i] + " - ₹" + amounts[i]);
        }
    }

    // Calculate total expenses
    public void totalExpenses() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += amounts[i];
        }
        System.out.println("💰 Total Expenses = ₹" + total);
    }
}

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker(100); // Max 100 entries

        int choice;
        do {
            System.out.println("\n===== Expense Tracker Menu =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Show Expenses");
            System.out.println("3. Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    sc.nextLine(); // consume newline
                    String category = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    tracker.addExpense(category, amount);
                    break;

                case 2:
                    tracker.showExpenses();
                    break;

                case 3:
                    tracker.totalExpenses();
                    break;

                case 4:
                    System.out.println("Exiting... Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
