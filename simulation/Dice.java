import java.util.Random;
import java.util.Date;


public class Dice {
    private int die[];
    private Random random;

    public Dice(){
        die = new int[2];
        this.random = new Random(new Date().hashCode());
    }

    public Dice (int n){
        die = new int[n];
        this.random = new Random(new Date().hashCode());
    }

    private int rollDice(){
        return this.random.nextInt(6)+1;
    }

    public int roll(){
        int sum = 0;
        for (int i =0; i<die.length; i++){
            die[i] = rollDice();
            sum+=die[i];
        }
        return sum;
    }

    public int[] getDieValues(){
        return die;
    }

    public String toString(){
        String s = "";
        for (int i=0; i < die.length; i++){
            s += Integer.toString(die[i]);
        }
        return s;
    }

    public boolean hasDoubles(){
        int values[] = new int[6];
        for (int i=0; i<6; i++){
            values[i] = 0;
        }

        for (int j =0; j<die.length; j++){
            values[j]+=1;
            if (values[j]>1){
                return true;
            }
        }
        return false;
    }
}
