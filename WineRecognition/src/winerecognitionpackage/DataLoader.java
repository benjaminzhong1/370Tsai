package winerecognitionpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    private List<double[]> instances;
    private List<Integer> labels;

    // Constructor
    public Dataset() {
        this.instances = new ArrayList<>();
        this.labels = new ArrayList<>();
    }

    // Method to load data from a CSV file
    public void loadCSV(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double[] instance = new double[values.length - 1];
                for (int i = 0; i < instance.length; i++) {
                    instance[i] = Double.parseDouble(values[i]);
                }
                int label = Integer.parseInt(values[values.length - 1]);
                instances.add(instance);
                labels.add(label);
            }
        }
    }

    // Getters
    public List<double[]> getInstances() {
        return instances;
    }

    public List<Integer> getLabels() {
        return labels;
    }
}