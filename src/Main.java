import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Instansierar en ny Scanner
        Scanner sc = new Scanner(System.in);

        //Instansierar en Arraylista som håller de olika bilarna
        ArrayList<Vehicle> vehicles = new ArrayList<>();


        //Lägger till de olika bilarna i array samt skriver ut värdet för konstruktorn
        vehicles.add(new Car("Car", 700, "ABC123", 200));
        vehicles.add(new Suv("Suv", 500, "ASR334", 12000));
        vehicles.add(new Truck("Truck", 600, "URT963", 4));


        while (true) {

            //Meny för biluthyrningen
            System.out.println("\n=== Fordonsuthyrning ===");
            System.out.println("1. Hyr ett fordon");
            System.out.println("2. Returnera ett fordon");
            System.out.println("3. Beräkna kostnad");
            System.out.println("4. Avsluta");
            System.out.print("Välj ett alternativ: ");
            int Choice = 0;

            try {
               Choice = sc.nextInt(); // Försöker läsa ett heltal
            } catch (java.util.InputMismatchException e) {
                System.out.println("Fel: Ange endast siffror!");
                sc.nextLine(); // Rensar felaktig inmatning
                continue; // Hoppa till nästa iteration av loopen
            }

            switch (Choice) {

               //utfall av val 1
                case 1:
                    System.out.println("\nTillgängliga fordon:");
                    // Visa alla fordon i listan
                    for (int i = 0; i < vehicles.size(); i++) {
                        Vehicle vehicle = vehicles.get(i);

                        if (vehicle instanceof Car) { // Kontrollera om objektet är av typen Car
                            Car car = (Car) vehicle; // Gör en typomvandling till Car {

                            //Skriver ut följande om Car
                            System.out.println((i + 1) + ". " + vehicle.getModel() + " (" + vehicle.getRegPlate() + "), Pris: " +
                                    vehicle.getPrice() + " SEK per dag, Hästkrafter " + car.getHorsePower() +
                                    ", Status:" + (vehicle.isAvailable() ? "Uthyrd" : "Tillgänglig"));
                        }

                        else if (vehicle instanceof Suv) {
                            Suv suv = (Suv) vehicle;

                            //Skriver ut följande om Suv
                            System.out.println((i + 1) + ". " + vehicle.getModel() + " (" + vehicle.getRegPlate() + "), Pris: " +
                                    vehicle.getPrice() + " SEK per dag, Antal körda mil " + suv.getMilesRun() +
                                    ", Status:" + (vehicle.isAvailable() ? "Uthyrd" : "Tillgänglig"));


                        }

                        else if (vehicle instanceof Truck) {
                            Truck truck = (Truck) vehicle;

                           //Skriver ut följande om Truck
                            System.out.println((i + 1) + ". " + vehicle.getModel() + " (" + vehicle.getRegPlate() + "), Pris: " +
                                    vehicle.getPrice() + " SEK per dag, Antal dörrar " + truck.getNumberOfDoors() +
                                    ", Status:" + (vehicle.isAvailable() ? "Uthyrd" : " Tillgänglig"));
                        }
                    }

                    // Fråga användaren vilket fordon som ska hyras
                    System.out.println("\nVilket fordon vill du hyra? Ange nummer:");
                    int carNumber = 0;

                    try {
                        carNumber = sc.nextInt() - 1; // Minus 1 för att justera till arrayindex
                    }
                    catch (java.util.InputMismatchException e) {
                        System.out.println("Fel: Ange endast siffror!");
                        sc.nextLine(); // Rensar felaktig inmatning
                        continue; // Hoppa till nästa iteration av loopen
                    }

                    //Ifall inputen är korrekt kommer följande uppmaning skrivas ut
                    if (carNumber >= 0 && carNumber < vehicles.size()) {

                        //Hämtar index från arraylist så korrekt bil blir uthyrd
                        Vehicle selectedVehicle = vehicles.get(carNumber);

                        System.out.println("Hur många dagar vill du hyra? Ange dagar:");
                        int days = 0;

                        try {
                            days = sc.nextInt(); // Försöker läsa ett heltal
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Fel: Ange endast siffror!");
                            sc.nextLine(); // Rensar felaktig inmatning
                            continue; // Hoppa till nästa iteration av loopen
                        }

                        System.out.println("din kostad för att hyra bilen i " + days + " dagar kostar " + selectedVehicle.calculateBill(days) + " kr");


                        // Försök att hyra fordonet
                        String rentResult = selectedVehicle.rentOut();
                        System.out.println(rentResult);

                      //Ifall input inte är korrekt kommer följande skrivas ut
                    } else {
                        System.out.println("Ogiltigt val! Försök igen.");
                    }
                    break;


                    case 2:
                    System.out.println("\nVilket fordon vill du returnera? (ange nummer):");

                    int returnChoice = 0;

                        try {
                             returnChoice = sc.nextInt() - 1;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Fel: Ange endast siffror!");
                            sc.nextLine(); // Rensar felaktig inmatning
                            continue; // Hoppa till nästa iteration av loopen
                        }

                    if (returnChoice >= 0 && returnChoice < vehicles.size()) {
                        Vehicle vehicle = vehicles.get(returnChoice);
                        System.out.println(vehicle.returnRent());

                    } else {
                        System.out.println("Ogiltigt val!");
                    }
                    break;


                    case 3:
                        System.out.println("För vilket fordon vill du beräkna kostnaden?");
                        for (int i = 0; i < vehicles.size(); i++) {
                            Vehicle vehicle = vehicles.get(i);
                            System.out.println((i + 1) + ". " + vehicle.getModel() + " (" + vehicle.getRegPlate() + ")");
                        }
                        int costChoice = 0;//Deklarerar costChoice till 0

                        try {
                            costChoice = sc.nextInt() - 1; // Minus 1 för att justera till arrayindex
                        }
                        catch (java.util.InputMismatchException e) {
                            System.out.println("Fel: Ange endast siffror!");
                            sc.nextLine(); // Rensar felaktig inmatning
                            continue; // Hoppa till nästa iteration av loopen
                        }


                        if (costChoice >= 0 && costChoice < vehicles.size()) {
                            System.out.print("Ange antal hyresdagar: ");
                            int days;

                            //Hanterar felinmatning
                            try {
                                days = sc.nextInt();
                                if (days > 0) {
                                    double totalCost = vehicles.get(costChoice).calculateBill(days);
                                    System.out.println("Total kostnad för " + days + " dagar: " + totalCost + " SEK");
                                } else {
                                    System.out.println("Fel: Antal dagar måste vara större än 0!");
                                }
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Fel: Ange endast siffror för dagar!");
                                sc.nextLine(); // Rensa felaktig inmatning
                            }
                        } else {
                            System.out.println("Ogiltigt val!");
                        }
                        break;

                        case 4:
                    System.out.println("Avslutar programmet. Tack!");
                    sc.close();
                    return;
            }



        }
    }
    }

