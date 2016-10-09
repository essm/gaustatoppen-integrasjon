package no.gaustatoppen.integrasjon.avtale;

public class Kvittering {

    private final String avtaleNummer;
    private final String avtaleStatus;

    public Kvittering(String avtaleNummer, String avtaleStatus) {
        this.avtaleNummer = avtaleNummer;
        this.avtaleStatus = avtaleStatus;
    }

    public String getAvtaleNummer() {
        return avtaleNummer;
    }

    public String getAvtaleStatus() {
        return avtaleStatus;
    }
}
