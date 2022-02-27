package com.step;

import com.step.abstractClassesAndInterfaces.Product;
import com.step.storeProducts.*;

import java.util.Scanner;

public class Main {
    private static Menu show      = new Menu();
    private static Scanner sc     = new Scanner(System.in);
    private static TotalPrice get = new TotalPrice();

    public static void main(String[] args) {

        Product milk250ml  = new Milk("lapte pasteurizat","GLC",6.00, "1.5",250);
        Product milk500ml  = new Milk("lapte organic"    ,"GLC",11.35,"2.5",500);
        Product milk1000ml = new Milk("lapte concentrat" ,"GLC",20.80,"3.5",1000);

        Product breadWhite = new Bread( "Piine Feliata","Franzeluta",6.50," Alba" );
        Product breadBrown = new Bread( "Piine Feliata","Brodetski" ,7.20," Bruna" );
        Product breadBlack = new Bread( "Piine Feliata","Franzeluta",6.00," Neagra" );

        ProductKeeper productKeeper = new ProductKeeper();
        productKeeper.addProduct( milk250ml, milk500ml,milk1000ml, breadWhite, breadBrown, breadBlack );

        boolean oneMoreTime;
        boolean innerOneMoreTime;
        do {
            show.menu();
            oneMoreTime = false;
            try {
                int input = sc.nextInt(); sc.nextLine();
                switch (input) {
                    case 1:
                        do {
                            show.menuProduct();
                            innerOneMoreTime = false;
                            try {
                                int input2 = sc.nextInt();  sc.nextLine();
                                switch (input2) {
                                    case 1:
                                        System.out.println( milk250ml );
                                        System.out.print("\n\tEnter to go to Product Menu: ");
                                        sc.nextLine();
                                        innerOneMoreTime = true;
                                        break;
                                    case 2:
                                        System.out.println( milk500ml );
                                        System.out.print("\n\tEnter to go to Product Menu: ");
                                        sc.nextLine();
                                        innerOneMoreTime = true;
                                        break;
                                    case 3:
                                        System.out.println( milk1000ml );
                                        System.out.print("\n\tEnter to go to Product Menu: ");
                                        sc.nextLine();
                                        innerOneMoreTime = true;
                                        break;
                                    case 4:
                                        System.out.println( breadWhite );
                                        System.out.print("\n\tEnter to go to Product Menu: ");
                                        sc.nextLine();
                                        innerOneMoreTime = true;
                                        break;
                                    case 5:
                                        System.out.println( breadBrown );
                                        System.out.print("\n\tEnter to go to Product Menu: ");
                                        sc.nextLine();
                                        innerOneMoreTime = true;
                                        break;
                                    case 6:
                                        System.out.println( breadBlack );
                                        System.out.print("\n\tEnter to go to Product Menu: ");
                                        sc.nextLine();
                                        innerOneMoreTime = true;
                                        break;
                                    case 7:
                                        oneMoreTime = true;
                                        break;
                                    default:
                                        System.out.println();
                                        System.out.print ("\t\tAvailable input (one to seven)!, Enter to continue:");
                                        innerOneMoreTime = true;
                                        sc.nextLine();
                                }
                            } catch (Exception e) {
                                System.out.print("\n\t *****Please enter an available input !!");
                                System.out.println("\t(Available inputs (one to seven)!, Enter to continue ***** ");
                                sc.nextLine();
                                innerOneMoreTime = true;
                            }
                        } while (innerOneMoreTime);

                        break;
                    case 2:
                        System.out.println(
                            "\n\tTotal items price is: "+
                            get.totalPrice( milk250ml, milk500ml , milk1000ml ,
                                            breadBlack , breadBrown , breadWhite  ) +
                            " lei"

                        );
                        break;
                    case 3:

                        break;
                    default:
                        System.out.print("\t\tAvailable input (one to three)!, Enter to continue:");
                        sc.nextLine();
                        oneMoreTime = true;
                }

            } catch (Exception ex) {
                System.out.print("\n\t/// *****Please enter an available input !!");
                System.out.println("\t(Available inputs are from one to three) *****///");
                sc.nextLine();
                oneMoreTime = true;
            }
        } while (oneMoreTime);

//        Sarcina practica pentru lectia de astazi.
//        ProductStore
//        Aplicatia care gestioneaza informatie despre Produse. Campurile
//        produsului sunt:
//        - denumirea produsului
//            - pretul (zecimal)
//            - producatorul(String)).
//
//
//
//        La lansarea aplicatiei, trebuie sa se initializeze 5 produse i
//        memorie (automat, nu e nevoie de introducere de la tastatura).
//            La ecran sa se afiseze un meniu principal cu 3 optiuni.
//        1 Product info
//        2 Total price
//        3 Exit
//        De la tastatura, utilizatorul trebuie sa aleaga o optiune.
//
//
//
//        1. Product info: Vizualizarea informatiei despre un produs.
//        Utilizatorul apasa 1 apoi de la tastatura introduce numarul produsului
//        care trebuie vizualizat. (1-5).
//            Daca introduce pozitie gresita este rugat sa introduca din nou.
//            Dupa vizualizarea informatiei despre produs, se afiseaza meniul
//            principal.
//        2. Total price - Vizualizarea pretului total pentru toate produsele
//        disponibile.
//        3. Exit - Iesire daca introduce.
//        La introducerea unei optiuni gresite in meniul principal, sa i se
//        afiseze un mesaj la ecran "Ati introdus o optiune incorecta. Incercati
//        din nou."
//
//
    }
}
