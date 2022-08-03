package NeuralNet;

import java.util.ArrayList;

/**
 * The OutputLayer is a subset of a Neuron Layer which deals with outputs. <br>
 * This is the final layer of the Neural Network where values are sent back to the User.
 * @author Caleb Devon
 *
 */

public class OutputLayer extends LayerN{
	protected OutputNeuron[] layer;
	
	public OutputLayer(OutputNeuron[] layer) {
		super((Neuron[])layer, false);
		this.layer = construct(layer);
		
	}
	
	@Override
	public OutputNeuron[] construct(Neuron[] layer) {
		for(int x = 0; x < layer.length; x++) {
			layer[x] = new OutputNeuron(new ArrayList<Connection>());
		}
		return (OutputNeuron[])layer;
	}
	
	public OutputNeuron[] getInputs() {
		return (OutputNeuron[])super.getLayer();
	}
	
	public OutputNeuron getInput(int x) {
		return (OutputNeuron)super.get(x);
	}
	
	public double[] getOutputs() {
		double[] ret = new double[layer.length];
		for(int x = 0; x < layer.length; x++) {
			ret[x] = layer[x].getOutput();
		}
		
		return ret;
	}
}
