import java.io.IOException;
import java.util.Scanner;

public class CalixPad {

    static void Sleep(int MS_TIME){
    try {
      Thread.sleep(MS_TIME);
    } catch (Exception e){
    System.out.println(e);
  }
  }

    static void displayCalculatorUI() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        // ANSI escape codes for text colors
        String pinkColor = "\u001B[1;38;5;161m";
        String pinkColor2 = "\u001B[3;38;5;208m";
        String yellowColor = "\u001B[1;38;5;208m";
        String greenColor = "\u001B[1;38;5;40m";
        String resetColor = "\u001B[0m";

        // Get terminal width
        Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", "tput cols"});
        process.waitFor();
        int terminalWidth = Integer.parseInt(new String(process.getInputStream().readAllBytes()).trim());

        // Get terminal height - line
        Process process2 = Runtime.getRuntime().exec(new String[]{"bash", "-c", "tput lines"});
        process2.waitFor();
        int terminalHeight = Integer.parseInt(new String(process2.getInputStream().readAllBytes()).trim());

        int padding = (terminalWidth + 37) / 2;
        int vertical_padding = (terminalHeight) / 2;

        // Print horizondal line
        System.out.println("\n".repeat(vertical_padding));
        // Print title
        System.out.printf("%-" + padding + "s|", "");
        System.out.printf("%s%-37s%s%s", pinkColor2, "      [Java CLI Calculator App]", resetColor, "|\n");

        // Print top border
        System.out.printf("%-" + padding + "s", "");
        System.out.println("---------------------------------------");

        // Print function UI
        System.out.printf("%-" + padding + "s|", "");
        System.out.printf("%s%-7s%s", pinkColor, "   √", resetColor);
        System.out.print(" | ");
        System.out.printf("%s%-6s%s", pinkColor, "  a²", resetColor);
        System.out.print(" |  ");
        System.out.printf("%s%-6s%s", pinkColor, "  %", resetColor);
        System.out.print(" |  ");
        System.out.printf("%s%-6s%s", pinkColor, "  /", resetColor);
        System.out.println(" |");

        // Print function UI with colored symbols
        System.out.printf("%-" + padding + "s", "");
        System.out.println("---------------------------------------");
        System.out.printf("%-" + padding + "s", "");
        System.out.printf("| %-6s | %-6s |  %-6s |  %s%-6s%s |%n", "  7", "  8", "  9", pinkColor, "  x", resetColor);
        System.out.printf("%-" + padding + "s", "");
        System.out.println("---------------------------------------");
        System.out.printf("%-" + padding + "s", "");
        System.out.printf("| %-6s | %-6s |  %-6s |  %s%-6s%s |%n", "  4", "  5", "  6", pinkColor, "  -", resetColor);
        System.out.printf("%-" + padding + "s", "");
        System.out.println("---------------------------------------");
        System.out.printf("%-" + padding + "s", "");
        System.out.printf("| %-6s | %-6s |  %-6s |  %s%-6s%s |%n", "  1", "  2", "  3", pinkColor, "  +", resetColor);
        System.out.printf("%-" + padding + "s", "");
        System.out.println("---------------------------------------");
        System.out.printf("%-" + padding + "s", "");
        System.out.printf("| %-6s | %-6s |  %s%-6s%s |  %s%-6s%s |%n", "  0", "  .", greenColor, "  C", resetColor, yellowColor, "  =", resetColor);
        System.out.printf("%-" + padding + "s", "");
        System.out.println("---------------------------------------");

        // Get user input
        System.out.printf("%-" + padding + "s", "");
        System.out.print("|> ");
        String userInput = scanner.nextLine();
        // Pass the values to the math class 
        long results = mathfunction(userInput);
        System.out.printf("%-" + padding + "s", "");
        System.out.print("[> " + results);

        System.out.printf("%n%-" + padding + "s", "");
        System.out.println("---------------------------------------");
  }

  static long mathfunction(String userInput){
    // Algoritham
    // Once you get the userInput then split it into 2 parts using its delimeter
    // create 2 variables num_1 and num_2 and assign first half to 1 and second half 2
    // Now do the arthemetic operation and put the result in a result var nd return it
    // Implement try cache and see if operator not in userInput then throw error
    String rmWhiteSpaces = userInput.replaceAll("\\s", ""); // 
    // System.out.println("Removed White Spaces: " + rmWhiteSpaces);
    String[] numbers = rmWhiteSpaces.split("[+\\-*/%]");

    int num_1 = Integer.parseInt(numbers[0]);
    int num_2 = Integer.parseInt(numbers[1]);
    long result = 0;

    try {
      char operator = userInput.charAt(userInput.indexOf(numbers[1]) - 1);
      // System.out.println(operator);
 
      switch (operator) {
        case '+':
          result = num_1 + num_2;
          break;
        case '-':
          result = num_1 - num_2;
          break;
        case '*':
          result = num_1 * num_2;
          break;
        case '/':
          if (num_2 == 0) {
            throw new ArithmeticException ("Division by 0 not possible!!");
          }
          result = num_1 / num_2;
          break;
        case '%':
          result = num_1 % num_2;
          break;
        case '^':
          result = num_1 * num_1;
          break;
        default:
          throw new IllegalArgumentException ("Get a life!! ;) [" + operator + "] Not allowed");
      }
    } catch (Exception e){
      System.out.println(e);
    }
    return result;
  }

    public static void main(String[] args) throws IOException, InterruptedException {
    while (true) {
        System.out.print("\033c");
        displayCalculatorUI();
        Sleep(5000);
    }
    }
}
