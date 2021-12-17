package NeuralNet;

/*****
 * 
 * @author Caleb Devon
 * 
 * Similar to a layer of neurons except that it represents the layers of connections between
 * the Neuron layers
 * 
 * Instead of a 1 Dimensional Array this contains a 2 Dimensional array representing the fact
 * that Connections rely on an input (Source) and output (Destination) Neuron
 * 
 * Notation is fairly simple
 * To get the Desired connection when performing calculations
 * 
 * layer[(Source Neuron index)][(Destination Neuron index)] will get you the Connection between
 * the Chosen Source and Chosen Destination Neuron
 *
 */
public class LayerC {
	protected Connection[][] layer;
	
	
	//constructor used for instantiating variables to avoid a possible null exception
	//in the future
	
	//Parameters display the size of the inputs and outputs, and gives the necessary
	//variables to form the connections between layers of neurons
	public LayerC(int srcSize, int destSize, LayerN source, LayerN dest) {
		
		layer = new Connection[srcSize][destSize];
		for(int y = 0; y < destSize; y++) {
			for(int x = 0; x < srcSize - 1; x++) {
				Connection c = new Connection(source.get(x), dest.get(y));
				layer[x][y] = c;
				source.get(x).addOutput(c);
				dest.get(y).addInput(c);
				
			}
			
			Connection c = new Connection(source.getBias(), dest.get(y));
			layer[srcSize - 1][y] = c;
			source.getBias().addOutput(c);
			dest.get(y).addInput(c);
			
		}
	}
	
	
	//getters
	public Connection get(int src, int dest) {
		return this.layer[src][dest];
	}
	
	public Connection[][] getLayer() {
		return this.layer;
	}
	

	
}
