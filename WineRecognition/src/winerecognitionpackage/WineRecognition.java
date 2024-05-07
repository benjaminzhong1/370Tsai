import java.io.IOException;
import java.util.List;
package winerecognitionpackage;

public class WineRecognition {

	public static void main(String[] args) {
        try {
            // Load the dataset
            Dataset dataset = new Dataset();
            dataset.loadCSV("temp.csv");
            List<double[]> instances = dataset.getInstances();
            List<Integer> labels = dataset.getLabels();

            // Train a decision tree
            DecisionTree tree = new DecisionTree();
            tree.train(instances, labels, 5, 10);

            // Print the decision tree
            tree.printTree();

            // Make predictions using the decision tree
            double[] testInstance = {1.0, 2.0, 3.0, 4.0}; // Example test instance
            int prediction = tree.predict(testInstance);
            System.out.println("Decision Tree Prediction: " + prediction);

            // Train a random forest
            RandomForest forest = new RandomForest(10); // Create a random forest with 10 trees
            forest.train(instances, labels, 5, 10);

            // Make predictions using the random forest
            List<Integer> forestPredictions = forest.predict(instances);
            System.out.println("Random Forest Predictions: " + forestPredictions);

        } catch (IOException e) {
            System.err.println("Error loading dataset: " + e.getMessage());
        }
    }

}
