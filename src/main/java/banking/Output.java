package banking;


import java.util.ArrayList;
import java.util.List;
public class Output {

    private List<String> outputList;

    public Output() {
        this.outputList = new ArrayList<>();
    }

    public void addOutput(String output) {
        outputList.add(output);
    }

    public List<String> getOutputList() {
        return outputList;
    }


}
