package NeuralNet;

import java.util.ArrayList;

/**
 * Specialized class for the Hidden Neurons, these will have both inputs and outputs
 * 
 * @author Caleb Devon
 *
 */

public class HiddenNeuron extends Neuron{
	
	protected double value;
	public ArrayList<Connection> inputs;
	public ArrayList<Connection> outputs;
	
	public HiddenNeuron(ArrayList<Connection> inputs, ArrayList<Connection> outputs) {
		super(inputs, outputs);
		this.value = super.getValue();
		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	public Connection getIn(int x) {
		return super.getIn(x);
	}
	
	public ArrayList<Connection> getInputs(){
		return super.getInputs();
	}
	
	public Connection getOut(int x) {
		return super.getOut(x);
	}
	
	public ArrayList<Connection> getOutputs(){
		return super.getOutputs();
	}
	
	public double getValue() {
		this.value = super.getValue();
		return super.getValue();
	}
	
	public void addOut(Connection c) {
		super.addOutput(c);
	}
	
	public void addIn(Connection c) {
		super.addInput(c);
	}
}
