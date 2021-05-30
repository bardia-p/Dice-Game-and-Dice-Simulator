public class DiceClient {
    public static void main(String[] args){
        int values[] = new int[6];
        for (int i=0; i<6; i++){
            values[i] = 0;
        }
        int sum = 0;
        int rolled[] = new int[3];

        Dice die = new Dice(3);

        for (int i =0; i < 1000; i++){
            sum+=die.roll();
            rolled = die.getDieValues();
            for (int j = 0; j<3; j++){
                values[rolled[j]-1]+=1;
            }
        }

        System.out.println("The average roll was: " + sum/3000.0);
        System.out.println("The histograms of the rolls is: ");

        String s;
        for (int i= 0; i< 6; i++){
            s = "";
            for (int j=0; j<values[i]/10; j++){
                s+="*";
            }
            System.out.println(i + 1+"("+values[i]+")"+s);
        }
    }
}
