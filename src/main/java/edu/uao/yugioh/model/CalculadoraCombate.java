package edu.uao.yugioh.model;

public class CalculadoraCombate {
    public ResultadoCombate atacar(Monstruo atacante, Monstruo defensor, Jugador jugadorDefensor) {
        return atacar(atacante, defensor, null, jugadorDefensor);
    }
    public ResultadoCombate atacar(Monstruo atacante, Monstruo defensor, Jugador jugadorAtacante, Jugador jugadorDefensor) {
        if (atacante == null || jugadorDefensor == null) throw new IllegalArgumentException("Atacante y jugador defensor son obligatorios");
        if (defensor == null) {
            int dano = atacante.getAtaque(); jugadorDefensor.recibirDano(dano);
            return new ResultadoCombate(atacante.getNombre(), "Ataque directo", dano, "Ataque directo");
        }
        int diferencia; String resultado; int danoLP = 0;
        if (defensor.getPosicion() == Posicion.ATAQUE) {
            diferencia = atacante.getAtaque() - defensor.getAtaque();
            if (diferencia > 0) resultado = "Defensor destruido";
            else if (diferencia < 0) { resultado = "Atacante destruido"; danoLP = Math.abs(diferencia); if (jugadorAtacante != null) jugadorAtacante.recibirDano(danoLP); }
            else resultado = "Empate: ambos destruidos";
        } else {
            diferencia = atacante.getAtaque() - defensor.getDefensa();
            resultado = diferencia > 0 ? "Defensor destruido" : (diferencia < 0 ? "Sin destrucción: daño absorbido" : "Sin destrucción");
        }
        return new ResultadoCombate(atacante.getNombre(), defensor.getNombre(), danoLP, resultado);
    }
}
