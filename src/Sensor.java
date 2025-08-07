import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private String id;
    private List<Double> leituras;

    public Sensor(String id) {
        this.id = id;
        this.leituras = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Double> getLeituras() {
        return leituras;
    }

    public void registrarLeituras(List<Double> novasLeituras) throws LeituraInvalidaException {
        if (novasLeituras.size() != 100) {
            throw new IllegalArgumentException("O número de leituras deve ser exatamente 100.");
        }

        for (int i = 0; i < novasLeituras.size(); i++) {
            double temp = novasLeituras.get(i);
            if (temp < -60 || temp > 60) {
                throw new LeituraInvalidaException(i, temp);
            }
        }

        this.leituras = novasLeituras;
    }

    @Override
    public String toString() {
        return "Sensor{" + "id='" + id + '\'' + ", leituras=" + leituras + '}';
    }
}