//Föräldrar klass till de olika bilsorterna
public abstract class Vehicle implements Rentable {
    private String model;
    private int price;
    private String regPlate;


    //Den urspungliga konstruktor alla fordron kommer ärva
    public Vehicle(String model, int price, String regPlate) {
        this.model = model;
        this.price = price;
        this.regPlate = regPlate;

    }

    //Metoderna de olika bilarna ska använda sig av
    public String getModel() {
        return model;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public int getPrice() {
        return price;
    }





}
