package com.yllies.morpion;

import org.springframework.stereotype.Service;

@Service
public class MorpionService {

    public String play(Session s, Integer id, Integer x, Integer y) {
        if (id == null) {
            return "Il manque l'identifiant du joueur";
        }
        if (x == null || y == null) {
            return "Il manque la position";
        }

        if (x < 1 || y < 1 || x > 3 || y > 3) {
            return String.format("La position (%d, %d) n'existe pas dans le plateau<br><br>", x, y);
        }


        if (s.getBoard() == null) {
            if (id == 2) {
                return "C'est au joueur 1 de commencer la partie";
            }

            s.init();
        }

        if (id != 1 && id != 2) {
            return "Veuillez entrer un identifiant de joueur valide : 1 ou 2" + s;
        }


        if (!id.equals(s.getExpectedUser())) {
            return "Ce n'est pas à votre tour de jouer<br><br>" + s;
        }


        if (!"...".equals(s.getBoard()[x - 1][y - 1])) {
            return String.format("La position (%d, %d) a déjà été utilisée<br><br>", x, y) + s;
        }

        if (id == 1) {
            s.getBoard()[x - 1][y - 1] = "X";
            s.setExpectedUser(2);
            return String.format("Vous avez placé un X à (%d, %d) <br><br>", x, y) + s;
        } else {
            s.getBoard()[x - 1][y - 1] = "O";
            s.setExpectedUser(1);
            return String.format("Vous avez placé un O à (%d, %d) <br><br>", x, y) + s;
        }
    }


    public String showGrid(Session s) {
        return s.toString();
    }

}


