import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


/** In this class, he finds m arrangements of queens on the chessboard so that they do not threaten each other.
 * @author Agafonov Vladislav
 *
 */
public class Queen {
    /** Is there a queen in the same column, true means there is */
    private final boolean[] column;
     /** Is there a queen from above from right to left from below */
    private final boolean[] rup;
     /** There is a queen from above from left to right from below */
    private final boolean[] lup;
     /** an array of the response in which the element number is a row, and the value of this element is a column */
    private final int[] queen;
     /** solution number */
    private int num;

    static int m;

    /** The start point of the program, where the number m is entered.
     * @param args
     */
    public static void main(String[] args) {
        Queen queen = new Queen();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число M расстановок: ");
        m = in.nextInt();
        if (m > 92) System.out.println("Максимум расстановок - 92");
        queen.queenPosition(1);
    }

    /** Arrays are created in this constructor.
     *
     */
    public Queen() {
        column = new boolean[9];
        rup = new boolean[17];
        lup = new boolean[17];
        queen = new int[9];
    }

    /** This method is responsible for finding possible locations of queens on the chessboard. After
     finding a possible option is rendered in the method and the recursive search for solutions continues.
     * @param i - line number for setting the queen.
     */
    public void queenPosition(int i) {
        if (i > 8 && m > num) paint();
         else {
            for (int j = 1; j <= 8; j++) {
                // Checking that there is no queen
                if (!column[j] && !rup[i+j] && !lup[i-j+8]) {

                    // sets the queen in this i -row, and in the j - column
                    queen[i] = j;

                    column[j] = rup[i+j] = lup[i-j+8] = true;
                    queenPosition(i+1);

                    column[j] = rup[i+j] = lup[i-j+8] = false;
                }
            }
        }
    }

    /** This method is responsible for drawing the queen arrangements
     *
     */
    void paint() {
            num++;
            System.out.println("\nРасстановка № " + num);
            // y - строка
            // x - столбец
            // номер элемента в массиве это строка, а значение этого элемента это столбец
            for (int y = 1; y <= 8; y++) {
                for (int x = 1; x <= 8; x++) {
                    if (queen[y] == x) System.out.print("|Ф");
                    else System.out.print("| ");
                }
                System.out.println("|");
            }
    }

}