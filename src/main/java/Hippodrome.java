import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.isNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hippodrome {

    private static final Logger logger = LogManager.getLogger(Hippodrome.class);

    private final List<Horse> horses;

    public Hippodrome(List<Horse> horses) {

        logger.debug("Inicializando Hippodrome con {} caballos.",
                horses != null ? horses.size() : null);

        if (isNull(horses)) {
            logger.error("Los caballos no pueden ser nulos");
            throw new IllegalArgumentException("Horses cannot be null.");
        } else if (horses.isEmpty()) {
            logger.error("Los caballos no pueden estar vacíos.");
            throw new IllegalArgumentException("Horses cannot be empty.");
        }

        this.horses = horses;
        logger.info("Hippodrome inicializado con {} caballos.", horses.size());
    }

    public List<Horse> getHorses() {
        return Collections.unmodifiableList(horses);
    }

    public void move() {
        logger.debug("Iniciando movimiento de todos los caballos...");
        horses.forEach(Horse::move);
        logger.debug("Movimiento completado para todos los caballos.");
    }

    public Horse getWinner() {
        Horse winner = horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();

        logger.info("El caballo ganador es '{}' con una distancia de {:.2f} metros.",
                winner.getName(), winner.getDistance());

        return winner;
    }
}
