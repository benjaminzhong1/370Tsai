package winerecognitionpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomForest {
    private List<DecisionTree> trees;
    private int numTrees;

    // Constructor
    public RandomForest(int numTrees) {
        this.numTrees = numTrees;
        this.trees = new ArrayList<>();
    }

    // Method to train the random forest
    public void train(List<double[]> instances, List<Integer> labels, int numFeatures, int maxDepth) {
        for (int i = 0; i < numTrees; i++) {
            List<double[]> bootstrapSample = generateBootstrapSample(instances);
            DecisionTree tree = new DecisionTree();
            tree.train(bootstrapSample, labels, numFeatures, maxDepth);
            trees.add(tree);
        }
    }

    // Method to make predictions using the random forest
    public List<Integer> predict(List<double[]> instances) {
        List<Integer> predictions = new ArrayList<>();
        for (double[] instance : instances) {
            int avgPrediction = 0;
            for (DecisionTree tree : trees) {
                avgPrediction += tree.predict(instance);
            }
            avgPrediction /= numTrees;
            predictions.add(avgPrediction);
        }
        return predictions;
    }

    // Method to generate a bootstrap sample from the dataset
    private List<double[]> generateBootstrapSample(List<double[]> instances) {
        Random random = new Random();
        List<double[]> bootstrapSample = new ArrayList<>();
        for (int i = 0; i < instances.size(); i++) {
            int index = random.nextInt(instances.size());
            bootstrapSample.add(instances.get(index));
        }
        return bootstrapSample;
    }
}