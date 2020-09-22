import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculations { //Can't solve for x + 10 = 30 yet, need to be able to find the 1 in front of x without needing to put a 1

    public static ArrayList<Integer> getNums(String equation) {

        ArrayList<Integer> nums = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < equation.length(); i++) {

            if (equation.charAt(i) == '^') {

                i += 2;

            }

            if (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '-') {

                StringBuilder stringBuilder = new StringBuilder();

                if (equation.charAt(i) == '-' && Character.isDigit(equation.charAt(i + 2)) && !Character.isDigit(equation.charAt(i + 1))) {

                    stringBuilder.append(equation.substring(i, i + 1));
                    i += 2;

                }

                while (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '-') {

                    stringBuilder.append(equation.substring(i, i + 1));
                    if (i != equation.length() - 1) {

                        i++;

                    }

                    else {

                        temp++;
                        if (temp == 1) {

                            break;

                        }

                    }

                }
                nums.add(Integer.parseInt(stringBuilder.toString()));

            }

        }

        return nums;

    }

    public static double solveLinearEquation(ArrayList<Integer> nums) {

        return (double)(nums.get(2) - nums.get(1)) / nums.get(0);

    }

    public static ArrayList<Double> solveQuadraticEquation(ArrayList<Integer> nums) {

        nums.add(nums.get(2) - nums.get(3));

        ArrayList<Double> answers = new ArrayList<>();
        double quadraticAnswer = (-(nums.get(1)) + Math.sqrt((nums.get(1)*nums.get(1)) - 4*(nums.get(0))*(nums.get(4)))) / 2*(nums.get(0));
        double quadraticAnswer2 = (-(nums.get(1)) - Math.sqrt((nums.get(1)*nums.get(1)) - 4*(nums.get(0))*(nums.get(4)))) / 2*(nums.get(0));
        answers.add(quadraticAnswer);
        answers.add(quadraticAnswer2);

        return answers;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String equation = scan.nextLine();
        ArrayList<Integer> nums = getNums(equation);

        if (nums.size() == 3) {

            System.out.println("X is: " + solveLinearEquation(nums));

        }

        else if (nums.size() == 4) {

            ArrayList<Double> answers = solveQuadraticEquation(nums);

            if (!Double.toString(answers.get(0)).equals("NaN") && !Double.toString(answers.get(1)).equals("NaN")) {

                System.out.println("X can be " + answers.get(0) + " or " + answers.get(1));

            }

            else if (!Double.toString(answers.get(0)).equals("NaN")) {

                System.out.println("X is " + answers.get(0));

            }

            else if (!Double.toString(answers.get(1)).equals("NaN")) {

                System.out.println("X is " + answers.get(1));

            }

            else {

                System.out.println("X is not a real number");

            }

        }

    }

}
