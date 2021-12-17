package NeuralNet;

import java.util.ArrayList;

/***
 * 
 * @author Caleb Devon
 * 
 * The hidden layer is the 2nd of the 3 layer types
 * the hidden layer is by far the most complex layer containing a bias neuron and 
 * both output and input connections.
 *
 */



public class HiddenLayer extends LayerN{
	protected HiddenNeuron[] layer;
	
	//constructor
	public HiddenLayer(HiddenNeuron[] layer) {
		super((Neuron[])layer, true);
		this.layer = construct(layer);
		
	}
	
	
	@Override
	public HiddenNeuron[] construct(Neuron[] layer) {
		for(int x = 0; x < layer.length; x++) {
			layer[x] = new HiddenNeuron(new ArrayList<Connection>(), new ArrayList<Connection>());
		}
		return (HiddenNeuron[])layer;
	}
	
	public BiasNeuron getBias() {
		return super.getBias();
	}
	
	public HiddenNeuron[] getInputs() {
		return (HiddenNeuron[])super.getLayer();
	}
	
	public HiddenNeuron getInput(int x) {
		return (HiddenNeuron)super.get(x);
	}
}
