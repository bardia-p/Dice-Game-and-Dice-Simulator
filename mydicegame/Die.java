package mydicegame;

import java.util.Random;
import java.util.Date;


/**
 * This class is used to simulate the behaviour of a simple die
 * @author Bardia Parmoun - 101143006
 */
public class Die {
    /**
	 * Keeps track of the number of sides of the die
	 */
	private int numberOfSides;
	
	/**
	 * Keeps track of the random variable
	 */
	private Random random;

	/**
	 * The default constructor for the die which sets its number of sides to 6
	 */
	public Die (){
		this(6);
	}
	
	/**
	 * Creates a die with the given number of sides
	 * @param numbSides keeps track of the number of the sides of the die
	 */
	public Die (int numSides){
		this.numberOfSides = numSides;
		this.random = new Random(new Date().hashCode());
	}
	
	/**
	 * Rolls the dice and finds a value from 1 to numberOfSides
	 * @return the result of the die roll
	 */
	public int roll(){
        return this.random.nextInt(numberOfSides)+1;
    }
}
