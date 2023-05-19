public class offer {

    private String nameOfOffer;
    private String numberOfOffer;
    private Double input;
    private String ref;
    private String description;
    private Double output;
    private String DateOffer;
    private String currency;



    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public Double getInput() {
        return input;
    }
    public void setInput(Double input) {
        this.input = input;
    }
    public Double getOutput() {
        return output;
    }
    public void setOutput(Double output) {
        this.output = output;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public String getDateOffer() {
        return DateOffer;
    }
    public void setDateOffer(String dateOffer) {
        DateOffer = dateOffer;
    }
    public String getNameOfOffer() {
        return nameOfOffer;
    }
    public void setNameOfOffer(String nameOfOffer) {
        this.nameOfOffer = nameOfOffer;
    }
    public String getNumberOfOffer() {
        return numberOfOffer;
    }
    public void setNumberOfOffer(String numberOfOffer) {
        this.numberOfOffer = numberOfOffer;
    }
    public offer(String numberOfOffer){
        this.numberOfOffer = numberOfOffer;
    }
    public offer(String description, Double input, boolean flag){
        this.input = input;
        this.description = description;
    }
    public offer(String description, Double output){
        this.output = output;
        this.description = description;
    }
    public String toString(){
        return "\nтип счёта: "+ nameOfOffer +"\nномер операции: " + numberOfOffer +"\nвалюта: " + currency +"\nдата операции: " + DateOffer
                +"\nреференс проводки: " + ref +"\nописание операции: " + description +"\nприход: " + input +"\nрасход: " + output;
    }
}
