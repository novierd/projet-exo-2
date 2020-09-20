import java.util.Scanner;
import java.util.regex.Pattern;

class Calculatrice {

    public static void main(final String[] args) {

    }

    // Initialisation
    Scanner sc = new Scanner(System.in);
    String donnee;
    String[] tableaudonnee;
    int nbr1, nbr2, resultat;
    String messagedefin = " Au Revoir";
    String messageaccueil = "----Calculatrice----";
    String[] messErreur = { " => Ton opération n'est pas logique !",
            " => Utilise les espaces sinon je ne peux pas faire le calcul ",
            " => Navré mais je ne peux faire que des opérations à deux entiers ...",
            " => \nVeux-tu effectuer une nouvelle opération ?", };

    // calculate method
    public void calculer() {

        // MAIN CODE
        while (true) {
            // Presentation
            System.out.println("");
            System.out.println(messageaccueil);

            // Operation
            try {
                System.out.print("Tape ton opération: ");
                donnee = sc.nextLine();

                if (Pattern.matches("([0-9]+)(\\s{1})([*+/-]{1})(\\s{1})([0-9]+)", donnee)) {
                    tableaudonnee = donnee.split("\\s");
                    nbr1 = Integer.parseInt(tableaudonnee[0]);
                    final String choix = tableaudonnee[1];
                    nbr2 = Integer.parseInt(tableaudonnee[2]);

                    switch (choix) {
                        case "+":
                            resultat = nbr1 + nbr2;
                            break;
                        case "-":
                            resultat = nbr1 - nbr2;
                            break;
                        case "*":
                            resultat = nbr1 * nbr2;
                            break;
                        case "/":
                            resultat = nbr1 / nbr2;
                            break;
                        default:
                            System.out.print("Calcul impossible");
                    }

                  
                    System.out.print(donnee + "=> Le résultat est " + resultat);
                } else if (Pattern.matches("(.*)([a-zA-Z])(.*)", donnee)) {
                  
                    System.out.print(donnee + messErreur[0]);
                } else if (Pattern.matches(
                        "([0-9]+)([*+/-]{1})([0-9]+)|([0-9]+)(\\s?)([*+/-]{1})([0-9]+)|([0-9]+)([*+/-]{1})(\\s?)([0-9]+)",
                        donnee)) {
                    
                    System.out.print(donnee + messErreur[1]);
                } else if (Pattern.matches(
                        "([0-9]+)(\\s?)([*+/-]{1})(\\s?)([0-9]+)(((\\s?)([*+/-]{1})(\\s?)([0-9]+)){1,})", donnee)) {

                    System.out.print(donnee + messErreur[2]);
                } else {
                   
                    System.out.print(donnee + messErreur[3]);
                }

            } catch (final Exception exception) {
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
            }
        }

    }
}

