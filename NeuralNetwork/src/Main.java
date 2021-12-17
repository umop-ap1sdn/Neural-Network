import java.util.Arrays;

import NeuralNet.Network;

public class Main {

	public static void main(String[] args) {
		
		double[][][] trainingData = prepareTraining();
		
		Network ai = new Network(new int[]{4, 11, 29, 16});
		//double[] inputs = {1.0, 0.0};
		//double[] target = {0.0, 1.0, 0.0};
		
		double[][] trainInputs = produceDataset(15);
		double[][] trainOut = getDecimal(trainInputs);
		for(int x = 0; x < 50000; x++) {
			for(int y = 0; y < trainInputs.length; y++) {
				double[] inputs = trainInputs[y];
				double[] target = trainOut[y];
				ai.train(inputs, target);
				
				//System.out.println(Arrays.toString(ai.getOutputs()));
			}
		}
		
		//double[][] testInputs = produceDataset(15);
		//double[][] testOut = getDecimal(testInputs);
		
		for(int y = 0; y < trainingData.length; y++) {
			double[] inputs = trainingData[y][0];
			double[] targets = trainingData[y][1];
			ai.test(inputs);
			
			double[] outputs = ai.getOutputs();
			
			int index = largestPoint(outputs);
			int indexT = largestPoint(targets);
			
			
			System.out.println(Arrays.toString(inputs) + " " + indexT);
			System.out.printf("%d %1.2f%n", index, outputs[index]);
			
		}
		
		
	}
	
	public static int largestPoint(double[] outputs) {
		double largestNum = 0;
		int index = 0;
		
		for(int x = 0; x < outputs.length; x++) {
			if(outputs[x] > largestNum) {
				largestNum = outputs[x];
				index = x;
			}
		}
		
		return index;
	}
	
	public static double[][][] prepareTraining(){
		double[][][] trainingData = new double[16][2][];
		
		double[] binary = new double[4];
		//double[] decimal = new double[trainingData.length];
		
		for(int x = 0; x < trainingData.length; x++) {
			binary = new double[4];
			
			for(int y = 0; y < binary.length; y++) {
				binary[y] = Math.round(Math.random());
			}
			trainingData[x][0] = binary;
			
		}
		
		double[][] binary2d = new double[trainingData.length][binary.length];
		
		
		
		for(int x = 0; x < binary2d.length; x++) {
			
			binary2d[x] = trainingData[x][0]; 
		}
		
		double[][] decimal2d = getDecimal(binary2d);
		
		for(int x = 0; x < decimal2d.length; x++) {
			trainingData[x][1] = decimal2d[x];
		}
		
		return trainingData;
	}
	
	public static double[][] getDecimal(double[][] binary) {
		double[] values = new double[binary.length];
		
		
		for(int x = 0; x < binary.length; x++) {
			double sum = 0;
			for(int y = 0; y < binary[x].length; y++) {
				int inverse = binary[x].length - (y + 1);
				sum += Math.pow(2, inverse) * binary[x][y];
			}
			
			values[x] = sum;
		}
		
		int max = 0;
		for(int x = 0; x < binary[0].length; x++) {
			max += Math.pow(2, x);
		}
		max++;
		
		double[][] decimal = new double[values.length][max];
				
		for(int x = 0; x < values.length; x++) {
			int val = (int)values[x];
			for(int y = 0; y < max; y++) {
				if(y == val) decimal[x][y] = 1;
				else decimal[x][y] = 0;
			}
			
		}
		
		return decimal;
	}
	
	public static double[][] produceDataset(int count){
		int size = 0;
		int count1 = count;
		while(count1 > 0) {
			count1 /= 2;
			size++;
		}
		
		double[][] binary = new double[count + 1][size];
		
		for(int x = 0; x <= count; x++) {
			count1 = x;
			
			
			for(int y = 0; y < size; y++) {
				int start = size - (y + 1);
				binary[x][start] = count1 % 2;
				count1 -= count1 % 2;
				count1 /= 2;
				
			}
		}
		
		return binary;
	}
	
	

}
