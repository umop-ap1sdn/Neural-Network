package NeuralNet;

//Don't mess with this class

public class NetworkBuilder {

	protected int[] networkSize;
	LayerN[] networkN;
	LayerC[] networkC;
	
	public NetworkBuilder(int[] networkSize) {
		networkN = new LayerN[networkSize.length];
		networkC = new LayerC[networkSize.length - 1];
		
		int size = networkSize.length;
		
		construct1(networkSize, size);
		construct2(networkSize, size - 1);
	}
	
	public void construct1(int[] size, int length) {
		
		networkN[0] = new InputLayer(new InputNeuron[size[0]]);
		networkN[length - 1] = new OutputLayer(new OutputNeuron[size[length - 1]]);
		
		for(int x = 1; x < length - 1; x++) {
			networkN[x] = new HiddenLayer(new HiddenNeuron[size[x]]);
		}
	}
	
	public void construct2(int[] size, int length) {
		for(int x = 0; x < length; x++) {
			networkC[x] = new LayerC(size[x] + 1, size[x + 1], networkN[x], networkN[x + 1]);
			
		}
	}
	
	public LayerN[] getNetworkN() {
		return this.networkN;
	}
	
	public LayerC[] getNetworkC() {
		return this.networkC;
	}
}
