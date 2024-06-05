package example.BUDGET;
	import java.util.ArrayList;
	import java.util.Scanner;
	
	enum TransactionType {
	  INCOME, EXPENSE
	}

	class Transaction {
	  String description;
	  double amount;
	  TransactionType type;

	  public Transaction(String description, double amount, TransactionType type) {
	    this.description = description;
	    this.amount = amount;
	    this.type = type;
	  }

	  public String toString() {
	    String typeString = (type == TransactionType.INCOME) ? "Income" : "Expense";
	    return typeString + ": " + description + ": rupees : " + String.format("%.2f", amount);
	  }
	}

	public class CHANDU {

	  public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    ArrayList<Transaction> transactions = new ArrayList<>();

	    while (true) {
	      System.out.println("\nIncome & Expense Tracker");
	      System.out.println("1. Add Income");
	      System.out.println("2. Add Expense");
	      System.out.println("3. View Transactions");
	      System.out.println("4. Exit");
	      System.out.print("Enter your choice: ");

	      int choice = scanner.nextInt();
	      scanner.nextLine();

	      switch (choice) {
	        case 1:
	          addTransaction(scanner, transactions, TransactionType.INCOME);
	          break;
	        case 2:
	          addTransaction(scanner, transactions, TransactionType.EXPENSE);
	          break;
	        case 3:
	          if (transactions.isEmpty()) {
	            System.out.println("No transactions found!");
	          } else {
	            System.out.println("\nYour Transactions:");
	            for (Transaction transaction : transactions) {
	              System.out.println(transaction);
	            }
	          }
	          break;
	        case 4:
	          System.out.println("Exiting Income & Expense Tracker...");
	          scanner.close();
	          System.exit(0);
	        default:
	          System.out.println("Invalid choice!");
	      }
	    }
	  }

	  private static void addTransaction(Scanner scanner, ArrayList<Transaction> transactions, TransactionType type) {
	    System.out.print("Enter transaction description: ");
	    String description = scanner.nextLine();
	    System.out.print("Enter transaction amount: ");
	    double amount = scanner.nextDouble();
	    transactions.add(new Transaction(description, amount, type));
	    System.out.println(type + " added successfully!");
	  }
	}

