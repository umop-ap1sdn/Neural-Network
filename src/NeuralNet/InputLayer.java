package NeuralNet;

import java.util.ArrayList;

/**
 * 
 * Specialized class for the input layer of neurons<br>
 * This layer will receive user-specified inputs and therefore will not need 
 * input connections.
 * Instead their values will be determined by the "setInputs" method.
 * 
 * @author Caleb Devon
 *
 */

public class InputLayer extends LayerN{
	protected InputNeuron[] layer;
	
	public InputLayer(InputNeuron[] layer) {
		super((Neuron[])layer, true);
		this.layer = construct(layer);
		
	}
	
	@Override
	public InputNeuron[] construct(Neuron[] layer) {
		for(int x = 0; x < layer.length; x++) {
			layer[x] = new InputNeuron(new ArrayList<Connection>());
		}
		return (InputNeuron[])layer;
	}
	
	public BiasNeuron getBias() {
		return super.getBias();
	}
	
	public InputNeuron[] getInputs() {
		return (InputNeuron[])super.getLayer();
	}
	
	public InputNeuron getInput(int x) {
		return (InputNeuron)super.get(x);
	}
	
	public void setInputs(double[] inputs) {
		super.setValues(inputs);
	}
}
