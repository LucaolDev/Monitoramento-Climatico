public class ErroSensor {

    private String idSensor;
    private String mensagemErro;

    public ErroSensor(String idSensor, String mensagemErro) {
        this.idSensor = idSensor;
        this.mensagemErro = mensagemErro;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
}
