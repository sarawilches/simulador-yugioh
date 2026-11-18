package edu.uao.yugioh;
import edu.uao.yugioh.controller.BatallaController;
import edu.uao.yugioh.model.*;
import edu.uao.yugioh.persistence.HistorialRepository;
import edu.uao.yugioh.view.BatallaView;
import javax.swing.SwingUtilities;
public class Main { public static void main(String[] args) { SwingUtilities.invokeLater(() -> { Jugador j1=new Jugador("Jugador 1"), j2=new Jugador("Jugador 2"); BatallaView v=new BatallaView(); new BatallaController(v,j1,j2,new HistorialRepository("historial_combate.txt")).iniciar(); }); } }