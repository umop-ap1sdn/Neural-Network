package NeuralNet;

/******
 * 
 * A Neural Network is among the most popular learning models which incorporates a forward pass 
 * and backpropagation. The forward pass is fairly simple; for each neuron in the layer forward
 * from the active layer, its value is calculated by adding the multiplicative value of Neurons 
 * from the active layer and the Connection which attaches the 2 neurons. This process is repeated
 * until each neuron in the active layer has been inputed to the neuron. At the end of this 
 * process the newly valued neuron is passed through a sigmoid function to compress the value to
 * one between 0 and 1.
 *
 * @author Caleb Devon
 * 
 */
public class Network {
	
	public final double LEARNING_RATE = 0.02;
	
	LayerN[] networkN;
	LayerC[] networkC;
	NetworkBuilder constructor;
	
	int nLayers;
	int cLayers;
	
	int[] size;
	
	
	public Network(int... size) {
		this.size = size;
		constructor = new NetworkBuilder(size);
		networkN = constructor.getNetworkN();
		networkC = constructor.getNetworkC();
		
		nLayers = networkN.length;
		cLayers = networkC.length;
	}
	
	public double[] getOutputs() {
		OutputLayer n = (OutputLayer) networkN[nLayers - 1];
		return n.getOutputs();
	}
	
	public void setInputs(double[] inputs) {
		networkN[0].getAsInput().setInputs(inputs);
	}
	
	public void train(double[] inputs, double[] target) {
		if(inputs.length != size[0]) {
			System.out.println("Please make sure input array lengths match network size");
			return;
		}
		
		if(target.length != size[nLayers - 1]) {
			System.out.println("Please make sure output array lengths match network size");
			return;
		}
		
		setInputs(inputs);
		forwardPropagation();
		determineErrors(target);
		backPropagation();
	}
	
	public void test(double[] inputs) {
		if(inputs.length != size[0]) {
			System.out.println("Please make sure array lengths match network size");
			return;
		}
		
		setInputs(inputs);
		forwardPropagation();
	}
	
	public void forwardPropagation() {
		for(int x = 0; x < cLayers; x++) {
			forwardPass(x);
			
		}
	}
	
	public void forwardPass(int layer) {
		for(int x = 0; x < size[layer + 1]; x++) {
			double value = 0.00;
			for(int y = 0; y < size[layer]; y++) {
				Neuron src = networkN[layer].get(y);
				Connection c = networkC[layer].get(y, x);
				
				value += src.getValue() * c.getWeight();
			}
			
			value += networkN[layer].getBias().getValue() * networkC[layer].get(size[layer], x).getWeight();
			double derivValue = sigmoidDeriv(value);
			value = sigmoid(value);
			networkN[layer + 1].get(x).updateValue(value, derivValue);
		}
	}
	
	public void determineErrors(double[] target) {
		int layer = nLayers - 1;
		LayerN layer1 = networkN[layer];
		
		for(int x = 0; x < target.length; x++) {
			double error = (layer1.get(x).getValue() - target[x]) * layer1.get(x).getDeriv();
			layer1.get(x).updateError(error);
		}
		
		multilayerError();
	}
	
	public void multilayerError() {
		for(int x = nLayers - 2; x > 0; x--) {
			LayerN fLayer = networkN[x + 1];
			LayerN layer = networkN[x];
			LayerC connections = networkC[x];
			
			for(int y = 0; y < size[x]; y++) {
				double sum = 0.00;
				for(int z = 0; z < size[x + 1]; z++) {
					sum += (fLayer.get(z).getError() * connections.get(y, z).getWeight());
				}
				
				sum *= layer.get(y).getDeriv();
				layer.get(y).updateError(sum);
			}
		}
	}
	
	public void backPropagation() {
		for(int x = cLayers - 1; x >= 0; x--) {
			for(int z = 0; z < size[x + 1]; z++) {
				for(int y = 0; y < size[x]; y++) {
					double gradient = -1 * LEARNING_RATE * networkN[x].get(y).getValue() * networkN[x + 1].get(z).getError();
					networkC[x].get(y, z).updateWeight(gradient);
				}
				
				double gradient = -1 * LEARNING_RATE * networkN[x + 1].get(z).getError();
				networkC[x].get(size[x], z).updateWeight(gradient);
			}
		}
	}
	
	public double sigmoid(double x) {
		double ret = 1 / (1 + Math.exp(-1 * x));
		return ret;
	}
	
	public double sigmoidDeriv(double x) {
		double ret = sigmoid(x) * (1 - sigmoid(x));
		return ret;
	}
}
