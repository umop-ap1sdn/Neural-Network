package NeuralNet;

import java.util.ArrayList;

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
