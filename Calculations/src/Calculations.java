import java.util.ArrayList;

public class Calculations {

    public static ArrayList<Integer> getNums(String equation) {

        //Create an array list to hold nums
        ArrayList<Integer> nums = new ArrayList<>();

        //Loops through the string to get all the numbers
        int temp = 0;
        for (int i = 0; i < equation.length(); i++) {

            if (equation.charAt(i) == '^') {

                i += 2;

            }

            if (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '-') {

                StringBuilder numGetter = new StringBuilder();

                if (equation.charAt(i) == '-' && Character.isDigit(equation.charAt(i + 2)) && !Character.isDigit(equation.charAt(i + 1))) {

                    numGetter.append(equation.charAt(i));
                    i += 2;

                }

                while (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '-') {

                    numGetter.append(equation.charAt(i));

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
                nums.add(Integer.parseInt(numGetter.toString()));

            }

        }

        return nums;

    }

    public static int solveLinearX(String equation) {

        ArrayList<Integer> nums = getNums(equation);

        //Formula is x = (c - b) / a
        return (nums.get(2) - nums.get(1)) / nums.get(0);

    }

    public static String solveQuadraticX(String equation) {

        //Make an array list to hold the numbers and move 'd' over to make the equation equal to zero
        ArrayList<Integer> nums = getNums(equation);
        nums.add(nums.get(2) - nums.get(3));

        //Make an array list to hold the possible two quadratic answers
        ArrayList<Double> answers = new ArrayList<>();

        //Formula is x = (-b ± √(b² - 4ac)) / 2a
        answers.add((-(nums.get(1)) + Math.sqrt(sqr(nums.get(1)) - 4 * nums.get(0) * nums.get(4))) / 2 * (nums.get(0)));
        answers.add((-(nums.get(1)) - Math.sqrt(sqr(nums.get(1)) - 4 * nums.get(0) * nums.get(4))) / 2 * (nums.get(0)));

        //Check if there are two answers or one answer or no answers
        if (!answers.get(0).toString().equals("NaN") && !answers.get(1).toString().equals("NaN")) {

            return answers.get(0) + " and " + answers.get(1);

        }

        else if (!answers.get(0).toString().equals("NaN")) {

            return answers.get(0).toString();

        }

        else if (!answers.get(1).toString().equals("NaN")) {

            return answers.get(1).toString();

        }

        else {

            return "not a real number";

        }

    }

    public static double sqr(int a) {

        return a*a;

    }

    public static double solvePythagoras(String equation) {

        //Create an array list to hold nums and find the length and height differences of the two points
        ArrayList<Integer> nums = getNums(equation);
        int l = Math.abs(nums.get(0) - nums.get(2));
        int h = Math.abs(nums.get(1) - nums.get(3));

        //Formula is: c = √(a² + b²)
        return Math.sqrt(sqr(l) + sqr(h));

    }

    public static double solveTrigonometry(String equation) {

        //Create an array list to hold nums and find the length and height differences of the two points
        ArrayList<Integer> nums = getNums(equation);
        double l = Math.toRadians(Math.abs(nums.get(0) - nums.get(2)));
        double h = Math.toRadians(Math.abs(nums.get(1) - nums.get(3)));

        return Math.toDegrees(Math.atan(h / l));

    }

    public static void main(String[] args) {

        System.out.println("X for linear is: " + solveLinearX("5x + 20 = 30"));
        System.out.println("X for quadratic is: " + solveQuadraticX("-7x^2 + 2x + 16 = 7"));
        System.out.println("The distance between the two points is: " + solvePythagoras("(1, 1) (6, 4)"));
        System.out.println("The angle between the two points (from the lowest point) is: " + solveTrigonometry("(1, 1) (6, 4)"));

    }

}
