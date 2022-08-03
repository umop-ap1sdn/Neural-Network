package NeuralNet;

/***
 * 
 * Connections represent the the wire connecting 2 neurons from one layer to the next
 * The area between 2 layers contains a web connecting all neurons from the first layer to all
 * neurons of the next layer<br><br>
 * 
 * The first layer neurons represent the source neurons and the layer it is delivering to will 
 * be the destination neurons<br><br>
 * 
 * Each individual Connection has a particular weight, which is what will be altered by the network
 * algorithm later<br><br>
 * 
 * This weight is randomized at the network's creation and represents how much of the source 
 * neuron's value will be transferred to the next layer
 * 
 * @author Caleb Devon
 *
 */
public class Connection {
	protected double weight;
	Neuron source;
	Neuron destination;
	
	//Made to define the source and destination neuron upon creation
	public Connection(Neuron source, Neuron destination) {
		this.source = source;
		this.destination = destination;
		
		//randomizes the weight upon start
		weight = Math.random();
	}
	
	
	//Getters and Setters
	public Neuron getSource() {
		return this.source;
	}
	
	public Neuron getDest() {
		return this.destination;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void updateWeight(double gradient) {
		this.weight += gradient;
	}
}
