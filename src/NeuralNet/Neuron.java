package NeuralNet;

import java.util.ArrayList;


/****
 * 
 * 
 * A Neuron is the most basic interface of the neural network, it's primary job is to store a value
 * in the network which it will then pass to next layers in the future.<br>
 * There are 4 types of Neurons: Input, Hidden, Output, and Bias Neurons<br><br>
 * 
 * Input Neurons are the values that are determined by the user and are set at the beginning of 
 * each test. They are responsible for sending outputs to the next layer<br><br>
 * 
 * Output Neurons represent the final step of the Network the values that these neurons yield 
 * represent the output of the entire network. These neurons will only recieve inputs from the 
 * previous layer<br><br>
 * 
 * Hidden Neurons are the step(s) between Input and Output. There can be any number of Hidden
 * Neurons and any number of sets of Hidden Neurons, or none at all. They are primarily used
 * to assist the calculations from input to output. These neurons both recieve an input from the 
 * previous layer, AND output their value to the next layer<br><br>
 * 
 * Lastly Bias Neurons represent the offset; they can be thought of as "b" in the y = mx + b
 * equation. They are not usually required but highly recommended. There are typically one of these
 * neurons in every layer except for the output. Unlike most neurons which values are a double 
 * between 0 and 1, Bias Neurons always contain a value of 1.<br><br>
 * 
 * A Neuron sends and receives data via connections, which can input into the Neuron or Output from
 * the neuron. If a Neuron has no need to receive or send data it will not have those Connections
 * (ex. An input Neuron does not receive data from any previous layer, so it will not have any 
 * inputs)
 * 
 * @author Caleb Devon
 *
 */
public abstract class Neuron {
	protected double value;
	protected double derivValue;
	protected double error;
	public ArrayList<Connection> inputs;
	public ArrayList<Connection> outputs;
	
	//This constructor is for hidden neurons which have both inputs and outputs
	public Neuron(ArrayList<Connection> inputs, ArrayList<Connection> outputs) {
		value = 0.0;
		derivValue = 0.0;
		error = 0.0;
		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	//This constructor is for the outhers which will only have one or the other
	//The boolean input is there to distinguish whether the type of connections will be inputs
	//or outputs
	public Neuron(ArrayList<Connection> inoutputs, boolean input) {
		if(input) inputs = inoutputs;
		else outputs = inoutputs;
	}
	
	
	//Getters and Setters
	
	public ArrayList<Connection> getInputs(){
		return this.inputs;
	}
	
	public ArrayList<Connection> getOutputs(){
		return this.outputs;
	}
	
	//Simpler getter
	public Connection getIn(int x) {
		return inputs.get(x);
	}
	
	public Connection getOut(int x) {
		return outputs.get(x);
	}
	
	public double getValue() {
		return value;
	}
	
	public double getDeriv() {
		return derivValue;
	}
	
	public double getError() {
		return error;
	}
	
	public void updateValue(double value, double derivValue) {
		this.value = value;
		this.derivValue = derivValue;
	}
	
	public void updateValue(double value) {
		this.value = value;
	}
	
	public void updateError(double error) {
		this.error = error;
	}
	
	public void addInput(Connection c) {
		inputs.add(c);
	}
	
	public void addOutput(Connection c) {
		outputs.add(c);
	}
}
