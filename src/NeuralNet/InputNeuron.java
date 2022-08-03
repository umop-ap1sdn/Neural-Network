package NeuralNet;

import java.util.ArrayList;

/**
 * Specialized class for inputs
 * Reminder the values of these Neurons will have to be set by hand as they are the first 
 * layer of the network
 * 
 * @author Caleb Devon
 *
 */

public class InputNeuron extends Neuron{
	double value;
	ArrayList<Connection> outputs;
	
	public InputNeuron(ArrayList<Connection> outputs) {
		super(outputs, false);
		this.outputs = outputs;
		value = super.getValue();
	}
	
	public void setInput(double x) {
		super.updateValue(x);
	}
	
	public Connection getOut(int x) {
		return super.getOut(x);
	}
	
	public ArrayList<Connection> getOutputs(){
		return super.getOutputs();
	}
	
	public void addOut(Connection c) {
		super.addOutput(c);
	}

}
