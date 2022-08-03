package NeuralNet;

import java.util.ArrayList;

/**
 * 
 * The Bias neuron is quite simple, its a neuron with a constant value of 1
 * this means it has no connections feeding into it, but it does have outputs
 * The bias can be thought of as the y-intercept in a simple linear equation
 * or the 'b' in y = mx + b.
 * 
 * @author Caleb Devon
 * 
 */


public class BiasNeuron extends Neuron{
	
	//finalizes the value as 1 because it can only be 1
	final double value = 1.00;
	
	//don't need inputs
	ArrayList<Connection> outputs;
	
	//simple constructor
	public BiasNeuron(ArrayList<Connection> outputs) {
		super(outputs, false);
		super.updateValue(this.value);
	}
	
	//getters and setters
	public Connection getOut(int x) {
		return super.getOut(x);
	}
	
	public ArrayList<Connection> getOutputs(){
		return super.getOutputs();
	}
	
	public void addOutput(Connection c) {
		super.addOutput(c);
	}
}
