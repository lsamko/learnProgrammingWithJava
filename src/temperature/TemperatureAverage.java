package temperature;

import java.util.ArrayList;
import java.util.List;


public class TemperatureAverage {
    public static void main(String[] args) {
        List<Integer> recordedTemperaturesInDegreesCelcius = new ArrayList<Integer>();
        for (String stringRepresentationOfTemperature : args) {
            int temperature = Integer.parseInt(stringRepresentationOfTemperature);
            recordedTemperaturesInDegreesCelcius.add(temperature);
        }

        if (recordedTemperaturesInDegreesCelcius.size() == 0) {
            System.out.println("Exception by ZERO!");
        } else {

            int averageTemperature = SimpleMath.calculateAverage(recordedTemperaturesInDegreesCelcius);
            System.out.println("The average temperature is " + averageTemperature);
        }
    }
}
