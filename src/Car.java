//Klass som ärver egenskaperna från Vehicle och implementerar metoderna från Rentable
public class Car extends Vehicle {
    private int horsePower;
    private boolean isRented;

    //Den urspungliga konstruktor alla fordron kommer ärva
    public Car(String model, int price, String regPlate,int horsePower) {

        //Super referar till abstrakta klassens egenskaper
        super(model, price, regPlate);

        this.horsePower = horsePower;

        //Tilldelar värdet false till isRented
        this.isRented = false;
    }



    //Metod för att retunera Car,implementerad från interface
    @Override
    public String rentOut() {

        //Ifall isRented är false kommer output skrivas ut
        if (isRented) {
            return "Fordonet är redan uthyrd";
        }

        //Ifall isRented är sann kommer följande uppmaning skrivas ut
        this.isRented = true;
        return "Grattis du har hyrt bilen";

    }

    //Metod för att retunera Car,implementerad från interface
    @Override

    //Om isRented är sann kommer följande uppmaning skrivas ut
    public String returnRent() {
        if (!isRented) {
            return "Bilen är inte uthyrd";
        }

        //Ifall bilen inte är uthyrd(vilket innebär retunerad) kommer följande uppmaning skrivas ut
        this.isRented = false;

        return "Bilen är nu returnerad!";
    }

    //Metod för att räkna ut kostnaden för att hyra Trucken,implementerad från interface
    @Override
    public double calculateBill(int days) {

        //Retunerar produkten av antal dagar samt pris
        return days * getPrice();
    }

    @Override
    public boolean isAvailable() {
        return this.isRented;
    }


    // Getter-metod
    public int getHorsePower() {
        return horsePower;
    }
}





