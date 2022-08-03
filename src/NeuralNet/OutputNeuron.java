package NeuralNet;

import java.util.ArrayList;

/**
 * 
 * Specialized class for the output neuron, this neuron only has input connections because the
 * outputs will be fed back to the user.
 * 
 * @author Caleb Devon
 * 
 */

public class OutputNeuron extends Neuron{
	
	double value;
	ArrayList<Connection> inputs;
	
	public OutputNeuron(ArrayList<Connection> inputs) {
		super(inputs, true);
		this.inputs = inputs;
		value = super.getValue();
	}
	
	public Connection getIn(int x) {
		return super.getIn(x);
	}
	
	public ArrayList<Connection> getInputs(){
		return super.getInputs();
	}
	
	public double getValue() {
		this.value = super.getValue();
		return super.getValue();
	}
	
	public void addIn(Connection c) {
		super.addInput(c);
	}
	
	public double getOutput() {
		return super.getValue();
	}

}
