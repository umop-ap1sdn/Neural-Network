package NeuralNet;

import java.util.ArrayList;

/*******
 * 
 * @author Caleb Devon
 * 
 * A Layer represents the organized list of Neurons in each category
 * A layer comes with a Neuron array to keep the entire network in an organized pattern
 * It also contains the Bias Neuron unless it is an output layer
 *
 */

public abstract class LayerN {
	protected Neuron[] layer;
	
	//The difference between the layer and layerBias is that the layerBias is the layer but includes the bias neuron
	
	protected Neuron[] layerBias;
	
	//Output layer will not need a bias and constructor is made to reflect that
	public LayerN(Neuron[] layer, boolean bias) {
		this.layer = layer;
		this.layer = construct(layer);
		
		 if(bias) {
		 
			layerBias = new Neuron[layer.length + 1];
			prepareBias();
			
			
		}
		
	}
	
	//Method to properly initialize the layer
	public abstract Neuron[] construct(Neuron[] layer);
	
	//Properly initialize the bias
	public void prepareBias() {
		for(int x = 0; x < layer.length; x++) {
			layerBias[x] = layer[x];
		}
		layerBias[layer.length] = new BiasNeuron(new ArrayList<Connection>());
	}
	
	//Getters and Setters
	public Neuron get(int x) {
		return layer[x];
	}
	
	public BiasNeuron getBias() {
		return (BiasNeuron) layerBias[layer.length];
	}
	
	public Neuron[] getLayer() {
		return this.layer;
	}
	
	public Neuron[] getLayerBias() {
		return this.layerBias;
	}
	
	public void setValues(double[] values) {
		if(values.length == layer.length) {
			for(int x = 0; x < values.length; x++) {
				layer[x].updateValue(values[x]);
			}
		} else {
			System.out.println("Please ensure that the number of inputs equals the number of input neurons");
		}
	}
	
	//Important for using the setValues as it ensures that it will recognize the values as the 
	//input of the network
	public InputLayer getAsInput() {
		return (InputLayer) this;
	}
}
