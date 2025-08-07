import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {

    private List<Sensor> sensoresValidos;
    private List<ErroSensor> sensorComErro;

    public SistemaMonitoramento() {
        this.sensoresValidos = new ArrayList<>();
        this.sensorComErro = new ArrayList<>();
    }

    public void processarSensores(List<Sensor> listaSensor, List<List<Double>> listaLeitura) {
        for (int i = 0; i < listaSensor.size(); i++) {
            Sensor sensor = listaSensor.get(i);
            List<Double> leituras = listaLeitura.get(i);

            try {
                sensor.registrarLeituras(leituras);
                sensoresValidos.add(sensor);
            } catch (LeituraInvalidaException | IllegalArgumentException e) {
                sensorComErro.add(new ErroSensor(sensor.getId(), e.getMessage()));
            }
        }
    }

    public void exibirRelatorio (){
        System.out.println("===== Sensores Válidos =====");
        for (Sensor sensor : sensoresValidos) {
            System.out.println("Sensor " + sensor.getId());
        }

        System.out.println("===== Sensores Com Erro =====");
        for (ErroSensor erroSensor : sensorComErro) {
            System.out.println("Sensor " + erroSensor.getIdSensor() + " --> " + erroSensor.getMensagemErro());
        }

    }

}


