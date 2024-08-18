import java.util.*;
public class P_32_No_Of_Lattice_Points_Inside_Circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int points = 0;
        for(int i = r-1;i>=0;i--){
            int linePoints = (int)Math.sqrt(Math.pow(r,2)-Math.pow(i,2));
            points += linePoints;
        }
        int totalPoints = 4*points+1;
        System.out.println(totalPoints);
    }
}