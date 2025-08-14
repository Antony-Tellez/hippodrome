import static java.util.Objects.isNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Horse {

    private static final Logger logger = LogManager.getLogger(Horse.class);

    private final String name;
    private final double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        logger.debug("Creando caballo con nombre='{}', velocidad={}, distancia={}", name, speed, distance);
        if (isNull(name)) {
            logger.error("Nombre nulo detectado.");
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (name.isBlank()) {
            logger.error("Nombre en blanco detectado.");
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (speed < 0) {
            logger.error("Velocidad negativa detectada: {}", speed);
            throw new IllegalArgumentException("Speed cannot be negative.");
        }
        if (distance < 0) {
            logger.error("Distancia negativa detectada: {}", distance);
            throw new IllegalArgumentException("Distance cannot be negative.");
        }

        this.name = name;
        this.speed = speed;
        this.distance = distance;

        logger.info("Caballo '{}' creado correctamente.", name);
    }

    public Horse(String name, double speed) {
        this(name, speed, 0);
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void move() {
        double randomFactor = getRandomDouble(0.2, 0.9);
        double distanceTraveled = speed * randomFactor;
        distance += speed * getRandomDouble(0.2, 0.9);

        logger.info("El caballo '{}' se movió {:.2f} metros (factor aleatorio: {:.2f}). Distancia total: {:.2f}",
                name, distanceTraveled, randomFactor, distance);
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }
}
